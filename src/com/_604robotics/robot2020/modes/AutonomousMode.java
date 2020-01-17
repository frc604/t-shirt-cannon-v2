package com._604robotics.robot2020.modes;

import com._604robotics.robot2020.Robot2020;
import com._604robotics.robotnik.Coordinator;
import com._604robotics.robotnik.Logger;

public class AutonomousMode extends Coordinator {
  private static final Logger logger = new Logger(AutonomousMode.class);

  private final com._604robotics.robot2020.Robot2020 robot;

  private Coordinator selectedModeMacro;
  private TeleopMode selectedTeleopMode;

  public String primaryFileName;
  public String secondaryFileName;

  public static enum PathFollowSide {
    LEFT,
    RIGHT
  }

  public AutonomousMode(Robot2020 robot) {
    this.robot = robot;
  }

  @Override
  public void begin() {
    // Filename is prefixed in MarionetteDriver
    primaryFileName = robot.dashboard.marionetteFile.get();
    secondaryFileName = "";

    switch (robot.dashboard.autonMode.get()) {
      case MANUAL:
        selectedModeMacro = robot.teleopMode;
        break;
      case OFF:
      default:
        selectedModeMacro = null;
        selectedTeleopMode = null;
        break;
    }

    if (selectedModeMacro != null) {
      selectedModeMacro.start();
    }
  }

  @Override
  public boolean run() {
    if (selectedModeMacro != null) {
      return selectedModeMacro.execute();
    }

    return false;
  }

  @Override
  public void end() {
    if (selectedModeMacro != null) {
      selectedModeMacro.stop();
    }
  }
}
