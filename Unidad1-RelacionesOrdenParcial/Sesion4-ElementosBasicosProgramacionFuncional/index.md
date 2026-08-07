---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 4: Elementos básicos de la programación funcional, recursividad y listas"
---

# Unidad 1 · Sesión 4: Elementos básicos de la programación funcional, recursividad y listas

## Objetivos

- Diseño e implementación de programas funcionales puros con estructuras de datos inmutables utilizando recursión, reconocimiento de patrones, mecanismos de encapsulación, funciones de alto orden e iteradores para resolver problemas de programación.
- Aplicar las reglas de inferencia de tipos genéricos en los programas funcionales para determinar errores de programación.
- Aplicar conceptos fundamentales de la programación funcional, utilizando un lenguaje de programación adecuado como Scala, para analizar un problema, modelar, diseñar y desarrollar su solución.
- Razonar sobre la estructura de programas funcionales utilizando la inducción como mecanismo de argumentación para demostrar propiedades de los programas que construye.

Para cumplir estos objetivos, en el bloque de programación funcional estudiaremos: principios, fundamentos y lenguajes de programación funcional; elementos de programación funcional (elementos básicos, estrategias de evaluación y terminación, condicionales y definición de valores); funciones y los procesos que ellas generan (procesos recursivos y procesos iterativos); listas (la descomposición en el diseño de datos y el reconocimiento de patrones, pares y tuplas); funciones de alto orden (funciones como parámetro, funciones anónimas y funciones como respuesta); funciones y datos (construyendo abstracciones de datos, organización de clases en Scala); funciones de alto orden sobre listas; y colecciones (secuencias, conjuntos, expresiones for, maps, streams).

## Paradigmas de programación

Un **paradigma** describe distintos conceptos y patrones de pensamiento en una disciplina científica. El **paradigma de programación** define las principales características de un lenguaje de programación, esto es, la forma en que se diseñan y construyen los programas. Por ejemplo, en el paradigma orientado a objetos los programas se construyen como un conjunto de objetos que interactúan entre ellos por medio de llamados a métodos, también conocidos como paso de mensajes.

:::{image} images/paradigmas-lenguajes-conceptos.png
:alt: Diagrama que relaciona lenguajes, paradigmas y conceptos, cada lenguaje realiza uno o más paradigmas y cada paradigma consiste de un conjunto de conceptos
:width: 80%
:::

*Figura: Lenguajes, paradigmas y conceptos. Imagen tomada de "Programming Paradigms for dummies, what every programmer should know", autor: Peter Van Roy.*

## Principios de la programación funcional

En un sentido operativo, la PF significa programar sin variables mutables, ni asignación, ni ciclos, ni otras estructuras de control imperativas. En un sentido más amplio, la PF significa que un programa es un conjunto de funciones e invocaciones a funciones. En particular, las funciones son valores que pueden ser producidos, consumidos y compuestos. Los lenguajes de programación funcionales hacen que esto sea sencillo.

En un sentido operativo, un lenguaje de PF no ofrece variables mutables, ni asignación, ni ciclos, ni otras estructuras de control imperativas. En un sentido más amplio, un lenguaje de PF permite la construcción de programas elegantes enfocados en funciones. En particular, las funciones son valores que pueden ser producidos, consumidos y compuestos, es decir:

- Pueden ser definidas en cualquier parte, incluso dentro de otras funciones.
- Al igual que cualquier otro valor, las funciones pueden ser pasadas como parámetros a otras funciones y devueltas como resultado de aplicar una función.
- Como para cualquier valor, existen operadores sobre las funciones (para componerlas y para invocarlas).

## Scala: el lenguaje del curso

Usaremos Scala como el lenguaje de programación del curso. ¿Por qué Scala?

- Porque corre sobre la JVM y su sintaxis es parecida a la de Java (menos esfuerzo inicial).
- Porque implementa el paradigma funcional de forma elegante.
- Porque ha sido diseñado para el procesamiento de grandes cantidades de datos, y eso puede ser muy útil para los estudiantes.

### El Read-Eval-Print Loop

