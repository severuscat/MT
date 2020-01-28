# Generated from grammar_parser.g4 by ANTLR 4.8
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .grammar_parserParser import grammar_parserParser
else:
    from grammar_parserParser import grammar_parserParser
from LAB_04.src.generator import grammar, utils

# This class defines a complete listener for a parse tree produced by grammar_parserParser.
class grammar_parserListener(ParseTreeListener):

    # Enter a parse tree produced by grammar_parserParser#start.
    def enterStart(self, ctx:grammar_parserParser.StartContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#start.
    def exitStart(self, ctx:grammar_parserParser.StartContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#program.
    def enterProgram(self, ctx:grammar_parserParser.ProgramContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#program.
    def exitProgram(self, ctx:grammar_parserParser.ProgramContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#header.
    def enterHeader(self, ctx:grammar_parserParser.HeaderContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#header.
    def exitHeader(self, ctx:grammar_parserParser.HeaderContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#imports.
    def enterImports(self, ctx:grammar_parserParser.ImportsContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#imports.
    def exitImports(self, ctx:grammar_parserParser.ImportsContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#import_line.
    def enterImport_line(self, ctx:grammar_parserParser.Import_lineContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#import_line.
    def exitImport_line(self, ctx:grammar_parserParser.Import_lineContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#import_name.
    def enterImport_name(self, ctx:grammar_parserParser.Import_nameContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#import_name.
    def exitImport_name(self, ctx:grammar_parserParser.Import_nameContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#tokenss.
    def enterTokenss(self, ctx:grammar_parserParser.TokenssContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#tokenss.
    def exitTokenss(self, ctx:grammar_parserParser.TokenssContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#token_line.
    def enterToken_line(self, ctx:grammar_parserParser.Token_lineContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#token_line.
    def exitToken_line(self, ctx:grammar_parserParser.Token_lineContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#startState.
    def enterStartState(self, ctx:grammar_parserParser.StartStateContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#startState.
    def exitStartState(self, ctx:grammar_parserParser.StartStateContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#skip_attr.
    def enterSkip_attr(self, ctx:grammar_parserParser.Skip_attrContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#skip_attr.
    def exitSkip_attr(self, ctx:grammar_parserParser.Skip_attrContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#states.
    def enterStates(self, ctx:grammar_parserParser.StatesContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#states.
    def exitStates(self, ctx:grammar_parserParser.StatesContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#state_line.
    def enterState_line(self, ctx:grammar_parserParser.State_lineContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#state_line.
    def exitState_line(self, ctx:grammar_parserParser.State_lineContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#parameters_state.
    def enterParameters_state(self, ctx:grammar_parserParser.Parameters_stateContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#parameters_state.
    def exitParameters_state(self, ctx:grammar_parserParser.Parameters_stateContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#returns_state.
    def enterReturns_state(self, ctx:grammar_parserParser.Returns_stateContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#returns_state.
    def exitReturns_state(self, ctx:grammar_parserParser.Returns_stateContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#rule_line.
    def enterRule_line(self, ctx:grammar_parserParser.Rule_lineContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#rule_line.
    def exitRule_line(self, ctx:grammar_parserParser.Rule_lineContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#parameters_rule.
    def enterParameters_rule(self, ctx:grammar_parserParser.Parameters_ruleContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#parameters_rule.
    def exitParameters_rule(self, ctx:grammar_parserParser.Parameters_ruleContext):
        pass


    # Enter a parse tree produced by grammar_parserParser#code_block.
    def enterCode_block(self, ctx:grammar_parserParser.Code_blockContext):
        pass

    # Exit a parse tree produced by grammar_parserParser#code_block.
    def exitCode_block(self, ctx:grammar_parserParser.Code_blockContext):
        pass



del grammar_parserParser