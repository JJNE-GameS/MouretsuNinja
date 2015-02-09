package com.jjnegames.mouretsu.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Transform;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public abstract class GameObject extends Image{
	
	Body body;
	
	public GameObject(Body body, Texture texture){
		super(texture);
		this.body=body;
	}
	
	@Override
	public void act(float delta){
		Transform tf = body.getTransform();
		Vector2 pos = tf.getPosition();
		float ang = tf.getRotation();
		ang*=180/Math.PI;
		this.setPosition((pos.x-(getWidth()/2)), pos.y-(getHeight()/2));
		this.setRotation(ang);
		
	
		
		childUpdate(delta);
		
	}
	
	protected abstract void childUpdate(float delta);
	
	
}
