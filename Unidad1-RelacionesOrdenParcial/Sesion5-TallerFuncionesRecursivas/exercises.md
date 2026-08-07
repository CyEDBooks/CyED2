---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 5: Ejercicios"
---

# Unidad 1 · Sesión 5: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 5](index.md).

A continuación encontrará unas definiciones recursivas; para cada una de ellas, desarrolle una o más funciones en Scala usando el IDE o entorno de programación de su preferencia.

**1)**

$$
x^n =
\begin{cases}
1 & \text{si } n=0 \\
x \cdot x^{\mathrm{pred}(n)} & \text{para } n>0
\end{cases}
$$

**2)**

$$
n! =
\begin{cases}
1 & \text{si } n=0 \\
n \cdot (\mathrm{pred}(n))! & \text{para } n>0
\end{cases}
$$

**3)**

$$
\Sigma(n) =
\begin{cases}
n & \text{si } n=0 \\
n + \Sigma(\mathrm{pred}(n)) & \text{para } n>0
\end{cases}
$$

**4)**

$$
\mathrm{suma}(x,y) =
\begin{cases}
y & \text{si } x = 0 \\
\mathrm{suc}(\,\mathrm{suma}(\mathrm{pred}(x), y)\,) & \text{si } x > 0
\end{cases}
$$

**5)** Proponga una función similar a la anterior que calcule la diferencia (llámela `dif`) entre dos números naturales.

**6)**

$$
\mathrm{prod}(x,y) =
\begin{cases}
0 & \text{si } x = 0 \\
1 & \text{si } x = 1 \\
\mathrm{suma}(y, \mathrm{prod}(\mathrm{pred}(x), y)) & \text{si } x > 0
\end{cases}
$$

**7)** Proponga una función similar a la anterior que calcule la división.

**8)**

$$
\mathrm{modulo}(m,n) =
\begin{cases}
m & \text{si } m<n \\
\mathrm{modulo}(\,\mathrm{dif}(m,n),\, n) & \text{si } m \geq n
\end{cases}
$$

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
