---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 6: Conceptos y ejemplos de inducción matemática"
---

# Unidad 2 · Sesión 6: Conceptos y ejemplos de inducción matemática

## Técnicas de demostración

**Inducción matemática.** Muchos teoremas establecen que $P(n)$ es verdad para todos los enteros positivos $n$, donde $P(n)$ es una expresión matemática.

Una prueba por inducción matemática consiste de dos pasos:

- **Paso base.** Se muestra que la proposición $P(1)$ se cumple.
- **Paso inductivo.** Se supone que $P(n)$ es cierto y se intenta demostrar que $P(n+1)$ también. $P(n) \rightarrow P(n+1)$.

## Inducción matemática

### Tema

Es una técnica de demostración para proposiciones de la forma $\forall n\, P(n)$, donde el dominio es el conjunto de los enteros positivos.

¿Sobre qué clase de teoremas se puede aplicar esta técnica? Teoremas en los que se afirma que $P(n)$ es verdadera para todos los enteros positivos $n$.

Una demostración por inducción de $P(n)$ verdadera para todo entero positivo $n$ consiste en dos pasos:

- **(Paso base:)** Se muestra que la proposición $P(1)$ es verdadera.
- **(Paso inducción:)** Se muestra que la implicación $P(k) \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$.

- La sentencia $P(k)$ para un entero fijo $k$ se denomina hipótesis de inducción o hipótesis inductiva.
- Completar los dos pasos de una demostración de este tipo prueba que $P(n)$ es verdadera para todo entero $n>0$.
- Expresado como regla de inferencia, esta técnica se enuncia así:

$$
[P(1) \land \forall k\, (P(k) \rightarrow P(k+1))] \rightarrow \forall n\, P(n).
$$

Para completar una demostración por inducción:

- Muestre que $P(1)$ es verdadera.
- Luego demuestre que $P(k) \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$.

Queremos mostrar que $P(k+1)$ **no puede ser falsa** cuando $P(k)$ es **verdadera**.

**Plantilla de una demostración.** Partes de una demostración con inducción matemática.

**Ejemplo.** Use el método de inducción matemática para demostrar que la suma de los $n$ primeros enteros positivos impares es $n^2$.

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la proposición que afirma que la suma de los $n$ primeros enteros positivos impares es $n^2$.

**Paso Base:** $P(1)$ afirma que la suma del primer entero impar es $1^2$. Esto es cierto pues el primer entero positivo impar es $1$.

**Paso de Inducción:** Para completar el paso de inducción se debe demostrar que la proposición $P(k) \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$. Para esto suponemos que $P(k)$ es verdadera para un entero positivo $k$, esto es,

$$
1 + 3 + 5 + \dots + (2k-1) = k^2.
$$

Ahora se debe demostrar que $P(k+1)$ es verdadera, suponiendo que $P(k)$ es verdadera. Tenemos que $P(k+1)$ es la sentencia que afirma:

$$
1 + 3 + 5 + \dots + (2k-1) + (2k+1) = (k+1)^2.
$$

Por tanto, si suponemos que $P(k)$ es verdadera, se sigue que:

$$
\begin{aligned}
1 + 3 + 5 + \dots + (2k-1) + (2k+1) &= [1 + 3 + \dots + (2k-1)] + (2k+1) \\
&= k^2 + (2k+1) \\
&= k^2 + 2k + 1 \\
&= (k+1)^2.
\end{aligned}
$$

Esto muestra que $P(k) \rightarrow P(k+1)$. Observe que se ha usado la hipótesis inductiva en la segunda igualdad. Finalmente, como $P(1)$ es verdadera y $P(k) \rightarrow P(k+1)$ también lo es para todo entero positivo $k$, el principio de inducción matemática muestra que $P(n)$ es verdadera para todo entero positivo $n$.
:::

**Ejemplo.** Use el método de inducción matemática para demostrar que para todos los enteros $n$ no negativos:

$$
1 + 2 + 2^2 + \dots + 2^n = 2^{n+1} - 1.
$$

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ afirma que la fórmula es correcta para el entero $n$.

