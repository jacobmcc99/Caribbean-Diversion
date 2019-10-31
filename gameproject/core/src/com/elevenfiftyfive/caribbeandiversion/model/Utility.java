package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.Date;

public abstract class Utility {
    private int health;
    private int quality;
    protected Task task;
    private String key;

    public Utility(int quality) {
        this.health = 100;
        this.quality = quality;
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

    public boolean isBusy() {
        return this.task.isDone() || task == null;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        if (!this.isBusy()) {
            this.task = task;
        }

    }

}