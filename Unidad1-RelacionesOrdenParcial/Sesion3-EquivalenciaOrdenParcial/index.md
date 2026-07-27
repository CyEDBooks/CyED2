---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 3: Relaciones de equivalencia y conjuntos parcialmente ordenados"
---

# Unidad 1 · Sesión 3: Relaciones de equivalencia y conjuntos parcialmente ordenados

## Clausuras de una relación

Considere la siguiente relación definida sobre $A=\{1,2,3,4\}$:

$$
R=\{(1,1),(1,2),(2,1),(2,2),(2,4),(3,2),(3,4),(4,1),(4,2)\}
$$

¿Qué le falta a la relación para que sea reflexiva? Faltan los pares $(3,3)$ y $(4,4)$. La **clausura reflexiva** de $R$ es:

$$
R' = R \cup \{(3,3),(4,4)\}
$$

La clausura reflexiva de $R$ es la relación $R'$ que contiene todos los pares de $R$ y además aquellos pares que le faltan para que sea reflexiva.

Dada una relación $R$, se tienen tres tipos de clausuras: **clausura reflexiva**, **clausura simétrica** y **clausura transitiva**.

**Clausura simétrica.** Considere $A=\{1,2,3,4\}$ y

$$
R=\{(1,1),(1,2),(2,2),(2,4),(3,2),(4,1),(4,2)\}
$$

Faltan los pares $(2,1)$, $(2,3)$ y $(1,4)$ para que sea simétrica. La clausura simétrica de $R$ es la relación

$$
R' = R \cup \{(2,1),(2,3),(1,4)\}
$$

**Clausura transitiva.** Considere $A=\{1,2,3,4\}$ y

$$
R=\{(1,1),(1,2),(2,2),(2,4),(3,2)\}
$$

Faltan los pares $(1,4)$ y $(3,4)$ para que sea transitiva. La clausura transitiva de $R$ es la relación

$$
R' = R \cup \{(1,4),(3,4)\}
$$

**Actividad.** Considere $A=\{1,2,3,4\}$ y $R=\{(1,1),(1,4),(2,2),(2,4),(3,1),(3,3)\}$. Muestre las clausuras reflexiva, simétrica y transitiva.

- Clausura reflexiva: $R_r = R \cup \{(4,4)\}$
- Clausura simétrica: $R_s = R \cup \{(4,1),(4,2),(1,3)\}$
- Clausura transitiva: $R_t = R \cup \{(3,4)\}$

**Actividad.** Considere $A=\{1,2,3,4\}$ y

$$
R=\{(1,1),(1,2),(1,3),(1,4),(2,3),(3,1),(3,3),(4,1),(4,3),(4,4)\}
$$

Muestre las clausuras reflexiva, simétrica y transitiva.

- Clausura reflexiva: $R_r = R \cup \{(2,2)\}$
- Clausura simétrica: $R_s = R \cup \{(2,1),(3,2),(3,4)\}$
- Clausura transitiva: $R_t = R \cup \{(2,1),(3,2),(3,4),(4,2)\}$

Existen dos tipos de relaciones especiales que construiremos a partir de las propiedades anteriores: la **relación de equivalencia** y la **relación de orden parcial**.

## Relaciones de equivalencia

Una relación $R$ en un conjunto $A$ es una **relación de equivalencia** si es reflexiva, simétrica y transitiva.

Indique cuáles de las siguientes relaciones definidas en $A=\{1,2,3,4\}$ son relaciones de equivalencia:

- $R_1=\{(1,1),(2,2),(3,3),(4,4)\}$ — **sí**.
- $R_2=\{(1,1),(1,3),(3,1),(3,3),(3,4),(4,3),(4,4)\}$ — **no** es reflexiva ni transitiva.
- $R_3=\{(1,1),(2,2),(2,3),(3,2),(3,3),(4,4)\}$ — **sí**.

**Ejemplo.** Suponga que en una universidad la matrícula académica se hace por bloques para cada programa, de forma tal que los estudiantes se matriculan en franjas de una hora dependiendo del semestre que cursen. La relación $R$ está dada por $x\,R\,y$ si, y sólo si, $x$ y $y$ son estudiantes del mismo programa en el mismo semestre académico.

