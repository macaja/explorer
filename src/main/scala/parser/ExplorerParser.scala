package parser

import domain.Coordinates
import domain.Instruction
import domain.L
import domain.R
import domain.M
import domain.N
import domain.S
import domain.E
import domain.W
import cats.syntax.traverse._
import domain.Pose
import domain.Direction

final case class InputFile(upperRightCoordinates: Coordinates, robotInputData: List[RobotInputData])

final case class RobotInputData(startingPose: Pose, instructions: List[Instruction])

object ExplorerParser {
  def parseLines(lines: List[String]) = parsePartLines(lines.map(_.split(" ").toList))

  private[parser] def parsePartLines(parts: List[List[String]]): Either[String, InputFile] = {
    for {
      upperRightCoordinates <- parseCoordinates(parts.headOption.getOrElse(List.empty))
      robotInputData        <- parseRobotInputData(parts.drop(1))
    } yield InputFile(upperRightCoordinates, robotInputData)
  }

  private[parser] def parseCoordinates(list: List[String]): Either[String, Coordinates] = {
    list.map(_.toIntOption).sequence.flatMap(Coordinates.fromList).toRight(s"Invalid coordinates: ${list.toString()}")
  }

  private[parser] def parseStartingPose(list: List[String]): Either[String, Pose] = {
    for {
      c <- parseCoordinates(list.take(2))
      d <- list
        .lift(2)
        .flatMap(_.headOption)
        .map(parseDirection)
        .getOrElse(Left(s"Invalid direction: ${list.toString()}"))
    } yield Pose(c, d)
  }

  private[parser] def parseRobotInputData(data: List[List[String]]): Either[String, List[RobotInputData]] = {
    data.grouped(2).toList.traverse { pair =>
      pair match {
        case startingPositionText :: instructions :: Nil =>
          parseRobotInputDataItem(startingPositionText, instructions)
        case _ =>
          Left("Invalid input format")
      }
    }
  }

  private[parser] def parseRobotInputDataItem(
    startinPositionText: List[String],
    instructions: List[String]): Either[String, RobotInputData] = {
    for {
      startingPosition <- parseStartingPose(startinPositionText)
      instructions     <- parseInstructions(instructions.headOption.getOrElse(""))
    } yield RobotInputData(startingPosition, instructions)
  }

  private[parser] def parseInstructions(str: String): Either[String, List[Instruction]] = {
    str.toList.traverse(parseInstruction)
  }

  private[parser] def parseInstruction(c: Char): Either[String, Instruction] = {
    c match {
      case 'L' => Right(L)
      case 'R' => Right(R)
      case 'M' => Right(M)
      case _ => Left(s"Invalid instruction: ${c.toString()}")
    }
  }

  private[parser] def parseDirection(c: Char): Either[String, Direction] = {
    c match {
      case 'N' => Right(N)
      case 'S' => Right(S)
      case 'E' => Right(E)
      case 'W' => Right(W)
      case _ => Left(s"Invalid direction: ${c.toString()}")
    }
  }

}
