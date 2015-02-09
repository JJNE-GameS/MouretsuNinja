package com.jjnegames.mouretsu.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.Rect;
import com.jjnegames.mouretsu.game.objects.characters.Char;
import com.jjnegames.mouretsu.game.objects.characters.Player;


public class MGame {
	
	public ArrayList<GameObject> objects;
	public static World world;
	private Stage stage;
	public OrthographicCamera camera = new OrthographicCamera(64,64);
	public FitViewport fvp = new FitViewport(1,1,camera);
	
	
	public MGame(){
		objects = new ArrayList<GameObject>();
		world = new World(new Vector2(0, -8.89f), true);
		stage = new Stage();
		
		stage.setViewport(fvp);
		
        
		Texture alus = new Texture(Gdx.files.internal("alus.png"), true);
		
		//Nearest on terävämpi mutta ei toimi hyvin pyöriessä ja Linear on epäselvempi mutta parempi vaihtoehto pyörivälle objektille
		alus.setFilter(TextureFilter.MipMapLinearNearest, TextureFilter.Linear);
		
		
		/*
		for(int x=0;x<20;x++){
			for(int y=0;y<20;y++){
				BodyDef bodyDef = new BodyDef();
				//DynamicBodylla luotu objekti voi liikkua
		        bodyDef.type = BodyDef.BodyType.DynamicBody;
		        
		        //Spawnpoint
		        bodyDef.position.set(1f+x*2.01f, 3f+y*2.01f);
		        //Rotation speed when spawned
		        bodyDef.angularVelocity=-2.1f;
		       
		        
		        //Luodaan rectangle jolle kerrotaan pelimaailma johon spawnataan, sijainti&pyörimisnopeus jne, leveys, korkeus, kuva joka kertoo miltä objekti näyttää
				Rect rectangle_1 = Rect.create(world, bodyDef, 1f, 1f, alus);
		        stage.addActor(rectangle_1);
			}
		}*/
        
        BodyDef bodyDef2 = new BodyDef();
        //KinematicBodylla luotu objekti ei voi liikkua
        bodyDef2.type=BodyType.KinematicBody;
        bodyDef2.position.set(25f, 0.2f);
        bodyDef2.angularVelocity=0;
        
        Rect rectangle_2 = Rect.create(world, bodyDef2, 50f, 1f, alus);
        stage.addActor(rectangle_2);
        
		
		BodyDef bodyDef3 = new BodyDef();
		bodyDef3.type=BodyType.DynamicBody;
		bodyDef3.position.set(3f, 3f);
		bodyDef3.angularVelocity=0;
		
		Char character_1 = Player.create(world, bodyDef3, 2f, 2f, alus);
		stage.addActor(character_1);
		
	}
	
	
	public void draw(){
		float delta =  Gdx.graphics.getDeltaTime();
		
		world.step(delta, 6, 2);
		
		stage.act();
		stage.draw();
	}
	
	public void dispose() {
		
	}
