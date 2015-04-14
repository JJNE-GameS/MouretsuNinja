package com.jjnegames.mouretsu.game;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jjnegames.mouretsu.MouretsuNinja;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.characters.Player;
import com.jjnegames.mouretsu.screens.GameHUD;


public class MGame {
	
	public static volatile LinkedList<Function> functions = new LinkedList<Function>();
	public static ArrayList<GameObject> objects;
	public static World world;
	public static Stage stage;
	public static Stage background,backgroundObjects;
	public static OrthographicCamera camera = new OrthographicCamera(64,64);
	public static FitViewport fvp = new FitViewport(1,1,camera);
	public static Player player;
	public Box2DDebugRenderer debugger;
	public static GameHUD hud = new GameHUD();
	private Image bgimage;
	public static boolean gameover;
	
	
	
	public MGame(){
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
		    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		        if ( button == Buttons.LEFT) {
		        	processClick();
		        	return true;
		        }
		        return false;
		    }
		});
		objects = new ArrayList<GameObject>();
		world = new World(new Vector2(0, -8.89f), true);
		stage = new Stage();
		background = new Stage();
		backgroundObjects = new Stage();
		
		stage.setViewport(fvp);
		backgroundObjects.setViewport(fvp);
		
		bgimage = new Image(TextureBank.bgimage);
		bgimage.setWidth(MouretsuNinja.WIDTH);
		bgimage.setHeight(MouretsuNinja.HEIGHT);
		background.addActor(bgimage);
        
		WorldGenerator.createWorld(objects, world, stage, camera);
		debugger = new Box2DDebugRenderer( true, true, true, true ,true, true);
		
		hud.show();
		
	}
	
	
	public void draw(boolean paused){
		float delta =  Gdx.graphics.getDeltaTime();
				camera.position.set(player.getX()+2, player.getY()+3, 0);
				camera.update();
				
		if(!paused){
			world.step(delta, 6, 2);
			if(!functions.isEmpty())
				functions.remove().exec();
			stage.act();
		}
		background.draw();
		backgroundObjects.draw();
		stage.draw();
//		debugger.render(world, camera.combined);
		hud.render(delta);
		justClicked=false;
	}
	
	public void dispose() {
        

		
	}
	public static boolean justClicked=false;
	private static void processClick(){
		justClicked=true;
	}
}
