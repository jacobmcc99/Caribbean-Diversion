package com.elevenfiftyfive.hack.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarbGame
{
    private List<Map> maps;
    public Battle battle; 
    public CarbGame() {

        maps = new ArrayList<Map>();
        maps.add(new Map(1));
        maps.add(new Map(2));
        maps.add(new Map(3));

    
        battle = new Battle(3, test());

    }



    public PlayerShip test()
    {
        HashMap<String,Crew>crew = new HashMap<>();
        crew.put("firstmate",new Crew(1,"firstmate"));
        crew.put("quartermaster",new Crew(2,"quartermaster"));
        crew.put("sailingmaster",new Crew(5,"sailingmaster"));
        crew.put("gunner",new Crew(1,"gunner"));
        crew.put("surgeon",new Crew(6,"surgeon"));
     
        HashMap<String,Cannon> cannons  = new HashMap<>();
    
        Cannon damaged = new Cannon(10,"left");
        damaged.setHealth(10);
        cannons.put("left",damaged);

        Cannon damagedC = new Cannon(10,"centerright");
        damagedC.setHealth(10);
        cannons.put("centerright", damagedC);

        cannons.put("centerleft", new Cannon(10,"centerleft"));
        cannons.put("right", new Cannon(10,"right"));

        // set tasks

        PlayerShip  ship = new PlayerShip(cannons, crew);
        
      //  ship.setRepairTask(ship.getCannon("left"), ship.getCrew("firstmate"));
        //ship.setRepairTask(ship.getCannon("centerright"), ship.getCrew("sailingmaster"));
        
        return ship;
    }
    
    

   
    


}