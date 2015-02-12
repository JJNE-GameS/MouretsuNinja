package com.jjnegames.mouretsu.game;

import java.util.ArrayList;
	


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jjnegames.mouretsu.game.objects.Ball;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.Rect;
import com.jjnegames.mouretsu.game.objects.characters.Char;
import com.jjnegames.mouretsu.game.objects.characters.Enemy;
import com.jjnegames.mouretsu.game.objects.characters.GrapplingHook;
import com.jjnegames.mouretsu.game.objects.characters.Player;
import com.jjnegames.mouretsu.game.utils.MapFileReader;

public class WorldGenerator {

	public static void createWorld(ArrayList<GameObject> objects, World world,
			Stage stage, OrthographicCamera camera) {
		
		 int[][] map = MapFileReader.Loadmap();
			 
		// Nearest on terävämpi mutta ei toimi hyvin pyöriessä ja Linear on
		// epäselvempi mutta parempi vaihtoehto pyörivälle objektille
		TextureBank.alus.setFilter(TextureFilter.MipMapLinearNearest,
				TextureFilter.Linear);

		BodyDef bodyDef = new BodyDef();
		// DynamicBodylla luotu objekti voi liikkua
		bodyDef.type = BodyDef.BodyType.DynamicBody;

		// Spawnpoint
		bodyDef.position.set(3f, 3f);
		// Rotation speed when spawned
		bodyDef.angularVelocity = 0;

		// Luodaan rectangle jolle kerrotaan pelimaailma johon spawnataan,
		// sijainti&pyörimisnopeus jne, leveys, korkeus, kuva joka kertoo miltä
		// objekti näyttää
		Player character_1 = (Player) Player.create(world, bodyDef, 1f, 1f,TextureBank.alus);
		MGame.player=character_1;
		stage.addActor(character_1);
		
		BodyDef bodyDef3 = new BodyDef();
		bodyDef3.type = BodyDef.BodyType.DynamicBody;
		bodyDef3.position.set(10f, 3f);
		bodyDef3.angularVelocity = 0;
		Char character_2 = Enemy.create(world, bodyDef3, 1f, 1f,TextureBank.vihollinen);
		stage.addActor(character_2);

		
		
		for(int x=0;x<map.length;x++){
			for(int y=0;y<map[x].length;y++){
				if(map[x][y]== 1){
				BodyDef bodyDef2 = new BodyDef();
				// KinematicBodylla luotu objekti ei voi liikkua
				bodyDef2.type = BodyType.KinematicBody;
				bodyDef2.position.set(x, y);
				bodyDef2.angularVelocity = 0;

				Rect rectangle_2 = Rect.create(world, bodyDef2, 1f, 1f,TextureBank.alus);
//				Ball rectangle_2 = Ball.create(world, bodyDef2, 0.5f, TextureBank.alus);

				stage.addActor(rectangle_2);
				
				}else if(map[x][y]== 2){
					BodyDef bodyDef4 = new BodyDef();
					bodyDef4.type = BodyType.KinematicBody;
					bodyDef4.position.set(x, y);
					bodyDef4.angularVelocity = 0;

					Rect rectangle_3 = Rect.create(world, bodyDef4, 1f, 1f,TextureBank.esine1);

					stage.addActor(rectangle_3);
					
				}else if(map[x][y]== 3){
					BodyDef bodyDef5 = new BodyDef();
					bodyDef5.type = BodyType.KinematicBody;
					bodyDef5.position.set(x, y);
					bodyDef5.angularVelocity = 0;

					Rect rectangle_4 = Rect.create(world, bodyDef5, 1f, 1f,TextureBank.esine2);


					stage.addActor(rectangle_4);
					
				}else if(map[x][y]== 4){
					BodyDef bodyDef6 = new BodyDef();
					bodyDef6.type = BodyType.KinematicBody;
					bodyDef6.position.set(x, y);
					bodyDef6.angularVelocity = 0;

					Rect rectangle_5 = Rect.create(world, bodyDef6, 1f, 1f,TextureBank.esine3);


					stage.addActor(rectangle_5);
					
				}
			
			}
		}
		

		// BodyDef bodyDef3 = new BodyDef();
		// bodyDef3.type=BodyType.DynamicBody;
		// bodyDef3.position.set(3f, 3f);
		// bodyDef3.angularVelocity=0;
		//
		// Char character_1 = Player.create(world, bodyDef3, 2f, 2f, alus);
		// stage.addActor(character_1);
		//

		world.setContactListener(createContactListener());
	}
	
	private  static ContactListener createContactListener()
	{
	    ContactListener contactListener = new ContactListener()
	    {
	        @Override
	        public void beginContact(Contact contact)
	        {

	        	final Fixture x1 = contact.getFixtureA();
	            final Fixture x2 = contact.getFixtureB();
	            

	            if(x1.getBody().getUserData()!= null){
		            if(x1.getBody().getUserData() instanceof Player && x2.getBody().getType().equals(BodyType.KinematicBody))
		            {
		            	Player p = (Player) x1.getBody().getUserData();
		            	if(!p.ableToJump){
		            		p.ableToJump = true;
		            	}
		            }else if (x1.getBody().getUserData() instanceof GrapplingHook){
		            	GrapplingHook hook = (GrapplingHook) x1.getBody().getUserData();
		            	WeldJointDef wj = new WeldJointDef();
		            	wj.initialize(x1.getBody(), x2.getBody(), x1.getBody().getWorldCenter());
		            	MGame.world.createJoint(wj);
		            }else{
		            }
	            }
	            
	            if(x2.getBody().getUserData()!= null){
		            if(x2.getBody().getUserData() instanceof Player && x1.getBody().getType().equals(BodyType.KinematicBody))
		            {
		            	Player p = (Player) x2.getBody().getUserData();
		            	if(!p.ableToJump){
		            		p.ableToJump = true;
		            	}
		            }else if (x2.getBody().getUserData() instanceof GrapplingHook){
		            	
		            	MGame.functions.add(new Function(){
		            		public void exec(){
		            			GrapplingHook hook = (GrapplingHook) x2.getBody().getUserData();
				            	if(hook.limiter!=null)
				            		return;
			            		System.out.println("excuting");
			            		hook.createRope(0.5f);
			            		WeldJointDef wj = new WeldJointDef();
			                	wj.initialize(x2.getBody(), x1.getBody(), x2.getBody().getWorldCenter());
			                	MGame.world.createJoint(wj);
			                	
		            			
		            		}
		            		
		            	});
		            }else{
		            }
	            }
	            

	        }

	        @Override
	        public void endContact(Contact contact)
	        {
	               
	        }

	        @Override
	        public void preSolve(Contact contact, Manifold oldManifold)
	        {
	               
	        }

	        @Override
	        public void postSolve(Contact contact, ContactImpulse impulse)
	        {
	               
	        }
	    };
	    return contactListener;
	}
}
