package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.HashMap;

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
        }
        crew.startRepair(target.getKey());
    }

    /*public void shootCannon(Utility target, Cannon cannon, Crew crew) {
       // first check if this cannon has been setup
        for (Cannon can : this.cannons.values()) {
            // iterate over all tasks and check if crew member has finished setting up this task
            
        }

        cannon.shoot(target.getKey(),crew.getKey());
     
   }
*/
    public void CompleteTasks()
    {
       // complete and apply tasks
       for (String cannonKey : cannons.keySet()) {
           
       }
    }

}