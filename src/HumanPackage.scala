object HumanPackage {
  trait HumanTrait {
    val x: Int
    val y: Int
  }

  class Human(val x: Int, val y: Int) extends HumanTrait {

  }
}
