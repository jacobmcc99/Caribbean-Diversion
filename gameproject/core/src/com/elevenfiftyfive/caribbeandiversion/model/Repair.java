package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.Random;
public class Repair extends Task{

   
    public Repair(int length, String targetKey) {
        super(length,targetKey);
    }

    @Override
    public Utility complete(Utility usingUtil,Utility targetUtil) { // changes the targetutil using the usingutil
        if (!isDone()) {
            return targetUtil; // if the task is incomplete, return the uneffected target util
        }
        
        targetUtil.setHealth(100);
        
        return targetUtil;
        
    }

    
    
}