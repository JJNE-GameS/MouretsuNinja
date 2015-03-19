package com.jjnegames.mouretsu.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class AnimationHandler {
	
	float runDuration;
	TextureRegionDrawable[] runAnimation;
	TextureRegionDrawable[] runAnimationFlipped;
	
	float atkDuration;
	TextureRegionDrawable[] atkAnimation;
	TextureRegionDrawable[] atkAnimationFlipped;
	
	float blockDuration;
	TextureRegionDrawable[] blockAnimation;
	TextureRegionDrawable[] blockAnimationFlipped;
	
	float criticalBlockDuration;
	TextureRegionDrawable[] criticalBlockAnimation;
	TextureRegionDrawable[] criticalBlockAnimationFlipped;
	
	float jumpDuration;
	TextureRegionDrawable[] jumpAnimation;
	TextureRegionDrawable[] jumpAnimationFlipped;
	
	
	float climbDuration;
	TextureRegionDrawable[] climbAnimation;
	TextureRegionDrawable[] climbAnimationFlipped;
	
	float standDuration;
	TextureRegionDrawable[] standAnimation;
	TextureRegionDrawable[] standAnimationFlipped;
	
	float spatkDuration;
	TextureRegionDrawable[] spatkAnimation;
	TextureRegionDrawable[] spatkAnimationFlipped;
	
	
	
	
	public AnimationHandler(Texture[] runAnimation, float runDuration, Texture[] atkAnimation, float atkDuration,
		Texture[] blockAnimation, float blockDuration, Texture[] criticalBlockAnimation, float criticalBlockDuration,
		Texture[] jumpAnimation, float jumpDuration, Texture[] climbAnimation, float climbDuration, Texture[] standAnimation, float standDuration, Texture[] spatkAnimation, float spatkDuration){
		
		this.runAnimation = new TextureRegionDrawable[runAnimation.length];
		this.runAnimationFlipped = new TextureRegionDrawable[runAnimation.length];
		
		this.atkAnimation = new TextureRegionDrawable[atkAnimation.length];
		this.atkAnimationFlipped = new TextureRegionDrawable[atkAnimation.length];
		
		this.blockAnimation = new TextureRegionDrawable[blockAnimation.length];
		this.blockAnimationFlipped = new TextureRegionDrawable[blockAnimation.length];
		
		this.criticalBlockAnimation = new TextureRegionDrawable[criticalBlockAnimation.length];
		this.criticalBlockAnimationFlipped = new TextureRegionDrawable[criticalBlockAnimation.length];
		
		this.jumpAnimation = new TextureRegionDrawable[jumpAnimation.length];
		this.jumpAnimationFlipped = new TextureRegionDrawable[jumpAnimation.length];
		
		this.climbAnimation = new TextureRegionDrawable[climbAnimation.length];
		this.climbAnimationFlipped = new TextureRegionDrawable[climbAnimation.length];
		
		this.standAnimation = new TextureRegionDrawable[standAnimation.length];
		this.standAnimationFlipped = new TextureRegionDrawable[standAnimation.length];
		
		this.spatkAnimation = new TextureRegionDrawable[spatkAnimation.length];
		this.spatkAnimationFlipped = new TextureRegionDrawable[spatkAnimation.length];
		
		for(int i=0;i<runAnimation.length;i++){
			this.runAnimation[i] = new TextureRegionDrawable(new TextureRegion(runAnimation[i]));
			TextureRegion flipped = new TextureRegion(runAnimation[i]);
			flipped.flip(true, false);
			this.runAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<atkAnimation.length;i++){
			this.atkAnimation[i] = new TextureRegionDrawable(new TextureRegion(atkAnimation[i]));
			TextureRegion flipped = new TextureRegion(atkAnimation[i]);
			flipped.flip(true, false);
			this.atkAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<blockAnimation.length;i++){
			this.blockAnimation[i] = new TextureRegionDrawable(new TextureRegion(blockAnimation[i]));
			TextureRegion flipped = new TextureRegion(blockAnimation[i]);
			flipped.flip(true, false);
			this.blockAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<criticalBlockAnimation.length;i++){
			this.criticalBlockAnimation[i] = new TextureRegionDrawable(new TextureRegion(criticalBlockAnimation[i]));
			TextureRegion flipped = new TextureRegion(criticalBlockAnimation[i]);
			flipped.flip(true, false);
			this.criticalBlockAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<jumpAnimation.length;i++){
			this.jumpAnimation[i] = new TextureRegionDrawable(new TextureRegion(jumpAnimation[i]));
			TextureRegion flipped = new TextureRegion(jumpAnimation[i]);
			flipped.flip(true, false);
			this.jumpAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<climbAnimation.length;i++){
			this.climbAnimation[i] = new TextureRegionDrawable(new TextureRegion(climbAnimation[i]));
			TextureRegion flipped = new TextureRegion(climbAnimation[i]);
			flipped.flip(true, false);
			this.climbAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<standAnimation.length;i++){
			this.standAnimation[i] = new TextureRegionDrawable(new TextureRegion(standAnimation[i]));
			TextureRegion flipped = new TextureRegion(standAnimation[i]);
			flipped.flip(true, false);
			this.standAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		for(int i=0;i<spatkAnimation.length;i++){
			this.spatkAnimation[i] = new TextureRegionDrawable(new TextureRegion(spatkAnimation[i]));
			TextureRegion flipped = new TextureRegion(spatkAnimation[i]);
			flipped.flip(true, false);
			this.spatkAnimationFlipped[i] = new TextureRegionDrawable(flipped);
		}
		
		this.runDuration=runDuration;
		this.atkDuration=atkDuration;
		this.blockDuration=blockDuration;
		this.criticalBlockDuration=criticalBlockDuration;
		this.jumpDuration=jumpDuration;
		this.climbDuration=climbDuration;
		this.standDuration=standDuration;
		this.spatkDuration=spatkDuration;
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
	
	private float atkFrame=0f;
	public Drawable updateAtk(float delta, boolean flipped){
		while(atkFrame>=atkDuration){
			atkFrame-=atkDuration;
		}
		atkFrame+=delta;
		
		int frame = (int) ((atkFrame/atkDuration)*(atkAnimation.length));
		if(frame==atkAnimation.length)
			frame=0;
		if(!flipped){
			return atkAnimation[frame];
		}else{
			return atkAnimationFlipped[frame];
		}
	}
	
	private float blockFrame=0f;
	public Drawable updateBlock(float delta, boolean flipped){
		while(blockFrame>=blockDuration){
			blockFrame-=blockDuration;
		}
		blockFrame+=delta;
		
		int frame = (int) ((blockFrame/blockDuration)*(blockAnimation.length));
		if(frame==blockAnimation.length)
			frame=0;
		if(!flipped){
			return blockAnimation[frame];
		}else{
			return blockAnimationFlipped[frame];
		}
	}
	
	private float criticalBlockFrame=0f;
	public Drawable updateCriticalBlock(float delta, boolean flipped){
		while(criticalBlockFrame>=criticalBlockDuration){
			criticalBlockFrame-=criticalBlockDuration;
		}
		criticalBlockFrame+=delta;
		
		int frame = (int) ((criticalBlockFrame/criticalBlockDuration)*(criticalBlockAnimation.length));
		if(frame==criticalBlockAnimation.length)
			frame=0;
		if(!flipped){
			return criticalBlockAnimation[frame];
		}else{
			return criticalBlockAnimationFlipped[frame];
		}
	}
	
	private float jumpFrame=0f;
	public Drawable updateJump(float delta, boolean flipped){
		while(jumpFrame>=jumpDuration){
			jumpFrame-=jumpDuration;
		}
		jumpFrame+=delta;
		
		int frame = (int) ((jumpFrame/jumpDuration)*(jumpAnimation.length));
		if(frame==jumpAnimation.length)
			frame=0;
		if(!flipped){
			return jumpAnimation[frame];
		}else{
			return jumpAnimationFlipped[frame];
		}
	}
	
	private float climbFrame=0f;
	public Drawable updateClimb(float delta, boolean flipped){
		while(climbFrame>=climbDuration){
			climbFrame-=climbDuration;
		}
		climbFrame+=delta;
		
		int frame = (int) ((climbFrame/climbDuration)*(climbAnimation.length));
		if(frame==climbAnimation.length)
			frame=0;
		if(!flipped){
			return climbAnimation[frame];
		}else{
			return climbAnimationFlipped[frame];
		}
	}
	
	private float standFrame=0f;
	public Drawable updateStand(float delta, boolean flipped){
		while(standFrame>=standDuration){
			standFrame-=standDuration;
		}
		standFrame+=delta;
		
		int frame = (int) ((standFrame/standDuration)*(standAnimation.length));
		if(frame==standAnimation.length)
			frame=0;
		if(!flipped){
			return standAnimation[frame];
		}else{
			return standAnimationFlipped[frame];
		}
	}
	
	private float spatkFrame=0f;
	public Drawable updateSpatk(float delta, boolean flipped){
		while(spatkFrame>=spatkDuration){
			spatkFrame-=spatkDuration;
		}
		spatkFrame+=delta;
		
		int frame = (int) ((spatkFrame/spatkDuration)*(spatkAnimation.length));
		if(frame==spatkAnimation.length)
			frame=0;
		if(!flipped){
			return spatkAnimation[frame];
		}else{
			return spatkAnimationFlipped[frame];
		}
	}

}
