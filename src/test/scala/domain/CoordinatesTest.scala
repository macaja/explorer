package domain

import org.scalatest.funsuite.AnyFunSuite

class CoordinatesTest extends AnyFunSuite {
  test("should have the correct x and y") {
    val coordinates = Coordinates(1, 2)
    assert(coordinates.x == 1)
    assert(coordinates.y == 2)
  }
  test("should up on the y coordinate") {
    val coordinates = Coordinates(1, 2)
    assert(Coordinates.up(coordinates) == Coordinates(1, 3))
  }
  test("should down on the y coordinate") {
    val coordinates = Coordinates(1, 2)
    assert(Coordinates.down(coordinates) == Coordinates(1, 1))
  }
  test("should right on the x coordinate") {
    val coordinates = Coordinates(1, 2)
    assert(Coordinates.right(coordinates) == Coordinates(2, 2))
  }
  test("should left on the x coordinate") {
    val coordinates = Coordinates(1, 2)
    assert(Coordinates.left(coordinates) == Coordinates(0, 2))
  }
}
