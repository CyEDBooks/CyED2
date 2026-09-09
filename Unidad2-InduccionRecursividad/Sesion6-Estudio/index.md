---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 6: Inducción matemática"
---

# Unidad 2 · Sesión 6: Inducción matemática

*Clase del 27 de agosto de 2025.*

## Objetivos

- Aplicar el principio de inducción matemática para definir estructuras discretas, demostrar sus propiedades y verificar algoritmos formalmente, en particular, establecer y resolver relaciones de recurrencia asociadas a la complejidad de dichos algoritmos.
- Expresar o comunicar con el vocabulario y lenguaje adecuado/especializado las ideas principales sobre estructuras discretas o la programación funcional.

## Agenda

1. Objetivos terminales
2. Inducción matemática (Tema, para la siguiente clase, ejercicios)
3. Inducción fuerte
4. Inducción estructural (inducción generalizada)
5. Ejercicios
6. Algoritmos recursivos e inducción estructural
7. Ejercicios

## Inducción matemática

### Tema

Es una técnica de demostración para proposiciones de la forma $\forall n\, P(n)$, donde el dominio es el conjunto de los enteros positivos.

¿Sobre qué clase de teoremas se puede aplicar esta técnica? Teoremas en los que se afirma que $P(n)$ es verdadera para todos los enteros positivos $n$. Por ejemplo, podemos demostrar:

- La sentencia $1 + 2 + \cdots + n = n(n+1)/2$.
- La propiedad: todo conjunto con $n$ elementos tiene $2^n$ subconjuntos.

Una demostración por inducción de $P(n)$ verdadera para todo entero positivo $n$ consiste en dos pasos:

- **Paso base:** Se muestra que la proposición $P(1)$ es verdadera.
- **Paso inducción:** Se muestra que la implicación $P(k) \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$.

La sentencia $P(k)$ para un entero fijo $k$ se denomina **hipótesis de inducción** o **hipótesis inductiva**. Completar los dos pasos de una demostración de este tipo prueba que $P(n)$ es verdadera para todo entero $n>0$. Expresado como regla de inferencia, esta técnica se enuncia así:

$$
[P(1) \land \forall k\,(P(k) \rightarrow P(k+1))] \rightarrow \forall n\, P(n).
$$

Para completar una demostración por inducción:

- Muestre que $P(1)$ es verdadera.
- Luego demuestre que $P(k) \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$.

Queremos mostrar que $P(k+1)$ no puede ser falsa cuando $P(k)$ es verdadera.

**Plantilla de una demostración.** Partes de una demostración con inducción matemática (puede consultar la plantilla completa en el documento de ejercicios enlazado al final de esta página).

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

**Ejemplo.** Use el método de inducción matemática para demostrar la desigualdad $n < 2^n$.

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la proposición que afirma que $n < 2^n$.

**Paso Base:** $P(1)$ es verdadera ya que $1 < 2^1$.

**Paso de Inducción:** Suponemos que $P(k)$ es verdadera para el entero positivo $k$. Es decir, suponemos que $k < 2^k$. Como tenemos que probar que $P(k+1)$ es verdadera, debemos llegar a $k+1 < 2^{k+1}$. Partimos de $k < 2^k$, sumamos $1$ a ambos lados de la desigualdad teniendo en cuenta que $1 \le 2^k$ y obtenemos:

$$
k + 1 < 2^k + 1 \le 2^k + 2^k = 2 \cdot 2^k = 2^{k+1}.
$$

Hemos demostrado que $P(k+1)$ ya que llegamos a $k+1 < 2^{k+1}$ basándonos en la suposición de que $P(k)$ es verdadera.
:::

**Ejemplo.** Use el método de inducción matemática para demostrar que para todos los enteros $n$ no negativos:

$$
1 + 2 + 2^2 + \dots + 2^n = 2^{n+1} - 1.
$$

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la proposición que afirma que la anterior fórmula es correcta para el entero $n$.

