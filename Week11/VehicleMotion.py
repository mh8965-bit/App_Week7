import sympy as sp

t = sp.symbols('t')

s = t**3 - 6*t**2 + 9*t + 5

v = sp.diff(s, t)
a = sp.diff(v, t)

print("Displacement:", s)
print("Velocity:", v)
print("Acceleration:", a)

print("Vehicle at rest:", sp.solve(v, t))

d = sp.integrate(v, (t, 0, 2))
print("Displacement from 0 to 2:", d)