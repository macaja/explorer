import cats.effect.IOApp
import explorer.effects.FileProcessor
import cats.effect.{ExitCode, IO}
import explorer.transformer.Transformers
import explorer.domain.Robot

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    FileProcessor
      .readLines(s"src/resources/${args.headOption.getOrElse("explorers-input.txt")}")
      .map {
        case Right(inputFile) =>
          val robots = Transformers.transformInputToRobot(inputFile)
          robots.foreach(robot => {
            val finalPosition = Robot.navigateArea(robot)
            println(s"${finalPosition.pose.location.x.toString()} ${finalPosition.pose.location.y
              .toString()} ${finalPosition.pose.orientation.toString()}")
          })
          ExitCode.Success
        case Left(error) =>
          println(error)
          ExitCode.Error
      }
}