- ¿Es $R$ reflexiva? Como $x$ es un estudiante de un programa en un semestre dado, entonces $x\,R\,x$ y $R$ es reflexiva.
- ¿Es $R$ simétrica? Suponemos $x\,R\,y$, entonces $x$ y $y$ son estudiantes del mismo programa en el mismo semestre. Por tanto $y\,R\,x$ y $R$ es simétrica.
- ¿Es $R$ transitiva? Suponemos que $x\,R\,y$ y $y\,R\,w$, entonces $x$, $y$ y $w$ son estudiantes del mismo programa en el mismo semestre. Por tanto $x\,R\,w$ y $R$ es transitiva.

Indique cuáles de las siguientes relaciones definidas en $A=\{1,2,3,4\}$ son relaciones de equivalencia:

- $R_4=\{(1,1),(2,2),(2,4),(3,3),(3,4),(4,2),(4,3),(4,4)\}$: no es **transitiva**.
- $R_5=\{(1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,1),(3,3),(4,4)\}$: no es **simétrica** ni **transitiva**.

## Clases de equivalencia, particiones y conjunto cociente

Si dos elementos $x,y$ están relacionados por medio de una relación de equivalencia, se dice que $x$ y $y$ son equivalentes.

Sea $R$ una relación de equivalencia en un conjunto $A$. El conjunto de todos los elementos que están relacionados con un elemento $a \in A$ se denomina **clase de equivalencia** de $a$, denotada por $[a]_R$:

$$
[a]_R=\{\, b \mid aRb \,\}.
$$

Si $b \in [a]_R$, decimos que $b$ es un **representante** de $[a]_R$.

**Actividad.** Sea $C$ el conjunto de las personas del Grupo 3 de Computación y Estructuras Discretas II. Definimos la relación $R$ en $C$ así: dos personas $a,b \in C$ están relacionadas ($aRb$) si nacieron el mismo año.

- Muestre que $R$ es una relación de equivalencia.
- Halle al menos un representante de cada clase de equivalencia en $C$.

Criterios: ¿se aplicó correctamente cada definición?, ¿se argumentó claramente según el enunciado?, ¿se identificaron correctamente las clases?

Si $aRb$ y $R$ es de equivalencia, se dice que $a$ es equivalente a $b$ y se escribe $a \sim b$.

**Actividad.** ¿Cuáles de las siguientes relaciones son de equivalencia? Halle además sus clases de equivalencia $[2]$ y $[3]$.

- $R_1:\ \mathbb{Z}\times\mathbb{Z}$ tal que $R_1(a,b) \equiv (a-b)$ es par.
- $R_2:\ \mathbb{Z}\times\mathbb{Z}$ tal que $R_2(a,b) \equiv a=b \ \vee \ a=-b$.

Dado un conjunto $A$, una **partición de $A$** es un conjunto de subconjuntos de $A$ sin elementos en común entre ellos y cuya unión es todo $A$. Es decir, $\mathcal{P}=\{A_1,A_2,\dots,A_m\}$ es una partición de $A$ si:

- $A_i \neq \varnothing$ para $i=1,\dots,m$.
- $A_i \cap A_j = \varnothing$ para $i \neq j$.
- $\displaystyle \bigcup_{i=1}^{m} A_i = A$.

Sea $R: A \leftrightarrow A$ una relación de equivalencia. Las clases de equivalencia de $R$ forman una partición de $A$.

**Pregunta.** ¿Cuáles son las clases de equivalencia de $R_1$? ¿Forman una partición de $\mathbb{Z}$?

:::{image} images/rosen.png
:alt: Representación gráfica de particiones de un conjunto
:width: 60%
:::

*Representación gráfica de particiones de un conjunto, tomado del libro Rosen, página 613 (Kenneth H. Rosen, Discrete Mathematics and Its Applications, 7th Edition, McGraw-Hill, 2012).*

