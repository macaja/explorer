package explorer

final case class Robot(pose: Pose, explorationArea: ExplorationArea)

object Robot {
    def navigateArea(instructions: List[Instruction], robot: Robot): Robot = {
        instructions.foldLeft(robot)((robot, instruction) => {
            robot.explorationArea.isWithinBounds(robot.pose.location) match {
                case OutOfBounds => robot
                case WhininBounds => instruction match {
                    case L => new Robot(Pose.turnLeft(robot.pose), robot.explorationArea)
                    case R => new Robot(Pose.turnRight(robot.pose), robot.explorationArea)
                    case M => new Robot(Pose.move(robot.pose), robot.explorationArea)
                }
            }
        })
    }
}