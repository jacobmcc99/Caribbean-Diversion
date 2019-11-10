package com.elevenfiftyfive.hack.model;

import java.util.Random;
public class Repair extends Task{
   
    public Repair(int length, String targetKey) {
        super(length,targetKey);
    }

    @Override
    public Utility apply(Utility usingUtil,Utility targetUtil) { // changes the targetutil using the usingutil
        targetUtil.setHealth(100);       
        return targetUtil;
        
    }

    
    
}