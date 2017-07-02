object GameAIPackage {
  import Entities._
  import GameGadgetsPackage.Command
  import FieldPackage.FieldState
  import GameStatePackage.GameState

  import scala.annotation.tailrec

  trait GameAITrait {

    def runCommand(): Unit
    def undoCommand(): Boolean

    def evaluate(): Command
  }

  class GameAI(fState: FieldState, gs: GameState)
                  extends GameAITrait {
    private val field: Array[Array[Sqare]] = fState.copyField

    /* methods */
    def takePlayer(com: Command): Human = gs.players(com.index)

    def runCommand(com: Command): Unit = {
      val player = takePlayer(com)
      com.action match {
        case MoveBuild =>

      }
    }

    def undoCommand(): Boolean = ???

    /* evaluators */
    @tailrec
    def loopEval(): Option[Command] = ???

    def evaluate(): Command = {
      loopEval() match{
        case Some(command) => command
        case None => throw new Exception("Mistook to evaluate commands")
      }
    }
  }
}
