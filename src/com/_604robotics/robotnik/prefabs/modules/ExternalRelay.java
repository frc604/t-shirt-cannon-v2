package com._604robotics.robotnik.prefabs.modules;

import com._604robotics.robotnik.Action;
import com._604robotics.robotnik.Module;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

public class ExternalRelay extends Module {

  private final Relay relay = new Relay(0);

  public ExternalRelay() {
    super(ExternalRelay.class);
    setDefaultAction(off);
  }

  public class On extends Action {

    public On() {
      super(ExternalRelay.this, On.class);
    }

    @Override
    public void run() {
      relay.set(Value.kOn);
    }
  }

  public class Off extends Action {

    public Off() {
      super(ExternalRelay.this, Off.class);
    }

    @Override
    public void run() {
      relay.set(Value.kOff);
    }
  }

  public On on = new On();
  public Off off = new Off();
}
