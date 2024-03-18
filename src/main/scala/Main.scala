import explorer.ExplorationArea
import explorer.Coordinates
import explorer.Robot
import explorer.Pose
import explorer.L
import explorer.M
import explorer.N
import explorer.Instruction

object Main {
  def main(args: Array[String]): Unit = {
    val explorationArea = ExplorationArea(5, 5)
    val pose = Pose(Coordinates(1, 2), N)
    val robot = Robot(pose, explorationArea)
    val instructions: List[Instruction] = List[Instruction](L, M, L, M, L, M, L, M, M)
    val finalPosition = robot.navigateArea(instructions)
    println(finalPosition)
  }
}
