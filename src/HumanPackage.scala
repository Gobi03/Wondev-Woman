object HumanPackage {
  import CommonPackage.{Point}

  trait HumanTrait {
    val x: Int
    val y: Int
    val coord: Point
  }

  class Human(val x: Int, val y: Int) extends HumanTrait {
    val coord = new Point(x, y)

    // constructors
    def this(p: Point) = this(p.x, p.y)
  }
}
