package com.elevenfiftyfive.caribbeandiversion;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.elevenfiftyfive.caribbeandiversion.View.Console;
import com.elevenfiftyfive.caribbeandiversion.model.*;

public class GDXGame extends Game {
	
	SpriteBatch batch;
	Texture img;
	float x=0,y=0;
	CarbGame g;


	@Override
	public void create () {
		
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		g = new CarbGame();

		setScreen(new Console(g));

		
	

	}
/*
	@Override
	public void render () { 		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
	  
		batch.draw(img, 0, 0);
	//	g.update();
		System.out.print(g.toString());
		batch.end();
		
		
	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
*/
}
