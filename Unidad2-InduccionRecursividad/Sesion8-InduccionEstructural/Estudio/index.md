---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 8: Inducción estructural"
---

# Unidad 2 · Sesión 8: Inducción estructural

## Agenda

1. Objetivos terminales
2. Repaso Recursividad
3. Inducción estructural
4. Inducción generalizada
5. Ejercicios

***

## Objetivos terminales

**OT2.** Aplicar el principio de inducción matemática para definir estructuras discretas, demostrar sus propiedades y verificar algoritmos formalmente, en particular, establecer y resolver relaciones de recurrencia asociadas a la complejidad de dichos algoritmos.

**OT4.** Expresar o comunicar con el vocabulario y lenguaje adecuado/especializado las ideas principales sobre estructuras discretas o la programación funcional.

***

## Repaso Recursividad

:::{admonition} Ejemplo
Dé una función recursiva de la función factorial $F(n) = n!$:
:::

:::{admonition} Solución
- **Paso base:** $F(0) = 1$.
- **Paso recursivo:** $F(n + 1) = (n + 1)F(n)$
:::

:::{admonition} Ejemplo
Dé una función recursiva de $H(n) = \sum_{k=0}^{n} a_k$:
:::

:::{admonition} Solución
- **Paso base:** $H(0) = \sum_{k=0}^{0} a_k = a_0$
- **Paso recursivo:** $H(n + 1) = \sum_{k=0}^{n+1} a_k = \left(\sum_{k=0}^{n} a_k\right) + a_{n+1}$
:::

### Conjuntos definidos recursivamente

:::{admonition} Ejemplo
Considere el subconjunto $S$ de los enteros definido por:
- **Paso base:** $3 \in S$
- **Paso recursivo:** Si $x \in S$ y $y \in S$, entonces $x + y \in S$
:::

:::{admonition} Solución
Los nuevos elementos de $S$ se van construyendo a partir del paso base de la siguiente manera:

- $3 \in S$ luego $S = \{3\}$
- $3 \in S$ luego $3 + 3 = 6 \in S$ luego $S = \{3, 6\}$
- $3, 6 \in S$ luego $3 + 6 = 9 \in S$ luego $S = \{3, 6, 9\}$
- $3, 6, 9 \in S$ luego $3 + 9 = 12 \in S$ luego $S = \{3, 6, 9, 12\}$
- $S = \{3, 6, 9, 12, 15, 18, 21, \dots\}$
:::

***

## Inducción estructural

Es una forma particular de inducción matemática utilizada para demostrar resultados sobre conjuntos definidos recursivamente.

Una demostración por inducción estructural consta de dos partes que son:

- **Paso base:** Se comprueba el resultado para todos los elementos especificados por el paso base.
- **Paso recursivo:** Se prueba la propiedad para cada elemento utilizado en construir nuevos elementos del paso recursivo, luego el resultado se cumple para estos nuevos elementos.

:::{admonition} Ejemplo
Demuestre por inducción estructural que $l(xy) = l(x) + l(y)$, donde $x$ e $y$ pertenecen a $\Sigma^*$, el conjunto de las cadenas de caracteres del alfabeto $\Sigma$. Sea $P(y)$ la propiedad que afirma que $l(xy) = l(x) + l(y)$ siempre que $x$ e $y$ pertenezcan a $\Sigma^*$.

**Algunas definiciones.** Formalmente: sea $C$ una cadena de $n$ carácteres representada por la secuencia $c_1 c_2 c_3 \dots c_n$. La operación concatenación $\cdot$ permite unir dos cadenas $X \cdot Y$. Definición recursiva de una cadena:
- la cadena vacía $\lambda$ es una cadena
- $c \cdot C$ es una cadena si $c$ es un caracter y $C$ una cadena.
:::

:::{admonition} Solución
**Paso base:** Para completar el paso se debe demostrar que $P(\lambda)$ es verdadera, esto es, verificar que $l(x\lambda) = l(x) + l(\lambda)$ para todo $x \in \Sigma^*$. Como $l(x\lambda) = l(x) = l(x) + 0 = l(x) + l(\lambda)$ para toda cadena $x$, se cumple que $P(\lambda)$ es verdadera.

**Paso recursivo:** Se supone que $P(y)$ es verdadera ($l(xy) = l(x) + l(y)$). Se debe demostrar que esto implica que $P(ya)$ es verdadera para toda $a \in \Sigma$. Ahora lo que se debe demostrar es que $l(xya) = l(x) + l(ya)$ para toda $a \in \Sigma$.

Partiendo de la definición recursiva de longitud se tiene que $l(xya) = l(xy) + 1$. Por la hipótesis inductiva, $l(xy) = l(x) + l(y)$, por tanto se concluye que $l(xya) = l(x) + l(y) + 1$. Se concluye entonces que $l(xya) = l(x) + l(y) + 1 = l(x) + l(ya)$.
:::

***

## Inducción generalizada

Extiende el concepto de inducción matemática para demostrar resultados sobre conjuntos no enteros, si se garantiza el cumplimiento de la propiedad del buen orden.

