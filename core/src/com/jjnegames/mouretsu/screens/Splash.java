package com.jjnegames.mouretsu.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jjnegames.mouretsu.MouretsuNinja;

public class Splash implements Screen {
	private Texture texture;
	private Image splashImage;
	private Stage stage;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		texture = new Texture(Gdx.files.internal("badlogic.jpg"));
		splashImage = new Image(texture);
		stage = new Stage();
		splashImage.setWidth(MouretsuNinja.WIDTH);
		splashImage.setHeight(MouretsuNinja.HEIGHT);
		stage.addActor(splashImage);
		splashImage.addAction(Actions.sequence(Actions.alpha(0),Actions.fadeIn(1f),Actions.delay(0.5f),
				Actions.run(new Runnable(){
					@Override 
					public void run(){
						
						((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen());
						
					}
					
				})));
	}

	@Override
	public void hide() {
		dispose();
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
		texture.dispose();
		stage.dispose();
	}

}
