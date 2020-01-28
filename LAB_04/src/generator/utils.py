class State:
    name = ''
    parameters = [] # list of str
    returns = [] # list of str
    rules = [] # list of rules
    first = set() # set of str
    follow = set() # set of str
    hasEpsilon = False

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def addParameter(self, type, name):
        res = type + " " + name
        self.parameters.append(res)


    def addReturn(self, type, name):
        res = type + " " + name
        self.returns.append(res)

    def addRule(self, r):
        self.rules.append(r)
        if (r.items.size() == 1 and r.items.get(0).equals("EPS")):
            self.hasEpsilon = True


    def getFirst(self):
        return self.first

    def addToFirst(self, item):
        if (item.equals("EPS")):
            self.hasEpsilon = True
        if (item in self.first):
            return False
        return self.first.add(item)

    def addToFollow(self, item):
        if (item in self.follow):
            return False
        return self.follow.add(item)

    def getFollow(self):
        return self.follow

    def getParameters(self):
        return self.parameters

    def getReturns(self)
        return self.returns

class Rule:
    items = []
    parameters = []
    actions = []

    def addItem(self, s, parameter, action):
        self.items.append(s)
        self.parameters.append(parameter)
        self.actions.append(action)


class TokenItem:
    name = ''
    pattern = ''
    def __init__(self, name, pattern):
        self.name = name
        self.pattern = pattern