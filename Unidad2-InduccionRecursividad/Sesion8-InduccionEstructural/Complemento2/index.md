---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 8: Inducción estructural — Complemento 2"
---

# Unidad 2 · Sesión 8: Inducción estructural
## Complemento 2 — Definiciones recursivas e Inducción Estructural

***

## Agenda

1. Motivación
2. Definiciones recursivas
   - ... de Funciones
   - ... de Conjuntos
3. Las secuencias como estructura discreta
4. Inducción estructural
   - Inducción estructural
   - Teoremas sobre secuencias

***

## Motivación

Algunas veces, es difícil definir un objeto explícitamente. Y es más fácil hacerlo en términos de sí mismo: definiciones recursivas.

Podemos definir recursivamente funciones y conjuntos. La definición recursiva de conjuntos da lugar a estructuras, cuyas propiedades se prueban usando una especie de inducción llamada inducción estructural.

Las secuencias, las cadenas de caracteres, las fórmulas de la lógica proposicional y del cálculo de predicados son ejemplos de conjuntos muy usados en informática, definidos recursivamente.

Vamos a estudiar con detenimiento algunos de estos objetos definidos recursivamente y cómo probar propiedades sobre ellos.

***

## Definiciones recursivas de funciones

### Números de Fibonacci

Una pareja de conejos recién nacidos (macho y hembra) es dejada en una isla. Se sabe que los conejos no se pueden reproducir hasta que no cumplen dos meses de edad. Una vez una pareja de conejos cumple 2 meses de edad, se reproducen y dan a luz una pareja nueva. Se quiere definir una función $\mathrm{fib}: \mathbb{N} \to \mathbb{N}$ tal que $\mathrm{fib}(n)$ represente el número de parejas de conejos en la isla después de pasados $n$ meses. Suponga que ninguna pareja de conejos se muere.

Miremos el comportamiento en una tabla:

| Mes | Edad $\geq 2$ | Edad $1$ | Edad $0$ | Total |
|---|---|---|---|---|
| 0 | 0 | 0 | 1 | 1 |
| 1 | 0 | 1 | 0 | 1 |
| 2 | 1 | 0 | 1 | 2 |
| 3 | 1 | 1 | 1 | 3 |
| 4 | 2 | 1 | 2 | 5 |
| 5 | 3 | 2 | 3 | 8 |
| 6 | 5 | 3 | 5 | 13 |

Escrito recursivamente:

$$
\mathrm{fib}(n) =
\begin{cases}
1 & n = 0 \\
1 & n = 1 \\
\mathrm{fib}(n-2) + \mathrm{fib}(n-1) & n \geq 2
\end{cases}
$$

### Torres de Hanoi

Dios, al crear el mundo, colocó tres varillas de diamante con 64 discos apilados de mayor a menor radio en la primera varilla. También creó un monasterio con monjes, quienes tenían la tarea de resolver esta Torre de Hanoi divina. Para poder resolverla, los monjes debían llevar todos los discos a la última varilla quedando en el mismo orden a como estaban en la primera; además, se impuso tres condiciones: sólo se puede mover un disco a la vez, un disco de mayor diámetro no puede descansar sobre otro de diámetro menor y sólo se puede mover el disco que se encuentra arriba en cada varilla.

Dios profetizó que el día en que estos monjes consiguieran terminar el juego, el mundo acabaría. Si los monjes movieran cada segundo un disco, sin equivocarse, y la historia fuera cierta, ¿podrías decir cuándo será el fin del mundo?

Para responder la pregunta, se quiere definir una función $\mathrm{hanoi}: \mathbb{N} \to \mathbb{N}$ tal que $\mathrm{hanoi}(n)$ represente el número de movimientos mínimo necesario para mover una torre de $n$ discos.

Escrito recursivamente:

$$
\mathrm{hanoi}(n) =
\begin{cases}
1 & n = 1 \\
2\,\mathrm{hanoi}(n-1) + 1 & n \geq 2
\end{cases}
$$

***

## Probando una propiedad sobre `fib`

