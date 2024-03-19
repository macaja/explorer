package domain

import org.scalatest.funsuite.AnyFunSuite
import domain._

class PoseTest extends AnyFunSuite {
  test("toString") {
    assert(Pose(Coordinates(1, 2), N).toString == "1 2 N")
    assert(Pose(Coordinates(3, 4), S).toString == "3 4 S")
  }
  test("move") {
    assert(Pose.move(Pose(Coordinates(1, 2), N)) == Pose(Coordinates(1, 3), N))
    assert(Pose.move(Pose(Coordinates(1, 2), E)) == Pose(Coordinates(2, 2), E))
    assert(Pose.move(Pose(Coordinates(1, 2), S)) == Pose(Coordinates(1, 1), S))
    assert(Pose.move(Pose(Coordinates(1, 2), W)) == Pose(Coordinates(0, 2), W))
  }
  test("turnLeft") {
    assert(Pose.turnLeft(Pose(Coordinates(1, 2), N)) == Pose(Coordinates(1, 2), W))
    assert(Pose.turnLeft(Pose(Coordinates(1, 2), E)) == Pose(Coordinates(1, 2), N))
    assert(Pose.turnLeft(Pose(Coordinates(1, 2), S)) == Pose(Coordinates(1, 2), E))
    assert(Pose.turnLeft(Pose(Coordinates(1, 2), W)) == Pose(Coordinates(1, 2), S))
  }
  test("turnRight") {
    assert(Pose.turnRight(Pose(Coordinates(1, 2), N)) == Pose(Coordinates(1, 2), E))
    assert(Pose.turnRight(Pose(Coordinates(1, 2), E)) == Pose(Coordinates(1, 2), S))
    assert(Pose.turnRight(Pose(Coordinates(1, 2), S)) == Pose(Coordinates(1, 2), W))
    assert(Pose.turnRight(Pose(Coordinates(1, 2), W)) == Pose(Coordinates(1, 2), N))
  }
}
