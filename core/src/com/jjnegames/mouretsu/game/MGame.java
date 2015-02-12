package com.jjnegames.mouretsu.game;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
	
	public static volatile LinkedList<Function> functions = new LinkedList<Function>();
	public static ArrayList<GameObject> objects;
	public static World world;
	public static Stage stage;
	public static OrthographicCamera camera = new OrthographicCamera(64,64);
	public static FitViewport fvp = new FitViewport(1,1,camera);
	public static Player player;
	
	
	public MGame(){
		objects = new ArrayList<GameObject>();
		world = new World(new Vector2(0, -8.89f), true);
		stage = new Stage();
		
		stage.setViewport(fvp);
		
        
		WorldGenerator.createWorld(objects, world, stage, camera);
		
		
		
	}
	
	
	public void draw(boolean paused){
		float delta =  Gdx.graphics.getDeltaTime();
		if(!paused){
			world.step(delta, 6, 2);
			if(!functions.isEmpty())
				functions.remove().exec();
			stage.act();
		}
		stage.draw();
		camera.position.set(player.getX()+3, player.getY()+4, 0);
		camera.update();
	}
	
	public void dispose() {
        

		
	}
	
}
