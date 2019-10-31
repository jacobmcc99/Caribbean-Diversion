package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.Random;
public class Shot extends Task{

   
    public Shot(int length, String targetKey, String usingKey) {
        super(length,targetKey,usingKey);
    }

    @Override
    public Utility complete(Utility usingUtil, Utility targetUtil) { // changes the targetutil using the usingutil
        if (!isDone()) {
            return targetUtil; // if the task is incomplete, return the uneffected target util
        }
        
     
        int damage =  new Random().nextInt(10);
        damage = usingUtil.getQuality() + damage;
        targetUtil.setHealth(targetUtil.getHealth() - damage);
        return targetUtil;
        
    }

    
    
}