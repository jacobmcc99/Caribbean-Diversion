package com.elevenfiftyfive.hack.model;

public class Map {
    private Route easy;
    private Route medium;
    private Route hard;
    private int difficulty;

    public Map(int level) {
        
        // difficulty
        this.difficulty = 2 * level;

        // generate routes
        this.easy = new Route(difficulty);
        this.medium = new Route((int)(difficulty + (difficulty * 0.5)));
        this.hard = new Route(difficulty * 2);
    }
}