**Paso Base:** $P(0)$ es verdadera ya que $2^0 = 1 = 2^1 - 1$.

**Paso de Inducción:** Suponemos que $P(k)$ es verdadera para el entero $k$. Es decir, suponemos que $1 + 2 + 2^2 + \dots + 2^k = 2^{k+1} - 1$. Como tenemos que probar que $P(k+1)$ es verdadera, debemos llegar a $1 + 2 + 2^2 + \dots + 2^k + 2^{k+1} = 2^{k+2} - 1$.

$$
\begin{aligned}
1 + 2 + 2^2 + \dots + 2^k + 2^{k+1} &= (1 + 2 + 2^2 + \dots + 2^k) + 2^{k+1} \\
&= (2^{k+1} - 1) + 2^{k+1} \\
&= 2 \cdot 2^{k+1} - 1 \\
&= 2^{k+2} - 1.
\end{aligned}
$$

Hemos demostrado que $P(k+1)$ ya que llegamos a $1 + 2 + 2^2 + \dots + 2^k + 2^{k+1} = 2^{k+2} - 1$, basándonos en la suposición de que $P(k)$ es verdadera.
:::

**Ejemplo.** Demuestre por inducción esta fórmula para la suma de un número finito de términos de una progresión geométrica:

$$
\sum_{j=0}^{n} ar^j = a + ar + ar^2 + \dots + ar^n = \frac{ar^{n+1}-a}{r-1}, \quad \text{cuando } r \neq 1.
$$

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la proposición que afirma que la anterior fórmula es correcta para la suma de los $n+1$ términos de una progresión geométrica.

**Paso Base:** $P(0)$ es verdadera pues $a = \dfrac{ar-a}{r-1}$.

**Paso de Inducción:** Suponemos que $P(k)$ es verdadera. Es decir, suponemos que:

$$
a + ar + ar^2 + \dots + ar^k = \frac{ar^{k+1}-a}{r-1}.
$$

Como tenemos que probar que $P(k+1)$ es verdadera, debemos llegar a:

$$
a + ar + ar^2 + \dots + ar^k + ar^{k+1} = \frac{ar^{k+2}-a}{r-1}.
$$

Partimos de $a + ar + ar^2 + \dots + ar^k = \dfrac{ar^{k+1}-a}{r-1}$ y sumamos $ar^{k+1}$ a ambos lados:

$$
a + ar + ar^2 + \dots + ar^k + ar^{k+1} = \frac{ar^{k+1}-a}{r-1} + ar^{k+1}.
$$

Reescribiendo el lado derecho de la ecuación tenemos:

$$
\frac{ar^{k+1}-a}{r-1} + ar^{k+1} = \frac{ar^{k+1}-a}{r-1} + \frac{ar^{k+2}-ar^{k+1}}{r-1} = \frac{ar^{k+2}-a}{r-1}.
$$

Ahora uniendo ambos lados llegamos a:

$$
a + ar + ar^2 + \dots + ar^k + ar^{k+1} = \frac{ar^{k+2}-a}{r-1}.
$$

Hemos demostrado que $P(k+1)$ ya que llegamos a la igualdad anterior, basándonos en la suposición de que $P(k)$ es verdadera.
:::

### Para la siguiente clase

**Ejercicios y sección.**

- Revisar los ejemplos resueltos de la sección 5.1.
- Responder las preguntas:
  - ¿Qué elementos de álgebra se aplican en la demostración?
  - ¿Hay algunos que se utilicen varias veces?

### Ejercicios

