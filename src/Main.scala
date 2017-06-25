import java.util.Scanner

sealed trait Direction
case object N extends Direction
case object NE extends Direction
case object E extends Direction
case object SE extends Direction
case object S extends Direction
case object SW extends Direction
case object W extends Direction
case object NW extends Direction

class Command(com: String, index: Int, dir1: Direction, dir2: Direction) {
  this(com: String, index: Int, dir1: String, dir2: String) =
    new Command()
}

object Player {
  def printer(com: )

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

// Console.err.println("Debug messages...")
