import java.util.Scanner

object Player extends App {
  
  val sc = new Scanner(System.in)

  val height = sc.nextInt()
  val playerNum = sc.nextInt()
  sc.nextLine()

  // game loop
  while(true) {
    val field = new Array[String](height)
    for(i <- 0 until height)
      field(i) = sc.nextLine()
    Console.err.println(field(0))

    for(i <- 0 until playerNum) {
      val unitx = sc.nextInt(); val unity = sc.nextInt()
    }
    for(i <- 0 until playerNum) {
      val (otherx, othery) = (sc.nextInt(), sc.nextInt())
    }
    Console.err.println("Debug messages2")

    val legalActionNum = sc.nextInt()
    sc.nextLine()
    Console.err.println(legalActionNum)
    ///sc.nextLine()
    for(i <- 0 until legalActionNum) {
      val test = sc.nextLine()
      Console.err.println(test)
      // val atype = sc.next()
      // val index = sc.nextInt()
      // val dir1 = sc.next()
      // val dir2 = sc.next()
    }
    
    println("MOVE&BUILD 0 N S")
  }

}

// To debug: Console.err.println("Debug messages...")
