from LAB_02 import lexical_an


class LexicalAnalyzer:
    def __init__(self, inp):
        self.cur_pos = 0
        self.cur_token = ''
        self.inp = inp

    def is_end(self, pos):
        return pos >= len(self.inp)

    def get_cur_char(self):
        return self.inp[self.cur_pos]

    def is_whitespace(self, cur_char):
        return cur_char == ' ' or cur_char == '\r' or \
               cur_char == '\n' or cur_char == '\t'

    def skip_var(self):
        if self.inp[self.cur_pos:self.cur_pos + 3] == 'var' and \
                (self.is_end(self.cur_pos + 3) or self.is_whitespace(self.inp[self.cur_pos + 3])):
            self.cur_pos += 3
            return True

    def skip_array(self):
        if self.inp[self.cur_pos:self.cur_pos + 5] == 'array' and \
                (self.is_end(self.cur_pos + 5) or self.is_whitespace(self.inp[self.cur_pos + 5])):
            self.cur_pos += 5
            return True

    def skip_dotsrange(self):
        if self.inp[self.cur_pos:self.cur_pos + 2] == '..' and \
                (self.is_end(self.cur_pos + 2) or self.is_whitespace(self.inp[self.cur_pos + 2]) or self.inp[
                    self.cur_pos + 2].isdigit()):
            self.cur_pos += 2
            return True

    def skip_of(self):
        if self.inp[self.cur_pos:self.cur_pos + 2] == 'of' and \
                (self.is_end(self.cur_pos + 2) or self.is_whitespace(self.inp[self.cur_pos + 2])):
            self.cur_pos += 2
            return True

    def get_word(self):
        if self.get_cur_char().isalpha():
            while self.get_cur_char().isalpha() or self.get_cur_char().isdigit():
                self.cur_pos += 1
            return True
        return False

    def is_num(self):
        if self.get_cur_char().isdigit():
            while self.get_cur_char().isdigit():
                self.cur_pos += 1
            return True
        return False

    def skip_whitespaces(self):
        while (not self.is_end(self.cur_pos)) and self.is_whitespace(self.inp[self.cur_pos]):
            self.cur_pos += 1

    def next_token(self):
        self.skip_whitespaces()

        if self.cur_pos >= len(self.inp):
            return lexical_an.Token.END
        if self.get_cur_char() == ':':
            self.cur_pos += 1
            return lexical_an.Token.DOTS
        if self.skip_var():
            return lexical_an.Token.VAR
        if self.skip_array():
            return lexical_an.Token.ARRAY
        if self.get_cur_char() == '[':
            self.cur_pos += 1
            return lexical_an.Token.LRANGE
        if self.get_cur_char() == ']':
            self.cur_pos += 1
            return lexical_an.Token.RRANGE
        if self.skip_dotsrange():
            return lexical_an.Token.DOTSRANGE
        if self.skip_of():
            return lexical_an.Token.OF
        if self.is_num():
            return lexical_an.Token.NUM
        if self.get_cur_char() == ',':
            self.cur_pos += 1
            return lexical_an.Token.COMMA
        if self.get_cur_char() == ';':
            self.cur_pos += 1
            return lexical_an.Token.DOTCOMMA
        if self.get_word():
            return lexical_an.Token.WORD
        # print(self.inp[self.cur_pos], self.inp[self.cur_pos + 1])
        raise Exception('invalid character')


# def test_analyser():
#     t1 = 'var x: array [1..10] of integer;'
#     t2 = 'var x: array [1..10,2..20] of integer;'
#     LA1 = LexicalAnalyzer(t1)
#     LA2 = LexicalAnalyzer(t2)

#
# if __name__ == '__main__':
#     test_analyser()
