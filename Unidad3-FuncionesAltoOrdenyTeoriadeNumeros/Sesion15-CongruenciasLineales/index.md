---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 15: Aritmética modular y congruencias lineales"
---

# Unidad 3 · Sesión 15: Aritmética modular y congruencias lineales

## Agenda

1. Congruencias
2. Aritmética modular
3. Congruencias lineales
4. Ejercicio: de la aritmética modular a la congruencia lineal

En la [Sesión 14](../Sesion14-Divisibilidad/index.md) definimos $a \;\mathbf{mod}\; d$ como el residuo de la división canónica: siempre está entre $0$ y $d - 1$, aunque $a$ sea negativo. Aquí trabajamos con ese residuo. Las trazas largas están en desplegables con pestañas **Paso 1, Paso 2, …**.

## 1. Congruencias

**Calcule y compare los siguientes pares de valores.**

1. $7 \;\mathbf{mod}\; 5$ y $2 \;\mathbf{mod}\; 5$
2. $4 \;\mathbf{mod}\; 3$ y $13 \;\mathbf{mod}\; 3$
3. $11 \;\mathbf{mod}\; 5$ y $21 \;\mathbf{mod}\; 5$
4. $22 \;\mathbf{mod}\; 4$ y $38 \;\mathbf{mod}\; 4$

:::{admonition} Respuesta
:class: dropdown
1. $7 \;\mathbf{mod}\; 5 = 2 \;\mathbf{mod}\; 5 = 2$
2. $4 \;\mathbf{mod}\; 3 = 13 \;\mathbf{mod}\; 3 = 1$
3. $11 \;\mathbf{mod}\; 5 = 21 \;\mathbf{mod}\; 5 = 1$
4. $22 \;\mathbf{mod}\; 4 = 38 \;\mathbf{mod}\; 4 = 2$

Los números son distintos, pero dejan el mismo residuo. La aritmética modular tiene una notación para eso.
:::

:::{admonition} Definición
Sean $a$ y $b$ enteros y $m$ un entero positivo. Decimos que **$a$ es congruente con $b$ módulo $m$**, y escribimos

$$
a \equiv b \pmod{m}
$$

si $a \;\mathbf{mod}\; m = b \;\mathbf{mod}\; m$. Si no lo son, escribimos $a \not\equiv b \pmod{m}$. El entero $m$ es el **módulo**.
:::

Para los pares anteriores: $7 \equiv 2 \pmod{5}$, $\;4 \equiv 13 \pmod{3}$, $\;11 \equiv 21 \pmod{5}$ y $22 \equiv 38 \pmod{4}$.

Fíjese en la diferencia entre $\mathbf{mod}$ como operador y $\pmod{m}$ en una congruencia. $a \;\mathbf{mod}\; m$ es un **número**, entre $0$ y $m - 1$. $a \equiv b \pmod{m}$ es una **proposición**, una relación entre $a$ y $b$.

**Indique cuáles afirmaciones son ciertas.**

1. $2 \equiv 20 \pmod{6}$
2. $5 \equiv 16 \pmod{3}$
3. $-7 \equiv -19 \pmod{4}$
4. $3 \equiv 38 \pmod{7}$
5. $-5 \equiv 5 \pmod{5}$

:::{admonition} Respuesta
:class: dropdown
| Afirmación | Residuos | ¿Cierta? |
|---|---|---|
| $2 \equiv 20 \pmod{6}$ | 2 y 2 | sí |
| $5 \equiv 16 \pmod{3}$ | 2 y 1 | no |
| $-7 \equiv -19 \pmod{4}$ | 1 y 1 | sí |
| $3 \equiv 38 \pmod{7}$ | 3 y 3 | sí |
| $-5 \equiv 5 \pmod{5}$ | 0 y 0 | sí |
:::

**Ahora reste. Para las cuatro congruencias ciertas, calcule $a - b$. ¿Qué tienen en común esos números con el módulo?**

:::{admonition} Respuesta
:class: dropdown
| Congruencia | $a - b$ | Como múltiplo de $m$ |
|---|---|---|
| $2 \equiv 20 \pmod{6}$ | $-18$ | $6 \cdot (-3)$ |
| $-7 \equiv -19 \pmod{4}$ | $12$ | $4 \cdot 3$ |
| $3 \equiv 38 \pmod{7}$ | $-35$ | $7 \cdot (-5)$ |
| $-5 \equiv 5 \pmod{5}$ | $-10$ | $5 \cdot (-2)$ |

