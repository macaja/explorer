package explorer

sealed trait Direction
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
