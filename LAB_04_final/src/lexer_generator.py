from LAB_04_final.src.utils import *
from LAB_04_final.src.grammar import Grammar

import os


class LexerGenerator:

    def __init__(self, grammar):
        self.grammar = grammar
        pathDir = os.path.join(
            "gen",
            grammar.grammar_name.lower()
        )
        if not os.path.exists(pathDir):
            os.makedirs(pathDir)
        fileName = grammar.grammar_name + "LexicalAnalyzer.py"
        enumFileName = grammar.grammar_name + "Token.py"
        with open(os.path.join(pathDir, enumFileName), 'w') as f:
            f.write(self.token_class_text())

        with open(os.path.join(pathDir, fileName), 'w') as f:
            f.write(self.file_text())

    def token_class_text(self):
        s = print_string('class ' + self.grammar.grammar_name + '_Token:', 0)
        for s1 in self.grammar.token_items.keys():
            s += print_string('{} = \"{}\"'.format(s1, s1), 1)
        s += print_string('_END=\"_END\"', 1)
        return s

    def file_text(self):
        s = 'from LAB_04_final.src.gen.{}.{}Token import {}_Token\n' \
            'import re\n\n' \
            'class {}lexer:\n'.format(self.grammar.grammar_name.lower(),
                                      self.grammar.grammar_name,
                                      self.grammar.grammar_name,
                                      self.grammar.grammar_name)
        s += '\tdef __init__(self, inp):\n' \
             '\t\tself.inp = inp\n' \
             '\t\tself.token_patterns = list()\n' \
             '\t\tself.skip_token_patterns = list()\n' \
             '\t\tself.tokens = list()\n' \
             '\t\tself.tokens_to_string = list()\n' \
             '\t\tself.cur_pos = 0\n'

        for item in self.grammar.tokens:
            s += print_string(
                "self.token_patterns.append(TokenItem({0}_Token.{1}, {2}))"
                    .format(
                    self.grammar.grammar_name,
                    item.name,
                    item.pattern),
                2
            )
        s += print_string('self.get_tokens()\n\n', 2)
        # methods
        s += print_string(
            '\tdef get_current_token(self):\n'
            '\t\treturn self.tokens[self.cur_pos]\n'
            '\n'
            '\tdef get_current_token_str(self):\n'
            '\t\treturn self.tokens_to_string[self.cur_pos]\n'
            '\n'
            '\tdef get_next_token(self):\n'
            '\t\tself.cur_pos += 1\n'
            '\t\treturn self.tokens[self.cur_pos]\n'
            '\n'
            '\tdef get_tokens(self):\n'
            '\t\twhile len(self.inp) != 0:\n'
            '\t\t\tt = self.find_first_token()\n'
            '\t\t\tif t is not None:\n'
            '\t\t\t\tself.tokens.append(t)\n'
            '\t\t\telif not self.find_first_skip_token():\n'
            '\t\t\t\traise Exception("NO MATCING WITH TOKENS")\n'
            '\n'
            '\t\tself.tokens.append({0}_Token._END)\n'
            '\tdef find_first_skip_token(self):\n'
            '\t\tfor item in self.skip_token_patterns:\n'
            '\t\t\tm = re.match(item.pattern, self.inp)\n'
            '\t\t\tif m is not None:\n'
            '\t\t\t\tself.inp = self.inp[m.end():]\n'
            '\t\t\t\treturn True\n'
            '\t\treturn False\n\n'
            '\tdef find_first_token(self):\n'
            '\t\tfor item in self.token_patterns:\n'
            '\t\t\tm = re.match(item.pattern, self.inp)\n'
            '\t\t\tif m is not None:\n'
            '\t\t\t\tself.tokens_to_string.append(self.inp[0:m.end()])\n'
            '\t\t\t\tself.inp = self.inp[m.end():]\n'
            '\t\t\t\treturn item.token\n'
            '\t\treturn None\n'
            '\n'
            'class TokenItem:\n'
            '\ttoken = {1}_Token()\n'
            '\tpattern = r\'\'\n\n'
            '\tdef __init__(self, token, s):\n'
            '\t\tself.token = token\n'
            '\t\tself.pattern = re.compile(s)\n'
            '\n\n'
            '# ======= TEST ========\n'
            '# if __name__ == \'__main__\':\n'
            '\t# cl = {2}lexer(\'1+10\')\n'
            '\t# print(cl.tokens)'.format(self.grammar.grammar_name,
                                        self.grammar.grammar_name,
                                        self.grammar.grammar_name),
            0
        )
        return s
