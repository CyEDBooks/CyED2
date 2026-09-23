---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 10: Divide y vencerás — MergeSort y QuickSort"
---

# Unidad 2 · Sesión 10: Divide y vencerás — MergeSort y QuickSort

## Agenda

1. Recursión estructural vs. recursión generativa (repaso)
2. Ordenamiento por inserción: ¿por qué no es divide y vencerás?
3. Diseño de algoritmos con recursión generativa
4. MergeSort: ordenamiento por mezclas
5. QuickSort
6. Comparación y complejidad
7. Ejercicios

## 1. Recursión estructural vs. recursión generativa

En la [Sesión 7](../Sesion7-Estudio/index.md) distinguimos dos formas de escribir funciones recursivas:

- **Recursión estructural.** La función descompone la entrada en sus partes y procesa la parte que tiene la misma forma de la entrada (por ejemplo, la cola de una lista). El llamado recursivo se hace sobre un dato *un poco más pequeño* que el original.
- **Recursión generativa.** La recursión no sigue la estructura de la entrada, sino que *genera* uno o más subproblemas nuevos —de la misma clase del original pero más pequeños— cuyas soluciones se combinan para resolver el problema completo. Esta es la base de la estrategia **divide y vencerás**.

**La plantilla general de la recursión generativa** distingue dos clases de problemas:

- **Triviales.** Tienen una solución obvia y alcanzable fácilmente.
- **No triviales.** Se dividen en subproblemas más pequeños de la misma clase del original, cuyas soluciones se combinan.

```scala
def funcionGenerativa[Problema, Solucion](problema: Problema): Solucion =
  if (esTrivial(problema)) resolverCasoTrivial(problema)
  else
    combinarSoluciones(
      funcionGenerativa(generarSubproblema1(problema)),
      // ...
      funcionGenerativa(generarSubproblemaN(problema))
    )
```

Hoy vamos a ver dos algoritmos de ordenamiento clásicos que siguen esta estrategia —**MergeSort** y **QuickSort**— y, antes de eso, vamos a mirar un algoritmo que *no* la sigue: el **ordenamiento por inserción**.

## 2. Ordenamiento por inserción: ¿por qué no es divide y vencerás?

**La idea.** Para ordenar una lista con `insertionSort`:

- Si la lista está vacía, ya está ordenada.
- Si no, se ordena la cola de la lista (recursivamente) y luego se **inserta** la cabeza en el lugar que le corresponde dentro de esa cola ya ordenada.

```scala
def insertar(x: Int, lista: List[Int]): List[Int] = lista match {
  case Nil               => List(x)
  case y :: ys if x <= y => x :: lista
  case y :: ys           => y :: insertar(x, ys)
}

def insertionSort(lista: List[Int]): List[Int] = lista match {
  case Nil       => Nil
  case x :: xs   => insertar(x, insertionSort(xs))
}
```

::::{image} images/insertion-sort.gif
:alt: Animación del ordenamiento por inserción tomando una carta a la vez de una secuencia desordenada e insertándola en su posición correcta dentro de la parte ya ordenada
:width: 50%
:align: center
::::

*Animación tomada de Wikipedia (inglés), artículo* [Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort)*, autor Swfung8, licencia CC BY-SA 3.0.*

:::{admonition} ¿Por qué `insertionSort` no es divide y vencerás?
:class: important
Cada llamado recursivo de `insertionSort` reduce el problema en **un solo elemento** (`xs`, la cola): no se *divide* la lista en dos subproblemas independientes de tamaño comparable que se resuelven por separado. Además, `insertar` no combina dos soluciones ya resueltas: recorre la cola ordenada buscando dónde ubicar un único valor.

En otras palabras, `insertionSort` es **recursión estructural** —sigue la forma de la lista, cabeza y cola— y no recursión generativa. Por eso su costo es $O(n^2)$: en el peor caso, insertar cada uno de los $n$ elementos recorre una cola de hasta $n$ elementos.

