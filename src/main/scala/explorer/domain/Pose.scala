package explorer.domain

final case class Pose(location: Coordinates, orientation: Direction)

object Pose {
  def move(pose: Pose): Pose = {
    val newLocation = pose.orientation match {
      case N => Coordinates.up(pose.location)
      case S => Coordinates.down(pose.location)
      case E => Coordinates.right(pose.location)
      case W => Coordinates.left(pose.location)
    }
    new Pose(newLocation, pose.orientation)
  }
  def turnLeft(pose: Pose): Pose = new Pose(pose.location, Direction.left(pose.orientation))
  def turnRight(pose: Pose): Pose = new Pose(pose.location, Direction.right(pose.orientation))
}
