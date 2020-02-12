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
        s = 'from LAB_04_final.src.gen.{0}.{1}Token import *\n' \
            'from LAB_04_final.src.gen.{0} import {1}LexicalAnalyzer\n\n' \
            ''.format(self.grammar.grammar_name.lower(), self.grammar.grammar_name)
        for imp in self.grammar.imports:
            s += 'import {}\n'.format(imp)

        # ===========NODE===========
        s += 'class Node:\n' \
             '\tdef __init__(self, name=None):\n' \
             '\t\tself.name = \'\' if name is None else name\n' \
             '\t\tself.children = list() # Nodes\n\n' \
             '\tdef add_child(self, node):\n' \
             '\t\tself.children.append(node)\n' \
             '\n' \
             '\tdef tree_to_string(self, mask=None):\n' \
             '\t\tmask = list() if mask is None else mask\n' \
             '\t\ts = \'\'\n' \
             '\t\tif len(mask) == 0:\n' \
             '\t\t\ts += \"|__\"\n' \
             '\t\ts += self.name + \'\\n\'\n' \
             '\t\tfor cur_child in range(len(self.children)):\n' \
             '\t\t\tfor b in mask:\n' \
             '\t\t\t\tif b:\n' \
             '\t\t\t\t\ts += \"|  \"\n' \
             '\t\t\t\telse:\n' \
             '\t\t\t\t\ts += \"   \"\n' \
             '\t\t\tmask.append(cur_child != len(self.children) - 1)\n' \
             '\t\t\ts += self.children[cur_child].tree_to_string(mask)\n' \
             '\t\t\tmask = mask[0:-1]\n' \
             '\t\treturn s' \
             '\n\n\n'
        s += 'def exp():\n' \
             '\traise Exception("UNEXPECTED TOKEN")\n\n'

        for state in self.grammar.states.values():
            s += self.print_state_node(state)

        # ===========PARSER===========

        # --------constructor---------
        s += 'class {}Parser:\n' \
             '\tdef __init__(self, lexer):\n' \
             '\t\tself.lexer = lexer\n' \
             '\t\tself.tree = Node()\n' \
             '\t\tself.build_tree()\n\n' \
             ''.format(self.grammar.grammar_name)
        # ---------build tree---------
        s += '\tdef build_tree(self):\n' \
             '\t\tself.tree = self._{0}()\n' \
             '\t\tif self.lexer.get_current_token() != {1}_Token._END:\n' \
             '\t\t\traise Exception("_END EXPECTED " + self.lexer.get_current_token() + " FOUND")\n' \
             '\n' \
             '\tdef print_tree(self):\n' \
             '\t\tprint(self.tree.tree_to_string())\n\n' \
             ''.format(self.grammar.start_state,
                       self.grammar.grammar_name)

        for return_str in self.grammar.states[self.grammar.start_state].returns:
            s += '\tdef get_{0}(self):\n' \
                 '\t\treturn self.tree.{0}\n\n'.format(return_str)

        # ---------consume---------
        s += '\tdef consume(self, token):\n' \
             '\t\tif self.lexer.get_current_token() != token:\n' \
             '\t\t\traise Exception("EXPECTED ANOTHER TOKEN")\n\n'

        # ---------states---------

        for st in self.grammar.states.values():
            s += self.print_state(st)

        return s

    def print_state_node(self, st):
        s = 'class Node_{0}(Node):\n' \
            '\tdef __init__(self):\n' \
            '\t\tsuper().__init__(\'{0}\')\n' \
            ''.format(st.name)
        for rr in st.returns:
            s += '\t\tself.{} = None\n'.format(rr)
        return s + '\n'

    def print_state(self, st):
        s = '\tdef _{0}(self{1}):\n' \
            '\t\tres = Node_{0}()\n'.format(st.name, self.print_params(st.parametrs))
        s += '\t\tc_t = self.lexer.get_current_token()\n' \
             '\t\tif c_t == \'\':\n' \
             '\t\t\tpass\n'
        for rule in st.rules:
            s += self.print_rule(rule, st)
        s += '\t\telse:\n' \
             '\t\t\texp()\n' \
             '\t\treturn res\n\n'
        return s

    def print_params(self, params):
        s = ''
        for i in range(len(params)):
            s += ', '
            s += params[i]
        return s

    def print_follow_case(self, st, action):
        s = ''
        for item in st.follow:
            s += "\t\telif c_t == {}_Token.{}:\n" \
                 "".format(self.grammar.grammar_name, item)
            # if item != '_END':
            s += "\t\t\tpass\n"
        if len(action) == 0:
            s += '\t\t\tpass\n'
            return s
        s += '\t' * 3 + action + '\n'
        s += '\t\t\treturn res\n'
        return s

    def print_rule(self, rule, st):
        s = ''
        first = self.grammar.first_for_rule(rule)
        has_eps = False
        for token in first:
            if token != 'EPS':
                s += '\t\telif c_t == {}_Token.{}:\n' \
                     ''.format(self.grammar.grammar_name, token)
            else:
                has_eps = True
                s += (self.print_follow_case(st, rule.actions[0]))
        if s == '' or has_eps:
            return s
        index = 0
        for i in range(len(rule.items)):
            item = rule.items[i]
            if item in self.grammar.token_items.keys():
                s += '\t\t\tself.consume({0}_Token.{1})\n' \
                     '\t\t\tres.add_child(Node("{1}"))\n' \
                     '\t\t\t{2}\n' \
                     '\t\t\tself.lexer.get_next_token()\n' \
                     '\n'.format(self.grammar.grammar_name, item, rule.actions[i])
            elif item in self.grammar.states.keys():
                print(item, rule.actions, rule.parametrs)

                s += '\t\t\tn{0} = self._{1}({2})\n' \
                     '\t\t\tres.add_child(n{0})\n' \
                     '\t\t\t{3}\n'.format(index, item, rule.parametrs[i], rule.actions[i])
                index += 1
            else:
                raise Exception("NOT IN TOKEN OR STATES")
        s += '\t\t\treturn res\n'
        return s
