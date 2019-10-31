package com.elevenfiftyfive.caribbeandiversion.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game
{
    private List<Map> maps;
    private PlayerShip player;

    public Game() {

        maps = new ArrayList<Map>();
        maps.add(new Map(1));
        maps.add(new Map(2));
        maps.add(new Map(3));

        // create a ship
        player = createShip();
        

    }
    public PlayerShip createShip() 
    {
       HashMap<String,Crew>crew = new HashMap<>();
       crew.put("firstmate",new Crew(10));
       crew.put("quartermaster",new Crew(10));
       crew.put("sailingmaster",new Crew(10));
       crew.put("gunner",new Crew(10));
       crew.put("surgeon",new Crew(10));
       
       HashMap<String,Cannon> cannons  = new HashMap<>();
       cannons.put("left", new Cannon(10));
       cannons.put("centerleft", new Cannon(10));
       cannons.put("centerright", new Cannon(10));
       cannons.put("right", new Cannon(10));

        return new PlayerShip(cannons,crew);
    }
    


}