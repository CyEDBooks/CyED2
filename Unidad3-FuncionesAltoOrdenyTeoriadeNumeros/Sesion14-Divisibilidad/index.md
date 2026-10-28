---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 14: Divisibilidad y módulo"
---

# Unidad 3 · Sesión 14: Divisibilidad y módulo

## Agenda

1. Teoría de números
2. Divisibilidad
3. Propiedades de la divisibilidad
4. Algoritmo de la división y el operador `mod`
5. Propiedades del módulo: congruencias

## 1. Teoría de números

La **teoría de números** estudia los enteros y sus propiedades. En esta unidad trabajaremos con tres ideas básicas: la divisibilidad, el máximo común divisor y la aritmética modular. Esta sesión cubre la primera y la última; el máximo común divisor y el algoritmo de Euclides vienen en la siguiente.

Ya usamos estas ideas sin nombrarlas. En la [Sesión 13](../Sesion13-FuncionesAltoOrdenII/index.md) escribimos

```scala
def divisores(n: Int): List[Int] = (1 to n).toList.filter(d => n % d == 0)
```

El predicado `n % d == 0` pregunta "¿`d` divide a `n`?". En esta sesión le damos a esa pregunta una definición precisa, estudiamos sus propiedades y vemos qué calcula exactamente el operador `%` cuando hay números negativos.

## 2. Divisibilidad

Cuando un entero se divide entre otro entero distinto de cero, el cociente puede ser entero o no: $12/3 = 4$, pero $7/3$ no es entero.

:::{admonition} Definición
Sean $a$ y $b$ enteros con $a \neq 0$. Decimos que **$a$ divide a $b$**, y escribimos $a \mid b$, si existe un entero $c$ tal que $b = ac$. En ese caso decimos que $a$ es un **factor** o **divisor** de $b$ y que $b$ es un **múltiplo** de $a$. Si $a$ no divide a $b$ escribimos $a \nmid b$.
:::

Con cuantificadores, sobre el dominio de los enteros:

$$
a \mid b \iff \exists c\, (ac = b)
$$

Fíjese en la diferencia de notación: $a \mid b$ es una **proposición**, verdadera o falsa; $a / b$ es un **número**. $3 \mid 12$ es verdadero, y $12 / 3$ es 4.

**¿Es cierto que $5 \mid 0$? ¿Y que $0 \mid 5$?**

:::{admonition} Respuesta
:class: dropdown
$5 \mid 0$ es verdadero: $0 = 5 \cdot 0$. Todo entero distinto de cero divide a 0.

$0 \mid 5$ no tiene sentido: la definición exige que el divisor sea distinto de cero. Además, no hay ningún entero $c$ con $0 \cdot c = 5$.
:::

En Scala, $a \mid b$ se decide con el residuo:

```scala
def divide(a: Int, b: Int): Boolean = b % a == 0   // requiere a != 0
```

Funciona también con negativos: `-12 % 3` y `12 % -3` valen 0. En la sección 4 veremos que `%` sí se comporta distinto con negativos cuando el residuo no es cero.

**Múltiplos hasta $n$.** Sean $n$ y $d$ enteros positivos. Los enteros positivos divisibles por $d$ son los de la forma $kd$ con $k$ entero positivo. Si además $kd \le n$, entonces $0 < k \le n/d$. Por tanto hay exactamente

$$
\left\lfloor \frac{n}{d} \right\rfloor
$$

enteros positivos menores o iguales que $n$ divisibles por $d$.

### 2.1 Ejemplos

#### Ejemplo 1

Determine si $3 \mid 12$ y si $3 \mid 7$.

:::{admonition} Resultado
:class: dropdown
$3 \mid 12$, porque $12 = 3 \cdot 4$.

$3 \nmid 7$: $7 = 3 \cdot 2 + 1$, así que $7/3$ no es entero y no existe un entero $c$ con $3c = 7$.
:::

#### Ejemplo 2

Decida cuáles afirmaciones son verdaderas.

1. $4 \mid 28$
2. $-5 \mid 35$
3. $6 \mid -42$
4. $7 \mid 0$
5. $12 \mid 4$

:::{admonition} Resultado
:class: dropdown
| Afirmación | ¿Verdadera? | Por qué |
|---|---|---|
| $4 \mid 28$ | sí | $28 = 4 \cdot 7$ |
| $-5 \mid 35$ | sí | $35 = (-5) \cdot (-7)$ |
| $6 \mid -42$ | sí | $-42 = 6 \cdot (-7)$ |
| $7 \mid 0$ | sí | $0 = 7 \cdot 0$ |
| $12 \mid 4$ | no | $4 = 12c$ obliga a $c = 1/3$, que no es entero |

El signo no cambia la respuesta: $a \mid b$ si y solo si $-a \mid b$, si y solo si $a \mid -b$.
:::

#### Ejemplo 3

Encuentre todos los divisores de 36.

:::{admonition} Resultado
:class: dropdown
Los divisores positivos son $1, 2, 3, 4, 6, 9, 12, 18, 36$. Con sus opuestos, 36 tiene 18 divisores enteros.

Los divisores positivos aparecen en parejas $d \cdot (36/d)$:

$$
1 \cdot 36 \qquad 2 \cdot 18 \qquad 3 \cdot 12 \qquad 4 \cdot 9 \qquad 6 \cdot 6
$$

Por eso basta probar hasta $\sqrt{36} = 6$. La pareja $6 \cdot 6$ tiene un solo divisor, y por eso 36 tiene una cantidad impar de divisores positivos: eso pasa exactamente con los cuadrados perfectos.

Con `divide` y `filter`:

```scala
(1 to 36).filter(d => divide(d, 36))   // Vector(1, 2, 3, 4, 6, 9, 12, 18, 36)
```
:::

#### Ejemplo 4

