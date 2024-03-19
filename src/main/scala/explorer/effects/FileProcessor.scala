package explorer.effects

import fs2.io.file.Files
import fs2.io.file.Path
import cats.effect.IO
import explorer.parser.ExplorerParser
import explorer.parser.InputFile

object FileProcessor {
  def readLines(path: String): IO[Either[String, InputFile]] = {
    Files[IO]
      .readUtf8Lines(Path(path))
      .map(_.split(" ").toList)
      .compile
      .toList
      .map(ExplorerParser.parseLine)
  }
}
