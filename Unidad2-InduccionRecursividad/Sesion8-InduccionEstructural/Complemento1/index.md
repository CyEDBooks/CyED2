---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 8: Inducción estructural — Complemento 1"
---

# Unidad 2 · Sesión 8: Inducción estructural
## Complemento 1 — Inducción Estructural e Inducción Generalizada

***

## Contenido

1. Objetivos terminales
2. Repaso de recursividad
3. Inducción estructural
4. Inducción generalizada
5. Ejercicios

***

## Objetivos terminales

**OT2.** Aplicar el principio de inducción matemática para definir estructuras discretas, demostrar sus propiedades y verificar algoritmos formalmente, en particular, establecer y resolver relaciones de recurrencia asociadas a la complejidad de dichos algoritmos.

**OT4.** Expresar o comunicar con el vocabulario y lenguaje adecuado/especializado las ideas principales sobre estructuras discretas o la programación funcional.

***

## Repaso de recursividad

### Definición matemática

:::{admonition} Definición
Una función recursiva es aquella que se define en términos de sí misma. Consta de dos partes esenciales:
- **Caso base:** Valor conocido que detiene la recursión.
- **Caso recursivo:** Definición que reduce el problema hacia el caso base.
:::

**Notación formal**

$$
f(n) =
\begin{cases}
\text{valor conocido} & \text{si } n \text{ cumple condición base} \\
g(n, f(\dots)) & \text{en otro caso}
\end{cases}
$$

donde la expresión en el caso recursivo debe converger hacia la condición base.

### Ejemplos matemáticos clásicos

**Factorial**

$$
F(n) =
\begin{cases}
1 & \text{si } n = 0 \\
n \cdot F(n - 1) & \text{si } n > 0
\end{cases}
$$

**Sumatoria**

$$
H(n) = \sum_{k=0}^{n} a_k =
\begin{cases}
a_0 & \text{si } n = 0 \\
H(n - 1) + a_n & \text{si } n > 0
\end{cases}
$$

**Fibonacci**

$$
\mathrm{fib}(n) =
\begin{cases}
0 & \text{si } n = 0 \\
1 & \text{si } n = 1 \\
\mathrm{fib}(n - 1) + \mathrm{fib}(n - 2) & \text{si } n > 1
\end{cases}
$$

### Recursividad en Scala

```scala
// Factorial en Scala
def factorial(n: Int): Int =
  if (n == 0) 1              // Caso base
  else n * factorial(n - 1)  // Caso recursivo
```

```scala
// Fibonacci en Scala
def fib(n: Int): Int =
  if (n == 0) 0                 // Caso base 1
  else if (n == 1) 1             // Caso base 2
  else fib(n - 1) + fib(n - 2)   // Caso recursivo
```

:::{admonition} Recordar
Sin `return`, `break` ni `continue`. La última expresión evaluada es el valor de retorno.
:::

### Conjuntos definidos recursivamente

:::{admonition} Definición inductiva de un conjunto
Un conjunto $S$ se define recursivamente mediante:
1. **Paso base:** Elemento(s) que pertenecen a $S$.
2. **Paso recursivo:** Regla(s) que generan nuevos elementos a partir de los existentes.
:::

**Ejemplo: Múltiplos de 3**
- Paso base: $3 \in S$
- Paso recursivo: Si $x \in S$ y $y \in S$, entonces $x + y \in S$

Así: $S = \{3\} \to \{3, 6\} \to \{3, 6, 9\} \to \{3, 6, 9, 12\} \to \cdots$

**Ejemplo: Listas de números naturales**
- Paso base: $\mathrm{Nil} \in S$ (lista vacía)
- Paso recursivo: Si $x \in \mathbb{N}$ y $l \in S$, entonces $x :: l \in S$

***

## Inducción estructural

### Concepto

:::{admonition} Definición (Rosen, Sección 5.3)
La inducción estructural es una forma particular de inducción matemática utilizada para demostrar propiedades sobre conjuntos definidos recursivamente.
:::

:::{admonition} Idea clave
Así como la inducción matemática clásica recorre los números naturales ($n \to n + 1$), la inducción estructural recorre la estructura del objeto: se demuestra la propiedad para los elementos base, y luego se muestra que se preserva al aplicar las reglas de construcción.
:::

