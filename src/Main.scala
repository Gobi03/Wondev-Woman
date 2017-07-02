import CommonPackage._

import Entities._

import GameGadgetsPackage._

import FieldPackage._
import HumanPackage._

import GameStatePackage._

import scala.annotation.tailrec
import java.util.Scanner


object Player {
  val sc = new Scanner(System.in)

  def initialInput(): (FieldState, GameState) = {
    /* first-only input */
    val height = sc.nextInt()
    val playerNum = sc.nextInt()
    sc.nextLine()

    /* every-turn input */
    val firstLine = sc.nextLine()
    val width = firstLine.length
    val fieldState = new FieldState(height, width)
    fieldState.squaresParseInputer("." + firstLine, 1)
    for(y <- 2 to height){
      val input = "." + sc.nextLine()
      fieldState.squaresParseInputer(input, y)
    }

    val players = new Array[Human](playerNum)
    val enemies = new Array[Human](playerNum)
    for(i <- 0 until playerNum) {
      players(i) = new Human(sc.nextInt(), sc.nextInt())
    }
    for(i <- 0 until playerNum) {
      enemies(i) = new Human(sc.nextInt(),sc.nextInt())
    }

    val choiceNum = sc.nextInt()
    sc.nextLine()  // remove newline
    val choices = new Array[Command](choiceNum)
    for(i <- 0 until choiceNum) {
      choices(i) =
        new Command(sc.next(), sc.nextInt(), sc.next(), sc.next())
      sc.nextLine()  // remove newline
    }
    val gameState = new GameState(players, enemies, choices)

    (fieldState, gameState)
  }

  def turnInput(fState: FieldState, gs: GameState): (FieldState, GameState) = {
    for(y <- 1 to fState.height){
      val input = "." + sc.nextLine()
      fState.squaresParseInputer(input, y)
    }

    val players = new Array[Human](gs.playerNum)
    val enemies = new Array[Human](gs.playerNum)
    for(i <- 0 until gs.playerNum) {
      players(i) = new Human(sc.nextInt(), sc.nextInt())
    }
    for(i <- 0 until gs.playerNum) {
      enemies(i) = new Human(sc.nextInt(),sc.nextInt())
    }

    val choiceNum = sc.nextInt()
    sc.nextLine()  // remove newline
    val choices = new Array[Command](choiceNum)
    for(i <- 0 until choiceNum) {
      choices(i) =
        new Command(sc.next(), sc.nextInt(), sc.next(), sc.next())
      sc.nextLine()  // remove newline
    }

    val newGameState = new GameState(players, enemies, choices)
    (fState, newGameState)
  }

  @tailrec
  def everyTurnProcess(oldFieldState: FieldState, oldGameState: GameState): (FieldState, GameState) = {
    val (fState, gs) = turnInput(oldFieldState, oldGameState)

    printer(gs.choices(gs.choiceNum / 2))
    everyTurnProcess(fState, gs)
  }


  /* main process */
  def main(args: Array[String]){
    val (fState, gs) = initialInput()
    printer(gs.choices(gs.choiceNum / 2))  // temporal output

    // game loop
    everyTurnProcess(fState, gs)
  }
}

// Console.err.println("Debug messages...")
