package chiselexample

import chisel3._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class ChiselExampleTest extends AnyFreeSpec with Matchers{
  "a & b & c" in {
    simulate(new ChiselExample) { c =>
      c.a.poke(true.B)
      c.b.poke(true.B)
      c.c.poke(true.B)
      c.d.poke(false.B)
      c.e.poke(true.B)
      c.f.poke(false.B)
      c.foo.poke(1.U)
      c.bar.poke(2.U)
      c.clock.step()
      c.out.expect(1.U)
    }
  }

  "d & e & f" in {
    simulate(new ChiselExample) { c =>
      c.a.poke(false.B)
      c.b.poke(true.B)
      c.c.poke(false.B)
      c.d.poke(true.B)
      c.e.poke(true.B)
      c.f.poke(true.B)
      c.foo.poke(1.U)
      c.bar.poke(2.U)
      c.clock.step()
      c.out.expect(2.U)
    }
  }
}