### Método formal

:::{admonition} Inducción estructural: esquema de demostración
Sea $S$ un conjunto definido recursivamente y $P$ una propiedad sobre los elementos de $S$.

- **Paso base:** Demostrar que $P(s)$ es verdadera para cada elemento $s$ especificado en el paso base de la definición de $S$.
- **Paso recursivo (inductivo):** Para cada regla de construcción del conjunto $S$, suponer que $P$ es verdadera para los elementos usados en la regla (hipótesis inductiva), y demostrar que $P$ también es verdadera para el nuevo elemento generado.
:::

**Conclusión**

$$
\Big[P(\text{bases}) \wedge \forall x \in S\,\big(P(\text{componentes de } x) \to P(x)\big)\Big] \;\to\; \forall s \in S,\, P(s)
$$

> La fórmula anterior resume el esquema completo: si la propiedad se cumple en las bases, y además se preserva cada vez que se construye un elemento nuevo a partir de otros que ya la cumplen, entonces se cumple para *todo* elemento del conjunto — sin importar cuántas veces se haya aplicado el paso recursivo para construirlo.

### Ejemplo: Longitud de concatenación de cadenas

**Definición recursiva de cadena sobre un alfabeto $\Sigma$**
- Paso base: La cadena vacía $\lambda$ es una cadena ($\lambda \in \Sigma^*$).
- Paso recursivo: Si $C$ es una cadena y $c \in \Sigma$, entonces $c \cdot C$ es una cadena.

**Definición recursiva de longitud $l$**
- $l(\lambda) = 0$
- $l(c \cdot C) = 1 + l(C)$ para $c \in \Sigma$, $C \in \Sigma^*$

:::{admonition} Propiedad a demostrar
Para todo $x, y \in \Sigma^*$: $\quad l(xy) = l(x) + l(y)$
:::

Hacemos inducción estructural sobre $y$. Sea $P(y)$: "$l(xy) = l(x) + l(y)$ para todo $x \in \Sigma^*$".

**Paso base ($y = \lambda$):**

$$
l(x\lambda) = l(x) = l(x) + 0 = l(x) + l(\lambda). \quad\checkmark
$$

> Aquí simplemente se usa que concatenar la cadena vacía no cambia nada ($x\lambda = x$) y que $l(\lambda) = 0$ por definición; por eso $l(x)+0$ y $l(x)+l(\lambda)$ son la misma cantidad.

**Paso recursivo ($y \to ya$ con $a \in \Sigma$):**

Suponemos $P(y)$: $l(xy) = l(x) + l(y)$ (hipótesis inductiva). Debemos demostrar $P(ya)$: $l(x(ya)) = l(x) + l(ya)$.

$$
\begin{aligned}
l(x(ya)) &= l((xy)a) &&\text{(la concatenación es asociativa: agrupar $x$ con $y$ antes de pegar $a$)}\\
&= l(xy) + 1 &&\text{(def. de $l$: $l(c\cdot C)=1+l(C)$, aquí $a$ es el carácter "pegado" al final)}\\
&= [l(x) + l(y)] + 1 &&\text{(H.I.: se reemplaza $l(xy)$ usando $P(y)$)}\\
&= l(x) + [l(y) + 1] &&\text{(reagrupar la suma — asociatividad de $+$)}\\
&= l(x) + l(ya) &&\text{(def. de $l$: $l(y)+1 = l(ya)$, en sentido inverso)}
\end{aligned}
$$

$\checkmark$ Con esto, $P(y) \Rightarrow P(ya)$ para toda $a \in \Sigma$, lo que completa el paso recursivo y demuestra $P(y)$ para toda $y \in \Sigma^*$.

### Inducción estructural en Scala: Listas

**Definición recursiva de `List[Int]` en Scala**
- Paso base: `Nil` (lista vacía)
- Paso recursivo: `head :: tail` donde `head: Int` y `tail: List[Int]`

```scala
// Suma de una lista
def sumarLista(lst: List[Int]): Int =
  if (lst.isEmpty) 0
  else lst.head + sumarLista(lst.tail)
```

**Traza de ejecución**

