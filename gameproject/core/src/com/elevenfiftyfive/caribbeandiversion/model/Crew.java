package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;
public class Crew extends Utility
{
    
    public Crew(int quality) {
        super(quality);
    }

    public void startRepair(String targetKey)
    {
        this.setTask(new Repair(20 - (this.getQuality()/10),targetKey));
    }
}