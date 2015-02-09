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
		
        
		WorldGenerator.createWorld(objects, world, stage, camera);
		
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
