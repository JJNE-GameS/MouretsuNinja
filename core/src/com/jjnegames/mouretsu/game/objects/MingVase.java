package com.jjnegames.mouretsu.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.objects.characters.AttackCone;
import com.jjnegames.mouretsu.game.objects.characters.Char;
import com.jjnegames.mouretsu.game.objects.characters.Player;
import com.jjnegames.mouretsu.game.objects.characters.SmallEnemy;

public class MingVase extends Char {

	public MingVase(Body body, Texture texture, float width, float height) {
		super(body, texture);
		this.setOriginX(width/2);
		this.setOriginY(height/2);
		this.setWidth(width*0.65f);
		this.setHeight(height*1.15f);
		health = 10;
		max_health = 10;
	}
	
	public static MingVase create(World world, BodyDef bodyDef, float w, float h,Texture texture

			){
	        Body body = world.createBody(bodyDef);
	       	        
    
	      //Create the first circle shape. It's offset from the center of the body by -2, 0.
	        CircleShape circleShape1 = new CircleShape();
	        circleShape1.setRadius(w*0.325f);
	        circleShape1.getPosition().set(0f, -h/4);
	        circleShape1.setPosition(new Vector2(0f, h/4));
	        
	        //Create the second circle shape. It's offset from the center of the body by 2, 0.
	        CircleShape circleShape2  = new CircleShape();
	        circleShape2.setRadius(w*0.325f);
	        circleShape2.getPosition().set(0f, h/4);
	        circleShape2.setPosition(new Vector2(0f, -h/4));
	        
	        FixtureDef fdef= new FixtureDef();
	        fdef.shape=circleShape1;
	        fdef.density=1.3f;
	        fdef.filter.groupIndex=GROUP_ENEMY;
	        
	        FixtureDef fdef2= new FixtureDef();
	        fdef2.shape=circleShape2;
	        fdef2.density=1.3f;
	        fdef2.filter.groupIndex=GROUP_ENEMY;
	        
	        Fixture f = body.createFixture(fdef);
	        Fixture f2 = body.createFixture(fdef2);
	     
	        body.setFixedRotation(true);
	        

			
			MingVase e = new MingVase(body, texture, w, h);
		    body.setUserData(e);
		  
		    return e;
	}

	
	float counter = 0;
	@Override
	protected void childUpdate(float delta) {

		if(dead){
			counter += delta;
			if(counter >= 5){
				World world = MGame.world;
				
				if(body != null)
				world.destroyBody(body);
				if(attackConeLeft != null)
				world.destroyBody(this.attackConeLeft);
				if(attackConeRight != null)
				world.destroyBody(this.attackConeRight);
				if(feet != null)
				world.destroyBody(this.feet);
				
				this.remove();
			
			}
			return;
		}
			
		
	}
	
	@Override
	public void die(){
		spawnSushi();
		counter = 0;
		dead = true;
		Filter f = new Filter();
		f.categoryBits = 1;
		f.groupIndex = 2;
		f.maskBits = (short) 0;
		
		getBody().getFixtureList().get(0).setFilterData(f);
		getBody().getFixtureList().get(1).setFilterData(f);
	}

	private void spawnSushi() {
		if(dead)
			return;
		MGame.stage.addActor(Sushi.create(this.getX(), this.getY()));
		
	}
	
	
	

}
