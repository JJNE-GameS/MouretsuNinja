package com.jjnegames.mouretsu.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.Rect;


	public class Enemy extends Char	{
		
		float counter = 0;
		boolean oikeelle = false;
		
	public Enemy(Body body, Texture texture, float width, float height) {
		super(body,texture);
		
		this.setOriginX(width/2);
		this.setOriginY(height/2);
		this.setWidth(width);
		this.setHeight(height);
		
		
	}
	
	public static Enemy create(World world, BodyDef bodyDef3, float w, float h,
			Texture vihollinen) {
		 	Body body = world.createBody(bodyDef3);
		  
	        PolygonShape shape = new PolygonShape();

	        shape.setAsBox(w/2, h/2);
	        
	        body.createFixture(shape, 1);
	        
	 

			Enemy e = new Enemy(body, vihollinen, w, h);
		    body.setUserData(e);
		    return e;
	}

	@Override
	protected void childUpdate(float delta) {
		
	counter += delta;
		
		 if (counter<3){
			// oikeelle = !oikeelle;
			body.setLinearVelocity(new Vector2(-3,body.getLinearVelocity().y));
		} if (counter>3) {
			
			body.setLinearVelocity(new Vector2(3,body.getLinearVelocity().y));
		} if (counter>6) {
			counter = 0;
		}
		
		World world = MGame.world;
		
	}

}