Para estudiar el siguiente ejemplo consideramos el denominado orden lexicográfico de $\mathbb{N} \times \mathbb{N}$, el cual define un orden para las parejas de enteros no negativos. El par $(x_1, y_1)$ es menor o igual que $(x_2, y_2)$ si $x_1 < x_2$ o $x_1 = x_2$ y $y_1 < y_2$.

:::{admonition} Ejemplo
Suponga que $a_{m,n}$ se define recursivamente para $(m, n) \in \mathbb{N} \times \mathbb{N}$ por $a_{0,0} = 0$ y

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 1 & \text{si } n = 0 \text{ y } m > 0 \\
a_{m,n-1} + n & \text{si } n > 0.
\end{cases}
$$

Demuestre que $a_{m,n} = m + n(n + 1)/2$ para todo $(m, n) \in \mathbb{N} \times \mathbb{N}$, esto es, para todos los pares de enteros no negativos.
:::

:::{admonition} Solución
Se puede demostrar que $a_{m,n} = m + n(n + 1)/2$ usando una versión generalizada del principio de inducción.

**Paso base:** Sea $(m, n) = (0, 0)$. Entonces por el paso base de la definición recursiva de $a_{m,n}$ se tiene que $a_{0,0} = 0$. Además cuando $m = n = 0$, $m + n(n + 1)/2 = 0 + (0 \cdot 1)/2 = 0$.

**Paso inductivo:** Sea $a_{m',n'} = m' + n'(n' + 1)/2$ con $(m', n')$ menor que $(m, n)$ en el orden lexicográfico de $\mathbb{N} \times \mathbb{N}$.

Por la definición recursiva, si $n = 0$, entonces $a_{m,n} = a_{m-1,n} + 1$. Como $(m - 1, n)$ es menor que $(m, n)$, la hipótesis de inducción nos dice que $a_{m-1,n} = m - 1 + n(n + 1)/2$, de donde $a_{m,n} = m - 1 + n(n + 1)/2 + 1 = m + n(n + 1)/2$, dando la igualdad deseada.

Ahora se supone que $n > 0$, por tanto $a_{m,n} = a_{m,n-1} + n$. Como $(m, n - 1)$ es menor que $(m, n)$, por hipótesis inductiva $a_{m,n-1} = m + (n - 1)n/2$ y de aquí $a_{m,n} = m + (n - 1)n/2 + n = m + (n^2 - n + 2n)/2 = m + n(n + 1)/2$, lo cual completa este paso.
:::

***

## Ejercicios

**Definición recursiva de un conjunto de enteros $S$:**
- El conjunto de un elemento $\{s\}$, donde $s$ es un entero, es un conjunto de enteros.
- Sean $S$ un conjunto de enteros y $e$ un entero, entonces $S \cup e$ es un conjunto de enteros.

**Algoritmo recursivo en Scala.** `maxSet` es la función que retorna el mayor elemento en un conjunto $S$ de enteros.

```scala
def max(a: Int, b: Int) = if (a>b) a else b
def maxList(conjunto: List[Int]): Int =
  conjunto match
    case h::Nil => 1
    case head::tail => max(maxList(tail, head))
```

:::{admonition} Demostración
- **Caso base:** Sea $S = \{a\}$ entonces, $|S| = 1$. En este caso, $mayor(S) = a$.
- **Caso recursivo:** Sea $S$ un conjunto de enteros, $S = \{e_1, e_2, \dots, e_k, e_{k+1}\}$. Asumimos que el algoritmo funciona correctamente para $S' = \{e_1, e_2, \dots, e_k\}$ y que $mayor(S') = d$. Ahora bien, para $S = S' \cup e_{k+1}$ el algoritmo entra en el `else` en donde se calcula $max(mayor(S'), e_{k+1})$; por hipótesis inductiva $mayor(S') = d$ es el entero mayor del conjunto $S'$, entonces reemplazamos en la definición y calculamos $max(d, e_{k+1})$ que es el mayor del conjunto $S$.
:::

***

### Ejercicio 1

Obtenga $f(2)$, $f(3)$, $f(4)$ y $f(5)$ si $f$ se define recursivamente por $f(0) = f(1) = 1$ y para $n = 1, 2, \dots$, como:

a) $f(n + 1) = f(n) - f(n - 1)$
b) $f(n + 1) = f(n)f(n - 1)$
c) $f(n + 1) = f(n)^2 + f(n - 1)^3$
d) $f(n + 1) = f(n)/f(n - 1)$

:::{admonition} 💡 Ver solución
:class: dropdown

a) $f(2) = 1 - 1 = 0$; $f(3) = 0 - 1 = -1$; $f(4) = -1 - 0 = -1$; $f(5) = -1 - (-1) = 0$

b) $f(2) = 1 \cdot 1 = 1$; $f(3) = 1 \cdot 1 = 1$; $f(4) = 1 \cdot 1 = 1$; $f(5) = 1 \cdot 1 = 1$

c) $f(2) = 1^2 + 1^3 = 2$; $f(3) = 2^2 + 1^3 = 5$; $f(4) = 5^2 + 2^3 = 33$; $f(5) = 33^2 + 5^3 = 1089 + 125 = 1214$

