package com.jjnegames.mouretsu.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public class Ball extends GameObject{

	public Ball(Body body, Texture texture) {
		super(body, texture);

	}
	
	public Ball(Body body, Texture texture, float radius) {
		super(body,texture);
		
		this.setOriginX(radius);
		this.setOriginY(radius);
		this.setWidth(radius*2);
		this.setHeight(radius*2);
		
	}
	
	
	public static Ball create(World world, BodyDef bodyDef, float r, Texture texture) {


        Body body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        Shape shape = new CircleShape();
        // We are a ball, so this makes sense, no?
        // Basically set the physics circle to a circle with the same radius 
        shape.setRadius(r);
        
        body.createFixture(shape, 1);
        
        // Create a body in the world using our definition

        
		return new Ball(body, texture, r);
	}
	
	public static Ball create(World world, BodyDef bodyDef, float r, Texture texture, short groupIndex) {


        Body body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        Shape shape = new CircleShape();
        // We are a ball, so this makes sense, no?
        // Basically set the physics circle to a circle with the same radius 
        shape.setRadius(r);
        FixtureDef fdef= new FixtureDef();
        fdef.shape=shape;
        fdef.density=0.001f;
        fdef.filter.groupIndex=groupIndex;
        body.createFixture(fdef);
        
        // Create a body in the world using our definition

        
		return new Ball(body, texture, r);
	}


	@Override
	protected void childUpdate(float delta) {
		// TODO Auto-generated method stub
		
	}

}
