package explorer

final case class ExplorationArea(x: Int, y: Int) {
  def isWithinBounds(coordinates: Coordinates): Boolean = {
    coordinates.x >= 0 && coordinates.x <= x && coordinates.y >= 0 && coordinates.y <= y
  }
}
