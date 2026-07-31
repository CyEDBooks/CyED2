---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 2: Introducción a Scala y Recursividad"
---

# Unidad 1 · Sesión 2: Introducción a Scala y Recursividad

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

### Herramientas para trabajar con Scala

Scala es un **lenguaje compilado**: el código fuente no se ejecuta directamente, sino que primero se traduce a otra representación que sí puede ejecutarse.

:::{image} images/scala-compilado-vs-interpretado.png
:alt: Comparación entre un lenguaje compilado (el código fuente pasa por un compilador y genera un ejecutable) y un lenguaje interpretado (el código fuente se ejecuta directamente mediante un intérprete)
:width: 80%
:::

En un lenguaje compilado, el código fuente pasa por un **compilador** que produce un programa (binario o ejecutable); ese programa es el que finalmente se ejecuta y produce el resultado. En un lenguaje interpretado, en cambio, el código fuente se entrega directamente a un **intérprete**, que lo ejecuta y produce el resultado sin generar un ejecutable intermedio.

En el caso de Scala, el compilador no genera un ejecutable nativo, sino **bytecode** que corre sobre la máquina virtual de Java (JVM), la misma que ejecuta los programas de Java. Por eso Scala necesita tener instalado un JDK (8 u 11) además del propio compilador de Scala.

:::{image} images/scala-compilador-diagrama.png
:alt: Diagrama que muestra que el compilador de Scala traduce el código fuente a bytecode (Machine code), etiquetado con JDK 8/11 y JVM, para indicar que ese bytecode corre sobre la máquina virtual de Java
:width: 80%
:::

Además del compilador, Scala requiere una herramienta que asista la configuración, compilación y ejecución de proyectos: **sbt** (*scala build tool*).

:::{image} images/sbt-logo.png
:alt: Logotipo de sbt (scala build tool)
:width: 30%
:::

sbt permite:

- Crear y configurar proyectos.
- Compilar y ejecutar el código.
- Ejecutar pruebas unitarias.

Un proyecto creado con sbt tiene, entre otros, un archivo `build.sbt` y las carpetas `project`, `src` y `target`:

:::{image} images/sbt-estructura-proyecto.png
:alt: Estructura de carpetas de un proyecto sbt: build.sbt, project, src y target
:width: 60%
:::

**Actividad.** Verifique la instalación ejecutando en la línea de comandos:

```
scala -version
```

y, para comprobar sbt:

```
sbt
exit
```

(el comando `exit` cierra la sesión interactiva de sbt).

### El REPL (Read-Eval-Print-Loop)

Un REPL es un ambiente de programación simple e interactivo. Su ciclo de trabajo consiste en tres pasos que se repiten:

1. El usuario digita una o más expresiones.
2. El REPL evalúa la expresión.
3. Se muestra al usuario el resultado.

:::{image} images/repl-diagrama.png
:alt: Diagrama del REPL: el código fuente se entrega a un intérprete que produce y muestra el resultado en pantalla
:width: 50%
:::

El REPL de Scala se puede iniciar de dos formas: desde la línea de comandos o desde una IDE.

**Por línea de comandos** hay, a su vez, dos opciones:

**Opción A — comando `scala`.** Escribir en el prompt:

```
scala
```

:::{image} images/repl-opcion-a-terminal.png
:alt: Terminal mostrando el inicio del REPL de Scala con el comando "scala"
:width: 90%
:::

Para salir: `ctrl + d`, o escribir `exit`.

**Opción B — comando `sbt console`.** Escribir en el prompt:

```
sbt
```

y luego, dentro del prompt de sbt, escribir:

```
console
```

:::{image} images/repl-opcion-b-terminal.png
:alt: Terminal mostrando el inicio de sbt y luego del REPL de Scala mediante el comando "console"
:width: 90%
:::

Para salir: `ctrl + d` cierra la consola de Scala y luego `exit` cierra sbt.

