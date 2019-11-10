package com.elevenfiftyfive.hack.model;

import java.util.HashMap;

public class Battle {
    
    private EnemyShip enemy;
    private PlayerShip player;
    public Battle(int difficutly, PlayerShip player) {
        super();

        this.player = player;
        
        enemy = createEnemy();

    }
    public void shoot(String usingCannon, String shooter, String target)
    {
        this.player.setShootingTask(usingCannon, shooter,  target);
    }
    public void setRepairTask(String crew, String target)
    {
        Utility repair = player.getAllCannon().get(target);
        if (repair==null) {
            repair = player.getCrew(target);
        }
      
        player.setRepairTask(repair, player.getCrew(crew));
    }
    public void setSetup(String crew, String target)
    {
        player.setSetupTask(target,player.getCrew(crew));
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
        player.update();
        enemy.update();
        enemy.makeMove(player);
        
        // check if the games over
        if (player.allCannonsDestroyed() || player.allCrewDead()) {
            System.out.print("game over You LOSE");
        }
        if (enemy.allCannonsDestroyed() || enemy.allCrewDead()) {
            System.out.print("game over You WIN");
        }

    }
    private EnemyShip createEnemy()
    {
        HashMap<String,Crew>crew = new HashMap<>();
        crew.put("firstmate",new Crew(1,"firstmate"));
        crew.put("quartermaster",new Crew(2,"quartermaster"));
        crew.put("sailingmaster",new Crew(5,"sailingmaster"));
        crew.put("gunner",new Crew(1,"gunner"));
        crew.put("surgeon",new Crew(6,"surgeon"));
     
        HashMap<String,Cannon> cannons  = new HashMap<>();

        cannons.put("centerleft", new Cannon(10,"centerleft"));
        cannons.put("right", new Cannon(10,"right"));

        
        return new EnemyShip(cannons, crew);
    }
}