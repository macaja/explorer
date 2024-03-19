package domain

sealed trait IsWhithinBounds

case object WhinInBounds extends IsWhithinBounds
case object OutOfBounds extends IsWhithinBounds

trait RectangularArea {
  val lowerLeftCoordinates: Coordinates
  val upperRightCoordinates: Coordinates
  def isWithinBounds(coordinates: Coordinates): IsWhithinBounds = {
    if (coordinates.x >= 0 && coordinates.x <= upperRightCoordinates.x && coordinates.y >= 0 && coordinates.y <= upperRightCoordinates.y) {
      WhinInBounds
    } else {
      OutOfBounds
    }
  }
}

final case class ExplorationArea(upperRightCoordinates: Coordinates) extends RectangularArea {
  val lowerLeftCoordinates = Coordinates(0, 0)
}
