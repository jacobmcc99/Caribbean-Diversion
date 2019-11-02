package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.*;

public class TaskCollection<T extends Task>
{
    private HashMap<String, T> tasks;
    private T current;
    public TaskCollection() {
        tasks = new HashMap<>();
    }
    public boolean has(String targetKey){
        return tasks.keySet().contains(targetKey);
    }
    public void remove(String targetKey){
        tasks.remove(targetKey);
    }
    public boolean isIdle() {
        return current.isDone();
    }
    public void add(T task){
        tasks.put(task.getTargetKey(),task);
    }
    public void CompleteTask(){
        tasks.put(current.getTargetKey(),current);
    }

}