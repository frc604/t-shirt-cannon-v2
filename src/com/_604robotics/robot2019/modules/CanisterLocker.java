package com._604robotics.robot2019.modules;

import com._604robotics.robot2019.constants.Ports;
import com._604robotics.robotnik.Action;
import com._604robotics.robotnik.Module;
import com._604robotics.robotnik.Output;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CanisterLocker extends Module {

    DoubleSolenoid locker = new DoubleSolenoid(Ports.CANISTER_LOCKER_A, Ports.CANISTER_LOCKER_B);

    public Output<Boolean> CanisterLocked;

    public CanisterLocker() {
        super(CanisterLocker.class);

        CanisterLocked = addOutput("CanisterLocked", () -> lock.isRunning());

        setDefaultAction(unlock);
    }

    public class Lock extends Action {

        public Lock() {
            super(CanisterLocker.this, Lock.class);
        }

        @Override
        public void run() {
            locker.set(Value.kForward);
        }


    }

    public class Unlock extends Action {

        public Unlock() {
            super(CanisterLocker.this, Unlock.class);
        }

        @Override
        public void run() {
            locker.set(Value.kReverse);
        }
    }

    public Lock lock = new Lock();
    public Unlock unlock = new Unlock();

}
