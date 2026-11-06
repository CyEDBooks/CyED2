---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 16: Ejercicios"
---

# Unidad 3 · Sesión 16: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 16](index.md). Las secciones que mencionan los ejercicios son las de ese material.

## Ejercicio 1

Trace el algoritmo de Euclides para $\text{mcd}(1547, 560)$. ¿Cuántas divisiones hace? ¿Son coprimos esos números?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba una ecuación por división. La que da residuo 0 cuenta, y es la última.

**Solución general.** $\text{mcd}(1547, 560) = 7$, con 6 divisiones. No son coprimos.
:::

## Ejercicio 2

Lleve $\dfrac{299}{391}$ a su mínima expresión con Euclides, y compruebe que el resultado tiene numerador y denominador coprimos.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Empiece dividiendo el mayor entre el menor.

**Solución general.** $\text{mcd}(391, 299) = 23$, y la fracción queda $\dfrac{13}{17}$. 13 y 17 son primos distintos.
:::

## Ejercicio 3

Decida si cada afirmación es verdadera o falsa.

1. Euclides puede dar un mcd distinto del que da la factorización, cuando los números son grandes.
2. La factorización por divisiones de prueba necesita menos divisiones que Euclides para números de 30 cifras.
3. Si $a = b > 0$, Euclides retorna $a$ en una sola división.
4. Para primos distintos $p$ y $q$, Euclides termina siempre en exactamente una división.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Revise el ejemplo 3 de la sección 2 y la tabla de la sección 3.

**Solución general.** 1 es falsa: ambos métodos son exactos. 2 es falsa: en el peor caso, $\sqrt{a}$ contra $2 \log_2 a$. 3 es verdadera. 4 es falsa: se necesitan por lo menos dos divisiones.
:::

## Ejercicio 4

Demuestre que para todo entero positivo $n$, $\text{mcd}(2n + 1, 3n + 1) = 1$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Busque una combinación lineal de los dos números en la que se cancele la $n$.

**Solución general.** $3(2n + 1) - 2(3n + 1) = 1$. Cualquier divisor común divide a 1.
:::

## Ejercicio 5

Demuestre que dos números de Fibonacci consecutivos siempre son coprimos.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Aplique el lema de la sección 1 a $F_{n+1} = F_n + F_{n-1}$, y use inducción.

**Solución general.** $\text{mcd}(F_{n+1}, F_n) = \text{mcd}(F_n, F_{n-1})$, y repitiendo se llega a $\text{mcd}(F_2, F_1) = 1$.
:::

## Ejercicio 6

Exprese $\text{mcd}(426, 37)$ como una combinación lineal: $\text{mcd}(426, 37) = \_\_ = 426 \cdot (\_\_) + 37 \cdot (\_\_)$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Son cuatro divisiones. Despeje los residuos y sustituya de abajo hacia arriba.

**Solución general.** $1 = 426 \cdot (2) + 37 \cdot (-23)$.
:::

## Ejercicio 7

Demuestre que $\text{mcd}(a, b) = 1$ si y solo si existen enteros $s$ y $t$ tales que $as + bt = 1$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Una dirección es el teorema 1. La otra es el corolario de la combinación lineal.

**Solución general.** Si $\text{mcd}(a, b) = 1$, el teorema 1 da $s$ y $t$. Si $as + bt = 1$, todo divisor común de $a$ y $b$ divide a 1.
:::

## Ejercicio 8

Demuestre que todo divisor común de $a$ y $b$ divide a $\text{mcd}(a, b)$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba el mcd como combinación lineal.

**Solución general.** Si $c \mid a$ y $c \mid b$, entonces $c$ divide a $as + bt = \text{mcd}(a, b)$.
:::

## Ejercicio 9

Encuentre el inverso de 11 módulo 26 y de 17 módulo 26 con Euclides. Exprese cada uno como residuo entre 0 y 25.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Aplique la fórmula de la sección 6. Si el coeficiente es negativo, sume 26.

**Solución general.** $\overline{11} = -7 \equiv 19$ y $\overline{17} = -3 \equiv 23 \pmod{26}$.
:::

## Ejercicio 10

Resuelva $17x \equiv 9 \pmod{26}$ y $235x \equiv 3 \pmod{37}$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use los inversos que ya conoce: el del ejercicio 9 y el del ejemplo 5 de la sección 6.

**Solución general.** $x \equiv 23 \cdot 9 = 207 \equiv 25 \pmod{26}$, y $x \equiv -17 \cdot 3 = -51 \equiv 23 \pmod{37}$.
:::

## Ejercicio 11

Demuestre la cancelación: si $ca \equiv cb \pmod{m}$ y $\text{mcd}(c, m) = 1$, entonces $a \equiv b \pmod{m}$. Dé un contraejemplo cuando $\text{mcd}(c, m) \neq 1$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Multiplique ambos lados por $\overline{c}$.

**Solución general.** $\overline{c}ca \equiv \overline{c}cb$ da $a \equiv b$. Contraejemplo: $2 \cdot 7 \equiv 2 \cdot 4 \pmod{6}$, pero $7 \not\equiv 4 \pmod{6}$.
:::

## Ejercicio 12

Sin resolver, diga cuántas soluciones módulo $m$ tiene cada congruencia. Después, resuelva las que tengan.

1. $4x \equiv 6 \pmod{10}$
2. $4x \equiv 7 \pmod{10}$
3. $12x \equiv 18 \pmod{30}$

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use el teorema 3. Divida todo entre el mcd antes de buscar el inverso.

**Solución general.** 1: $d = 2$ y $2 \mid 6$, así que hay 2 soluciones: $x \equiv 4, 9 \pmod{10}$. 2: $d = 2$ y $2 \nmid 7$: ninguna. 3: $d = 6$ y $6 \mid 18$: 6 soluciones; $2x \equiv 3 \pmod{5}$ da $x \equiv 4 \pmod{5}$, y módulo 30 son $4, 9, 14, 19, 24, 29$.
:::

## Ejercicio 13

Para el cifrado $c = (5p + 8) \;\mathbf{mod}\; 26$ de la Sesión 15, escriba la fórmula para descifrar y úsela con `UAL`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** $\text{mcd}(5, 26) = 1$. Encuentre el inverso de 5 con la fórmula de la sección 6.

**Solución general.** $\overline{5} = 21$, así que $p \equiv 21(c - 8) \pmod{26}$. `UAL` se descifra como `SOL`.
:::

## Ejercicio 14

Escriba `mcdTraza(a: Long, b: Long): List[(Long, Long, Long, Long)]`, que retorne la lista de cuádruplas $(a, b, q, r)$ de cada división, sin variables mutables.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Tiene la misma estructura de `pasos`: donde `pasos` suma 1, aquí se antepone una cuádrupla.

**Solución general.** Con `b == 0` retorna `Nil`. En otro caso, `(a, b, a / b, a % b) :: mcdTraza(b, a % b)`. Con $(287, 91)$ retorna tres cuádruplas.
:::

## Ejercicio 15

Escriba `mcdLista(xs: List[Long]): Long`, que calcule el mcd de una lista no vacía con un método de alto orden.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** $\text{mcd}(a, b, c) = \text{mcd}(\text{mcd}(a, b), c)$. Compare con `reduceLeft` de la Sesión 13.

**Solución general.** `xs.reduceLeft(mcd)`. Con `List(12, 18, 30)` retorna 6.
:::

## Ejercicio 16

Encuentre el inverso de 9 módulo 32.