¿Cuántos enteros positivos menores o iguales que 1000 son divisibles por 7? ¿Cuántos hay entre 100 y 1000, inclusive?

:::{admonition} Resultado
:class: dropdown
$\lfloor 1000/7 \rfloor = 142$. En efecto, $7 \cdot 142 = 994 \le 1000 < 1001 = 7 \cdot 143$.

Entre 100 y 1000 hay que quitar los múltiplos de 7 que son menores o iguales que 99:

$$
\left\lfloor \frac{1000}{7} \right\rfloor - \left\lfloor \frac{99}{7} \right\rfloor = 142 - 14 = 128
$$

Se resta $\lfloor 99/7 \rfloor$ y no $\lfloor 100/7 \rfloor$ porque el 100 está dentro del intervalo. Comprobación: el primer múltiplo es $105 = 7 \cdot 15$ y el último es $994 = 7 \cdot 142$; de 15 a 142 hay $142 - 15 + 1 = 128$ valores de $k$.
:::

#### Ejemplo 5

Compruebe el ejemplo anterior con `count`, y cuente los enteros entre 1 y 100 que son divisibles por 3 o por 5.

```scala
(1 to 1000).count(n => divide(7, n))
(1 to 100).count(n => divide(3, n) || divide(5, n))
```

:::{admonition} Resultado
:class: dropdown
`142` y `47`.

El segundo valor también se obtiene con la fórmula, con un cuidado: los múltiplos de 15 son múltiplos de 3 y de 5, y se contarían dos veces.

$$
\left\lfloor \frac{100}{3} \right\rfloor + \left\lfloor \frac{100}{5} \right\rfloor - \left\lfloor \frac{100}{15} \right\rfloor = 33 + 20 - 6 = 47
$$

`count(p)` es `filter(p).length` en un solo recorrido.
:::

#### Ejemplo 6

Demuestre que para todo entero $n$, $2 \mid n(n+1)$.

:::{admonition} Demostración
:class: dropdown
Todo entero es par o impar. Separamos en dos casos y en cada uno buscamos el entero $c$ de la definición.

- **$n$ par**, $n = 2k$: $\;n(n+1) = 2k(n+1) = 2\,\big(k(n+1)\big)$. El entero es $c = k(n+1)$.
- **$n$ impar**, $n = 2k+1$: $\;n + 1 = 2k + 2 = 2(k+1)$, así que $n(n+1) = 2\,\big(n(k+1)\big)$. El entero es $c = n(k+1)$.

En ambos casos $n(n+1) = 2c$ con $c$ entero. $\blacksquare$

El producto de dos enteros consecutivos siempre es par porque uno de los dos lo es.
:::

#### Ejemplo 7

Demuestre que para todo entero $n$, $3 \mid n^3 - n$.

:::{admonition} Demostración
:class: dropdown
Primero factorizamos: $n^3 - n = n(n^2 - 1) = (n-1)\,n\,(n+1)$, el producto de tres enteros consecutivos. Todo entero es de la forma $3k$, $3k+1$ o $3k+2$.

| Caso | Factor divisible por 3 | $n^3 - n = 3c$ con |
|---|---|---|
| $n = 3k$ | $n = 3k$ | $c = k(n-1)(n+1)$ |
| $n = 3k+1$ | $n - 1 = 3k$ | $c = k\,n\,(n+1)$ |
| $n = 3k+2$ | $n + 1 = 3(k+1)$ | $c = (k+1)(n-1)\,n$ |

En los tres casos aparece el entero $c$ de la definición. $\blacksquare$

Para $n = 5$: $5^3 - 5 = 120 = 3 \cdot 40$. Con la misma idea de casos se demuestra que $6 \mid n^3 - n$: entre tres consecutivos siempre hay un par y un múltiplo de 3.
:::

## 3. Propiedades de la divisibilidad

:::{admonition} Teorema 1
Sean $a$, $b$ y $c$ enteros con $a \neq 0$. Entonces:

1. si $a \mid b$ y $a \mid c$, entonces $a \mid (b + c)$;
2. si $a \mid b$, entonces $a \mid bc$ para todo entero $c$;
3. si $a \mid b$ y $b \mid c$, con $b \neq 0$, entonces $a \mid c$.
:::

:::{admonition} Demostración de (1)
:class: dropdown
Como $a \mid b$, existe un entero $s$ con $b = as$. Como $a \mid c$, existe un entero $t$ con $c = at$. Entonces

$$
b + c = as + at = a(s + t)
$$

y $s + t$ es entero. Por tanto $a \mid (b + c)$. $\blacksquare$
:::

**¿Cómo se demuestra (3)?**

:::{admonition} Respuesta
:class: dropdown
De $a \mid b$ sale $b = as$, y de $b \mid c$ sale $c = bt$. Sustituyendo, $c = (as)t = a(st)$, y $st$ es entero. Todas las demostraciones de esta sección siguen ese esquema: escribir cada hipótesis como una igualdad con un entero desconocido, operar y encontrar el entero que pide la conclusión.
:::

:::{admonition} Corolario
Si $a \mid b$ y $a \mid c$, entonces $a \mid (mb + nc)$ para todo par de enteros $m$ y $n$.
:::

Por (2), $a \mid mb$ y $a \mid nc$; por (1), $a$ divide su suma. La expresión $mb + nc$ se llama **combinación lineal** de $b$ y $c$: si $a$ divide a dos números, divide a todas sus combinaciones lineales. Esta idea es la base del algoritmo de Euclides.

Otros hechos básicos, que salen directamente de la definición:

| Hecho | Por qué |
|---|---|
| $a \mid a$ | $a = a \cdot 1$ |
| $1 \mid a$ | $a = 1 \cdot a$ |
| $a \mid 0$ | $0 = a \cdot 0$ |
| si $a \mid b$ y $b \neq 0$, entonces $\lvert a \rvert \le \lvert b \rvert$ | $b = ac$ con $c \neq 0$, así que $\lvert c \rvert \ge 1$ y $\lvert b \rvert = \lvert a \rvert\,\lvert c \rvert \ge \lvert a \rvert$ |

