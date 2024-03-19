package domain

import org.scalatest.funsuite.AnyFunSuite

class DirectionTest extends AnyFunSuite {
  test("left") {
    assert(domain.Direction.left(domain.N) == domain.W)
    assert(domain.Direction.left(domain.S) == domain.E)
    assert(domain.Direction.left(domain.E) == domain.N)
    assert(domain.Direction.left(domain.W) == domain.S)
  }

  test("right") {
    assert(domain.Direction.right(domain.N) == domain.E)
    assert(domain.Direction.right(domain.S) == domain.W)
    assert(domain.Direction.right(domain.E) == domain.S)
    assert(domain.Direction.right(domain.W) == domain.N)
  }
}
