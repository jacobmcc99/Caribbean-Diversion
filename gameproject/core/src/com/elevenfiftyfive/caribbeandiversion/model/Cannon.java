package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Cannon extends Utility {
    private String shooterKey;
    public Cannon(int quality) {
        super(quality);
        this.shooterKey = "";
    }
    public String getShooterKey() {
        return shooterKey;
    }

    public void setShooterKey(String shooterKey) {
        this.shooterKey = shooterKey;
    }

    public void shoot(String targetKey, String shooterKey) {
        if (shooterKey!="") {
            this.setTask(new Shot(3, targetKey));
        }
    }

}