**Paso Base:** $P(0)$ es verdadera porque $2^0 = 1 = 2^1 - 1$.

**Paso de Inducción:** Suponemos $P(k)$ verdadera: $1 + 2 + 2^2 + \dots + 2^k = 2^{k+1} - 1$. Debemos demostrar: $1+2+2^2+\dots+2^k+2^{k+1} = 2^{k+2}-1$.

$$
\begin{aligned}
1+2+2^2+\dots+2^k+2^{k+1} &= (1+2+2^2+\dots+2^k)+2^{k+1} \\
&= (2^{k+1}-1)+2^{k+1} \\
&= 2\cdot 2^{k+1}-1 \\
&= 2^{k+2}-1.
\end{aligned}
$$

Entonces $P(k+1)$ es verdadera y, por inducción, $P(n)$ vale para todo $n \ge 0$.
:::

### Ejemplos y ejercicios

**Ejercicio.** Demuestre que la suma de los $n$ primeros enteros $1+2+3+\dots+n$ es $n(n+1)/2$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=1}^{n} i = \frac{n(n+1)}{2}.
$$

**Paso base.** $P(1)$: $\displaystyle\sum_{i=1}^{1} i = 1 = 1\cdot 2/2$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=1}^{n} i = n(n+1)/2$ y sumamos $(n+1)$ a ambos lados:

$$
\begin{aligned}
\sum_{i=1}^{n+1} i = \sum_{i=1}^{n} i + (n+1) &= n(n+1)/2 + (n+1) \\
&= (n+1)(n+2)/2 \\
&= P(n+1).
\end{aligned}
$$
:::

**Ejercicio.** Demuestre que $2^0+2^1+2^2+\dots+2^n=2^{n+1}-1$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=0}^{n} 2^i = 2^{n+1}-1.
$$

**Paso base.** $P(0)$: $\displaystyle\sum_{i=0}^{0} 2^i = 2^0 = 1$ y $2^{0+1}-1 = 1$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=0}^{n} 2^i = 2^{n+1}-1$ y sumamos $2^{n+1}$ a ambos lados:

$$
\begin{aligned}
\sum_{i=0}^{n+1} 2^i = \sum_{i=0}^{n} 2^i + 2^{n+1} &= (2^{n+1}-1) + 2^{n+1} \\
&= 2\cdot 2^{n+1}-1 \\
&= 2^{(n+1)+1}-1 = P(n+1).
\end{aligned}
$$
:::

**Ejercicio.** Demuestre que la suma de los primeros $n$ impares es $n^2$, es decir, $1+3+5+\dots+(2n-1)=n^2$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=1}^{n} (2i-1) = n^2.
$$

**Paso base.** $P(1)$: $\displaystyle\sum_{i=1}^{1} (2i-1) = 1 = 1^2$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=1}^{n} (2i-1) = n^2$ y sumamos $(2n+1)$ a ambos lados:

$$
\begin{aligned}
\sum_{i=1}^{n+1} (2i-1) = \sum_{i=1}^{n} (2i-1) + (2n+1) &= n^2 + (2n+1) \\
&= n^2 + 2n + 1 \\
&= (n+1)^2 \\
&= P(n+1).
\end{aligned}
$$
:::

**Ejercicio.** Demuestre que $1^2+2^2+3^2+\dots+n^2=n(n+1)(2n+1)/6$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=1}^{n} i^2 = \frac{n(n+1)(2n+1)}{6}.
$$

**Paso base.** $P(1)$: $\displaystyle\sum_{i=1}^{1} i^2 = 1^2=(1\cdot 2\cdot 3)/6$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=1}^{n} i^2 = n(n+1)(2n+1)/6$ y sumamos $(n+1)^2$ a ambos lados:

$$
\begin{aligned}
\sum_{i=1}^{n+1} i^2 = \sum_{i=1}^{n} i^2+(n+1)^2 &= n(n+1)(2n+1)/6+(n+1)^2\\
&=(n+1)(2n^2+7n+6)/6\\
&=(n+1)(2n+3)(n+2)/6\\
&=\frac{(n+1)[(n+1)+1][2(n+1)+1]}{6}\\
&=P(n+1).
\end{aligned}
$$
:::