Sobre los enteros positivos, la relación "divide a" es reflexiva ($a \mid a$), transitiva (propiedad 3) y antisimétrica: si $a \mid b$ y $b \mid a$, el último hecho de la tabla da $a \le b$ y $b \le a$, así que $a = b$. Es un **orden parcial**, como los de la [Sesión 3](../../Unidad1-RelacionesOrdenParcial/Sesion3-EquivalenciaOrdenParcial/index.md). Sobre todos los enteros no es antisimétrica: $3 \mid -3$ y $-3 \mid 3$, pero $3 \neq -3$.

### 3.1 Ejemplos

#### Ejemplo 1

Sabiendo que $4 \mid 12$ y $4 \mid 20$, justifique sin dividir que $4 \mid 32$ y que $4 \mid 84$.

:::{admonition} Resultado
:class: dropdown
$32 = 12 + 20$, así que $4 \mid 32$ por la propiedad (1).

$84 = 12 \cdot 7$, así que $4 \mid 84$ por la propiedad (2).
:::

#### Ejemplo 2

Justifique sin dividir:

1. $3 \mid 42$, sabiendo que $3 \mid 6$ y $6 \mid 42$.
2. $5 \mid 3 \cdot 15 - 2 \cdot 25$.

:::{admonition} Resultado
:class: dropdown
1. Por la propiedad (3), la transitividad.
2. Por el corolario con $b = 15$, $c = 25$, $m = 3$ y $n = -2$: como $5 \mid 15$ y $5 \mid 25$, 5 divide a cualquier combinación lineal de ellos. En efecto, $45 - 50 = -5 = 5 \cdot (-1)$.
:::

#### Ejemplo 3

Ilustre el corolario con $a = 6$, $b = 18$ y $c = 30$.

:::{admonition} Resultado
:class: dropdown
$6 \mid 18$ y $6 \mid 30$. Algunas combinaciones lineales:

| $m$ | $n$ | $18m + 30n$ | Como múltiplo de 6 |
|---|---|---|---|
| 2 | 1 | 66 | $6 \cdot 11$ |
| 1 | $-1$ | $-12$ | $6 \cdot (-2)$ |
| $-5$ | 3 | 0 | $6 \cdot 0$ |
| 2 | $-1$ | 6 | $6 \cdot 1$ |

Todas son múltiplos de 6, como dice el corolario. La última fila muestra algo más: con $m = 2$ y $n = -1$ la combinación vale exactamente 6, el mayor divisor común de 18 y 30. Que esto siempre se pueda lograr es el teorema de Bézout, que veremos con el algoritmo de Euclides.
:::

#### Ejemplo 4

¿Son ciertos los recíprocos de las propiedades (1) y (2)?

1. Si $a \mid (b + c)$, ¿entonces $a \mid b$ y $a \mid c$?
2. Si $a \mid bc$, ¿entonces $a \mid b$ o $a \mid c$?

:::{admonition} Resultado
:class: dropdown
Ninguno de los dos. Basta un contraejemplo para cada uno.

1. $2 \mid (3 + 5)$, pero $2 \nmid 3$ y $2 \nmid 5$.
2. $6 \mid 4 \cdot 9 = 36$, pero $6 \nmid 4$ y $6 \nmid 9$. El factor 2 de 6 está en el 4 y el factor 3 está en el 9.

La segunda afirmación sí es cierta cuando $a$ es primo: es el **lema de Euclides**, que estudiaremos más adelante.
:::

#### Ejemplo 5

Demuestre que si $a \mid b$ y $a \mid (b + c)$, entonces $a \mid c$. Úselo para justificar, sin dividir, que $7 \nmid 703$.

:::{admonition} Resultado
:class: dropdown
$c = (b + c) - b$ es una combinación lineal de $b + c$ y $b$, con coeficientes $1$ y $-1$. Por el corolario, $a \mid c$. $\blacksquare$

Para el 703: $703 = 700 + 3$ y $7 \mid 700$. Si fuera cierto que $7 \mid 703$, la propiedad que acabamos de demostrar daría $7 \mid 3$, que es falso. Por tanto $7 \nmid 703$.

Este es el argumento que se usa en general: si $a$ divide a uno de dos sumandos, entonces $a$ divide a la suma **si y solo si** divide al otro sumando.
:::

#### Ejemplo 6

Demuestre que para todo entero $n$, si $d \mid (3n + 5)$ y $d \mid (2n + 3)$, entonces $d = 1$ o $d = -1$. Concluya que la fracción $\dfrac{3n+5}{2n+3}$ no se puede simplificar para ningún $n$.

:::{admonition} Resultado
:class: dropdown
La idea es encontrar una combinación lineal de $3n + 5$ y $2n + 3$ en la que se cancele la $n$. Multiplicando la primera por 2 y la segunda por $-3$:

$$
2(3n + 5) - 3(2n + 3) = 6n + 10 - 6n - 9 = 1
$$

Por el corolario, $d \mid 1$, y los únicos divisores de 1 son $1$ y $-1$. $\blacksquare$

Simplificar la fracción significa dividir numerador y denominador entre un divisor común distinto de $\pm 1$, y acabamos de ver que no existe. Por ejemplo, con $n = 4$ queda $17/11$, y con $n = 10$ queda $35/23$.
:::

#### Ejemplo 7

**Criterio de divisibilidad por 9.** Demuestre que un entero positivo es divisible por 9 si y solo si la suma de sus cifras es divisible por 9.

:::{admonition} Resultado
:class: dropdown
Tomemos $n = 7425$ y $s = 7 + 4 + 2 + 5 = 18$. Restando:

