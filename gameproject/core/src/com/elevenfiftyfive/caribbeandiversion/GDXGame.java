package com.elevenfiftyfive.caribbeandiversion;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.elevenfiftyfive.caribbeandiversion.View.*;


public class GDXGame extends Game {

	SpriteBatch batch;
	Texture img;
//	float x = 0, y = 0;
	public GDXGame() {
		super();

		this.setScreen(new BattleScreen());
	}
	@Override
	public void create() {
	
	}
	@Override
    public void render (){
		super.render();
		
	}
	
	@Override
    public void dispose() {	
    }
}