```
sumarLista(List(1,2,3))
= 1 + sumarLista(List(2,3))          // se separa el head (1) y se recurre sobre el tail
= 1 + 2 + sumarLista(List(3))        // igual: head=2, se recurre sobre List(3)
= 1 + 2 + 3 + sumarLista(Nil)        // head=3, el tail ya es la lista vacía
= 1 + 2 + 3 + 0 = 6                  // caso base: sumarLista(Nil) = 0
```

**Más algoritmos sobre listas**

```scala
// Longitud de una lista
def longitud(lst: List[Int]): Int =
  if (lst.isEmpty) 0
  else 1 + longitud(lst.tail)
```

```scala
// Invertir una lista (con auxiliar)
def invertirAux(n: Int, lst: List[Int]): List[Int] =
  if (lst.isEmpty) List(n)
  else lst.head :: invertirAux(n, lst.tail)

def invertir(lst: List[Int]): List[Int] =
  if (lst.isEmpty) List()
  else invertirAux(lst.head, invertir(lst.tail))
```

### Ordenar por inserción

```scala
// Insertion sort recursivo
def insertarOrdenado(n: Int, lst: List[Int]): List[Int] =
  if (lst.isEmpty) List(n)
  else {
    if (lst.head < n)
      lst.head :: insertarOrdenado(n, lst.tail)
    else n :: lst
  }

def ordenar(lst: List[Int]): List[Int] =
  if (lst.isEmpty) List()
  else insertarOrdenado(lst.head, ordenar(lst.tail))
```

:::{admonition} Receta de diseño para listas
1. **Caso base:** Lista vacía → respuesta inmediata.
2. **Caso recursivo:** Procesar `head`, llamar recursivamente con `tail`.
:::

### Ejemplo: Propiedad de longitud y `++`

:::{admonition} Propiedad a demostrar por inducción estructural
Para toda lista $l_1, l_2$:

$$
\mathrm{longitud}(l_1 \mathbin{+\!\!+} l_2) = \mathrm{longitud}(l_1) + \mathrm{longitud}(l_2)
$$
:::

Inducción sobre la estructura de $l_1$.

**Paso base ($l_1 = \mathrm{Nil}$):**

$$
\mathrm{longitud}(\mathrm{Nil} \mathbin{+\!\!+} l_2) = \mathrm{longitud}(l_2) = 0 + \mathrm{longitud}(l_2). \quad\checkmark
$$

> `Nil ++ l2` es simplemente `l2` (concatenar con la lista vacía no agrega nada), y `longitud(Nil) = 0`; por eso ambos lados coinciden.

**Paso recursivo ($l_1 = h :: t$):**

Hipótesis inductiva: $\mathrm{longitud}(t \mathbin{+\!\!+} l_2) = \mathrm{longitud}(t) + \mathrm{longitud}(l_2)$.

Debemos demostrar: $\mathrm{longitud}((h :: t) \mathbin{+\!\!+} l_2) = \mathrm{longitud}(h :: t) + \mathrm{longitud}(l_2)$.

$$
\begin{aligned}
\mathrm{longitud}((h :: t) \mathbin{+\!\!+} l_2) &= \mathrm{longitud}(h :: (t \mathbin{+\!\!+} l_2)) &&\text{(def. de $\mathbin{+\!\!+}$: pegar $l_2$ detrás de $t$, dejando $h$ al frente)}\\
&= 1 + \mathrm{longitud}(t \mathbin{+\!\!+} l_2) &&\text{(def. de longitud: se cuenta el head $h$)}\\
&= 1 + \mathrm{longitud}(t) + \mathrm{longitud}(l_2) &&\text{(H.I.: se reemplaza $\mathrm{longitud}(t \mathbin{+\!\!+} l_2)$)}\\
&= \mathrm{longitud}(h :: t) + \mathrm{longitud}(l_2) &&\text{(def. de longitud, en sentido inverso: $1+\mathrm{longitud}(t) = \mathrm{longitud}(h::t)$)}
\end{aligned}
\quad\checkmark
$$

### Otro ejemplo: Concatenar y sumar

:::{admonition} Propiedad
$$
\mathrm{sumarLista}(l_1 \mathbin{+\!\!+} l_2) = \mathrm{sumarLista}(l_1) + \mathrm{sumarLista}(l_2)
$$
:::