1. Use la inducción matemática para demostrar que $2 - 2\cdot 7 + 2\cdot 7^2 + \dots + 2(-7)^n = \dfrac{1-(-7)^{n+1}}{4}$ para todo entero no negativo $n$.
2. Demuestre que $1^3 + 2^3 + \dots + n^3 = \left[\dfrac{n(n+1)}{2}\right]^2$ para todo entero positivo $n$.
3. Demuestre que $2^n > n^2$ para todo entero $n$ mayor que $4$.
4. Demuestre, utilizando inducción matemática, que $n! < n^n$ para todo $n$ entero mayor que $1$.
5. Demuestre que para un conjunto de $n$ elementos el número de subconjuntos es $2^n$ para todo $n$ entero mayor que $1$.

**Ejercicios y lectura previa.** Del texto *Discrete Mathematics and its Applications*:

- Resuelva los siguientes ejercicios: 56, 57 y 59 de la sección 5.1.
- Lea la sección 5.2 hasta la subsección 5.2.3.

## Inducción fuerte

La inducción fuerte se utiliza cuando no se puede usar fácilmente la inducción matemática (débil). Usa el mismo paso base, pero cambia el paso de inducción.

Una demostración por inducción fuerte de $P(n)$ verdadera para todo entero positivo $n$ consiste en dos pasos:

- **Paso base:** Se muestra que la proposición $P(1)$ es verdadera.
- **Paso inducción:** Se demuestra que $[P(1) \land P(2) \land \dots \land P(k)] \rightarrow P(k+1)$ es verdadera para todo entero positivo $k$.

**Ejemplo.** Muestre que si $n$ es mayor que $1$, entonces $n$ se puede escribir como el producto de números primos.

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la proposición que afirma que $n$ se puede escribir como producto de números primos.

**Paso Base:** $P(2)$ es verdadera ya que $2$ se puede poner como producto de números primos: él mismo.

**Paso de Inducción:** Suponemos que $P(j)$ es verdadera para todos los enteros positivos $j$ menores o iguales que $k$. Cuando $k+1$ es primo no hay problema pues ya se tiene el resultado, y cuando $k+1$ es compuesto, se puede escribir como el producto de dos enteros $a$ y $b$ que cumplen que $2 \le a \le b < k+1$. Por hipótesis inductiva, tanto $a$ como $b$ se pueden escribir como producto de números primos. Por tanto, si $k+1$ es compuesto, este se puede escribir como el producto de números primos: los primos de la factorización de $a$ y los de la factorización de $b$.
:::

**Ejemplo.** Consideremos un juego en el que hay dos montones de fósforos y dos contrincantes juegan por turnos quitando el número de fósforos que deseen de uno de los montones. El jugador que quite el último fósforo gana. Muestre que si los dos montones contienen inicialmente el mismo número de fósforos, el segundo jugador puede ganar siempre, haga lo que haga el primero.

:::{admonition} Solución
:class: dropdown
Decimos que $P(n)$ es la sentencia que afirma que el segundo jugador puede ganar siempre si inicialmente hay $n$ fósforos en cada montón.

**Paso Base:** $P(1)$ es verdadera ya que cuando $n=1$ el primer jugador tiene sólo una elección posible, que es quitar el único fósforo que hay en uno de los montones, dejando el otro montón con un fósforo. El segundo jugador gana el juego.

**Paso de Inducción:** Suponemos que $P(j)$ es verdadera para todo $j$, $1 \le j \le k$. Es decir, el segundo jugador puede ganar siempre que inicialmente haya $j$ fósforos en cada uno de los dos montones, con $1 \le j \le k$. Ahora supongamos que tenemos $k+1$ fósforos en cada montón al comienzo del juego y supongamos que el primer jugador quita $i$ ($1 \le i \le k$) fósforos en la primera jugada, dejando $k+1-i$ en el montón. Si el segundo jugador quita el mismo número de fósforos del otro montón, crea la situación en la que hay dos montones con $k+1-i$ fósforos. Como $1 \le k+1-i \le k$, el segundo jugador puede ganar siempre por hipótesis de inducción. Completamos la demostración viendo que si el primer jugador quita los $k+1$ fósforos de un montón, el segundo jugador tiene la opción obvia de ganar quitando los $k+1$ fósforos del segundo montón.
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
- Para demostrar que $P(n)$ es verdadera para $n=j, j+1, j+2, \dots$, donde $j$ es un entero, vemos primero que $P(j), P(j+1), P(j+2), \dots, P(l)$ son verdaderas (el paso base), y entonces demostramos que $[P(j) \land P(j+1) \land P(j+2) \land \dots \land P(k)] \rightarrow P(k+1)$ es verdadera para todo entero $k \ge l$ (el paso de inducción).