$$
n - s = 7 \cdot (1000 - 1) + 4 \cdot (100 - 1) + 2 \cdot (10 - 1) + 5 \cdot (1 - 1) = 7 \cdot 999 + 4 \cdot 99 + 2 \cdot 9
$$

En general, si $n = d_k 10^k + \cdots + d_1 10 + d_0$ y $s = d_k + \cdots + d_1 + d_0$, entonces

$$
n - s = d_k (10^k - 1) + \cdots + d_1 (10 - 1)
$$

1. Cada $10^i - 1 = 99\ldots9$ es igual a $9 \cdot 11\ldots1$, así que $9 \mid 10^i - 1$.
2. Por las propiedades (2) y (1), 9 divide a cada sumando $d_i(10^i - 1)$ y a su suma: $9 \mid n - s$.
3. Como $n = (n - s) + s$ y 9 divide al primer sumando, el ejemplo 5 dice que $9 \mid n$ si y solo si $9 \mid s$. $\blacksquare$

Con $n = 7425$, $s = 18$ es divisible por 9, así que $9 \mid 7425$ (en efecto, $7425 = 9 \cdot 825$). En Scala:

```scala
def sumaDigitos(n: Int): Int = n.toString.map(_.asDigit).sum

sumaDigitos(7425)   // 18
7425 % 9            // 0
```

El mismo argumento funciona para el 3, porque $3 \mid 9$ y por transitividad $3 \mid 10^i - 1$.
:::

## 4. Algoritmo de la división y el operador `mod`

La división de un entero entre un entero positivo produce un cociente y un residuo.

:::{admonition} Teorema (algoritmo de la división)
Sean $a$ un entero y $d$ un entero positivo. Existen enteros **únicos** $q$ y $r$, con $0 \le r < d$, tales que

$$
a = dq + r
$$
:::

En esa igualdad, $a$ es el **dividendo**, $d$ el **divisor**, $q$ el **cociente** y $r$ el **residuo** (o resto). Se escribe

$$
q = a \;\mathbf{div}\; d \qquad\qquad r = a \;\mathbf{mod}\; d
$$

Lo esencial es la condición $0 \le r < d$: el residuo nunca es negativo, aunque $a$ lo sea. Para hallar $q$ se toma el múltiplo de $d$ **más cercano a $a$ por debajo**. Con $a = 14$ y $d = 3$, ese múltiplo es $12 = 3 \cdot 4$ y $14 = 3 \cdot 4 + 2$. Con $a = -14$, el múltiplo de 3 inmediatamente por debajo es $-15 = 3 \cdot (-5)$, y

$$
-14 = 3 \cdot (-5) + 1
$$

así que $-14 \;\mathbf{div}\; 3 = -5$ y $-14 \;\mathbf{mod}\; 3 = 1$.

![Recta numérica de -18 a -6 con los múltiplos de 3 marcados y el punto -14 resaltado. Arriba, una flecha de -15 a -14 indica la división matemática: -14 = 3·(-5) + 1, cociente -5 y residuo 1. Abajo, una flecha de -12 a -14 indica lo que calculan / y % en Scala: -14 = 3·(-4) + (-2)](images/division-negativos.svg)

**En Scala.** Los operadores `/` y `%` de `Int` **truncan hacia cero**: `-14 / 3` es `-4` y el residuo queda negativo, `-14 % 3` es `-2`. Para negativos, `%` **no** es el $\mathbf{mod}$ matemático. Hay dos formas de obtenerlo:

| Expresión | $a = 14$ | $a = -14$ |
|---|---|---|
| `a / 3` | `4` | `-4` |
| `a % 3` | `2` | `-2` |
| `Math.floorDiv(a, 3)` | `4` | `-5` |
| `Math.floorMod(a, 3)` | `2` | `1` |
| `((a % 3) + 3) % 3` | `2` | `1` |

Con $a \ge 0$ todas coinciden; la diferencia solo aparece con dividendos negativos.

**Propiedades del operador.** Para todo entero $a$ y todo entero positivo $d$:

| Propiedad | Comentario |
|---|---|
| $0 \le a \;\mathbf{mod}\; d < d$ | hay exactamente $d$ residuos posibles: $0, 1, \ldots, d-1$ |
| $d \mid a \iff a \;\mathbf{mod}\; d = 0$ | la divisibilidad es el caso de residuo cero |
| $a \;\mathbf{mod}\; d = a \iff 0 \le a < d$ | si $a$ ya está en el rango, el residuo es $a$ |
| $(a + kd) \;\mathbf{mod}\; d = a \;\mathbf{mod}\; d$ para todo entero $k$ | sumar múltiplos de $d$ no cambia el residuo |
| $a \;\mathbf{div}\; d = \lfloor a/d \rfloor$ y $a \;\mathbf{mod}\; d = a - d\lfloor a/d \rfloor$ | se demuestra en el ejemplo 6 |

### 4.1 Ejemplos

#### Ejemplo 1

Calcule el cociente y el residuo de dividir 101 entre 11, y 44 entre 8.

:::{admonition} Resultado
:class: dropdown
$101 = 11 \cdot 9 + 2$: $\;101 \;\mathbf{div}\; 11 = 9$ y $101 \;\mathbf{mod}\; 11 = 2$.

$44 = 8 \cdot 5 + 4$: $\;44 \;\mathbf{div}\; 8 = 5$ y $44 \;\mathbf{mod}\; 8 = 4$.

En los dos casos se verifica $0 \le r < d$.
:::

#### Ejemplo 2

Calcule:

1. $17 \;\mathbf{mod}\; 5$
2. $9 \;\mathbf{mod}\; 4$
3. $2 \;\mathbf{mod}\; 2$
4. $7 \;\mathbf{mod}\; 9$
5. $0 \;\mathbf{mod}\; 17$