**Probar que** $\forall n \mid n \in \mathbb{N} \land n \geq 4 : \mathrm{fib}(n) > n$

Lo probaremos usando el principio de inducción fuerte: $P(n) \equiv \mathrm{fib}(n) > n$

**[Caso base]** Demostrar $P(4) \land P(5)$ (¿por qué?)

> **Nota:** el paso de inducción de más abajo calcula $\mathrm{fib}(k+1)$ a partir de $\mathrm{fib}(k-1)$ y $\mathrm{fib}(k)$, y solo se usa para $k \geq 5$ (es decir, para concluir $n = k+1 \geq 6$). Por eso el paso inductivo no cubre $n=4$ ni $n=5$: esos dos casos hay que verificarlos directamente como parte del caso base.

$$
P(4) \equiv \mathrm{fib}(4) > 4 \equiv 5 > 4 \equiv \mathit{true}
$$
$$
P(5) \equiv \mathrm{fib}(5) > 5 \equiv 8 > 5 \equiv \mathit{true}
$$

Por tanto: $P(4) \land P(5) \equiv \mathit{true}$

**[Caso de inducción]** Demostrar $(\forall j \mid 4 \leq j \leq k : P(j)) \vdash P(k+1)$ para $k \geq 5$.

- Teo $(P(k+1))$: $\mathrm{fib}(k+1) > (k+1)$
- Hip. Ind. $(\forall j \mid 4 \leq j \leq k : P(j))$: HI $: (\forall j \mid 4 \leq j \leq k : \mathrm{fib}(j) > j)$

$$
\begin{aligned}
\mathrm{fib}(k+1) &= \mathrm{fib}(k-1) + \mathrm{fib}(k) &&\text{Def. de fib}\\
&> (k - 1) + k &&\text{HI (aplicada a } j=k-1 \text{ y } j=k \text{)}\\
&> k + 1 &&(k-1) > 1 \text{ pues } k \geq 5
\end{aligned}
$$

$\square$ Por tanto, $\forall n \mid n \in \mathbb{N} \land n \geq 4 : \mathrm{fib}(n) > n$

***

## Probando una propiedad sobre `hanoi`

**Probar que** $\forall n \mid n \in \mathbb{N} \land n \geq 1 : \mathrm{hanoi}(n) = 2^n - 1$

Lo probaremos usando el principio de inducción: $P(n) \equiv \mathrm{hanoi}(n) = 2^n - 1$

**[Caso base]** Demostrar $P(1)$

$$
P(1) \equiv \mathrm{hanoi}(1) = 2^1 - 1 \equiv 1 = 1 \equiv \mathit{true}
$$

Por tanto: $P(1) \equiv \mathit{true}$

**[Caso de inducción]** Demostrar $P(k) \vdash P(k+1)$ para $k \geq 1$.

- Teo $(P(k+1))$: $\mathrm{hanoi}(k+1) = 2^{k+1} - 1$
- Hip. Ind. $(P(k))$: HI $: \mathrm{hanoi}(k) = 2^k - 1$

$$
\begin{aligned}
\mathrm{hanoi}(k+1) &= 2\,\mathrm{hanoi}(k) + 1 &&\text{Def. de hanoi}\\
&= 2(2^k - 1) + 1 &&\text{HI}\\
&= 2^{k+1} - 2 + 1 &&\text{Aritmética}\\
&= 2^{k+1} - 1 &&\text{Aritmética}
\end{aligned}
$$

$\square$ Por tanto, $\forall n \mid n \in \mathbb{N} \land n \geq 1 : \mathrm{hanoi}(n) = 2^n - 1$

***

## Definición recursiva de conjuntos

Toda definición recursiva de un conjunto tiene dos tipos de reglas: las **básicas**, que especifican elementos que pertenecen al conjunto, y las **recursivas**, que especifican cómo construir elementos del conjunto a partir de elementos ya conocidos del conjunto.

Sea $A$ el conjunto definido así:

- $3 \in A$
- $x \in A \land y \in A \implies (x + y) \in A$

Enumere 5 elementos de $A$: $3, 6, 9, 12, 15, \dots$

