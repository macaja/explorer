package explorer

final case class Pose(location: Coordinates, orientation: Direction) {
  def move: Pose = {
    val newLocation = orientation match {
      case N => location.moveNorth
      case S => location.moveSouth
      case E => location.moveEast
      case W => location.moveWest
    }
    this.copy(location = newLocation)
  }
  def turnLeft: Pose = this.copy(orientation = orientation.left)
  def turnRight: Pose = this.copy(orientation = orientation.right)
}
