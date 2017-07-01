object Entities {
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

  sealed abstract class Action(val code: String)
  case object MoveBuild extends Action("MOVE&BUILD")

  def stringToCommand(com: String): Action = {
    com match {
      case "MOVE&BUILD" => MoveBuild
      case _ => throw new Exception("Not Command String")
    }
  }
}
