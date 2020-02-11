from LAB_04_final.src.gen.calculator.CalculatorToken import Calculator_Token
import re

class Calculatorlexer:
	def __init__(self, inp):
		self.inp = inp
		self.token_patterns = list()
		self.skip_token_patterns = list()
		self.tokens = list()
		self.tokens_to_string = list()
		self.cur_pos = 0
		self.token_patterns.append(TokenItem(Calculator_Token.LP, "[(]"))
		self.token_patterns.append(TokenItem(Calculator_Token.RP, "[)]"))
		self.token_patterns.append(TokenItem(Calculator_Token.PLUS, "\\+"))
		self.token_patterns.append(TokenItem(Calculator_Token.MINUS, "-"))
		self.token_patterns.append(TokenItem(Calculator_Token.MUL, "\\*"))
		self.token_patterns.append(TokenItem(Calculator_Token.NUMBER, "[1-9]+[0-9]*|0"))
		self.get_tokens()


	def get_current_token(self):
		return self.tokens[self.cur_pos]

	def get_current_token_str(self):
		return self.tokens_to_string[self.cur_pos]

	def get_next_token(self):
		self.cur_pos += 1
		return self.tokens[self.cur_pos]

	def get_tokens(self):
		while len(self.inp) != 0:
			t = self.find_first_token()
			if t is not None:
				self.tokens.append(t)
			elif not self.find_first_skip_token():
				raise Exception("NO MATCING WITH TOKENS")

		self.tokens.append(Calculator_Token._END)
	def find_first_skip_token(self):
		for item in self.skip_token_patterns:
			m = re.match(item.pattern, self.inp)
			if m is not None:
				self.inp = self.inp[m.end():]
				return True
		return False

	def find_first_token(self):
		for item in self.token_patterns:
			m = re.match(item.pattern, self.inp)
			if m is not None:
				self.tokens_to_string.append(self.inp[0:m.end()])
				self.inp = self.inp[m.end():]
				return item.token
		return None

class TokenItem:
	token = Calculator_Token()
	pattern = r''

	def __init__(self, token, s):
		self.token = token
		self.pattern = re.compile(s)


# ======= TEST ========
# if __name__ == '__main__':
	# cl = Calculatorlexer('1+10')
	# print(cl.tokens)
