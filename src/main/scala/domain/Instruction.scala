package domain

sealed trait Instruction
case object L extends Instruction
case object R extends Instruction
case object M extends Instruction
