package com.jjnegames.mouretsu.game;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.characters.Player;


public class MGame {
	
	public static volatile LinkedList<Function> functions = new LinkedList<Function>();
	public static ArrayList<GameObject> objects;
	public static World world;
	public static Stage stage;
	public static OrthographicCamera camera = new OrthographicCamera(64,64);
	public static FitViewport fvp = new FitViewport(1,1,camera);
	public static Player player;
	public Box2DDebugRenderer debugger;
	
	
	public MGame(){
		objects = new ArrayList<GameObject>();
		world = new World(new Vector2(0, -8.89f), true);
		stage = new Stage();
		
		stage.setViewport(fvp);
		
        
		WorldGenerator.createWorld(objects, world, stage, camera);
		debugger = new Box2DDebugRenderer( true, true, true, true ,true, true);
		
	}
	
	
	public void draw(){
		float delta =  Gdx.graphics.getDeltaTime();
		
		camera.position.set(player.getX()+2, player.getY()+3, 0);
		camera.update();
		world.step(delta, 6, 2);
		if(!functions.isEmpty())
			functions.remove().exec();
		stage.act();
		stage.draw();
		debugger.render(world, camera.combined);
	}
	
	public void dispose() {
		
	}
}
