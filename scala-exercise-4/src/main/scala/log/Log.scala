package log

trait LogMessage
case class LogXeta(xetacodu: Int , mesaj: String) extends LogMessage
case class LogMelumat(mesaj: String) extends LogMessage
case class LogWarning() extends LogMessage

object LogProcessor {
  def logEmalEt(log: LogMessage): String = {
    log match {
      case LogXeta(xetacodu, mesaj) => s"Kritik xeta: $xetacodu, Mesaj: $mesaj"
      case LogMelumat(mesaj) => s"Məlumat emal edildi: $mesaj"
      case LogWarning() => "Xeberdarliq"
      case _ => "Naməlum Log Növü"
    }
  }
}
