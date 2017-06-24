import java.util.Scanner

object Player {
  def main(args: Array[String]){
    val sc = new Scanner(System.in)

    val height = sc.nextInt()
    val playerNum = sc.nextInt()
    sc.nextLine()

    // game loop
    while(true) {
      val field = new Array[String](height)
      for(i <- 0 until height)
        field(i) = sc.nextLine()

      for(i <- 0 until playerNum) {
        val (unitx, unity) = (sc.nextInt(), sc.nextInt())
      }
      for(i <- 0 until playerNum) {
        val (otherx, othery) = (sc.nextInt(), sc.nextInt())
      }

      val legalActionNum = sc.nextInt()
      sc.nextLine()
      for(i <- 0 until legalActionNum) {
        val (com, index, move, block) =
          (sc.next(), sc.nextInt(), sc.next(), sc.next())
        sc.nextLine()
      }
      
      println("MOVE&BUILD 0 N S")
    }
  }
}

// To debug: Console.err.println("Debug messages...")
