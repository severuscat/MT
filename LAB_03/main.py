from antlr4 import *

from LAB_03.gen.prefix_notationLexer import prefix_notationLexer
from LAB_03.gen.prefix_notationParser import prefix_notationParser


def main():
    input = FileStream('yet_another_test')
    lexer = prefix_notationLexer(input)
    tokens = CommonTokenStream(lexer)
    parser = prefix_notationParser(tokens)
    parser.w = open('test').readline()
    parser.s()


if __name__ == '__main__':
    main()
