package com.jjnegames.mouretsu.game.objects.characters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.jjnegames.mouretsu.game.MGame;

public class Player extends Char {

	public Player(Body body, Texture texture, float width, float height) {
		super(body, texture);


		this.setOriginX(width/2);
		this.setOriginY(height/2);
		this.setWidth(width);
		this.setHeight(height);
	}

	@Override
	protected void childUpdate(float delta) {
		if(Gdx.input.isKeyPressed(Keys.W)&&ableToJump){
        	body.applyForceToCenter(new Vector2(0,300), true);
        	ableToJump = false;
		} if (Gdx.input.isKeyPressed(Keys.A)){
			body.setLinearVelocity(new Vector2(-5,body.getLinearVelocity().y));
		} if (Gdx.input.isKeyPressed(Keys.D)){
			body.setLinearVelocity(new Vector2(5,body.getLinearVelocity().y));
		}
		
		
		World world = MGame.world;
		
		/*
		AABB testAABB = new AABB();
		testAABB.upperBound = player x, player y;
		testAABB.lowerBound = player.x + 0.001, player y + 0.001;
		 */
		
		final ArrayList<Fixture> shapesUnderCharacter = new ArrayList<Fixture>();
		world.QueryAABB(new QueryCallback(){

			@Override
			public boolean reportFixture(Fixture fixture) {
				shapesUnderCharacter.add(fixture);
				return true;
			}},
			
			body.getPosition().x-getWidth()/2+0.1f, 
			body.getPosition().y-getHeight()/2-0.1f, 
			body.getPosition().x+getWidth()/2-0.1f, 
			body.getPosition().y+getHeight()/0.1f);

		for(Fixture s : shapesUnderCharacter ){
			if(s.getBody().getType()==BodyType.KinematicBody||
					s.getBody().getType()==BodyType.StaticBody)
				ableToJump = true;
			
		}


		
    }
	
	public static Char create(World world, BodyDef bodyDef, float w, float h, Texture texture) {


        Body body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        PolygonShape shape = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
        shape.setAsBox(w/2, h/2);
        
        body.createFixture(shape, 1);
        
        // Create a body in the world using our definition

        
		return new Player(body, texture, w, h);
	}

}