**Paso base ($l_1 = \mathrm{Nil}$):**

$$
\mathrm{sumarLista}(\mathrm{Nil} \mathbin{+\!\!+} l_2) = \mathrm{sumarLista}(l_2) = 0 + \mathrm{sumarLista}(l_2). \quad\checkmark
$$

**Paso recursivo ($l_1 = h :: t$):** H.I.: $\mathrm{sumarLista}(t \mathbin{+\!\!+} l_2) = \mathrm{sumarLista}(t) + \mathrm{sumarLista}(l_2)$.

$$
\begin{aligned}
\mathrm{sumarLista}((h :: t) \mathbin{+\!\!+} l_2) &= \mathrm{sumarLista}(h :: (t \mathbin{+\!\!+} l_2)) &&\text{(def. de $\mathbin{+\!\!+}$, igual que en el ejemplo anterior)}\\
&= h + \mathrm{sumarLista}(t \mathbin{+\!\!+} l_2) &&\text{(def. de sumarLista: se suma el head $h$)}\\
&= h + \mathrm{sumarLista}(t) + \mathrm{sumarLista}(l_2) &&\text{(H.I.)}\\
&= \mathrm{sumarLista}(h :: t) + \mathrm{sumarLista}(l_2) &&\text{(def. de sumarLista, en sentido inverso)}
\end{aligned}
\quad\checkmark
$$

> Nótese el mismo patrón de los dos ejemplos anteriores: separar el `head` con la definición de la operación, aplicar la hipótesis inductiva sobre el `tail`, y volver a agrupar. Es la estructura fija de toda demostración por inducción estructural sobre listas.

***

## Inducción generalizada

### Concepto

:::{admonition} Definición
La inducción generalizada extiende el principio de inducción matemática para demostrar propiedades sobre conjuntos que no son necesariamente los enteros, siempre que se garantice la propiedad del buen orden.
:::

**Método**
1. Se define un orden sobre el dominio (por ejemplo, orden lexicográfico).
2. **Paso base:** Se verifica la propiedad para el elemento mínimo del orden.
3. **Paso inductivo:** Se supone que la propiedad vale para todos los elementos menores que $(m, n)$ en dicho orden, y se demuestra para $(m, n)$.

### Orden lexicográfico

:::{admonition} Definición
El orden lexicográfico de $\mathbb{N} \times \mathbb{N}$ define un orden total para las parejas de enteros no negativos:

$$
(x_1, y_1) \leq (x_2, y_2) \iff x_1 < x_2 \text{ o } (x_1 = x_2 \text{ y } y_1 \leq y_2)
$$
:::

**Ejemplo:** $(0,0) < (0,1) < (0,2) < \cdots < (1,0) < (1,1) < (1,2) < \cdots < (2,0) < \cdots$

:::{admonition} Propiedad del buen orden
Todo subconjunto no vacío de $\mathbb{N} \times \mathbb{N}$ con el orden lexicográfico tiene un elemento mínimo. Esto valida el uso de inducción sobre este conjunto.
:::

> Esta propiedad es la que juega, en la inducción generalizada, el mismo papel que "todo natural tiene un sucesor" juega en la inducción matemática clásica: garantiza que no hay una cadena infinita descendente de elementos "menores", así que el paso inductivo eventualmente toca el paso base.

### Ejemplo: Inducción generalizada con $a_{m,n}$

**Definición recursiva.** Sea $a_{m,n}$ definida para $(m, n) \in \mathbb{N} \times \mathbb{N}$ por $a_{0,0} = 0$ y:

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 1 & \text{si } n = 0 \text{ y } m > 0 \\
a_{m,n-1} + n & \text{si } n > 0
\end{cases}
$$

:::{admonition} Propiedad a demostrar
$$
a_{m,n} = m + \frac{n(n+1)}{2} \quad \text{para todo } (m,n) \in \mathbb{N} \times \mathbb{N}.
$$
:::

**Paso base:** $(m, n) = (0, 0)$.
Por definición: $a_{0,0} = 0$. Por fórmula: $0 + \frac{0 \cdot 1}{2} = 0$. $\checkmark$

