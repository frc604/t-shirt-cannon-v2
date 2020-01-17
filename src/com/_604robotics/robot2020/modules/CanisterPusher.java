package com._604robotics.robot2020.modules;

import com._604robotics.robot2020.constants.Ports;
import com._604robotics.robotnik.Action;
import com._604robotics.robotnik.Module;
import com._604robotics.robotnik.Output;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CanisterPusher extends Module {

  DoubleSolenoid pusher = new DoubleSolenoid(Ports.CANISTER_PUSHER_A, Ports.CANISTER_PUSHER_B);

  public Output<Boolean> CanisterPushing;

  public CanisterPusher() {
    super(CanisterPusher.class);

    CanisterPushing = addOutput("CanisterPushing", () -> push.isRunning());

    setDefaultAction(retract);
  }

  public class Push extends Action {

    public Push() {
      super(CanisterPusher.this, Push.class);
    }

    @Override
    public void run() {
      pusher.set(Value.kReverse);
    }
  }

  public class Retract extends Action {

    public Retract() {
      super(CanisterPusher.this, Retract.class);
    }

    @Override
    public void run() {
      pusher.set(Value.kForward);
    }
  }

  public Push push = new Push();
  public Retract retract = new Retract();
}