¿Cómo podría describir los elementos de $A$? Todo elemento de $A$ es múltiplo de 3 (pendiente demostrarlo).

Sobre un conjunto definido recursivamente, es natural definir funciones (u operaciones) recursivamente. Por ejemplo, considere la función $\mathrm{coc} : A \to \mathbb{N}$:

$$
\mathrm{coc}(a) =
\begin{cases}
1 & a = 3 \\
\mathrm{coc}(x) + \mathrm{coc}(y) & a = x+y \land x \in A \land y \in A
\end{cases}
$$

Calcule $\mathrm{coc}(9)$:

$$
\mathrm{coc}(9) = \mathrm{coc}(3+6) = \mathrm{coc}(3) + \mathrm{coc}(6) = \mathrm{coc}(3) + \mathrm{coc}(3+3) = \mathrm{coc}(3) + \mathrm{coc}(3) + \mathrm{coc}(3) = 1+1+1 = 3
$$

> **Nota:** obsérvese que $\mathrm{coc}(a)$ termina contando cuántas veces aparece el $3$ "de base" al descomponer $a$ como sumas — por eso $\mathrm{coc}(9) = 3$ (porque $9 = 3+3+3$). Como $A$ solo contiene múltiplos de 3, $\mathrm{coc}(a) = a/3$ para todo $a \in A$, aunque esa igualdad todavía no se ha demostrado formalmente aquí.

### ¿Entendimos las definiciones recursivas de funciones y conjuntos?

**Ejercicio 1.** Para cada función $f : \mathbb{N} \to \mathbb{N}$ definida recursivamente, calcule los valores solicitados:

1. $f(n) = \begin{cases} 1 & n=0 \\ f(n-1)+2 & n \geq 1 \end{cases}$. Calcule $f(1), f(2), f(6)$.
2. $f(n) = \begin{cases} 1 & n=0 \\ 2f(n-1) & n \geq 1 \end{cases}$. Calcule $f(1), f(2), f(4)$.
3. $f(n) = \begin{cases} 3 & n=0 \\ 3f(n-1)+7 & n \geq 1 \end{cases}$. Calcule $f(1), f(2), f(3)$.

:::{admonition} 💡 Ver solución
:class: dropdown

1. $f(1)=3$, $f(2)=5$, $f(3)=7$, $f(4)=9$, $f(5)=11$, $f(6)=13$.
2. $f(1)=2$, $f(2)=4$, $f(3)=8$, $f(4)=16$.
3. $f(1)=3\cdot3+7=16$, $f(2)=3\cdot16+7=55$, $f(3)=3\cdot55+7=172$.
:::

**Ejercicio 2.** Para cada función $f : \mathbb{N} \to \mathbb{Z}$ definida recursivamente, con $f(0)=f(1)=1$, calcule los valores solicitados:

1. $f(n) = f(n-1) - f(n-2)$ para $n \geq 2$. Calcule $f(2), f(3), f(5)$.
2. $f(n) = f(n-1)f(n-2)$ para $n \geq 2$. Calcule $f(2), f(3), f(5)$.
3. $f(n) = f(n-1)/f(n-2)$ para $n \geq 2$. Calcule $f(2), f(3), f(5)$.

:::{admonition} 💡 Ver solución
:class: dropdown

1. $f(2)=1-1=0$, $f(3)=0-1=-1$, $f(4)=-1-0=-1$, $f(5)=-1-(-1)=0$.
2. $f(2)=1\cdot1=1$, $f(3)=1\cdot1=1$, $f(4)=1\cdot1=1$, $f(5)=1\cdot1=1$.
3. $f(2)=1/1=1$, $f(3)=1/1=1$, $f(4)=1/1=1$, $f(5)=1/1=1$.
:::

***

## Estructuras: conjuntos + operaciones

Las estructuras de datos usadas en informática se representan formalmente como estructuras algebraicas, es decir, conjuntos y operaciones sobre ellos.

Muchas de estas estructuras se representan con conjuntos definidos recursivamente y operaciones (funciones) sobre esos conjuntos que también son naturalmente recursivas.

