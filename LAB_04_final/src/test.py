from LAB_04_final.src.gen.calculator.CalculatorLexicalAnalyzer import Calculatorlexer
from LAB_04_final.src.gen.calculator.CalculatorParser import CalculatorParser

if __name__ == '__main__':
    input = '1+1+10*5'
    lexer = Calculatorlexer(input)
    parser = CalculatorParser(lexer)
    parser.print_tree()