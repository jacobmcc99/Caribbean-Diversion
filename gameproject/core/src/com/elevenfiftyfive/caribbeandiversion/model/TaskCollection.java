package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.*;

public class TaskCollection<T extends Task> {
    private HashMap<String, T> completeTasks;
    private T current;

    public TaskCollection() {
        completeTasks = new HashMap<>();
    }

    public boolean has(String targetKey) {
        return completeTasks.keySet().contains(targetKey);
    }

  
    
    public void start(T task){
        this.current = task;
    }
    public String currentWorker() {
        return current.getTargetKey();
    }

    public Task getCurrent() {
        return this.current;
    }

    public void attemptCurrentCompletetion() {
        if ( current != null && current.isDone()) {
            completeTasks.put(current.getTargetKey(), current);
            current = null;
        }
    }

    public Utility applyTask(Utility usingUtil,Utility target) {
        Utility result = completeTasks.get(target.getKey()).apply(usingUtil, target);

        // remove the task
        completeTasks.remove(target.getKey());

        return result;
    }

    public HashMap<String, T> getCompleteTasks() {
        return this.completeTasks;
    }
}