### Inducción matemática y el axioma del buen ordenamiento

Todo conjunto no vacío de enteros positivos tiene un elemento mínimo. Este axioma permite mostrar la validez de la inducción matemática (leer el último párrafo de la sección 3.3).

La propiedad del buen orden y la inducción matemática son equivalentes.

### Ejercicios

1. Use el axioma del buen ordenamiento para probar el algoritmo de la división: Si $a$ es un número entero y $d$ es un entero positivo, entonces existen unos únicos enteros $q$ y $r$ tal que $a = dq + r$ con $0 \le r < d$.
2. Use la inducción fuerte para demostrar que si usted puede correr una milla o dos millas, y si usted siempre puede correr dos millas más cuando haya corrido un número especificado de millas, usted puede correr cualquier cantidad de millas.
3. Sea $P(n)$ la propiedad que nos indica que el franqueo de $n$ centavos puede formarse usando estampillas de 3 centavos y 5 centavos. Por inducción fuerte se puede probar que $P(n)$ es verdadera para $n \ge 8$.
   - a) Muestre que $P(8)$, $P(9)$ y $P(10)$ son verdaderos, completando así el paso base de la prueba.
   - b) ¿Cuál es la hipótesis inductiva de la prueba?
   - c) ¿Qué necesita para probar el paso inductivo?
   - d) Complete el paso inductivo para $k \ge 10$.
   - e) Explique por qué estos pasos demuestran que la propiedad es verdadera siempre que $n \ge 8$.
4. Determine qué cantidades de franqueo se pueden formar utilizando estampillas de 4 centavos y de 11 centavos. Pruébelo utilizando inducción fuerte.
5. ¿Qué cantidades de dinero se pueden formar utilizando sólo billetes de dos dólares y de cinco dólares? Pruebe su respuesta utilizando inducción fuerte.
6. Demuestre a partir de la propiedad del buen orden que la inducción fuerte es un método de demostración válido.

## Inducción estructural

Es una forma particular de inducción matemática utilizada para demostrar resultados sobre conjuntos definidos recursivamente.

Una demostración por inducción estructural consta de dos partes:

- **Paso base:** Se comprueba el resultado para todos los elementos especificados por el paso base.
- **Paso recursivo:** Se prueba la propiedad para cada elemento utilizado en construir nuevos elementos del paso recursivo.

**Ejemplo.** Demuestre por inducción estructural que $l(xy) = l(x) + l(y)$, donde $x$ e $y$ pertenecen a $\Sigma^*$, el conjunto de las cadenas de caracteres del alfabeto $\Sigma$. Esto es, sea $P(y)$ la propiedad que afirma que $l(xy) = l(x) + l(y)$ siempre que $x$ e $y$ pertenezcan a $\Sigma^*$.

:::{admonition} Solución
:class: dropdown
**Paso base:** Para completar el paso se debe demostrar que $P(\lambda)$ es verdadera, esto es, verificar que $l(x\lambda) = l(x) + l(\lambda)$ para todo $x \in \Sigma^*$. Como $l(x\lambda) = l(x) = l(x) + 0 = l(x) + l(\lambda)$ para toda cadena $x$, se cumple que $P(\lambda)$ es verdadera.

