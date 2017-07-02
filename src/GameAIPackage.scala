object GameAIPackage {
  import FieldPackage.FieldState
  import GameStatePackage.GameState

  trait GameAITrait {

    def runCommand(): Unit
    def undoCommand(): Boolean
  }

  class GameAI(fState: FieldState, gs: GameState)
                  extends GameAITrait {
    private val field = fState.copyField

    def apply(point: CommonPackage.Point): Entities.Square = ???
    val height: Int = ???
    def squaresParseInputer(suqaresStr: String,row: Int): Unit = ???
    val width: Int = ???

    def runCommand(): Unit = ???
    def undoCommand(): Boolean = ???
  }
}
