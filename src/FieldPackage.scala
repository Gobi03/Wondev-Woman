object FieldPackage {
  import Entities._

  trait FieldStateTrait {
    // field size
    val height: Int
    val width: Int

    def squaresParseInputer(suqaresStr: String, row: Int): Unit
  }

  class FieldState(val height: Int, val width:Int)
      extends FieldStateTrait {

    protected val field = Array.ofDim[Square](height+2, width+2)
    // field の初期化
    for(y <- 0 to height+1; x <- 0 to width+1)
      field(y)(x) = Wall

    def squaresParseInputer(squaresStr: String, row: Int): Unit = {
      for(x <- 1 to width){
        val square = stringToSquare(squaresStr(x).toString)
        field(row)(x) = square
      }
    }

  }
}
