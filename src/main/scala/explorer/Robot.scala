package explorer

final case class Robot(pose: Pose, explorationArea: ExplorationArea) {
  def navigateArea(instructions: List[Instruction]): Robot = {
    instructions.foldLeft(this)((robot, instruction) => {
      if (explorationArea.isWithinBounds(robot.pose.location)) {
        instruction match {
          case L => robot.copy(pose = robot.pose.turnLeft)
          case R => robot.copy(pose = robot.pose.turnRight)
          case M => robot.copy(pose = robot.pose.move)
        }
      } else {
        robot
      }
    })
  }

}