En todas, el módulo divide la diferencia. En la que era falsa, $5 - 16 = -11$, y $3 \nmid -11$.
:::

:::{admonition} Teorema 1
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

Si $r_1 = r_2$, entonces $a - b = m(q_1 - q_2)$ y $m \mid (a - b)$. Recíprocamente, si $m \mid (a - b)$, como también $m \mid m(q_1 - q_2)$, el ejemplo 4 de la sección 2 de la [Sesión 14](../Sesion14-Divisibilidad/index.md) da $m \mid (r_1 - r_2)$. Pero $-m < r_1 - r_2 < m$, y el único múltiplo de $m$ en ese rango es 0. Por tanto $r_1 = r_2$. $\blacksquare$
:::

En la práctica, la forma (2) es la más cómoda para verificar una congruencia: se resta y se mira si el módulo divide la diferencia. Con negativos ahorra calcular residuos.

**Una consecuencia inmediata.** Si $d \mid m$ y $a \equiv b \pmod{m}$, entonces $a \equiv b \pmod{d}$, por transitividad: $d \mid m$ y $m \mid (a - b)$. Con $b = 0$ es lo que usamos en el criterio del 6: si $n \equiv 0 \pmod{6}$, entonces $n \equiv 0 \pmod{2}$ y $n \equiv 0 \pmod{3}$.

**Clases de congruencia.** El conjunto de todos los enteros congruentes con $a$ módulo $m$ se llama **clase de congruencia** de $a$ módulo $m$:

$$
[a]_m = \{\, a + km \;:\; k \in \mathbb{Z} \,\} = \{\, \ldots,\ a - 2m,\ a - m,\ a,\ a + m,\ a + 2m,\ \ldots \,\}
$$

La congruencia módulo $m$ es reflexiva, simétrica y transitiva: es una **relación de equivalencia**, como las de la [Sesión 3](../../Unidad1-RelacionesOrdenParcial/Sesion3-EquivalenciaOrdenParcial/index.md). Sus clases de equivalencia son las clases de congruencia, y parten a los enteros en exactamente $m$ clases, una por cada residuo $0, 1, \ldots, m - 1$.

![Los enteros de -10 a 14 coloreados según su residuo módulo 5, y las cinco clases [0], [1], [2], [3] y [4], cada una con sus elementos espaciados de 5 en 5](images/clases-mod-5.svg)

### 1.1 Ejemplos

#### Ejemplo 1

Use la forma $m \mid (a - b)$ del teorema 1 para decidir cada congruencia.

1. $17 \equiv 5 \pmod{6}$
2. $24 \equiv 14 \pmod{6}$
3. $16 \equiv 4 \pmod{12}$
4. $38 \equiv 3 \pmod{7}$

:::{admonition} Resultado
:class: dropdown
| Congruencia | $a - b$ | ¿$m \mid (a - b)$? |
|---|---|---|
| $17 \equiv 5 \pmod{6}$ | 12 | sí, $12 = 6 \cdot 2$ |
| $24 \equiv 14 \pmod{6}$ | 10 | no |
| $16 \equiv 4 \pmod{12}$ | 12 | sí, $12 = 12 \cdot 1$ |
| $38 \equiv 3 \pmod{7}$ | 35 | sí, $35 = 7 \cdot 5$ |
:::

#### Ejemplo 2

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

## 2. Aritmética modular

**$1234$ deja residuo 2 al dividirlo entre 7, y $5678$ deja residuo 1. Sin hacer la suma ni la multiplicación, ¿qué residuo deja $1234 + 5678$? ¿Y $1234 \cdot 5678$?**

:::{admonition} Respuesta
:class: dropdown
Pruebe la conjetura más simple: operar con los residuos. $2 + 1 = 3$ y $2 \cdot 1 = 2$. Comprobemos:

```scala
(1234 + 5678) % 7   // 3
(1234 * 5678) % 7   // 2
```

Coinciden. El teorema siguiente dice que no fue suerte.
:::

:::{admonition} Teorema 2
Sea $m$ un entero positivo. Si $a \equiv b \pmod{m}$ y $c \equiv d \pmod{m}$, entonces

$$
a + c \equiv b + d \pmod{m} \qquad\qquad ac \equiv bd \pmod{m}
$$
:::

:::{admonition} Demostración
:class: dropdown
Por el teorema 1, $a = b + sm$ y $c = d + tm$ para algunos enteros $s$ y $t$. Entonces

