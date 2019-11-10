package com.elevenfiftyfive.caribbeandiversion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.elevenfiftyfive.caribbeandiversion.GDXGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.foregroundFPS = 1;
		config.width=1700;
		config.height=1300;
		new LwjglApplication(new GDXGame(), config);
	}
}
