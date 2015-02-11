package com.jjnegames.mouretsu.game.objects.characters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.jjnegames.mouretsu.game.MGame;
import com.jjnegames.mouretsu.game.TextureBank;

public class Player extends Char {
	
	private GrapplingHook hook = null;

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
		}else if(Gdx.input.isKeyPressed(Keys.W) && hook!=null){
        	hook.isReeling=true;
		}else if(hook!=null){
			hook.isReeling=false;
		} if (Gdx.input.isKeyPressed(Keys.A)){
			body.applyForceToCenter(new Vector2(-200*delta,0), true);
		} if (Gdx.input.isKeyPressed(Keys.D)){
			body.applyForceToCenter(new Vector2(200*delta,0), true);
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.Q)){
			grapple();
		}
		
		


		
    }
	
	private void grapple(){
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
			
			float dist = (float)Math.sqrt((positionx-targetX)*(positionx-targetX)+(positiony-targetY)*(positiony-targetY));
			Vector2 linearVelocity = new Vector2(vX*dist*GrapplingHook.SPEED, vY*dist*GrapplingHook.SPEED);
			hook = GrapplingHook.create(body.getWorld(), bodyDef, 0.1f, TextureBank.alus, this, CATEGORY_PLAYER);
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

        // Now define the dimensions of the physics shape
        PolygonShape shape = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
        shape.setAsBox(w/2, h/2);
        
        FixtureDef fdef= new FixtureDef();
        fdef.shape=shape;
        fdef.density=1;
        fdef.filter.groupIndex=CATEGORY_PLAYER;
        
        Fixture f = body.createFixture(fdef);
        PolygonShape feet = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions 
        feet.setAsBox(w/2*0.6f, h/2*1.01f);
        FixtureDef feetfix = new FixtureDef();
        feetfix.shape = feet;
        feetfix.isSensor = true;
        feetfix.filter.groupIndex=CATEGORY_PLAYER;
        // Create a body in the world using our definition
        body.createFixture(feetfix);
        
        
        
        
        Player p = new Player(body, texture, w, h);
        body.setUserData(p);
		return p;
	}

}
