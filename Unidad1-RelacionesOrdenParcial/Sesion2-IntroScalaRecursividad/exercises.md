---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 2: Ejercicios"
---

# Unidad 1 · Sesión 2: Ejercicios

Los ejercicios de esta página se enfocan en la parte de recursividad de la [Sesión 2](index.md); los ejercicios cortos de Scala (definir y probar funciones) están señalados como **Actividad** dentro del material de estudio.

Use esta página después de leer el [material de estudio de la Sesión 2](index.md).

**1)** Obtenga $f(2), f(3), f(4)$ y $f(5)$ si $f$ se define recursivamente por $f(0) = f(1) = 1$ y para $n = 1, 2, \dots$, como:

- a) $f(n+1) = f(n) - f(n-1)$
- b) $f(n+1) = f(n)f(n-1)$
- c) $f(n+1) = f(n)^2 + f(n-1)^3$
- d) $f(n+1) = f(n)/f(n-1)$

**2)** Dé una función recursiva para la sucesión $\{a_n\}$, $n = 1,2,3,\dots$, si:

- a) $a_n = 4n - 2$
- b) $a_n = 1 + (-1)^n$
- c) $a_n = n(n+1)$
- d) $a_n = n^2$

**3)** Dé un algoritmo recursivo para calcular la suma de los $n$ primeros enteros positivos impares ($n \in \mathbb{Z}^+$).

**4)** Dé un algoritmo recursivo que calcule el máximo de un conjunto finito de enteros, y luego demuestre que es correcto.

**5)** Dé un algoritmo recursivo para calcular $nx$ para $n$ entero positivo y $x$ entero, y luego demuestre que tal algoritmo es correcto.

**6)** Escriba un algoritmo recursivo que calcule el término $n$-ésimo de la sucesión definida por $a_0 = 1$, $a_1 = 2$ y $a_n = a_{n-1} \cdot a_{n-2}$, para $n = 2,3,4,\dots$

**7)** Escriba un algoritmo recursivo que calcule el término $n$-ésimo de la sucesión definida por $a_0 = 1$, $a_1 = 2$, $a_2 = 3$, y $a_n = a_{n-1} + a_{n-2} + a_{n-3}$, para $n = 3,4,5,\dots$

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
