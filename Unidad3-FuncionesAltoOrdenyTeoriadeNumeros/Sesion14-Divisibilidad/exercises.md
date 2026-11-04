---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 14: Ejercicios"
---

# Unidad 3 · Sesión 14: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 14](index.md). Las secciones que mencionan los ejercicios son las de ese material.

## Ejercicio 1

Decida si cada afirmación es verdadera o falsa, para $d$ entero positivo y $a$, $b$ enteros. Justifique.

1. Si $d \mid a$ y $d \mid b$, entonces $d \mid (5a - 3b)$.
2. Si $d \mid 0$, entonces $d = 0$.
3. Si $d \mid (a + b)$, entonces $d \mid a$ y $d \mid b$.
4. "Divide a" es una relación de orden parcial sobre los enteros positivos.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Revise el corolario de la combinación lineal, la pregunta sobre $5 \mid 0$ de la sección 1 y los recíprocos del ejemplo 3 de la sección 2.

**Solución general.** 1 es verdadera, por el corolario. 2 es falsa: todo entero distinto de cero divide a 0. 3 es falsa: $2 \mid (3 + 5)$. 4 es verdadera: es reflexiva, antisimétrica y transitiva sobre los positivos.
:::

## Ejercicio 2

Demuestre que si $a \mid b$ y $a \mid c$, entonces $a \mid (b - c)$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba cada hipótesis como una igualdad con un entero desconocido.

**Solución general.** $b = as$ y $c = at$ dan $b - c = a(s - t)$. También sale del corolario con $m = 1$ y $n = -1$.
:::

## Ejercicio 3

Para la división de $-58$ entre 9:

1. Halle $q$ y $r$ de la división canónica.
2. Diga qué retornan `-58 / 9`, `-58 % 9` y `Math.floorMod(-58, 9)`.
3. ¿Se cumple $-58 = 9 \cdot (-6) + (-4)$? ¿Es la división canónica?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Busque el múltiplo de 9 inmediatamente por debajo de $-58$. `%` hereda el signo del dividendo.

**Solución general.** $-58 = 9 \cdot (-7) + 5$: $q = -7$ y $r = 5$. Scala retorna `-6`, `-4` y `5`. La igualdad se cumple, pero no es canónica porque $r = -4 < 0$.
:::

## Ejercicio 4

Sin dividir, decida si 8730 es divisible por 2, 3, 5, 6, 9 y 10. Después, dé un número que sea divisible por 3 y por 6, pero no por 9, y otro que sea divisible por 6 y no por 12.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use la tabla de criterios de la sección 4. Para 6, combine dos criterios.

**Solución general.** La suma de cifras es 18 y la última cifra es 0: es divisible por todos. El 12 es divisible por 3 y por 6, pero no por 9. El 18 es divisible por 6, pero no por 12.
:::

## Ejercicio 5

Muestre que **no** es cierto que "si $a \mid n$ y $b \mid n$, entonces $ab \mid n$". ¿Qué condición sobre $a$ y $b$ lo hace cierto?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Busque $a$ y $b$ con un factor común. Revise la sección 7.

**Solución general.** $4 \mid 12$ y $6 \mid 12$, pero $24 \nmid 12$. Es cierto cuando $a$ y $b$ son coprimos. En general lo que se obtiene es $\text{mcm}(a, b) \mid n$.
:::

## Ejercicio 6

Considere $n = 4900$.

1. Halle su factorización canónica.
2. ¿Cuántos factores primos tiene contando multiplicidad? ¿Cuántos distintos?
3. ¿Cuántos divisores positivos tiene?
4. ¿Es cuadrado perfecto? ¿Cubo perfecto?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use la tabla "De la factorización se leen varias cosas" de la sección 6.

**Solución general.** $4900 = 2^2 \cdot 5^2 \cdot 7^2$. Contando multiplicidad son 6, y distintos son 3. Tiene $3 \cdot 3 \cdot 3 = 27$ divisores positivos. Es cuadrado perfecto ($70^2$) y no es cubo perfecto.
:::

## Ejercicio 7

Decida si cada afirmación sobre el teorema fundamental de la aritmética es verdadera o falsa.

1. Garantiza la existencia y la unicidad, salvo el orden, de la factorización en primos.
2. Aplica a todo entero $n > 1$.
3. Da un método eficiente para decidir si un número grande es primo.
4. Implica que dos enteros mayores que 1 son iguales si y solo si tienen la misma factorización canónica.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Lea las tres precisiones de la sección 6.

**Solución general.** 1, 2 y 4 son verdaderas. 3 es falsa: el teorema afirma que la factorización existe, sin decir cómo hallarla.
:::

## Ejercicio 8

¿Es $2^{11} - 1 = 2047$ primo? Justifique con el teorema 2, indicando hasta qué primo hay que probar.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** $\sqrt{2047} \approx 45.2$. Pruebe los primos en orden.

