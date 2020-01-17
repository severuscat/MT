from LAB_02 import lexical_analyzer
from LAB_02 import lexical_an


# t1 = 'var x: array [1..10] of integer;'
# t2 = 'var x: array [1..10, 2..20] of integer;'

class Tree():
    node = ''
    children = []

    def __init__(self, node):
        self.node = node
        self.children = []

    def add_child(self, child):
        self.children.append(child)

    def to_string(self, mask):
        res = ''
        if (len(mask)) > 0:
            res = res + "|__"
        res = res + self.node + '\n'
        for curChild in range(len(self.children)):
            for i in mask:
                if i != 0:
                    res = res + "|     "
                else:
                    res = res + '     '
            res += self.children[curChild].to_string(mask + [curChild != len(self.children) - 1])
        return res


def check_next_token(expected, la):
    actual = la.next_token()
    if expected != actual:
        raise Exception("parse error")


def S(la):
    tree = Tree('ARRAY_DESCR')
    check_next_token(lexical_an.Token.VAR, la)
    tree.add_child(Tree('var'))
    check_next_token(lexical_an.Token.WORD, la)
    tree.add_child(Tree('word'))
    check_next_token(lexical_an.Token.DOTS, la)
    tree.add_child(Tree('dots'))
    check_next_token(lexical_an.Token.ARRAY, la)
    tree.add_child(Tree('array'))
    # check_next_token(lexical_an.Token.LRANGE, la)
    # tree.add_child(Tree('lbr'))
    # tree.add_child(R(la))
    # tree.add_child(Tree('rbr'))
    # check_next_token(lexical_an.Token.OF, la)
    # tree.add_child(Tree('of'))
    # check_next_token(lexical_an.Token.WORD, la)
    # tree.add_child(Tree('word'))
    tree.add_child(A(la))
    check_next_token(lexical_an.Token.DOTCOMMA, la)
    tree.add_child(Tree('dotcomma'))
    check_next_token(lexical_an.Token.END, la)
    tree.add_child(Tree('end'))
    return tree


def A(la):
    tree = Tree('ARR_OF')
    check_next_token(lexical_an.Token.LRANGE, la)
    tree.add_child(Tree('lbr'))
    tree.add_child(R(la))
    tree.add_child(Tree('rbr'))
    check_next_token(lexical_an.Token.OF, la)
    tree.add_child(Tree('of'))
    tree.add_child(A1(la))
    return tree


def A1(la):
    tree = Tree('ARR_OF1')
    cur_token = la.next_token()
    if cur_token == lexical_an.Token.ARRAY:
        tree.add_child(Tree('array'))
        tree.add_child(A(la))
        return tree
    elif cur_token == lexical_an.Token.WORD:
        tree.add_child(Tree('word'))
        return tree
    else:
        raise Exception("parse error")


def R(la):
    this_node = Tree('RANGE')
    check_next_token(lexical_an.Token.NUM, la)
    this_node.add_child(Tree('num'))
    check_next_token(lexical_an.Token.DOTSRANGE, la)
    this_node.add_child(Tree('dotsrange'))
    check_next_token(lexical_an.Token.NUM, la)
    this_node.add_child(Tree('num'))
    this_node.add_child(R1(la))
    return this_node


def R1(la):
    this_node = Tree('RANGE1')
    cur_token = la.next_token()
    if cur_token == lexical_an.Token.COMMA:
        this_node.add_child(Tree('comma'))
        this_node.add_child(R(la))
        return this_node
    elif cur_token == lexical_an.Token.RRANGE:
        this_node.add_child(Tree('eps'))
        return this_node
    else:
        raise Exception("parse error")


def build_tree(array_descr):
    la = lexical_analyzer.LexicalAnalyzer(array_descr)
    tree = S(la)
    return tree


def test(descr):
    print(descr)
    print(build_tree(descr).to_string([]))


if __name__ == '__main__':
    test('var x: array [1..10, 2..20] of array [5..500] of integer;')
    # test('\nvar x: array [1..10, 2..20,3..30,    \t 4..40] of integer;')
