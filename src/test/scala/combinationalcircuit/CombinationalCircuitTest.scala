package combinationalcircuit

import chisel3._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class CombinationalCircuitTest extends AnyFreeSpec with Matchers{
  "in0" in {
    simulate(new CombinationalCircuit) { c =>
      c.sel.poke(0.B)
      c.in0.poke(1.B)
      c.in1.poke(0.B)
      c.out.expect(1.B)
      c.in0.poke(0.B)
      c.out.expect(0.B)
      c.sel.poke(1.B)
      c.out.expect(0.B)
    }
  }
  "in1" in {
    simulate(new CombinationalCircuit) { c =>
      c.sel.poke(1.B)
      c.in0.poke(0.B)
      c.in1.poke(1.B)
      c.out.expect(1.B)
      c.in1.poke(0.B)
      c.out.expect(0.B)
      c.sel.poke(0.B)
      c.out.expect(0.B)
    }
  }
}
