package com.jjnegames.mouretsu.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jjnegames.mouretsu.game.MGame;

public class GameScreen implements Screen {
	
	public MGame game;
	
	public boolean paused=false;
	
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.draw();
	}

	@Override
	public void resize(int width, int height) {
		// isompi numero, pienempi zoomi
		game.camera.setToOrtho(false, 12, 10);
	}

	@Override
	public void show() {
		game = new MGame();
		
        
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		paused=true;
	}

	@Override
	public void resume() {
		paused=false;
	}

	@Override
	public void dispose() {
		game.dispose();
		game=null;
	}

}