**Ejemplo.** Sea $R : \mathbb{Z} \leftrightarrow \mathbb{Z}$ definida por $nRm \equiv 4 \mid (n-m)$.

**1. Probar que $R$ es una relación de equivalencia.**

- ¿$R$ es reflexiva? $nRn \equiv 4 \mid (n-n) \equiv 4 \mid 0 \equiv \text{true}$.
- ¿$R$ es simétrica? $nRm \equiv 4 \mid (n-m) \equiv 4 \mid -(n-m) = 4 \mid (m-n) \equiv mRn$.
- ¿$R$ es transitiva? $nRm \land mRp \equiv 4 \mid (n-m) \land 4 \mid (m-p) \Rightarrow 4 \mid \big((n-m)+(m-p)\big) = 4 \mid (n-p) \equiv nRp$.

**2. Determinar las clases de equivalencia.**

$$
[0]=\{\dots,-8,-4,0,4,8,\dots\}
\qquad
[1]=\{\dots,-7,-3,1,5,9,\dots\}
$$

$$
[2]=\{\dots,-6,-2,2,6,10,\dots\}
\qquad
[3]=\{\dots,-5,-1,3,7,11,\dots\}
$$

¿Forman una partición de $\mathbb{Z}$?

## Aritmética modular

Se basa en la operación residuo o módulo, definida a continuación:

$$
a \bmod b \text{ es el residuo de } a \div b, \qquad 0 \leq a \bmod b < b
$$

**Actividad.** Calcule los siguientes módulos:

$$
17 \bmod 5 = 2 \qquad 9 \bmod 4 = 1 \qquad -7 \bmod 3 = 2 \qquad 2 \bmod 2 = 0 \qquad -5 \bmod 2 = 1
$$

$$
-21 \bmod 9 = 6 \qquad 4 \bmod 2 = 0 \qquad 2 \bmod 4 = 2 \qquad -12 \bmod 5 = 3
$$

$$
-34 \bmod 4 = 2 \qquad 7 \bmod 9 = 7 \qquad 73 \bmod 8 = 1 \qquad -24 \bmod 7 = 4
$$

Calcule y compare los siguientes pares de valores:

$$
7 \bmod 5 = 2,\; 2 \bmod 5 = 2
\qquad
4 \bmod 3 = 1,\; 13 \bmod 3 = 1
$$

$$
11 \bmod 5 = 1,\; 21 \bmod 5 = 1
\qquad
22 \bmod 4 = 2,\; 38 \bmod 4 = 2
$$

Se dice que $a$ es **congruente con $b$ módulo $m$**, escrito $a \equiv b \pmod{m}$, si y solo si

$$
a \bmod m = b \bmod m.
$$

Para los casos anteriores se tiene que: $7 \equiv 2 \pmod{5}$, $4 \equiv 13 \pmod{3}$, $11 \equiv 21 \pmod{5}$, $22 \equiv 38 \pmod{4}$.

**Actividad.** Indique cuáles de las siguientes afirmaciones son ciertas:

- $2 \equiv 20 \pmod{6}$: **sí**, $2 \bmod 6 = 2$, $20 \bmod 6 = 2$.
- $5 \equiv 16 \pmod{3}$: **no**, $5 \bmod 3 = 2$ y $16 \bmod 3 = 1$.
- $-7 \equiv -19 \pmod{4}$: **sí**, $-7 \bmod 4 = 1$, $-19 \bmod 4 = 1$.
- $3 \equiv 38 \pmod{7}$: **sí**, $3 \bmod 7 = 3$, $38 \bmod 7 = 3$.
- $-5 \equiv 5 \pmod{5}$: **sí**, $-5 \bmod 5 = 0$, $5 \bmod 5 = 0$.

**Propiedad.** $a \equiv b \pmod{m}$ si y solo si $m \mid (a-b)$.

### Clases de congruencia módulo $m$

En general, ¿cuál es la clase $[x]_R$ si $R$ es la relación $\bmod\,m$? ¿Cómo se denominan estas clases?

