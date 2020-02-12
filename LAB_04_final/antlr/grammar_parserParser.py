# Generated from grammar_parser.g4 by ANTLR 4.8
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

from LAB_04_final.src import grammar, utils

def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31")
        buf.write("\u00c2\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16")
        buf.write("\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\3\2\3\2")
        buf.write("\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3")
        buf.write("\5\3\5\7\5\66\n\5\f\5\16\59\13\5\3\5\3\5\3\6\3\6\3\6\3")
        buf.write("\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7G\n\7\f\7\16\7J\13\7\3\b")
        buf.write("\3\b\3\b\7\bO\n\b\f\b\16\bR\13\b\3\b\3\b\3\t\3\t\3\t\3")
        buf.write("\t\3\t\3\t\5\t\\\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3")
        buf.write("\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\6\fo\n\f\r\f\16")
        buf.write("\fp\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r{\n\r\3\r\3\r\3")
        buf.write("\r\3\r\3\r\5\r\u0082\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7")
        buf.write("\r\u008b\n\r\f\r\16\r\u008e\13\r\3\r\3\r\3\16\3\16\3\16")
        buf.write("\3\16\3\16\7\16\u0097\n\16\f\16\16\16\u009a\13\16\3\17")
        buf.write("\3\17\3\17\3\17\3\17\7\17\u00a1\n\17\f\17\16\17\u00a4")
        buf.write("\13\17\3\20\3\20\5\20\u00a8\n\20\3\20\5\20\u00ab\n\20")
        buf.write("\3\20\6\20\u00ae\n\20\r\20\16\20\u00af\3\21\3\21\3\21")
        buf.write("\3\21\3\21\3\21\7\21\u00b8\n\21\f\21\16\21\u00bb\13\21")
        buf.write("\3\21\3\21\3\22\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20")
        buf.write("\22\24\26\30\32\34\36 \"\2\2\2\u00be\2$\3\2\2\2\4\'\3")
        buf.write("\2\2\2\6-\3\2\2\2\b\62\3\2\2\2\n<\3\2\2\2\fA\3\2\2\2\16")
        buf.write("K\3\2\2\2\20U\3\2\2\2\22`\3\2\2\2\24f\3\2\2\2\26i\3\2")
        buf.write("\2\2\30t\3\2\2\2\32\u0091\3\2\2\2\34\u009b\3\2\2\2\36")
        buf.write("\u00ad\3\2\2\2 \u00b1\3\2\2\2\"\u00be\3\2\2\2$%\5\4\3")
        buf.write("\2%&\7\2\2\3&\3\3\2\2\2\'(\5\6\4\2()\5\b\5\2)*\5\16\b")
        buf.write("\2*+\5\22\n\2+,\5\26\f\2,\5\3\2\2\2-.\7\3\2\2./\7\27\2")
        buf.write("\2/\60\7\4\2\2\60\61\b\4\1\2\61\7\3\2\2\2\62\63\7\5\2")
        buf.write("\2\63\67\7\6\2\2\64\66\5\n\6\2\65\64\3\2\2\2\669\3\2\2")
        buf.write("\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7")
        buf.write("\7\2\2;\t\3\2\2\2<=\7\b\2\2=>\5\f\7\2>?\b\6\1\2?@\7\4")
        buf.write("\2\2@\13\3\2\2\2AB\7\27\2\2BH\b\7\1\2CD\7\t\2\2DE\7\27")
        buf.write("\2\2EG\b\7\1\2FC\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2")
        buf.write("I\r\3\2\2\2JH\3\2\2\2KL\7\n\2\2LP\7\6\2\2MO\5\20\t\2N")
        buf.write("M\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3")
        buf.write("\2\2\2ST\7\7\2\2T\17\3\2\2\2UV\7\27\2\2VW\7\13\2\2W[\7")
        buf.write("\30\2\2XY\5\24\13\2YZ\b\t\1\2Z\\\3\2\2\2[X\3\2\2\2[\\")
        buf.write("\3\2\2\2\\]\3\2\2\2]^\7\4\2\2^_\b\t\1\2_\21\3\2\2\2`a")
        buf.write("\7\f\2\2ab\7\r\2\2bc\7\27\2\2cd\7\4\2\2de\b\n\1\2e\23")
        buf.write("\3\2\2\2fg\7\16\2\2gh\7\17\2\2h\25\3\2\2\2ij\7\20\2\2")
        buf.write("jn\7\6\2\2kl\5\30\r\2lm\b\f\1\2mo\3\2\2\2nk\3\2\2\2op")
        buf.write("\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\7\2\2s\27\3")
        buf.write("\2\2\2tu\7\27\2\2uz\b\r\1\2vw\7\21\2\2wx\5\32\16\2xy\7")
        buf.write("\22\2\2y{\3\2\2\2zv\3\2\2\2z{\3\2\2\2{\u0081\3\2\2\2|")
        buf.write("}\7\23\2\2}~\7\21\2\2~\177\5\34\17\2\177\u0080\7\22\2")
        buf.write("\2\u0080\u0082\3\2\2\2\u0081|\3\2\2\2\u0081\u0082\3\2")
        buf.write("\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\13\2\2\u0084\u0085")
        buf.write("\5\36\20\2\u0085\u008c\b\r\1\2\u0086\u0087\7\24\2\2\u0087")
        buf.write("\u0088\5\36\20\2\u0088\u0089\b\r\1\2\u0089\u008b\3\2\2")
        buf.write("\2\u008a\u0086\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a")
        buf.write("\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e")
        buf.write("\u008c\3\2\2\2\u008f\u0090\7\4\2\2\u0090\31\3\2\2\2\u0091")
        buf.write("\u0092\7\27\2\2\u0092\u0098\b\16\1\2\u0093\u0094\7\25")
        buf.write("\2\2\u0094\u0095\7\27\2\2\u0095\u0097\b\16\1\2\u0096\u0093")
        buf.write("\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098")
        buf.write("\u0099\3\2\2\2\u0099\33\3\2\2\2\u009a\u0098\3\2\2\2\u009b")
        buf.write("\u009c\7\27\2\2\u009c\u00a2\b\17\1\2\u009d\u009e\7\25")
        buf.write("\2\2\u009e\u009f\7\27\2\2\u009f\u00a1\b\17\1\2\u00a0\u009d")
        buf.write("\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2")
        buf.write("\u00a3\3\2\2\2\u00a3\35\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5")
        buf.write("\u00a7\7\27\2\2\u00a6\u00a8\5 \21\2\u00a7\u00a6\3\2\2")
        buf.write("\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00ab")
        buf.write("\5\"\22\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab")
        buf.write("\u00ac\3\2\2\2\u00ac\u00ae\b\20\1\2\u00ad\u00a5\3\2\2")
        buf.write("\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0")
        buf.write("\3\2\2\2\u00b0\37\3\2\2\2\u00b1\u00b2\7\21\2\2\u00b2\u00b3")
        buf.write("\7\27\2\2\u00b3\u00b9\b\21\1\2\u00b4\u00b5\7\25\2\2\u00b5")
        buf.write("\u00b6\7\27\2\2\u00b6\u00b8\b\21\1\2\u00b7\u00b4\3\2\2")
        buf.write("\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba")
        buf.write("\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc")
        buf.write("\u00bd\7\22\2\2\u00bd!\3\2\2\2\u00be\u00bf\7\31\2\2\u00bf")
        buf.write("\u00c0\b\22\1\2\u00c0#\3\2\2\2\20\67HP[pz\u0081\u008c")
        buf.write("\u0098\u00a2\u00a7\u00aa\u00af\u00b9")
        return buf.getvalue()


