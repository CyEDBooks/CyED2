---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 1: Relaciones"
---

# Unidad 1 · Sesión 1: Relaciones

## Definición de relación

### Relación binaria

Sean $A$ y $B$ dos conjuntos, una relación de $A$ en $B$ es un subconjunto de $A \times B$.

**Ejemplo.** Sea $A$ el conjunto de todas las ciudades y $B$ el conjunto de los países de Sudamérica. Se define $R$ tal que $(a,b)\in R$ si la ciudad $a$ está en el país $b$.

$$
(\text{Barranquilla},\text{Colombia}),\;
(\text{Rosario},\text{Argentina}),\;
(\text{Sao Paulo},\text{Brasil}),
$$
$$
(\text{Antofagasta},\text{Chile}),\;
(\text{Maracaibo},\text{Venezuela})
$$

pertenecen a $R$.

**Ejemplo.** Sean $A=\{0,1,2\}$ y $B=\{a,b\}$. Entonces

$$
R=\{(0,a),(0,b),(1,a),(2,b)\}
$$

es una relación de $A$ en $B$. Esto significa que $0Ra$ pero $1\not R b$.

Sean $A=\{1,2,3,4\}$, $B=\{-1,-2,-3\}$; se presentan a continuación algunas relaciones:

- $R_1=\{(2,-1),(3,-2),(1,-1)\}$
- $R_2=\{(1,-1),(2,-2),(3,-3)\}$
- $R_3=\{(1,-2),(1,-3),(2,-2),(2,-3),(3,-2),(3,-3)\}$
- $R_4=\{(3,-1)\}$

Cada relación es un subconjunto de:

$$
A \times B =
\{(1,-1),(1,-2),(1,-3),
(2,-1),(2,-2),(2,-3),
(3,-1),(3,-2),(3,-3),
(4,-1),(4,-2),(4,-3)\}
$$

### Relación en $A$

Una relación definida en un conjunto $A$ es una relación de $A$ en $A$.

Sea $A=\{1,2,3,4,5\}$, se presentan algunas relaciones de $A$ en $A$:

- $R_1=\{(4,2),(1,3),(1,5)\}$
- $R_2=\{(1,1),(2,2),(3,3),(4,4),(5,5)\}$
- $R_3=\{(1,1),(3,1),(4,1),(4,2),(4,3)\}$
- $R_4=\{(2,1),(3,2),(4,3)\}$

**Actividad.** Sea $A=\{1,2,3,4\}$ muestre las siguientes relaciones:

- $R_1=\{(a,b)\mid a<b\}$
- $R_2=\{(a,b)\mid a=b\}$
- $R_3=\{(a,b)\mid a=b+1\}$
- $R_4=\{(a,b)\mid a \text{ divide } b\}$
- $R_5=\{(a,b)\mid a+b \leq 3\}$

**Actividad.** Sea $A=\{1,2,3,4\}$ muestre las siguientes relaciones:

- $R_1=\{(1,2),(1,3),(1,4),(2,3),(2,4),(3,4)\}$
- $R_2=\{(1,1),(2,2),(3,3),(4,4)\}$
- $R_3=\{(2,1),(3,2),(4,3)\}$
- $R_4=\{(1,1),(1,2),(1,3),(1,4),(2,2),(2,4),(3,3),(4,4)\}$
- $R_5=\{(1,1),(1,2),(2,1)\}$

**Actividad.** Sea $A=\{-2,-1,1,2,3,4\}$ muestre las siguientes relaciones:

- $R_1=\{(a,b)\mid a>0 \;\wedge\; b<0\}$
- $R_2=\{(a,b)\mid a=-b\}$
- $R_3=\{(a,b)\mid a+b<2\}$

### Relaciones y funciones

Una **función** es una relación $R$ de $A$ en $B$ tal que a cada elemento de $A$ le corresponde un único elemento de $B$. Es decir, a cada $a \in A$ le asignamos un único $b \in B$ tal que $f(a)=b$ y $(a,b)\in R$.