Si tenemos que $x \equiv y \bmod m$ entonces $x - y$ es divisible por $m$, lo cual nos indica que $x - y = km$, donde $k$ es un entero, luego $y = x - km$. Como $k$ es cualquier entero, entonces:

$$
[x]_R = \{\ldots, x - 2m, x - m, x + m, x + 2m, \ldots \}
$$

Estas clases se denominan **clases de congruencia módulo $m$**.

## Particiones y clases de equivalencia

**Teorema.** Sea $R$ una relación de equivalencia en el conjunto $A$. Las siguientes afirmaciones son equivalentes:

1. $aRb$
2. $[a] = [b]$
3. $[a] \cap [b] \neq \emptyset$

**Probemos que 3 implica 1.** Supongamos que $[a] \cap [b] \neq \emptyset$, entonces existe $c$ tal que $c \in [a]$ y $c \in [b]$. Esto es $aRc$ y $bRc$, por simetría $cRb$, de donde finalmente por transitividad $aRb$.

Consideraciones respecto a las clases de equivalencia:

1. Una relación de equivalencia particiona (divide) a un conjunto $A$.
2. La unión de las clases de equivalencia es $A$, es decir, $\bigcup_{a \in A} [a]_R = A$.
3. No existen clases que tengan elementos en común.

Una relación de equivalencia sobre $A$ determina una partición sobre $A$, es decir, consiste de conjuntos disjuntos cuya unión es $A$. Al conjunto que contiene las clases de equivalencia lo denominamos **conjunto cociente**:

$$
A/R = \{[x]_R : x \in A\}.
$$

**Teorema.** Sea $R$ una relación de equivalencia sobre un conjunto $A$. Entonces las clases de equivalencia de $R$ determinan una partición de $A$. Recíprocamente, dada una partición del conjunto $A$ como $\{A_i \mid i \in I\}$, hay una relación de equivalencia cuyas clases son los conjuntos $A_i$.

**Ejemplo.**