:::{admonition} Resultado
:class: dropdown
| Expresión | $a = dq + r$ | Resultado |
|---|---|---|
| $17 \;\mathbf{mod}\; 5$ | $17 = 5 \cdot 3 + 2$ | 2 |
| $9 \;\mathbf{mod}\; 4$ | $9 = 4 \cdot 2 + 1$ | 1 |
| $2 \;\mathbf{mod}\; 2$ | $2 = 2 \cdot 1 + 0$ | 0 |
| $7 \;\mathbf{mod}\; 9$ | $7 = 9 \cdot 0 + 7$ | 7 |
| $0 \;\mathbf{mod}\; 17$ | $0 = 17 \cdot 0 + 0$ | 0 |

Cuando $0 \le a < d$, como en $7 \;\mathbf{mod}\; 9$, el cociente es 0 y el residuo es el mismo $a$.
:::

#### Ejemplo 3

Calcule los siguientes módulos de números negativos:

1. $-7 \;\mathbf{mod}\; 3$
2. $-5 \;\mathbf{mod}\; 2$
3. $-21 \;\mathbf{mod}\; 9$
4. $-12 \;\mathbf{mod}\; 5$
5. $-34 \;\mathbf{mod}\; 4$

:::{admonition} Resultado
:class: dropdown
En cada caso se busca el múltiplo de $d$ inmediatamente por debajo de $a$:

| Expresión | Múltiplo por debajo | $a = dq + r$ | Resultado |
|---|---|---|---|
| $-7 \;\mathbf{mod}\; 3$ | $-9$ | $-7 = 3 \cdot (-3) + 2$ | 2 |
| $-5 \;\mathbf{mod}\; 2$ | $-6$ | $-5 = 2 \cdot (-3) + 1$ | 1 |
| $-21 \;\mathbf{mod}\; 9$ | $-27$ | $-21 = 9 \cdot (-3) + 6$ | 6 |
| $-12 \;\mathbf{mod}\; 5$ | $-15$ | $-12 = 5 \cdot (-3) + 3$ | 3 |
| $-34 \;\mathbf{mod}\; 4$ | $-36$ | $-34 = 4 \cdot (-9) + 2$ | 2 |

Un atajo: si $d \nmid a$, entonces $(-a) \;\mathbf{mod}\; d = d - (a \;\mathbf{mod}\; d)$. Por ejemplo, $21 \;\mathbf{mod}\; 9 = 3$ y $-21 \;\mathbf{mod}\; 9 = 9 - 3 = 6$.
:::

#### Ejemplo 4

¿Qué devuelve Scala en cada línea?

```scala
-14 / 3
-14 % 3
Math.floorDiv(-14, 3)
Math.floorMod(-14, 3)
((-14 % 3) + 3) % 3
```

**¿Por qué la última fórmula necesita el `% 3` final?**

:::{admonition} Resultado
:class: dropdown
`-4`, `-2`, `-5`, `1` y `1`.

`/` y `%` truncan hacia cero: $-14 = 3 \cdot (-4) + (-2)$, con residuo negativo. `floorDiv` y `floorMod` redondean hacia abajo y coinciden con $\mathbf{div}$ y $\mathbf{mod}$.

`a % 3` está entre $-2$ y $2$, así que `(a % 3) + 3` está entre 1 y 5: ya no es negativa, pero puede pasarse de 2. Con $a = 14$, `(14 % 3) + 3` es 5; con $a = -15$, `(-15 % 3) + 3` es 3. El `% 3` final la devuelve al rango $0, 1, 2$.
:::

#### Ejemplo 5

Hoy es miércoles. ¿Qué día de la semana será dentro de 100 días? ¿Qué día fue hace 101 días?

:::{admonition} Resultado
:class: dropdown
Numeramos los días: lunes = 0, martes = 1, miércoles = 2, …, domingo = 6. Avanzar $k$ días es sumar $k$ y tomar el residuo módulo 7.

- Dentro de 100 días: $(2 + 100) \;\mathbf{mod}\; 7 = 102 \;\mathbf{mod}\; 7 = 4$, porque $102 = 7 \cdot 14 + 4$. Será **viernes**.
- Hace 101 días: $(2 - 101) \;\mathbf{mod}\; 7 = -99 \;\mathbf{mod}\; 7 = 6$, porque $-99 = 7 \cdot (-15) + 6$. Fue **domingo**.

```scala
val dias = Vector("lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo")

def diaDentroDe(hoy: Int, k: Int): String = dias(Math.floorMod(hoy + k, 7))

diaDentroDe(2, 100)    // "viernes"
diaDentroDe(2, -101)   // "domingo"
```

Con `%` en lugar de `floorMod`, la segunda llamada calcula `-99 % 7 = -1` y `dias(-1)` lanza `IndexOutOfBoundsException`. El mismo razonamiento sirve para un reloj de 24 horas: 50 horas después de las 15:00 son las $(15 + 50) \;\mathbf{mod}\; 24 = 17$, es decir, las 17:00.
:::

#### Ejemplo 6

Demuestre que el cociente y el residuo de dividir $a$ entre $d > 0$ son

$$
q = \left\lfloor \frac{a}{d} \right\rfloor \qquad\qquad r = a - d\left\lfloor \frac{a}{d} \right\rfloor
$$

:::{admonition} Demostración
:class: dropdown
Sea $q = \lfloor a/d \rfloor$. Por definición de la parte entera inferior, $q$ es el único entero con

$$
q \le \frac{a}{d} < q + 1
$$

Multiplicando por $d > 0$, que no cambia las desigualdades:

$$
dq \le a < dq + d
$$

y restando $dq$:

$$
0 \le a - dq < d
$$

Así, $r = a - dq$ cumple $a = dq + r$ con $0 \le r < d$. Como el teorema garantiza que esa pareja es única, $q$ y $r$ son el cociente y el residuo. $\blacksquare$

