package com.jjnegames.mouretsu.game.objects.characters;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.JointEdge;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.TextureBank;
import com.jjnegames.mouretsu.game.utils.AnimationHandler;
import com.jjnegames.mouretsu.screens.Splash;

public class Player extends Char {
	
	private static final float ATTACK_DELAY = 0.5f;
	public static float ATTACK_DURATION=0.7f;
	
	public GrapplingHook hook = null;
	public boolean skill1 = true,skill2 = true,skill3 = true,skill4 = true;
	
	public Player(Body body, Body feet, Body attackConeRight, Body attackConeLeft, Texture texture, float width, float height) {
		super(body, texture);
		health=100;
		attackrange = 0.7f;
		
		this.animHandler=new AnimationHandler(new Texture[]{
				TextureBank.pl_run1,
				TextureBank.pl_run2,
				TextureBank.pl_run3,
				TextureBank.pl_run4,
				TextureBank.pl_run5,
				TextureBank.pl_run6,
				TextureBank.pl_run7,
				TextureBank.pl_run8

		}, 1f,
		new Texture[]{
				
				TextureBank.pl_atk1,
				TextureBank.pl_atk2,
				TextureBank.pl_atk3,
				TextureBank.pl_atk4,
				TextureBank.pl_atk5
		}, ATTACK_DURATION,
		new Texture[]{
				
				TextureBank.pl_block1,
				TextureBank.pl_block2,
				TextureBank.pl_block3

				
		}, 0.5f,
		new Texture[]{
				
				TextureBank.pl_block1,
				TextureBank.pl_block2,
				TextureBank.pl_block3,
				TextureBank.pl_block4
		}, 0.5f,
		new Texture[]{
				TextureBank.pl_jump1,
				TextureBank.pl_jump2

		}, 0.8f,
		new Texture[]{
				TextureBank.pl_jump3,
				TextureBank.pl_jump4

		}, 0.8f,
		new Texture[]{
				TextureBank.pl_jump1,
				TextureBank.pl_jump2,
				TextureBank.pl_jump3,
				TextureBank.pl_jump4
		}, 0.8f,
		new Texture[]{
				TextureBank.pl_idle1,
				TextureBank.pl_idle2,
				TextureBank.pl_idle3,
				TextureBank.pl_idle4
		}, 1f,
		new Texture[]{
				TextureBank.pl_spatk1,
				TextureBank.pl_spatk2,
				TextureBank.pl_spatk3,
				TextureBank.pl_spatk4,
				TextureBank.pl_spatk5

		}, ATTACK_DURATION);
		this.feet=feet;
		this.attackConeRight=attackConeRight;
		this.attackConeLeft=attackConeLeft;

		this.setOriginX(width/2);
		this.setOriginY((height*1.8f)/2f);
		this.setWidth(width);
		this.setHeight((height*1.37f));
	}

