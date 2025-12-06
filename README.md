# Scala Təlimləri Toplusu

Bu repository-də Scala proqramlaşdırma dilinin müxtəlif konsepsiyalarını əhatə edən bir neçə təlim (exercise) və həllər mövcuddur. Hər bir təlimin məqsədi və istifadə olunan yanaşmalar aşağıda ətraflı şəkildə izah edilmişdir.

---

### 1. Hello World
Ənənəvi "Hello, World!" proqramı. Bu, Scala sintaksisi ilə tanışlıq üçün ilk addımdır.

*   **Fayl:** `solutions/scala/hello-world/1/src/main/scala/HelloWorld.scala`
*   **Konsepsiyalar:** `object` yaradılması, `def` ilə metod təyin etmək, `String` qaytarmaq.
*   **İzah:** `HelloWorld` adlı bir `object` içərisində "Hello, World!" mətnini qaytaran sadə bir `hello` funksiyası yaradılmışdır.

```scala/solutions/scala/hello-world/1/src/main/scala/HelloWorld.scala#L1-3
object HelloWorld {
  def hello() = "Hello, World!"
}
```

---

### 2. Two-fer
Funksiyalarda standart (default) arqumentlərin istifadəsini və sətir interpolyasiyasını nümayiş etdirən bir təlim.

*   **Fayl:** `solutions/scala/two-fer/1/src/main/scala/Twofer.scala`
*   **Konsepsiyalar:** Standart parametrlər, `s`-string interpolyasiyası.
*   **İzah:** `twofer` funksiyası `name` adlı bir arqument qəbul edir. Əgər funksiya çağırılarkən `name` üçün bir dəyər verilməzsə, standart olaraq "you" dəyəri mənimsədilir. Funksiya, verilən ada uyğun olaraq "One for [name], one for me." formatında bir mətn qaytarır.

```scala/solutions/scala/two-fer/1/src/main/scala/Twofer.scala#L1-5
object Twofer {
  def twofer(name: String = "you"): String = {
      s"One for $name, one for me."
    }
  }
```

---

### 3. Uzun il (Leap Year)
Verilən bir ilin uzun il olub-olmadığını yoxlayan alqoritmik məntiqin tətbiqi.

*   **Fayl:** `solutions/scala/leap/1/src/main/scala/Leap.scala`
*   **Konsepsiyalar:** Şərt operatorları (`if`/`else`), modul (qalıq) hesablanması (`%`).
*   **İzah:** `leapYear` funksiyası bir ili arqument olaraq qəbul edir və uzun il qaydalarına (4-ə, 100-ə və 400-ə bölünmə) əsaslanaraq `true` və ya `false` dəyəri qaytarır.

```scala/solutions/scala/leap/1/src/main/scala/Leap.scala#L5-15
object Leap {
  def leapYear(year: Int): Boolean = {
    if (year % 400 == 0){
      true
    } else if (year % 100 == 0){
      false
      } else if (year % 4 == 0){
      true
      } else {
      false
      }
    
    }
  }
```

---

### 4. Kolleksiyalar ilə İş: `map` və `flatMap`
Kolleksiyalar üzərində `map` və `flatMap` kimi yüksək səviyyəli (higher-order) funksiyaların fərqini və istifadəsini göstərən təlim.

*   **Fayl:** `scala-exercise-1/src/main/scala/Main.scala`
*   **Konsepsiyalar:** `List`, `map`, `flatMap`, `String.split`.
*   **İzah:** Bir `List[String]` (cümlələr siyahısı) üzərində əvvəlcə `map`, sonra isə `flatMap` tətbiq olunur. `map` funksiyası hər cümləni sözlər massivinə çevirərək `List[Array[String]]` yaradır. `flatMap` isə eyni əməliyyatı yerinə yetirir, ancaq nəticədə yaranan bütün massivləri birləşdirərək tək bir `List[String]` (sözlər siyahısı) qaytarır.

