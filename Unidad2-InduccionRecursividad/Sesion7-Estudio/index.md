---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 7: Funciones y los procesos que ellas generan"
---

# Unidad 2 · Sesión 7: Funciones y los procesos que ellas generan

## Agenda

1. Funciones y Procesos
   - Recursión lineal e iteración
   - Recursión de cola
   - Recursión de árbol
2. Recursión Generativa
   - Definiciones
   - Ordenamiento por mezclas (MergeSort)
   - Parametrización de tipos
3. Ejercicios

## Funciones y Procesos

### Generalidades

**Funciones vs. procesos computacionales:**

- Una función especifica la evolución de un proceso computacional.
- Las reglas de evaluación de una función determinan el siguiente estado del proceso computacional.

**Objetivo:** hacer observaciones globales sobre el comportamiento de un proceso.

**Procesos más comunes:**

- Recursión lineal e iteración.
- Recursión en árbol.

### Recordar evaluación: modelo de sustitución

La aplicación de funciones con parámetros ($f(e_1, \dots, e_n)$) se evalúa así:

- Evalúe los argumentos $e_1, \dots, e_n$ de izquierda a derecha. Denotemos $v_1, \dots, v_n$ los resultados de esas evaluaciones.
- Sustituya la aplicación de la función por su cuerpo (lado derecho del `=`) y,
- Sustituya en ese cuerpo los parámetros formales por los argumentos actuales $v_1, \dots, v_n$.
- Evalúe esta nueva expresión.

### Recursión lineal e iteración

**Ejemplo: la función factorial.** Considere las siguientes funciones:

```scala
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

def factIter(cont: Int, prod: Int, n: Int): Int =
  if (cont > n) prod else factIter(cont + 1, cont * prod, n)

def fact(n: Int) = factIter(1, 1, n)
```

¿Cómo se evalúa `factorial(4)` y `fact(4)`?

**Comparación de procesos generados.**

```
factorial(4)                                    fact(4)
→ if (4 == 0) 1 else 4 * factorial(4 − 1)        → factIter(1, 1, 4)
↠ 4 * factorial(3)                               → if (1 > 4) 1 else factIter(1 + 1, 1 * 1, 4)
↠ 4 * 3 * factorial(2)                           ↠ factIter(2, 1, 4)
↠ 4 * 3 * 2 * factorial(1)                       → if (2 > 4) 1 else factIter(2 + 1, 2 * 1, 4)
↠ 4 * 3 * 2 * 1 * factorial(0)                   ↠ factIter(3, 2, 4)
↠ 4 * 3 * 2 * 1 * 1                              → if (3 > 4) 2 else factIter(3 + 1, 3 * 2, 4)
↠ 24                                             ↠ factIter(4, 6, 4)
                                                  → if (4 > 4) 6 else factIter(4 + 1, 4 * 6, 4)
                                                  ↠ factIter(5, 24, 4)
                                                  → if (5 > 4) 24 else factIter(5 + 1, 5 * 24, 4)
                                                  ↠ 24
```

| | `factorial` | `fact` |
|---|---|---|
| **Tiempo** | $\sim 2n$ | $\sim n$ |
| **Forma** | Expansión-Contracción | Constante |
| **Espacio** | $\sim n$ | $\sim$ cte |
| | Recursivo Lineal | Iterativo Lineal |

:::{admonition} ¡Ojo!
:class: warning
**Proceso Recursivo $\neq$ Función Recursiva.** Una función recursiva (definida en términos de sí misma) puede generar un proceso iterativo, como lo muestra `fact`, o un proceso recursivo, como lo muestra `factorial`.
:::

### Recursión de cola

Cuando una función recursiva se invoca a sí misma como su **última acción** (y no antes), la pila de evaluación puede ser reutilizada. A este tipo de recursión se le denomina **recursión de cola**.

