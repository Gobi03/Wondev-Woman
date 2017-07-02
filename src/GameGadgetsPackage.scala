object GameGadgetsPackage {
  import Entities._

  class Command(val action: Action, val index: Int,
              val dir1: Direction, val dir2: Direction) {
  def this(action: String, index: Int, dir1: String, dir2: String) =
    this(stringToCommand(action), index,
    stringToDirection(dir1), stringToDirection(dir2))
  }

  // Game Output
  def printer(command: Command): Unit = {
    import command._
    println(s"${action.code} ${index} ${dir1.code} ${dir2.code}")
  }

}
