object Main {

def main(args: Array[String]): Unit = {  val cümlələr: List[String] = List(
    "Scala həm FP, həm də OOP-dir",
    "FP immutability tələb edir",
    "Data Engineer Spark-dan istifadə edir"
  )

  // 1. Map ilə cəhd edin
  val mapNəticəsi = cümlələr.map(c => c.split(" "))
  // mapNəticəsi-nin tipi nədir?

  // 2. FlatMap ilə həll edin
  val flatMapNəticəsi = cümlələr.flatMap(c => c.split(" "))

  println(s"1. Map Nəticəsi Tipi: ${mapNəticəsi}")
  println(s"2. FlatMap Nəticəsi Tipi: ${flatMapNəticəsi}")
  println(s"2. FlatMap Nəticəsi: ${flatMapNəticəsi}")
  // Gözlənilən nəticə: List(Scala, həm, FP,, həm, də, OOP-dir, FP, immutability, tələb, edir, Data, Engineer, Spark-dan, istifadə, edir)
}

}
