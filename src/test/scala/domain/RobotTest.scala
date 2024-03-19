package domain

import org.scalatest.funsuite.AnyFunSuite

class RobotTest extends AnyFunSuite {
  test("navigateArea") {
    val robot = Robot(Pose(Coordinates(1, 2), N), List(L, M, L, M, L, M, L, M, M), ExplorationArea(Coordinates(5, 5)))
    val expected =
      Robot(Pose(Coordinates(1, 3), N), List(L, M, L, M, L, M, L, M, M), ExplorationArea(Coordinates(5, 5)))
    assert(Robot.navigateArea(robot) == expected)
  }
}