- Las funciones recursivas por la cola implementan procesos iterativos.
- Los lenguajes de programación compilan las recursiones de cola como iteraciones (optimización de código).

**Ejemplos.** `factorial` no es recursión de cola (queda pendiente la multiplicación por `n`), mientras que `factIter` sí lo es (el llamado recursivo es la última acción):

```scala
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

def factIter(cont: Int, prod: Int, n: Int): Int =
  if (cont > n) prod else factIter(cont + 1, cont * prod, n)

def fact(n: Int) = factIter(1, 1, n)
```

**Recursión de cola en Scala.** En Scala se puede anotar el código para asegurarse de que una función use recursión de cola. Para ello es necesario:

1. Importar el paquete de anotaciones por medio de la línea `import scala.annotation.tailrec`.
2. Anotar el código con la etiqueta `@tailrec`.

```scala
import scala.annotation.tailrec

@tailrec
def factIter(cont: Int, prod: Int, n: Int): Int =
  if (cont > n) prod else factIter(cont + 1, cont * prod, n)

def fact(n: Int) = factIter(1, 1, n)
```

Si la implementación de `factIter` no aplica la recursión de cola, se muestra un **error** de compilación.

### Recursión de árbol

**La función de Fibonacci.** Recordemos la función de Fibonacci:

$$
\mathrm{fib}(n) =
\begin{cases}
0 & \text{si } n = 0 \\
1 & \text{si } n = 1 \\
\mathrm{fib}(n-1) + \mathrm{fib}(n-2) & \text{sino}
\end{cases}
$$

Definida en Scala:

```scala
def fibonacci(n: Int): Int =
  if (n == 0) 0
  else if (n == 1) 1
  else fibonacci(n - 1) + fibonacci(n - 2)
```

**Proceso para evaluar `fibonacci(4)`:**

```
fibonacci(4)
→ if (4 == 0) 0 else if (4 == 1) 1 else fibonacci(4 − 1) + fibonacci(4 − 2)
↠ fibonacci(3) + fibonacci(2)
↠ fibonacci(2) + fibonacci(1) + fibonacci(2)
↠ fibonacci(1) + fibonacci(0) + fibonacci(1) + fibonacci(2)
↠ 1 + 0 + 1 + fibonacci(2)
↠ 1 + 0 + 1 + fibonacci(1) + fibonacci(0)
↠ 1 + 0 + 1 + 1 + 0
↠ 3
```

En general, se genera un **árbol de evaluaciones**.

**¿Se puede hacer más eficiente?**

Observaciones:

- Tiempo $\equiv$ Nodos del árbol.
- Espacio $\equiv$ Profundidad del árbol.
- Fácil de programar.
- Mayor eficiencia $\Rightarrow$ menos natural.

Una solución más eficiente: observar que $0, 1, 1, 2, 3, 5, 8, 13, 21, \dots$, cada término es la suma de los dos anteriores. Podemos usar **dos acumuladores** y un contador:

```scala
import scala.annotation.tailrec

@tailrec
def fibIter(a: Int, b: Int, n: Int): Int = if (n == 0) b else fibIter(a + b, a, n - 1)

def fibonacci(n: Int) = fibIter(1, 0, n)
```

## Recursión Generativa

### Definiciones

**Recursión estructural vs. recursión generativa.**

- Las funciones que descomponen la entrada en sus partes y procesan luego la parte que tiene la misma forma de la entrada se llaman funciones con **recursión estructural**. Por ejemplo, las listas (estructura de cabeza-cola) y los números enteros (restar uno hasta llegar a cero).
- Cuando la recursión no se hace teniendo en cuenta la estructura de la entrada, sino en la solución de sub-problemas que permiten obtener una solución general, se llama **recursión generativa**.
- La recursión generativa se aplica para resolver problemas con la estrategia **divide y vencerás**.

