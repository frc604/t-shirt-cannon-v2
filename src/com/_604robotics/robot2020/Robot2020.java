package com._604robotics.robot2020;

import com._604robotics.robot2020.constants.Ports;
import com._604robotics.robot2020.modes.*;
import com._604robotics.robot2020.modules.*;
import com._604robotics.robot2020.systems.*;
import com._604robotics.robotnik.Robot;
import com._604robotics.robotnik.prefabs.modules.*;
import edu.wpi.first.wpilibj.RobotBase;

public class Robot2020 extends Robot {

  public static void main(String[] args) {
    RobotBase.startRobot(Robot2020::new);
  }

  public final Dashboard dashboard = addModule(new Dashboard());
  public final DashboardSystem dashboardSystem =
      addSystem(DashboardSystem.class, new DashboardSystem(this));
  public final PowerMonitor powermonitor =
      addModule(new PowerMonitor(Ports.PDP_MODULE, Ports.PCM_A));
  public final ExternalPCM externalPCM = addModule(new ExternalPCM(Ports.PCM_B));

  public final Drive drive = addModule(new Drive());
  public final Arm arm = addModule(new Arm());
  public final CanisterLocker canisterLocker = addModule(new CanisterLocker());
  public final CanisterPusher canisterPusher = addModule(new CanisterPusher());
  public final ExternalRelay sprinkler = addModule(new ExternalRelay());

  public final TeleopMode teleopMode = setTeleopMode(new TeleopMode(this));
  public final AutonomousMode autonomousMode = setAutonomousMode(new AutonomousMode(this));
}
