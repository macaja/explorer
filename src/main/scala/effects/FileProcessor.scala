package effects

import fs2.io.file.Files
import fs2.io.file.Path
import cats.effect.IO

object FileProcessor {
  def readLines(path: String): IO[List[String]] =
    Files[IO]
      .readUtf8Lines(Path(path))
      .compile
      .toList
}