En una relación se puede dar que un elemento de $A$ esté relacionado con más de un elemento de $B$. Las relaciones son una generalización de las funciones y pueden emplearse para expresar una clase mucho más amplia de relaciones entre conjuntos.

## Propiedades de relaciones

Las relaciones se clasifican de acuerdo con cuatro propiedades: reflexiva, simétrica, antisimétrica y transitiva.

### Reflexiva

Una relación $R$ sobre un conjunto $A$ se llama reflexiva si $(a,a)\in R$ para cada elemento $a\in A$.

Sea $A=\mathbb{Z}^+$, indique si las relaciones son reflexivas:

- $R_1=\{(a,b)\mid a \text{ divide } b\}$: **sí**, ya que $a\mid a$.
- $R_2=\{(a,b)\mid a \leq b\}$: **sí**, ya que $a\leq a$.
- $R_3=\{(a,b)\mid a > b\}$: **no**, ya que no se cumple $a>a$.

### Simétrica

Una relación $R$ sobre un conjunto $A$ se llama simétrica si cuando $(a,b)\in R$ entonces $(b,a)\in R$.

Sea $A=\mathbb{Z}^+$, indique si las relaciones son simétricas:

- $R_1=\{(a,b)\mid a \text{ divide } b\}$: **no**, $1\mid 3$ pero $3\nmid 1$.
- $R_2=\{(a,b)\mid a\leq b\}$: **no**, $2 \leq 3$ pero no se cumple que $3 \leq 2$.
- $R_3=\{(a,b)\mid a>b\}$: **no**, $6>1$ pero no se cumple que $1>6$.

### Antisimétrica

Una relación $R$ sobre un conjunto $A$ se llama antisimétrica si cuando $(a,b)\in R$ entonces $(b,a)\notin R$. No se consideran los casos $(a,a)$.

Sea $A=\mathbb{Z}^+$, indique si las relaciones son antisimétricas:

- $R_1=\{(a,b)\mid a \text{ divide } b\}$: **sí**.
- $R_2=\{(a,b)\mid a \leq b\}$: **sí**.
- $R_3=\{(a,b)\mid a>b\}$: **sí**.

### Transitiva

Una relación $R$ sobre un conjunto $A$ se llama transitiva si cuando $(a,b)\in R$ y $(b,c)\in R$ entonces $(a,c)\in R$.

Sea $A=\{1,2,3,4\}$ y las siguientes relaciones, complete la tabla de propiedades:

- $R_1=\{(2,2),(2,3),(2,4),(3,2),(3,3),(3,4)\}$
- $R_2=\{(1,1),(1,2),(2,1),(2,2),(3,3),(4,4)\}$
- $R_3=\{(2,4),(4,2)\}$

|       | Reflexiva | Simétrica | Antisimétrica | Transitiva |
|-------|-----------|-----------|----------------|------------|
| $R_1$ | NO        | NO        | NO             | SI         |
| $R_2$ | SI        | SI        | NO             | SI         |
| $R_3$ | NO        | SI        | NO             | NO         |

Sea $A=\{1,2,3,4\}$ y las siguientes relaciones, complete la tabla de propiedades:

- $R_4=\{(1,2),(2,3),(3,4)\}$
- $R_5=\{(1,1),(2,2),(3,3),(4,4)\}$
- $R_6=\{(1,3),(1,4),(2,3),(2,4),(3,1),(3,4)\}$

|       | Reflexiva | Simétrica | Antisimétrica | Transitiva |
|-------|-----------|-----------|----------------|------------|
| $R_4$ | NO        | NO        | SI             | NO         |
| $R_5$ | SI        | SI        | SI             | SI         |
| $R_6$ | NO        | NO        | NO             | NO         |

Dadas las siguientes relaciones definidas sobre los números enteros, complete la tabla de propiedades:

- $R_1=\{(a,b)\mid a + b =  0\}$
- $R_2=\{(a,b)\mid a \neq b\}$

