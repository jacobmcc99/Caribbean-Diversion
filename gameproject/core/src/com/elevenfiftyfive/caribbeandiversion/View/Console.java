package com.elevenfiftyfive.caribbeandiversion.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.elevenfiftyfive.caribbeandiversion.model.*;

public class Console implements Screen {

    CarbGame g;
    SpriteBatch batch;
    OrthographicCamera camera;
    FitViewport viewport;
    Stage stage;
    Skin skin;
    TextureAtlas atlas;
    public Console(CarbGame g) {
        super();

        this.g = g;

        // setup
     
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        atlas = new TextureAtlas("Skins/flat-earth/skin/flat-earth-ui.atlas");
        skin = new Skin(Gdx.files.internal("Skins/flat-earth/skin/flat-earth-ui.json"), atlas);


    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
     
        g = new CarbGame();
    
        Table table = new Table();

        for (Crew crew : g.getPlayer().getAllCrew().values()) {
            
            Label name = new Label(crew.getKey(), skin);
            name.toFront();
            table.add(name);
            table.row();

            Label health = new Label("Health: " + String.valueOf(crew.getHealth()) , skin);
            table.add(health);
            table.padLeft(20);
            table.row();

            String current="";
            if(crew.getCurrent()==null){
                current="idle";
            }
            else{
                current="[ " + crew.getCurrent().getTargetKey() + " ] " + crew.getCurrent().getSecsRemaining();
            }
            Label currentTask = new Label("Currently: " +  current, skin);
            table.add(currentTask);
            table.padLeft(20);
            table.row();

            table.padLeft(0);
     
        }

        table.setFillParent(true);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
       
        

    }

    @Override
    public void resume() {
       

    }

    @Override
    public void hide() {
      
    
    }

    @Override
    public void dispose() {
        skin.dispose();
        atlas.dispose();
        stage.dispose();
    }

}