package transformer

import parser.InputFile
import domain.Robot
import domain.ExplorationArea

object Transformer {
  def transformInputToRobot(inputFile: InputFile): List[Robot] = {
    inputFile.robotInputData.map(robotInputData => {
      val explorationArea = ExplorationArea(inputFile.upperRightCoordinates)
      Robot(robotInputData.startingPose, robotInputData.instructions, explorationArea)
    })
  }
}