**Recursión generativa.** Un algoritmo que sigue la estrategia divide y vencerás parte un problema en otros más pequeños y resuelve cada uno. Así, el problema general se resuelve combinando soluciones de los más pequeños. La recursión generativa distingue dos clases de problemas:

- **Triviales.** Tienen una solución trivial y alcanzable fácilmente.
- **No triviales.** Son pequeños problemas de la misma clase del problema original.

### Ordenamiento por mezclas (MergeSort)

**Ordenando listas con recursión generativa.** Intentaremos definir una función que ordene listas más eficientemente que el ordenamiento por inserción. Un algoritmo conocido para esto se llama **mergeSort** u ordenamiento por mezclas. La idea es:

- Si la lista tiene cero o un elementos, ya está ordenada.
- Si no:
  - Divida la lista original en dos sublistas de tamaño similar (si se puede, igual), cada una conteniendo más o menos la mitad de los elementos de la lista original.
  - Ordene las dos sublistas.
  - Mezcle las dos sublistas ordenadas en una sola lista ordenada.

**MergeSort, la idea:**

::::{image} images/mergesort-arbol.png
:alt: Árbol de recursión de mergeSort partiendo la lista [1 8 6 4 10 5 3 2 22] en mitades sucesivas hasta listas de un elemento y luego mezclando de regreso hacia la lista ordenada [1 2 3 4 5 6 8 10 22]
:width: 70%
::::

*Imagen tomada del texto* How to Design Programs *de Matthias Felleisen, Robert Bruce Findler, Matthew Flatt y Shriram Krishnamurthi.*

**Primera implementación de mergeSort:**

```scala
def msort(xs: List[Int]): List[Int] = {
  def merge(l1: List[Int], l2: List[Int]): List[Int] = l1 match {
    case Nil     => l2
    case m :: ms => l2 match {
      case Nil     => l1
      case n :: ns => if (m < n) m :: merge(ms, l2) else n :: merge(l1, ns)
    }
  }
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (l1, l2) = xs splitAt n
    merge(msort(l1), msort(l2))
  }
}
```

La función `splitAt` devuelve dos listas (una hasta antes del elemento `n` y otra del `n`-ésimo elemento en adelante), embebidas en una pareja o tupla de 2 elementos.

**Parejas y tuplas.** Una pareja compuesta por `x` y `y` se escribe en Scala `(x, y)`:

```scala
scala> val pareja = ("numero", 42)
val pareja: (String, Int) = (numero, 42)
```

Las parejas también se pueden usar como patrones:

```scala
scala> val (cadena, valor) = pareja
val cadena: String = numero
val valor: Int = 42
```

### Parametrización de tipos

**Haciendo un ordenamiento más general.** ¿Cómo parametrizar `msort` de manera que ordene listas de cualquier tipo? Note que no es suficiente parametrizar `msort` con un *wildcard*:

```scala
def msort[T](xs: List[T]): List[T] = ...
```

porque `msort` usa `merge` y esta usa `<`, que no es un comparador del tipo `T`.

**Idea:** parametrizar con la función de comparación del tipo `T`. Diseñamos `msort` polimórfica y de alto orden, pasando el operador de comparación:

```scala
def msort[T](xs: List[T])(mq: (T, T) => Boolean): List[T] = {
  def merge(l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
    case (Nil, _) => l2
    case (_, Nil) => l1
    case (m :: ms, n :: ns) =>
      if (mq(m, n)) m :: merge(ms, l2) else n :: merge(l1, ns)
  }
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (l1, l2) = xs splitAt n
    merge(msort(l1)(mq), msort(l2)(mq))
  }
}

msort(List(1, 3, 2, 4, 7, 5))((x: Int, y: Int) => x < y)
msort(List("a", "c", "f", "e", "d", "b"))((x: String, y: String) => x < y)
```

## Ejercicios

1. Implementar en Scala el algoritmo de búsqueda binaria.
2. Implementar en Scala el algoritmo `quickSort` recursivo del texto de Cormen.

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
