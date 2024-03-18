package explorer

sealed trait IsWhithinBounds

case object WhininBounds extends IsWhithinBounds
case object OutOfBounds extends IsWhithinBounds

trait RectangularArea {
  val lowerLeftCoordinates: Coordinates
  val upperRightCoordinates: Coordinates
  def isWithinBounds(coordinates: Coordinates): IsWhithinBounds = {
    if (coordinates.x >= 0 && coordinates.x <= upperRightCoordinates.x && coordinates.y >= 0 && coordinates.y <= upperRightCoordinates.y) {
      WhininBounds
    } else {
      OutOfBounds
    }
  }
}

final case class ExplorationArea(upperRightCoordinates: Coordinates) extends RectangularArea {
  val lowerLeftCoordinates = Coordinates(0, 0)
}
object ExplorationArea {
  def isValid(explorationArea: ExplorationArea): Boolean = {
    explorationArea.upperRightCoordinates.x > 0 && explorationArea.upperRightCoordinates.y > 0
  }
}
