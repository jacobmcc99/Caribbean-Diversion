package com.elevenfiftyfive.caribbeandiversion.model;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Random;

public class Crew extends Utility {


    private TaskCollection<Repair> repairs;
    private TaskCollection<SetupCannon> setups;

    public Crew(int quality,String Key) {
        super(quality,Key);

        repairs = new TaskCollection<Repair>();
        setups = new TaskCollection<SetupCannon>();
    }

    public boolean hasRepaired(String targetKey) {
        return repairs.has(targetKey);
    }

    public boolean hasSetup(String targetKey) {
        return setups.has(targetKey);
    }

    public Utility applySetup(Utility targetUtility) {
        return setups.applyTask(this, targetUtility);
    }

    public Utility applyRepair(Utility targetUtility) {
        return repairs.applyTask(this, targetUtility);
    }

    public void startRepair(String targetKey) {
        // end whatever task they are currently doing
        repairs.start(new Repair(20 - (this.getQuality() / 10), targetKey));
    }

    // attempt the ending of the current tasks
    public void finishCurrent() {
        repairs.attemptCurrentCompletetion();
        setups.attemptCurrentCompletetion();
    }

    public void startSetupCannon(String targetKey) {
        setups.start(new SetupCannon(20 - (this.getQuality() / 10), targetKey));
    }

    public HashMap<String, Repair> getCompleteRepairs() {
        return repairs.getCompleteTasks();
    }

    public boolean isIdle() {
        return (getCurrent() == null);
    }

    public Task getCurrent() {
        if (setups.getCurrent() != null) {
            return setups.getCurrent();
        }

        return repairs.getCurrent();
    }

    public HashMap<String, SetupCannon> getCompleteSetups() {
        return setups.getCompleteTasks();
    }

}