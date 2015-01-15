package com.jjnegames.mouretsu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.jjnegames.mouretsu.screens.Splash;

public class MouretsuNinja extends Game {
	SpriteBatch batch;
	Texture img;
	public static final String TITLE="Game Project"; 
    public static final int WIDTH=800,HEIGHT=480; // used later to set window size
	
	@Override
	public void create () {
		setScreen(new Splash());
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
	}

//	@Override
//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
	World world = new World(new Vector2(0,0), true);
}
