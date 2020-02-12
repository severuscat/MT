class Rule:
    def __init__(self):
        self.items = list()  # strings
        self.parametrs = list()  # strings
        self.actions = list()  # strings

    def add_item(self, s, param, action):
        self.items.append(s)
        self.parametrs.append(param)
        self.actions.append(action)
        # print("\nADD: ", self.items, self.parametrs, self.actions)


class State:
    def __init__(self):
        self.name = ""
        self.parametrs = list()  # strings
        self.returns = list()
        self.rules = list()  # of Rule
        self.first = set()  # str
        self.follow = set()  # str
        self.has_eps = False

    def add_rule(self, rule):
        self.rules.append(rule)
        # print('ADD RULE: .... ', self.name, rule.items, rule.parametrs, rule.actions)
        if len(rule.items) == 1 and rule.items[0] == 'EPS':
            self.has_eps = True

    def add_parameter(self, name):
        # print('ADD PARAM: ....', self.name, name)
        self.parametrs.append(name)

    def add_to_first(self, item):
        if item == 'EPS':
            self.has_eps = True
        if item in self.first:
            return False
        self.first.add(item)
        return True

    def add_to_follow(self, item):
        if item in self.follow:
            return False
        self.follow.add(item)
        return True


class TokenItem:
    def __init__(self, name, pattern):
        self.name = name
        self.pattern = pattern


def print_string(text, tabs):
    return '\t' * tabs + text + '\n'