$$
a + c = (b + d) + (s + t)m
$$

$$
ac = (b + sm)(d + tm) = bd + (bt + sd + stm)\,m
$$

En los dos casos el resultado es "lo de la derecha más un múltiplo de $m$". Por el teorema 1, $a + c \equiv b + d$ y $ac \equiv bd \pmod{m}$. $\blacksquare$
:::

Consecuencias que se usan todo el tiempo:

| Consecuencia | Uso |
|---|---|
| $(a + b) \;\mathbf{mod}\; m = \big((a \;\mathbf{mod}\; m) + (b \;\mathbf{mod}\; m)\big) \;\mathbf{mod}\; m$ | reducir antes de sumar |
| $(ab) \;\mathbf{mod}\; m = \big((a \;\mathbf{mod}\; m)(b \;\mathbf{mod}\; m)\big) \;\mathbf{mod}\; m$ | reducir antes de multiplicar |
| si $a \equiv b \pmod{m}$, entonces $a^k \equiv b^k \pmod{m}$ para todo $k \ge 1$ | aplicar el producto $k$ veces |

La división **no** se comporta igual: $14 \equiv 8 \pmod{6}$, pero al dividir ambos lados entre 2 queda $7 \not\equiv 4 \pmod{6}$. Volveremos a esto en la [Sesión 16](../Sesion16-AlgoritmoEuclides/index.md).

### 2.1 Ejemplos

#### Ejemplo 1

Sin multiplicar números grandes, calcule $(123 + 4567) \;\mathbf{mod}\; 9$ y $(123 \cdot 4567) \;\mathbf{mod}\; 9$.

:::{admonition} Resultado
:class: dropdown
Primero se reduce cada número: $123 = 9 \cdot 13 + 6$ y $4567 = 9 \cdot 507 + 4$. Es decir, $123 \equiv 6$ y $4567 \equiv 4 \pmod{9}$. Por el teorema 2:

$$
123 + 4567 \equiv 6 + 4 = 10 \equiv 1 \pmod{9} \qquad\qquad 123 \cdot 4567 \equiv 6 \cdot 4 = 24 \equiv 6 \pmod{9}
$$

Las respuestas son 1 y 6. Comprobación en Scala:

```scala
(123 + 4567) % 9   // 1
(123 * 4567) % 9   // 6
```

Esta técnica es la que permite trabajar con números enormes, como en criptografía: se reduce módulo $m$ en cada paso y los números intermedios nunca pasan de $m^2$.
:::

#### Ejemplo 2

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

#### Ejemplo 3

Demuestre que el cuadrado de cualquier entero es congruente con 0 o con 1 módulo 4. Concluya que 1999 no es suma de dos cuadrados.

:::{admonition} Resultado
:class: dropdown
Todo entero $n$ es congruente con 0, 1, 2 o 3 módulo 4. Por el teorema 2, $n^2$ es congruente con el cuadrado del residuo:

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

#### Ejemplo 4

**Criterio de divisibilidad por 11.** Demuestre que un entero es divisible por 11 si y solo si la suma alternada de sus cifras, empezando con signo $+$ por las unidades, es divisible por 11. Aplíquelo a 918082.

:::{admonition} Resultado
:class: dropdown
Como $10 = 11 - 1$, se tiene $10 \equiv -1 \pmod{11}$, y por el teorema 2, $10^i \equiv (-1)^i \pmod{11}$. Si $n = d_k 10^k + \cdots + d_1 10 + d_0$, aplicando otra vez el teorema 2 a cada término y a la suma:

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

Compare con el criterio del 9 de la [Sesión 14](../Sesion14-Divisibilidad/index.md). Allí se usó que $9 \mid 10^i - 1$; con congruencias es una sola línea: $10 \equiv 1 \pmod{9}$, así que $10^i \equiv 1$ y $n \equiv d_k + \cdots + d_1 + d_0 \pmod{9}$.
:::

## 3. Congruencias lineales

**Encuentre $x$ tal que $3x \equiv 4 \pmod{7}$.**

:::{admonition} Respuesta
:class: dropdown
Por tanteo. Basta probar los residuos de $x$ de 0 a 6, porque sumarle 7 a $x$ le suma 21 a $3x$, y 21 es múltiplo de 7.

