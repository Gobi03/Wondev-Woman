import Entities._

import java.util.Scanner

class Command(val action: Action, val index: Int,
              val dir1: Direction, val dir2: Direction) {
  def this(action: String, index: Int, dir1: String, dir2: String) =
    this(stringToCommand(action), index,
    stringToDirection(dir1), stringToDirection(dir2))
}

object Player {
  def printer(command: Command): Unit = {
    import command._
    println(s"$action $index $dir1.code $dir2.code")
  }

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

      val legalCommandNum = sc.nextInt()
      sc.nextLine()
      val commands = new Array[Command](legalCommandNum)
      for(i <- 0 until legalCommandNum) {
        commands(i) =
          new Command(sc.next(), sc.nextInt(), sc.next(), sc.next())
        sc.nextLine()
      }

      printer(commands(0))
    }
  }
}

// Console.err.println("Debug messages...")
