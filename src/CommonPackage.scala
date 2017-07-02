object CommonPackage {
  case class Point(val x: Int, val y: Int) {
    def +(p: Point): Point =
      new Point(this.x + p.x, this.y + p.y)
    def -(p: Point): Point =
      new Point(this.x - p.x, this.y - p.y)
  }
}
