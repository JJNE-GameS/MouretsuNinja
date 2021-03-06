package com.jjnegames.mouretsu.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.jjnegames.mouretsu.MouretsuNinja;
import com.jjnegames.mouretsu.game.MGame;

public class GameHUD {
	
	private Texture texture1, texture2, texture3, texture4, texture5, texture6,texture7,texture8  ;
	private Image  backgroundImage, skillImage1, skillImage2, skillImage3, skillImage4, noHealthImage, healthImage, armorImage;
	private Stage stage;
	
	public void render(float delta) {
		stage.draw();
		if(MGame.player.skill1){
			 skillImage1.setVisible(true);
		}else{
			skillImage1.setVisible(false);
		}
		if(MGame.player.skill2){
			 skillImage2.setVisible(true);
		}else{
			skillImage2.setVisible(false);
		}
		if(MGame.player.skill3){
			 skillImage3.setVisible(true);
		}else{
			skillImage3.setVisible(false);
		}
		if(MGame.player.skill4){
			 skillImage4.setVisible(true);
		}else{
			skillImage4.setVisible(false);
		}
	
		healthImage.setWidth(380*(MGame.player.health/MGame.player.max_health));
		if(MGame.player.blocking && MGame.player.attackCooldown<=0){
			armorImage.setVisible(true);
			armorImage.setWidth(380*(MGame.player.block_shield/MGame.player.max_block_shield));
		}else{
			armorImage.setVisible(false);
		}
		
	}
		
		public void show() {
			
			texture1 = new Texture(Gdx.files.internal("hud/background_hud.png"));
			texture2 = new Texture(Gdx.files.internal("hud/skill1.png"));
			texture3 = new Texture(Gdx.files.internal("hud/locked.png"));
			texture4 = new Texture(Gdx.files.internal("hud/locked.png"));
			texture5 = new Texture(Gdx.files.internal("hud/locked.png"));
			texture6 = new Texture(Gdx.files.internal("hud/nohealth.png"));
			texture7 = new Texture(Gdx.files.internal("hud/health.png"));
			texture8 = new Texture(Gdx.files.internal("hud/armor.png"));
			
			backgroundImage = new Image(texture1);
			skillImage1 = new Image(texture2);
			skillImage2 = new Image(texture3);
			skillImage3 = new Image(texture4);
			skillImage4 = new Image(texture5);
			noHealthImage = new Image(texture6);
			healthImage = new Image(texture7);
			armorImage = new Image(texture8);
			
			stage = new Stage();
			

			

			
			skillImage1.setWidth(240);
			skillImage1.setHeight(70);
			skillImage1.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*0.429f, backgroundImage.getHeight()*0.045f);
			stage.addActor(skillImage1);
			
			skillImage2.setWidth(100);
			skillImage2.setHeight(60);
			skillImage2.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*-0.15f, backgroundImage.getHeight()*0.07f);
			stage.addActor(skillImage2);
			
			skillImage3.setWidth(100);
			skillImage3.setHeight(60);
			skillImage3.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*0.15f, backgroundImage.getHeight()*0.07f);
			stage.addActor(skillImage3);
			
			skillImage4.setWidth(100);
			skillImage4.setHeight(60);
			skillImage4.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*-0.02f, backgroundImage.getHeight()*0.07f);
			stage.addActor(skillImage4);
			
			noHealthImage.setWidth(380);
			noHealthImage.setHeight(13);
			noHealthImage.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*0.3f, backgroundImage.getHeight()*0.44f);
			stage.addActor(noHealthImage);
			
			healthImage.setWidth(380);
			healthImage.setHeight(13);
			healthImage.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*0.3f, backgroundImage.getHeight()*0.44f);
			stage.addActor(healthImage);
			
			armorImage.setWidth(380);
			armorImage.setHeight(13);
			armorImage.setPosition(MouretsuNinja.WIDTH/2 - backgroundImage.getWidth()*0.3f, backgroundImage.getHeight()*0.44f);
			stage.addActor(armorImage);
			
			backgroundImage.setWidth(700);
			backgroundImage.setHeight(180);
			backgroundImage.setPosition(MouretsuNinja.WIDTH/2- backgroundImage.getWidth()/2, -35);
			stage.addActor(backgroundImage);
			
	}
		
		public void dispose() {
			texture1.dispose();
			texture2.dispose();
			texture3.dispose();
			texture4.dispose();
			texture5.dispose();
			stage.dispose();
		}
	
	
}