**Paso recursivo:** Se supone que $P(y)$ es verdadera ($l(xy) = l(x) + l(y)$). Se debe demostrar que esto implica que $P(ya)$ es verdadera para toda $a \in \Sigma$. Ahora lo que se debe demostrar es que $l(xya) = l(x) + l(ya)$ para toda $a \in \Sigma$. Partiendo de la definición recursiva de longitud se tiene que $l(xya) = l(xy) + 1$. Por la hipótesis inductiva, $l(xy) = l(x) + l(y)$, por tanto se concluye que $l(xya) = l(x) + l(y) + 1$. De aquí, $l(xya) = l(x) + l(y) + 1 = l(x) + l(ya)$, lo cual concluye la demostración.
:::

### Inducción generalizada

Extiende el concepto de inducción matemática para demostrar resultados sobre conjuntos no enteros, si se garantiza el cumplimiento de la propiedad del buen orden.

Para estudiar el siguiente ejemplo consideramos el denominado **orden lexicográfico** de $\mathbb{N} \times \mathbb{N}$, el cual define un orden para las parejas de enteros no negativos. El par $(x_1,y_1)$ es menor o igual que $(x_2,y_2)$ si $x_1 < x_2$ o $x_1 = x_2$ y $y_1 < y_2$.

**Ejemplo.** Suponga que $a_{m,n}$ se define recursivamente para $(m,n) \in \mathbb{N} \times \mathbb{N}$ por $a_{0,0} = 0$ y

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 1 & \text{si } n = 0 \text{ y } m > 0 \\
a_{m,n-1} + n & \text{si } n > 0.
\end{cases}
$$

Demuestre que $a_{m,n} = m + \dfrac{n(n+1)}{2}$ para todo $(m,n) \in \mathbb{N} \times \mathbb{N}$, esto es, para todos los pares de enteros no negativos.

:::{admonition} Solución
:class: dropdown
Se puede demostrar que $a_{m,n} = m + \dfrac{n(n+1)}{2}$ usando una versión generalizada del principio de inducción.

**Paso base:** Sea $(m,n) = (0,0)$. Entonces por el paso base de la definición recursiva de $a_{m,n}$ se tiene que $a_{0,0} = 0$. Además, cuando $m=n=0$, $m + \dfrac{n(n+1)}{2} = 0 + \dfrac{0\cdot 1}{2} = 0$.

**Paso inductivo:** Sea $a_{m',n'} = m' + \dfrac{n'(n'+1)}{2}$ con $(m',n')$ menor que $(m,n)$ en el orden lexicográfico de $\mathbb{N} \times \mathbb{N}$. Por la definición recursiva, si $n=0$, entonces $a_{m,n} = a_{m-1,n} + 1$. Como $(m-1,n)$ es menor que $(m,n)$, la hipótesis de inducción nos dice que $a_{m-1,n} = m - 1 + \dfrac{n(n+1)}{2}$, de donde $a_{m,n} = m - 1 + \dfrac{n(n+1)}{2} + 1 = m + \dfrac{n(n+1)}{2}$, dando la igualdad deseada. Ahora se supone que $n>0$, por tanto $a_{m,n} = a_{m,n-1} + n$. Como $(m,n-1)$ es menor que $(m,n)$, por hipótesis inductiva $a_{m,n-1} = m + \dfrac{(n-1)n}{2}$ y de aquí $a_{m,n} = m + \dfrac{(n-1)n}{2} + n = m + \dfrac{n^2-n+2n}{2} = m + \dfrac{n(n+1)}{2}$, lo cual completa este paso.
:::

## Ejercicios

1. Obtenga $f(2)$, $f(3)$, $f(4)$ y $f(5)$ si $f$ se define recursivamente por $f(0)=f(1)=1$ y, para $n=1,2,\dots$:
   - a) $f(n+1) = f(n) - f(n-1)$
   - b) $f(n+1) = f(n)f(n-1)$
   - c) $f(n+1) = f(n)^2 + f(n-1)^3$
   - d) $f(n+1) = f(n)/f(n-1)$
