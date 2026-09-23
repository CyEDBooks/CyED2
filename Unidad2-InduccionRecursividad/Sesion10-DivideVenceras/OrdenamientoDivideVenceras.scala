class OrdenamientoDivideVenceras {

  def particionBajo(n: Int, lista: List[Int]): List[Int] =
    if (n == 0) Nil
    else lista match {
      case Nil              => Nil
      case primero :: resto => primero :: particionBajo(n - 1, resto)
    }

  def particionAlto(n: Int, lista: List[Int]): List[Int] =
    if (n == 1) lista
    else lista match {
      case Nil        => Nil
      case _ :: resto => particionAlto(n - 1, resto)
    }

  def mezclar(lista1: List[Int], lista2: List[Int]): List[Int] = (lista1, lista2) match {
    case (Nil, _)           => lista2
    case (_, Nil)           => lista1
    case (m :: ms, n :: ns) =>
      if (m < n) m :: mezclar(ms, lista2) else n :: mezclar(lista1, ns)
  }

  def mergeSort(lista: List[Int]): List[Int] = lista match {
    case Nil      => Nil
    case _ :: Nil => lista
    case _ =>
      val p = lista.length / 2
      mezclar(mergeSort(particionBajo(p, lista)), mergeSort(particionAlto(p + 1, lista)))
  }

  def menores(pivote: Int, lista: List[Int]): List[Int] =
    lista.filter(x => x <= pivote)

  def mayores(pivote: Int, lista: List[Int]): List[Int] =
    lista.filter(x => x > pivote)

  def quickSort(lista: List[Int]): List[Int] = lista match {
    case Nil             => Nil
    case pivote :: resto =>
      quickSort(menores(pivote, resto)) ::: List(pivote) ::: quickSort(mayores(pivote, resto))
  }

  private def mostrar(lista: List[Int]): String =
    lista.mkString("[", ", ", "]")

  private def sangria(nivel: Int): String =
    "|   " * nivel

  def mergeSortPasoAPaso(lista: List[Int], nivel: Int): List[Int] = {
    val s = sangria(nivel)
    println(s"${s}mergeSort(${mostrar(lista)})")
    lista match {
      case Nil =>
        println(s"${s}  caso trivial: lista vacia -> []")
        Nil
      case _ :: Nil =>
        println(s"${s}  caso trivial: un solo elemento -> ${mostrar(lista)}")
        lista
      case _ =>
        val p = lista.length / 2
        val bajo = particionBajo(p, lista)
        val alto = particionAlto(p + 1, lista)
        println(s"${s}  longitud = ${lista.length}, p = $p")
        println(s"${s}  DIVIDIR: particionBajo = ${mostrar(bajo)}, particionAlto = ${mostrar(alto)}")
        val bajoOrdenado = mergeSortPasoAPaso(bajo, nivel + 1)
        val altoOrdenado = mergeSortPasoAPaso(alto, nivel + 1)
        val resultado = mezclar(bajoOrdenado, altoOrdenado)
        println(s"${s}  MEZCLAR: ${mostrar(bajoOrdenado)} con ${mostrar(altoOrdenado)} -> ${mostrar(resultado)}")
        resultado
    }
  }

  def quickSortPasoAPaso(lista: List[Int], nivel: Int): List[Int] = {
    val s = sangria(nivel)
    println(s"${s}quickSort(${mostrar(lista)})")
    lista match {
      case Nil =>
        println(s"${s}  caso trivial: lista vacia -> []")
        Nil
      case pivote :: resto =>
        val listaMenores = menores(pivote, resto)
        val listaMayores = mayores(pivote, resto)
        println(s"${s}  pivote = $pivote, resto = ${mostrar(resto)}")
        println(s"${s}  DIVIDIR: menores o iguales = ${mostrar(listaMenores)}, mayores = ${mostrar(listaMayores)}")
        val menoresOrdenados = quickSortPasoAPaso(listaMenores, nivel + 1)
        val mayoresOrdenados = quickSortPasoAPaso(listaMayores, nivel + 1)
        val resultado = menoresOrdenados ::: List(pivote) ::: mayoresOrdenados
        println(s"${s}  UNIR: ${mostrar(menoresOrdenados)} ::: [$pivote] ::: ${mostrar(mayoresOrdenados)} -> ${mostrar(resultado)}")
        resultado
    }
  }

  def pruebaDeEscritorioMergeSort(lista: List[Int]): Unit = {
    println("==============================================")
    println(s"PRUEBA DE ESCRITORIO: mergeSort(${mostrar(lista)})")
    println("==============================================")
    val resultado = mergeSortPasoAPaso(lista, 0)
    println()
    println(s"Resultado:  ${mostrar(resultado)}")
    println(s"Esperado:   ${mostrar(lista.sorted)}")
    println(s"Correcto:   ${resultado == lista.sorted && resultado == mergeSort(lista)}")
    println()
  }

  def pruebaDeEscritorioQuickSort(lista: List[Int]): Unit = {
    println("==============================================")
    println(s"PRUEBA DE ESCRITORIO: quickSort(${mostrar(lista)})")
    println("==============================================")
    val resultado = quickSortPasoAPaso(lista, 0)
    println()
    println(s"Resultado:  ${mostrar(resultado)}")
    println(s"Esperado:   ${mostrar(lista.sorted)}")
    println(s"Correcto:   ${resultado == lista.sorted && resultado == quickSort(lista)}")
    println()
  }
}

@main def pruebasDeEscritorio(): Unit = {
  val ordenamiento = new OrdenamientoDivideVenceras
  ordenamiento.pruebaDeEscritorioMergeSort(List(38, 27, 43, 3, 9, 82, 10))
  ordenamiento.pruebaDeEscritorioQuickSort(List(38, 27, 43, 3, 9, 82, 10))
}
