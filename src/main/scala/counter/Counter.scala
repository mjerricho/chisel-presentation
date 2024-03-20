package counter

import chisel3._

class Counter extends Module {
  val max = 2.U
  val maxWidth = max.getWidth.W
  val out = IO(Output(UInt(maxWidth)))
  val counter = RegInit(0.U(maxWidth))
  counter := Mux(counter === max, 0.U, counter + 1.U)
  out := counter
}
