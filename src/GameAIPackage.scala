object GameAIPackage {
  import CommonPackage._
  import Entities._
  import GameGadgetsPackage.Command
  import FieldPackage.FieldState
  import GameStatePackage.GameState
  import HumanPackage.{Human}

  import scala.annotation.tailrec

  trait GameAITrait {
    val onThreeWeight = 100  // ターンのスコアを獲得できるか
    val numOfArroundThreeWeight = 30
    val numOfArroundSpaceWeight = 30

    def evaluate(): Command
  }

  class GameAI(fState: FieldState, gs: GameState)
                  extends GameAITrait {
    private val field: Array[Array[Square]] = fState.copyField

    /* methods */
    def takePlayer(com: Command): Human = gs.players(com.index)

    def build(p: Point): Unit = {
      field(p.y)(p.x) = incrSquare(field(p.y)(p.x))
    }
    def unbuild(p: Point): Unit = {
      field(p.y)(p.x) = decrSquare(field(p.y)(p.x))
    }

    def runCommand(com: Command): Unit = {
      com.action match {
        case MoveBuild =>
          gs.players(com.index) = gs.players(com.index).move(com.dir1)
          build(gs.players(com.index).coord)
      }
    }

    def takeFieldSquare(pos: Point): Square = field(pos.y)(pos.x)

    def makeArroundSquareList(pos: Point): List[Square] = {
      val res = new Array[Square](8)
      var i = 0
      for(volp <- List((0,1),(1,0),(0,-1),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1))) {
        val nowp: Point = pos + Point(volp._1, volp._2)
        res(i) = takeFieldSquare(nowp)
        i += 1
      }
      res.toList
    }

    def undoCommand(com: Command): Unit = {
      com.action match {
        case MoveBuild =>
          unbuild(gs.players(com.index).coord)
          gs.players(com.index) = gs.players(com.index).moveBack(com.dir1)
      }
    }

    def isOnThreeEval(pl: Human): Double = {
      field(pl.y)(pl.x) match {
        case Three => 1.0
        case _ => 0.0
      }
    }
    def numOfArroundThreeEval(player: Human): Double = {
      val pos: Point = player.coord
      var cnt = 0.0
      for(e <- makeArroundSquareList(pos)) {
        e match {
          case Three => cnt += 1.0
          case _ => ()
        }
      }
      val res = cnt / 8
      res
    }
    def numOfArroundSpaceEval(player: Human): Double = {
      val pos: Point = player.coord
      var cnt = 0.0
      for(e <- makeArroundSquareList(pos)) {
        e match {
          case Wall | Four => ()
          case _ => cnt += 1.0
        }
      }
      val res = cnt / 8
      res
    }

    /* evaluators */
    def loopEval(choices: List[Command], preScore: Double, res: Option[Command]): Option[Command] = {
      choices match {
        case Nil => res
        case command :: rest =>
          runCommand(command)

          val player = takePlayer(command)

          val score: Double =
            isOnThreeEval(player) * onThreeWeight +
              numOfArroundThreeEval(player) * numOfArroundThreeWeight +
              numOfArroundSpaceEval(player) * numOfArroundSpaceWeight

          undoCommand(command)

          if(score > preScore)
            loopEval(rest, score, Some(command))
          else
            loopEval(rest, preScore, res)
      }
    }

    def evaluate(): Command = {
      loopEval(gs.choices.toList, -(1e9).toDouble, None) match{
        case Some(x) => x
        case None => throw new Exception("Mistook to evaluate commands")
      }
    }
  }
}