**Ejercicio.** Demuestre que $1^3+2^3+\dots+n^3=[n(n+1)/2]^2$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=1}^{n} i^3 = \left[\frac{n(n+1)}{2}\right]^2.
$$

**Paso base.** $P(1)$: $\displaystyle\sum_{i=1}^{1} i^3 = 1^3=[(1\cdot 2)/2]^2$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=1}^{n} i^3=[n(n+1)/2]^2$ y sumamos $(n+1)^3$ a ambos lados:

$$
\begin{aligned}
\sum_{i=1}^{n+1} i^3 = \sum_{i=1}^{n} i^3+(n+1)^3 &=[n(n+1)/2]^2+(n+1)^3\\
&=n^2(n+1)^2/4+(n+1)^3\\
&=(n+1)^2[n^2/4+(n+1)]\\
&=(n+1)^2(n+2)^2/4\\
&=[(n+1)(n+2)/2]^2\\
&=P(n+1).
\end{aligned}
$$
:::

**Ejercicio.** Demuestre que $1\cdot 2+2\cdot 3+\dots+n(n+1)=n(n+1)(n+2)/3$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=1}^{n} i(i+1) = \frac{n(n+1)(n+2)}{3}.
$$

**Paso base.** $P(1)$: $\displaystyle\sum_{i=1}^{1} i(i+1) = 1\cdot 2=(1\cdot 2\cdot 3)/3=2$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=1}^{n} i(i+1) = n(n+1)(n+2)/3$ y sumamos $(n+1)(n+2)$ a ambos lados:

$$
\begin{aligned}
\sum_{i=1}^{n+1} i(i+1) = \sum_{i=1}^{n} i(i+1) + (n+1)(n+2) &= n(n+1)(n+2)/3 + (n+1)(n+2) \\
&= (n+1)(n+2)\,[n/3+1] \\
&= (n+1)(n+2)(n+3)/3 \\
&= P(n+1).
\end{aligned}
$$
:::

**Ejercicio.** Demuestre que $1\cdot 1!+2\cdot 2!+\dots+n\cdot n!=(n+1)!-1$.

:::{admonition} Solución
:class: dropdown
En notación de sumatoria, $P(n)$ afirma que

$$
\sum_{i=1}^{n} i\cdot i! = (n+1)!-1.
$$

**Paso base.** $P(1)$: $\displaystyle\sum_{i=1}^{1} i\cdot i! = 1\cdot 1!=(1+1)!-1=1$.

**Paso inductivo.** $P(n) \rightarrow P(n+1)$. Partimos de $\displaystyle\sum_{i=1}^{n} i\cdot i!=(n+1)!-1$ y sumamos $(n+1)(n+1)!$ a ambos lados:

$$
\begin{aligned}
\sum_{i=1}^{n+1} i\cdot i! = \sum_{i=1}^{n} i\cdot i!+(n+1)(n+1)! &=(n+1)!-1+(n+1)(n+1)!\\
&=(n+1)![1+(n+1)]-1\\
&=(n+1)!(n+2)-1\\
&=(n+2)!-1\\
&=P(n+1).
\end{aligned}
$$
:::

### Ejercicios para el lector

**Actividad.** Demuestre que la suma de los primeros $n$ pares es $n(n+1)$, es decir,

$$
2+4+6+\dots+2n = n(n+1).
$$

**Ejercicios y sección.**

- Revisar los ejemplos resueltos de la sección 5.1 del libro *Discrete Mathematics and Its Applications* de Rosen.
- Responder las preguntas:
  - ¿Qué elementos de álgebra se aplican en la demostración?
  - ¿Hay algunos que se utilicen varias veces?

