package dtos

import domain.Instruction
import domain.Pose
import domain.Coordinates
import transformer.Transformer
import domain.Robot

final case class RobotInputData(startingPose: Pose, instructions: List[Instruction])

final case class InputFile(upperRightCoordinates: Coordinates, robotInputData: List[RobotInputData])

object InputFile {
  def process(inputFile: InputFile): List[String] = {
    val robots = Transformer.transformInputToRobot(inputFile)
    robots.map { robot =>
      val finalPosition = Robot.navigateArea(robot)
      finalPosition.pose.toString()
    }
  }
}
