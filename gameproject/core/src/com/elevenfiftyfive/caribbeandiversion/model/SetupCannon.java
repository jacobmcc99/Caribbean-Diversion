package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.Random;
public class SetupCannon extends Task{
   
    public SetupCannon(int length, String targetKey) {

        super(length,targetKey);
    }

    @Override
    public Utility apply(Utility usingUtil,Utility targetUtil) { // changes the targetutil using the usingutil
        targetUtil.setReady(true);  
        return targetUtil; // no need for this
     
    }

    
    
}