package com.jjnegames.mouretsu.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.TextureBank;
import com.jjnegames.mouretsu.game.objects.characters.SmallEnemy;

public class Sushi extends Ball {

	public Sushi(Body body, Texture texture, float radius) {
		super(body, texture, radius);
		createTime=System.currentTimeMillis();
		
	}
	
	public boolean del=false;
	public long createTime;
	public static Sushi create(float x, float y){
		
		BodyDef bodyDef8 = new BodyDef();
		bodyDef8.type = BodyDef.BodyType.DynamicBody;
		bodyDef8.position.set(x,y);
		bodyDef8.angularVelocity = 0;

        Body body = MGame.world.createBody(bodyDef8);

        // Now define the dimensions of the physics shape
        Shape shape = new CircleShape();
        // We are a ball, so this makes sense, no?
        // Basically set the physics circle to a circle with the same radius 
        shape.setRadius(0.15f);
        
        body.createFixture(shape, 1);
        body.setFixedRotation(true);
        
        FixtureDef fdef= new FixtureDef();
        fdef.shape=shape;
        fdef.density=0.001f;
        fdef.filter.groupIndex=GROUP_ENEMY;
        fdef.isSensor=true;
        // Create a body in the world using our definition

        Sushi s = new Sushi(body, TextureBank.sushi, 0.15f);
        body.setUserData(s);
		return s;
	
		
	}
	
	@Override
	public void childUpdate(float delta){
		if(del){
			MGame.world.destroyBody(body);
			remove();
		}
	}
	
}