Con $a = -14$ y $d = 3$: $\lfloor -14/3 \rfloor = \lfloor -4.67 \rfloor = -5$ y $r = -14 - 3 \cdot (-5) = 1$. La parte entera inferior redondea hacia $-\infty$; por eso la función de Scala se llama `floorMod`.
:::

#### Ejemplo 7

La siguiente función calcula $(a \;\mathbf{div}\; d,\; a \;\mathbf{mod}\; d)$ con sumas y restas. Explique por qué es correcta y úsela para demostrar el teorema del algoritmo de la división.

```scala
def divMod(a: Int, d: Int): (Int, Int) = {   // requiere d > 0
  @annotation.tailrec
  def loop(q: Int, r: Int): (Int, Int) =
    if (r < 0) loop(q - 1, r + d)
    else if (r >= d) loop(q + 1, r - d)
    else (q, r)
  loop(0, a)
}

divMod(-14, 3)
(-50 to 50).forall(a => divMod(a, 7) == (Math.floorDiv(a, 7), Math.floorMod(a, 7)))
```

:::{admonition} Resultado
:class: dropdown
`(-5, 1)` y `true`.

**Invariante.** En cada llamado a `loop` se cumple $a = dq + r$. Al inicio, $a = d \cdot 0 + a$. Si $r < 0$, el llamado siguiente usa $q - 1$ y $r + d$, y $d(q-1) + (r + d) = dq + r$. Si $r \ge d$, usa $q + 1$ y $r - d$, y el cálculo es el mismo.

**Terminación.** Si $r$ es negativo, sube de $d$ en $d$ hasta llegar a $[0, d)$; no se pasa, porque antes del último paso $r < 0$ y después $r + d < d$. Si $r \ge d$, baja de $d$ en $d$ y por la misma razón no queda negativo. Hay unos $\lvert a \rvert / d$ pasos.

**Existencia.** Cuando `loop` termina, se cumplen $a = dq + r$ (el invariante) y $0 \le r < d$ (la condición de parada). Eso demuestra que $q$ y $r$ existen para cualquier $a$.

**Unicidad.** Supongamos que $a = dq + r = dq' + r'$, con $0 \le r, r' < d$. Restando, $d(q - q') = r' - r$, así que $d \mid r' - r$. Pero $-d < r' - r < d$. Por la tabla de la sección 3, un múltiplo de $d$ distinto de cero tiene valor absoluto al menos $d$; entonces $r' - r = 0$. De ahí $r = r'$ y $q = q'$. $\blacksquare$

El `forall` comprueba 101 casos, incluidos negativos, contra la biblioteca. Esto no es una demostración, pero es una buena forma de detectar errores. Como algoritmo, `divMod` es lento: $\Theta(\lvert a \rvert / d)$ pasos. El hardware calcula `/` y `%` en tiempo constante.
:::

## 5. Propiedades del módulo: congruencias

Calcule y compare: $7 \;\mathbf{mod}\; 5$ y $2 \;\mathbf{mod}\; 5$; $\;11 \;\mathbf{mod}\; 5$ y $21 \;\mathbf{mod}\; 5$. En los dos pares el residuo es el mismo (2 y 1). La **aritmética modular** estudia los enteros a partir de su residuo, y tiene una notación para decir "dejan el mismo residuo".

:::{admonition} Definición
Sean $a$ y $b$ enteros y $m$ un entero positivo. Decimos que **$a$ es congruente con $b$ módulo $m$**, y escribimos

$$
a \equiv b \pmod{m}
$$

si $a \;\mathbf{mod}\; m = b \;\mathbf{mod}\; m$. Si no lo son, escribimos $a \not\equiv b \pmod{m}$. El entero $m$ es el **módulo**.
:::

Fíjese en la diferencia entre $\mathbf{mod}$ como operador y $\pmod{m}$ en una congruencia. $a \;\mathbf{mod}\; m$ es un **número**, entre $0$ y $m - 1$. $a \equiv b \pmod{m}$ es una **proposición**, una relación entre $a$ y $b$.

:::{admonition} Teorema 2
Sean $a$ y $b$ enteros y $m$ un entero positivo. Son equivalentes:

1. $a \equiv b \pmod{m}$, es decir, $a \;\mathbf{mod}\; m = b \;\mathbf{mod}\; m$;
2. $m \mid (a - b)$;
3. existe un entero $k$ tal que $a = b + km$.
:::

:::{admonition} Demostración
:class: dropdown
**(2) ⇔ (3).** $m \mid (a - b)$ significa que $a - b = km$ para algún entero $k$, es decir, $a = b + km$.

**(1) ⇔ (2).** Por el algoritmo de la división, $a = mq_1 + r_1$ y $b = mq_2 + r_2$ con $0 \le r_1, r_2 < m$. Restando,

$$
a - b = m(q_1 - q_2) + (r_1 - r_2)
$$

Si $r_1 = r_2$, entonces $a - b = m(q_1 - q_2)$ y $m \mid (a - b)$. Recíprocamente, si $m \mid (a - b)$, como también $m \mid m(q_1 - q_2)$, el ejemplo 5 de la sección 3 da $m \mid (r_1 - r_2)$. Pero $-m < r_1 - r_2 < m$, y el único múltiplo de $m$ en ese rango es 0. Por tanto $r_1 = r_2$. $\blacksquare$
:::

En la práctica, la forma (2) es la más cómoda para verificar una congruencia: se resta y se mira si el módulo divide la diferencia.

**Clases de congruencia.** El conjunto de todos los enteros congruentes con $a$ módulo $m$ se llama **clase de congruencia** de $a$ módulo $m$:

$$
[a]_m = \{\, a + km \;:\; k \in \mathbb{Z} \,\} = \{\, \ldots,\ a - 2m,\ a - m,\ a,\ a + m,\ a + 2m,\ \ldots \,\}
$$

La congruencia módulo $m$ es reflexiva, simétrica y transitiva: es una **relación de equivalencia**, como las de la [Sesión 3](../../Unidad1-RelacionesOrdenParcial/Sesion3-EquivalenciaOrdenParcial/index.md). Sus clases de equivalencia son las clases de congruencia, y parten a los enteros en exactamente $m$ clases, una por cada residuo $0, 1, \ldots, m - 1$.

![Los enteros de -10 a 14 coloreados según su residuo módulo 5, y las cinco clases [0], [1], [2], [3] y [4], cada una con sus elementos espaciados de 5 en 5](images/clases-mod-5.svg)

**La congruencia respeta la suma y el producto.**

:::{admonition} Teorema 3
Sea $m$ un entero positivo. Si $a \equiv b \pmod{m}$ y $c \equiv d \pmod{m}$, entonces

$$
a + c \equiv b + d \pmod{m} \qquad\qquad ac \equiv bd \pmod{m}
$$
:::

:::{admonition} Demostración
:class: dropdown
Por el teorema 2, $a = b + sm$ y $c = d + tm$ para algunos enteros $s$ y $t$. Entonces

$$
a + c = (b + d) + (s + t)m
$$

$$
ac = (b + sm)(d + tm) = bd + (bt + sd + stm)\,m
$$

En los dos casos el resultado es "lo de la derecha más un múltiplo de $m$". Por el teorema 2, $a + c \equiv b + d$ y $ac \equiv bd \pmod{m}$. $\blacksquare$
:::

Consecuencias que se usan todo el tiempo:

| Consecuencia | Uso |
|---|---|
| $(a + b) \;\mathbf{mod}\; m = \big((a \;\mathbf{mod}\; m) + (b \;\mathbf{mod}\; m)\big) \;\mathbf{mod}\; m$ | reducir antes de sumar |
| $(ab) \;\mathbf{mod}\; m = \big((a \;\mathbf{mod}\; m)(b \;\mathbf{mod}\; m)\big) \;\mathbf{mod}\; m$ | reducir antes de multiplicar |
| si $a \equiv b \pmod{m}$, entonces $a^k \equiv b^k \pmod{m}$ para todo $k \ge 1$ | aplicar el producto $k$ veces |

La división **no** se comporta igual: $14 \equiv 8 \pmod{6}$, pero al dividir ambos lados entre 2 queda $7 \not\equiv 4 \pmod{6}$.

### 5.1 Ejemplos

#### Ejemplo 1

Calcule y compare cada pareja. Cuando los residuos coincidan, escriba la congruencia.

1. $4 \;\mathbf{mod}\; 3$ y $13 \;\mathbf{mod}\; 3$
2. $22 \;\mathbf{mod}\; 4$ y $38 \;\mathbf{mod}\; 4$
3. $2 \;\mathbf{mod}\; 6$ y $20 \;\mathbf{mod}\; 6$
4. $5 \;\mathbf{mod}\; 3$ y $16 \;\mathbf{mod}\; 3$

:::{admonition} Resultado
:class: dropdown
| Pareja | Residuos | Conclusión |
|---|---|---|
| 4 y 13, módulo 3 | 1 y 1 | $4 \equiv 13 \pmod{3}$ |
| 22 y 38, módulo 4 | 2 y 2 | $22 \equiv 38 \pmod{4}$ |
| 2 y 20, módulo 6 | 2 y 2 | $2 \equiv 20 \pmod{6}$ |
| 5 y 16, módulo 3 | 2 y 1 | $5 \not\equiv 16 \pmod{3}$ |
:::

#### Ejemplo 2

Use la forma $m \mid (a - b)$ del teorema 2 para decidir cada congruencia.

1. $17 \equiv 5 \pmod{6}$
2. $24 \equiv 14 \pmod{6}$
3. $-7 \equiv -19 \pmod{4}$
4. $-5 \equiv 5 \pmod{5}$

:::{admonition} Resultado
:class: dropdown
| Congruencia | $a - b$ | ¿$m \mid (a - b)$? |
|---|---|---|
| $17 \equiv 5 \pmod{6}$ | 12 | sí, $12 = 6 \cdot 2$ |
| $24 \equiv 14 \pmod{6}$ | 10 | no |
| $-7 \equiv -19 \pmod{4}$ | 12 | sí, $12 = 4 \cdot 3$ |
| $-5 \equiv 5 \pmod{5}$ | $-10$ | sí, $-10 = 5 \cdot (-2)$ |

Con este método no hace falta calcular residuos de negativos. Comprobación de la tercera con residuos: $-7 \;\mathbf{mod}\; 4 = 1$ y $-19 \;\mathbf{mod}\; 4 = 1$.
:::

#### Ejemplo 3

1. Decida si $-29$, $-122$ y $226$ son congruentes con 5 módulo 17.
2. Escriba los elementos de $[4]_{12}$ que están entre $-30$ y $30$.

:::{admonition} Resultado
:class: dropdown
1. Se resta 5 y se mira si 17 divide el resultado:

   | $a$ | $a - 5$ | ¿$17 \mid (a - 5)$? | Conclusión |
   |---|---|---|---|
   | $-29$ | $-34$ | sí, $-34 = 17 \cdot (-2)$ | $-29 \equiv 5 \pmod{17}$ |
   | $-122$ | $-127$ | no: $17 \cdot 7 = 119$ y $17 \cdot 8 = 136$ | $-122 \not\equiv 5 \pmod{17}$ |
   | $226$ | $221$ | sí, $221 = 17 \cdot 13$ | $226 \equiv 5 \pmod{17}$ |

