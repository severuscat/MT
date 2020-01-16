from enum import Enum


class Token(Enum):
    BEG = 'begin'
    VAR = 'var'
    WORD = 'WORD'
    DOTS = ':'
    ARRAY = 'array'
    LRANGE = '['
    RRANGE = ']'
    NUM = 'NUM'
    DOTSRANGE = '..'
    OF = 'of'
    COMMA = ','
    END = '##'
    UNKNOWN = 'UNKNOWN TOKEN'
    DOTCOMMA = ';'
