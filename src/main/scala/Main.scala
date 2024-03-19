import cats.effect.IOApp
import effects.FileProcessor
import cats.effect.{ExitCode, IO}
import parser.ExplorerParser
import dtos.InputFile

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    FileProcessor
      .readLines(s"src/resources/${args.headOption.getOrElse("explorers-input.txt")}")
      .map(ExplorerParser.parseLines)
      .flatMap {
        case Left(error) =>
          IO.println(error) >> IO.pure(ExitCode.Error)
        case Right(inputFile) =>
          IO.pure(InputFile.process(inputFile).foreach(println)) >> IO.pure(ExitCode.Success)
      }
  }
}
