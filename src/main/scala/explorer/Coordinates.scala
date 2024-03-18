package explorer

final case class Coordinates(x: Int, y: Int) {
  def moveNorth: Coordinates = this.copy(y = y + 1)
  def moveSouth: Coordinates = this.copy(y = y - 1)
  def moveEast: Coordinates = this.copy(x = x + 1)
  def moveWest: Coordinates = this.copy(x = x - 1)
}
