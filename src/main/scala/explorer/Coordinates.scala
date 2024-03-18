package explorer

final case class Coordinates(x: Int, y: Int)

object Coordinates {
  def up(coordinates: Coordinates): Coordinates = new Coordinates(coordinates.x, coordinates.y + 1)
  def down(coordinates: Coordinates): Coordinates = new Coordinates(coordinates.x, coordinates.y - 1)
  def right(coordinates: Coordinates): Coordinates = new Coordinates(coordinates.x + 1, coordinates.y)
  def left(coordinates: Coordinates): Coordinates = new Coordinates(coordinates.x - 1, coordinates.y)
}