El *Read-Eval-Print Loop* o **REPL** es un ambiente de programación simple e interactivo que permite interactuar con el intérprete del lenguaje como si fuera una calculadora. El REPL es una capa interactiva que permite escribir expresiones a las que responde con su valor.

El REPL de Scala se puede iniciar de una de las siguientes formas.

**Usando la línea de comandos:**

:::{image} images/repl-linea-comandos.png
:alt: Terminal mostrando el inicio del REPL de Scala con el comando scala
:width: 70%
:::

**Usando una IDE:**

:::{image} images/repl-ide.png
:alt: Panel de terminal integrado de un IDE mostrando el prompt scala
:width: 70%
:::

### Expresiones

Interacciones sencillas con el REPL. Como calculadora:

```scala
scala> 87 + 145
val res3: Int = 232
```

Es más que una calculadora, pues permite definir valores y calcular con ellos:

```scala
scala> def size = 2
def size: Int

scala> 5 * size
val res4: Int = 10
```

**Resumen.** El REPL trabaja con expresiones (valores y operandos) y con la definición de nombres.

**Nota sobre tipos:** en Scala todo es un objeto, así que los tipos de datos son como en Java, pero con mayúscula inicial (`Int`, `Double`, `String`, `Boolean`, ...).

### Parámetros

Las definiciones pueden tener parámetros:

```scala
scala> def square(x: Double) = x * x
def square(x: Double): Double

scala> square(2)
val res5: Double = 4.0

scala> square(5 + 4)
val res6: Double = 81.0

scala> square(square(4))
val res7: Double = 256.0

scala> def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
def sumOfSquares(x: Double, y: Double): Double
```

Los tipos de los parámetros de las funciones se escriben después de `:`. El tipo devuelto por la función se escribe después de `:`, posterior a la lista de parámetros:

```scala
scala> def sumOfSquares(x: Double, y: Double): Double = square(x) + square(y)
def sumOfSquares(x: Double, y: Double): Double
```

## Definición de funciones

Por ejemplo:

```scala
scala> def cubo(n: Int) = n * n * n
scala> cubo(3) // llamado
```

- No es necesario definir el tipo de retorno, se puede inferir.
- No hay `return`.
- No hay ningún carácter que señale el fin de una instrucción.
- No hay caracteres para marcar el inicio y el fin de un bloque.

## Condicionales y definición de valores

### Expresiones condicionales

Para expresar escogencia entre dos alternativas, Scala tiene una expresión condicional `if-else`. Como es una expresión, siempre devuelve algo. Por ejemplo:

```scala
scala> def abs(x: Int) = if (x >= 0) x else -x
def abs(x: Int): Int
```

`(x >= 0)` es un predicado de tipo `Boolean`.

Como referencia, así se ve el operador condicional (ternario) en Java:

:::{image} images/condicional-ternario-java.png
:alt: Diagrama del operador condicional ternario en Java, int x = (a mayor que b) interrogación 40 dos puntos 30, donde 1 es la condición, 2 es el valor devuelto si es verdadera y 3 el valor devuelto si es falsa
:width: 70%
:::

### Expresiones booleanas

Las expresiones booleanas son:

```scala
true false   // Constantes
!b           // Neg
b && b       // Conj
b || b       // Disy
```

Y las operaciones típicas de comparación:

```scala
e <= e, e >= e, e < e, e > e, e == e, e != e
```

### Evaluación de expresiones booleanas y condicionales

Reglas de evaluación de las expresiones booleanas:

```
!true      --> false
!false     --> true
true && e  --> e
false && e --> false
true || e  --> true
false || e --> e
```

Nótese que el operando a la derecha no necesita ser evaluado siempre.

Reglas de evaluación de la expresión condicional. Se evalúa primero el predicado, y luego:

```
if true e1 else e2  --> e1
if false e1 else e2 --> e2
```

## Fundamentos: evaluación de expresiones

Toda expresión no primitiva (con un operador y unos operandos) se evalúa de la siguiente manera:

1. Se identifica el operador principal de la expresión.
2. Se evalúan sus operandos, de izquierda a derecha.
3. Se aplica el operador a los operandos.

