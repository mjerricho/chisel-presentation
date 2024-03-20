import circt.stage.ChiselStage
import combinationalcircuit.CombinationalCircuit
import counter.Counter
import gettingstarted.GettingStarted


object CompileDesign extends App {
  ChiselStage.emitSystemVerilogFile(
    new CombinationalCircuit,
    Array("--target-dir", "output/"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}