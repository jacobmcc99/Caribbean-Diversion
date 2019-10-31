package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.HashMap;
import java.util.List;

import javax.rmi.CORBA.Util;

public abstract class Ship {

    private int x;
    private int y;
    private HashMap<String, Crew> crew;
    private HashMap<String, Cannon> cannons;


    public Ship(HashMap<String, Cannon> cannons, HashMap<String, Crew> crew) {
        this.cannons = cannons;
        this.crew = crew;
    }

    public void setCrewRepairTask(Utility target, Crew crew) {
        // check if they are operating a gun first. If they are end the shooting of that cannanon
        for (Cannon cannon : cannons.values()) {
            if (cannon.getShooterKey() ==crew.getKey()) {
                cannon.setShooterKey("");
            }
        } // now start repair
        crew.startRepair(target.getKey());
    }

    public void shootCan(Utility target, Cannon cannon, Crew crew) {

        cannon.shoot(target.getKey(),crew.getKey());
     
   }

    public void CompleteTasks()
    {
        // carray out all damages on cannons
        for (String cannonKey : cannons.keySet()) {
            // complete shots and repairs for this cannon
            for (Cannon otherCannon : cannons.values()) {
                // check if theres any shots heading for it
                if (otherCannon.getTask().getTargetKey() == cannonKey) {

                    // if so, replace the cannon with the damaged Cannon
                    Cannon damagedCannon = (Cannon)otherCannon.getTask().complete(otherCannon, cannons.get(cannonKey));
                    cannons.put(cannonKey, damagedCannon);

                    
                }
            }
        }
    }

}