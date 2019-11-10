package com.elevenfiftyfive.hack.model;

import java.security.Key;

public abstract class Utility {
    private String key;

    private int health;
    private int quality;

    private boolean ready; // ready for the task to completed

    public Utility(int quality, String key) {
        this.key = key;
        this.health = 100;
        this.quality = quality;
        this.ready = false;

    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getHealth() {
        return health;
    }

    public int getQuality() {
        return quality;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}