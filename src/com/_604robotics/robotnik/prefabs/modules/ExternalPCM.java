package com._604robotics.robotnik.prefabs.modules;

import com._604robotics.robotnik.Module;
import com._604robotics.robotnik.Output;
import edu.wpi.first.wpilibj.Compressor;

public class ExternalPCM extends Module {
  private final Compressor compressor;

  public Output<Double> compCurrent;

  public ExternalPCM(int compPort) {
    super(ExternalPCM.class);

    compressor = new Compressor(compPort);

    compCurrent =
        addOutput(
            "Compressor" + Integer.toString(compPort) + "Current",
            () -> compressor.getCompressorCurrent());
  }
}
