package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.HashMap;
import java.util.List;
public abstract class Ship{

    private int x;
    private int y;
    private HashMap<String,Crew>crew;
    private HashMap<String,Cannon>cannons;

    private List<Task> shots;
    private List<Task> repairs;


    public Ship(HashMap<String,Cannon>cannons,HashMap<String,Crew>crew){
        this.cannons = cannons;
        this.crew = crew;
    }
    



}