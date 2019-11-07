package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarbGame
{
    private List<Map> maps;
    private PlayerShip player;

    public CarbGame() {

        maps = new ArrayList<Map>();
        maps.add(new Map(1));
        maps.add(new Map(2));
        maps.add(new Map(3));

        HashMap<String,Crew>crew = new HashMap<>();
        crew.put("firstmate",new Crew(10,"firstmate"));
        crew.put("quartermaster",new Crew(10,"quartermaster"));
        crew.put("sailingmaster",new Crew(10,"sailingmaster"));
        crew.put("gunner",new Crew(10,"gunner"));
        crew.put("surgeon",new Crew(10,"surgeon"));
        
        HashMap<String,Cannon> cannons  = new HashMap<>();
        cannons.put("left", new Cannon(10,"left"));
        cannons.put("centerleft", new Cannon(10,"centerleft"));
        cannons.put("centerright", new Cannon(10,"centerright"));
        cannons.put("right", new Cannon(10,"right"));

        player = new PlayerShip(cannons, crew);
    }
    public PlayerShip getPlayer(){
        return player;
    }
    public String toString()
    {
        return player.toString();
    }
    public void update()
    {
        player.CompleteTasks();
    }
    

   
    


}