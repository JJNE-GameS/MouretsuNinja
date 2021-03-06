package com.jjnegames.mouretsu.game.objects.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.TextureBank;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.Rect;
import com.jjnegames.mouretsu.game.utils.AnimationHandler;


public class Boss extends Char	{
		
		private static final float ATTACK_DURATION = 2f;
		private static final float ATTACK_DELAY = 1.9f;
		float counter = 0;
		boolean oikeelle = false;
		
	public Boss(Body body, Texture texture, float width, float height) {
		super(body,texture);
		
		max_health = 300;
		health = 300;
		this.attack_damage = 50;
		attackrange = 2f;
		MAX_MOVE_SPEED = 2;
		this.setOriginX(width/2);
		this.setOriginY(height/2);
		this.setWidth(width);
		this.setHeight(height);
		yOffset=-0.35f;


		this.animHandler=new AnimationHandler(new Texture[]{
				TextureBank.pl_enemyrun1,
				TextureBank.pl_enemyrun2,
				TextureBank.pl_enemyrun3,
				TextureBank.pl_enemyrun4,
				TextureBank.pl_enemyrun5,
				TextureBank.pl_enemyrun6
		}, 1f,
		new Texture[]{
				
				TextureBank.pl_enemyatk1,
				TextureBank.pl_enemyatk2,
				TextureBank.pl_enemyatk3,
				TextureBank.pl_enemyatk4,
				TextureBank.pl_enemyatk5,
				TextureBank.pl_enemyatk6,
				TextureBank.pl_enemyatk7,
				TextureBank.pl_enemyatk8,
				TextureBank.pl_enemyatk9,
				TextureBank.pl_enemyatk10,
				TextureBank.pl_enemyatk11
			
		}, ATTACK_DURATION,
		new Texture[]{
				
				TextureBank.pl_block1,
				TextureBank.pl_block2,
				TextureBank.pl_block3,
				TextureBank.pl_block4

				
		}, 0.5f,
		new Texture[]{
				
				TextureBank.pl_block1,
				TextureBank.pl_block2,
				TextureBank.pl_block3
		}, 0.5f,
		new Texture[]{
				TextureBank.pl_enemyrun1
		}, 0.8f,
		new Texture[]{
				TextureBank.pl_enemyrun1
		
		}, 0.8f,
		new Texture[]{
				TextureBank.pl_enemyrun1

		}, 0.8f,
		new Texture[]{
				TextureBank.pl_enemyrun1

		}, 1f,
		new Texture[]{
				TextureBank.pl_enemyrun1
		}, 1);
		
	}
	
