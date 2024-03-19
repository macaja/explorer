import cats.effect.IOApp
import effects.FileProcessor
import cats.effect.{ExitCode, IO}
import parser.ExplorerParser
import dtos.InputFile
import ExplorerParser.parseLines
import InputFile.processInput

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val stringPath = s"src/resources/${args.headOption.getOrElse("explorers-input.txt")}"
    FileProcessor
      .readLines(stringPath)
      .map(parseLines)
      .flatMap {
        case Left(error) =>
          IO.println(error) >> IO.pure(ExitCode.Error)
        case Right(inputFile) =>
          IO.pure(processInput(inputFile).foreach(println)) >> IO.pure(ExitCode.Success)
      }
  }
}
