grammar grammar_parser;

@header {from LAB_04.src.generator import grammar, utils}

start returns [g]
@init {
$g = grammar.Grammar()
}: program[$g] EOF;

program[g]: header[$g] imports[$g] tokens[$g] startState[$g] states[$g];

header[g]: 'grammar' NAME ';' {$g.setName($NAME.text)};

imports[g]: '@imp' '{' import_line[$g]* '}';

import_line[g]: ('import' import_name {$g.addImport($import_name.name)} ';');

import_name returns[name]
@init {
$name = ""
}: n1=NAME {$name += $n1.text} ('.' n2=NAME {$name += '.' + $n2.text})*;

tokens[g]: '@tokens' '{' token_line[$g]* '}';

token_line[g] locals [hasSkip]
@init {
$hasSkip = False
}: NAME ':' REGEX (skip_attr {$hasSkip = True})? ';' {
if ($hasSkip):
    $g.addSkipToken($NAME.text, $REGEX.text)
else:
    $g.addToken($NAME.text, $REGEX.text)
};

startState[g]: '@start' '=' NAME ';' {
$g.setStartState($NAME.text)
};

skip_attr : '->' 'skip';

states[g]: '@states' '{' (state_line {$g.addState($state_line.state)}) + '}';

state_line returns [state]
@init {
$state = utils.State()
}: NAME {$state.setName($NAME.text)}
('[' parameters_state[$state] ']')? ('returns' '[' returns_state[$state] ']')?
':' r1=rule_line {$state.addRule($r1.r)} ('|' r2=rule_line {$state.addRule($r2.r)})* ';';

parameters_state[state] : type1=NAME name1=NAME {$state.addParameter($type1.text, $name1.text)}
                               (',' type2=NAME name2=NAME {$state.addParameter($type2.text, $name2.text)})*;

returns_state[state] : type1=NAME name1=NAME {$state.addReturn($type1.text, $name1.text)}
                               (',' type2=NAME name2=NAME {$state.addReturn($type2.text, $name2.text)})*;

rule_line returns [r] locals [parameters, code]
@init {
$r = utils.Rule()
$parameters = ""
$code = ""
}: (NAME (parameters_rule[$parameters])? (code_block[$code])?
{$r.addItem($NAME.text, $parameters, $code)
$parameters = ""
$code = ""})+;

parameters_rule[s] : '[' n1=NAME {$s.append($n1.text)} (',' n2=NAME {$s += ", " + $n2.text})* ']';

code_block[s] : CODE_TEXT {
$s += $CODE_TEXT.text
$s = s[1:-1]
};

WS: [ \t\n]+ -> skip;
NAME : [a-zA-Z][a-zA-Z0-9_]*;
REGEX : '"' (~('"'))* '"';
CODE_TEXT: '#' (~('#'))+ '#';
