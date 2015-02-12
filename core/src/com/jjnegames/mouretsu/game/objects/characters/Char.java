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

public abstract class Char extends GameObject {

	public boolean ableToJump = true;
	public Body feet;
	public Body attackConeRight,
	attackConeLeft;
	public Char inAttackCone=null;
	
	public Char(Body body, Texture texture) {
		super(body,texture);
	}
	
}