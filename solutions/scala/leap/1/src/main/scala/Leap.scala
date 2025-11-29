//Əgər il 400-ə qalıqsız bölünürsə, uzun ildir.
//Əks halda, əgər il 100-ə qalıqsız bölünürsə, uzun il deyil.
//Əks halda, əgər il 4-ə qalıqsız bölünürsə, uzun ildir.
//Əks halda, uzun il deyil.

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

