# Generated from grammar_parser.g4 by ANTLR 4.8
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys

from LAB_04_final.src import grammar, utils


def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31")
        buf.write("\u009f\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7")
        buf.write("\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r")
        buf.write("\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\4\23")
        buf.write("\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30")
        buf.write("\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3")
        buf.write("\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b")
        buf.write("\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13")
        buf.write("\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16")
        buf.write("\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17")
        buf.write("\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22")
        buf.write("\3\22\3\23\3\23\3\24\3\24\3\25\6\25\u0082\n\25\r\25\16")
        buf.write("\25\u0083\3\25\3\25\3\26\3\26\7\26\u008a\n\26\f\26\16")
        buf.write("\26\u008d\13\26\3\27\3\27\7\27\u0091\n\27\f\27\16\27\u0094")
        buf.write("\13\27\3\27\3\27\3\30\3\30\6\30\u009a\n\30\r\30\16\30")
        buf.write("\u009b\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t")
        buf.write("\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23")
        buf.write("%\24\'\25)\26+\27-\30/\31\3\2\7\4\2\13\f\"\"\4\2C\\c|")
        buf.write("\6\2\62;C\\aac|\3\2$$\3\2%%\2\u00a2\2\3\3\2\2\2\2\5\3")
        buf.write("\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2")
        buf.write("\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2")
        buf.write("\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2")
        buf.write("\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2")
        buf.write("\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3")
        buf.write("\2\2\2\59\3\2\2\2\7;\3\2\2\2\t@\3\2\2\2\13B\3\2\2\2\r")
        buf.write("D\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23U\3\2\2\2\25W\3\2")
        buf.write("\2\2\27^\3\2\2\2\31`\3\2\2\2\33c\3\2\2\2\35h\3\2\2\2\37")
        buf.write("p\3\2\2\2!r\3\2\2\2#t\3\2\2\2%|\3\2\2\2\'~\3\2\2\2)\u0081")
        buf.write("\3\2\2\2+\u0087\3\2\2\2-\u008e\3\2\2\2/\u0097\3\2\2\2")
        buf.write("\61\62\7i\2\2\62\63\7t\2\2\63\64\7c\2\2\64\65\7o\2\2\65")
        buf.write("\66\7o\2\2\66\67\7c\2\2\678\7t\2\28\4\3\2\2\29:\7=\2\2")
        buf.write(":\6\3\2\2\2;<\7B\2\2<=\7k\2\2=>\7o\2\2>?\7r\2\2?\b\3\2")
        buf.write("\2\2@A\7}\2\2A\n\3\2\2\2BC\7\177\2\2C\f\3\2\2\2DE\7k\2")
        buf.write("\2EF\7o\2\2FG\7r\2\2GH\7q\2\2HI\7t\2\2IJ\7v\2\2J\16\3")
        buf.write("\2\2\2KL\7\60\2\2L\20\3\2\2\2MN\7B\2\2NO\7v\2\2OP\7q\2")
        buf.write("\2PQ\7m\2\2QR\7g\2\2RS\7p\2\2ST\7u\2\2T\22\3\2\2\2UV\7")
        buf.write("<\2\2V\24\3\2\2\2WX\7B\2\2XY\7u\2\2YZ\7v\2\2Z[\7c\2\2")
        buf.write("[\\\7t\2\2\\]\7v\2\2]\26\3\2\2\2^_\7?\2\2_\30\3\2\2\2")
        buf.write("`a\7/\2\2ab\7@\2\2b\32\3\2\2\2cd\7u\2\2de\7m\2\2ef\7k")
        buf.write("\2\2fg\7r\2\2g\34\3\2\2\2hi\7B\2\2ij\7u\2\2jk\7v\2\2k")
        buf.write("l\7c\2\2lm\7v\2\2mn\7g\2\2no\7u\2\2o\36\3\2\2\2pq\7]\2")
        buf.write("\2q \3\2\2\2rs\7_\2\2s\"\3\2\2\2tu\7t\2\2uv\7g\2\2vw\7")
        buf.write("v\2\2wx\7w\2\2xy\7t\2\2yz\7p\2\2z{\7u\2\2{$\3\2\2\2|}")
        buf.write("\7~\2\2}&\3\2\2\2~\177\7.\2\2\177(\3\2\2\2\u0080\u0082")
        buf.write("\t\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083")
        buf.write("\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2")
        buf.write("\u0085\u0086\b\25\2\2\u0086*\3\2\2\2\u0087\u008b\t\3\2")
        buf.write("\2\u0088\u008a\t\4\2\2\u0089\u0088\3\2\2\2\u008a\u008d")
        buf.write("\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c")
        buf.write(",\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0092\7$\2\2\u008f")
        buf.write("\u0091\n\5\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2")
        buf.write("\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3")
        buf.write("\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7$\2\2\u0096.\3")
        buf.write("\2\2\2\u0097\u0099\7%\2\2\u0098\u009a\n\6\2\2\u0099\u0098")
        buf.write("\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b")
        buf.write("\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7%\2\2")
        buf.write("\u009e\60\3\2\2\2\7\2\u0083\u008b\u0092\u009b\3\b\2\2")
        return buf.getvalue()


class grammar_parserLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    T__3 = 4
    T__4 = 5
    T__5 = 6
    T__6 = 7
    T__7 = 8
    T__8 = 9
    T__9 = 10
    T__10 = 11
    T__11 = 12
    T__12 = 13
    T__13 = 14
    T__14 = 15
    T__15 = 16
    T__16 = 17
    T__17 = 18
    T__18 = 19
    WS = 20
    NAME = 21
    REGEX = 22
    CODE_TEXT = 23

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'grammar'", "';'", "'@imp'", "'{'", "'}'", "'import'", "'.'", 
            "'@tokens'", "':'", "'@start'", "'='", "'->'", "'skip'", "'@states'", 
            "'['", "']'", "'returns'", "'|'", "','" ]

    symbolicNames = [ "<INVALID>",
            "WS", "NAME", "REGEX", "CODE_TEXT" ]

    ruleNames = [ "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", 
                  "T__7", "T__8", "T__9", "T__10", "T__11", "T__12", "T__13", 
                  "T__14", "T__15", "T__16", "T__17", "T__18", "WS", "NAME", 
                  "REGEX", "CODE_TEXT" ]

    grammarFileName = "grammar_parser.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.8")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