| $x$ | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|---|
| $3x$ | 0 | 3 | 6 | 9 | 12 | 15 | 18 |
| $3x \;\mathbf{mod}\; 7$ | 0 | 3 | 6 | 2 | 5 | 1 | **4** |

$x = 6$ funciona: $18 = 7 \cdot 2 + 4$.
:::

**¿Hay más soluciones? Pruebe con $x = 13$ y con $x = -1$.**

:::{admonition} Respuesta
:class: dropdown
Las dos funcionan. $3 \cdot 13 = 39 = 7 \cdot 5 + 4$ y $3 \cdot (-1) = -3 = 7 \cdot (-1) + 4$.

Hay infinitas: $\ldots, -8, -1, 6, 13, 20, \ldots$ Son exactamente los elementos de $[6]_7$. Si $x_0$ es solución, $x_0 + 7k$ también, porque $3(x_0 + 7k) = 3x_0 + 21k \equiv 3x_0 \pmod{7}$.
:::

:::{admonition} Definición
Una **congruencia lineal** es una congruencia de la forma

$$
ax \equiv b \pmod{m}
$$

con $m$ entero positivo, $a$ y $b$ enteros y $x$ una incógnita entera. Una **solución** es un entero $x$ que la cumple. Las soluciones vienen por clases completas módulo $m$, así que basta dar los residuos $x \in \{0, 1, \ldots, m-1\}$ que funcionan.
:::

Antes de buscar un método, fijemos qué se pide:

| Análisis | Congruencia lineal |
|---|---|
| **Entradas** | tres enteros: $a$, $b$ y $m > 0$ |
| **Salida** | la lista de residuos $x$, entre $0$ y $m - 1$, con $ax \equiv b \pmod{m}$ |
| **Con $a = 3$, $b = 4$, $m = 7$** | `List(6)`, que representa a $x \equiv 6 \pmod{7}$ |

La solución más directa es la del tanteo: probarlos todos.

```scala
def porTanteo(a: Int, b: Int, m: Int): List[Int] =
  (0 until m).toList.filter(x => Math.floorMod(a * x - b, m) == 0)

porTanteo(3, 4, 7)   // List(6)
```

Hace $m$ intentos. Con $m = 7$ es inmediato. Con un módulo de un millón ya es un millón de intentos para **una sola** congruencia, y los módulos de la criptografía tienen cientos de cifras. Necesitamos un método que no pruebe uno por uno.

### 3.1 Ejemplos

#### Ejemplo 1

Resuelva por tanteo.

1. $5x \equiv 2 \pmod{7}$
2. $7x \equiv 3 \pmod{5}$
3. $11x \equiv 5 \pmod{6}$

:::{admonition} Resultado
:class: dropdown
1. $5x \;\mathbf{mod}\; 7$ para $x = 0, \ldots, 6$ es $0, 5, 3, 1, 6, 4, 2$. Solución: $x \equiv 6 \pmod{7}$.
2. Como $7 \equiv 2 \pmod{5}$, la congruencia equivale a $2x \equiv 3 \pmod{5}$. Con $x = 0, \ldots, 4$ se obtiene $0, 2, 4, 1, 3$. Solución: $x \equiv 4 \pmod{5}$.
3. Como $11 \equiv 5 \pmod{6}$, equivale a $5x \equiv 5 \pmod{6}$. Con $x = 0, \ldots, 5$ se obtiene $0, 5, 4, 3, 2, 1$. Solución: $x \equiv 1 \pmod{6}$.

Reducir el coeficiente módulo $m$ antes de empezar acorta las cuentas.
:::

## 4. Ejercicio: de la aritmética modular a la congruencia lineal

Con $\mathbf{mod}$ avanzamos: dado un número, calculamos a dónde llega. Con una congruencia lineal retrocedemos: dado a dónde llegó, calculamos de qué número salió. Los tres ejercicios siguientes hacen ese recorrido de ida y vuelta.

### Ejercicio 1: el calendario

En el ejemplo 6 de la sección 3 de la [Sesión 14](../Sesion14-Divisibilidad/index.md) calculamos que, si hoy es miércoles (día 2), dentro de $k$ días será el día $(2 + k) \;\mathbf{mod}\; 7$.

Un respaldo corre hoy, miércoles, y después cada 5 días. **¿Después de cuántas ejecuciones cae en domingo por primera vez?**

:::{admonition} Solución
:class: dropdown
**Entradas:** día inicial 2, periodo 5, día objetivo 6. **Salida:** el menor $x > 0$ de ejecuciones.

