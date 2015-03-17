package com.jjnegames.mouretsu.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Triangle extends GameObject{
	
	
	public Triangle(Body body, Texture texture, float width, float height) {
		super(body,texture);
		
		this.setOriginX(width/2);
		//this.setOriginY(height/2);
		this.setWidth(width);
		this.setHeight(height);
		
	}
	
    
    
	@Override
	protected void childUpdate(float delta) {
		//if(Gdx.input.isKeyPressed(Keys.W)){
        //	body.applyForceToCenter(new Vector2(0f*delta,500f*delta), true);
       // }
		
	}

	public static Triangle create(World world, BodyDef bodyDef, float w, float h, Texture texture) {


        Body body = world.createBody(bodyDef);

        Vector2[] vertices = new Vector2[3];

        vertices[0] = new Vector2(0f  , 0f  );
        vertices[1] = new Vector2(w , 0f  );
        vertices[2] = new Vector2(0f , h);
     /*   vertices[3] = new Vector2(0.322f , 0.341f);
        vertices[4] = new Vector2(0.225f , 0.322f);
        vertices[5] = new Vector2(0.282f , 0.398f);     
        vertices[6] = new Vector2(0.161f , 0.457f);
        vertices[7] = new Vector2(0.135f , 0.298f);*/
        PolygonShape shape = new PolygonShape();
        shape.set(vertices);
        // Now define the dimensions of the physics shape
        
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
        
        body.createFixture(shape, 1);
        
        // Create a body in the world using our definition

        
		return new Triangle(body, texture, w, h);
	}
    
	
	
	
	
    /**
     *  
     */

}