**Paso inductivo:** Supongamos que $a_{m',n'} = m' + \frac{n'(n'+1)}{2}$ para todo $(m', n')$ menor que $(m, n)$ en el orden lexicográfico. Se analizan los dos casos de la definición recursiva por separado.

**Caso $n = 0$, $m > 0$:** $a_{m,0} = a_{m-1,0} + 1$. Como $(m-1, 0) < (m, 0)$, por H.I.:

$$
\begin{aligned}
a_{m-1,0} &= (m-1) + \frac{0 \cdot 1}{2} = m - 1 &&\text{(H.I. aplicada a $(m-1,0)$)}\\
\Rightarrow\quad a_{m,0} &= (m-1) + 1 = m = m + \frac{0 \cdot 1}{2} &&\text{(se suma el $+1$ de la definición recursiva)}
\end{aligned}
\quad\checkmark
$$

**Caso $n > 0$:** $a_{m,n} = a_{m,n-1} + n$. Como $(m, n-1) < (m, n)$, por H.I.:

$$
\begin{aligned}
a_{m,n-1} &= m + \frac{(n-1)n}{2} &&\text{(H.I. aplicada a $(m,n-1)$)}\\
a_{m,n} &= m + \frac{(n-1)n}{2} + n &&\text{(se suma el $+n$ de la definición recursiva)}\\
&= m + \frac{n^2 - n}{2} + \frac{2n}{2} &&\text{(se expande y se lleva $n$ a común denominador)}\\
&= m + \frac{n^2 - n + 2n}{2} &&\text{(se suman las fracciones)}\\
&= m + \frac{n^2 + n}{2} = m + \frac{n(n+1)}{2} &&\text{(se simplifica y factoriza $n^2+n = n(n+1)$)}
\end{aligned}
\quad\checkmark
$$

### Otro ejemplo: Inducción generalizada

**Definición recursiva.** Sea $b_{m,n}$ definida para $(m, n) \in \mathbb{Z}^+ \times \mathbb{Z}^+$ por $b_{1,1} = 5$ y:

$$
b_{m,n} =
\begin{cases}
b_{m-1,n} + 2 & \text{si } n = 1 \text{ y } m > 1 \\
b_{m,n-1} + 2 & \text{si } n > 1
\end{cases}
$$

:::{admonition} Propiedad a demostrar
$$
b_{m,n} = 2(m+n) + 1 \quad \text{para todo } (m,n) \in \mathbb{Z}^+ \times \mathbb{Z}^+.
$$
:::

**Paso base:** $(m, n) = (1, 1)$.
Por definición: $b_{1,1} = 5$. Por fórmula: $2(1+1) + 1 = 5$. $\checkmark$

**Caso $n = 1$, $m > 1$:** $b_{m,1} = b_{m-1,1} + 2$.

$$
\begin{aligned}
b_{m-1,1} &= 2((m-1)+1) + 1 = 2m + 1 &&\text{(H.I. aplicada a $(m-1,1)$)}\\
\Rightarrow\quad b_{m,1} &= 2m + 1 + 2 = 2(m+1) + 1 &&\text{(se suma el $+2$ de la definición recursiva y se reagrupa)}
\end{aligned}
\quad\checkmark
$$

**Caso $n > 1$:** $b_{m,n} = b_{m,n-1} + 2$.

$$
\begin{aligned}
b_{m,n-1} &= 2(m + (n-1)) + 1 = 2(m+n) - 1 &&\text{(H.I. aplicada a $(m,n-1)$)}\\
\Rightarrow\quad b_{m,n} &= 2(m+n) - 1 + 2 = 2(m+n) + 1 &&\text{(se suma el $+2$ de la definición recursiva)}
\end{aligned}
\quad\checkmark
$$

***

## Ejercicios

### Ejercicios del libro de Rosen (Sección 5.3)

**Ejercicio 1 (Rosen 5.3 – 18).** Obtenga $f(2)$, $f(3)$, $f(4)$ y $f(5)$ si $f$ se define recursivamente por $f(0) = f(1) = 1$ y para $n = 1, 2, \dots$:

a) $f(n+1) = f(n) - f(n-1)$
b) $f(n+1) = f(n) \cdot f(n-1)$
c) $f(n+1) = f(n)^2 + f(n-1)^3$
d) $f(n+1) = f(n)/f(n-1)$

