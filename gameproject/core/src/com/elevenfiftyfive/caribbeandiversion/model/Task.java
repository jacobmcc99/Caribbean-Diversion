package com.elevenfiftyfive.caribbeandiversion.model;

import java.time.LocalDateTime;
import java.time.Duration;

public abstract class Task {
    private int length;
    private LocalDateTime end;
    private String targetKey;

    public Task(int length, String targetKey) {

        this.length = 10;//length;

        // set time
        this.end = LocalDateTime.now().plusSeconds(this.length);
  

        this.setTargetKey(targetKey);
        // this.UsingKey = UsingKey;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }

    public long getSecsRemaining() {
        long secsRemaining = Duration.between(LocalDateTime.now(), end).getSeconds();
        if (secsRemaining <= 0) {
            return 0;
        } else {
            return secsRemaining;
        }

    }

   
    public boolean isDone() {
        return getSecsRemaining() == 0;
    }
    abstract public Utility apply(Utility usingUtil, Utility targetUtil);
}