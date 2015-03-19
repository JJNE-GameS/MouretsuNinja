package com.jjnegames.mouretsu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class TextureBank extends AssetManager{
	
	public static Texture alus = new Texture(Gdx.files.internal("alus.png"), true);
	public static Texture vihollinen = new Texture(Gdx.files.internal("are-you-a-wizard.jpg"), true);
	public static Texture pelaaja = new Texture(Gdx.files.internal("ninjatest.png"));
	public static Texture kolmio = new Texture (Gdx.files.internal("images.jpg"));
	public static Texture bgimage = new Texture (Gdx.files.internal("sininen.png"));
	
	public static Texture[] groundtiles = new Texture[]{
		new Texture (Gdx.files.internal("ground/Tile1.png")),
		new Texture(Gdx.files.internal("ground/Tile2.png")),
		new Texture(Gdx.files.internal("ground/Tile3.png")),
		new Texture (Gdx.files.internal("ground/Tile4.png")),
		new Texture(Gdx.files.internal("ground/Tile5.png")),
		new Texture(Gdx.files.internal("ground/Tile6.png")),
		new Texture (Gdx.files.internal("ground/Tile7.png")),
		new Texture(Gdx.files.internal("ground/Tile8.png")),
		new Texture(Gdx.files.internal("ground/Tile9.png")),
		new Texture (Gdx.files.internal("ground/Tile10.png")),
		new Texture(Gdx.files.internal("ground/Tile11.png")),
		new Texture(Gdx.files.internal("ground/Tile12.png")),
		new Texture (Gdx.files.internal("ground/Tile13.png")),
		new Texture(Gdx.files.internal("ground/Tile14.png")),
		new Texture(Gdx.files.internal("ground/Tile15.png")),
		new Texture (Gdx.files.internal("ground/Tile16.png"))
	};
	
	public static Texture house5 = new Texture(Gdx.files.internal("house/housetile5.png"));
	public static Texture[] housetiles = new Texture[]{
		house5,
		house5,
		new Texture(Gdx.files.internal("house/housetile2.png")),
		house5,
		house5,
		house5,
		house5,
		house5,
		new Texture(Gdx.files.internal("house/housetile8.png")),
		house5,
		new Texture(Gdx.files.internal("house/housetile10.png")),
		house5,
		house5,
		house5,
		new Texture(Gdx.files.internal("house/housetile14.png")),
		house5
	};
	
	public static Texture[] bridgetiles = new Texture[]{
		alus,
		new Texture(Gdx.files.internal("ninjatest.png")),
		new Texture(Gdx.files.internal("are-you-a-wizard.jpg")),
		new Texture (Gdx.files.internal("images.jpg")),
		new Texture(Gdx.files.internal("ninjatest.png")),
		new Texture(Gdx.files.internal("are-you-a-wizard.jpg")),
		new Texture (Gdx.files.internal("images.jpg")),
		new Texture(Gdx.files.internal("ninjatest.png")),
		new Texture(Gdx.files.internal("are-you-a-wizard.jpg")),
		new Texture (Gdx.files.internal("images.jpg")),
		new Texture(Gdx.files.internal("ninjatest.png")),
		new Texture(Gdx.files.internal("are-you-a-wizard.jpg")),
		new Texture (Gdx.files.internal("images.jpg")),
		new Texture(Gdx.files.internal("ninjatest.png")),
		new Texture(Gdx.files.internal("are-you-a-wizard.jpg"))
	};
	
	public static Texture buddha = new Texture(Gdx.files.internal("buddha/budsta0.png"));
	public static Texture[] buddhatiles = new Texture[]{
		new Texture (Gdx.files.internal("buddha/budsta0.png")),
		buddha,
		buddha,
		new Texture (Gdx.files.internal("buddha/budsta3.png")),
		buddha,
		buddha,
		new Texture (Gdx.files.internal("buddha/budsta6.png")),
		buddha,
		buddha,
		new Texture (Gdx.files.internal("buddha/budsta9.png")),
		buddha,
		buddha,
		new Texture (Gdx.files.internal("buddha/budsta12.png")),
		buddha,
		buddha
	};

	public static Texture pl_run1 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run2 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run3 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run4 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run5 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run6 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run7 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run8 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run9 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run10 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run11 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run12 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run13 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_run14 = new Texture(Gdx.files.internal("alus.png"));
	
	
	public static Texture pl_atk1 = new Texture(Gdx.files.internal("fedora.jpg"));
	public static Texture pl_atk2 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_atk3 = new Texture(Gdx.files.internal("sininen.png"));
	public static Texture pl_atk4 = new Texture(Gdx.files.internal("ninjatest.png"));
	public static Texture pl_atk5 = new Texture(Gdx.files.internal("images.jpg"));
	public static Texture pl_atk6 = new Texture(Gdx.files.internal("ground.jpg"));
	public static Texture pl_atk7 = new Texture(Gdx.files.internal("badlogic.jpg"));
	public static Texture pl_atk8 = new Texture(Gdx.files.internal("are-you-a-wizard.jpg"));
	public static Texture pl_atk9 = new Texture(Gdx.files.internal("woods.jpg"));
	public static Texture pl_atk10 = new Texture(Gdx.files.internal("spurdo.png"));

	
	public static Texture pl_block1 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_block2 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_block3 = new Texture(Gdx.files.internal("alus.png"));
	
	public static Texture pl_idle1 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle2 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle3 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle4 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle5 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle6 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle7 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle8 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle9 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle10 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle11 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_idle12 = new Texture(Gdx.files.internal("alus.png"));
	
	public static Texture pl_jump1 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_jump2 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_jump3 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_jump4 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_jump5 = new Texture(Gdx.files.internal("alus.png"));
	public static Texture pl_jump6 = new Texture(Gdx.files.internal("alus.png"));
	
	public static Texture esine1 = new Texture(Gdx.files.internal("badlogic.jpg"), true);
	public static Texture esine2 = new Texture(Gdx.files.internal("fedora.jpg"), true);
	public static Texture esine3 = new Texture(Gdx.files.internal("spurdo.png"), true);
}
