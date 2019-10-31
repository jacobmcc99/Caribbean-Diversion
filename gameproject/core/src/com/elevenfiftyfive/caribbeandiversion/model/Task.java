package com.elevenfiftyfive.caribbeandiversion.model;

import java.time.LocalDateTime;
import java.sql.Date;
import java.time.Duration;

import java.util.Calendar;

public abstract class Task {
    private int length;
    private LocalDateTime end;
    private String targetKey;
    private String UsingKey;

    public Task(int length, String targetKey, String UsingKey) {

        this.length = length;

        // set time
        this.end = LocalDateTime.now().plusSeconds(length);

        this.targetKey = targetKey;
        this.UsingKey = UsingKey;
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

    public void changeUsing(String UsingKey) {
        this.UsingKey = UsingKey;
        // retart task
        this.end = LocalDateTime.now().plusSeconds(length);
    }

    abstract public Utility complete(Utility usingUtil, Utility targetUtil);
}