**Ida (aritmética modular).** Tras $x$ ejecuciones, el respaldo cae en el día $(2 + 5x) \;\mathbf{mod}\; 7$.

**Vuelta (congruencia lineal).** Pedir que sea domingo es pedir

$$
2 + 5x \equiv 6 \pmod{7} \quad\Longleftrightarrow\quad 5x \equiv 4 \pmod{7}
$$

Probamos los residuos de $x$:

| $x$ | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|---|
| $5x \;\mathbf{mod}\; 7$ | 0 | 5 | 3 | 1 | 6 | **4** | 2 |

El menor valor positivo es $x = 5$: son 25 días.

**Prueba.** Reutilizamos la función de la Sesión 14:

```scala
val dias = Vector("lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo")

def diaDentroDe(hoy: Int, k: Int): String = dias(Math.floorMod(hoy + k, 7))

diaDentroDe(2, 5 * 5)   // "domingo"
```
:::

**¿Y si el respaldo corre cada 14 días? Muestre que nunca cae en domingo.**

:::{admonition} Solución
:class: dropdown
La congruencia es $14x \equiv 4 \pmod{7}$. Como $14 \equiv 0 \pmod{7}$, queda $0 \equiv 4 \pmod{7}$, que es falsa para todo $x$. El respaldo cae siempre en miércoles.
:::

### Ejercicio 2: el dígito perdido

Un código de 10 dígitos $d_1 d_2 \ldots d_{10}$ es válido si

$$
1 \cdot d_1 + 2 \cdot d_2 + \cdots + 10 \cdot d_{10} \equiv 0 \pmod{11}
$$

Este es el esquema del ISBN-10. El código `030?406152` perdió el cuarto dígito. **¿Cuál era?**

:::{admonition} Solución
:class: dropdown
**Entradas:** nueve dígitos y la posición del que falta. **Salida:** el dígito $x$.

**Ida.** Sumamos los términos conocidos, reduciendo módulo 11:

| $i$ | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|---|---|---|---|---|---|---|---|---|---|---|
| $d_i$ | 0 | 3 | 0 | $x$ | 4 | 0 | 6 | 1 | 5 | 2 |
| $i \cdot d_i$ | 0 | 6 | 0 | $4x$ | 20 | 0 | 42 | 8 | 45 | 20 |

La suma de los conocidos es $141 = 11 \cdot 12 + 9$. Entonces $141 \equiv 9 \pmod{11}$.

**Vuelta.** Queda $4x + 9 \equiv 0 \pmod{11}$, es decir, $4x \equiv -9 \equiv 2 \pmod{11}$. Probamos los dígitos:

| $x$ | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
|---|---|---|---|---|---|---|---|---|---|---|
| $4x \;\mathbf{mod}\; 11$ | 0 | 4 | 8 | 1 | 5 | 9 | **2** | 6 | 10 | 3 |

El dígito era **6**.

**Prueba.**

```scala
val digitos = List(0, 3, 0, 6, 4, 0, 6, 1, 5, 2)

digitos.zipWithIndex.map { case (d, i) => (i + 1) * d }.sum % 11   // 0
```
:::

### Ejercicio 3: cifrado afín

Numeramos las letras: A = 0, B = 1, …, Z = 25. Para cifrar, cada letra $p$ se reemplaza por

$$
c = (7p + 3) \;\mathbf{mod}\; 26
$$

1. Cifre la palabra `HOLA`.
2. Escriba la congruencia lineal que hay que resolver para descifrar una letra.
3. Descifre el mensaje `RDZD`, probando valores de $p$.
4. Implemente `cifrar` y `descifrar` en Scala.
5. Muestre que **no** se puede usar $c = (13p + 3) \;\mathbf{mod}\; 26$ como cifrado.

**Análisis.** Primero, el problema:

| Análisis | Cifrado afín |
|---|---|
| **Entradas** | los coeficientes $a = 7$ y $k = 3$, y un texto en mayúsculas |
| **Salida de `cifrar`** | el texto con cada letra reemplazada por $(ap + k) \;\mathbf{mod}\; 26$ |
| **Salida de `descifrar`** | el texto original |
| **Proceso** | cifrar es una **ida** con aritmética modular; descifrar es una **vuelta**: una congruencia lineal por letra |

