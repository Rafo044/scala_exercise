//import com.typesafe.config.ConfigFactory

//val config = ConfigFactory.load()
//val dburl = config.getString("db.url")



abstract class BookCenter {
  def book_id: Int
}
case class SalesBook(book_id: Int, quantity: Int, bookInfo: InfoBook) extends BookCenter {
  def addBook(bookname: String, price: Double): Unit = {
    println(s"Adding book: $bookname by ${bookInfo.author}, price: $price")
  }
}

case class InfoBook(book_id: Int, author: String, description: String) extends BookCenter {

}

object BookApp {
  def main(args: Array[String]): Unit = {
    val books = SalesBook(1, 10, InfoBook(1, "Author", "Description"))
    books.addBook("Book Title", 19.99)
  }
}
