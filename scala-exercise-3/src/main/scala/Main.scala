object Main {

  case class Musteri(ad: String, telefon: Option[String])

  val eli: Musteri = Musteri("Əli", Some("501234567"))
  val samir: Musteri = Musteri("Samir", None)

  def main(args: Array[String]): Unit = {

    def formatlaVeGeriQaytar(telOption: Option[String]): String = {
      telOption
        .map(_.replaceFirst("50", "+99450"))
        .getOrElse("Telefon nomresi yoxdur")
    }

    println(s"Əli: ${formatlaVeGeriQaytar(eli.telefon)}")
    println(s"Samir: ${formatlaVeGeriQaytar(samir.telefon)}")
  }
}
