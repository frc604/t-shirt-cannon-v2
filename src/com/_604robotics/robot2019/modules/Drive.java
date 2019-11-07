package com._604robotics.robot2019.modules;

import com._604robotics.robot2019.constants.Ports;
import com._604robotics.robotnik.Action;
import com._604robotics.robotnik.Input;
import com._604robotics.robotnik.Module;
import com._604robotics.robotnik.Output;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends Module {
    private final VictorSP m_frontLeft = new VictorSP(Ports.DRIVE_FRONT_LEFT_MOTOR);
    private final VictorSP m_rearLeft = new VictorSP(Ports.DRIVE_REAR_LEFT_MOTOR);
    private final SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);


    private final VictorSP m_frontRight = new VictorSP(Ports.DRIVE_FRONT_RIGHT_MOTOR);
    private final VictorSP m_rearRight = new VictorSP(Ports.DRIVE_REAR_RIGHT_MOTOR);
    private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    DifferentialDrive robotDrive = new DifferentialDrive(m_left, m_right);


    private final BuiltInAccelerometer accel = new BuiltInAccelerometer();
    public final Output<Double> xAccel = addOutput("X accel",accel::getX);
    public final Output<Double> yAccel = addOutput("Y accel",accel::getY);
    public final Output<Double> zAccel = addOutput("Z accel",accel::getZ);
    //private final AnalogGyro horizGyro=new AnalogGyro(Ports.HORIZGYRO);

    public synchronized void resetSensors() {
    }


    public class Idle extends Action {
        public Idle () {
            super(Drive.this, Idle.class);
        }

        @Override
        public void run () {
            robotDrive.stopMotor();
        }
    }

    public final Action idle = new Idle();

    public class TankDrive extends Action {
        public final Input<Double> leftPower;
        public final Input<Double> rightPower;
        public final boolean squared;

        public TankDrive () {
            this(0, 0, true);
        }

        public TankDrive (boolean squared) {
            this(0, 0, squared);
        }

        public TankDrive (double defaultLeftPower, double defaultRightPower) {
            this(defaultLeftPower, defaultRightPower, true);
        }

        public TankDrive (double defaultLeftPower, double defaultRightPower, boolean squared) {
            super(Drive.this, TankDrive.class);
            // Make these inputs persistent for auton code
            leftPower = addInput("leftPower", defaultLeftPower, true);
            rightPower = addInput("rightPower", defaultRightPower, true);
            this.squared = squared;
        }

        @Override
        public void run () {
            if (leftPower.get()>1 || leftPower.get()<-1 || rightPower.get()>1 || rightPower.get()<-1) {
                System.out.println("L"+leftPower.get()+"R"+rightPower.get());
            }
            robotDrive.tankDrive(leftPower.get(), rightPower.get(), squared);
        }
    }

    public class ArcadeDrive extends Action {
        public final Input<Double> movePower;
        public final Input<Double> rotatePower;
        public final boolean squared;

        public ArcadeDrive () {
            this(0, 0, true);
        }

        public ArcadeDrive (boolean squared) {
            this(0, 0, squared);
        }

        public ArcadeDrive (double defaultMovePower, double defaultRotPower) {
            this(defaultMovePower, defaultRotPower, true);
        }

        public ArcadeDrive (double defaultMovePower, double defaultRotPower, boolean squared) {
            super(Drive.this, ArcadeDrive.class);
            // Make these inputs persistent for auton code
            movePower = addInput("movePower", defaultMovePower, true);
            rotatePower = addInput("rotatePower", defaultRotPower, true);
            this.squared = squared;
        }

        @Override
        public void run () {
            robotDrive.arcadeDrive(movePower.get(), rotatePower.get(), squared);
        }
    }

    public Drive () {
        super(Drive.class);
        robotDrive.setDeadband(0.04);
        //horizGyro.calibrate();
        setDefaultAction(idle);
    }
}
