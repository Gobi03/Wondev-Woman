object FieldPackage {
  import CommonPackage.Point
  import Entities._
  import GameGadgetsPackage.Command

  trait FieldStateTrait {
    // field size
    val height: Int
    val width: Int

    // methods
    def apply(point: Point): Square
    def copyField(): Array[Array[Square]]
    def squaresParseInputer(suqaresStr: String, row: Int): Unit
  }

  class FieldState(val height: Int, val width:Int)
      extends FieldStateTrait {
    // private values
    protected val field = Array.ofDim[Square](height+2, width+2)

    // field の初期化
    for(y <- 0 to height+1; x <- 0 to width+1)
      field(y)(x) = Wall

    // methods
    def apply(p: Point): Square = (field(p.y)(p.x))

    def copyField(): Array[Array[Square]] = field.clone

    def squaresParseInputer(squaresStr: String, row: Int): Unit = {
      for(x <- 1 to width){
        val square = stringToSquare(squaresStr(x).toString)
        field(row)(x) = square
      }
    }

  }
}
