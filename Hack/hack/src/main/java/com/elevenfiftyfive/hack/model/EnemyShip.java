package com.elevenfiftyfive.hack.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EnemyShip extends Ship {
    private LocalDateTime lastMove;
    private Random rnd;

    public EnemyShip(HashMap<String, Cannon> cannons, HashMap<String, Crew> crew) {
        super(cannons, crew);
        lastMove = LocalDateTime.now();
        rnd = new Random();
    }

    public void makeMove(Ship opponent) // every 5 seconds
    {
        if (secsSinceLastMove() >= 5) {
            if (!allCrewDead() && !allCannonsDestroyed()) {
                // select a random util to repair
                int move = rnd.nextInt(2);
                if (move == 0) {

                    this.setRepairTask(this.selectRepair(), selectCrew());
                }
            }

        }
    }

    public Crew selectCrew() {

        ArrayList<Crew> idelCrew = new ArrayList<>();

        for (Crew crewMem : this.getAllCrew().values()) {
            if (crewMem.isIdle()) {
                idelCrew.add(crewMem);
            }

        }

        if (idelCrew.size() == 0) {
            return null; // all crew are busy
        }

        return idelCrew.get(rnd.nextInt(idelCrew.size()));

    }

    public Cannon selectCannon() {

        ArrayList<Cannon> idleCannons = new ArrayList<>();

        for (Cannon cannon : this.getAllCannon().values()) {
            if (cannon.isIdle()) {
                idleCannons.add(cannon);
            }

        }

        return idleCannons.get(rnd.nextInt(idleCannons.size()));
    }

    public Utility selectRepair() {
        ArrayList<Utility> needsRepairing = new ArrayList<>();

        for (Crew crewMem : this.getAllCrew().values()) {
            if (crewMem.getHealth() < 100) {
                needsRepairing.add(crewMem);
            }
        }

        for (Cannon cannon : this.getAllCannon().values()) {
            if (cannon.getHealth() < 100) {
                needsRepairing.add(cannon);
            }
        }

        if (needsRepairing.size() <= 0) {
            return null;
        }

        // select a random from the utilities
        return needsRepairing.get(rnd.nextInt(needsRepairing.size()));
    }

    public long secsSinceLastMove() {
        return Duration.between(LocalDateTime.now(), lastMove).getSeconds();
    }

}