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


public class MGame {
	
	public ArrayList<GameObject> objects;
	World world;
	private Stage stage;
	public OrthographicCamera camera = new OrthographicCamera(64,64);
	public FitViewport fvp = new FitViewport(1,1,camera);
	
	
	public MGame(){
		objects = new ArrayList<GameObject>();
		world = new World(new Vector2(0, -8.89f), true);
		stage = new Stage();
		
		stage.setViewport(fvp);
		
        
		Texture alus = new Texture(Gdx.files.internal("alus.png"), true);
		
		alus.setFilter(TextureFilter.MipMapLinearNearest, TextureFilter.Linear);
		
		
		
		BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(1f, 3f);
        bodyDef.angularVelocity=2.1f;
        
        
		Rect rectangle_1 = Rect.create(world, bodyDef, 1f, 1f, alus);
        stage.addActor(rectangle_1);
        
        BodyDef bodyDef2 = new BodyDef();
        bodyDef2.type=BodyType.KinematicBody;
        bodyDef2.position.set(1f, 0.2f);
        bodyDef2.angularVelocity=0;
        
        Rect rectangle_2 = Rect.create(world, bodyDef2, 3f, 1f, alus);
        stage.addActor(rectangle_2);
        
		stage.setDebugUnderMouse(true);
		stage.setDebugAll(true);
	}
	
	
	public void draw(){
		float delta =  Gdx.graphics.getDeltaTime();
		
		world.step(delta, 6, 2);
		
		stage.act();
		stage.draw();
	}
	
	public void dispose() {
		
	}

}
