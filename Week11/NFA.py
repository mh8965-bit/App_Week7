from automata.fa.nfa import NFA

nfa = NFA(
    states={'q0', 'q1', 'q2'},
    input_symbols={'a', 'b'},
    transitions={
        'q0': {'a': {'q0', 'q1'}, 'b': {'q0'}},
        'q1': {'b': {'q2'}},
        'q2': {'a': {'q2'}, 'b': {'q2'}}
    },
    initial_state='q0',
    final_states={'q2'}
)

tests = ['ab', 'aab', 'bab', 'aba', 'aaa', 'bbb']

for s in tests:
    if nfa.accepts_input(s):
        print(s, "Accepted")
    else:
        print(s, "Rejected")