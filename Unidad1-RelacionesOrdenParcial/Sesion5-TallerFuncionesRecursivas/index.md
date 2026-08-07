---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 1 · Sesión 5: Taller de funciones recursivas"
---

# Unidad 1 · Sesión 5: Taller de funciones recursivas

## Objetivos

- Diseñar e implementar programas funcionales puros con estructuras de datos inmutables utilizando recursión, reconocimiento de patrones, mecanismos de encapsulación, funciones de alto orden e iteradores para resolver problemas de programación.
- Aplicar conceptos fundamentales de la programación funcional, utilizando un lenguaje de programación adecuado como Scala, para analizar un problema, modelar, diseñar y desarrollar su solución.

**Antes de empezar:** el taller debe ser desarrollado de forma individual.

## Recursión y naturales

A continuación se presentan unas definiciones sobre los números enteros.

**Definición:**

- $0 \in \mathbb{Z}^+$ (Cero es un entero positivo).
- $n + 1 \in \mathbb{Z}^+$, si $n \in \mathbb{Z}^+$ ($n+1$ es un entero positivo si $n$ también es un entero positivo).

**Funciones:**

- $\mathrm{sucesor}(n) = n + 1$, para todo $n \in \mathbb{Z}^+$.
- $\mathrm{predecesor}(n) = n - 1$, para todo $n \in \mathbb{Z}^+$ excepto $0$.

Desarrolle en Scala las funciones `suc` y `pred` (sucesor y predecesor) y utilícelas para implementar las funciones que corresponden a las definiciones recursivas de la [sección de ejercicios](exercises.md).

---

*Material adaptado del material original de las profesoras Angela Villota y Jenifer Viafara.*