Estas estructuras se usan para representar de manera genérica (independiente de la implementación) estructuras de datos que se usan en informática, como las **Secuencias**. Y en general, para describir los Tipos Abstractos de Datos (TAD).

Entonces, se pueden estudiar estas estructuras y sus propiedades de forma abstracta. Cualquier implementación deberá cumplir esas propiedades.

Como ejemplo, vamos a definir la estructura denominada **Secuencia**.

***

## Las secuencias como estructura discreta

### Motivación

Los conjuntos se usan para modelar datos de ciertos tipos (enteros, reales, caracteres, ...), normalmente de tamaño fijo. Para modelar datos de tamaño arbitrariamente grande, se usa una estructura discreta denominada **secuencia**.

Con las secuencias se desea representar listas ordenadas de elementos de algún conjunto. Una secuencia permite "empaquetar" en un sólo "dato" múltiples elementos de un conjunto de forma ordenada.

Formalmente, una secuencia $s$ de elementos de un conjunto $A$ es una función

$$
s : \{i \in \mathbb{N} : 0 \leq i < n\} \to A
$$

$s(0)$ es el primer elemento de la secuencia, $s(1)$ es el segundo, y así sucesivamente hasta $s(n-1)$ que es el último elemento de la secuencia. Se suele escribir

$$
\langle s_0, s_1, \dots, s_{n-1} \rangle
$$

Por definición toda secuencia tiene un número finito de elementos. Cuando se desea modelar una lista ordenada de un número infinito de elementos se utiliza una **sucesión**, que no es más que $s : \mathbb{N} \to A$.

### Definición recursiva de secuencia

El conjunto de secuencias de elementos del conjunto $A$ ($\mathrm{Seq}[A]$) también se puede definir recursivamente, así:

- $\varepsilon$ representa la secuencia sin elementos o secuencia vacía.
- Si $a \in A$ y $s \in \mathrm{Seq}[A]$, entonces $t = a \mathbin{/} s \in \mathrm{Seq}[A]$ representa la secuencia cuyo primer elemento es $a$ y los otros están en el orden en que estaban en $s$, es decir, $t_0 = a, t_1 = s_0, \dots, t_n = s_{n-1}$.

Visto de otra manera: $a \mathbin{/} \langle a_0, a_1, \dots, a_{n-1} \rangle = \langle a, a_0, a_1, \dots, a_{n-1} \rangle$

Nótese que la secuencia $\langle a_0, a_1, \dots, a_{n-1} \rangle$ se puede escribir como $a_0 \mathbin{/} (a_1 \mathbin{/} (a_2 \mathbin{/} \dots \mathbin{/} (a_{n-1} \mathbin{/} \varepsilon) \dots))$, y se escribe por convención

$$
a_0 \mathbin{/} a_1 \mathbin{/} a_2 \mathbin{/} \dots \mathbin{/} a_{n-1} \mathbin{/} \varepsilon
$$

Tenemos ahora un mecanismo para construir secuencias incrementalmente.

> **Nota:** el operador $\mathbin{/}$ (llamado *cons*) es exactamente el mismo mecanismo que `::` en Scala para listas: agrega un elemento al frente de una secuencia ya construida. El paso base es la secuencia vacía $\varepsilon$ (equivalente a `Nil`), y el paso recursivo agrega un elemento a la vez.

### Operaciones sobre secuencias

Sea $s = \langle 4, 2, 5 \rangle \in \mathrm{Seq}[\mathbb{N}]$. Entonces $7 \mathbin{/} s = \langle 7, 4, 2, 5 \rangle$.

Hay unas operaciones (funciones) muy útiles sobre secuencias, que se definen recursivamente por casos, sobre la forma como se construyen secuencias:

| Operación (función) $f$ | Caso $f(\varepsilon)$ | Caso $f(x \mathbin{/} s)$ | Tipo |
|---|---|---|---|
| $\mathrm{head}: \mathrm{Seq}[A] \to A$ | — | $x$ | Parcial |
| $\mathrm{tail}: \mathrm{Seq}[A] \to \mathrm{Seq}[A]$ | — | $s$ | Parcial |
| $\mathrm{size}: \mathrm{Seq}[A] \to \mathbb{N}$ | $0$ | $1 + \mathrm{size}(s)$ | Total |
| $\mathrm{last}: \mathrm{Seq}[A] \to A$ | — | $x$ si $s = \varepsilon$; $\mathrm{last}(s)$ si no | Parcial |
| $\mathrm{dlast}: \mathrm{Seq}[A] \to \mathrm{Seq}[A]$ | — | $\varepsilon$ si $s = \varepsilon$; $x \mathbin{/} \mathrm{dlast}(s)$ si no | Parcial |
| $\oplus: \mathrm{Seq}[A] \times \mathrm{Seq}[A] \to \mathrm{Seq}[A]$ | $\varepsilon \oplus t = t$ | $(x \mathbin{/} s) \oplus t = x \mathbin{/} (s \oplus t)$ | Total |
| $\mathrm{rev}: \mathrm{Seq}[A] \to \mathrm{Seq}[A]$ | $\varepsilon$ | $\mathrm{rev}(s) \oplus x \mathbin{/} \varepsilon$ | Total |

> **Nota:** `head`, `tail`, `last` y `dlast` son *parciales* porque no están definidas sobre $\varepsilon$ (no hay primer ni último elemento de la secuencia vacía) — igual que `head`/`tail` fallan sobre `Nil` en Scala. `size`, $\oplus$ y `rev` sí cubren ambos casos y por eso son *totales*.

Calcule (con $s = \langle 4, 2, 5\rangle$):

$$
\mathrm{tail}(s) = \langle 2,5 \rangle \qquad \mathrm{size}(s) = 3
$$
$$
\mathrm{last}(s) = 5 \qquad \mathrm{dlast}(s) = \langle 4,2 \rangle
$$
$$
\mathrm{rev}(s) = \langle 5,2,4 \rangle \qquad s \oplus \langle 3,1 \rangle = \langle 4,2,5,3,1 \rangle
$$

### Propiedades de las secuencias

Dados $s, t \in \mathrm{Seq}[A]$, se dice que $s = t$ si se da uno de los dos casos siguientes:
- $s = t = \varepsilon$
- $s = x \mathbin{/} s_1 \land t = y \mathbin{/} t_1 \land x = y \land s_1 = t_1$

Los siguientes son teoremas sobre las secuencias:

- $\mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$
- $s \oplus \varepsilon = s$
- $\mathrm{rev}(\mathrm{rev}(s)) = s$
- $\mathrm{rev}(s \oplus t) = \mathrm{rev}(t) \oplus \mathrm{rev}(s)$

Se dice que una secuencia $s$ es **palíndrome** si se lee igual de izquierda a derecha que de derecha a izquierda, es decir: $\mathrm{pal}(s) \equiv (s = \mathrm{rev}(s))$.

Se puede demostrar que: $\mathrm{pal}(s \oplus \mathrm{rev}(s)) \equiv \mathit{true}$.

¡Queda pendiente demostrarlos! Dos de ellos ($s \oplus \varepsilon = s$ y $\mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$) se demuestran más abajo, en la sección de inducción estructural. Los otros dos quedan como ejercicio:

:::{admonition} 💡 Ver pistas
:class: dropdown

