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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jjnegames.mouretsu.MouretsuNinja;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.Rect;


public class MGame {
	
	public ArrayList<GameObject> objects;
	World world;
	private Stage stage;
	private Stage background;
	private Stage hud;
	private Texture texture;
	private Image splashImage;
	public OrthographicCamera camera = new OrthographicCamera(64,64);
	public FitViewport fvp = new FitViewport(1,1,camera);
	
	
	public MGame(){
		objects = new ArrayList<GameObject>();
		world = new World(new Vector2(0, -8.89f), true);
		stage = new Stage();
		background = new Stage();
		hud = new Stage();
		
		stage.setViewport(fvp);
		
        
		Texture alus = new Texture(Gdx.files.internal("alus.png"), true);
		
		alus.setFilter(TextureFilter.MipMapLinearNearest, TextureFilter.Linear);
		
		Texture ground = new Texture(Gdx.files.internal("ground.jpg"), true);
		
		texture = new Texture (Gdx.files.internal("woods.jpg"), true);
		
		splashImage = new Image(texture);
		splashImage.setWidth(MouretsuNinja.WIDTH);
		splashImage.setHeight(MouretsuNinja.HEIGHT);
		background.addActor(splashImage);
		
		
			
			BodyDef bodyDef = new BodyDef();
	        bodyDef.type = BodyDef.BodyType.DynamicBody;
	        bodyDef.position.set(25f, 3f*1.1f);
	        bodyDef.angularVelocity=10.1f;
	        
	        
			Rect rectangle_1 = Rect.create(world, bodyDef,5f, 5f, alus);
	        stage.addActor(rectangle_1);
			
		
        BodyDef bodyDef2 = new BodyDef();
        bodyDef2.type=BodyType.KinematicBody;
        bodyDef2.position.set(1f, 0.5f);
        bodyDef2.angularVelocity=0;
        
        Rect rectangle_2 = Rect.create(world, bodyDef2, 100f, 1f, ground);
        stage.addActor(rectangle_2);
        
        BodyDef bodyDef3 = new BodyDef();
        bodyDef3.type=BodyType.KinematicBody;
        bodyDef3.position.set(1f, 25f);
        bodyDef3.angularVelocity=0;
        
        Rect rectangle_3 = Rect.create(world, bodyDef3, 0f, 5000f, ground);
        stage.addActor(rectangle_3);
		
        
        BodyDef bodyDef4 = new BodyDef();
        bodyDef4.type=BodyType.KinematicBody;
        bodyDef4.position.set(50f, 25f);
        bodyDef4.angularVelocity=0;
        
        Rect rectangle_4 = Rect.create(world, bodyDef4, 1f, 5000f, ground);
        stage.addActor(rectangle_3);
		
	}
	
	
	public void draw(){
		float delta =  Gdx.graphics.getDeltaTime();
		
		world.step(delta, 6, 2);
		
		background.act();
		background.draw();
		
		stage.act();
		stage.draw();
		
		hud.act();
		hud.draw();
	}
	
	public void dispose() {
		
	}

}
