object GameAIPackage {
  import GameGadgetsPackage.Command
  import FieldPackage.FieldState
  import GameStatePackage.GameState

  trait GameAITrait {

    def runCommand(): Unit
    def undoCommand(): Boolean

    def evaluate(): Option[Command]
  }

  class GameAI(fState: FieldState, gs: GameState)
                  extends GameAITrait {
    private val field = fState.copyField

    def runCommand(): Unit = ???
    def undoCommand(): Boolean = ???

    def evaluate(): Option[Command] = ???
  }
}
