package com.jjnegames.mouretsu.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jjnegames.mouretsu.MouretsuNinja;


public class StartScreen implements Screen {
	
	private Texture texture1, texture2, texture3;
	private Image startImage1, startImage2, startImage3;
	private Stage stage1;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage1.act();
		stage1.draw();
		
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			if(Gdx.input.getX() > startImage2.getX() && Gdx.input.getX() < startImage2.getX()+ startImage2.getWidth() && 
					MouretsuNinja.HEIGHT-Gdx.input.getY() > startImage2.getY() && MouretsuNinja.HEIGHT-Gdx.input.getY() < startImage2.getY()+ startImage2.getHeight()){
				System.out.println("Peli käynnistetty");
			((Game)Gdx.app.getApplicationListener()).setScreen(new Splash());}
			else if(Gdx.input.getX() > startImage3.getX() && Gdx.input.getX() < startImage3.getX()+ startImage3.getWidth() && 
					MouretsuNinja.HEIGHT-Gdx.input.getY() > startImage3.getY() && MouretsuNinja.HEIGHT-Gdx.input.getY() < startImage3.getY()+ startImage2.getHeight()){
				System.out.println("Peli sammutettu");
				System.exit(0);
			}
		}
			
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		texture1 = new Texture(Gdx.files.internal("startmenu/StartScreen_1.png"));
		texture2 = new Texture(Gdx.files.internal("startmenu/StartScreen_2.png"));
		texture3 = new Texture(Gdx.files.internal("startmenu/StartScreen_3.png"));
		
		startImage1 = new Image(texture1);
		startImage2 = new Image(texture2);
		startImage3 = new Image(texture3);
		
		stage1 = new Stage();
		
		
		startImage1.setWidth(MouretsuNinja.WIDTH);
		startImage1.setHeight(MouretsuNinja.HEIGHT);
		stage1.addActor(startImage1);
		
		startImage2.setWidth(250f);
		startImage2.setHeight(75f);
		startImage2.setPosition(MouretsuNinja.WIDTH/2-startImage2.getWidth()/2, MouretsuNinja.HEIGHT/1.7f);
		stage1.addActor(startImage2);
		
		startImage3.setWidth(250f);
		startImage3.setHeight(75f);
		startImage3.setPosition(MouretsuNinja.WIDTH/2-startImage3.getWidth()/2, MouretsuNinja.HEIGHT/3);
		stage1.addActor(startImage3);
		
		
	}

	@Override
	public void hide() {
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
	public void dispose() {
		texture1.dispose();
		texture2.dispose();
		texture3.dispose();
		stage1.dispose();
		
	}

	
	
	
}
