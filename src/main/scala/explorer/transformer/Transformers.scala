package explorer.transformer

import explorer.parser.InputFile
import explorer.domain.Robot
import explorer.domain.ExplorationArea

object Transformers {
  def transformInputToRobot(inputFile: InputFile): List[Robot] = {
    inputFile.robotInputData.map(robotInputData => {
      val explorationArea = ExplorationArea(inputFile.upperRightCoordinates)
      Robot(robotInputData.startingPose, robotInputData.instructions, explorationArea)
    })
  }
}
