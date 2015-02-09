package com.jjnegames.mouretsu.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class Rect extends GameObject{
	
	
	public Rect(Body body, Texture texture, float width, float height) {
		super(body,texture);
		
		this.setOriginX(width/2);
		this.setOriginY(height/2);
		this.setWidth(width);
		this.setHeight(height);
		
	}
	
    
    
	@Override
	protected void childUpdate(float delta) {
		if(Gdx.input.isKeyPressed(Keys.W)){
        	body.applyForceToCenter(new Vector2(0f*delta,500f*delta), true);
        }
		if(Gdx.input.isKeyPressed(Keys.A)){
        	body.applyForceToCenter(new Vector2(-100f*delta,0f*delta), true);
        }
		if(Gdx.input.isKeyPressed(Keys.D)){
        	body.applyForceToCenter(new Vector2(100f*delta,0f*delta), true);
        }
	}

	public static Rect create(World world, BodyDef bodyDef, float w, float h, Texture texture) {


        Body body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        PolygonShape shape = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
        shape.setAsBox(w/2, h/2);
        FixtureDef fdef = new FixtureDef();
        fdef.shape=shape;
        fdef.density = 1f;
        fdef.restitution = 0;
        body.createFixture(fdef);
        
        
        // Create a body in the world using our definition

        
		return new Rect(body, texture, w, h);
	}
    
	
	
	
	
    /**
     *  
     */
//	public static Rectangle create() {
//		
//		
//	}
	

}
