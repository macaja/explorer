package dtos

package dtos

import org.scalatest.funsuite.AnyFunSuite
import domain._

class InputFileTest extends AnyFunSuite {
  test("process") {
    val inputFile = InputFile(
      Coordinates(5, 5),
      List(
        RobotInputData(Pose(Coordinates(1, 2), N), List(L, M, L, M, L, M, L, M, M)),
        RobotInputData(Pose(Coordinates(3, 3), E), List(M, M, R, M, M, R, M, R, R, M))
      )
    )
    val processedInput = InputFile.process(inputFile)
    assert(processedInput.nonEmpty)
    assert(processedInput == List("1 3 N", "5 1 E"))
  }
}
