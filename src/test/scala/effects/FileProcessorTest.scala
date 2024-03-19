package effects

import org.scalatest.funsuite.AnyFunSuite
import effects.FileProcessor
import cats.effect.unsafe.implicits.global

class FileProcessorTest extends AnyFunSuite {
  test("readLines") {
    val path = "src/test/scala/resources/input-test.txt"
    val result = FileProcessor.readLines(path).unsafeRunSync()
    assert(result == List("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"))
  }
}