1. Use la inducción matemática para demostrar que $2 - 2\cdot 7 + 2\cdot 7^2 + \dots + 2(-7)^n = \dfrac{1-(-7)^{n+1}}{4}$ para todo entero no negativo $n$.
2. Demuestre que $1^3 + 2^3 + \dots + n^3 = \left[\dfrac{n(n+1)}{2}\right]^2$ para todo entero positivo $n$.
3. Demuestre que $2^n > n^2$ para todo entero $n > 4$.
4. Demuestre, utilizando inducción matemática, que $n! < n^n$ para todo entero $n > 1$.
5. Demuestre que para un conjunto de $n$ elementos el número de subconjuntos es $2^n$ para todo entero $n > 1$.

**Ejercicios y lectura previa.** Del texto *Discrete Mathematics and Its Applications*:

- Resuelva los siguientes ejercicios: 56, 57 y 59 de la sección 5.1.
- Lea la sección 5.2 hasta la subsección 5.2.3.

## Inducción fuerte

La inducción fuerte se utiliza cuando no se puede usar fácilmente la inducción matemática (débil). Usa el mismo paso base, pero cambia el paso de inducción.

Una demostración por inducción fuerte de $P(n)$ verdadera para todo entero positivo $n$ consiste en dos pasos:

- **(Paso base:)** Se muestra que la proposición $P(1)$ es verdadera.
- **(Paso inducción:)** Se demuestra que $[P(1)\land P(2)\land \dots \land P(k)] \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$.

**Ejemplo.** Muestre que si $n$ es mayor que $1$, entonces $n$ se puede escribir como el producto de números primos.

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la proposición que afirma que $n$ se puede escribir como producto de números primos.

**Paso Base:** $P(2)$ es verdadera ya que $2$ se puede poner como producto de números primos: él mismo.

**Paso de Inducción:** Suponemos que $P(j)$ es verdadera para todos los enteros positivos $j$ menores o iguales que $k$. Cuando $k+1$ es primo no hay problema pues ya se tiene el resultado, y cuando $k+1$ es compuesto, se puede escribir como el producto de dos enteros $a$ y $b$ que cumplen $2 \le a \le b < k+1$. Por hipótesis inductiva, tanto $a$ como $b$ se pueden escribir como producto de números primos. Por lo tanto, si $k+1$ es compuesto, este se puede escribir como producto de números primos, los primos de la factorización de $a$ y los de la factorización de $b$.
:::

**Ejemplo.** Consideremos un juego en el que hay dos montones de fósforos y dos contrincantes juegan por turnos quitando el número de fósforos que deseen de uno de los montones. El jugador que quite el último fósforo gana. Muestre que si los dos montones contienen inicialmente el mismo número de fósforos, el segundo jugador puede ganar siempre, haga lo que haga el primero.

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la sentencia que afirma que el segundo jugador puede ganar siempre si inicialmente hay $n$ fósforos en cada montón.

**Paso Base:** $P(1)$ es verdadera ya que cuando $n=1$ el primer jugador tiene sólo una elección posible, que es quitar el único fósforo que hay en uno de los montones, dejando el otro montón con un fósforo. El segundo jugador gana el juego.

**Paso de Inducción:** Suponemos que $P(j)$ es verdadera para todo $j$, $1 \le j \le k$. Es decir, el segundo jugador puede ganar siempre que inicialmente haya $j$ fósforos en cada uno de los dos montones, con $1 \le j \le k$. Ahora supongamos que tenemos $k+1$ fósforos en cada montón al comienzo del juego y supongamos que el primer jugador quita $i$ ($1 \le i \le k$) fósforos en la primera jugada, dejando $k+1-i$ en el montón. Si el segundo jugador quita el mismo número de fósforos del otro montón, crea la situación en la que hay dos montones con $k+1-i$ fósforos. Como $1 \le k+1-i \le k$ el segundo jugador puede ganar siempre por hipótesis de inducción. Completamos la demostración viendo que si el primer jugador quita los $k+1$ fósforos de un montón, el segundo jugador tiene la opción obvia de ganar quitando los $k+1$ fósforos del segundo montón.
:::

**Ejemplo.** Demuestre que cualquier franqueo postal de 12 o más pesos se puede completar empleando solamente sellos de 4 y 5 pesos.

