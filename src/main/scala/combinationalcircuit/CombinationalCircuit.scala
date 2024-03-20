package combinationalcircuit

import chisel3._
// _root_ disambiguates from package chisel3.util.circt if user imports chisel3.util._

// making a multiplexer
class CombinationalCircuit extends Module{
  val sel, in0, in1 = IO(Input(Bool()))
  val out = IO(Output(Bool()))
  val wire = Wire(Bool())

  wire := (sel & in1) | (~sel & in0)
  out := wire
}
