---
# Copyright (c) 2026 Angela Villota, and collaborators from the CyED block
# Licensed under the PolyForm Noncommercial License 1.0.0.
# Commercial use is prohibited without prior written authorization.
title: "Unidad 2 · Sesión 9: Anexo — Pruebas unitarias con MUnit en Scala e IntelliJ IDEA"
---

# Unidad 2 · Sesión 9: Anexo
## Pruebas unitarias con MUnit en Scala e IntelliJ IDEA

Creación del proyecto, configuración, escritura y ejecución de pruebas desde la IDE.

***

## Contenido

1. Propósito de la guía
2. Antes de empezar
3. Ruta de trabajo
4. Aserciones que usaremos inicialmente
5. Problemas frecuentes
6. Checklist antes de terminar
7. Fuentes

:::{admonition} Idea central
Las pruebas acompañan el desarrollo: primero pensamos qué debe ocurrir, luego comprobamos automáticamente que la implementación cumple esa expectativa.
:::

***

## 1. Propósito de la guía

Al finalizar esta guía podrás crear un proyecto Scala con sbt en IntelliJ IDEA, configurar MUnit, escribir pruebas unitarias y ejecutarlas directamente desde la IDE.

- Crear un proyecto Scala usando sbt.
- Distinguir el código de producción (`src/main/scala`) del código de pruebas (`src/test/scala`).
- Agregar MUnit como dependencia de pruebas en `build.sbt`.
- Escribir suites con `munit.FunSuite` y usar `assertEquals` y `assert`.
- Ejecutar una prueba, una suite o el conjunto de pruebas desde IntelliJ IDEA.
- Seleccionar casos de prueba útiles para funciones recursivas.

***

## 2. Antes de empezar

Verifica que tu equipo tenga los siguientes elementos:

- IntelliJ IDEA instalado.
- Plugin de Scala instalado y habilitado.
- Un JDK configurado en IntelliJ IDEA.
- Conexión a Internet durante la primera sincronización para descargar dependencias.

:::{admonition} Nota
:class: tip
IntelliJ IDEA reconoce MUnit mediante el plugin de Scala. En esta guía ejecutaremos las pruebas desde los controles de la IDE; la consola de sbt no es el mecanismo principal.
:::

***

## 3. Ruta de trabajo

| Paso | Actividad |
|---|---|
| 1 | Crear el proyecto Scala con sbt |
| 2 | Reconocer la estructura del proyecto |
| 3 | Agregar MUnit en `build.sbt` |
| 4 | Sincronizar sbt |
| 5 | Crear una función para probar |
| 6 | Crear la primera suite |
| 7 | Ejecutar una prueba |
| 8 | Interpretar el resultado |
| 9 | Agregar varios casos |
| 10 | Ejecutar toda la suite |
| 11 | Ejecutar todas las pruebas |
| 12 | Probar funciones sobre listas |
| 13 | Elegir casos para recursión |
| 14 | Aplicar el ciclo prueba–implementación |

### Paso 1 — Crear un proyecto Scala con sbt en IntelliJ IDEA

Abre IntelliJ IDEA y crea un proyecto nuevo. En el asistente selecciona Scala como lenguaje y sbt como sistema de construcción.

```
File → New → Project → Scala → Build system: sbt
```

- Asigna un nombre al proyecto, por ejemplo: `TestingExample`.
- Selecciona la ubicación donde se guardará.
- Selecciona un JDK disponible.
- Mantén la versión de Scala sugerida por el proyecto, salvo que el curso indique una versión específica.
- Haz clic en Create y espera a que IntelliJ termine la importación inicial.

:::{admonition} Importante
:class: warning
No continúes mientras IntelliJ esté descargando o indexando dependencias. Espera a que termine la sincronización inicial.
:::

### Paso 2 — Reconocer la estructura del proyecto

En un proyecto sbt, el código y las pruebas se organizan en carpetas diferentes:

```
TestingExample/
├── build.sbt
└── src/
    ├── main/
    │   └── scala/
    └── test/
        └── scala/
```

- `src/main/scala`: contiene las funciones y objetos que forman parte de la solución.
- `src/test/scala`: contiene las suites de pruebas.

:::{admonition} Si no ves alguna carpeta
Créala dentro de `src` y vuelve a sincronizar el proyecto sbt. IntelliJ debe reconocer `src/test/scala` como fuente de pruebas.
:::

### Paso 3 — Agregar MUnit al archivo `build.sbt`

Abre `build.sbt` y agrega la dependencia de MUnit. No borres las configuraciones que IntelliJ haya generado.

```scala
libraryDependencies += "org.scalameta" %% "munit" % "1.1.0" % Test
```

