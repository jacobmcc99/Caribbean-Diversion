package com.elevenfiftyfive.caribbeandiversion.View;

import java.util.HashMap;
import java.util.HashSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.elevenfiftyfive.caribbeandiversion.model.*;

public class Console implements Screen, InputProcessor {

    CarbGame g;
    HashMap<String, Crew> crewMembers;
  //  SpriteBatch batch;
  //  OrthographicCamera camera;
  //  FitViewport viewport;
    Stage stage;
    Skin skin;
    TextureAtlas atlas;
    String skinName;
    TextButton btn;

    public Console(CarbGame g) {
        super();

        this.g = g;

        // setup

      //  stage = new Stage();
       // Gdx.input.setInputProcessor(stage);
        skinName = "flat-earth";
        // skinName = "star-soldier";
        atlas = new TextureAtlas("Skins/" + skinName + "/skin/" + skinName + "-ui.atlas");
        skin = new Skin(Gdx.files.internal("Skins/" + skinName + "/skin/" + skinName + "-ui.json"), atlas);
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

  //      stage.addActor(createConsoleTable());

 //       stage.act(Gdx.graphics.getDeltaTime());
 //       stage.draw();
   //     stage.clear();

    }

    public Table drawCrewCard(Crew crew) {
        /*
         * 
         * |---------------------------------| | | Name | level | health | | | | | Pic
         * |-----------------------| | | Task | Target | | | Remaining |
         * |---------------------------------|
         * 
         */

        crewMembers = g.getPlayer().getAllCrew();
        Table outer = new Table();
        Table crewInfo = new Table();

        Label name = new Label(crew.getKey(), skin);
        Label level = new Label(String.valueOf(crew.getQuality()), skin);
        Label health = new Label("Health: " + String.valueOf(crew.getHealth()), skin);
        name.setFontScale(2, 2);
        crewInfo.add(name).top().left().height(100).padLeft(1).padBottom(5);
        crewInfo.add(health).left().width(10).padLeft(10);
        // crewInfo.add(level).right().width(30);

        // task info
        crewInfo.row();

        if (crew.getCurrent() == null) {

            Label idle = new Label("Idle", skin);

            crewInfo.add(idle);

        } else {

            Label taskType;
            if (crew.getCurrent() instanceof Repair) {
                taskType = new Label("Repair", skin);
            } else {
                taskType = new Label("Setup", skin);
            }

            crewInfo.add(taskType).center();

            Label target = new Label(crew.getCurrent().getTargetKey(), skin);
            crewInfo.add(target);
            crewInfo.row();

            crewInfo.add(new Label(String.valueOf(crew.getCurrent().getSecsRemaining()), skin));

        }
        crewInfo.row();

      //  TextButton btn = new TextButton("as", skin);

    //    crewInfo.add(btn).left().width(100).fill(true).pad(10);
    //    crewInfo.row();
        crewInfo.setWidth(3);
        outer.setFillParent(true);
        // outer.debug();

        // add table border
        // outer.add(new Table().background(background)).width(1);

        outer.add(crewInfo); // .top().left().width(200);

        outer.left().bottom();
        outer.padLeft(10);

        return outer;
    }

    public Table createConsoleTable() {
        Table table = new Table();
        // table.add(new Label("Crew", skin));
        NinePatch wpatch = new NinePatch(new Texture(Gdx.files.internal("whitebackground.png")), 1, 1, 1, 1);
        NinePatchDrawable wbackground = new NinePatchDrawable(wpatch);

        for (Crew crew : g.getPlayer().getAllCrew().values()) {
            table.add(drawCrewCard(crew)).left().padBottom(10);
            table.row();
            table.add(new Table().background(wbackground)).left().height(3).expandX().padTop(10).padBottom(10);
            table.row();
        }

        table.left();
        NinePatch patch = new NinePatch(new Texture(Gdx.files.internal("blackBackground.jpg")), 1, 1, 1, 1);
        NinePatchDrawable background = new NinePatchDrawable(patch);
        table.background(background);
        // table.setDebug(true);
        table.setWidth(20);

        return table;
    }

    @Override
    public void resize(int width, int height) {
        // stage.getViewport().update(width, height, true);
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

    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (screenX > 70 && screenX < 30) {
            if (screenY > 300 && screenY < 345) {
                System.out.println("button one");
            }
            if (screenY > 300 && screenY < 345) {
                System.out.println("button one");
            }
            if (screenY > 300 && screenY < 345) {
                System.out.println("button one");
            }
            if (screenY > 300 && screenY < 345) {
                System.out.println("button one");
            }
        }
        System.out.println(screenX + " : " + screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }

}