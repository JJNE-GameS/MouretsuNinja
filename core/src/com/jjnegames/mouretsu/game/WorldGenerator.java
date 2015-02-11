package com.jjnegames.mouretsu.game;

import java.util.ArrayList;

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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.Rect;
import com.jjnegames.mouretsu.game.objects.characters.Char;
import com.jjnegames.mouretsu.game.objects.characters.Enemy;
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
		Char character_1 = Player.create(world, bodyDef, 1f, 1f,TextureBank.alus);
		stage.addActor(character_1);
		

		BodyDef bodyDef3 = new BodyDef();
		bodyDef3.type = BodyDef.BodyType.DynamicBody;
		bodyDef3.position.set(25f, 25f);
		bodyDef3.angularVelocity = 0;
		Char character_2 = Enemy.create(world, bodyDef3, 3f, 3f,TextureBank.vihollinen);
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
				stage.addActor(rectangle_2);
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
	            
	            if(x1.getBody().getUserData()!= null)
	            if(x1.getBody().getUserData() instanceof Player && x2.getBody().getType().equals(BodyType.KinematicBody))
	            {
	            	Player p = (Player) x1.getBody().getUserData();
	            	if(!p.ableToJump){
	            		p.ableToJump = true;
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