|       | Reflexiva | Simétrica | Antisimétrica | Transitiva |
|-------|-----------|-----------|----------------|------------|
| $R_1$ | NO        | SI        | NO             | NO         |
| $R_2$ | NO        | SI        | NO             | NO         |

### Combinación de relaciones

Puesto que las relaciones de $A$ en $B$ son subconjuntos de $A \times B$, dos relaciones de $A$ en $B$ se pueden combinar como se combinan dos conjuntos.

**Ejemplo.** Sean $A=\{1,2,3\}$ y $B=\{1,2,3,4\}$.

$$
R_1=\{(1,1),(2,2),(3,3)\}
\qquad
R_2=\{(1,1),(1,2),(1,3),(1,4)\}
$$

Calcule $R_1 \cup R_2$, $R_1 \cap R_2$, $R_1 - R_2$ y $R_2 - R_1$.

:::{admonition} Solución
:class: dropdown
$$
\begin{aligned}
R_1 \cup R_2 &= \{(1,1),(1,2),(1,3),(1,4),(2,2),(3,3)\} \\
R_1 \cap R_2 &= \{(1,1)\} \\
R_1 - R_2 &= \{(2,2),(3,3)\} \\
R_2 - R_1 &= \{(1,2),(1,3),(1,4)\}
\end{aligned}
$$
:::

### Composición de relaciones

Sean $R$ una relación de un conjunto $A$ en un conjunto $B$ y $S$ una relación de $B$ en un conjunto $C$. La composición de $R$ y $S$ es la relación que consiste en los pares ordenados $(a,c)$ con $a \in A$ y $c \in C$ para los cuales existe un elemento $b \in B$ tal que $(a,b) \in R$ y $(b,c) \in S$.

La composición de $R$ y $S$ se denota $S \circ R$:

$$
S \circ R = \{(a,c) \mid (a,b)\in R \land (b,c)\in S\}
$$

Determinar la composición de dos relaciones requiere hallar elementos que sean el segundo elemento de algún par ordenado de la primera relación y el primer elemento de algún par ordenado de la segunda relación.

**Ejemplo.** ¿Cuál es la composición de las relaciones $R$ y $S$, donde $R$ es la relación de $\{1,2,3\}$ en $\{1,2,3,4\}$ con $R=\{(1,1),(1,4),(2,3),(3,1),(3,4)\}$ y $S$ es la relación de $\{1,2,3,4\}$ en $\{0,1,2\}$ con $S=\{(1,0),(2,0),(3,1),(3,2),(4,1)\}$?

:::{admonition} Solución
:class: dropdown
$S \circ R$ se construye usando los pares ordenados de $R$ y de $S$ tales que el segundo elemento de $R$ coincide con el primero de $S$. Por ejemplo, $(2,3)\in R$ y $(3,1)\in S$ producen $(2,1)$. Calculando todos los casos:

$$
S \circ R=\{(1,0),(1,1),(2,1),(2,2),(3,0),(3,1)\}.
$$
:::

## Relaciones $n$-arias

Las relaciones entre elementos de más de dos conjuntos son necesarias para representar bases de datos. Mediante relaciones adecuadas se pueden responder consultas sobre la información almacenada en bases de datos.

Sean $A_1, A_2, \dots, A_n$ conjuntos. Una relación $n$-aria en estos conjuntos es un subconjunto de

$$
A_1 \times A_2 \times \dots \times A_n.
$$

Los conjuntos $A_1, A_2, \dots, A_n$ se llaman dominios de la relación y $n$ es su grado.

**Ejemplo.** Sea $R$ la relación en $\mathbb{N} \times \mathbb{N} \times \mathbb{N}$ que consta de las ternas $(a,b,c)$ en las que $a,b,c$ son enteros positivos con $a<b<c$. ¿Pertenecen $(1,2,3)$ y $(2,4,3)$ a $R$? ¿Cuál es el grado de esta relación?