2. Dé una función recursiva para la sucesión $\{a_n\}$, $n=1,2,3,\dots$, si:
   - a) $a_n = 4n-2$
   - b) $a_n = 1 + (-1)^n$
   - c) $a_n = n(n+1)$
   - d) $a_n = n^2$
3. Demuestre que el conjunto $S$ definido por $1 \in S$ y $s+t \in S$ si $s \in S$ y $t \in S$ es el conjunto de los enteros positivos.
4. Dé una definición recursiva del conjunto de:
   - a) los enteros positivos impares.
   - b) los enteros positivos potencias de 3.
   - c) los enteros positivos congruentes con 2 módulo 3.
   - d) los enteros positivos no divisibles por 5.
5. Si el triángulo equilátero original del fractal de copo de nieve de Koch tiene lados de longitud $s$, halle la longitud de cada lado del copo de nieve y el perímetro utilizando una definición recursiva.
6. a) Dé una definición recursiva de la función $\mathrm{unos}(s)$, que cuenta el número de unos que hay en la cadena de bits $s$.
   b) Utilice la inducción estructural para demostrar que $\mathrm{unos}(st) = \mathrm{unos}(s) + \mathrm{unos}(t)$.

**Ejercicios sugeridos** sección 5.3: 18, 27, 29, 32 y 41.

## Algoritmos recursivos e inducción estructural

Un algoritmo se llama **recursivo** si resuelve un problema reduciéndolo a un caso del mismo problema con datos de entrada más pequeños. Este tipo de algoritmos hallan la solución al problema mediante una secuencia de reducciones, hasta que se llega a un caso inicial cuya solución se conoce.

**Ejemplo.** Dé un algoritmo recursivo para hallar $a^n$, donde $a$ es un número real distinto de cero y $n$ un entero no negativo.

:::{admonition} Solución
:class: dropdown
```
procedure potencia(a : número real no nulo, n : entero no negativo)
if n = 0 then potencia(a, n) := 1
else potencia(a, n) := a · potencia(a, n − 1)
```
:::

**Ejemplo.** Construya una versión recursiva de un algoritmo de búsqueda binaria.

:::{admonition} Solución
:class: dropdown
```
procedure busqueda_binaria(x, i, j)
m := ⌊(i + j)/2⌋
if x = a_m then
    posicion := m
else if x < a_m and i < m then
    busqueda_binaria(x, i, m − 1)
else if x > a_m and j > m then
    busqueda_binaria(x, m + 1, j)
else posicion := 0
```
:::

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

### Algoritmos iterativos

**Ejemplo.** Diseñe un algoritmo iterativo que calcule el factorial.

:::{admonition} Solución
:class: dropdown
```
procedure factorial_iterativo(n : entero positivo)
x := 1
for i := 1 to n
    x := i · x
```
:::

### Correctitud de algoritmos recursivos

Para mostrar la correctitud de un algoritmo recursivo utilizamos inducción.

**Ejemplo.** Demuestre que el siguiente algoritmo es correcto:

```
procedure factorial(n : entero positivo)
if n = 1 then
    factorial(n) := 1
else
    factorial(n) := n · factorial(n − 1)
```

:::{admonition} Solución
:class: dropdown
Vamos a probar que el algoritmo calcula correctamente el factorial para $n \in \mathbb{Z}^+$.

**Paso Base:** El factorial de 1 es 1 y esa es la respuesta que da el algoritmo cuando $n=1$.

**Paso Inductivo:** Asumimos que el algoritmo `factorial(k)` funciona correctamente para $n=k$. Si $n=k+1$ el algoritmo entra a la cláusula del `else` y multiplica $k+1$ por el resultado de `factorial(k)`. Por H.I. sabemos que este es el resultado correcto de $k!$. Como $(k+1)! = (k+1)k!$ hemos probado la correctitud del algoritmo.
:::

## Ejercicios