	@Override
	protected void childUpdate(float delta) {
		
		if(attackCooldown>0){
			if(specialatk){
				setDrawable(animHandler.updateSpatk(delta, !movingRight));
				
			}else{
				setDrawable(animHandler.updateAtk(delta, !movingRight));
				
			}
		}else if(blocking){
			setDrawable(animHandler.updateBlock(delta, !movingRight));
		}
		else if(body.getLinearVelocity().y > 0.5 || body.getLinearVelocity().y < -0.5 || !ableToJump){
			if(getBody().getLinearVelocity().y > 0){
				setDrawable(animHandler.updateJump(delta, !movingRight));
			}else{
				setDrawable(animHandler.updateJumpDown(delta, !movingRight));
			}
				
		}else if(body.getLinearVelocity().x < 0.5 && body.getLinearVelocity().x > -0.5 ){
			setDrawable(animHandler.updateStand(delta, !movingRight));
		}else{
		setDrawable(animHandler.updateRun(delta, !movingRight));
		}
		if(jumpCooldown>0){
			jumpCooldown-=delta;
		}if(attackCooldown>0){
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
		}if(special_attack_cooldown > 0){
			special_attack_cooldown -= delta;
		}
		if((Gdx.input.isKeyPressed(Keys.W)||Gdx.input.isKeyPressed(Keys.SPACE))&&ableToJump&&jumpCooldown<=0){
        	body.applyForceToCenter(new Vector2(0,300), true);
        	ableToJump = false;
        	jumpCooldown=1f;
		}else if(Gdx.input.isKeyPressed(Keys.W) && hook!=null){
        	hook.isReeling=true;
		}else if(hook!=null){
			hook.isReeling=false;
		} if (Gdx.input.isKeyPressed(Keys.A)){
			System.out.println();
			if(body.getLinearVelocity().x>-MAX_MOVE_SPEED)
				body.applyForceToCenter(new Vector2(-200*delta,0), true);
			movingRight=false;
		} if (Gdx.input.isKeyPressed(Keys.D)){
			if(body.getLinearVelocity().x<MAX_MOVE_SPEED)
			body.applyForceToCenter(new Vector2(200*delta,0), true);
			movingRight=true;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.Q)){
			grapple();
		}
		if(Gdx.input.isButtonPressed(Buttons.LEFT)){
			attack(false);
		}if (Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
			blocking=true;
		}else{
			blocking=false;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.NUM_1)){
			attack(true);
		}
		
		if(block_shield < max_block_shield){
			block_shield += block_shield_regen*delta;
		}
		
    }
	
	

	public void grapple(){
		if(hook==null){
			Vector3 worldCoordinates = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			Vector3 gameCoord = MGame.camera.unproject(worldCoordinates);
			System.out.println(gameCoord);
			float targetX = gameCoord.x, targetY =gameCoord.y;
			float positionx = body.getPosition().x, positiony = body.getPosition().y;
			float vX =(float)( (targetX - positionx)/Math.sqrt(((targetX - positionx) * (targetX - positionx)) + ((targetY - positiony) *(targetY - positiony ))));
			float vY =(float)( (targetY - positiony)/Math.sqrt(((targetY - positiony) * (targetY - positiony)) + ((targetX - positionx) *(targetX - positionx ))));
		
			BodyDef bodyDef = new BodyDef();
			// DynamicBodylla luotu objekti voi liikkua
			bodyDef.type = BodyDef.BodyType.DynamicBody;
	
			// Spawnpoint
			bodyDef.position.set(positionx, positiony);
			// Rotation speed when spawned
			bodyDef.angle = (float) (Math.atan2(vY, vX)- Math.PI/2);
			float dist = (float)Math.sqrt((positionx-targetX)*(positionx-targetX)+(positiony-targetY)*(positiony-targetY));
			Vector2 linearVelocity = new Vector2(vX*GrapplingHook.SPEED, vY*GrapplingHook.SPEED);
			hook = GrapplingHook.create(body.getWorld(), bodyDef, 0.2f, TextureBank.hook, this, GROUP_PLAYER);
			hook.getBody().setLinearVelocity(linearVelocity);
			MGame.stage.addActor(hook);
		}else{
			hook.destroyRope();
			hook.getBody().getWorld().destroyBody(hook.getBody());
			hook.remove();
			hook=null;
		}

	}
	
	
	
	public static Char create(World world, BodyDef bodyDef, float w, float h, Texture texture) {

		
        Body body = world.createBody(bodyDef);
        
        
        BodyDef feetdef = new BodyDef();
        feetdef.type=BodyType.DynamicBody;
        feetdef.position.set(body.getPosition());
        feetdef.position.y-=h/2f;
        Body feet = world.createBody(feetdef);
        

        // Now define the dimensions of the physics shape
//        PolygonShape shape = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
//        shape.setAsBox(w*0.25f, h/2f);
        
//        Shape shape = new CircleShape();
//        shape.setRadius(h*0.25f);
        
        
        
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
        fdef.filter.groupIndex=GROUP_PLAYER;
        
        FixtureDef fdef2= new FixtureDef();
        fdef2.shape=circleShape2;
        fdef2.density=1.3f;
        fdef2.filter.groupIndex=GROUP_PLAYER;
        
        Fixture f = body.createFixture(fdef);
        Fixture f2 = body.createFixture(fdef2);
        
        PolygonShape feetShape = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
        feetShape.setAsBox(w*0.2f, h*0.1f);
        
       
        FixtureDef feetfix = new FixtureDef();
        feetfix.shape = feetShape;
        feetfix.isSensor = true;
        feetfix.filter.groupIndex=GROUP_PLAYER;
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
        atrfdef.filter.groupIndex=GROUP_PLAYER;
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
        atlfdef.filter.groupIndex=GROUP_PLAYER;
        // Create a body in the world using our definition
        atklb.createFixture(atlfdef);
        
        WeldJointDef wjdal = new WeldJointDef();
        wjdal.initialize(body, atklb, body.getWorldCenter());
        
        world.createJoint(wjdal);
        
        
        
        body.setFixedRotation(true);
        
//        atkrb.getMassData().mass=0;
//        atklb.getMassData().mass=0;
//        atkrb.getMassData().I=0;
//        atklb.getMassData().I=0;

        
        Player p = new Player(body, feet, atkrb, atklb, texture, w, h);
        body.setUserData(p);
        feet.setUserData(p);
        atkrb.setUserData(new AttackCone(p, true));
        atklb.setUserData(new AttackCone(p, false));

		return p;
	}
	
	@Override
	public void die(){
		((Game)Gdx.app.getApplicationListener()).getScreen().pause();
		health=-1;
		MGame.gameover = true;
	}

	

}
