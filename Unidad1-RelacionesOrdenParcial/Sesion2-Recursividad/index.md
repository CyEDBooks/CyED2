---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 2: Recursividad"
---

# Unidad 1 · Sesión 2: Recursividad

## Objetivos

- Aplicar el principio de inducción matemática para definir estructuras discretas, demostrar sus propiedades y verificar algoritmos formalmente, en particular, establecer y resolver relaciones de recurrencia asociadas a la complejidad de dichos algoritmos.
- Expresar o comunicar con el vocabulario y lenguaje adecuado/especializado las ideas principales sobre estructuras discretas o la programación funcional.
- Relacionar los pasos de la inducción matemática para construir conjuntos de manera recursiva; identificando el paso base $P(1)$ y la hipótesis inductiva, $P(k)$.
- Enunciar el principio de inducción estructural y construir pruebas basadas en este principio sobre conjuntos distintos a los naturales.
- Reconocer o diseñar algoritmos recursivos.
- Utilizar el principio de inducción para verificar que un algoritmo recursivo sea correcto.

## Recursividad

Recursión es el proceso de definir objetos en términos de ellos mismos.

Considere el fractal Koch de copo de nieve:

:::{image} images/koch.png
:alt: Construcción del fractal de Koch (copo de nieve)
:width: 70%
:::

**Tarea.** Encontrar una forma recursiva de calcular el número de lados, $N$, del fractal.

### Definición recursiva del fractal Koch

Alteramos recursivamente cada segmento de línea del fractal la siguiente manera:

1. Divida el segmento de línea en tres segmentos de igual longitud.
2. Dibuje un triángulo equilátero que tenga el segmento medio del paso 1 como base y apunte hacia afuera.
3. Elimine el segmento de línea que es la base del triángulo del paso 2.

### ¿Cómo se define una función de manera recursiva?

Para definir una función, cuyo dominio es el conjunto de los enteros no negativos, de manera recursiva, utilizamos dos pasos:

- **Paso base:** Se especifica el valor de la función en un valor inicial.
- **Paso recursivo:** Se proporciona una regla para obtener su valor en un entero utilizando valores enteros más pequeños.

**Ejemplo.** Suponga que $f$ se define recursivamente como:

- **Paso base:** $f(0) = 3$.
- **Paso recursivo:** $f(n+1) = 2f(n) + 3$.

Obtenga $f(1)$, $f(2)$, $f(3)$ y $f(4)$.

**Solución.** A partir de la definición recursiva se obtiene:

$$
\begin{aligned}
f(1) &= 2f(0) + 3 = 2 \cdot 3 + 3 = 9, \\
f(2) &= 2f(1) + 3 = 2 \cdot 9 + 3 = 21, \\
f(3) &= 2f(2) + 3 = 2 \cdot 21 + 3 = 45, \\
f(4) &= 2f(3) + 3 = 2 \cdot 45 + 3 = 93.
\end{aligned}
$$

**Ejemplo.** Dé una función recursiva de la función factorial $F(n) = n!$.

**Solución.**

- **Paso base:** $F(0) = 1$.
- **Paso recursivo:** $F(n+1) = (n+1)F(n)$.

**Ejemplo.** Dé una función recursiva de $H(n) = \sum_{k=0}^{n} a_k$.

:::{admonition} Solución
:class: dropdown
- **Paso base:** $H(0) = \sum_{k=0}^{0} a_k = a_0$.
- **Paso recursivo:** $H(n+1) = \sum_{k=0}^{n+1} a_k = \left(\sum_{k=0}^{n} a_k\right) + a_{n+1}$.
:::

## Conjuntos y estructuras definidos recursivamente

Las definiciones recursivas de conjuntos también tienen dos partes.

- **Paso base:** Se especifica una colección inicial de elementos.
- **Paso recursivo:** Se proporciona una regla para la formación de nuevos elementos del conjunto a partir de los que ya se conocen.

**Ejemplo.** Considere el subconjunto $S$ de los enteros definido por:

- **Paso base:** $3 \in S$.
- **Paso recursivo:** Si $x \in S$ y $y \in S$, entonces $x + y \in S$.

:::{admonition} Solución
:class: dropdown
Los nuevos elementos de $S$ se van construyendo a partir del paso base de la siguiente manera:

$$
\begin{aligned}
&3 \in S \text{ luego } S = \{3\} \\
&3 \in S \text{ luego } 3+3=6 \in S \text{ luego } S = \{3,6\} \\
&3,6 \in S \text{ luego } 3+6=9 \in S \text{ luego } S = \{3,6,9\} \\
&3,6,9 \in S \text{ luego } 3+9=12 \in S \text{ luego } S = \{3,6,9,12\} \\
&S = \{3,6,9,12,15,18,21,\dots\}
\end{aligned}
$$
:::

**Actividad.** Describa el conjunto $S$ por comprensión.

## Algoritmos recursivos

Un algoritmo se llama recursivo si resuelve un problema reduciéndolo a un caso del mismo problema con datos de entrada más pequeños. Este tipo de algoritmos hallan la solución al problema mediante una secuencia de reducciones, hasta que se llega a un caso inicial cuya solución se conoce.

**Actividad.** Dé un algoritmo recursivo para hallar $a^n$, donde $a$ es un número real distinto de cero y $n$ un entero no negativo.

**Actividad.** Construya una versión recursiva de un algoritmo de búsqueda binaria.

**Ejemplo.** Diseñe un algoritmo recursivo que calcule el factorial.

:::{admonition} Solución
:class: dropdown
```
procedure factorial(n : entero positivo)
if n = 1 then
    factorial(n) := 1
else
    factorial(n) := n · factorial(n − 1)
```
:::

## Introducción a Scala

Los algoritmos recursivos de esta sesión se implementarán en Scala durante el taller de la Sesión 4. Antes de empezar conviene repasar la estructura básica de un programa en Scala y su comparación con Java.

Al igual que en Java, los programas en Scala suelen declarar un **package** al inicio del archivo:

```scala
package com.mycompany.app
```

El `package` permite organizar el código, agrupar clases y objetos relacionados y evitar conflictos de nombres.

En Java, un programa típico inicia con:

```java
public class Main {
    public static void main(String[] args) {
        ...
    }
}
```

En Scala, en lugar de usar `class Main`, normalmente usamos:

```scala
object Main {
    def main(args: Array[String]): Unit = {
        println("¡Hola, Scala!")
    }
}
```

**Diferencias clave con Java:**

- Scala usa `object` en lugar de `class` para el punto de entrada.
- `object` define un **singleton** (una única instancia).
- No se necesitan las palabras clave `public` ni `static`.
- El tipo `Unit` es equivalente a `void` en Java.

Dentro del `object Main`, definimos el método principal:

```scala
def main(args: Array[String]): Unit = {
    println("Programa iniciado")
}
```

- `def` → define una función.
- `args: Array[String]` → argumentos por línea de comandos.
- `: Unit` → tipo de retorno (similar a `void`).
- `=` → separa la firma del cuerpo del método.

En Scala se pueden definir otras funciones dentro del mismo `object`, al mismo nivel que `main`:

```scala
object Main {

    def main(args: Array[String]): Unit = {
        val resultado = cuadrado(5)
        println(resultado)
    }

    def cuadrado(x: Int): Int = {
        x * x
    }
}
```

Aquí `cuadrado` está definido al mismo nivel que `main`, puede llamarse directamente desde `main`, y no necesitamos una clase adicional como en Java.

Scala incluye utilidades matemáticas en el paquete `scala.math`. Una función muy utilizada es `scala.math.pow(base, exponente)`, que sirve para calcular potencias:

```scala
object Main {

    def main(args: Array[String]): Unit = {

        val resultado = scala.math.pow(2, 3)
        println(resultado)  // 8.0
    }
}
```

`scala.math.pow` devuelve un **Double**, incluso si los argumentos son enteros. Si se necesita un entero, se puede convertir usando `.toInt` (que trunca, no redondea):

```scala
val x = scala.math.pow(2, 3)      // 8.0
val y = scala.math.pow(2, 3.5)    // 11.313...

println(y.toInt)  // 11 (se elimina lo que hay después de la coma)
```

**Ejemplo completo:**

```scala
package com.example.app

object Main {

    def main(args: Array[String]): Unit = {

        val base = 3
        val exponente = 4

        val potencia: Int = scala.math.pow(base, exponente).toInt

        println(s"$base^$exponente = $potencia")
    }

    def multiplicar(a: Int, b: Int): Int = {
        a * b
    }
}
```

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