MergeSort y QuickSort, en cambio, **sí** parten el problema en subproblemas de tamaño similar (más o menos la mitad de la lista cada uno), los resuelven de forma independiente y **combinan** sus soluciones. Esa es la diferencia que los hace, en general, más eficientes que el ordenamiento por inserción.
:::

## 3. Diseño de algoritmos con recursión generativa

Cuando resolvemos un problema con recursión generativa, la estrategia de diseño de funciones se adapta así:

| Elemento | Adaptación |
|---|---|
| Contrato, cabecera y propósito | Se conservan; el propósito debe explicar *qué* hace la función y, de forma general, *cómo* lo hace. |
| Ejemplos | Deben mostrar cómo funciona el algoritmo, no solo su resultado. |
| Plantilla | Se parte de la plantilla de recursión generativa (caso trivial / caso no trivial). |
| Pruebas | Para problemas triviales y no triviales. |
| **Terminación** | Elemento **nuevo**: hay que argumentar por qué el algoritmo termina. |

:::{admonition} Terminación
:class: tip
En recursión generativa es necesario mostrar que **cada llamado recursivo reduce el tamaño de la entrada**, de manera que en algún momento el problema se vuelve trivial y la recursión se detiene. Sin este argumento, el diseño del algoritmo se considera incompleto: nada impide, en principio, que los subproblemas generados no se vuelvan más pequeños.
:::

Para diseñar cada algoritmo respondemos las mismas preguntas:

1. ¿En qué caso la entrada es un problema con solución trivial? ¿Cuál es esa solución?
2. En el caso no trivial: ¿cómo se parte el problema en subproblemas? ¿cuántos subproblemas hay que resolver?
3. ¿Cómo se combinan las soluciones de los subproblemas para obtener la solución general?
4. ¿Por qué el algoritmo termina?

## 4. MergeSort: ordenamiento por mezclas

**La idea.**

- Si la lista tiene cero o un elemento, ya está ordenada (caso trivial).
- Si no (caso no trivial):
  - Se calcula la longitud de la lista para partirla por la mitad en dos sublistas.
  - Cada sublista se ordena con el mismo procedimiento (llamado recursivo).
  - Las dos sublistas ya ordenadas se **mezclan** en una sola lista ordenada.

::::{image} images/mergesort-arbol.png
:alt: Árbol de recursión de mergeSort partiendo la lista [1 8 6 4 10 5 3 2 22] en mitades sucesivas hasta listas de un elemento y luego mezclando de regreso hacia la lista ordenada [1 2 3 4 5 6 8 10 22]
:width: 65%
:align: center
::::

*Imagen tomada del texto* How to Design Programs *de Matthias Felleisen, Robert Bruce Findler, Matthew Flatt y Shriram Krishnamurthi.*

::::{image} images/merge-sort.gif
:alt: Animación de mergeSort dividiendo repetidamente la secuencia por la mitad y luego mezclando las mitades ya ordenadas
:width: 50%
:align: center
::::

