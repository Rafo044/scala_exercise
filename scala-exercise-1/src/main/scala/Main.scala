case class Musteri(ad: String, yas: Int, aktiv: Boolean , sifariSayı: Int)

object Main{
def main(args: Array[String]): Unit = {
  val musteriler: List[Musteri] = List(
    Musteri("Əli", 30, true, 5),
    Musteri("Gülnar", 22, false, 0),
    Musteri("Samir", 45, true, 12),
    Musteri("Leyla", 17, true, 3), // 18 yaşdan kiçik
    Musteri("Cavid", 28, false, 1)
  )
  val süzgəcdənKecmisSiyahı: List[Musteri] = musteriler.filter(musteri => musteri.yas < 18)
  val sonHesabat: List[String] = süzgəcdənKecmisSiyahı.map(musteri => s"${musteri.ad}-${musteri.yas}")
  println(sonHesabat)
  }
}
