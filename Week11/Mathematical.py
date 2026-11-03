import sympy as sp

x = sp.symbols('x')

expr = x**2 + 5*x + 6

print("Expanded:", sp.expand((x+2)*(x+3)))
print("Factorized:", sp.factor(expr))
print("Simplified:", sp.simplify(expr/(x+2)))

eq = x**2 - 5*x + 6
print("Roots:", sp.solve(eq, x))