package com.jjnegames.mouretsu.screens;

import java.awt.event.KeyListener;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jjnegames.mouretsu.MouretsuNinja;
import com.jjnegames.mouretsu.game.MGame;

public class GameScreen implements Screen {
	
	public MGame game;
	private Texture texture1, texture2, texture3;
	private Image pauseImage1, pauseImage2, pauseImage3;
	public Stage pauseStage;
	
	public boolean paused=false;
	
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
			game.draw(paused);
		if(paused){
			pauseStage.draw();
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
				if(Gdx.input.getX() > pauseImage2.getX() && Gdx.input.getX() < pauseImage2.getX()+ pauseImage2.getWidth() && 
						MouretsuNinja.HEIGHT-Gdx.input.getY() > pauseImage2.getY() && MouretsuNinja.HEIGHT-Gdx.input.getY() < pauseImage2.getY()+ pauseImage2.getHeight()){
					paused = false;
				}
				else if(Gdx.input.getX() > pauseImage3.getX() && Gdx.input.getX() < pauseImage3.getX()+ pauseImage3.getWidth() && 
						MouretsuNinja.HEIGHT-Gdx.input.getY() > pauseImage3.getY() && MouretsuNinja.HEIGHT-Gdx.input.getY() < pauseImage3.getY()+ pauseImage2.getHeight()){
					System.out.println("Peli sammutettu");
					System.exit(0);
				}
			}
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			paused = true;
			
			
		}
	}

	@Override
	public void resize(int width, int height) {
		// isompi numero, pienempi zoomi
		game.camera.setToOrtho(false, 12, 10);
	}

	@Override
	public void show() {
		game = new MGame();
		
		
		texture1 = new Texture(Gdx.files.internal("pausemenu/PauseScreen_1_1.png"));
		texture2 = new Texture(Gdx.files.internal("pausemenu/PauseScreen_2.png"));
		texture3 = new Texture(Gdx.files.internal("pausemenu/PauseScreen_3.png"));
		
		pauseImage1 = new Image(texture1);
		pauseImage2 = new Image(texture2);
		pauseImage3 = new Image(texture3);
		
		pauseStage = new Stage();
		
		
		pauseImage1.setWidth(MouretsuNinja.WIDTH);
		pauseImage1.setHeight(MouretsuNinja.HEIGHT);
		pauseStage.addActor(pauseImage1);
		
		pauseImage2.setWidth(250f);
		pauseImage2.setHeight(75f);
		pauseImage2.setPosition(MouretsuNinja.WIDTH/2-pauseImage2.getWidth()/2, MouretsuNinja.HEIGHT/1.7f);
		pauseStage.addActor(pauseImage2);
		
		pauseImage3.setWidth(250f);
		pauseImage3.setHeight(75f);
		pauseImage3.setPosition(MouretsuNinja.WIDTH/2-pauseImage3.getWidth()/2, MouretsuNinja.HEIGHT/3);
		pauseStage.addActor(pauseImage3);
        
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
		texture1.dispose();
		texture2.dispose();
		texture3.dispose();
		pauseStage.dispose();
	}
	

}
