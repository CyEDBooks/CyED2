---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 4: Ejercicios"
---

# Unidad 1 · Sesión 4: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 4](index.md).

## Ejercicio en clase

Para el siguiente fragmento de código en Scala:

```scala
def funcion(x: Int, y: Int, n: Int): Int =
  if (x > n) y else funcion(x + 1, x * y, n)

def misterio(n: Int) = funcion(1, 1, n)

misterio(4)
```

Aplique la regla de evaluación paso a paso e indique el valor que se produce al evaluar la expresión `misterio(4)`.

## Ejercicios propuestos

**1) Recursión de naturales.** Implemente en Scala una función recursiva `sumaDigitos(n: Int): Int` que calcule la suma de los dígitos de un número natural `n` (por ejemplo, `sumaDigitos(1234)` debe devolver `10`). Utilice únicamente condicionales (`if`/`else`) y recursión, sin reconocimiento de patrones.

**2) Listas.** Implemente en Scala una función recursiva `contarPares(xs: List[Int]): Int` que cuente cuántos elementos pares hay en una lista de enteros `xs`. Utilice únicamente `head`, `tail` e `isEmpty`, sin reconocimiento de patrones.

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
