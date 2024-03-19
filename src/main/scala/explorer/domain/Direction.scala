package explorer.domain

sealed trait Direction {
  override def toString: String = this match {
    case N => "N"
    case E => "E"
    case S => "S"
    case W => "W"
  }
}

case object N extends Direction
case object S extends Direction
case object E extends Direction
case object W extends Direction

object Direction {
  def left(direction: Direction): Direction = direction match {
    case N => W
    case S => E
    case E => N
    case W => S
  }
  def right(direction: Direction): Direction = direction match {
    case N => E
    case S => W
    case E => S
    case W => N
  }
}