:::{admonition} Solución
:class: dropdown
Demostraremos que se pueden formar franqueos de 12, 13, 14 y 15 pesos y luego mostraremos cómo formar un franqueo de $k+1$ pesos, $k \ge 15$, a partir de franqueos de $k-3$ pesos.

Decimos que $P(n)$ es la proposición que afirma que cualquier franqueo postal de 12 o más pesos se puede completar empleando solamente sellos de 4 y 5 pesos.

**Paso Base:** Podemos formar franqueos de 12, 13, 14 y 15 pesos utilizando tres sellos de 4, dos de 4 y uno de 5, uno de 4 y dos de 5, y tres de 5 pesos, respectivamente.

**Paso de Inducción:** Sea $k \ge 15$. Suponemos que podemos formar franqueos de $j$ pesos para $12 \le j \le k$. Para formar un franqueo de $k+1$ pesos usamos el franqueo de $k-3$ pesos y le añadimos un sello de 4 pesos. Esto completa el paso de inducción y la demostración por el principio fuerte de inducción.
:::

¿Qué diferencia se pudo observar entre este ejemplo y los previos?

- La inducción fuerte trata casos donde el paso de inducción es válido sólo para valores suficientemente grandes de $k$.
- Para demostrar que $P(n)$ es verdadera para $n=j, j+1, j+2, \dots$, donde $j$ es un entero, vemos primero que $P(j), P(j+1), P(j+2), \dots, P(l)$ son verdaderas (el paso base), y entonces demostramos que $[P(j)\land P(j+1)\land P(j+2)\land \dots \land P(k)] \rightarrow P(k+1)$ es verdadera para todo entero $k \ge l$ (el paso de inducción).

**Inducción matemática y el axioma del buen ordenamiento.** Todo conjunto no vacío de enteros positivos tiene un elemento mínimo. Este axioma permite mostrar la validez de la inducción matemática (leer el último párrafo de la sección 3.3).

La propiedad del buen orden y la inducción matemática son equivalentes.

**Ejercicios.**

1. Use la inducción fuerte para demostrar que si usted puede correr una milla o dos millas, y si usted siempre puede correr dos millas más cuando haya corrido un número especificado de millas, usted puede correr cualquier cantidad de millas.
2. Sea $P(n)$ la propiedad que nos indica que el franqueo de $n$ centavos puede formarse usando estampillas de $3$ centavos y $5$ centavos. Por inducción fuerte se puede probar que $P(n)$ es verdadera para $n \ge 8$.
   - a) Muestre que $P(8)$, $P(9)$ y $P(10)$ son verdaderos, completando así el paso base de la prueba.
   - b) ¿Cuál es la hipótesis inductiva de la prueba?
   - c) ¿Qué necesita para probar el paso inductivo?
   - d) Complete el paso inductivo para $k \ge 10$.
   - e) Explique por qué estos pasos demuestran que la propiedad es verdadera siempre que $n \ge 8$.
3. Determine qué cantidades de franqueo se pueden formar utilizando estampillas de 4 centavos y de 11 centavos. Pruébelo utilizando inducción fuerte.
4. ¿Qué cantidades de dinero se pueden formar utilizando sólo billetes de dos dólares y de cinco dólares? Pruebe su respuesta utilizando inducción fuerte.

## Inducción estructural

Es una forma particular de inducción matemática utilizada para demostrar resultados sobre conjuntos definidos recursivamente.

Una demostración por inducción estructural consta de dos partes que son:

- **Paso base:** Se comprueba el resultado para todos los elementos especificados por el paso base.
- **Paso recursivo:** Se prueba la propiedad para cada elemento utilizado en construir nuevos elementos del paso recursivo.

**Ejemplo.** Demuestre por inducción estructural que $l(xy)=l(x)+l(y)$, donde $x$ e $y$ pertenecen a $\Sigma^*$, el conjunto de las cadenas del alfabeto $\Sigma$. Esto es, sea $P(y)$ la propiedad que afirma que $l(xy)=l(x)+l(y)$ siempre que $x,y \in \Sigma^*$.