:::{admonition} Solución
:class: dropdown
$(1,2,3)\in R$, pero $(2,4,3)\notin R$. El grado de esta relación es $3$ y sus dominios son todos iguales a $\mathbb{N}$.
:::

### Modelo relacional de datos

Es un modelo para representar bases de datos basado en el concepto de relación.

- Una base de datos consta de *registros*, que son $n$-tuplas formadas a partir de *campos*.
- Los campos son las entradas de la $n$-tupla.
- Las relaciones que se utilizan para representar bases de datos se llaman también tablas.
- Cada columna de la tabla corresponde a un *atributo* de la base de datos.
- Se dice que un dominio de una relación $n$-aria es una **clave primaria** si el valor de la $n$-tupla en dicho dominio caracteriza la $n$-tupla.

**Ejemplo — Tabla Estudiantes**

| Nombre_estudiante | Número_id | Programa    | Promedio |
|--------------------|-----------|-------------|----------|
| Ackermann          | 231455    | Informática | 3,88     |
| Adams              | 888323    | Física      | 3,45     |
| Chou               | 102147    | Informática | 3,49     |
| Goodfriend         | 453876    | Matemáticas | 3,45     |
| Rao                | 678543    | Matemáticas | 3,90     |
| Stevens            | 786576    | Psicología  | 2,99     |

- Los atributos de esta base de datos son: Nombre_estudiante, Número_id, Programa y Promedio.
- Un registro (4-tupla) puede ser: $(\text{Ackermann},231455,\text{Informática},3{,}88)$.
- Un campo del anterior registro puede ser Informática o 231455.

¿Qué dominios son claves primarias para la relación $n$-aria que se muestra en la Tabla Estudiantes, suponiendo que no se va a añadir en el futuro ninguna $n$-tupla?

:::{admonition} Solución
:class: dropdown
- Como hay una sola 4-tupla en la tabla para cada nombre de estudiante, el dominio de nombres de estudiantes es una clave primaria.
- De forma similar, los números ID en esta tabla son únicos, de modo que el dominio de números ID es también una clave primaria.
- El dominio de programa no es una clave primaria, ya que hay más de una 4-tupla que contiene el mismo programa.
- El dominio de promedio tampoco es una clave primaria, porque hay dos 4-tuplas con el mismo promedio.
:::

Las $n$-tuplas de una relación $n$-aria también pueden identificarse de manera unívoca mediante combinaciones de dominios. Cuando una $n$-tupla de una relación viene determinada por los valores de un conjunto de dominios, al producto cartesiano de estos dominios se le llama **clave compuesta**.

### Operador de selección

Sea $R$ una relación $n$-aria y $C$ una condición que puede ser satisfecha por los elementos de $R$. Entonces, el operador de selección $s_C$ transforma la relación $n$-aria $R$ en la relación $n$-aria formada por todas las $n$-tuplas de $R$ que satisfacen la condición $C$.

**Ejemplo.** Para hallar los registros de estudiantes de informática en la relación $n$-aria que se muestra en la Tabla Estudiantes, usamos el operador $s_C$ donde $C$ es la condición Programa = "Informática". ¿Qué 4-tuplas resultan?

:::{admonition} Solución
:class: dropdown
El resultado son las dos 4-tuplas (Ackermann, 231455, Informática, 3,88) y (Chou, 102147, Informática, 3,49).
:::

**Actividad.** Encuentre los registros de estudiantes con un promedio mayor a 3.5 y posteriormente aquellos registros de estudiantes de Informática con un promedio mayor a 3.5.

### Proyecciones

La proyección $P_{i_1,i_2,\ldots,i_m}$ transforma la $n$-tupla $(a_1,a_2,\ldots,a_n)$ en la $m$-tupla $(a_{i_1},a_{i_2},\ldots,a_{i_m})$, donde $m \le n$. En otras palabras, la proyección $P_{i_1,i_2,\ldots,i_m}$ elimina $n-m$ componentes de una $n$-tupla, manteniendo las componentes $i_1$-ésima, $i_2$-ésima, $\ldots$, $i_m$-ésima.

