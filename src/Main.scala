import Entities._

import GameGadgetsPackage._
import FieldPackage._
import HumanPackage._


import java.util.Scanner


object Player {
  val sc = new Scanner(System.in)

  def initialInput(): FieldState = {
    // first-only input
    val height = sc.nextInt()
    val playerNum = sc.nextInt()
    sc.nextLine()

    // every-turn input
    val firstLine = sc.nextLine()
    val width = firstLine.length
    val fieldState = new FieldState(height, width)
    fieldState.squaresParseInputer("." + firstLine, 1)
    for(y <- 2 to height){
      val input = "." + sc.nextLine()
      fieldState.squaresParseInputer(input, y)
    }

    for(i <- 0 until playerNum) {
      val player = new Human(sc.nextInt(), sc.nextInt())
    }
    for(i <- 0 until playerNum) {
      val enemy = new Human(sc.nextInt(), sc.nextInt())
    }

    val choiceNum = sc.nextInt()
    sc.nextLine()
    val commands = new Array[Command](choiceNum)
    for(i <- 0 until choiceNum) {
      commands(i) =
        new Command(sc.next(), sc.nextInt(), sc.next(), sc.next())
      sc.nextLine()  // remove newline
    }

    fieldState
  }

  
  def main(args: Array[String]){
    val fieldState = initialInput()


    // game loop
    while(true) {
      val field = new Array[String](height)
      for(i <- 0 until height)
        field(i) = sc.nextLine()

      for(i <- 0 until playerNum) {
        val (unitx, unity) = (sc.nextInt(), sc.nextInt())
      }
      for(i <- 0 until playerNum) {
        val (enemyX, enemyY) = (sc.nextInt(), sc.nextInt())
      }

      val choiceNum = sc.nextInt()
      sc.nextLine()
      val commands = new Array[Command](choiceNum)
      for(i <- 0 until choiceNum) {
        commands(i) =
          new Command(sc.next(), sc.nextInt(), sc.next(), sc.next())
        sc.nextLine()
      }

      printer(commands(0))
    }
  }
}

// Console.err.println("Debug messages...")
