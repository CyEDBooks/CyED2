---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 13: Ejercicios"
---

# Unidad 3 · Sesión 13: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 13](index.md). Las secciones que mencionan los ejercicios son las de ese material.

## Ejercicio 1

Escriba `elevarCuadrado`, que recibe una `List[Double]` y devuelve la lista de los cuadrados, de dos formas: con reconocimiento de patrones y con `map`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** La versión recursiva tiene el esqueleto de `escalar` de la sección 1.

**Solución general.** Recursiva: `Nil => Nil` y `y :: ys => y * y :: elevarCuadrado(ys)`. Con `map`: `xs.map(x => x * x)`.
:::

## Ejercicio 2

Reescriba la siguiente función con `filter` y `map`.

```scala
def positivosCuadrados(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case y :: ys =>
    if (y > 0) (y * y) :: positivosCuadrados(ys)
    else positivosCuadrados(ys)
}
```

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Identifique la condición y la transformación. ¿En qué orden van?

**Solución general.** `xs.filter(_ > 0).map(y => y * y)`. El orden importa: si primero se eleva al cuadrado, todos los resultados distintos de cero son positivos.
:::

## Ejercicio 3

Implemente `longitud[T](xs: List[T]): Int` y `reverso[T](xs: List[T]): List[T]` con `foldLeft`, sin recursión explícita.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** En `longitud` el elemento no importa, solo que exista. Para `reverso`, revise la tercera animación de `foldLeft`.

**Solución general.** `xs.foldLeft(0)((acc, _) => acc + 1)` y `xs.foldLeft(List[T]())((acc, x) => x :: acc)`.
:::

## Ejercicio 4

Implemente `filtrar[T](xs: List[T])(p: T => Boolean): List[T]` con `foldRight`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Parta de `mapConFold` (sección 4.3, ejemplo 3). El operador decide si pone `x` delante del acumulado o deja el acumulado igual.

**Solución general.** `xs.foldRight(List[T]())((x, acc) => if (p(x)) x :: acc else acc)`.
:::

## Ejercicio 5

Dada `val palabras: List[String]`, devuelva en una sola expresión las palabras de más de 4 letras, convertidas a mayúsculas.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Una etapa selecciona y otra transforma.

**Solución general.** `palabras.filter(_.length > 4).map(_.toUpperCase)`. Con `List("sol", "lluvia", "viento", "mar")` da `List("LLUVIA", "VIENTO")`.
:::

## Ejercicio 6

Dada `val transacciones: List[(String, Double)]` de la forma (concepto, monto), calcule el saldo total ignorando las devoluciones, es decir, los conceptos que empiezan por `"DEV"`.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** `filterNot` con un predicado sobre la primera componente, y después un `foldLeft` sobre la segunda.

**Solución general.** `transacciones.filterNot(_._1.startsWith("DEV")).map(_._2).foldLeft(0.0)(_ + _)`.
:::

## Ejercicio 7

Implemente `paraTodo[T](xs: List[T])(p: T => Boolean): Boolean` y `existe[T](xs: List[T])(p: T => Boolean): Boolean` con `foldLeft`. Compruebe que coinciden con `forall` y `exists` en listas vacías.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** ¿Cuál es el neutro de `&&`? ¿Y el de `||`? Ese neutro es la respuesta para la lista vacía.

**Solución general.** `xs.foldLeft(true)((acc, x) => acc && p(x))` y `xs.foldLeft(false)((acc, x) => acc || p(x))`. Sobre `Nil` dan `true` y `false`, igual que `Nil.forall(p)` y `Nil.exists(p)`. A diferencia de `forall` y `exists` de la biblioteca, estas versiones recorren la lista completa aunque la respuesta ya se conozca.
:::

## Ejercicio 8

Para cada operador y valor inicial, decida si `xs.foldLeft(z)(op) == xs.foldRight(z)(op)` para toda lista de enteros `xs`. Si no, dé un contraejemplo.

1. `max` con `z = Int.MinValue`
2. `-` con `z = 0`
3. `(x, y) => x * y` con `z = 1`
4. `(x, y) => (x + y) / 2` con `z = 0`

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Revise la condición de la sección 4.4. Para encontrar contraejemplos, pruebe listas de dos o tres elementos.

**Solución general.** 1 y 3 coinciden siempre: los operadores son asociativos y `z` es su neutro. 2 falla: con `List(1, 2)`, `foldLeft` da $(0-1)-2 = -3$ y `foldRight` da $1-(2-0) = -1$. 4 falla porque el promedio entero no es asociativo: con `List(4, 8)`, `foldLeft` da $((0+4)/2 + 8)/2 = 5$ y `foldRight` da $(4 + (8+0)/2)/2 = 4$.
:::

## Ejercicio 9

Traduzca a `flatMap`, `withFilter` y `map` la consulta 1 de la sección 8, ejemplo 5.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Hay dos generadores y un filtro pegado al segundo. Aplique las reglas de la tabla de la sección 8 de arriba abajo.

**Solución general.** `libros.flatMap(l => l.autores.withFilter(a => a.startsWith("Odersky")).map(a => l.titulo))`.
:::

## Ejercicio 10

Muestre que **no** se puede calcular la longitud de una `List[String]` con `reduceLeft`, aunque la lista no sea vacía.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba el tipo del operador de `reduceLeft` para `T = String` y el tipo del resultado.

**Solución general.** `reduceLeft` recibe `op: (String, String) => String` y devuelve un `String`: el acumulador tiene que ser del mismo tipo de los elementos, y una longitud es un `Int`. `foldLeft` sí sirve porque separa el tipo del acumulador (`U = Int`) del tipo de los elementos (`T = String`).
:::

## Ejercicio 11

Escriba `empaquetar` de la sección 5 con `foldRight`, sin usar `span` ni recursión explícita.