1. Sea $R$ una relación de equivalencia sobre el conjunto $A=\{1,2,3,4,5,6\}$ tal que

   $$
   R=\{(1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(4,4),(4,5),(5,4),(5,5),(6,6)\}.
   $$

   Halle la partición de $R$.

2. Encuentre la relación de equivalencia $R$ producida por la partición $A_1=\{1,3,4\}$, $A_2=\{2,6\}$ y $A_3=\{5,7\}$.

3. ¿Cuáles son las clases de equivalencia de la congruencia módulo $3$?

**Solución.**

1. La colección de conjuntos $A_1=\{1,2,3\}$, $A_2=\{4,5\}$, $A_3=\{6\}$ forma la partición de $A$. Estos conjuntos son disjuntos y su unión forma $A$.
2. $R=\{(1,1),(1,3),(1,4),(2,2),(2,6),(3,1),(3,3),(3,4),(4,1),(4,3),(4,4),(5,5),(5,7),(6,2),(6,6),(7,5),(7,7)\}$.
3. $[0]_3=\{\dots,-3,0,3,\dots\}$, $[1]_3=\{\dots,-2,1,4,\dots\}$, $[2]_3=\{\dots,-1,2,5,\dots\}$.

### Clases de equivalencia módulo 3, paso a paso

**Problema:** ¿Cuáles son las clases de equivalencia de la congruencia módulo 3?

**Paso 1: ¿Qué significa congruencia módulo 3?**

$$
a \equiv b \pmod{3}
\quad \Longleftrightarrow \quad
3 \mid (a-b)
$$

Es decir, $a$ y $b$ dejan el mismo residuo al dividir entre 3.

**Paso 2: ¿Qué residuos son posibles al dividir entre 3?** $0,\; 1,\; 2$. Por lo tanto, existirán exactamente **3 clases de equivalencia**.

**Paso 3: Construimos las clases.**

$$
[0] = \{\dots,-6,-3,0,3,6,9,\dots\}
\qquad
[1] = \{\dots,-5,-2,1,4,7,10,\dots\}
\qquad
[2] = \{\dots,-4,-1,2,5,8,11,\dots\}
$$

**Conclusión:** Las clases de equivalencia módulo 3 son $\mathbb{Z}/3\mathbb{Z} = \{[0],[1],[2]\}$. Los enteros quedan particionados en 3 conjuntos según su residuo.

## Relaciones de orden parcial

Una relación $R$ en un conjunto $A$ es una **relación de orden parcial** si es reflexiva, antisimétrica y transitiva.

Indique cuáles de las siguientes relaciones definidas en $A=\{1,2,3,4\}$ son relaciones de orden parcial:

- $R_1=\{(1,1),(2,2),(3,3),(4,4)\}$: **sí**.
- $R_2=\{(1,1),(1,3),(1,4),(2,2),(3,3),(3,4),(4,4)\}$: **sí**.
- $R_3=\{(1,1),(2,2),(2,3),(2,4),(3,2),(3,3),(4,4)\}$: **no**, porque no es antisimétrica ($(2,3)\in R$ y $(3,2)\in R$).
- $R_4=\{(1,1),(2,2),(2,4),(3,3),(4,2),(4,4)\}$: no es antisimétrica.
- $R_5=\{(1,1),(1,2),(1,3),(2,2),(2,3),(3,3),(3,4),(4,4)\}$: no es transitiva, ya que $(1,3)\in R_5$ y $(3,4)\in R_5$ pero $(1,4)\notin R_5$.

### Conjuntos parcialmente ordenados

Se dice que una relación $R$ en un conjunto $S$ es un **orden parcial** si es reflexiva, antisimétrica y transitiva. Se llama **conjunto parcialmente ordenado** a cualquier conjunto $S$ con un orden parcial $R$, y se denota por $(S,R)$.

**Ejemplo.** Demuestre que la relación "mayor o igual que" ($\geq$) es un orden parcial en el conjunto de los enteros.

**Solución.** Como $a \geq a$ para cada entero $a$, $\geq$ es reflexiva. Si $a \geq b$ y $b \geq a$, entonces $a = b$; por tanto, $\geq$ es antisimétrica. Finalmente, $\geq$ es transitiva, ya que $a \geq b$ y $b \geq c$ implican que $a \geq c$. Se sigue que $\geq$ es un orden parcial en el conjunto de los enteros y $(\mathbb{Z},\geq)$ es un conjunto parcialmente ordenado.

En un conjunto parcialmente ordenado, la notación $a \preceq b$ denota que $(a,b)\in R$. Se usa esta notación porque la relación "menor o igual que" es un paradigma para los órdenes parciales. La notación $a \prec b$ quiere decir que $a \preceq b$, pero $a \neq b$. También se dice que "$a$ es menor que $b$" o que "$b$ es mayor que $a$" si $a \prec b$.

Se dice que los elementos $a$ y $b$ de un conjunto parcialmente ordenado $(S,\preceq)$ son **comparables** si se tiene que bien $a \preceq b$ o bien $b \preceq a$. Cuando $a$ y $b$ son elementos de $S$ tales que ni $a \preceq b$ ni $b \preceq a$ se dice que $a$ y $b$ son **no comparables**.

**Ejemplo.** En el conjunto parcialmente ordenado $(\mathbb{Z}^+, \mid)$, ¿son comparables los números enteros $3$ y $9$? ¿Son comparables $5$ y $7$?

**Solución.** Los enteros $3$ y $9$ son comparables, ya que $3 \mid 9$. Los enteros $5$ y $7$ son no comparables, ya que $5 \nmid 7$ y $7 \nmid 5$.

### Conjuntos totalmente ordenados

Si $(S,\preceq)$ es un conjunto parcialmente ordenado y cada dos elementos de $S$ son comparables, se dice que $S$ es un **conjunto totalmente ordenado** o **linealmente ordenado**. En tal caso, se dice que $\preceq$ es un orden total u orden lineal. A un conjunto totalmente ordenado también se le llama **cadena**.

**Ejemplo.** El conjunto parcialmente ordenado $(\mathbb{Z},\leq)$ está totalmente ordenado, ya que $a \leq b$ o $b \leq a$ para todo par de números enteros $a$ y $b$.

### Conjuntos bien ordenados

$(S,\preceq)$ es un **conjunto bien ordenado** si $\preceq$ es un orden total y cualquier subconjunto no vacío de $S$ tiene un elemento mínimo.

**Ejemplo.** El conjunto de pares ordenados de enteros positivos $\mathbb{Z}^+ \times \mathbb{Z}^+$, con $(a_1,a_2) \preceq (b_1,b_2)$ si $a_1 < b_1$ o si $a_1 = b_1$ y $a_2 \leq b_2$ (el orden lexicográfico), es un conjunto bien ordenado.

### Principio del buen ordenamiento

**Teorema.** Supongamos que $S$ es un conjunto bien ordenado. Entonces $P(x)$ es verdadera para todo $x \in S$ si:

- **Paso base:** $P(x_0)$ es verdadera para el elemento mínimo $x_0$ de $S$, y
- **Paso de inducción:** Para cada $y \in S$ se tiene que si $P(x)$ es verdadera para todo $x \prec y$, entonces $P(y)$ es verdadera.

### Orden lexicográfico

Las palabras de un diccionario aparecen en orden alfabético, o lexicográfico. Este orden se basa en el orden de las letras en el alfabeto y no es más que un caso particular de una ordenación de las cadenas de un conjunto construida a partir de un orden parcial definido sobre el conjunto.

Sean $(A_1,\preceq_1)$ y $(A_2,\preceq_2)$ dos conjuntos parcialmente ordenados, el orden lexicográfico $\preceq$ en $A_1 \times A_2$ se define de la siguiente forma: $(a_1,a_2)$ es menor que $(b_1,b_2)$, esto es,

$$
(a_1,a_2) \prec (b_1,b_2),
$$

si bien $a_1 \prec_1 b_1$ o bien $a_1 = b_1$ y $a_2 \prec_2 b_2$. Obtenemos un orden parcial añadiendo la igualdad al orden $\prec$ en $A_1 \times A_2$.

**Ejemplo.** Determine si es cierto o no que $(3,5) \prec (4,8)$, que $(3,8) \prec (4,5)$ y que $(4,9) \prec (4,11)$ en el conjunto parcialmente ordenado $(\mathbb{Z}\times\mathbb{Z},\preceq)$, donde $\preceq$ es el orden lexicográfico construido a partir de la relación usual $\leq$ en $\mathbb{Z}$.

**Solución.** Como $3 < 4$, se sigue que $(3,5) \prec (4,8)$ y que $(3,8) \prec (4,5)$. Se tiene que $(4,9) \prec (4,11)$, ya que las primeras componentes de $(4,9)$ y $(4,11)$ son iguales, pero $9 < 11$.

En la siguiente figura aparecen en azul los pares de $(\mathbb{Z}^+ \times \mathbb{Z}^+,\preceq)$ que son menores que $(3,4)$.

:::{image} images/rosen2.png
:alt: Pares menores que (3,4) en el orden lexicográfico
:width: 45%
:::

*Tomado de Kenneth H. Rosen, Discrete Mathematics and Its Applications, Capítulo 9.4 (Partial Ordering), p. 621.*

### Diagramas de Hasse

Es el diagrama que representa un orden parcial. Este diagrama se llama **diagrama de Hasse** en honor del matemático alemán del siglo XX Helmut Hasse.

En general, se puede representar un orden parcial en un conjunto finito utilizando el siguiente procedimiento:

- Se comienza con el grafo dirigido de dicha relación.
- Puesto que un orden parcial es reflexivo, hay un bucle en cada vértice. Esos bucles se eliminan.
- Se eliminan todas las aristas que tienen que estar presentes debido a la transitividad, ya que todo orden parcial es transitivo.
- Se dispone cada arista de manera que su vértice inicial quede por debajo de su vértice final.
- Finalmente, se eliminan todas las flechas de las aristas dirigidas.

---

*Material adaptado del material original de los profesores Angela Villota, Jenifer Viafara, Oscar Bedoya y Juan Francisco Díaz.*