- **$\mathrm{rev}(\mathrm{rev}(s)) = s$:** inducción estructural sobre $s$. El caso base ($s=\varepsilon$) es trivial. En el caso recursivo ($s = a \mathbin{/} s'$) hay que expandir $\mathrm{rev}(a \mathbin{/} s') = \mathrm{rev}(s') \oplus a \mathbin{/} \varepsilon$, aplicar $\mathrm{rev}$ de nuevo, usar la hipótesis inductiva $\mathrm{rev}(\mathrm{rev}(s'))=s'$, y la propiedad $s \oplus \varepsilon = s$ ya demostrada.
- **$\mathrm{rev}(s \oplus t) = \mathrm{rev}(t) \oplus \mathrm{rev}(s)$:** inducción estructural sobre $s$. Caso base ($s=\varepsilon$): usa $\varepsilon \oplus t = t$ y $\mathrm{rev}(t) \oplus \mathrm{rev}(\varepsilon) = \mathrm{rev}(t) \oplus \varepsilon = \mathrm{rev}(t)$ (con la propiedad $s\oplus\varepsilon=s$). Caso recursivo: usa la definición de $\oplus$ y $\mathrm{rev}$, la hipótesis inductiva, y la asociatividad de $\oplus$.
- **$\mathrm{pal}(s \oplus \mathrm{rev}(s)) \equiv \mathit{true}$:** aplique la propiedad anterior con $t = \mathrm{rev}(s)$: $\mathrm{rev}(s \oplus \mathrm{rev}(s)) = \mathrm{rev}(\mathrm{rev}(s)) \oplus \mathrm{rev}(s) = s \oplus \mathrm{rev}(s)$ (usando $\mathrm{rev}(\mathrm{rev}(s))=s$), que es justamente la definición de que $s \oplus \mathrm{rev}(s)$ es palíndrome.
:::

***

## Inducción estructural

### El principio de inducción estructural

Sea $A$ un conjunto definido recursivamente. En general, supongamos que queremos probar

$$
\forall a \mid a \in A : P(a)
$$

donde $P(a)$ es un predicado sobre $A$. Usaremos el principio de inducción estructural de la siguiente manera:

- Establecer clara y formalmente $P(a)$.
- **[Caso base]** Demostrar $P(a)$, para todo $a \in A$ definido por una regla básica, usando las técnicas de demostración conocidas.
- **[Caso de inducción]** Demostrar $P(b)$ para todo $b \in A$ construido con una regla recursiva, suponiendo que todos los elementos $a \in A$ usados en la construcción de $b$ cumplen $P$. Formalmente podemos escribirlo así: $(\forall a \preceq b : P(a)) \vdash P(b)$, donde $a \preceq b$ significa que $a$ se usa para construir $b$.

$\forall a \preceq b : P(a)$ es la Hipótesis de inducción. Se concluirá $\forall a \mid a \in A : P(a)$ por inducción estructural.

> **Nota de notación:** $\vdash$ se lee "permite concluir" o "implica" — $X \vdash Y$ dice que a partir de $X$ (la hipótesis inductiva) se puede demostrar $Y$ (lo que falta probar). $a \preceq b$ es simplemente una forma compacta de decir "$a$ es una de las piezas con las que se construyó $b$" — por ejemplo, si $b = x+y$ fue construido con la regla recursiva del conjunto $A$, entonces $x \preceq b$ y $y \preceq b$.

### Ejemplo

Sea $A$ el conjunto definido así:

- $3 \in A$
- $x \in A \land y \in A \implies (x+y) \in A$

Demostrar que $\forall a \in A : 3 \mid a$

Lo probaremos usando el principio de inducción estructural: $P(a) \equiv 3 \mid a$

**[Caso base]** Demostrar $P(3)$

$$
P(3) \equiv 3 \mid 3 \equiv \mathit{true}
$$

**[Caso de inducción]** Demostrar $P(x), P(y) \vdash P(x+y)$

- Teo $(P(x+y))$: $3 \mid (x+y)$
- Hip. Ind. $(P(x), P(y))$: HI $: 3 \mid x \land 3 \mid y$

$$
\begin{aligned}
3 \mid x \land 3 \mid y &&\text{HI}\\
\implies 3 \mid (x+y) &&\text{Teo. de divisibilidad}
\end{aligned}
$$

$\square$ Por tanto, $\forall a \in A : 3 \mid a$

> **Nota:** esta es la misma propiedad de "todo elemento de $A$ es múltiplo de 3" que se dejó pendiente en la sección de definiciones recursivas de conjuntos — aquí ya queda formalmente demostrada.

### Teoremas sobre secuencias

