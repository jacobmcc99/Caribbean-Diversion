package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;
public class Cannon extends Utility
{
    
    public Cannon(int quality) {
        super(quality);
    }

    
    public void shoot(String targetKey)
    {
        if(!this.isBusy())
        {
            this.setTask(new Shot(3,targetKey, this.getKey()));
        }
        
    }
    
}