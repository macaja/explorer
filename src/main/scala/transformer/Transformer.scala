package transformer

import domain.Robot
import domain.ExplorationArea
import dtos.InputFile

object Transformer {
  def transformInputToRobot(inputFile: InputFile): List[Robot] = {
    inputFile.robotInputData.map(robotInputData => {
      val explorationArea = ExplorationArea(inputFile.upperRightCoordinates)
      Robot(robotInputData.startingPose, robotInputData.instructions, explorationArea)
    })
  }
}
