package com.elevenfiftyfive.caribbeandiversion.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.elevenfiftyfive.caribbeandiversion.model.CarbGame;

public class BattleScreen implements Screen {
    CarbGame game;
    Console console;
    Table parentTable;
    NinePatch patch;
    NinePatchDrawable background;
    Stage stage;
    Skin skin;
    TextureAtlas atlas;

    public BattleScreen(/*Skin skin,TextureAtlas atlas,NinePatchDrawable NinePatchDrawable*/) {
        super();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        game = new CarbGame();
       
     TextureAtlas texttr = new TextureAtlas("Skins/flat-earth/skin/flat-earth-ui.atlas");
      skin = new Skin(Gdx.files.internal("Skins/flat-earth/skin/flat-earth-ui.json"), atlas);
       
   //     
        

    //    parentTable.setFillParent(true);
        
       // stage.addActor(parentTable);
    }

    @Override
    public void show() {
        patch = new NinePatch(new Texture(Gdx.files.internal("core/assets/images/tmpBackground.jpg")), 1, 1, 1, 1);
  
        parentTable = new Table();
         parentTable.background(new NinePatchDrawable(patch));

        Table consoleTable = new Console(game).createConsoleTable();
        parentTable.pad(70).padTop(200);
        parentTable.add(consoleTable).left().expand().width(300).padRight(0).height(800);
        stage.addActor(parentTable);
    }



    public void setUpConsole() {
        // stage.clear();
        // parent.clear();
        //x++;
      //  System.out.println(x);
        // Table consoleTable = new Console(game).createConsoleTable();

        // parent.pad(70).padTop(200);
        // parent.add(consoleTable).left().expand().width(300).padRight(0).height(800);

        // parent.add(new Label("test", skin));

    }

    @Override
    public void render(float delta) {
        //// Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        /// Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      

        /// stage.act();
        /// stage.draw();
        /// stage.act(Gdx.graphics.getDeltaTime());

     //   game.update();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        stage.dispose();
 //        skin.dispose();
     //   atlas.dispose();

        // TODO Auto-generated method stub

    }
}