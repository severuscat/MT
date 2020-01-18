from antlr4 import *

from LAB_03.gen.prefix_notationLexer import prefix_notationLexer
from LAB_03.gen.prefix_notationParser import prefix_notationParser


def main(name):
    input = FileStream(name)
    lexer = prefix_notationLexer(input)
    tokens = CommonTokenStream(lexer)
    parser = prefix_notationParser(tokens)
    parser.w = name+'gen'
    parser.s()


if __name__ == '__main__':
    main('test')
    main('tetst1')
