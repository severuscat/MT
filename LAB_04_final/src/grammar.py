from LAB_04_final.src.utils import *


class Grammar:
    def __init__(self):
        self.grammar_name = ''
        self.start_state = ''
        self.token_items = dict()  # str, tokenItem
        self.states = dict()  # str, state
        self.tokens = list()  # tokenItems
        self.skip_tokens = list()  # tokenItems

        self.imports = list() # str

    def add_import(self, import_line):
        self.imports.append(import_line)

    def add_token(self, token_name, pattern):
        item = TokenItem(token_name, pattern)
        self.tokens.append(item)
        if token_name in self.token_items:
            raise Exception("DUPLICATE TOKEN NaME")
        self.token_items.update({token_name: item})

    def add_skip_token(self, token_name, pattern):
        item = TokenItem(token_name, pattern)
        self.skip_tokens.append(item)
        if token_name in self.token_items:
            raise Exception("DUPLICATE TOKEN NaME")
        self.token_items.update({token_name: item})

    def add_state(self, s):
        self.states.update({s.name: s})

    def construct_first(self):
        changed = True
        while changed:
            changed = False
            for state in self.states.values():
                print(state.parametrs)
                for rule in state.rules:
                    for item in rule.items:

                        print(state.name, item)

                        if item == 'EPS':
                            if state.add_to_first(item):
                                changed = True
                        elif item in self.token_items.keys():
                            if state.add_to_first(item):
                                changed = True
                            break
                        elif item in self.states.keys():
                            st = self.states[item]
                            # print(3)
                            for new_item in st.first:
                                if state.add_to_first(new_item):
                                    changed = True
                            if not st.has_eps:
                                break
                        else:
                            raise Exception("UNKNOWN STATE NAME in " + state.name)

    def construct_follow(self):
        start = self.states[self.start_state]
        start.add_to_follow('_END')
        changed = True
        while changed:
            changed = False
            for state in self.states.values():
                for rule in state.rules:
                    cur_gamma_first = set()
                    cur_gamma_first.add("_END")
                    for i in range(len(rule.items) - 1, -1, -1):
                        item = rule.items[i]
                        if item == "EPS":
                            cur_gamma_first.add("EPS")
                            continue
                        if item in self.token_items.keys():
                            cur_gamma_first.clear()
                            cur_gamma_first.add(item)
                            continue
                        if item in self.states.keys():
                            st = self.states[item]
                            for s in cur_gamma_first:
                                if s != "EPS":
                                    if st.add_to_follow(s):
                                        changed = True
                            if '_END' in cur_gamma_first:
                                for s in state.follow:
                                    if st.add_to_follow(s):
                                        changed = True
                            if (not st.has_eps):
                                cur_gamma_first.clear()
                            cur_gamma_first.union(st.first)
                        else:
                            raise Exception("UNKNOWN STATE NAME {}(((".format(state.name))

    def first_for_rule(self, r):
        first = set()  # str
        for item in r.items:
            if item == "EPS":
                first.add("EPS")
            elif item in self.token_items.keys():
                first.add(item)
                break
            elif item in self.states.keys():
                first.union(self.states[item].first)
                if "EPS" not in first:
                    break
        return first

# if __name__ == '__main__':
#     g = Grammar()
#     g.add_token('1111', '1111')
#     print(g.tokens)
#     g.add_token('222', '222')
#     print(g.tokens)
