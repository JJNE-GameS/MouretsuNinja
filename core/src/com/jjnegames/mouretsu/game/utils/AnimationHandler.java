package com.jjnegames.mouretsu.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class AnimationHandler {
	
	float runDuration;
	TextureRegionDrawable[] runAnimation;
	TextureRegionDrawable[] runAnimationFlipped;
	
	public AnimationHandler(Texture[] runAnimation, float runDuration){
		this.runAnimation = new TextureRegionDrawable[runAnimation.length];
		this.runAnimationFlipped = new TextureRegionDrawable[runAnimation.length];
		
		for(int i=0;i<runAnimation.length;i++){
			this.runAnimation[i] = new TextureRegionDrawable(new TextureRegion(runAnimation[i]));
			TextureRegion flipped = new TextureRegion(runAnimation[i]);
			flipped.flip(true, false);
			this.runAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		
		this.runDuration=runDuration;
		
	}
	
	private float runFrame=0f;
	public Drawable updateRun(float delta, boolean flipped){
		while(runFrame>=runDuration){
			runFrame-=runDuration;
		}
		runFrame+=delta;
		
		int frame = (int) ((runFrame/runDuration)*(runAnimation.length));
		if(frame==runAnimation.length)
			frame=0;
		if(!flipped){
			return runAnimation[frame];
		}else{
			return runAnimationFlipped[frame];
		}
	}

}