	public static Boss create(World world, BodyDef bodyDef, float w, float h,Texture texture

			){
	        Body body = world.createBody(bodyDef);
	        
	        
	        BodyDef feetdef = new BodyDef();
	        feetdef.type=BodyType.DynamicBody;
	        feetdef.position.set(body.getPosition());
	        feetdef.position.y-=h/2f;
	        Body feet = world.createBody(feetdef);
	        

	        // Now define the dimensions of the physics shape
//	        PolygonShape shape = new PolygonShape();
	        // We are a box, so this makes sense, no?
	        // Basically set the physics polygon to a box with the same dimensions 
//	        shape.setAsBox(w*0.25f, h/2f);
	        
//	        Shape shape = new CircleShape();
//	        shape.setRadius(h*0.25f);
	        
	        
	        
	      //Create the first circle shape. It's offset from the center of the body by -2, 0.
	        CircleShape circleShape1 = new CircleShape();
	        circleShape1.setRadius(w*0.325f);
	        circleShape1.getPosition().set(0f, -h/4);
	        circleShape1.setPosition(new Vector2(0f, (h/4)-0.1f));
	        
	        //Create the second circle shape. It's offset from the center of the body by 2, 0.
	        CircleShape circleShape2  = new CircleShape();
	        circleShape2.setRadius(w*0.325f);
	        circleShape2.getPosition().set(0f, h/4);
	        circleShape2.setPosition(new Vector2(0f, (-h/4)-0.1f));
	        
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
	        
	        PolygonShape feetShape = new PolygonShape();
	        // We are a box, so this makes sense, no?
	        // Basically set the physics polygon to a box with the same dimensions 
	        feetShape.setAsBox(w*0.2f, h*0.1f);
	        
	       
	        FixtureDef feetfix = new FixtureDef();
	        feetfix.shape = feetShape;
	        feetfix.isSensor = true;
	        feetfix.filter.groupIndex=GROUP_ENEMY;
	        feetfix.density=0.0001f;
	        // Create a body in the world using our definition
	        feet.createFixture(feetfix);
	        
	        WeldJointDef wjd = new WeldJointDef();
	        wjd.initialize(body, feet, body.getWorldCenter());
	        
	        world.createJoint(wjd);
	        
	        
	        /*
	         * The right side attack sensor
	         */
	        BodyDef atkright = new BodyDef();
	        atkright.type=BodyType.DynamicBody;
	        atkright.position.set(body.getPosition());
	        atkright.position.x+=w/4f;
	        Body atkrb = world.createBody(atkright);

	        
	        PolygonShape atkrs = new PolygonShape();
	        // We are a box, so this makes sense, no?
	        // Basically set the physics polygon to a box with the same dimensions 
	        atkrs.setAsBox(w/2f, h/3f);
	        
	       
	        FixtureDef atrfdef = new FixtureDef();
	        atrfdef.shape = atkrs;
	        atrfdef.isSensor = true;
	        atrfdef.density=0.0001f;
	        atrfdef.filter.groupIndex=GROUP_ENEMY;
	        // Create a body in the world using our definition
	        atkrb.createFixture(atrfdef);
	        
	        WeldJointDef wjdar = new WeldJointDef();
	        wjdar.initialize(body, atkrb, body.getWorldCenter());
	        
	        world.createJoint(wjdar);
	        
	        
	        /*
	         * The right side attack sensor
	         */
	        BodyDef atkleft = new BodyDef();
	        atkleft.type=BodyType.DynamicBody;
	        atkleft.position.set(body.getPosition());
	        atkleft.position.x-=w/4f;
	        Body atklb = world.createBody(atkleft);
	        PolygonShape atkls = new PolygonShape();
	        // We are a box, so this makes sense, no?
	        // Basically set the physics polygon to a box with the same dimensions 
	        atkls.setAsBox(w/2f, h/3f);
	        
	       
	        FixtureDef atlfdef = new FixtureDef();
	        atlfdef.shape = atkls;
	        atlfdef.isSensor = true;
	        atlfdef.density=0.0001f;
	        atlfdef.filter.groupIndex=GROUP_ENEMY;
	        // Create a body in the world using our definition
	        atklb.createFixture(atlfdef);
	        
	        WeldJointDef wjdal = new WeldJointDef();
	        wjdal.initialize(body, atklb, body.getWorldCenter());
	        
	        world.createJoint(wjdal);
	        
	        
	        
	        body.setFixedRotation(true);
	        
//	        atkrb.getMassData().mass=0;
//	        atklb.getMassData().mass=0;
//	        atkrb.getMassData().I=0;
//	        atklb.getMassData().I=0;
			
			Boss e = new Boss(body, texture, w, h);
		    body.setUserData(e);
		    feet.setUserData(e);
		    atkrb.setUserData(new AttackCone(e, true));
	        atklb.setUserData(new AttackCone(e, false));
		    return e;
	}

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
		if(attackCooldown>0){
			setDrawable(animHandler.updateAtk(delta, movingRight));
		}else if(blocking){
			setDrawable(animHandler.updateBlock(delta, !movingRight));
		}else if(body.getLinearVelocity().y > 0.5 || body.getLinearVelocity().y < -0.5 || !ableToJump){
			setDrawable(animHandler.updateJump(delta, !movingRight));
		}else if(body.getLinearVelocity().x < 0.5 && body.getLinearVelocity().x > -0.5 ){
			setDrawable(animHandler.updateStand(delta, movingRight));
		}else{
		setDrawable(animHandler.updateRun(delta, movingRight));
		}
		counter += delta;
	
		float pdis = this.getBody().getPosition().x - MGame.player.getBody().getPosition().x;
		 if (pdis < 4.5 && pdis>0){
			 if(body.getLinearVelocity().x>-MAX_MOVE_SPEED)
			 body.applyForceToCenter(new Vector2(-880*delta,0), true);
			 movingRight=false;
		}else if (pdis < 0 ) {
			if(body.getLinearVelocity().x<MAX_MOVE_SPEED)
			body.applyForceToCenter(new Vector2(880*delta,0), true);
			movingRight=true;
		} if (counter>6) {
			counter = 0;
		}
		if(inAttackCone!=null && attackCooldown<=0){
			float distance =(float) Math.sqrt(Math.pow((body.getPosition().x - inAttackCone.getBody().getPosition().x),2)+ Math.pow((body.getPosition().y- inAttackCone.getBody().getPosition().y),2));
			if(distance <= inAttackCone.getWidth()/4+attackrange+this.getWidth()/4 && inAttackCone instanceof Player){
				attack();
			}
		}
		World world = MGame.world;
		
		if(attackCooldown>0){
			attackCooldown-=delta;
			if(ATTACK_DURATION-attackCooldown >= ATTACK_DELAY && !attacked){
				if(inAttackCone!=null){
					attacked = true;
					float distance =(float) Math.sqrt(Math.pow((body.getPosition().x - inAttackCone.getBody().getPosition().x),2)+ Math.pow((body.getPosition().y- inAttackCone.getBody().getPosition().y),2));
					if(distance <= inAttackCone.getWidth()/4+attackrange+this.getWidth()/4){
						if(specialatk)
							inAttackCone.damage(special_attack_damage, attackingFromRight);
						else
							inAttackCone.damage(attack_damage, attackingFromRight);
						System.out.println("hit "+inAttackCone.toString());


					}
				}
			}
		}
		
		
		
	}
	
	private void attack() {
		if(inAttackCone!=null && attackCooldown<=0){
			attacked = false;
			attackCooldown=ATTACK_DURATION;
		}else if(attackCooldown<=0)
			attackCooldown=ATTACK_DURATION;
		
	}
	
	@Override
	public void die(){
		counter = 0;
		dead = true;
		Filter f = new Filter();
		f.categoryBits = 1;
		f.groupIndex = 2;
		f.maskBits = (short) 0;
		
		getBody().getFixtureList().get(0).setFilterData(f);
		getBody().getFixtureList().get(1).setFilterData(f);
	}

}