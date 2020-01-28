from LAB_04.antlr.grammar_parserLexer import grammar_parserLexer
from LAB_04.antlr.grammar_parserParser import grammar_parserParser
from LAB_04.src.generator.lexical_analyzer_generator import LexicalAnalyzerGenerator
from LAB_04.src.generator.parser_generator import ParserGenerator

from antlr4 import *


def main(name):
    # /home/severuscat/STUD/MT/LAB_04/grammars/calc
    # /home/severuscat/STUD/MT/LAB_04/grammars/hw03
    input = FileStream(name)
    lexer = grammar_parserLexer(input)
    tokens = CommonTokenStream(lexer)
    parser = grammar_parserParser(tokens)
    grammar = parser.start().g
    grammar.constructFirst()
    grammar.constructFollow()
    lexicalAnalyzerGenerator = LexicalAnalyzerGenerator(grammar)
    parserGenerator = ParserGenerator(grammar)


if __name__ == "__main__":
    # filename = input()
    main('../../grammars/test')
    # main('../../grammars/calc')
