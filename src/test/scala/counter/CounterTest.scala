package counter

import chisel3._
import chisel3.simulator.EphemeralSimulator._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class CounterTest extends AnyFreeSpec with Matchers {
  "count and wrap around back to zero" in {
    simulate(new Counter) { c =>
      c.out.expect(0.U)
      c.clock.step()
      c.out.expect(1.U)
      c.clock.step()
      c.out.expect(2.U)
      c.clock.step()
      c.out.expect(0.U)
    }
  }
}