:::{admonition} Solución
:class: dropdown
**Paso base:** Para completar el paso se debe demostrar que $P(\lambda)$ es verdadera, es decir, verificar que $l(x\lambda)=l(x)+l(\lambda)$ para todo $x\in\Sigma^*$. Como $l(x\lambda)=l(x)=l(x)+0=l(x)+l(\lambda)$ para toda cadena $x$, se cumple que $P(\lambda)$ es verdadera.

**Paso recursivo:** Se supone que $P(y)$ es verdadera ($l(xy)=l(x)+l(y)$). Se debe demostrar que esto implica que $P(ya)$ es verdadera para toda $a\in\Sigma$. Ahora lo que se debe demostrar es que $l(xya)=l(x)+l(ya)$. Por definición recursiva de longitud, $l(xya)=l(xy)+1$. Por la hipótesis inductiva $l(xy)=l(x)+l(y)$, entonces $l(xya)=l(x)+l(y)+1$. Pero $l(ya)=l(y)+1$, por lo tanto

$$
l(xya)=l(x)+l(ya),
$$

lo cual concluye la demostración.
:::

### Inducción generalizada

Extiende el concepto de inducción matemática para demostrar resultados sobre conjuntos no enteros, si se garantiza el cumplimiento de la propiedad del buen orden.

Para estudiar el siguiente ejemplo consideramos el denominado *orden lexicográfico* de $\mathbb{N}\times\mathbb{N}$, el cual define un orden para las parejas de enteros no negativos.

El par $(x_1,y_1)$ es menor o igual que $(x_2,y_2)$ si $x_1 < x_2$ o $x_1 = x_2$ y $y_1 < y_2$.

**Ejemplo.** Suponga que $a_{m,n}$ se define recursivamente para $(m,n)\in\mathbb{N}\times\mathbb{N}$ por $a_{0,0}=0$ y

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 1 & \text{si } n = 0 \text{ y } m > 0, \\
a_{m,n-1} + n & \text{si } n > 0 .
\end{cases}
$$

Demuestre que

$$
a_{m,n} = m + \frac{n(n+1)}{2}
$$

para todo $(m,n)\in\mathbb{N}\times\mathbb{N}$, es decir, para todos los pares de enteros no negativos.

:::{admonition} Solución
:class: dropdown
Se puede demostrar que $a_{m,n}= m + \dfrac{n(n+1)}{2}$ usando una versión generalizada del principio de inducción.

**Paso base:** Sea $(m,n)=(0,0)$. Entonces por el paso base de la definición recursiva de $a_{m,n}$ se tiene que $a_{0,0}=0$. Además cuando $m=n=0$, $m+\dfrac{n(n+1)}{2}=0+\dfrac{0\cdot 1}{2}=0$.

**Paso inductivo:** Sea $a_{m',n'}=m'+\dfrac{n'(n'+1)}{2}$ con $(m',n')$ menor que $(m,n)$ en el orden lexicográfico de $\mathbb{N}\times\mathbb{N}$.

Por la definición recursiva, si $n=0$, entonces $a_{m,n}=a_{m-1,n}+1$. Como $(m-1,n)$ es menor que $(m,n)$, la hipótesis inductiva dice que $a_{m-1,n}=m-1+\dfrac{n(n+1)}{2}$, de donde

$$
a_{m,n}=m-1+\frac{n(n+1)}{2}+1=m+\frac{n(n+1)}{2}.
$$

Ahora si $n>0$, entonces $a_{m,n}=a_{m,n-1}+n$. Como $(m,n-1)$ es menor que $(m,n)$,

$$
a_{m,n-1}=m+\frac{(n-1)n}{2},
$$

por tanto

$$
a_{m,n}=m+\frac{(n-1)n}{2}+n=m+\frac{n(n+1)}{2}.
$$
:::

---

*Material adaptado del material original de los profesores Juan Francisco Díaz, Angela Villota, Jenifer Viafara y Oscar Bedoya.*
