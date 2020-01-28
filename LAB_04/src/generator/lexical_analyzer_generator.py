from LAB_04.src.generator import grammar as m_grammar

import os


class LexicalAnalyzerGenerator:
    grammar = m_grammar.Grammar()

    def __init__(self, grammar):
        self.grammar = grammar
        pathDir = os.path.join(
            "home",
            "severuscat",
            "STUD",
            "MT",
            "LAB_04"
        )
        pathDir = pathDir.resolve("gen").resolve(grammar.grammarName.toLowerCase())
        os.makedirs(pathDir)
        fileName = grammar.grammarName + "LexicalAnalyzer.java"  # TODO: CHANGE IT!!
        enumFileName = grammar.grammarName + "Token.java"
        with open(os.path.join(pathDir, enumFileName)) as f:
            f.write(self.tokenClassText())

        with open(os.path.join(pathDir, fileName)) as f:
            f.write(self.fileText())

    def tokenClassText(self):
        sb = ''
        sb += self.printString("package " + self.grammar.grammarName.toLowerCase() + ";", 0)
        # tokens
        sb += self.printString("\npublic enum " + self.grammar.grammarName + "Token {", 0)
        for s in self.grammar.tokenItems.keySet():
            sb += self.printString(s + ",", 1)

        sb += self.printString("_END\n}\n", 1)
        return sb

    def fileText(self):
        sb = ''
        # header
        sb += self.printString("package " + self.grammar.grammarName.toLowerCase() + ";\n" +
                               "import java.util.ArrayList;\n" +
                               "import java.util.List;\n" +
                               "import java.util.regex.Matcher;\n" +
                               "import java.util.regex.Pattern;", 0)
        # class
        sb += "\n"
        sb += self.printString("public class " + self.grammar.grammarName + "LexicalAnalyzer {", 0)

        # fields
        sb += self.printString("\tprivate StringBuilder inputSB;\n" +
                               "\tprivate List<TokenItem> tokenPatterns = new ArrayList<>();\n" +
                               "\tprivate List<TokenItem> skipTokenPatterns = new ArrayList<>();\n" +
                               "\tprivate List<" + self.grammar.grammarName + "Token> tokens = new ArrayList<>();\n" +
                               "\tprivate List<String> tokensToString = new ArrayList<>();\n" +
                               "\tprivate int currentPosition = 0;\n", 0)

        # constructor
        sb += self.printString(
            "\tpublic " + self.grammar.grammarName + "LexicalAnalyzer(String input) throws Exception {\n" +
            "\t\tinputSB = new StringBuilder(input);", 0)

        sb += "\n"

        for item in self.grammar.tokens:
            sb += self.printString(
                "tokenPatterns.add(new TokenItem(" + self.grammar.grammarName + "Token." + item.name + "," + item.pattern + "));",
                2)

        sb += "\n"

        for item in self.grammar.skipTokens:
            sb += self.printString(
                "skipTokenPatterns.add(new TokenItem(" + self.grammar.grammarName + "Token." + item.name + "," + item.pattern + "));",
                2)

        sb += self.printString("getTokens();", 2)
        sb += self.printString("}", 1)

        sb += "\n"
        # methods
        sb += self.printString("" +
                               "\tpublic " + self.grammar.grammarName + "Token getCurrentToken() {\n" +
                               "\t\treturn tokens.get(currentPosition);\n" +
                               " \t}\n" +
                               "\n" +
                               "\tpublic String getCurrentTokenString() {\n" +
                               "\t\treturn tokensToString.get(currentPosition);\n" +
                               "\t}\n" +
                               "\n" +
                               "\tpublic " + self.grammar.grammarName + "Token getNextToken() {\n" +
                               "\t\treturn tokens.get(++currentPosition);\n" +
                               "\t}\n" +
                               "\n" +
                               "\tprivate void getTokens() throws Exception {\n" +
                               "\t\twhile (!(inputSB.length() == 0)) {\n" +
                               "\t\t\t" + self.grammar.grammarName + "Token t = findFirstToken();\n" +
                               "\t\t\tif (t != null) {\n" +
                               "\t\t\t\ttokens.add(t);\n" +
                               "\t\t\t} else if (!findFirstSkipToken()) {\n" +
                               "\t\t\t\tthrow new Exception(\"Not find matching with tokens.\");\n" +
                               "\t\t\t}\n" +
                               "\t\t}\n" +
                               "\t\ttokens.add(" + self.grammar.grammarName + "Token._END);\n" +
                               "\t}\n" +
                               "\n" +
                               "\tprivate boolean findFirstSkipToken() {\n" +
                               "\t\tfor (TokenItem item : skipTokenPatterns) {\n" +
                               "\t\t\tMatcher m = item.pattern.matcher(inputSB.toString());\n" +
                               "\t\t\tif (m.lookingAt()) {\n" +
                               "\t\t\t\tinputSB.delete(0, m.end());\n" +
                               "\t\t\t\treturn true;\n" +
                               "\t\t\t}\n" +
                               "\t\t}\n" +
                               "\t\treturn false;\n" +
                               "\t}\n" +
                               "\n" +
                               "\tprivate " + self.grammar.grammarName + "Token findFirstToken() {\n" +
                               "\t\tfor (TokenItem item : tokenPatterns) {\n" +
                               "\t\t\tMatcher m = item.pattern.matcher(inputSB.toString());\n" +
                               "\t\t\tif (m.lookingAt()) {\n" +
                               "\t\t\t\ttokensToString.add(inputSB.substring(0, m.end()));\n" +
                               "\t\t\t\tinputSB.delete(0, m.end());\n" +
                               "\t\t\t\treturn item.token;\n" +
                               "\t\t\t}\n" +
                               "\t\t}\n" +
                               "\t\treturn null;\n" +
                               "\t}\n" +
                               "\n" +
                               "\tprivate static class TokenItem {\n" +
                               "\t\t" + self.grammar.grammarName + "Token token;\n" +
                               "\t\tPattern pattern;\n" +
                               "\t\tTokenItem(" + self.grammar.grammarName + "Token token, String s) {\n" +
                               "\t\t\tthis.token = token;\n" +
                               "\t\t\tpattern = Pattern.compile(s);\n" +
                               "\t\t}\n" +
                               "\t}\n" +
                               "}", 0
                               )
        return sb

    def printString(self, text, tabs):
        s = ''
        for i in range(tabs):
            s += "\t"

        s += text
        s += "\n"
        return s
