package domain

import org.scalatest.funsuite.AnyFunSuite
import domain._

class DirectionTest extends AnyFunSuite {
  test("toString") {
    assert(N.toString() == "N")
    assert(S.toString() == "S")
    assert(E.toString() == "E")
    assert(W.toString() == "W")
  }
  test("left") {
    assert(Direction.left(N) == W)
    assert(Direction.left(S) == E)
    assert(Direction.left(E) == N)
    assert(Direction.left(W) == S)
  }

  test("right") {
    assert(Direction.right(N) == E)
    assert(Direction.right(S) == W)
    assert(Direction.right(E) == S)
    assert(Direction.right(W) == N)
  }
}
