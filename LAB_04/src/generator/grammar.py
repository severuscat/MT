import sys

from LAB_04.src.generator import utils


class Grammar:
    grammarName = ''
    startState = ''
    tokenItems = dict()  # mapka
    states = dict()
    tokens = list()
    skipTokens = list()
    imports = list()

    def addImport(self, s):
        self.imports.append(s)

    def setName(self, s):
        self.grammarName = s

    def setStartState(self, s):
        self.startState = s

    def addToken(self, tokenName, pattern):
        item = utils.TokenItem(tokenName, pattern)
        self.tokens.append(item)
        if tokenName in self.tokenItems:
            sys.stderr.write("Duplicate token name.")
            sys.exit(-1)
        self.tokenItems.update({tokenName, item})

    def addSkipToken(self, tokenName, pattern):
        item = utils.TokenItem(tokenName, pattern)
        self.skipTokens.append(item)
        if tokenName in self.tokenItems:
            sys.stderr.write("Duplicate token name.")
            sys.exit(-1)
        self.tokenItems[tokenName] = item

    def showTokens(self):
        print(self.grammarName)
        print("TOKENS")
        for item in self.tokens:
            print("Key: {0}  Value: {1} \n".format(item.name, item.pattern))

        print("SKIP TOKENS")
        for item in self.skipTokens:
            print("Key: {0}  Value: {1} \n".format(item.name, item.pattern))

    def addState(self, s):
        self.states[s.getName()] = s

    def constructFirst(self):
        changed = True
        while (changed):
            changed = False
            for state in self.states.values():
                for rule in state.rules:
                    for item in rule.items:
                        if item.equals("EPS"):
                            if state.addToFirst(item):
                                changed = True
                        elif item in self.tokenItems:
                            if state.addToFirst(item):
                                changed = True
                            break
                        elif item in self.states:
                            st = self.states.get(item)
                            for newItem in st.getFirst():
                                if state.addToFirst(newItem):
                                    changed = True
                            if not st.hasEpsilon:
                                break
                        else:
                            sys.stderr.write("Unknown state name in " + state.getName() + ".")
                            sys.exit(-1)

    def showFirst(self):
        print("---FIRST---")
        for state in self.states.values():
            print(state.getName() + " : " + state.getFirst().toString())

    def constructFollow(self):
        start = self.states.get(self.startState)
        start.addToFollow("_END")
        changed = True
        while (changed):
            changed = False
            for self.state in self.states.values():
                for rule in self.state.rules:
                    cur_gamma_first = set()
                    cur_gamma_first.add("_END")
                    for i in range(rule.items.size() - 1, 0, -1):
                        item = rule.items.get(i)
                        if item == "EPS":
                            cur_gamma_first.add("EPS")
                            continue
                        if item in self.tokenItems:
                            cur_gamma_first.clear()
                            cur_gamma_first.add(item)
                            continue
                        if item in self.states:
                            st = self.states.get(item)
                            for s in cur_gamma_first:
                                if not s == "EPS":
                                    if st.addToFollow(s):
                                        changed = True
                            if "_END" in cur_gamma_first:
                                for s in self.state.getFollow():
                                    if st.addToFollow(s):
                                        changed = True
                            if not st.hasEpsilon:
                                cur_gamma_first.clear()
                            cur_gamma_first.union(st.getFirst())
                        else:
                            sys.stderr.write("Unknown state name " + item + " in " + self.state.getName() + ".")
                            sys.exit(-1)

    def showFollow(self):
        print("---FOLLOW---")
        for state in self.states.values():
            print(state.getName() + " : " + state.getFollow().toString())

    def firstForRule(self, r):
        first = set()
        for item in r.items:
            if item == "EPS":
                first.add("EPS")
            elif item in self.tokenItems:
                first.add(item)
                break
            elif item in self.states:
                first.union(self.states.get(item).getFirst())
                if not ("EPS" in first):
                    break
        return first
