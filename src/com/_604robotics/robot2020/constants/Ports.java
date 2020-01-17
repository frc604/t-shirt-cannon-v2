package com._604robotics.robot2020.constants;

import com._604robotics.robotnik.utils.annotations.Unreal;

@Unreal("Assign all ports when they are decided in design")
public class Ports {
  private Ports() {}

  /* Solenoids */
  public static final int SHIFTER_A = 0;
  public static final int SHIFTER_B = 1;

  /* Drive Motors */
  public static final int DRIVE_FRONT_LEFT_MOTOR = 2;
  public static final int DRIVE_REAR_LEFT_MOTOR = 1;
  public static final int DRIVE_FRONT_RIGHT_MOTOR = 3;
  public static final int DRIVE_REAR_RIGHT_MOTOR = 4;

  /* Arm Motors */
  public static final int ARM_FRONT_MOTOR = 7;
  public static final int ARM_REAR_MOTOR = 8;

  /* Canister Control */
  public static final int CANISTER_LOCKER_A = 2;
  public static final int CANISTER_LOCKER_B = 3;
  public static final int CANISTER_PUSHER_A = 4;
  public static final int CANISTER_PUSHER_B = 5;

  /* CAN Motors */
  public static final int PCM_A = 0;
  public static final int PCM_B = 1;
  public static final int PDP_MODULE = 0;
}