**Ejemplo.** ¿Cuál es el resultado de aplicar la proyección $P_{1,3}$ a las 4-tuplas $(2,3,0,4)$, (Juana López, 234111001, Geografía, 3,14) y $(a_1,a_2,a_3,a_4)$?

:::{admonition} Solución
:class: dropdown
La proyección $P_{1,3}$ transforma estas 4-tuplas en $(2,0)$, (Juana López, Geografía) y $(a_1,a_3)$, respectivamente.
:::

### Operador de Join

Sean $R$ una relación de grado $m$ y $S$ una relación de grado $n$. El join $J_p(R,S)$, con $p \le m$ y $p \le n$, es una relación de grado $m+n-p$ que consta de todas las $(m+n-p)$-tuplas $(a_1,\ldots,a_{m-p},c_1,\ldots,c_p,b_1,\ldots,b_{n-p})$, donde la $m$-tupla $(a_1,\ldots,a_{m-p},c_1,\ldots,c_p)$ pertenece a $R$ y la $n$-tupla $(c_1,\ldots,c_p,b_1,\ldots,b_{n-p})$ pertenece a $S$.

En otras palabras, el operador de join $J$ produce a partir de dos relaciones una nueva relación combinando todas las $m$-tuplas de la primera relación con todas las $n$-tuplas de la segunda relación, donde las $p$ últimas componentes de las $m$-tuplas coinciden con las $p$ primeras componentes de las $n$-tuplas.

**Ejemplo.** ¿Qué relación resulta cuando se usa el operador de join $J_2$ para combinar la relación desplegada en las siguientes tablas?

**TABLA 5** — *Teaching assignments*

| Professor | Department       | Course_number |
|-----------|------------------|---------------|
| Cruz      | Zoology          | 335           |
| Cruz      | Zoology          | 412           |
| Farber    | Psychology       | 501           |
| Farber    | Psychology       | 617           |
| Grammer   | Physics          | 544           |
| Grammer   | Physics          | 551           |
| Rosen     | Computer Science | 518           |
| Rosen     | Mathematics      | 575           |

**TABLA 6** — *Class schedule*

| Department       | Course_number | Room | Time      |
|------------------|---------------|------|-----------|
| Computer Science | 518           | N521 | 2:00 P.M. |
| Mathematics      | 575           | N502 | 3:00 P.M. |
| Mathematics      | 611           | N521 | 4:00 P.M. |
| Physics          | 544           | B505 | 4:00 P.M. |
| Psychology       | 501           | A100 | 3:00 P.M. |
| Psychology       | 617           | A110 | 11:00 A.M.|
| Zoology          | 335           | A100 | 9:00 A.M. |
| Zoology          | 412           | A100 | 8:00 A.M. |

:::{admonition} Solución
:class: dropdown
Note que $p = 2$ y por lo tanto el grado de la relación $J_2(R,S)$ es $5$.

**TABLA 7** — *Teaching schedule*

| Professor | Departament      | Course_number | Room | Time      |
|-----------|------------------|---------------|------|-----------|
| Cruz      | Zoology          | 335           | A100 | 9:00 A.M. |
| Cruz      | Zoology          | 412           | A100 | 8:00 A.M. |
| Farber    | Psychology       | 501           | A100 | 3:00 P.M. |
| Farber    | Psychology       | 617           | A110 | 11:00 A.M.|
| Grammer   | Physics          | 544           | B505 | 4:00 P.M. |
| Rosen     | Computer Science | 518           | N521 | 2:00 P.M. |
| Rosen     | Mathematics      | 575           | N502 | 3:00 P.M. |
:::

---

*Material adaptado del material original de los profesores Angela Villota, Jenifer Viafara, Oscar Bedoya y Juan Francisco Díaz.*
