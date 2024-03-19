package explorer.domain

final case class Robot(pose: Pose, instructions: List[Instruction], explorationArea: ExplorationArea)

object Robot {
  def navigateArea(robot: Robot): Robot = {
    robot.instructions.foldLeft(robot)((robot, instruction) => {
      robot.explorationArea.isWithinBounds(robot.pose.location) match {
        case OutOfBounds => robot
        case WhinInBounds =>
          instruction match {
            case L => new Robot(Pose.turnLeft(robot.pose), robot.instructions, robot.explorationArea)
            case R => new Robot(Pose.turnRight(robot.pose), robot.instructions, robot.explorationArea)
            case M => new Robot(Pose.move(robot.pose), robot.instructions, robot.explorationArea)
          }
      }
    })
  }
}
