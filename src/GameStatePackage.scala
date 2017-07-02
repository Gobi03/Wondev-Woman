object GameStatePackage {
  import Entities._
  import GameGadgetsPackage._
  import HumanPackage._

  trait GameStateTrait {
    val playerNum: Int
    val players: Array[Human]
    val enemies: Array[Human]

    val choiceNum: Int
    val choices: Array[Command]
  }

  class GameState(
    val players: Array[Human],
    val enemies: Array[Human],
    val choices: Array[Command]) extends GameStateTrait
  {
    val playerNum = players.length
    val choiceNum = choices.length
  }
}
