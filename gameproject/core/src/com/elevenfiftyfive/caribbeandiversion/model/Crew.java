package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Random;

public class Crew extends Utility {

    private TaskCollection<Repair> repairs;
    private TaskCollection<SetupCannon> setups;
    public Crew(int quality) {
        super(quality);

        repairs = new TaskCollection<Repair>();
        setups = new TaskCollection<SetupCannon>();
    }

    public void startRepair(String targetKey) {

        repairs.add(new Repair(20 - (this.getQuality() / 10), targetKey));

    }

    public void startSetupCannon(String targetKey) {

        setups.add(new SetupCannon(20 - (this.getQuality() / 10), targetKey));

    }

}