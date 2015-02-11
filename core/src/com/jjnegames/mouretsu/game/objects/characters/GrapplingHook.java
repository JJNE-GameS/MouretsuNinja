package com.jjnegames.mouretsu.game.objects.characters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.*;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.TextureBank;
import com.jjnegames.mouretsu.game.objects.Ball;

public class GrapplingHook extends Ball{
	
	public static final float SPEED = 2f, REEL_SPEED=20;
	public Char chara;
	public boolean isReeling=true;
	public DistanceJoint limiter;

	public GrapplingHook(Body body, Texture texture, float radius, Char chara) {
		super(body, texture, radius);
		this.chara=chara;
	}
	
	@Override
	public void childUpdate(float delta){
		if(limiter!=null){
			if(limiter.getLength()>0.2f){
				limiter.setLength(limiter.getLength()-(REEL_SPEED*delta));
			}
			
//			for(DistanceJoint joint : ropeJoints){
//				
//				if(joint.getLength()>0f){
//					joint.setLength(joint.getLength()-(REEL_SPEED*delta)/ropeJoints.length*6);
//				}
//			}
		}
	}
	
	
	public static GrapplingHook create(World world, BodyDef bodyDef, float r, Texture texture, Char chara, short groupIndex) {


        Body body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        Shape shape = new CircleShape();
        // We are a ball, so this makes sense, no?
        // Basically set the physics circle to a circle with the same radius 
        shape.setRadius(r);
        FixtureDef fdef= new FixtureDef();
        fdef.shape=shape;
        fdef.density=1;
        fdef.filter.groupIndex=groupIndex;
        fdef.isSensor=true;
        
        FixtureDef fdef2= new FixtureDef();
        fdef2.shape=shape;
        fdef2.density=1;
        fdef2.filter.groupIndex=groupIndex;
        
        Fixture f = body.createFixture(fdef);
        Fixture f2 = body.createFixture(fdef2);

        // Create a body in the world using our definition

        
		GrapplingHook hook = new GrapplingHook(body, texture, r, chara);
		
		f2.setUserData(hook);
		f.setUserData(hook);
		body.setUserData(hook);
		return hook;
	}
	
	public void createRope(float distanceBetweenJoints){
		
		
		DistanceJointDef rj = new DistanceJointDef();
		rj.initialize(chara.getBody(), getBody(),
				chara.getBody().getWorldCenter(),
				getBody().getWorldCenter());
		rj.dampingRatio=0.5f;
		rj.frequencyHz=1.4f;
		DistanceJoint ropej = (DistanceJoint)body.getWorld().createJoint(rj);
		
		limiter=ropej;
		
	}
	
	public void destroyRope(){
		if(limiter!=null)
			getBody().getWorld().destroyJoint(limiter);
	}

}
