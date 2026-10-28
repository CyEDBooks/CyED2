---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 12: Ejercicios"
---

# Unidad 3 · Sesión 12: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 12](index.md). Las secciones que mencionan los ejercicios son las de ese material.

## Ejercicio 1

Escriba una función de alto orden `producto`, análoga a `suma`, que calcule

$$
\prod_{i=a}^{b} f(i) = f(a) \cdot f(\mathit{prox}(a)) \cdots
$$

Defina `factorial` en términos de `producto`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Copie `suma` y cambie dos cosas: el operador y el valor del caso base. ¿Qué número no altera un producto?

**Solución general.** El caso base devuelve `1` y la rama recursiva calcula `f(a) * producto(f, prox, prox(a), b)`. `factorial(n) = producto(x => x, x => x + 1, 1, n)`; `factorial(5) = 120`.
:::

## Ejercicio 2

Escriba una función `acumular` que generalice `suma` y `producto`. Después escriba `suma` y `producto` como llamados a `acumular`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Compare `suma` y `producto` y liste lo que cambia: el operador que combina y el valor neutro. Esos dos son los parámetros nuevos. El operador es una función de tipo `(Int, Int) => Int`.

**Solución general.** `acumular(combinar, neutro, f, prox, a, b)` devuelve `neutro` si `a > b` y si no `combinar(f(a), acumular(combinar, neutro, f, prox, prox(a), b))`. `suma` es `acumular(_ + _, 0, …)` y `producto` es `acumular(_ * _, 1, …)`.
:::

## Ejercicio 3

`suma` genera un proceso recursivo lineal: la suma `f(a) + …` queda pendiente en cada llamado. Escriba una versión que genere un proceso iterativo, recursiva de cola y anotada con `@tailrec`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use una función auxiliar con un acumulador, como en la [Sesión 7](../../Unidad2-InduccionRecursividad/Sesion7-Estudio/index.md). ¿Con qué valor arranca el acumulador?

**Solución general.** Una función interna `iter(a, acc)` devuelve `acc` si `a > b` y si no llama `iter(prox(a), acc + f(a))`. `suma` devuelve `iter(a, 0)`. El llamado recursivo es lo último que hace `iter`, así que el compilador acepta `@tailrec`.
:::

## Ejercicio 4

Defina una función de alto orden `componer` que reciba dos funciones `f` y `g` de tipo `Int => Int` y devuelva $f \circ g$.

```scala
def componer(f: Int => Int, g: Int => Int): Int => Int = ???

componer(x => x + 1, x => x * 2)(3)   // 7: primero 3 * 2 = 6, luego 6 + 1 = 7
```

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** El tipo de retorno es `Int => Int`, así que el cuerpo es una función anónima. $(f \circ g)(x) = f(g(x))$.

**Solución general.** `componer` devuelve `x => f(g(x))`. Pruebe también `componer(x => x * 2, x => x + 1)(3)`: da `8` y muestra que la composición no es conmutativa.
:::

## Ejercicio 5

Defina `aplicarN`, que aplica una función `f` exactamente `n` veces a un valor inicial.

```scala
def aplicarN(f: Int => Int, n: Int, x: Int): Int = ???

aplicarN(x => x + 1, 5, 0)   // 5
aplicarN(x => x * 2, 3, 1)   // 8
```

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Aplicar `f` cero veces deja `x` igual. Aplicar `f` $n$ veces es aplicarla una vez y luego $n - 1$ veces más.

**Solución general.** Si `n == 0` se devuelve `x`; si no, `aplicarN(f, n - 1, f(x))`. Esta versión es recursiva de cola. Una variante que devuelve una función: `def aplicarN(f: Int => Int, n: Int): Int => Int`, construida con `componer` del ejercicio 4.
:::

## Ejercicio 6

Reescriba la siguiente función con una lista de parámetros por argumento. Luego defina dos funciones especializadas mediante aplicación parcial y úselas.

```scala
def operar(a: Int, b: Int, c: Int): Int = a * b + c
```

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Siga la regla de la sección 5.5. Piense qué significa fijar `a`, o fijar `a` y `b`.

**Solución general.** `def operar(a: Int)(b: Int)(c: Int): Int = a * b + c`. Por ejemplo, `val dobleMas = operar(2)` tiene tipo `Int => Int => Int` y `val seisMas = operar(2)(3)` tiene tipo `Int => Int`; `seisMas(4) = 10`.
:::

## Ejercicio 7

Para la función `producto` del ejercicio 1, plantee la relación de recurrencia de su costo temporal, resuélvala y dé su orden asintótico. Suponga que `f` y `prox` cuestan una constante.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use como tamaño $n$ el número de factores. Compare con el análisis de `suma` en la sección 6.

**Solución general.** $T(0) = c_0$ y $T(n) = T(n-1) + c_1$, de donde $T(n) = c_0 + n\,c_1 \in \Theta(n)$.
:::

## Ejercicio 8

Explique por qué la siguiente línea no compila y corríjala de dos formas distintas.

```scala
suma4(x => x)(1, 10)
```

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba el tipo de `suma4(x => x)`. ¿Qué espera recibir a continuación?

**Solución general.** `suma4(x => x)` tiene tipo `(Int => Int) => (Int, Int) => Int`: espera `prox`, no el par `(1, 10)`. El compilador rechaza `(1, 10)` porque no es una función `Int => Int`. Correcciones: dar el sucesor en la misma expresión, `suma4(x => x)(x => x + 1)(1, 10)`, o guardar la aplicación parcial y luego aplicarla, `val sumaId = suma4(x => x)(x => x + 1)` seguido de `sumaId(1, 10)`. Las dos dan `55`.
:::

## Ejercicio 9

Usando currying, defina una función que reciba un predicado y devuelva una función que cuente cuántos elementos de una lista cumplen ese predicado. Úsela para definir `contarPares` y `contarNegativos` por aplicación parcial, y analice su costo con una recurrencia.