**Usando una IDE**, hay que ubicar el modo *Worksheet*. IntelliJ y VSCode soportan las herramientas de Scala, pero en ambos casos es necesario tener correctamente instalado y configurado el compilador de Scala y sbt (revise la documentación oficial y la del repositorio del curso). Mientras se configura el entorno local, también se puede usar [Scastie](https://scastie.scala-lang.org/) en modo *worksheet* para probar código de forma inmediata en el navegador.

### Programación funcional vs. imperativa

Scala es un lenguaje **multiparadigma**: soporta tanto el estilo funcional como el imperativo (orientado a objetos).

- **Expresiones (*expression*):** combinaciones de valores y operadores que, al evaluarse, producen un valor. Son declarativas: no cambian los valores sobre los que operan. Un programa funcional es, en esencia, un conjunto de expresiones y funciones que se evalúan, producen un valor y cumplen con una tarea específica. Son ejemplos de expresiones: expresiones sobre números, booleanos o cadenas, llamados a funciones, y expresiones condicionales.
- **Instrucciones (*statement*):** unidades o bloques constructores de los programas en el paradigma imperativo que representan una acción que debe ejecutarse. A diferencia de las expresiones, pueden modificar el estado: algunas instrucciones producen cambios en los valores de las variables. Un programa imperativo es un conjunto de instrucciones que se ejecutan de forma secuencial y cumplen con una tarea específica. Son ejemplos de instrucciones: `print("hey")`, `println("Hello, world!")`, la definición de variables inmutables y la definición de funciones.

**Actividad.** Digite en el REPL algunas expresiones con números y luego una instrucción (por ejemplo, un `println`), y observe la diferencia entre lo que el REPL le muestra en cada caso.

### Tipado estático

En Scala los tipos son explícitamente definidos por el programador y se verifican en tiempo de compilación. Sin embargo, el compilador puede **inferir** el tipo de algunas variables y expresiones, de modo que se puede omitir el tipo para que el código sea más legible y elegante.

Las variables inmutables se definen con la palabra clave `val`:

```
val <nombre>(: <tipo>)? = <expresión>
```

Por ejemplo:

```scala
val a = 2 + 6
val msg: String = "hola mundo"
```

En el primer caso el tipo (`Int`) se infiere de la expresión `2 + 6`; en el segundo se declara explícitamente como `String`.

### Definiendo funciones

:::{image} images/scala-definiendo-funciones.png
:alt: Diagrama anotado de la definición de una función en Scala, def max(x Int, y Int) Int = if x > y then x else y, señalando la palabra clave def, el nombre de la función, la lista de parámetros entre paréntesis, el tipo de retorno, el signo igual y el cuerpo de la función indentado
:width: 80%
:::

**Ejemplo.** Función que calcula el cubo de un número:

```scala
def cubo(n: Int) = n * n * n
```

Al llamarla con `cubo(3)` se obtiene `27`. Nótese que:

- No es necesario definir el tipo de retorno; el compilador lo infiere.
- No hay palabra clave `return`: el valor de la última expresión del cuerpo es el valor devuelto.
- No hay un carácter que señale el fin de una instrucción (como el `;` de Java).
- No hay caracteres que marquen el inicio y el fin de un bloque cuando el cuerpo cabe en una sola línea.

**Actividad.**

- Defina y pruebe una función que evalúe el polinomio $n^3 + 2n$.
- Defina y pruebe una función que evalúe el polinomio $n^2 - 7n + 12$.

### Funciones recursivas en Scala

**Ejemplo.** Función que calcula la suma de los enteros desde $0$ hasta $n$:

```scala
def sum(n: Int): Int = if n == 0 then 0 else n + sum(n - 1)
```

A diferencia de `cubo`, aquí sí se necesita declarar el tipo de retorno (`Int`), porque el compilador no siempre puede inferir el tipo de una función recursiva a partir de su propio cuerpo. Como antes, no hay `return`, ni carácter de fin de instrucción, ni caracteres de inicio-fin de bloque.

Esta es exactamente la función recursiva $H$ de la sección anterior, escrita en Scala: el **paso base** es `n == 0`, y el **paso recursivo** es `n + sum(n - 1)`.

### La expresión condicional `if`

```scala
if <comparación> then <expresión> else <expresión>
```

es la expresión condicional de Scala, usada arriba en `sum`. Es equivalente al operador ternario de Java:

```java
(comparación) ? <expresión> : <expresión>
```

Por ejemplo, `if n == 0 then 0 else n + sum(n - 1)` en Scala equivale a `(a == 10) ? 20 : 30` en Java (con la comparación y las expresiones correspondientes).

**Actividad.** Defina y pruebe en Scala la siguiente función, que verifica si $n^3 + 2n$ es divisible por 3:

```scala
def f(num: Int) =
  (((num * num * num) + (2 * num)) % 3) == 0
```

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara, y de las diapositivas "Introducción a Scala" de Angela Villota, Jenifer Viafara y Juan Caicedo.*
