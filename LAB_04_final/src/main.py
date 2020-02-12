from LAB_04_final.antlr.grammar_parserLexer import grammar_parserLexer
from LAB_04_final.antlr.grammar_parserParser import grammar_parserParser
from LAB_04_final.src.lexer_generator import LexerGenerator
from LAB_04_final.src.parser_generator import ParserGenerator
from LAB_04_final.src.gen.calculator.CalculatorLexicalAnalyzer import Calculatorlexer
from LAB_04_final.src.gen.calculator.CalculatorParser import CalculatorParser

from antlr4 import *


def main(name):
    # /home/severuscat/STUD/MT/LAB_04_final/grammars/calc
    # /home/severuscat/STUD/MT/LAB_04_final/grammars/hw03
    input = FileStream(name)
    lexer = grammar_parserLexer(input)
    tokens = CommonTokenStream(lexer)
    parser = grammar_parserParser(tokens)
    grammar = parser.start().g
    grammar.construct_first()
    grammar.construct_follow()
    lexicalAnalyzerGenerator = LexerGenerator(grammar)
    # print([(item+' '+str(lexicalAnalyzerGenerator.grammar.states[item].first)) for item in lexicalAnalyzerGenerator.grammar.states])
    # print([(item+' '+str(lexicalAnalyzerGenerator.grammar.states[item].follow)) for item in lexicalAnalyzerGenerator.grammar.states])
    parserGenerator = ParserGenerator(grammar)
    input = '1+1'
    lexer = Calculatorlexer(input)
    parser = CalculatorParser(lexer)
    parser.print_tree()


if __name__ == "__main__":
    # filename = input()
    main('../grammars/calc')
    # main('../../grammars/calc')
