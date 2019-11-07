package com._604robotics.robot2019.systems;

import com._604robotics.robot2019.constants.Calibration;
import com._604robotics.robotnik.Coordinator;

public class DashboardSystem extends Coordinator {
    private final com._604robotics.robot2019.Robot2019 robot;

    public DashboardSystem ( com._604robotics.robot2019.Robot2019 robot) {
        this.robot = robot;
    }

    @Override
    public boolean run () {
        robot.dashboard.xAccel.set(robot.drive.xAccel.get());
        robot.dashboard.yAccel.set(robot.drive.yAccel.get());
        robot.dashboard.zAccel.set(robot.drive.zAccel.get());

        //robot.dashboard.totalCurrent.set(robot.powermonitor.totalPortCurrent.get());
        
        //robot.powermonitor.initDashboardSendables();

		
		/* Controller Values */
		robot.dashboard.driverLeftStickY.set(robot.teleopMode.getDriverLeftStickY());
        
        switch( robot.dashboard.marionetteRecorder.get() ) {
            case MANUAL:
                robot.dashboard.writeFile.set(robot.dashboard.filePrefix.get() + robot.dashboard.marionetteFile.get());
                break;
            default:
                break;
        }
        
        switch( robot.dashboard.marionetteOutput.get() ) {
            case MANUAL:
                robot.dashboard.primaryReadFile.set(robot.dashboard.filePrefix.get() + robot.dashboard.marionetteFile.get());
                break;
            default:
                break;
        }

        // Leave at end of function
        return true;
    }
}