Recordemos: el conjunto $\mathrm{Seq}[A]$ se define recursivamente así: $\varepsilon \in \mathrm{Seq}[A]$; si $a \in A$ y $s \in \mathrm{Seq}[A]$, entonces $t = a \mathbin{/} s \in \mathrm{Seq}[A]$. Y las operaciones $\mathrm{size}$ y $\oplus$ se definen así:

$$
\mathrm{size}(t) = \begin{cases} 0 & t = \varepsilon \\ 1 + \mathrm{size}(s) & t = a \mathbin{/} s \end{cases}
\qquad
s \oplus t = \begin{cases} t & s = \varepsilon \\ a \mathbin{/} (u \oplus t) & s = a \mathbin{/} u \end{cases}
$$

Vamos a probar las siguientes propiedades:

- $\forall s \in \mathrm{Seq}[A] : s \oplus \varepsilon = s$
- $\forall s, t \in \mathrm{Seq}[A] : \mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$

#### $\forall s \in \mathrm{Seq}[A] : s \oplus \varepsilon = s$

Lo probaremos usando el principio de inducción estructural: $P(s) \equiv s \oplus \varepsilon = s$

**[Caso base]** Demostrar $P(\varepsilon)$

$$
P(\varepsilon) \equiv \varepsilon \oplus \varepsilon = \varepsilon \equiv \varepsilon = \varepsilon \equiv \mathit{true}
$$

**[Caso de inducción]** Demostrar $P(s) \vdash P(a \mathbin{/} s)$

- Teo $(P(a \mathbin{/} s))$: $a \mathbin{/} s \oplus \varepsilon = a \mathbin{/} s$
- Hip. Ind. $(P(s))$: HI $: s \oplus \varepsilon = s$

$$
\begin{aligned}
a \mathbin{/} s \oplus \varepsilon &= a \mathbin{/} (s \oplus \varepsilon) &&\text{Def. } \oplus\\
&= a \mathbin{/} s &&\text{HI}
\end{aligned}
$$

$\square$ Por tanto, $\forall s \in \mathrm{Seq}[A] : s \oplus \varepsilon = s$

#### $\forall s, t \in \mathrm{Seq}[A] : \mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$

Lo probaremos usando el principio de inducción estructural **sobre $s$** (nótese que $t$ queda fijo durante toda la demostración; la inducción sólo recorre la estructura de $s$).

$P(s) \equiv \mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$

**[Caso base]** Demostrar $P(\varepsilon)$

$$
P(\varepsilon) \equiv \mathrm{size}(\varepsilon \oplus t) = \mathrm{size}(\varepsilon) + \mathrm{size}(t) \equiv \mathrm{size}(t) = 0 + \mathrm{size}(t) \equiv \mathrm{size}(t) = \mathrm{size}(t) \equiv \mathit{true}
$$

**[Caso de inducción]** Demostrar $P(s) \vdash P(a \mathbin{/} s)$

- Teo $(P(a \mathbin{/} s))$: $\mathrm{size}(a \mathbin{/} s \oplus t) = \mathrm{size}(a \mathbin{/} s) + \mathrm{size}(t)$
- Hip. Ind. $(P(s))$: HI $: \mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$

$$
\begin{aligned}
\mathrm{size}(a \mathbin{/} s \oplus t) &= \mathrm{size}(a \mathbin{/} (s \oplus t)) &&\text{Def. } \oplus\\
&= 1 + \mathrm{size}(s \oplus t) &&\text{Def. } \mathrm{size}\\
&= 1 + \mathrm{size}(s) + \mathrm{size}(t) &&\text{HI}\\
&= (1 + \mathrm{size}(s)) + \mathrm{size}(t) &&\text{Aritmética}\\
&= \mathrm{size}(a \mathbin{/} s) + \mathrm{size}(t) &&\text{Def. } \mathrm{size}
\end{aligned}
$$

$\square$ Por tanto, $\forall s, t \in \mathrm{Seq}[A] : \mathrm{size}(s \oplus t) = \mathrm{size}(s) + \mathrm{size}(t)$

---

*Material adaptado del curso Matemáticas Discretas I, profesor Juan Francisco Díaz Frías (Universidad del Valle), 2018-I.*
