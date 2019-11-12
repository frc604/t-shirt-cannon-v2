package com._604robotics.robot2019.modules;

import com._604robotics.robot2019.constants.Ports;
import com._604robotics.robotnik.Action;
import com._604robotics.robotnik.Input;
import com._604robotics.robotnik.Module;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class Arm extends Module {
    private PWMTalonSRX frontMotor;
    private PWMTalonSRX rearMotor;

    public Arm() {
        super(Arm.class);

        frontMotor = new PWMTalonSRX(Ports.ARM_FRONT_MOTOR);
        rearMotor = new PWMTalonSRX(Ports.ARM_REAR_MOTOR);


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