:::{admonition} 💡 Pista
:class: dropdown
Evalúe paso a paso reemplazando los valores ya calculados. Comience con $f(2) = g(f(1), f(0))$ y continúe.
:::

**Ejercicio 2 (Rosen 5.3 – 27).** Dé una definición recursiva de las funciones máx y mín de tal forma que $\max(a_1, a_2, \dots, a_n)$ y $\min(a_1, a_2, \dots, a_n)$ sean el máximo y el mínimo de los valores, respectivamente.

:::{admonition} 💡 Pista
:class: dropdown
Defina el caso base para $n = 1$ y el caso recursivo comparando $a_n$ con $\max(a_1, \dots, a_{n-1})$.
:::

**Ejercicio 3 (Rosen 5.3 – 29).** Dé una definición recursiva de la función $a_n = 4n - 2$ para $n = 1, 2, 3, \dots$

:::{admonition} 💡 Pista
:class: dropdown
Busque una relación entre $a_{n+1}$ y $a_n$. Note que $a_{n+1} - a_n = 4$.
:::

**Ejercicio 4 (Rosen 5.3 – 32).** Demuestre por inducción estructural que el número de paréntesis izquierdos en un sistema de paréntesis balanceados es igual al número de paréntesis derechos.

:::{admonition} 💡 Pista
:class: dropdown
Considere la definición recursiva de paréntesis balanceados: la cadena vacía es balanceada, y si $w$ y $x$ son balanceadas, entonces $(w)$ y $wx$ son balanceadas. Haga inducción sobre esta estructura.
:::

**Ejercicio 5 (Rosen 5.3 – 41).** Utilice la inducción generalizada para demostrar que si $a_{m,n}$ se define recursivamente por $a_{0,0} = 0$ y

$$
a_{m,n} =
\begin{cases}
a_{m-1,n} + 1 & \text{si } n = 0 \text{ y } m > 0 \\
a_{m,n-1} + 1 & \text{si } n > 0
\end{cases}
$$

entonces $a_{m,n} = m + n$ para todo $(m, n) \in \mathbb{N} \times \mathbb{N}$.

:::{admonition} 💡 Pista
:class: dropdown
Siga el mismo esquema del ejemplo de $a_{m,n} = m + n(n+1)/2$. Considere los dos casos del paso inductivo por separado.
:::

### Ejercicio de inducción estructural con Scala

**Problema.** Considere la siguiente función que duplica cada elemento de una lista:

```scala
def duplicar(lst: List[Int]): List[Int] =
  if (lst.isEmpty) Nil
  else (lst.head * 2) :: duplicar(lst.tail)
```

Y la función `sumarLista` definida anteriormente.

:::{admonition} Propiedad a demostrar
Para toda lista $l$:

$$
\mathrm{sumarLista}(\mathrm{duplicar}(l)) = 2 \cdot \mathrm{sumarLista}(l)
$$

Demuestre esta propiedad por inducción estructural sobre $l$.
:::

:::{admonition} 💡 Pistas
:class: dropdown
1. **Paso base ($l = \mathrm{Nil}$):** Evalúe ambos lados y verifique que son iguales.
2. **Paso recursivo ($l = h :: t$):**
   - Establezca la hipótesis inductiva: $\mathrm{sumarLista}(\mathrm{duplicar}(t)) = 2 \cdot \mathrm{sumarLista}(t)$.
   - Expanda $\mathrm{duplicar}(h :: t)$ según la definición.
   - Aplique `sumarLista` al resultado.
   - Use la H.I. y álgebra para concluir.
:::

***

## Resumen

:::{admonition} Conceptos clave de hoy
- **Recursión:** Caso base + caso recursivo. Tanto en matemáticas como en Scala.
- **Inducción estructural:** Demostración sobre conjuntos definidos recursivamente siguiendo su estructura (cadenas, listas, árboles).
- **Inducción generalizada:** Extiende la inducción a dominios con buen orden (ej: $\mathbb{N} \times \mathbb{N}$ con orden lexicográfico).
:::

**Lecturas sugeridas**
- Rosen, Capítulo 5, Secciones 5.3 y 5.4.
- Cormen et al., Capítulo 4: Divide and Conquer (Apéndice sobre inducción).
- Odersky et al., Capítulo 16: Working with Lists.
