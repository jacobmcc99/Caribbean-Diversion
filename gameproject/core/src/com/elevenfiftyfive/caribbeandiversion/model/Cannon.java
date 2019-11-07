package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Cannon extends Utility {

    private String shooterKey;
    private boolean setUp;
    private TaskCollection<Shot> shots;

    public Cannon(int quality,String Key) {
        super(quality,Key);
        this.shooterKey = "";
        this.setUp=false;
        shots = new TaskCollection<>();
    }

    public boolean isSetUp() {
        return setUp;
    }

    public void setSetUp(boolean setUp) {
        this.setUp = setUp;
    }

    public String getShooterKey() {
        return shooterKey;
    }

    public void setShooterKey(String shooterKey) {
        this.shooterKey = shooterKey;
    }

    public void shoot(String targetKey, String shooterKey) {
        
        
    }



}