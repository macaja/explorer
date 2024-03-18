package explorer

sealed trait Direction {
  def left: Direction
  def right: Direction
}
case object N extends Direction {
  def left: Direction = W
  def right: Direction = E
}
case object S extends Direction {
  def left: Direction = E
  def right: Direction = W
}
case object E extends Direction {
  def left: Direction = N
  def right: Direction = S
}
case object W extends Direction {
  def left: Direction = S
  def right: Direction = N
}
