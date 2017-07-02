object Entities {
  // Direction
  sealed abstract class Direction(val code: String)
  case object N extends Direction("N")
  case object NE extends Direction("NE")
  case object E extends Direction("E")
  case object SE extends Direction("SE")
  case object S extends Direction("S")
  case object SW extends Direction("SW")
  case object W extends Direction("W")
  case object NW extends Direction("NW")

  def stringToDirection(dir: String): Direction = {
    dir match {
      case "N" => N
      case "NE" => NE
      case "E" => E
      case "SE" => SE
      case "S" => S
      case "SW" => SW
      case "W" => W
      case "NW" => NW
      case _ => throw new Exception("Not Direction String")
    }
  }

  // Action
  sealed abstract class Action(val code: String)
  case object MoveBuild extends Action("MOVE&BUILD")

  def stringToCommand(com: String): Action = {
    com match {
      case "MOVE&BUILD" => MoveBuild
      case _ => throw new Exception("Not Command String")
    }
  }

  // Square (field object)
  sealed abstract class Square(val code: String)
  case object Wall extends Square(".")
  case object Zero extends Square("0")
  case object One extends Square("1")
  case object Two extends Square("2")
  case object Three extends Square("3")
  case object Four extends Square("4")

  def stringToSquare(square: String): Square = {
    square match {
      case "." => Wall
      case "0" => Zero
      case "1" => One
      case "2" => Two
      case "3" => Three
      case "4" => Four
      case _ => throw new Exception("Not Square String")
    }
  }
}
