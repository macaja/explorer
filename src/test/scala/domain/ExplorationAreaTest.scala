package domain

import org.scalatest.funsuite.AnyFunSuite

class ExplorationAreaTest extends AnyFunSuite {
  test("isWithinBounds") {
    val explorationArea = ExplorationArea(Coordinates(5, 5))
    assert(explorationArea.isWithinBounds(Coordinates(0, 0)) == WhinInBounds)
    assert(explorationArea.isWithinBounds(Coordinates(5, 5)) == WhinInBounds)
    assert(explorationArea.isWithinBounds(Coordinates(6, 5)) == OutOfBounds)
    assert(explorationArea.isWithinBounds(Coordinates(5, 6)) == OutOfBounds)
    assert(explorationArea.isWithinBounds(Coordinates(-1, 5)) == OutOfBounds)
    assert(explorationArea.isWithinBounds(Coordinates(5, -1)) == OutOfBounds)
  }
}
