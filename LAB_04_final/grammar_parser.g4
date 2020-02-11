grammar grammar_parser;

@header {from LAB_04_final.src import grammar, utils}

start returns [g]
@init {
$g = grammar.Grammar()
}: program[$g] EOF;

program[g]: header[$g] imports[$g] tokens[$g] startState[$g] states[$g];

header[g]: 'grammar' NAME ';' {$g.grammar_name = $NAME.text};

imports[g]: '@imp' '{' import_line[$g]* '}';

import_line[g]: ('import' import_name {$g.add_import($import_name.name)} ';');

import_name returns[name]
@init {
$name = ""
}: n1=NAME {$name += $n1.text} ('.' n2=NAME {$name += '.' + $n2.text})*;

tokens[g]: '@tokens' '{' token_line[$g]* '}';

token_line[g] locals [has_skip]
@init {
$has_skip = False
}: NAME ':' REGEX (skip_attr {$has_skip = True})? ';' {
if ($has_skip):
    $g.add_skip_token($NAME.text, $REGEX.text)
else:
    $g.add_token($NAME.text, $REGEX.text)
};

startState[g]: '@start' '=' NAME ';' {
$g.start_state = $NAME.text
};

skip_attr : '->' 'skip';

states[g]: '@states' '{' (state_line {$g.add_state($state_line.state)}) + '}';

state_line returns [state]
@init {
$state = utils.State()
}: NAME {$state.name = $NAME.text}
('[' parameters_state[$state] ']')? ('returns' '[' returns_state[$state] ']')?
':' r1=rule_line {$state.add_rule($r1.r)} ('|' r2=rule_line {$state.add_rule($r2.r)})* ';';

parameters_state[state] : name1=NAME {$state.add_parameter($name1.text)}
                               (',' name2=NAME {$state.add_parameter($name2.text)})*;

returns_state[state] : name1=NAME {$state.returns.append($name1.text)}
                               (',' name2=NAME {$state.add_return($name2.text)})*;

rule_line returns [r] locals [parameters, code]
@init {
$r = utils.Rule()
$parameters = ""
$code = ""
}: (NAME (parameters_rule[$parameters])? (code_block[$code])?
{$r.add_item($NAME.text, $parameters, $code)
$parameters = ""
$code = ""})+;

parameters_rule[s] : '[' n1=NAME {$s+=$n1.text} (',' n2=NAME {$s += ", " + $n2.text})* ']';

code_block[s] : CODE_TEXT {
$s += $CODE_TEXT.text
$s = s[1:-1]
};

WS: [ \t\n]+ -> skip;
NAME : [a-zA-Z][a-zA-Z0-9_]*;
REGEX : '"' (~('"'))* '"';
CODE_TEXT: '#' (~('#'))+ '#';