2. Los elementos son $4 + 12k$: $\;-20, -8, 4, 16, 28$. Todos dejan residuo 4 al dividirlos entre 12; por ejemplo, $-20 = 12 \cdot (-2) + 4$.
:::

#### Ejemplo 4

Sin multiplicar números grandes, calcule $(1234 + 5678) \;\mathbf{mod}\; 7$ y $(1234 \cdot 5678) \;\mathbf{mod}\; 7$.

:::{admonition} Resultado
:class: dropdown
Primero se reduce cada factor: $1234 = 7 \cdot 176 + 2$ y $5678 = 7 \cdot 811 + 1$. Es decir, $1234 \equiv 2$ y $5678 \equiv 1 \pmod{7}$. Por el teorema 3:

$$
1234 + 5678 \equiv 2 + 1 = 3 \pmod{7} \qquad\qquad 1234 \cdot 5678 \equiv 2 \cdot 1 = 2 \pmod{7}
$$

Las respuestas son 3 y 2. Comprobación en Scala:

```scala
(1234 + 5678) % 7   // 3
(1234 * 5678) % 7   // 2   (1234 * 5678 = 7006652)
```

Esta técnica es la que permite trabajar con números enormes, como en criptografía: se reduce módulo $m$ en cada paso y los números intermedios nunca pasan de $m^2$.
:::

#### Ejemplo 5

Calcule $2^{10} \;\mathbf{mod}\; 7$ y $2^{100} \;\mathbf{mod}\; 7$.

:::{admonition} Resultado
:class: dropdown
La clave es que $2^3 = 8 \equiv 1 \pmod{7}$. Elevando a cualquier potencia, $(2^3)^k \equiv 1^k = 1 \pmod{7}$.

- $2^{10} = (2^3)^3 \cdot 2 \equiv 1 \cdot 2 = 2 \pmod{7}$. En efecto, $1024 = 7 \cdot 146 + 2$.
- $2^{100} = (2^3)^{33} \cdot 2 \equiv 1 \cdot 2 = 2 \pmod{7}$, porque $100 = 3 \cdot 33 + 1$.

$2^{100}$ tiene 31 cifras y no cabe en un `Int` ni en un `Long`. Con `BigInt`:

```scala
BigInt(2).pow(100) % 7   // 2
```

Fíjese que el exponente se redujo usando $100 \;\mathbf{mod}\; 3 = 1$: las potencias de 2 módulo 7 se repiten con período 3 ($2, 4, 1, 2, 4, 1, \ldots$).
:::

#### Ejemplo 6

Demuestre que el cuadrado de cualquier entero es congruente con 0 o con 1 módulo 4. Concluya que 1999 no es suma de dos cuadrados.

:::{admonition} Resultado
:class: dropdown
Todo entero $n$ es congruente con 0, 1, 2 o 3 módulo 4. Por el teorema 3, $n^2$ es congruente con el cuadrado del residuo:

| $n \;\mathbf{mod}\; 4$ | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| $n^2 \;\mathbf{mod}\; 4$ | 0 | 1 | $4 \;\mathbf{mod}\; 4 = 0$ | $9 \;\mathbf{mod}\; 4 = 1$ |

Así que $n^2 \equiv 0$ o $n^2 \equiv 1 \pmod{4}$. $\blacksquare$

Entonces $x^2 + y^2$ es congruente con $0 + 0$, $0 + 1$ o $1 + 1$: con 0, 1 o 2, y **nunca** con 3, módulo 4. Como $1999 = 4 \cdot 499 + 3$, tenemos $1999 \equiv 3 \pmod{4}$ y 1999 no es suma de dos cuadrados.

Una búsqueda exhaustiva lo confirma. Como $45^2 = 2025 > 1999$, basta probar hasta 44:

```scala
(0 to 44).exists(x => (0 to 44).exists(y => x * x + y * y == 1999))   // false
```

La búsqueda revisa $45^2 = 2025$ parejas para un solo número. El argumento modular cubre de una vez a todos los enteros de la forma $4k + 3$.
:::

#### Ejemplo 7

**Criterio de divisibilidad por 11.** Demuestre que un entero es divisible por 11 si y solo si la suma alternada de sus cifras, empezando con signo $+$ por las unidades, es divisible por 11. Aplíquelo a 918082.

:::{admonition} Resultado
:class: dropdown
Como $10 = 11 - 1$, se tiene $10 \equiv -1 \pmod{11}$, y por el teorema 3, $10^i \equiv (-1)^i \pmod{11}$. Si $n = d_k 10^k + \cdots + d_1 10 + d_0$, aplicando otra vez el teorema 3 a cada término y a la suma:

$$
n \equiv d_0 - d_1 + d_2 - \cdots + (-1)^k d_k \pmod{11}
$$

En particular, $n \;\mathbf{mod}\; 11 = 0$ si y solo si la suma alternada es congruente con 0, es decir, si y solo si 11 la divide. $\blacksquare$

Para $n = 918082$, de derecha a izquierda:

$$
2 - 8 + 0 - 8 + 1 - 9 = -22 = 11 \cdot (-2)
$$

así que $11 \mid 918082$ (en efecto, $918082 = 11 \cdot 83462$).

```scala
def sumaAlterna(n: Long): Int =
  n.toString.reverse.map(_.asDigit).zipWithIndex
    .map { case (d, i) => if (i % 2 == 0) d else -d }
    .sum

sumaAlterna(918082)   // -22
918082 % 11           // 0
```

Compare con el criterio del 9 en la sección 3, ejemplo 7. Allí se usó que $9 \mid 10^i - 1$; con congruencias es una sola línea: $10 \equiv 1 \pmod{9}$, así que $10^i \equiv 1$ y $n \equiv d_k + \cdots + d_1 + d_0 \pmod{9}$.
:::

En la próxima sesión usaremos estas propiedades para calcular el máximo común divisor con el algoritmo de Euclides.