La configuración `Test` indica que esta dependencia se usa para el código de pruebas, no como parte de la aplicación principal.

:::{admonition} No reemplaces tu versión de Scala
:class: warning
El tutorial oficial muestra un ejemplo con una versión de Scala concreta. En tu proyecto conserva la versión creada por IntelliJ, a menos que el curso indique otra.
:::

### Paso 4 — Sincronizar los cambios de sbt

Después de modificar `build.sbt`, IntelliJ debe volver a cargar el modelo del proyecto y descargar MUnit.

```
Load sbt Changes / Sync / sbt tool window → Reload project
```

- Usa la notificación `Load sbt Changes` si aparece en el editor.
- También puedes usar `Reload project` desde la ventana de herramientas de sbt.
- Espera a que la sincronización termine antes de crear la suite.

### Paso 5 — Crear una función que vamos a probar

En `src/main/scala` crea un archivo Scala llamado `Recursion.scala`. Puedes hacerlo con clic derecho sobre la carpeta y New → New Scala Class/File.

```scala
object Recursion:

  def potencia(base: Int, exponente: Int): Int =
    if exponente == 0 then
      1
    else
      base * potencia(base, exponente - 1)
```

Por ejemplo, `Recursion.potencia(2, 3)` debe producir `8`.

### Paso 6 — Crear la primera suite de pruebas

En `src/test/scala` crea `RecursionSuite.scala` y define una clase que extienda `munit.FunSuite`.

```scala
class RecursionSuite extends munit.FunSuite:

  test("2 elevado a 3 debe ser 8") {
    val obtained = Recursion.potencia(2, 3)
    val expected = 8

    assertEquals(obtained, expected)
  }
```

:::{admonition} Observa la estructura
Cada test tiene una descripción, ejecuta la función, define el resultado esperado y usa una aserción para comparar.
:::

#### Anatomía de una prueba

| Elemento | Valor |
|---|---|
| Entrada / ejecución | `Recursion.potencia(2, 3)` |
| Resultado obtenido | `obtained` |
| Resultado esperado | `expected = 8` |
| Comparación | `assertEquals(obtained, expected)` |

:::{admonition} Evita esta falsa prueba
:class: danger
No calcules `expected` llamando de nuevo a la misma función que estás probando. El resultado esperado debe definirse de forma independiente.
:::

### Paso 7 — Ejecutar una prueba desde IntelliJ IDEA

Cuando IntelliJ reconoce la suite MUnit, aparece el ícono de ejecución en el margen izquierdo del editor.

- Haz clic en el ícono junto al test.
- Selecciona Run para ejecutar únicamente esa prueba.
- También puedes ubicar el cursor dentro de la prueba y usar la acción Run desde IntelliJ.

El resultado se mostrará en la ventana Run, en la parte inferior de la IDE.

### Paso 8 — Interpretar el resultado de una prueba

Una prueba puede pasar o fallar. Lo importante es usar el reporte para decidir qué debes corregir.

| Resultado | Significado |
|---|---|
| PASA | El valor obtenido cumple lo esperado. |
| FALLA | Puede existir un error en la implementación o en la especificación de la prueba. |

```scala
// Ejemplo deliberadamente incorrecto
val obtained = Recursion.potencia(2, 3)
val expected = 10
assertEquals(obtained, expected)
```

:::{admonition} Pregunta clave
:class: warning
Cuando una prueba falla, no asumas automáticamente que el algoritmo está mal. Revisa también si el resultado esperado fue definido correctamente.
:::

### Paso 9 — Agregar varios casos de prueba

Una sola prueba rara vez es suficiente. Para `potencia` podemos probar casos normales y casos particulares.

```scala
class RecursionSuite extends munit.FunSuite:

  test("2 elevado a 3") {
    assertEquals(Recursion.potencia(2, 3), 8)
  }

  test("5 elevado a 2") {
    assertEquals(Recursion.potencia(5, 2), 25)
  }

  test("exponente cero") {
    assertEquals(Recursion.potencia(7, 0), 1)
  }

  test("base uno") {
    assertEquals(Recursion.potencia(1, 20), 1)
  }
```

### Paso 10 — Ejecutar toda una suite

Haz clic en el ícono de ejecución que aparece junto al nombre de la clase `RecursionSuite`, o haz clic derecho sobre el archivo y selecciona Run.

IntelliJ ejecutará todas las pruebas contenidas en esa clase y mostrará un resumen en la ventana Run.

### Paso 11 — Ejecutar todas las pruebas del proyecto

Cuando tengas varias suites, ejecuta el conjunto completo para comprobar que un cambio reciente no haya roto comportamiento que ya funcionaba.

