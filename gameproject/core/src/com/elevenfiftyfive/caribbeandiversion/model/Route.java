package com.elevenfiftyfive.caribbeandiversion.model;

public class Route{
    private Double enemyLocation;
    private Double playerLocation;
    private Island island;
    private int difficulty;

    public Route(int difficulty) {
      this.difficulty = difficulty;
      
    }
}