:::::{admonition} Solución de 1: cifrar HOLA
:class: dropdown
::::{tab-set}
:::{tab-item} Paso 1
```{code-block} text
:emphasize-lines: 2
letra  p   7p + 3   c    letra cifrada
H      7   52       0    A
```

> $52 = 26 \cdot 2 + 0$.

:::
:::{tab-item} Paso 2
```{code-block} text
:emphasize-lines: 3
letra  p   7p + 3   c    letra cifrada
H      7   52       0    A
O     14   101      23   X
```

> $101 = 26 \cdot 3 + 23$.

:::
:::{tab-item} Paso 3
```{code-block} text
:emphasize-lines: 4
letra  p   7p + 3   c    letra cifrada
H      7   52       0    A
O     14   101      23   X
L     11   80       2    C
```

:::
:::{tab-item} Paso 4
```{code-block} text
:emphasize-lines: 5
letra  p   7p + 3   c    letra cifrada
H      7   52       0    A
O     14   101      23   X
L     11   80       2    C
A      0   3        3    D
```

> `HOLA` se cifra como `AXCD`.

:::
::::
:::::

:::::{admonition} Solución de 2: la congruencia para descifrar
:class: dropdown
::::{tab-set}
:::{tab-item} Paso 1
```{code-block} text
:emphasize-lines: 1
c ≡ 7p + 3 (mod 26)
```

> Se conoce $c$ y se busca $p$. **¿Qué tipo de problema es?**

:::
:::{tab-item} Paso 2
```{code-block} text
:emphasize-lines: 2
c ≡ 7p + 3 (mod 26)
7p ≡ c - 3 (mod 26)
```

> Es una congruencia lineal en $p$, con $a = 7$, $b = c - 3$ y $m = 26$.

:::
::::
:::::

:::{admonition} Solución de 3: descifrar RDZD
:class: dropdown
Probamos $p = 0, 1, 2, \ldots$ hasta que $7p \;\mathbf{mod}\; 26$ coincida con $(c - 3) \;\mathbf{mod}\; 26$:

| Letra cifrada | $c$ | $(c - 3) \;\mathbf{mod}\; 26$ | $p$ | Comprobación | Letra |
|---|---|---|---|---|---|
| R | 17 | 14 | 2 | $7 \cdot 2 = 14$ | C |
| D | 3 | 0 | 0 | $7 \cdot 0 = 0$ | A |
| Z | 25 | 22 | 18 | $7 \cdot 18 = 126 = 26 \cdot 4 + 22$ | S |
| D | 3 | 0 | 0 | $7 \cdot 0 = 0$ | A |

El mensaje es `CASA`.
:::

:::{admonition} Solución de 4: implementación
:class: dropdown
Un cifrado es un `map` letra por letra. Con currying, la clave queda fija y el resultado es una función, como en la [Sesión 12](../Sesion12-FuncionesAltoOrdenI/index.md). Para descifrar reutilizamos `porTanteo`:

```scala
def aNumeros(s: String): List[Int] = s.toList.map(l => l - 'A')
def aTexto(xs: List[Int]): String = xs.map(n => ('A' + n).toChar).mkString

def cifrar(a: Int, k: Int)(p: Int): Int = Math.floorMod(a * p + k, 26)
def descifrar(a: Int, k: Int)(c: Int): Int = porTanteo(a, c - k, 26).head

val ida    = cifrar(7, 3)
val vuelta = descifrar(7, 3)

aTexto(aNumeros("HOLA").map(ida))      // "AXCD"
aTexto(aNumeros("RDZD").map(vuelta))   // "CASA"

(0 until 26).forall(p => vuelta(ida(p)) == p)   // true
```

La última línea comprueba las 26 letras: `vuelta` deshace a `ida`.
:::

:::{admonition} Solución de 5: el coeficiente 13 no sirve
:class: dropdown
Se ve directamente en la tabla:

| $p$ | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| $13p \;\mathbf{mod}\; 26$ | 0 | 13 | 0 | 13 | 0 |

A, C, E… se cifran con la misma letra, así que al descifrar no se sabe de cuál salió. Un coeficiente sirve solo si las 26 letras producen 26 valores distintos:

```scala
(1 until 26).toList.filter(a => (0 until 26).map(cifrar(a, 0)).distinct.size == 26)
// List(1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25)
```
:::

En este ejercicio, cada letra exigió probar hasta 26 valores. En la [Sesión 16](../Sesion16-AlgoritmoEuclides/index.md) encontraremos una fórmula que descifra sin probar nada.
