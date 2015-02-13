package com.jjnegames.mouretsu.game.objects.characters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.utils.AnimationHandler;

public abstract class Char extends GameObject {

	public boolean ableToJump = true;
	public Body feet;
	public Body attackConeRight,
	attackConeLeft;
	public Char inAttackCone=null;
	public float max_health=100;
	public float health=100;
	public float max_block_shield=300;
	public float block_shield=300;
	public float block_shield_regen=30;
	public boolean blocking = false;
	public float attack_damage=25;
	public boolean movingRight=true;
	public float jumpCooldown = 0f;
	public float attackCooldown = 0f;
	AnimationHandler animHandler;
	
	
	public Char(Body body, Texture texture) {
		super(body,texture);
	}
	
	public void damage(float amount) {
		if(blocking && attackCooldown<=0){
			block_shield-=amount;
			if(block_shield<0){
				health+=block_shield;
				block_shield=0;
			}
		}else{
			health-=amount;
		}
		if(health<=0)
			die();
	}
	
	public void die(){
		System.out.println("DEAD " +toString());
	}
	
	
	
}