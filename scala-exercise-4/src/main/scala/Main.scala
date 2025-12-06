
import log.LogProcessor.logEmalEt
import log.LogXeta
import log.LogMelumat
import log.LogWarning

object Main {
  def main(args: Array[String]): Unit = {
    val log1 = LogXeta(500, "Database Down")
    val log2 = LogMelumat("İstifadəçi Qeydiyyatı")
    val log3 = LogWarning()

    println(logEmalEt(log1))
    println(logEmalEt(log2))
    println(logEmalEt(log3))
  }
}
