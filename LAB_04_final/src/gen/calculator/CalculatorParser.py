from LAB_04_final.src.gen.calculator.CalculatorToken import *
from LAB_04_final.src.gen.calculator import CalculatorLexicalAnalyzer

class Node:
	def __init__(self, name=None):
		self.name = '' if name is None else name
		self.children = list() # Nodes

	def add_child(self, node):
		self.children.append(node)

	def tree_to_string(self, mask=None):
		mask = list() if mask is None else mask
		s = ''
		if len(mask) != 0:
			s += "|__"
		s += self.name + '\n'
		for cur_child in range(len(self.children)):
			for b in mask:
				if b:
					s += "|  "
				else:
					s += "   "
			s += self.children[cur_child].tree_to_string(mask + [cur_child != len(self.children) - 1])
		return s


def exp():
	raise Exception("UNEXPECTED TOKEN")

class Node_E(Node):
	def __init__(self):
		super().__init__('E')
		self.v = None

class Node_G(Node):
	def __init__(self):
		super().__init__('G')
		self.v = None

class Node_T(Node):
	def __init__(self):
		super().__init__('T')
		self.v = None

class Node_H(Node):
	def __init__(self):
		super().__init__('H')
		self.v = None

class Node_F(Node):
	def __init__(self):
		super().__init__('F')
		self.v = None

class Node_PlusOp(Node):
	def __init__(self):
		super().__init__('PlusOp')
		self.v = None

class Node_MinusOp(Node):
	def __init__(self):
		super().__init__('MinusOp')
		self.v = None

class Node_MulOp(Node):
	def __init__(self):
		super().__init__('MulOp')
		self.v = None

class CalculatorParser:
	def __init__(self, lexer):
		self.lexer = lexer
		self.tree = Node()
		self.build_tree()

	def build_tree(self):
		self.tree = self._E()
		if self.lexer.get_current_token() != Calculator_Token._END:
			raise Exception("_END EXPECTED, " + self.lexer.get_current_token() + " FOUND")

	def print_tree(self):
		print(self.tree.tree_to_string())

	def get_v(self):
		return self.tree.v

	def consume(self, token):
		if self.lexer.get_current_token() != token:
			raise Exception("EXPECTED ANOTHER TOKEN")

	def _E(self):
		res = Node_E()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
			pass
		elif c_t == Calculator_Token.MINUS:
			pass
		elif c_t == Calculator_Token.LP:
			pass
		elif c_t == Calculator_Token.NUMBER:
			n0 = self._T()
			res.add_child(n0)
			u = n0.v
			n1 = self._G(u)
			res.add_child(n1)
			res.v = n1.v
			return res
		else:
			exp()
		return res

	def _G(self, a):
		res = Node_G()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
		elif c_t == Calculator_Token._END:
			pass
		elif c_t == Calculator_Token.RP:
			res.v = a
			return res
			pass
		elif c_t == Calculator_Token.PLUS:
			self.consume(Calculator_Token.PLUS)
			res.add_child(Node("PLUS"))
			
			self.lexer.get_next_token()

			n0 = self._T()
			res.add_child(n0)
			u = n0.v
			n1 = self._PlusOp(a, u)
			res.add_child(n1)
			acc = n1.v
			n2 = self._G(acc)
			res.add_child(n2)
			res.v = n2.v
			return res
			pass
		elif c_t == Calculator_Token.MINUS:
			self.consume(Calculator_Token.MINUS)
			res.add_child(Node("MINUS"))
			
			self.lexer.get_next_token()

			n0 = self._T()
			res.add_child(n0)
			u = n0.v
			n1 = self._MinusOp(a, u)
			res.add_child(n1)
			acc = n1.v
			n2 = self._G(acc)
			res.add_child(n2)
			res.v = n2.v
			return res
		else:
			exp()
		return res

	def _T(self):
		res = Node_T()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
			pass
		elif c_t == Calculator_Token.MINUS:
			pass
		elif c_t == Calculator_Token.LP:
			pass
		elif c_t == Calculator_Token.NUMBER:
			n0 = self._F()
			res.add_child(n0)
			u = n0.v
			n1 = self._H(u)
			res.add_child(n1)
			res.v = n1.v
			return res
		else:
			exp()
		return res

	def _H(self, a):
		res = Node_H()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
		elif c_t == Calculator_Token.MINUS:
			pass
		elif c_t == Calculator_Token._END:
			pass
		elif c_t == Calculator_Token.RP:
			pass
		elif c_t == Calculator_Token.PLUS:
			res.v = a
			return res
			pass
		elif c_t == Calculator_Token.MUL:
			self.consume(Calculator_Token.MUL)
			res.add_child(Node("MUL"))
			
			self.lexer.get_next_token()

			n0 = self._F()
			res.add_child(n0)
			u = n0.v
			n1 = self._MulOp(a, u)
			res.add_child(n1)
			acc = n1.v
			n2 = self._H(acc)
			res.add_child(n2)
			res.v = n2.v
			return res
		else:
			exp()
		return res

	def _F(self):
		res = Node_F()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
			pass
		elif c_t == Calculator_Token.NUMBER:
			self.consume(Calculator_Token.NUMBER)
			res.add_child(Node("NUMBER"))
			res.v = int(self.lexer.get_current_token_str())
			self.lexer.get_next_token()

			return res
			pass
		elif c_t == Calculator_Token.MINUS:
			self.consume(Calculator_Token.MINUS)
			res.add_child(Node("MINUS"))
			
			self.lexer.get_next_token()

			n0 = self._F()
			res.add_child(n0)
			res.v = -(n0.v)
			return res
			pass
		elif c_t == Calculator_Token.LP:
			self.consume(Calculator_Token.LP)
			res.add_child(Node("LP"))
			
			self.lexer.get_next_token()

			n0 = self._E()
			res.add_child(n0)
			res.v = n0.v
			self.consume(Calculator_Token.RP)
			res.add_child(Node("RP"))
			
			self.lexer.get_next_token()

			return res
		else:
			exp()
		return res

	def _PlusOp(self, a, b):
		res = Node_PlusOp()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
		elif c_t == Calculator_Token.MINUS:
			pass
		elif c_t == Calculator_Token._END:
			pass
		elif c_t == Calculator_Token.RP:
			pass
		elif c_t == Calculator_Token.PLUS:
			res.v = a + b
			return res
		else:
			exp()
		return res

	def _MinusOp(self, a, b):
		res = Node_MinusOp()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
		elif c_t == Calculator_Token.MINUS:
			pass
		elif c_t == Calculator_Token._END:
			pass
		elif c_t == Calculator_Token.RP:
			pass
		elif c_t == Calculator_Token.PLUS:
			res.v = a - b
			return res
		else:
			exp()
		return res

	def _MulOp(self, a, b):
		res = Node_MulOp()
		c_t = self.lexer.get_current_token()
		if c_t == '':
			pass
		elif c_t == Calculator_Token.MINUS:
			pass
		elif c_t == Calculator_Token._END:
			pass
		elif c_t == Calculator_Token.MUL:
			pass
		elif c_t == Calculator_Token.RP:
			pass
		elif c_t == Calculator_Token.PLUS:
			res.v = a * b
			return res
		else:
			exp()
		return res

