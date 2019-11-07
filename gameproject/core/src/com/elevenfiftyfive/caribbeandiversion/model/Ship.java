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

    public void setRepairTask(Utility target, Crew crew) {
        // check if they are operating a gun first. If they are end the shooting of that
        // cannanon
        for (Cannon cannon : cannons.values()) {
            if (cannon.getShooterKey() == crew.getKey()) {
                cannon.setShooterKey("");
            }
        }
        crew.startRepair(target.getKey());
    }

    public HashMap<String, Crew> getAllCrew()
    {
        return crew;
    }

    public HashMap<String, Cannon> getAllCannon()
    {
        return cannons;
    }

    public Cannon getCannon(String targetKey) {
        return cannons.get(targetKey);
    }

    public Crew getCrew(String targetKey) {
        return crew.get(targetKey);
    }

    public void setSetupTask(String targetKey, Crew crew) {
        // end whatever they are doing first

        for (Cannon cannon : cannons.values()) {
            if (cannon.getShooterKey() == crew.getKey()) {
                cannon.setShooterKey("");
            }
        }
        crew.startSetupCannon(targetKey);
    }

    public void CompleteTasks() {
        // complete and apply tasks
        for (String cannonKey : cannons.keySet()) {
            for (String crewKey : crew.keySet()) {

                // check if this crew member has repaired this cannon
                if (crew.get(crewKey).hasRepaired(cannonKey)) {
                    Cannon applied = (Cannon) crew.get(crewKey).applyRepair(cannons.get(cannonKey));
                    cannons.put(cannonKey, applied);
                }

                // check if this crew member has setup this cannon
                if (crew.get(crewKey).hasSetup(cannonKey)) {
                    Cannon applied = (Cannon) crew.get(crewKey).applySetup(cannons.get(cannonKey));
                    cannons.put(cannonKey, applied);
                }

            }
        }

        // check if the crew member have repaired any other crew member
        for (String crewKey : crew.keySet()) {

            for (String otherMemberKey : crew.keySet()) {

                if (crew.get(otherMemberKey).hasRepaired(crewKey)) {
                    Crew applied = (Crew) crew.get(otherMemberKey).applyRepair(crew.get(crewKey));
                    crew.put(crewKey, applied);
                }
            }

        }

        // complete current tasks
        for (String key : crew.keySet()) {
           crew.get(key).finishCurrent();
        }
    }

    public String toString() {
        String result = "";

        result += "\n" + "Crew --------";
        for (String key : this.crew.keySet()) {
            result += "\n";
            result += "\n" + " [" + key + "]" + "H: " + crew.get(key).getHealth();

            if (crew.get(key).getCurrent() == null) {
                result += "\n" + " Idle"; 
            } else {
                result += "\n" + "C [" + crew.get(key).getCurrent().getTargetKey() + "] "
                        + crew.get(key).getCurrent().getSecsRemaining();
            }
            result += "\n";
            result += "\n" + " Complete Repairs   --- ";
            HashMap<String, Repair> repairs = crew.get(key).getCompleteRepairs();
            for (String taskKey : repairs.keySet()) {
                result += "\n" + "      [" + repairs.get(taskKey).getTargetKey() + "] ";
            }

            result += "\n" + " Complete Setups   --- ";
            HashMap<String, SetupCannon> setups = crew.get(key).getCompleteSetups();
            for (String taskKey : setups.keySet()) {
                result += "\n" + "      [" + setups.get(taskKey).getTargetKey() + "] ";
            }

        }

        return result;
    }

}