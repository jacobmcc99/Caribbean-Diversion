package com.elevenfiftyfive.hack.model;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Cannon extends Utility {

    private String shooterKey;

    private TaskCollection<Shot> shots;

    public Cannon(int quality, String Key) {
        super(quality, Key);
        this.shooterKey = "";

        shots = new TaskCollection<>();
    }

    public boolean isSetUp() {
        return this.isReady();
    }

    public void setSetUp(boolean setUp) {
        this.setReady(setUp);
    }

    public boolean isIdle() {
        return (getCurrent() == null);
    }

    public String getShooterKey() {
        return shooterKey;
    }

    public Task getCurrent() {

        return shots.getCurrent();
        
    }

    public void setShooterKey(String shooterKey) {
        this.shooterKey = shooterKey;
    }

    public void cancelShot() {
        this.shots.start(null);
    }

    public void shoot(String shooterKey, String targetKey) {

        if (isReady()) {
            shots.start(new Shot(30 - (this.getQuality() - 10), targetKey));
            this.setShooterKey(shooterKey);
        }

    }

}