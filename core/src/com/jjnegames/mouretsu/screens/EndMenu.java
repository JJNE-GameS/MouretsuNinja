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
import com.jjnegames.mouretsu.game.TextureBank;

public class EndMenu implements Screen{

	
	private Texture texture1, texture2, texture3, texture4;
	private Image endImage1, endImage2, endImage3, endImage4;
	private Stage Endstage;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Endstage.act();
		Endstage.draw();
		
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			if(Gdx.input.getX() > endImage3.getX() && Gdx.input.getX() < endImage3.getX()+ endImage3.getWidth() && 
					MouretsuNinja.HEIGHT-Gdx.input.getY() > endImage3.getY() && MouretsuNinja.HEIGHT-Gdx.input.getY() < endImage3.getY()+ endImage3.getHeight()){
				System.out.println("Peli käynnistetty");
			((Game)Gdx.app.getApplicationListener()).setScreen(new Splash());}
			else if(Gdx.input.getX() > endImage4.getX() && Gdx.input.getX() < endImage4.getX()+ endImage4.getWidth() && 
					MouretsuNinja.HEIGHT-Gdx.input.getY() > endImage4.getY() && MouretsuNinja.HEIGHT-Gdx.input.getY() < endImage4.getY()+ endImage2.getHeight()){
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
		texture1 = new Texture(Gdx.files.internal("endmenu/EndScreen_1.png"));
		texture2 = new Texture(Gdx.files.internal("endmenu/EndScreen_2.png"));
		texture3 = new Texture(Gdx.files.internal("endmenu/EndScreen_3.png"));
		texture4 = new Texture(Gdx.files.internal("endmenu/EndScreen_4.png"));
		
		endImage1 = new Image(texture1);
		endImage2 = new Image(texture2);
		endImage3 = new Image(texture3);
		endImage4 = new Image(texture4);
		
		Endstage = new Stage();
		
		
		endImage1.setWidth(MouretsuNinja.WIDTH);
		endImage1.setHeight(MouretsuNinja.HEIGHT);
		Endstage.addActor(endImage1);
		
		endImage2.setWidth(250f);
		endImage2.setHeight(120f);
		endImage2.setPosition(MouretsuNinja.WIDTH/2-endImage2.getWidth()/2.1f, MouretsuNinja.HEIGHT/1.5f);
		Endstage.addActor(endImage2);
		
		endImage3.setWidth(250f);
		endImage3.setHeight(75f);
		endImage3.setPosition(MouretsuNinja.WIDTH/2-endImage3.getWidth()/2, MouretsuNinja.HEIGHT/2.1f);
		Endstage.addActor(endImage3);
		
		endImage4.setWidth(250f);
		endImage4.setHeight(75f);
		endImage4.setPosition(MouretsuNinja.WIDTH/2-endImage4.getWidth()/2, MouretsuNinja.HEIGHT/3.7f);
		Endstage.addActor(endImage4);
		
	
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
		texture4.dispose();
		Endstage.dispose();
		
	}

	
	
	

}