*Animación tomada de Wikipedia (inglés), artículo* [Merge sort](https://en.wikipedia.org/wiki/Merge_sort)*, autor Swfung8, licencia CC BY-SA 3.0.*

**Traduciendo el algoritmo original (Scheme) a Scala.** La clase fuente de esta sesión definía `mergeSort` con tres funciones auxiliares: `particion-bajo` (toma los primeros `n` elementos), `particion-alto` (descarta los primeros `n - 1` elementos) y `mezclar` (combina dos listas ya ordenadas conservando el orden). Así se ven en Scala, manteniendo la misma descomposición:

```scala
def particionBajo(n: Int, lista: List[Int]): List[Int] =
  if (n == 0) Nil
  else lista match {
    case Nil              => Nil
    case primero :: resto => primero :: particionBajo(n - 1, resto)
  }

def particionAlto(n: Int, lista: List[Int]): List[Int] =
  if (n == 1) lista
  else lista match {
    case Nil          => Nil
    case _ :: resto   => particionAlto(n - 1, resto)
  }

def mezclar(lista1: List[Int], lista2: List[Int]): List[Int] = (lista1, lista2) match {
  case (Nil, _)           => lista2
  case (_, Nil)           => lista1
  case (m :: ms, n :: ns) =>
    if (m < n) m :: mezclar(ms, lista2) else n :: mezclar(lista1, ns)
}

def mergeSort(lista: List[Int]): List[Int] = lista match {
  case Nil        => Nil
  case _ :: Nil   => lista
  case _ =>
    val p = lista.length / 2
    mezclar(mergeSort(particionBajo(p, lista)), mergeSort(particionAlto(p + 1, lista)))
}
```

:::{admonition} Análisis de datos
- **¿Caso trivial?** La lista es vacía o tiene un solo elemento → ya está ordenada, se retorna igual.
- **¿Cómo se parte el problema no trivial?** Se divide la entrada en dos listas de tamaño similar (más o menos la mitad).
- **¿Cuántos subproblemas?** Dos: `particionBajo(p, lista)` y `particionAlto(p + 1, lista)`.
- **¿Cómo se combinan las soluciones?** Con `mezclar`, que une dos listas ya ordenadas conservando el orden.
- **Terminación.** El tamaño de la entrada se divide por la mitad en cada llamado recursivo, hasta que la lista tiene cero o un elemento —el caso trivial— y ahí se detiene la recursión.
:::

:::{admonition} Nota
:class: note
En la Sesión 7 vimos una versión de `msort` que usa `xs.splitAt(n)` para partir la lista en una sola línea. Aquí mantuvimos `particionBajo`/`particionAlto` por separado, siguiendo la misma descomposición del algoritmo original en Scheme, para que se vea con claridad la correspondencia entre las dos versiones. Ambas implementaciones resuelven el mismo problema con la misma estrategia; solo cambia qué tan "de bajo nivel" se escriben las funciones auxiliares.
:::

## 5. QuickSort

**La idea.**

- Se escoge un **pivote** (en este algoritmo, el primer elemento de la lista).
- Se parte el resto de la lista en dos:
  - Una lista con los elementos **menores o iguales** al pivote.
  - Una lista con los elementos **mayores** al pivote.
- Cada una de esas listas se ordena con el mismo procedimiento (llamado recursivo).
- Se combinan las piezas: `ordenados(menores) ++ [pivote] ++ ordenados(mayores)`.

::::{image} images/quicksort-arbol.png
:alt: Árbol de recursión de quickSort partiendo la lista [11 8 14 7] escogiendo el primer elemento como pivote en cada paso, hasta llegar a la lista ordenada [7 8 11 14]
:width: 40%
:align: center
::::

*Imagen tomada del material original de esta sesión (recursión generativa y algoritmos de ordenamiento), adaptado del texto* How to Design Programs.

::::{image} images/quicksort.gif
:alt: Animación de quickSort escogiendo un pivote y particionando el arreglo en elementos menores y mayores hasta obtenerlo ordenado
:width: 50%
:align: center
::::

*Animación tomada de Wikipedia (inglés), artículo* [Quicksort](https://en.wikipedia.org/wiki/Quicksort)*, autor RolandH, licencia CC BY-SA 3.0.*

**Traduciendo el algoritmo original (Scheme) a Scala.** La clase fuente definía `qsort` usando dos funciones auxiliares, `menores` y `mayores`, y `append` para combinar las tres partes. En Scala:

```scala
def menores(pivote: Int, lista: List[Int]): List[Int] =
  lista.filter(x => x <= pivote)

def mayores(pivote: Int, lista: List[Int]): List[Int] =
  lista.filter(x => x > pivote)

def quickSort(lista: List[Int]): List[Int] = lista match {
  case Nil            => Nil
  case pivote :: resto =>
    quickSort(menores(pivote, resto)) ::: List(pivote) ::: quickSort(mayores(pivote, resto))
}
```

:::{admonition} Análisis de datos
- **¿Caso trivial?** La lista es vacía → ya está ordenada, se retorna igual (`empty` en el original).
- **¿Cómo se parte el problema no trivial?** Se toma el primer elemento como pivote y se divide el resto en menores-o-iguales y mayores.
- **¿Cuántos subproblemas?** Dos: uno por cada sublista.
- **¿Cómo se combinan las soluciones?** Concatenando (`:::` en Scala, `append` en el original): ordenados-menores, pivote, ordenados-mayores.
- **Terminación.** En cada paso, `quickSort` divide la lista en dos listas estrictamente más pequeñas que la entrada (porque el pivote se retira de ambas); eventualmente el llamado recibe la lista vacía, ahí se detiene la recursión, se unen las salidas y se obtiene el resultado.
:::

## 6. Comparación y complejidad

| Algoritmo | Tipo de recursión | ¿Divide y vencerás? | Tiempo promedio | Peor caso |
|---|---|---|---|---|
| Ordenamiento por inserción | Estructural (reduce en 1 elemento) | No | $O(n^2)$ | $O(n^2)$ |
| MergeSort | Generativa | Sí | $O(n \log n)$ | $O(n \log n)$ |
| QuickSort | Generativa | Sí | $O(n \log n)$ | $O(n^2)$ (pivote siempre el mínimo o el máximo) |

:::{admonition} ¿Por qué MergeSort y QuickSort son $O(n \log n)$ en promedio?
Cada nivel de la recursión (cada "piso" del árbol) hace un trabajo proporcional a $n$ —mezclar o particionar toda la lista—, y la lista se divide por la mitad en cada llamado, así que hay aproximadamente $\log_2 n$ niveles. De ahí $O(n \log n)$. QuickSort pierde esta garantía en el peor caso porque, si el pivote resulta ser siempre el elemento más pequeño o más grande, una de las dos particiones queda vacía y la profundidad del árbol pasa de $\log n$ a $n$.
:::

## 7. Ejercicios

1. Simule paso a paso, dibujando el árbol de llamados (como en las imágenes de esta sesión), la ejecución de `mergeSort` y de `quickSort` sobre la lista `List(7, 2, 9, 4, 3, 8, 1)`.
2. Argumente la terminación de `insertionSort` (Sección 2) con el mismo formato usado para `mergeSort` y `quickSort`. ¿En qué se diferencia del argumento de terminación de los algoritmos de recursión generativa?
3. Parametrice `quickSort` con una función de comparación, siguiendo la misma idea de alto orden que se usó para `msort` en la Sesión 7 (`msort[T](xs: List[T])(mq: (T, T) => Boolean)`), de manera que sirva para ordenar listas de cualquier tipo.
4. ¿Qué pasa con el desempeño de `quickSort`, tal como está implementado aquí (pivote = primer elemento), si se le pasa una lista que ya está ordenada? Relacione la respuesta con la fila de "peor caso" de la tabla de la Sección 6.

## Fuentes

- Material original de esta sesión: *Recursión Generativa y algoritmos de ordenamiento*, Fundamentos de Programación, Universidad del Valle.
- Felleisen, M., Findler, R. B., Flatt, M., Krishnamurthi, S. — *How to Design Programs*.
- Wikipedia (inglés) — [Insertion sort](https://en.wikipedia.org/wiki/Insertion_sort), animación de Swfung8, CC BY-SA 3.0.
- Wikipedia (inglés) — [Merge sort](https://en.wikipedia.org/wiki/Merge_sort), animación de Swfung8, CC BY-SA 3.0.
- Wikipedia (inglés) — [Quicksort](https://en.wikipedia.org/wiki/Quicksort), animación de RolandH, CC BY-SA 3.0.

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