**Solución general.** No es primo. Los primos 2, 3, 5, 7, 11, 13, 17 y 19 no lo dividen, y 23 sí: $2047 = 23 \cdot 89$.
:::

## Ejercicio 9

Demuestre que si $n$ es compuesto, existen enteros $a$ y $b$ con $1 < a \le b < n$ tales que $n = ab$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use la caracterización de compuesto de la sección 5.

**Solución general.** Existe $a$ con $a \mid n$ y $1 < a < n$. Sea $b = n/a$. Entonces $1 < b < n$, y si hace falta se intercambian los nombres para que $a \le b$.
:::

## Ejercicio 10

Demuestre que $\sqrt{2}$ es irracional usando el teorema fundamental de la aritmética.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Suponga $\sqrt{2} = p/q$ con enteros positivos y eleve al cuadrado. Cuente el exponente de 2 a cada lado.

**Solución general.** De $2q^2 = p^2$: en $p^2$ el exponente de 2 es par. En $2q^2$ es impar, porque el exponente en $q^2$ es par y se le suma 1. Por la unicidad de la factorización, no pueden ser el mismo número.
:::

## Ejercicio 11

Pruebe que si $p > 3$ es primo, entonces $24 \mid p^2 - 1$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Factorice $p^2 - 1 = (p - 1)(p + 1)$. Son dos pares consecutivos, y entre $p - 1$, $p$, $p + 1$ hay un múltiplo de 3. Como 3 y 8 son coprimos, basta ver $3 \mid p^2 - 1$ y $8 \mid p^2 - 1$.

**Solución general.** $p$ es impar, así que $p - 1$ y $p + 1$ son pares consecutivos: uno es múltiplo de 4, y el producto es múltiplo de 8. $p$ no es múltiplo de 3, así que uno de los otros dos lo es. Con $\text{mcm}(3, 8) = 24$ se concluye.
:::

## Ejercicio 12

Con $a = 2^3 \cdot 3^2 \cdot 7$ y $b = 2 \cdot 3^3 \cdot 5$:

1. Calcule $\text{mcd}(a, b)$ y $\text{mcm}(a, b)$ sin calcular $a$ ni $b$.
2. Verifique el teorema 3.
3. ¿$\text{mcd}(a, b) + \text{mcm}(a, b) = a + b$?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba los exponentes de 2, 3, 5 y 7 de cada número, con ceros donde haga falta.

**Solución general.** $\text{mcd} = 2 \cdot 3^2 = 18$, y $\text{mcm} = 2^3 \cdot 3^3 \cdot 5 \cdot 7 = 7560$. $a = 504$ y $b = 270$: $504 \cdot 270 = 136080 = 18 \cdot 7560$. La suma no se conserva: $18 + 7560 = 7578$ y $504 + 270 = 774$.
:::

## Ejercicio 13

Tres sensores reportan cada 6, 15 y 35 minutos. Si acaban de coincidir, ¿en cuántos minutos vuelven a coincidir? ¿Se cumple $6 \cdot 15 \cdot 35 = \text{mcd} \cdot \text{mcm}$?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Factorice los tres y tome exponentes máximos. Revise el ejemplo 2 de la sección 7.

**Solución general.** $\text{mcm}(6, 15, 35) = 210$ y $\text{mcd}(6, 15, 35) = 1$. El producto de los tres es $3150$, y $1 \cdot 210 = 210$. La identidad no se generaliza a tres números.
:::

## Ejercicio 14

Escriba `contarPrimos(n: Int): Int`, que retorne el número de primos menores o iguales que $n$ usando `criba`. Escriba `tau(n: Int): Int` a partir de `factorizar` y `canonica`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** `tau` multiplica $e_i + 1$ sobre las parejas $(p, e)$. Reutilice `map` y `product`.

**Solución general.** `criba(n).length` y `canonica(factorizar(n)).map { case (_, e) => e + 1 }.product`. Con $n = 360$, `tau` retorna 24.
:::

## Ejercicio 15

Un número es **perfecto** si es igual a la suma de sus divisores propios. Implemente `esPerfecto(n: Int): Boolean` y verifíquelo con 6, 28 y 496.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Reutilice `divisores`, y quite el propio $n$.

**Solución general.** `divisores(n).filter(_ != n).sum == n`. Los tres dan `true`, y `esPerfecto(12)` da `false`.
:::

## Ejercicio 16

Modifique `factorizar` para que retorne directamente `List[(Int, Int)]`, sin pasar por la lista plana de `canonica`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** En el caso `n % p == 0`, cuente con `exponente(p, n)` cuántas veces cabe $p$ y salte a $p + 1$.

**Solución general.** El caso se vuelve `(p, e) :: aux(n / potencia(p, e), p + 1)`, con `e = exponente(p, n)`. El caso `p * p > n` retorna `List((n, 1))`.
:::

## Ejercicio 17

Encuentre todas las parejas de enteros positivos $(a, b)$, con $a \le b$, tales que $\text{mcd}(a, b) = 6$ y $\text{mcm}(a, b) = 504$.
