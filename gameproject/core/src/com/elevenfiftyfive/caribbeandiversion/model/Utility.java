package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.Date;

public abstract class Utility {
    private int health;
    private int quality;
    private boolean busy;
    private Task task;
    private String key;

    public Utility(int quality) {
        this.health = 100;
        this.quality = quality;
        busy = false;
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
    public int getQuality(){return quality;}
    public boolean isBusy(){return busy;}
    public void setTask(Task task){this.task = task;}
    public void setHealth(int health){this.health=health;}

    

}