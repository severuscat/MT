from LAB_04_final.src import grammar as m_grammar

import os
import sys


class ParserGenerator:
    def __init__(self, grammar):
        self.grammar = grammar
        pathDir = os.path.join(
            "gen",
            grammar.grammar_name.lower()
        )
        if (not os.path.exists(pathDir)):
            os.makedirs(pathDir)
        fileName = grammar.grammar_name + "Parser.py"

        with open(os.path.join(pathDir, fileName), 'w') as f:
            f.write(self.fileText())

    def fileText(self):
        sb = ''
        # # header
        # sb += self.printString("package " + self.grammar.grammar_name.lower() + ";\n" +
        #                        "\n" +
        #                        "import java.util.ArrayList;\n" +
        #                        "import java.util.List;", 0)

        for imp in self.grammar.imports:
            sb += self.printString("import " + imp, 0)

        sb += "\n"
        # class
        sb += self.printString("" +
                               "class " + self.grammar.grammar_name + "Parser:\n" +
                               "\tpublic Node tree;\n" +
                               "\tpublic static class Node {\n" +
                               "\t\tprivate String name;\n" +
                               "\t\tprivate List<Node> children = new ArrayList<>();\n" +
                               "\n" +
                               "\t\tNode(String s) {\n" +
                               "\t\t\tname = s;\n" +
                               "\t\t}\n" +
                               "\n" +
                               "\t\tpublic void addChild(Node node) {\n" +
                               "\t\t\tchildren.add(node);\n" +
                               "\t\t}\n" +
                               "\n" +
                               "\t\tpublic String name {\n" +
                               "\t\t\treturn name;\n" +
                               "\t\t}\n" +
                               "\n" +
                               "\t\tStringBuilder treeToString(ArrayList<Boolean> mask) {\n" +
                               "\t\t\tStringBuilder sb = new StringBuilder();\n" +
                               "\t\t\tif (!mask.isEmpty()) {\n" +
                               "\t\t\t\tsb.append(\"|__\");\n" +
                               "\t\t\t}\n" +
                               "\t\t\tsb.append(\"'\").append(name).append(\"'\").append(\"\\n\");\n" +
                               "\t\t\tfor (int curChild = 0; curChild < children.size(); ++curChild) {\n" +
                               "\t\t\t\tfor (boolean b : mask) {\n" +
                               "\t\t\t\t\tif (b) {\n" +
                               "\t\t\t\t\t\tsb.append(\"|  \");\n" +
                               "\t\t\t\t\t} else {\n" +
                               "\t\t\t\t\t\tsb.append(\"   \");\n" +
                               "\t\t\t\t\t}\n" +
                               "\t\t\t\t}\n" +
                               "\t\t\t\tmask.add(curChild != children.size() - 1);\n" +
                               "\t\t\t\tsb.append(children.get(curChild).treeToString(mask));\n" +
                               "\t\t\t\tmask.remove(mask.size() - 1);\n" +
                               "\t\t\t}\n" +
                               "\t\t\treturn sb;\n" +
                               "\t\t}\n" +
                               "\t}", 0)

        sb += "\n"

        for state in self.grammar.states.values():
            sb += self.printStateNode(state)
            sb += "\n"

        sb += self.printString("private " + self.grammar.grammar_name + "LexicalAnalyzer lexicalAnalyzer;", 1)

        sb += "\n"

        # constructor
        sb += self.printString(
            "\tpublic " + self.grammar.grammar_name + "Parser(" + self.grammar.grammar_name + "LexicalAnalyzer lexicalAnalyzer) throws Exception {\n" +
            "\t\tthis.lexicalAnalyzer = lexicalAnalyzer;\n" +
            "\t\tbuildTree();\n" +
            "\t}", 0)

        sb += "\n"

        sb += self.printString("" +
                               "\tprivate void buildTree() throws Exception {\n" +
                               "\t\ttree = _" + self.grammar.start_state + "();\n" +
                               "\t\tif (lexicalAnalyzer.getCurrentToken() != " + self.grammar.grammar_name + "Token._END) {\n" +
                               "\t\t\tthrow new Exception(\"Cur token is \" + lexicalAnalyzer.getCurrentToken().toString() + \" but expected END.\");\n" +
                               "\t\t}\n" +
                               "\t}", 0)

        sb += "\n"

        sb += self.printString("" +
                               "\tpublic void printTree() {\n" +
                               "\t\tSystem.out.println(tree.treeToString(new ArrayList<>()));\n" +
                               "\t}", 0)

        sb += "\n"

        for returnStr in self.grammar.states[self.grammar.start_state].returns:
            arg = returnStr.split(" ")
            sb += self.printString("public " + " get" + arg[0] + "() {", 1)
            sb += self.printString("return ((Node_E)tree)." + arg[0] + ";", 2)
            sb += self.printString("}", 1)

        sb += "\n"

        # consume
        sb += self.printString("" +
                               "\tprivate void consume(" + self.grammar.grammar_name + "Token token) throws Exception{\n" +
                               "\t\tif (lexicalAnalyzer.getCurrentToken() != token) {\n" +
                               "\t\t\tthrow new Exception(\"Expected another token.\");\n" +
                               "\t\t}\n" +
                               "\t}", 0)

        sb += "\n"

        # states
        for s in self.grammar.states.values():
            sb += self.printState(s)
            sb += "\n"

        sb += self.printString("}", 0)

        return sb

    def printStateNode(self, s):
        sb = ''
        sb += self.printString("public class Node_" + s.name + " extends Node {", 1)
        sb += self.printString("Node_" + s.name + "() {", 2)
        sb += self.printString("super(\"" + s.name + "\");", 3)
        sb += self.printString("}", 2)
        for str in s.returns:
            sb += self.printString("public " + str + ";", 2)
        sb += self.printString("}", 1)
        return sb

    def printState(self, s):
        sb = ''

        sb += self.printString("private Node_" + s.name + " _" + s.name + "(" + self.printParameters(
            s.parametrs) + ") throws Exception {", 1)
        sb += self.printString("Node_" + s.name + " res = new Node_" + s.name + "();", 2)
        sb += self.printString("switch (lexicalAnalyzer.getCurrentToken()) {", 2)

        for rule in s.rules:
            sb += self.printRule(rule, s)

        sb += self.printString("default : ", 3)
        sb += self.printString("throw new Exception(\"Unexpected token.\");", 4)

        sb += self.printString("}", 2)
        sb += self.printString("}", 1)
        return sb

    def printParameters(self, parameters):
        sb = ''
        for i in range(len(parameters)):
            if (i != 0):
                sb += ", "
            sb += parameters[i]
        return sb

    def printFollowCase(self, s, action):
        sb = ''
        for item in s.follow:
            sb += self.printString("case " + item + " :", 3)
        if (len(sb) == 0):
            return sb
        sb += self.printString("{", 3)
        sb += self.printString(action, 4)
        sb += self.printString("return res;", 4)
        sb += self.printString("}", 3)
        return sb

    def printRule(self, rule, s):
        sb = ''
        first = self.grammar.first_for_rule(rule)
        containsEps = False
        for token in first:
            if not (token == "EPS"):
                sb += self.printString("case " + token + " :", 3)
            else:
                containsEps = True
                sb += self.printFollowCase(s, rule.actions[0])
        if len(sb) == 0 or containsEps:
            return sb

        sb += self.printString("{", 3)

        index = 0
        # sys.stdout.write(str(rule.parameters) + str(rule.actions) + str(rule.items) + '\n')
        for i in range(len(rule.items)):
            item = rule.items[i]
            if item in self.grammar.token_items:
                sb += self.printString(
                    "consume(" + self.grammar.grammar_name + "Token." + item + ");", 4)
                sb += self.printString("res.addChild(new Node(\"" + item + "\"));", 4)
                sb += self.printString(rule.actions[i], 4)
                sb += self.printString("lexicalAnalyzer.getNextToken();", 4)
            elif item in self.grammar.states:
                sb += self.printString(
                    "Node_" + item + " n" +
                    str(index) + " = _" + item +
                    "(" + rule.parametrs[i] + ");", 4
                )
                sb += self.printString("res.addChild(n" + str(index) + ");", 4)
                sb += self.printString(rule.actions[i], 4)
                index += 1
            else:
                sys.stderr.write("Not in token & states. " + item)
                exit(-1)
        sb += self.printString("return res;", 4)
        sb += self.printString("}", 3)
        return sb

    def printString(self, text, tabs):
        s = ''
        for i in range(tabs):
            s += "\t"
        s += text
        s += "\n"
        return s
