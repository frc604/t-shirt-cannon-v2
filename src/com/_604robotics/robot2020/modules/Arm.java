package com._604robotics.robot2020.modules;

import com._604robotics.robot2020.constants.Ports;
import com._604robotics.robotnik.Action;
import com._604robotics.robotnik.Input;
import com._604robotics.robotnik.Module;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Arm extends Module {
  private WPI_TalonSRX frontMotor;
  private WPI_TalonSRX rearMotor;

  public Arm() {
    super(Arm.class);

    frontMotor = new WPI_TalonSRX(Ports.ARM_FRONT_MOTOR);
    rearMotor = new WPI_TalonSRX(Ports.ARM_REAR_MOTOR);

    setDefaultAction(move);
  }

  public class Move extends Action {
    public Input<Double> inputPower;

    public Move() {
      super(Arm.this, Move.class);
      inputPower = addInput("Input Power", 0.0, true);
    }

    @Override
    public void run() {
      frontMotor.set(inputPower.get());
      rearMotor.set(inputPower.get());
    }
  }

  public Move move = new Move();
}
