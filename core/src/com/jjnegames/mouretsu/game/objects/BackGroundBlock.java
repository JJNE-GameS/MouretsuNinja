package com.jjnegames.mouretsu.game.objects;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class BackGroundBlock extends Image{
	
	
	public BackGroundBlock(Texture texture,float x, float y, float width, float height) {
		super(texture);
		
		this.setX(x+width/2);
		this.setY(y-height/2);
		this.setOriginX(width/2);
		this.setOriginY(height/2);
		this.setWidth(width);
		this.setHeight(height);
		// TODO Auto-generated constructor stub
	}


	public static BackGroundBlock create(float x, float y, float w, float h, Texture texture) {

		return new BackGroundBlock(texture,x,y,w,h);
	}
    
	
	
	
	
    /**
     *  
     */

}
