package com.elevenfiftyfive.hack.model;
import java.util.Random;

public class Shot extends Task {

    public Shot(int length, String targetKey) {
        super(length, targetKey);
    }

    @Override
    public Utility apply(Utility usingUtil, Utility targetUtil) { // changes the targetutil using the usingutil
        
        int damage =  new Random().nextInt(10);
        damage = usingUtil.getQuality() + damage;
        targetUtil.setHealth(targetUtil.getHealth() - damage);

        return targetUtil;
        
    }

}