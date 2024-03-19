import cats.effect.IOApp
import effects.FileProcessor
import cats.effect.{ExitCode, IO}
import transformer.Transformer
import domain.Robot
import parser.ExplorerParser

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    FileProcessor
      .readLines(s"src/resources/${args.headOption.getOrElse("explorers-input.txt")}")
      .map(ExplorerParser.parseLines)
      .map(_.fold(
        error => {
          println(error)
          ExitCode.Error
        },
        inputFile => {
          val robots = Transformer.transformInputToRobot(inputFile)
          robots.foreach(robot => {
            val finalPosition = Robot.navigateArea(robot)
            println(finalPosition.pose.toString())
          })
          ExitCode.Success
        }
      ))
}
