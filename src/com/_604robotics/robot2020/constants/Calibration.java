package com._604robotics.robot2020.constants;

import com._604robotics.robotnik.prefabs.auto.TrackerConstants;
import com._604robotics.robotnik.utils.annotations.Unreal;
import com._604robotics.robotnik.utils.annotations.Untested;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;

public class Calibration {

  public static final double TELEOP_DRIVE_DEADBAND = 0.3;
  public static final double TELEOP_MANIP_DEADBAND = 0.2;
  public static final double TELEOP_FACTOR = -1;

  @Unreal("Values must be updated when the real robot is designed")
  public static final double DRIVE_MOVE_PID_P = 0.0045;

  @Unreal("Values must be updated when the real robot is designed")
  public static final double DRIVE_MOVE_PID_I = 0;

  @Unreal("Values must be updated when the real robot is designed")
  public static final double DRIVE_MOVE_PID_D = 0.00;

  public static final double DRIVE_MOVE_PID_MAX = 0.85; // 0.7
  public static final double DRIVE_MOVE_TOLERANCE = 100;
  public static final double SLOW_ROTATION_MODIFIER = 0.66;

  @Unreal("Values must be updated when the real robot is designed")
  public static final double DRIVE_ROTATE_PID_P = 0.003;

  public static final double DRIVE_ROTATE_PID_I = 0;

  @Unreal("Values must be updated when the real robot is designed")
  public static final double DRIVE_ROTATE_PID_D = 0.01;

  public static final double DRIVE_ROTATE_PID_MAX = 0.4;
  public static final double DRIVE_ROTATE_TOLERANCE = 80;

  public static final double DRIVE_PID_AFTER_TIMING = 0.75;
  public static final double DRIVE_PID_SAMPLE_RATE = 0.01;

  public static final double DRIVE_MOTOR_RAMP = 4;

  /* Arm Calibration */
  @Unreal("Values must be updated when robot is designed")
  public static final class Arm {
    public static final double CLICKS_FULL_ROTATION =
        10240; // One rotation of the encoder in clicks

    public static final double LOW_SETPOINT = 4116; // Ready to intake from front
    public static final double STOW_SETPOINT = 0 - 3; // Starting position
    public static final double OUTPUT_SETPOINT = 1182; // Output from front TODO: be higher
    public static final double ROCKET_SETPOINT = 2606;
    public static final double VERTICAL_POSITION = 440; // The arm is straight up
    public static final double HORIZONTAL_POSITION =
        1700; // The arm is horizontally backwards NOTE: Did not modify with HARDSTOP b.c. it works
    // still
    public static final double BACK_ROCKET_SETPOINT = -985;
    public static final double BACK_CARGO_SETPOINT = -377;

    public static final double HARDSTOP_CLOSE_POSITION = -25;
    // HORIZONTAL_POSITION = Arm balance point - (CLICKS_FULL_ROTATION / 4)

    public static final double MIN_ENCODER_VAL = 0; // The lowest value the encoder can have
    public static final double MAX_ENCODER_VAL = 0; // The largest value the encoder can have

    public static final double kP = 0.0004;
    public static final double kI = 0;
    public static final double kD = 0.00025 * 0.02; // Multiplying by 0.02 to time parameterize it.
    public static final double kF = -0.709;
    // -0.05

    public static final double SCALE_JOYSTICK = 0.6; // Multiply the input joystick by this
  }

  public static final class Drive {
    public static final boolean GYRO_REVERSED = false;
    public static final double TRACK_WIDTH = 0.5969;
    public static final double WHEEL_DIAMETER = 0.127;
    public static final double ENCODER_CPR = 245;
    public static final double DISTANCE_PER_CLICK =
        (WHEEL_DIAMETER * Math.PI) / (double) ENCODER_CPR;
  }

  public static final class Auto {
    public static final double RAMSETE_B = 2.0;
    public static final double RAMSETE_ZETA = 0.7;
    public static final double KS_VOLTS = 0.933;
    public static final double KV_VOLT_SECONDS_PER_METER = 2.58;
    public static final double KA_VOLT_SECONDS_SQUARED_PER_METER = 0.586;
    public static final double KP_DRIVE_VELCOTIY = 1.5;

    public static final double MAX_SPEED_METERS_PER_SECOND = 10; // 10
    public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 2; // 1.5
    public static final double MAX_CENTRIPETAL_ACCELERATION_RADIANS_PER_SECOND_SQUARED = 2; // 1.5

    public static final TrackerConstants TRACKER_CONSTANTS =
        new TrackerConstants(
            new SimpleMotorFeedforward(
                KS_VOLTS, KV_VOLT_SECONDS_PER_METER, KA_VOLT_SECONDS_SQUARED_PER_METER),
            KP_DRIVE_VELCOTIY,
            RAMSETE_B,
            RAMSETE_ZETA,
            MAX_SPEED_METERS_PER_SECOND,
            MAX_ACCELERATION_METERS_PER_SECOND_SQUARED);
  }

  public static final double HATCH_PUSH_TIME = 0.5;
  public static final double HATCH_BACK_TIME = 0.5;
  public static final double HATCH_PULL_TIME = 0.5;
  public static final double HATCH_RELEASE_TIME = 0.5;

  /* Marionette */
  public static final boolean AUTO_APPEND_TIMESTAMP = true;

  public static final String CUSTOM_PRIMARY = "single00.switchLeft.marionette";
  public static final String CUSTOM_SECONDARY = "half00.switchRight.marionette";

  @Untested("Currently matches value in PixyMon")
  public static final int PIXY_MAX_BLOCKS = 20; // May or may not have to match PixyMon settings...

  // :5800 includes framerate and crosshair :5802 does not :5801 is the control interface
  public static final String LIMELIGHT_URL = "http://10.6.4.101:5802";
  public static final int LIMELIGHT_FPS = 90; // Default: Uncapped (Normally around 90)
  public static final int LIMELIGHT_RES_X = 320; // Default: 320
  public static final int LIMELIGHT_RES_Y = 240; // Default: 240

  @Unreal("Needs to be measured")
  public static final double LIMELIGHT_HEIGHT =
      24.5; // Height of limelight from the ground in inches

  @Unreal("Needs to be measured")
  public static final double LIMELIGHT_ANGLE =
      80; // Angle of the limelight relative to the plane of the robot in degrees
  // If negative, pointed down, positive is pointed up
  @Unreal("Needs to be measured")
  public static final double TARGET_HEIGHT =
      28; // Height of the center of the vision target in inches

  public static final double LIMELIGHT_ANGLE_TOLERANCE = 0.005;
  public static final double LIMELIGHT_DIST_TOLERANCE = 1;
  public static final int LIMELIGHT_DRIVER_PIPE =
      9; // The pipeline to use for driver usage, NOT tracking
  public static final int LIMELIGHT_VISION_PIPE = 0; // Pipeline for vision tracking by default
}
