package transformer

import domain.Pose
import domain.Coordinates
import domain.N
import domain.E
import domain.L
import domain.M
import domain.R
import domain.Robot
import domain.ExplorationArea
import org.scalatest.funsuite.AnyFunSuite
import dtos.RobotInputData
import dtos.InputFile

class TransformerTest extends AnyFunSuite {

  test("transform an input file into a robot") {
    val inputFile = InputFile(
      Coordinates(5, 5),
      List(
        RobotInputData(Pose(Coordinates(1, 2), N), List(L, M, L, M, L, M, L, M, M)),
        RobotInputData(Pose(Coordinates(3, 3), E), List(M, M, R, M, M, R, M, R, R, M))
      )
    )
    val expected = List(
      Robot(Pose(Coordinates(1, 2), N), List(L, M, L, M, L, M, L, M, M), ExplorationArea(Coordinates(5, 5))),
      Robot(Pose(Coordinates(3, 3), E), List(M, M, R, M, M, R, M, R, R, M), ExplorationArea(Coordinates(5, 5)))
    )
    assert(Transformer.transformInputToRobot(inputFile) == expected)
  }
}