```scala/scala-exercise-1/src/main/scala/Main.scala#L3-17
object Main {

def main(args: Array[String]): Unit = {  val cümlələr: List[String] = List(
    "Scala həm FP, həm də OOP-dir",
    "FP immutability tələb edir",
    "Data Engineer Spark-dan istifadə edir"
  )

  // 1. Map ilə cəhd edin
  val mapNəticəsi = cümlələr.map(c => c.split(" "))

  // 2. FlatMap ilə həll edin
  val flatMapNəticəsi = cümlələr.flatMap(c => c.split(" "))

  println(s"1. Map Nəticəsi Tipi: ${mapNəticəsi}")
  println(s"2. FlatMap Nəticəsi Tipi: ${flatMapNəticəsi}")
  println(s"2. FlatMap Nəticəsi: ${flatMapNəticəsi}")
}

}
```

---

### 5. `Option` ilə Məlumatların Təhlükəsiz Emalı
`null` dəyərlərin qarşısını almaq və proqramın dayanıqlılığını artırmaq üçün Scala-nın `Option` tipindən (`Some`/`None`) istifadə.

*   **Fayl:** `scala-exercise-2/src/main/scala/Main.scala`
*   **Konsepsiyalar:** `case class`, `Option[T]`, `Some`, `None`, `map`, `getOrElse`.
*   **İzah:** `Musteri` sinfinin `telefon` sahəsi `Option[String]` olaraq təyin edilib, bu da bir müştərinin telefon nömrəsinin olmaya biləcəyini göstərir. Proqram, nömrə varsa onu formatlayır (`map`), yoxdursa standart bir mətn qaytarır (`getOrElse`). Bu, `NullPointerException` xətalarından qaçınmaq üçün effektiv bir yoldur.

```scala/scala-exercise-2/src/main/scala/Main.scala#L9-13
    def formatlaVeGeriQaytar(telOption: Option[String]): String = {
      telOption
        .map(_.replaceFirst("50", "+99450"))
        .getOrElse("Telefon nomresi yoxdur")
    }
```

---

### 6. Kolleksiyaların Filtrlənməsi və Transformasiyası
Müştəri siyahısı üzərində `filter` və `map` funksiyalarını istifadə edərək data emalı zəncirinin qurulması.

*   **Fayl:** `scala-exercise-3/src/main/scala/Main.scala`
*   **Konsepsiyalar:** `case class`, `List`, `filter`, `map`.
*   **İzah:** Proqram, müştərilərdən ibarət bir siyahıdan yaşı 18-dən kiçik olanları `filter` vasitəsilə seçir. Daha sonra, seçilmiş müştərilərin siyahısını `map` ilə "ad-yaş" formatında mətn siyahısına çevirir.

```scala/scala-exercise-3/src/main/scala/Main.scala#L12-14
  val süzgəcdənKecmisSiyahı: List[Musteri] = musteriler.filter(musteri => musteri.yas < 18)
  val sonHesabat: List[String] = süzgəcdənKecmisSiyahı.map(musteri => s"${musteri.ad}-${musteri.yas}")
  println(sonHesabat)
```

---

### 7. ADT (Algebraic Data Types) ilə Logların Emalı
Fərqli, lakin əlaqəli məlumat növlərini (log mesajları) modelləşdirmək üçün Scala-nın `sealed trait` və `case object`/`case class` (ADT) xüsusiyyətlərinin istifadəsi.

*   **Fayl:** `scala-exercise-4/src/main/scala/Main.scala` (və `log/Log.scala`)
*   **Konsepsiyalar:** `sealed trait`, `case class`, `case object`, Pattern Matching.
*   **İzah:** Bu təlimdə fərqli log növləri (`LogXeta`, `LogMelumat`, `LogWarning`) bir `sealed trait` altında birləşdirilir. `logEmalEt` funksiyası (ehtimal ki, `log/Log.scala` faylında yerləşir) bu fərqli log növlərini emal etmək üçün pattern matching istifadə edir. `Main` obyekti fərqli log nümunələri yaradır və onları emal edərək nəticəni çap edir.

```scala/scala-exercise-4/src/main/scala/Main.scala#L7-14
  def main(args: Array[String]): Unit = {
    val log1 = LogXeta(500, "Database Down")
    val log2 = LogMelumat("İstifadəçi Qeydiyyatı")
    val log3 = LogWarning()

    println(logEmalEt(log1))
    println(logEmalEt(log2))
    println(logEmalEt(log3))
  }
```
