object HumanPackage {
  import CommonPackage.{Point}
  import Entities._

  trait HumanTrait {
    val x: Int
    val y: Int
    val coord: Point
  }

  class Human(val x: Int, val y: Int) extends HumanTrait {
    val coord = new Point(x, y)

    def move(dir: Direction): Human = new Human(this.coord + dir)
    def moveBack(dir: Direction): Human = new Human(this.coord - dir)

    // constructors
    def this(p: Point) = this(p.x, p.y)
  }
}
