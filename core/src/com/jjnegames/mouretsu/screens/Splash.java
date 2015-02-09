package com.jjnegames.mouretsu.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jjnegames.mouretsu.MouretsuNinja;

public class Splash implements Screen {
	private Texture texture1, texture2, texture3, texture4, texture5, texture6, texture7;
	private Image splashImage1, splashImage2, splashImage3, splashImage4, splashImage5, splashImage6, splashImage7;
	private Stage stage;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)){
			((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen());
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
//		new Thread(){
//			public void run(){
//				for(int i=0;i<460;i++){
//					try{
//						Thread.sleep(100);
//					}catch(InterruptedException e){
//						e.printStackTrace();
//					}
//				}
//			}
//			
//			
//		}.start();
		texture1 = new Texture(Gdx.files.internal("intro/pic1_2.bmp"));
		texture2 = new Texture(Gdx.files.internal("intro/pic1_3.bmp"));
		texture3 = new Texture(Gdx.files.internal("intro/pic1_4.bmp"));
		texture4 = new Texture(Gdx.files.internal("intro/pic1_5.bmp"));
		texture5 = new Texture(Gdx.files.internal("intro/pic1_6.bmp"));
		texture6 = new Texture(Gdx.files.internal("intro/intro1_edited_1.png"));
		texture7 = new Texture(Gdx.files.internal("intro/intro2_edited_2.png"));
		splashImage1 = new Image(texture1);
		splashImage2 = new Image(texture2);
		splashImage3 = new Image(texture3);
		splashImage4 = new Image(texture4);
		splashImage5 = new Image(texture5);
		splashImage6 = new Image(texture6);
		splashImage7 = new Image(texture7);
		
		stage = new Stage();
		
		splashImage1.setWidth(MouretsuNinja.WIDTH);
		splashImage1.setHeight(MouretsuNinja.HEIGHT);
		stage.addActor(splashImage1);
		splashImage1.addAction(Actions.sequence(Actions.alpha(0),Actions.delay(1f),Actions.fadeIn(1.5f),Actions.delay(1f),Actions.fadeOut(1.5f)));
		
		splashImage2.setWidth(MouretsuNinja.WIDTH);
		splashImage2.setHeight(MouretsuNinja.HEIGHT);
		stage.addActor(splashImage2);
		splashImage2.addAction(Actions.sequence(Actions.alpha(0),Actions.delay(5f),Actions.fadeIn(1.5f),Actions.delay(1f),Actions.fadeOut(1.5f)));
		
		splashImage3.setWidth(MouretsuNinja.WIDTH);
		splashImage3.setHeight(MouretsuNinja.HEIGHT);
		stage.addActor(splashImage3);
		splashImage3.addAction(Actions.sequence(Actions.alpha(0),Actions.delay(9f),Actions.fadeIn(1.5f),Actions.delay(1f),Actions.fadeOut(1.5f)));
		
		splashImage4.setWidth(MouretsuNinja.WIDTH);
		splashImage4.setHeight(MouretsuNinja.HEIGHT);
		stage.addActor(splashImage4);
		splashImage4.addAction(Actions.sequence(Actions.alpha(0),Actions.delay(13f),Actions.fadeIn(1.5f),Actions.delay(1f),Actions.fadeOut(1.5f)));
		
		splashImage5.setWidth(MouretsuNinja.WIDTH);
		splashImage5.setHeight(MouretsuNinja.HEIGHT);
		stage.addActor(splashImage5);
		splashImage5.addAction(Actions.sequence(Actions.alpha(0),Actions.delay(17f),Actions.fadeIn(1.5f),Actions.delay(3f),Actions.fadeOut(1.5f)));
		
		int w = MouretsuNinja.WIDTH;
		int h = MouretsuNinja.HEIGHT;
		splashImage6.setWidth(MouretsuNinja.WIDTH*1.1f);
		splashImage6.setHeight(MouretsuNinja.HEIGHT*3f);
		stage.addActor(splashImage6);
		splashImage6.addAction(Actions.sequence(Actions.alpha(0),Actions.moveBy(-w*0.045f, -h*2.05f),Actions.delay(23f),Actions.fadeIn(1.5f),Actions.delay(2f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.delay(2f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.delay(2f),Actions.fadeOut(1.5f)));
		
		splashImage7.setWidth(MouretsuNinja.WIDTH*1.1f);
		splashImage7.setHeight(MouretsuNinja.HEIGHT*3f);
		stage.addActor(splashImage7);
//		splashImage7.addAction(Actions.sequence(Actions.alpha(0),Actions.moveBy(-w*0.045f, -h*2.05f),Actions.delay(0f),Actions.fadeIn(1.5f),Actions.delay(2f),
//				Actions.moveBy(0, +h*1f,2f),Actions.delay(2f),
//				Actions.moveBy(0, +h*1f,2f),Actions.delay(2f),Actions.fadeOut(1.5f)));
		
		splashImage7.addAction(Actions.sequence(Actions.alpha(0),Actions.moveBy(-w*0.045f, -h*2.05f),Actions.delay(37f),Actions.fadeIn(1.5f),Actions.delay(2f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.delay(2f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.1f,0.111f),
				Actions.moveBy(0, +h*0.09f,0.111f),
				Actions.moveBy(0, +h*0.08f,0.111f),
				Actions.moveBy(0, +h*0.07f,0.111f),
				Actions.moveBy(0, +h*0.06f,0.111f),
				Actions.moveBy(0, +h*0.04f,0.111f),
				Actions.moveBy(0, +h*0.03f,0.111f),
				Actions.moveBy(0, +h*0.02f,0.111f),
				Actions.moveBy(0, +h*0.01f,0.111f),
				Actions.delay(2f),Actions.fadeOut(2f),Actions.delay(2f),Actions.run(new Runnable(){
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
		texture1.dispose();
		texture2.dispose();
		texture3.dispose();
		texture4.dispose();
		texture5.dispose();
		texture6.dispose();
		texture7.dispose();
		stage.dispose();
	}

}
