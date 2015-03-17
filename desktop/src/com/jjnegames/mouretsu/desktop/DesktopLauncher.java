package com.jjnegames.mouretsu.desktop;

import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jjnegames.mouretsu.MouretsuNinja;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		for(DisplayMode dm : config.getDisplayModes()){
			System.out.println(dm.width+" "+dm.height);
		}
		
		config.width=MouretsuNinja.WIDTH;
		config.height=MouretsuNinja.HEIGHT;
		config.fullscreen=false;
		config.backgroundFPS=15;
		config.foregroundFPS=60;
		config.x=-1;
		config.y=-1;
		new LwjglApplication(new MouretsuNinja(), config);
	}
	
	
}