Un nombre se evalúa sustituyéndolo por lo que hay en el lado derecho de su definición. El proceso de evaluación termina una vez se tiene un valor (un valor es, por ahora, un número).

**Ejemplo.** ¿Cómo se evaluaría la expresión $(2 * \mathrm{Size}) * \mathrm{Size}$? (Nota: operador principal, de izquierda a derecha.)

1. Identificar el operador principal: $(2 * \mathrm{Size}) * \mathrm{Size}$.
2. Evaluar el primer operando $(2 * \mathrm{Size})$:
   1. Identificar el operador principal: $2 * \mathrm{Size}$.
   2. Evaluar el primer operando: $2$.
   3. Evaluar el segundo operando $\mathrm{Size}$. Como es un nombre, devuelve el lado derecho: $2$.
   4. Aplicar el operador $*$ a los operandos $2$ y $2$, devolviendo $4$.
3. Evaluar el segundo operando $\mathrm{Size}$. Como es un nombre, devuelve el lado derecho: $2$.
4. Aplicar el operador $*$ a los operandos $4$ y $2$, devolviendo $8$.

### Evaluación de aplicación de funciones definidas por el programador

La evaluación de funciones con parámetros se hace de manera similar a las expresiones no primitivas:

1. Evaluar los argumentos de izquierda a derecha.
2. Reemplazar el llamado de la función por su cuerpo (después del `=`).
3. Reemplazar en el cuerpo de la función los parámetros formales por los argumentos actuales evaluados.
4. Evaluar esta nueva expresión.

Por ejemplo:

```scala
sumOfSquares(3, 2 + 2)
sumOfSquares(3, 4)
square(3) + square(4)
3*3 + square(4)
9 + square(4)
9 + 4*4
9 + 16
25
```

## Listas

La lista es una estructura de datos fundamental para la programación funcional. La lista que tiene los elementos $x_1, \ldots, x_n$ se escribe en Scala como `List(x1, ..., xn)`. Ejemplos:

```scala
def minions = List("Kevin", "Dave", "Bob")
def numeros = List(1, 2, 3, 4)
def lDEl = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
def vacia = List()
```

Dos características importantes de las listas: son **inmutables** y son **recursivas**.

### Los constructores de listas

Las listas se construyen a partir de dos constructores:

- La lista vacía `Nil`, y
- El operador de construcción `::` (se pronuncia *cons*):

```scala
x :: xs
```

construye una lista cuyo primer elemento es `x`, y cuyo resto de elementos es la lista `xs`.

### El tipo Lista

Las listas son **homogéneas**: todos sus elementos deben ser del mismo tipo. El tipo de una lista de elementos del tipo `T` es `scala.List[T]` o, en versión corta, `List[T]`.

### Asociatividad a la derecha

Por convención, los operadores que terminan en `:` son asociativos a la derecha, es decir: `A :: B :: C` se interpreta como `A :: (B :: C)`. Por ejemplo:

```scala
scala> val numeros = 1 :: 2 :: 3 :: 4 :: Nil
val numeros: List[Int] = List(1, 2, 3, 4)
```

es lo mismo que escribir:

```scala
scala> val numeros = 1 :: (2 :: (3 :: (4 :: Nil)))
val numeros: List[Int] = List(1, 2, 3, 4)
```

### Operaciones sobre listas

Todas las operaciones sobre las listas se implementan a partir de las constructoras de listas y de las siguientes operaciones selectoras:

- `head`: devuelve el primer elemento de una lista.
- `tail`: devuelve la lista sin el primer elemento (el resto de la lista).
- `isEmpty`: devuelve `true` si la lista es vacía y `false` si no.

Todas estas operaciones son métodos de los objetos de tipo `List`:

```scala
scala> minions.head
val res6: String = Kevin

scala> minions.tail
val res7: List[String] = List(Dave, Bob)

scala> minions.tail.head
val res8: String = Dave

scala> minions.tail.tail.head
val res9: String = Bob

scala> minions.tail.tail.tail.head
java.util.NoSuchElementException: head of empty list

scala> minions.tail.tail.tail.tail
java.lang.UnsupportedOperationException: tail of empty list
```

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
