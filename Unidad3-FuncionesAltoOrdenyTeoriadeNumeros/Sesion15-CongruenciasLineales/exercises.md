---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 3 · Sesión 15: Ejercicios"
---

# Unidad 3 · Sesión 15: Ejercicios

Use esta página después de leer el [material de estudio de la Sesión 15](index.md). Las secciones que mencionan los ejercicios son las de ese material.

## Ejercicio 1

Calcule $-19 \;\mathbf{mod}\; 7$ y $-127 \;\mathbf{mod}\; 4$. Indique si se presenta cada congruencia y justifique: $52 \equiv 31 \pmod{7}$ y $-31 \equiv 60 \pmod{7}$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Para los módulos, busque el múltiplo inmediatamente por debajo. Para las congruencias, use la forma $m \mid (a - b)$.

**Solución general.** $-19 \;\mathbf{mod}\; 7 = 2$ y $-127 \;\mathbf{mod}\; 4 = 1$. Las dos congruencias se presentan: las diferencias son $21$ y $-91$, ambas múltiplos de 7.
:::

## Ejercicio 2

Demuestre que si $a \equiv b \pmod{m}$ y $d \mid m$, entonces $a \equiv b \pmod{d}$. Dé un contraejemplo del recíproco.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Traduzca a divisibilidad y use transitividad.

**Solución general.** $d \mid m$ y $m \mid (a - b)$ dan $d \mid (a - b)$. El recíproco falla: $8 \equiv 2 \pmod{3}$, pero $8 \not\equiv 2 \pmod{12}$, aunque $3 \mid 12$.
:::

## Ejercicio 3

Sin calcular la potencia, halle $3^{200} \;\mathbf{mod}\; 8$ y $7^{50} \;\mathbf{mod}\; 6$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Busque una potencia pequeña congruente con 1 o con $-1$.

**Solución general.** $3^2 = 9 \equiv 1 \pmod{8}$, así que $3^{200} \equiv 1$. Como $7 \equiv 1 \pmod{6}$, también $7^{50} \equiv 1$.
:::

## Ejercicio 4

Muestre que ningún número de la forma $8k + 7$ es suma de tres cuadrados.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Haga la tabla de $n^2 \;\mathbf{mod}\; 8$, como en el ejemplo 3 de la sección 2.

**Solución general.** Los cuadrados son congruentes con 0, 1 o 4 módulo 8. Sumando tres de esos valores se obtienen todos los residuos menos el 7.
:::

## Ejercicio 5

Encuentre todas las soluciones módulo $m$, por tanteo o con el inverso.

1. $4x \equiv 5 \pmod{9}$
2. $2x \equiv 7 \pmod{17}$
3. $3x \equiv 1 \pmod{8}$

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Verifique primero $\text{mcd}(a, m)$. Después, multiplique por el inverso.

**Solución general.** $\overline{4} = 7$ da $x \equiv 35 \equiv 8 \pmod{9}$. $\overline{2} = 9$ da $x \equiv 63 \equiv 12 \pmod{17}$. $\overline{3} = 3$ da $x \equiv 3 \pmod{8}$.
:::

## Ejercicio 6

Sin resolver, diga cuántas soluciones módulo $m$ tiene cada congruencia. Después, resuelva las que tengan.

1. $4x \equiv 6 \pmod{10}$
2. $4x \equiv 7 \pmod{10}$
3. $12x \equiv 18 \pmod{30}$

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Use el teorema 4. Divida todo entre el mcd antes de buscar el inverso.

**Solución general.** 1: $d = 2$ y $2 \mid 6$, así que hay 2 soluciones: $x \equiv 4, 9 \pmod{10}$. 2: $d = 2$ y $2 \nmid 7$: ninguna. 3: $d = 6$ y $6 \mid 18$: 6 soluciones; $2x \equiv 3 \pmod{5}$ da $x \equiv 4 \pmod{5}$, y módulo 30 son $4, 9, 14, 19, 24, 29$.
:::

## Ejercicio 7

Demuestre la cancelación: si $ca \equiv cb \pmod{m}$ y $\text{mcd}(c, m) = 1$, entonces $a \equiv b \pmod{m}$. Dé un contraejemplo cuando $\text{mcd}(c, m) \neq 1$.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Multiplique ambos lados por $\overline{c}$.

**Solución general.** $\overline{c}ca \equiv \overline{c}cb$ da $a \equiv b$. Contraejemplo: $2 \cdot 7 \equiv 2 \cdot 4 \pmod{6}$, pero $7 \not\equiv 4 \pmod{6}$.
:::

## Ejercicio 8

Un sistema rota claves cada 9 horas. Acaba de rotar a las 04:00. ¿Después de cuántas rotaciones ocurre por primera vez una a las 22:00? ¿Y a las 21:00?

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Escriba la hora tras $x$ rotaciones con $\mathbf{mod}\; 24$, y plantee la congruencia lineal. Mire $\text{mcd}(9, 24)$.

**Solución general.** $4 + 9x \equiv 22 \pmod{24}$ da $9x \equiv 18$, y dividiendo entre 3, $3x \equiv 6 \pmod{8}$: $x \equiv 2 \pmod{8}$. Son 2 rotaciones. Para las 21:00, $9x \equiv 17 \pmod{24}$ no tiene solución, porque $3 \nmid 17$.
:::

## Ejercicio 9

El código `3120?47391` usa el esquema del ejercicio 2 de la sección 7 y perdió el quinto dígito. Recupérelo.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** Calcule $\sum i \cdot d_i$ con los dígitos conocidos, y plantee $5x + \text{suma} \equiv 0 \pmod{11}$.

**Solución general.** Los conocidos suman 199, y $199 \equiv 1 \pmod{11}$. Queda $5x \equiv -1 \equiv 10 \pmod{11}$. Con $\overline{5} = 9$: $x \equiv 90 \equiv 2 \pmod{11}$. El dígito es 2.
:::

## Ejercicio 10

Para el cifrado $c = (5p + 8) \;\mathbf{mod}\; 26$: cifre `SOL`, escriba la fórmula para descifrar y extienda el código de la sección 7 para cifrar y descifrar cadenas completas.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** $\text{mcd}(5, 26) = 1$. Encuentre el inverso de 5 con `inverso`.

**Solución general.** `SOL` se cifra como `UAL`. $\overline{5} = 21$, así que $p \equiv 21(c - 8) \pmod{26}$. Una cadena se cifra con `aTexto(aNumeros(s).map(cifrar(5, 8)))`.
:::

## Ejercicio 11

Muestre que **no** se puede descifrar sin ambigüedad con $c = (6p + 1) \;\mathbf{mod}\; 26$: dé dos letras distintas con el mismo cifrado.

:::{admonition} Pistas y solución general
:class: dropdown
**Pistas.** $\text{mcd}(6, 26) = 2$. Busque dos valores de $p$ que difieran en $26/2$.

**Solución general.** $p = 0$ y $p = 13$ dan $c = 1$ y $6 \cdot 13 + 1 = 79 \equiv 1 \pmod{26}$. A y N se cifran igual.
:::

## Ejercicio 12

Encuentre al menos 3 soluciones de $3x \equiv 5 \pmod{16}$.
