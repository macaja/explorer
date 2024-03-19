package parser

import org.scalatest.funsuite.AnyFunSuite
import parser.ExplorerParser
import domain._

class ExplorerParserTest extends AnyFunSuite {
  test("parseLines") {
    val lines = List("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM")
    val inputFile = ExplorerParser.parseLines(lines)
    assert(inputFile.isRight)
    inputFile.map(inputFile => {
      assert(inputFile.upperRightCoordinates == Coordinates(5, 5))
      assert(
        inputFile.robotInputData == List(
          RobotInputData(Pose(Coordinates(1, 2), N), List(L, M, L, M, L, M, L, M, M)),
          RobotInputData(Pose(Coordinates(3, 3), E), List(M, M, R, M, M, R, M, R, R, M))
        ))
    })
  }
  test("parsePartLines") {
    val partLines = List(List("5", "5"), List("1", "2", "N"), List("LMLMLMLMM"))
    val robotInputData = ExplorerParser.parsePartLines(partLines)
    assert(robotInputData.isRight)
    robotInputData.map(inputFile => {
      assert(inputFile.upperRightCoordinates == Coordinates(5, 5))
      assert(
        inputFile.robotInputData == List(RobotInputData(Pose(Coordinates(1, 2), N), List(L, M, L, M, L, M, L, M, M))))
    })
  }
  test("parseCoordinates") {
    val coordinates = ExplorerParser.parseCoordinates(List("5", "5"))
    assert(coordinates.isRight)
    coordinates.map(coordinates => {
      assert(coordinates == Coordinates(5, 5))
    })
  }
  test("parsePose") {
    val pose = ExplorerParser.parseStartingPose(List("1", "2", "N"))
    assert(pose.isRight)
    pose.map(pose => {
      assert(pose == Pose(Coordinates(1, 2), N))
    })
  }
}