```
Project → src/test/scala → clic derecho → Run Tests
```

:::{admonition} Buena práctica
:class: tip
Antes de entregar o hacer commit de una versión importante, ejecuta todas las pruebas del proyecto.
:::

### Paso 12 — Probar una función recursiva sobre listas

Crea `ListFunctions.scala` en `src/main/scala`:

```scala
object ListFunctions:

  def longitud[A](lista: List[A]): Int =
    lista match
      case Nil => 0
      case _ :: tail => 1 + longitud(tail)
```

Luego crea `ListFunctionsSuite.scala` en `src/test/scala`:

```scala
class ListFunctionsSuite extends munit.FunSuite:

  test("lista vacía") {
    assertEquals(ListFunctions.longitud(List.empty[Int]), 0)
  }

  test("un elemento") {
    assertEquals(ListFunctions.longitud(List(10)), 1)
  }

  test("varios elementos") {
    assertEquals(ListFunctions.longitud(List(10, 20, 30, 40)), 4)
  }
```

### Paso 13 — Elegir casos de prueba para funciones recursivas

Las pruebas deben reflejar la estructura del problema. Para una función recursiva sobre listas, empieza por estos tres tipos de caso:

| Caso | Tipo | Ejemplo |
|---|---|---|
| Lista vacía | Caso base | `List.empty[Int]` |
| Un elemento | Caso pequeño | `List(10)` |
| Varios elementos | Caso recursivo | `List(10, 20, 30, 40)` |

Cuando la especificación incluya condiciones adicionales, agrega casos límite y casos que permitan detectar errores frecuentes.

### Paso 14 — Aplicar el ciclo prueba–implementación

Durante CyED2 las pruebas no se dejan para el final. Úsalas como parte del proceso de resolución del problema.

| Paso | Actividad |
|---|---|
| 1 | Comprender el problema |
| 2 | Definir casos de prueba |
| 3 | Escribir una prueba |
| 4 | Ejecutarla en IntelliJ |
| 5 | Implementar o modificar la función |
| 6 | Ejecutar de nuevo |
| 7 | Refactorizar sin romper las pruebas |

> El paso 7 cierra el ciclo: al refactorizar, vuelve al paso 3 para seguir agregando o ajustando pruebas.

***

## 4. Aserciones que usaremos inicialmente

Para esta introducción trabajaremos principalmente con dos aserciones de MUnit:

```scala
assertEquals(obtained, expected)
assert(condition)
```

- `assertEquals`: comprueba que el valor obtenido sea igual al esperado.
- `assert`: comprueba que una condición booleana sea verdadera.

**Ejemplo con `assert`**

```scala
test("todos los resultados son pares") {
  val input = List(1, 2, 3, 4)
  val result = input.map(x => x * 2)
  assert(result.forall(x => x % 2 == 0))
}
```

***

## 5. Problemas frecuentes

| Problema | Solución |
|---|---|
| IntelliJ no reconoce `munit.FunSuite` | Revisa que la dependencia esté en `build.sbt` y vuelve a cargar el proyecto sbt. |
| No aparece el ícono de Run | Espera la indexación, revisa que el archivo esté en `src/test/scala` y que el proyecto haya sincronizado correctamente. |
| La prueba compila pero falla | Compara el valor obtenido con el esperado y decide si el error está en la implementación o en la prueba. |
| Modifiqué `build.sbt` y nada cambió | Usa `Load sbt Changes` o `Reload project` para actualizar el modelo del proyecto. |

***

## 6. Checklist antes de terminar

- [ ] El proyecto fue creado como Scala + sbt en IntelliJ IDEA.
- [ ] MUnit aparece como dependencia de Test en `build.sbt`.
- [ ] El proyecto fue sincronizado después de modificar `build.sbt`.
- [ ] El código está en `src/main/scala`.
- [ ] Las suites están en `src/test/scala`.
- [ ] Cada prueba tiene una expectativa clara e independiente de la función probada.
- [ ] Se probaron el caso base, casos normales y, cuando corresponda, casos límite.
- [ ] Todas las pruebas del proyecto pasan antes de entregar.

***

## 7. Fuentes

- Scala Documentation — [How to write tests? (Scala Toolkit)](https://docs.scala-lang.org/toolkit/testing-suite.html)
- JetBrains — [Get started with Scala](https://www.jetbrains.com/help/idea/get-started-with-scala.html)
- JetBrains — [sbt support in IntelliJ IDEA](https://www.jetbrains.com/help/idea/sbt-support.html)
- JetBrains — [Run, debug, and test Scala projects](https://www.jetbrains.com/help/idea/run-debug-and-test-scala.html)