d) $f(2) = 1/1 = 1$; $f(3) = 1/1 = 1$; $f(4) = 1/1 = 1$; $f(5) = 1/1 = 1$
:::

***

### Ejercicio 2

Dé una función recursiva para la sucesión $\{a_n\}$, $n = 1, 2, 3, \dots$, si

a) $a_n = 4n - 2$
b) $a_n = 1 + (-1)^n$
c) $a_n = n(n + 1)$
d) $a_n = n^2$

:::{admonition} 💡 Ver solución
:class: dropdown

a) $a_{n+1} - a_n = 4(n+1) - 2 - (4n - 2) = 4$. Entonces $a_1 = 2$, $a_{n+1} = a_n + 4$ para $n \geq 1$.

b) Los valores alternan $0, 2, 0, 2, \dots$: $a_1 = 0$, $a_{n+1} = 2 - a_n$ para $n \geq 1$.

c) $a_{n+1} - a_n = (n+1)(n+2) - n(n+1) = 2(n+1)$. Entonces $a_1 = 2$, $a_{n+1} = a_n + 2(n+1)$ para $n \geq 1$.

d) $a_{n+1} - a_n = (n+1)^2 - n^2 = 2n + 1$. Entonces $a_1 = 1$, $a_{n+1} = a_n + 2n + 1$ para $n \geq 1$.
:::

***

### Ejercicio 3

Dé una definición recursiva de las funciones $\max$ y $\min$ de tal forma que $\max(a_1, a_2, \dots, a_n)$ y $\min(a_1, a_2, \dots, a_n)$ sean el máximo y el mínimo de los valores $a_1, a_2, \dots, a_n$, respectivamente.

:::{admonition} 💡 Ver solución
:class: dropdown

$$
\max(a_1, \dots, a_n) =
\begin{cases}
a_1 & \text{si } n = 1 \\
\max\big(\max(a_1, \dots, a_{n-1}), a_n\big) & \text{si } n > 1
\end{cases}
$$

$$
\min(a_1, \dots, a_n) =
\begin{cases}
a_1 & \text{si } n = 1 \\
\min\big(\min(a_1, \dots, a_{n-1}), a_n\big) & \text{si } n > 1
\end{cases}
$$
:::

***

### Ejercicio 4

Utilice la inducción generalizada para demostrar que si $a_{m,n}$ se define recursivamente por $a_{0,0} = 0$ y

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 1 & \text{si } n = 0 \text{ y } m > 0 \\
a_{m,n-1} + 1 & \text{si } n > 0,
\end{cases}
$$

entonces $a_{m,n} = m + n$ para todo $(m, n) \in \mathbb{N} \times \mathbb{N}$.

:::{admonition} 💡 Ver solución
:class: dropdown

**Paso base:** $(m, n) = (0, 0)$. Por definición $a_{0,0} = 0$, y por fórmula $0 + 0 = 0$. ✓

**Paso inductivo:** Suponga $a_{m',n'} = m' + n'$ para todo $(m', n')$ menor que $(m, n)$ en el orden lexicográfico.

- Caso $n = 0$, $m > 0$: $a_{m,0} = a_{m-1,0} + 1 = (m - 1 + 0) + 1 = m = m + 0$. ✓
- Caso $n > 0$: $a_{m,n} = a_{m,n-1} + 1 = (m + (n-1)) + 1 = m + n$. ✓
:::

***

### Ejercicio 5

Utilice la inducción generalizada para demostrar que si $a_{m,n}$ se define recursivamente por $a_{1,1} = 5$ y

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 2 & \text{si } n = 1 \text{ y } m > 1 \\
a_{m,n-1} + 2 & \text{si } n > 1,
\end{cases}
$$

entonces $a_{m,n} = 2(m + n) + 1$ para todo $(m, n) \in \mathbb{Z}^+ \times \mathbb{Z}^+$.

:::{admonition} 💡 Ver solución
:class: dropdown

**Paso base:** $(m, n) = (1, 1)$. Por definición $a_{1,1} = 5$, y por fórmula $2(1 + 1) + 1 = 5$. ✓

**Paso inductivo:** Suponga la fórmula válida para todo par menor que $(m, n)$ en el orden lexicográfico.

- Caso $n = 1$, $m > 1$: $a_{m,1} = a_{m-1,1} + 2$. Por H.I., $a_{m-1,1} = 2((m-1) + 1) + 1 = 2m + 1$. Entonces $a_{m,1} = 2m + 1 + 2 = 2(m + 1) + 1$. ✓
- Caso $n > 1$: $a_{m,n} = a_{m,n-1} + 2$. Por H.I., $a_{m,n-1} = 2(m + (n-1)) + 1 = 2(m+n) - 1$. Entonces $a_{m,n} = 2(m+n) - 1 + 2 = 2(m+n) + 1$. ✓
:::

***

### Ejercicios sugeridos

Ejercicios sugeridos del libro de Rosen, sección 5.3: 18, 27, 29, 32 y 41.

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
