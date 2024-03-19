package domain

import org.scalatest.funsuite.AnyFunSuite

class InstructionTest extends AnyFunSuite {
  test("toString") {
    assert(domain.L.toString == "L")
    assert(domain.R.toString == "R")
    assert(domain.M.toString == "M")
  }
}
