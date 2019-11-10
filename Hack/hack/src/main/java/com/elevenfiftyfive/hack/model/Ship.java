package com.elevenfiftyfive.hack.model;

import java.util.HashMap;

import com.elevenfiftyfive.hack.View.Colours;

public abstract class Ship {

    private int x;
    private int y;
    private HashMap<String, Crew> crew;
    private HashMap<String, Cannon> cannons;

    public Ship(HashMap<String, Cannon> cannons, HashMap<String, Crew> crew) {
        this.cannons = cannons;
        this.crew = crew;
     
    }

    public void setShootingTask(String usingCannon, String shooter , String target) {
        this.cannons.get(usingCannon).shoot(shooter, target); 
    }

    public boolean allCannonsDestroyed()
    {
        return this.getAllCannon().size()==0;
    }
    public boolean allCrewDead()
    {
        return this.getAllCrew().size()==0;
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

    public HashMap<String, Crew> getAllCrew() {
        return crew;
    }

    public HashMap<String, Cannon> getAllCannon() {
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
                cannon.cancelShot();
            }

        }
        crew.startSetupCannon(targetKey);
    }

    public void update() {
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

            // check if the cannon is destroyed
            if (cannons.get(cannonKey).getHealth()<=0) {
                    cannons.remove(cannonKey);
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

              // remove any crew member whose health == 0 
              if (crew.get(key).getHealth()<=0) {
                  crew.remove(key);
              }
        }
    }

    public String toString() {
        String result = "";
        String tabs = "\n    ";
        result += "\n" + Colours.ANSI_BRIGHT_YELLOW + "Crew --------" + Colours.ANSI_RESET;
        for (String key : this.crew.keySet()) {

            result += "\n" + " H: " + crew.get(key).getHealth() + Colours.ANSI_BRIGHT_CYAN + " [" + key + "]"
                    + Colours.ANSI_RESET;

            if (crew.get(key).getCurrent() == null) {
                result += tabs + "Idle";
            } else if (crew.get(key).getCurrent() instanceof Repair) {
                result += tabs + "Repairing [" + Colours.ANSI_BRIGHT_RED + crew.get(key).getCurrent().getTargetKey()
                        + Colours.ANSI_RESET + "] ";
                result += "  " + tabs + crew.get(key).getCurrent().getSecsRemaining();
            } else {
                result += tabs + "set   up [" + Colours.ANSI_BRIGHT_RED + crew.get(key).getCurrent().getTargetKey()
                        + Colours.ANSI_RESET + "] ";
                result += "  " + tabs + crew.get(key).getCurrent().getSecsRemaining();

            }
            result += "\n              -                  ";

        }
        result += "\n" + Colours.ANSI_BRIGHT_YELLOW + "Cannons --------" + Colours.ANSI_RESET;
        result += "\n              -                  ";
        result += "\n";
        for (String key : this.cannons.keySet()) {

            if (cannons.get(key).isSetUp()) {
                result += Colours.ANSI_BRIGHT_GREEN + " R " + Colours.ANSI_RESET;

            } else {
                result += Colours.ANSI_BRIGHT_RED + " N " + Colours.ANSI_RESET;

            }

            result += " H: " + cannons.get(key).getHealth() + Colours.ANSI_BRIGHT_CYAN + "   ["
                    + cannons.get(key).getKey() + "]" + Colours.ANSI_RESET;
            result += "\n";
        }
        
        return result;
    }

}