class grammar_parserParser ( Parser ):

    grammarFileName = "grammar_parser.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'grammar'", "';'", "'@imp'", "'{'", "'}'", 
                     "'import'", "'.'", "'@tokens'", "':'", "'@start'", 
                     "'='", "'->'", "'skip'", "'@states'", "'['", "']'", 
                     "'returns'", "'|'", "','" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "WS", "NAME", "REGEX", "CODE_TEXT" ]

    RULE_start = 0
    RULE_program = 1
    RULE_header = 2
    RULE_imports = 3
    RULE_import_line = 4
    RULE_import_name = 5
    RULE_tokens = 6
    RULE_token_line = 7
    RULE_startState = 8
    RULE_skip_attr = 9
    RULE_states = 10
    RULE_state_line = 11
    RULE_parametrs_state = 12
    RULE_returns_state = 13
    RULE_rule_line = 14
    RULE_parametrs_rule = 15
    RULE_code_block = 16

    ruleNames =  [ "start", "program", "header", "imports", "import_line", 
                   "import_name", "tokens", "token_line", "startState", 
                   "skip_attr", "states", "state_line", "parametrs_state", 
                   "returns_state", "rule_line", "parametrs_rule", "code_block" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    T__5=6
    T__6=7
    T__7=8
    T__8=9
    T__9=10
    T__10=11
    T__11=12
    T__12=13
    T__13=14
    T__14=15
    T__15=16
    T__16=17
    T__17=18
    T__18=19
    WS=20
    NAME=21
    REGEX=22
    CODE_TEXT=23

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.8")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class StartContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None

        def program(self):
            return self.getTypedRuleContext(grammar_parserParser.ProgramContext,0)


        def EOF(self):
            return self.getToken(grammar_parserParser.EOF, 0)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_start

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStart" ):
                listener.enterStart(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStart" ):
                listener.exitStart(self)




    def start(self):

        localctx = grammar_parserParser.StartContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_start)

        localctx.g = grammar.Grammar()

        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 34
            self.program(localctx.g)
            self.state = 35
            self.match(grammar_parserParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ProgramContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self.g = g

        def header(self):
            return self.getTypedRuleContext(grammar_parserParser.HeaderContext,0)


        def imports(self):
            return self.getTypedRuleContext(grammar_parserParser.ImportsContext,0)


        def tokens(self):
            return self.getTypedRuleContext(grammar_parserParser.TokensContext,0)


        def startState(self):
            return self.getTypedRuleContext(grammar_parserParser.StartStateContext,0)


        def states(self):
            return self.getTypedRuleContext(grammar_parserParser.StatesContext,0)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_program

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterProgram" ):
                listener.enterProgram(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitProgram" ):
                listener.exitProgram(self)




    def program(self, g):

        localctx = grammar_parserParser.ProgramContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 2, self.RULE_program)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 37
            self.header(localctx.g)
            self.state = 38
            self.imports(localctx.g)
            self.state = 39
            self.tokens(localctx.g)
            self.state = 40
            self.startState(localctx.g)
            self.state = 41
            self.states(localctx.g)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class HeaderContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self._NAME = None # Token
            self.g = g

        def NAME(self):
            return self.getToken(grammar_parserParser.NAME, 0)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_header

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterHeader" ):
                listener.enterHeader(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitHeader" ):
                listener.exitHeader(self)




    def header(self, g):

        localctx = grammar_parserParser.HeaderContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 4, self.RULE_header)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 43
            self.match(grammar_parserParser.T__0)
            self.state = 44
            localctx._NAME = self.match(grammar_parserParser.NAME)
            self.state = 45
            self.match(grammar_parserParser.T__1)
            localctx.g.grammar_name = (None if localctx._NAME is None else localctx._NAME.text)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ImportsContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self.g = g

        def import_line(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(grammar_parserParser.Import_lineContext)
            else:
                return self.getTypedRuleContext(grammar_parserParser.Import_lineContext,i)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_imports

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterImports" ):
                listener.enterImports(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitImports" ):
                listener.exitImports(self)




    def imports(self, g):

        localctx = grammar_parserParser.ImportsContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 6, self.RULE_imports)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 48
            self.match(grammar_parserParser.T__2)
            self.state = 49
            self.match(grammar_parserParser.T__3)
            self.state = 53
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.T__5:
                self.state = 50
                self.import_line(localctx.g)
                self.state = 55
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 56
            self.match(grammar_parserParser.T__4)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Import_lineContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self._import_name = None # Import_nameContext
            self.g = g

        def import_name(self):
            return self.getTypedRuleContext(grammar_parserParser.Import_nameContext,0)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_import_line

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterImport_line" ):
                listener.enterImport_line(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitImport_line" ):
                listener.exitImport_line(self)




    def import_line(self, g):

        localctx = grammar_parserParser.Import_lineContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 8, self.RULE_import_line)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 58
            self.match(grammar_parserParser.T__5)
            self.state = 59
            localctx._import_name = self.import_name()
            localctx.g.add_import(localctx._import_name.name)
            self.state = 61
            self.match(grammar_parserParser.T__1)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Import_nameContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.name = None
            self.n1 = None # Token
            self.n2 = None # Token

        def NAME(self, i:int=None):
            if i is None:
                return self.getTokens(grammar_parserParser.NAME)
            else:
                return self.getToken(grammar_parserParser.NAME, i)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_import_name

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterImport_name" ):
                listener.enterImport_name(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitImport_name" ):
                listener.exitImport_name(self)




    def import_name(self):

        localctx = grammar_parserParser.Import_nameContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_import_name)

        localctx.name = ""

        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 63
            localctx.n1 = self.match(grammar_parserParser.NAME)
            localctx.name += (None if localctx.n1 is None else localctx.n1.text)
            self.state = 70
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.T__6:
                self.state = 65
                self.match(grammar_parserParser.T__6)
                self.state = 66
                localctx.n2 = self.match(grammar_parserParser.NAME)
                localctx.name += '.' + (None if localctx.n2 is None else localctx.n2.text)
                self.state = 72
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class TokensContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self.g = g

        def token_line(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(grammar_parserParser.Token_lineContext)
            else:
                return self.getTypedRuleContext(grammar_parserParser.Token_lineContext,i)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_tokens

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterTokens" ):
                listener.enterTokens(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitTokens" ):
                listener.exitTokens(self)




    def tokens(self, g):

        localctx = grammar_parserParser.TokensContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 12, self.RULE_tokens)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 73
            self.match(grammar_parserParser.T__7)
            self.state = 74
            self.match(grammar_parserParser.T__3)
            self.state = 78
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.NAME:
                self.state = 75
                self.token_line(localctx.g)
                self.state = 80
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 81
            self.match(grammar_parserParser.T__4)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Token_lineContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self.has_skip = None
            self._NAME = None # Token
            self._REGEX = None # Token
            self.g = g

        def NAME(self):
            return self.getToken(grammar_parserParser.NAME, 0)

        def REGEX(self):
            return self.getToken(grammar_parserParser.REGEX, 0)

        def skip_attr(self):
            return self.getTypedRuleContext(grammar_parserParser.Skip_attrContext,0)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_token_line

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterToken_line" ):
                listener.enterToken_line(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitToken_line" ):
                listener.exitToken_line(self)




    def token_line(self, g):

        localctx = grammar_parserParser.Token_lineContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 14, self.RULE_token_line)

        localctx.has_skip = False

        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 83
            localctx._NAME = self.match(grammar_parserParser.NAME)
            self.state = 84
            self.match(grammar_parserParser.T__8)
            self.state = 85
            localctx._REGEX = self.match(grammar_parserParser.REGEX)
            self.state = 89
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==grammar_parserParser.T__11:
                self.state = 86
                self.skip_attr()
                localctx.has_skip = True


            self.state = 91
            self.match(grammar_parserParser.T__1)

            if (localctx.has_skip):
                localctx.g.add_skip_token((None if localctx._NAME is None else localctx._NAME.text), (None if localctx._REGEX is None else localctx._REGEX.text))
            else:
                localctx.g.add_token((None if localctx._NAME is None else localctx._NAME.text), (None if localctx._REGEX is None else localctx._REGEX.text))

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class StartStateContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self._NAME = None # Token
            self.g = g

        def NAME(self):
            return self.getToken(grammar_parserParser.NAME, 0)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_startState

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStartState" ):
                listener.enterStartState(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStartState" ):
                listener.exitStartState(self)




    def startState(self, g):

        localctx = grammar_parserParser.StartStateContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 16, self.RULE_startState)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 94
            self.match(grammar_parserParser.T__9)
            self.state = 95
            self.match(grammar_parserParser.T__10)
            self.state = 96
            localctx._NAME = self.match(grammar_parserParser.NAME)
            self.state = 97
            self.match(grammar_parserParser.T__1)

            localctx.g.start_state = (None if localctx._NAME is None else localctx._NAME.text)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Skip_attrContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return grammar_parserParser.RULE_skip_attr

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterSkip_attr" ):
                listener.enterSkip_attr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitSkip_attr" ):
                listener.exitSkip_attr(self)




    def skip_attr(self):

        localctx = grammar_parserParser.Skip_attrContext(self, self._ctx, self.state)
        self.enterRule(localctx, 18, self.RULE_skip_attr)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 100
            self.match(grammar_parserParser.T__11)
            self.state = 101
            self.match(grammar_parserParser.T__12)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class StatesContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, g=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.g = None
            self._state_line = None # State_lineContext
            self.g = g

        def state_line(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(grammar_parserParser.State_lineContext)
            else:
                return self.getTypedRuleContext(grammar_parserParser.State_lineContext,i)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_states

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterStates" ):
                listener.enterStates(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitStates" ):
                listener.exitStates(self)




    def states(self, g):

        localctx = grammar_parserParser.StatesContext(self, self._ctx, self.state, g)
        self.enterRule(localctx, 20, self.RULE_states)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 103
            self.match(grammar_parserParser.T__13)
            self.state = 104
            self.match(grammar_parserParser.T__3)
            self.state = 108 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 105
                localctx._state_line = self.state_line()
                localctx.g.add_state(localctx._state_line.state)
                self.state = 110 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==grammar_parserParser.NAME):
                    break

            self.state = 112
            self.match(grammar_parserParser.T__4)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class State_lineContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.state = None
            self._NAME = None # Token
            self.r1 = None # Rule_lineContext
            self.r2 = None # Rule_lineContext

        def NAME(self):
            return self.getToken(grammar_parserParser.NAME, 0)

        def rule_line(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(grammar_parserParser.Rule_lineContext)
            else:
                return self.getTypedRuleContext(grammar_parserParser.Rule_lineContext,i)


        def parametrs_state(self):
            return self.getTypedRuleContext(grammar_parserParser.Parametrs_stateContext,0)


        def returns_state(self):
            return self.getTypedRuleContext(grammar_parserParser.Returns_stateContext,0)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_state_line

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterState_line" ):
                listener.enterState_line(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitState_line" ):
                listener.exitState_line(self)




    def state_line(self):

        localctx = grammar_parserParser.State_lineContext(self, self._ctx, self.state)
        self.enterRule(localctx, 22, self.RULE_state_line)

        localctx.state = utils.State()

        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 114
            localctx._NAME = self.match(grammar_parserParser.NAME)
            localctx.state.name = (None if localctx._NAME is None else localctx._NAME.text)
            self.state = 120
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==grammar_parserParser.T__14:
                self.state = 116
                self.match(grammar_parserParser.T__14)
                self.state = 117
                self.parametrs_state(localctx.state)
                self.state = 118
                self.match(grammar_parserParser.T__15)


            self.state = 127
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            if _la==grammar_parserParser.T__16:
                self.state = 122
                self.match(grammar_parserParser.T__16)
                self.state = 123
                self.match(grammar_parserParser.T__14)
                self.state = 124
                self.returns_state(localctx.state)
                self.state = 125
                self.match(grammar_parserParser.T__15)


            self.state = 129
            self.match(grammar_parserParser.T__8)
            self.state = 130
            localctx.r1 = self.rule_line()
            localctx.state.add_rule(localctx.r1.r)
            self.state = 138
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.T__17:
                self.state = 132
                self.match(grammar_parserParser.T__17)
                self.state = 133
                localctx.r2 = self.rule_line()
                localctx.state.add_rule(localctx.r2.r)
                self.state = 140
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 141
            self.match(grammar_parserParser.T__1)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Parametrs_stateContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, state=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.state = None
            self.name1 = None # Token
            self.name2 = None # Token
            self.state = state

        def NAME(self, i:int=None):
            if i is None:
                return self.getTokens(grammar_parserParser.NAME)
            else:
                return self.getToken(grammar_parserParser.NAME, i)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_parametrs_state

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterParametrs_state" ):
                listener.enterParametrs_state(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitParametrs_state" ):
                listener.exitParametrs_state(self)




    def parametrs_state(self, state):

        localctx = grammar_parserParser.Parametrs_stateContext(self, self._ctx, self.state, state)
        self.enterRule(localctx, 24, self.RULE_parametrs_state)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 143
            localctx.name1 = self.match(grammar_parserParser.NAME)
            localctx.state.add_parameter((None if localctx.name1 is None else localctx.name1.text))
            self.state = 150
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.T__18:
                self.state = 145
                self.match(grammar_parserParser.T__18)
                self.state = 146
                localctx.name2 = self.match(grammar_parserParser.NAME)
                localctx.state.add_parameter((None if localctx.name2 is None else localctx.name2.text))
                self.state = 152
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Returns_stateContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, state=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.state = None
            self.name1 = None # Token
            self.name2 = None # Token
            self.state = state

        def NAME(self, i:int=None):
            if i is None:
                return self.getTokens(grammar_parserParser.NAME)
            else:
                return self.getToken(grammar_parserParser.NAME, i)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_returns_state

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterReturns_state" ):
                listener.enterReturns_state(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitReturns_state" ):
                listener.exitReturns_state(self)




    def returns_state(self, state):

        localctx = grammar_parserParser.Returns_stateContext(self, self._ctx, self.state, state)
        self.enterRule(localctx, 26, self.RULE_returns_state)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 153
            localctx.name1 = self.match(grammar_parserParser.NAME)
            localctx.state.returns.append((None if localctx.name1 is None else localctx.name1.text))
            self.state = 160
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.T__18:
                self.state = 155
                self.match(grammar_parserParser.T__18)
                self.state = 156
                localctx.name2 = self.match(grammar_parserParser.NAME)
                localctx.state.add_return((None if localctx.name2 is None else localctx.name2.text))
                self.state = 162
                self._errHandler.sync(self)
                _la = self._input.LA(1)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Rule_lineContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.r = None
            self.parametrs = None
            self.code = None
            self._NAME = None # Token

        def NAME(self, i:int=None):
            if i is None:
                return self.getTokens(grammar_parserParser.NAME)
            else:
                return self.getToken(grammar_parserParser.NAME, i)

        def parametrs_rule(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(grammar_parserParser.Parametrs_ruleContext)
            else:
                return self.getTypedRuleContext(grammar_parserParser.Parametrs_ruleContext,i)


        def code_block(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(grammar_parserParser.Code_blockContext)
            else:
                return self.getTypedRuleContext(grammar_parserParser.Code_blockContext,i)


        def getRuleIndex(self):
            return grammar_parserParser.RULE_rule_line

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterRule_line" ):
                listener.enterRule_line(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitRule_line" ):
                listener.exitRule_line(self)




    def rule_line(self):

        localctx = grammar_parserParser.Rule_lineContext(self, self._ctx, self.state)
        self.enterRule(localctx, 28, self.RULE_rule_line)

        localctx.parametrs= list()
        localctx.code = list()
        localctx.r = utils.Rule()

        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 171 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 163
                localctx._NAME = self.match(grammar_parserParser.NAME)
                self.state = 165
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==grammar_parserParser.T__14:
                    self.state = 164
                    self.parametrs_rule(localctx.parametrs)


                self.state = 168
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if _la==grammar_parserParser.CODE_TEXT:
                    self.state = 167
                    self.code_block(localctx.code)


                localctx.r.add_item((None if localctx._NAME is None else localctx._NAME.text), ''.join(localctx.parametrs), ''.join(localctx.code)[1:-1])
                localctx.parametrs = list()
                localctx.code = list()
                self.state = 173 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==grammar_parserParser.NAME):
                    break

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Parametrs_ruleContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, parametrs=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.parametrs = None
            self.n1 = None # Token
            self.n2 = None # Token
            self.parametrs = parametrs

        def NAME(self, i:int=None):
            if i is None:
                return self.getTokens(grammar_parserParser.NAME)
            else:
                return self.getToken(grammar_parserParser.NAME, i)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_parametrs_rule

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterParametrs_rule" ):
                listener.enterParametrs_rule(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitParametrs_rule" ):
                listener.exitParametrs_rule(self)




    def parametrs_rule(self, parametrs):

        localctx = grammar_parserParser.Parametrs_ruleContext(self, self._ctx, self.state, parametrs)
        self.enterRule(localctx, 30, self.RULE_parametrs_rule)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 175
            self.match(grammar_parserParser.T__14)
            self.state = 176
            localctx.n1 = self.match(grammar_parserParser.NAME)
            localctx.parametrs.append((None if localctx.n1 is None else localctx.n1.text))
            self.state = 183
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==grammar_parserParser.T__18:
                self.state = 178
                self.match(grammar_parserParser.T__18)
                self.state = 179
                localctx.n2 = self.match(grammar_parserParser.NAME)
                localctx.parametrs.append(", " + (None if localctx.n2 is None else localctx.n2.text))
                self.state = 185
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 186
            self.match(grammar_parserParser.T__15)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class Code_blockContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1, code=None):
            super().__init__(parent, invokingState)
            self.parser = parser
            self.code = None
            self._CODE_TEXT = None # Token
            self.code = code

        def CODE_TEXT(self):
            return self.getToken(grammar_parserParser.CODE_TEXT, 0)

        def getRuleIndex(self):
            return grammar_parserParser.RULE_code_block

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterCode_block" ):
                listener.enterCode_block(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitCode_block" ):
                listener.exitCode_block(self)




    def code_block(self, code):

        localctx = grammar_parserParser.Code_blockContext(self, self._ctx, self.state, code)
        self.enterRule(localctx, 32, self.RULE_code_block)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 188
            localctx._CODE_TEXT = self.match(grammar_parserParser.CODE_TEXT)

            localctx.code.append((None if localctx._CODE_TEXT is None else localctx._CODE_TEXT.text))

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