1. Dé un algoritmo recursivo para calcular la suma de los $n$ primeros enteros positivos ($n \in \mathbb{Z}^+$).
2. Dé un algoritmo recursivo para calcular la suma de los $n$ primeros enteros positivos impares ($n \in \mathbb{Z}^+$).
3. Dé un algoritmo recursivo que calcule el máximo de un conjunto finito de enteros, y luego demuestre que es correcto.
4. Dé un algoritmo recursivo para calcular $n \cdot x$ para $n$ entero positivo y $x$ entero, y luego demuestre que tal algoritmo es correcto.
5. Dado el siguiente algoritmo:

   ```
   procedure potencia(a : número real no nulo, n : entero no negativo)
   if n = 0 then potencia(a, n) := 1
   else potencia(a, n) := a · potencia(a, n − 1)
   ```

   demuestre su correctitud.
6. Escriba un algoritmo recursivo que calcule el término $n$-ésimo de la sucesión definida por $a_0=1$, $a_1=2$ y $a_n = a_{n-1}\cdot a_{n-2}$, para $n=2,3,4,\dots$
7. Escriba un algoritmo recursivo que calcule el término $n$-ésimo de la sucesión definida por $a_0=1$, $a_1=2$, $a_2=3$, y $a_n = a_{n-1}+a_{n-2}+a_{n-3}$, para $n=3,4,5,\dots$
8. Dé un algoritmo recursivo que calcule la cadena $w^i$, la concatenación de $i$ copias de la cadena de bits $w$.

## Fibonacci: recursión vs. iteración

A menudo un algoritmo iterativo para la evaluación de una sucesión definida recursivamente requiere mucho menos cálculo que un procedimiento que utilice recursión. Veamos el algoritmo para calcular los números de Fibonacci de ambas maneras y analicemos:

```
procedure fibonacci(n : entero no negativo)
if n = 0 then fibonacci(0) := 0
else if n = 1 then fibonacci(1) := 1
else fibonacci(n) := fibonacci(n − 1) + fibonacci(n − 2)
```

Cuando empleamos un procedimiento recursivo para calcular $f_n$, primero expresamos $f_n$ como $f_{n-1}+f_{n-2}$. Luego reemplazamos estos dos números de Fibonacci por la suma de los dos números de Fibonacci previos y así sucesivamente. Cuando aparecen $f_1$ y $f_0$, éstos son reemplazados por su valor. Note que en cada paso de la recursión, hasta obtener $f_0$ y $f_1$, el total de números de Fibonacci a evaluar se duplica. Si utilizamos un diagrama de árbol para ver cómo calculamos el número de Fibonacci podemos observar que se requieren $f_{n+1}-1$ adiciones.

```
procedure fibonacci_iterativo(n : entero no negativo)
if n = 0 then y := 0
else
begin
    x := 0
    y := 1
    for i := 1 to n − 1
    begin
        z := x + y
        x := y
        y := z
    end
end
```

Este procedimiento inicializa $x$ como $f_0=0$ e $y$ como $f_1=1$. Cuando se recorre el ciclo, se asigna la suma de $x$ e $y$ a la variable auxiliar $z$. Luego a $x$ se le asigna el valor de $y$ y a $y$ el valor de $z$. Por tanto, tras recorrer el ciclo por primera vez, $x$ es igual a $f_1$ e $y$ toma el valor $f_0+f_1=f_2$. Así, cuando el bucle se recorre $n-1$ veces, $x$ es igual a $f_{n-1}$ e $y$ es igual a $f_n$. Se han realizado sólo $n-1$ sumas para calcular $f_n$ en este algoritmo, con $n>1$.

## Ejercicios

- Leer la sección 5.4.
- Ejercicios sugeridos sección 5.4: 7-11, 21, 22, 38, 40 y 50-52.

---

Puede encontrar la plantilla completa para demostraciones por inducción matemática, junto con ejercicios adicionales resueltos y propuestos, en el documento [Ejercicios de Inducción Matemática](ejercicios.pdf).

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
