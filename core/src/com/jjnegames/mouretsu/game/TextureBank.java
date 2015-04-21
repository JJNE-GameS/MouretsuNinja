package com.jjnegames.mouretsu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class TextureBank extends AssetManager{
	
	public static Texture alus = new Texture(Gdx.files.internal("alus.png"), true);
	public static Texture vihollinen = new Texture(Gdx.files.internal("are-you-a-wizard.jpg"), true);
	public static Texture pelaaja = new Texture(Gdx.files.internal("ninjatest.png"));
	public static Texture kolmio = new Texture (Gdx.files.internal("images.jpg"));
	public static Texture bgimage = new Texture (Gdx.files.internal("background.png"));
	public static Texture mingvase = new Texture (Gdx.files.internal("mingvase.png"));
	public static Texture water = new Texture (Gdx.files.internal("water.png"));
	public static Texture bridguwalk = new Texture (Gdx.files.internal("bridge/bridge_groundtile1_001.png"));
	public static Texture hook = new Texture (Gdx.files.internal("hook.png"));
	public static Texture tree = new Texture (Gdx.files.internal("tree.png"));
	public static Texture sushi = new Texture (Gdx.files.internal("Sushi.png"));
	public static Texture torch = new Texture (Gdx.files.internal("torch.png"));
	public static Texture torch1 = new Texture (Gdx.files.internal("torch1.png"));
	public static Texture cave = new Texture (Gdx.files.internal("cavebg_002.png"));
	public static Texture cavetop = new Texture (Gdx.files.internal("cavebg_top.png"));
	
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
	
	public static Texture[] walltiles = new Texture[]{
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_right.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_botright.png")),
		new Texture(Gdx.files.internal("wall/housebg_right.png")),
		new Texture(Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_left.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png")),
		new Texture (Gdx.files.internal("wall/housebg_botleft.png")),
		new Texture(Gdx.files.internal("wall/housebg_left.png")),
		new Texture(Gdx.files.internal("wall/housebg_bot.png")),
		new Texture (Gdx.files.internal("wall/housebg_003.png"))
	};
	
	public static Texture house5 = new Texture(Gdx.files.internal("house/housetile5.png"));
	public static Texture[] housetiles = new Texture[]{
		house5,
		house5,
		new Texture(Gdx.files.internal("house/housetile2.png")),
		house5,
		house5,
		house5,
		new Texture(Gdx.files.internal("house/housetile14.png")),
		house5,
		new Texture(Gdx.files.internal("house/housetile8.png")),
		house5,
		new Texture(Gdx.files.internal("house/housetile10.png")),
		house5,
		new Texture(Gdx.files.internal("house/housetile14.png")),
		house5,
		new Texture(Gdx.files.internal("house/housetile14.png")),
		house5
	};
	public static Texture bridgu = new Texture(Gdx.files.internal("bridge/bridgetile_v005.png"));
	public static Texture[] bridgetiles = new Texture[]{
		bridgu,
		bridgu,
		new Texture(Gdx.files.internal("bridge/bridge_sidetile1_003.png")),
		bridgu,
		bridgu,
		bridgu,
		bridgu,
		bridgu,
		new Texture(Gdx.files.internal("bridge/bridge_sidetile2_002.png")),
		bridgu,
		bridgu,
		bridgu,
		bridgu,
		bridgu,
		bridgu
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

	public static Texture pl_run1 = new Texture(Gdx.files.internal("walking/walk_1.png"));
	public static Texture pl_run2 = new Texture(Gdx.files.internal("walking/walk_2.png"));
	public static Texture pl_run3 = new Texture(Gdx.files.internal("walking/walk_3.png"));
	public static Texture pl_run4 = new Texture(Gdx.files.internal("walking/walk_4.png"));
	public static Texture pl_run5 = new Texture(Gdx.files.internal("walking/walk_5.png"));
	public static Texture pl_run6 = new Texture(Gdx.files.internal("walking/walk_6.png"));
	public static Texture pl_run7 = new Texture(Gdx.files.internal("walking/walk_7.png"));
	public static Texture pl_run8 = new Texture(Gdx.files.internal("walking/walk_8.png"));
	
	public static Texture pl_enemyrun1 = new Texture(Gdx.files.internal("walking/ewalk1.png"));
	public static Texture pl_enemyrun2 = new Texture(Gdx.files.internal("walking/ewalk2.png"));
	public static Texture pl_enemyrun3 = new Texture(Gdx.files.internal("walking/ewalk3.png"));
	public static Texture pl_enemyrun4 = new Texture(Gdx.files.internal("walking/ewalk4.png"));
	public static Texture pl_enemyrun5 = new Texture(Gdx.files.internal("walking/ewalk5.png"));
	public static Texture pl_enemyrun6 = new Texture(Gdx.files.internal("walking/ewalk6.png"));

	
	
	public static Texture pl_atk1 = new Texture(Gdx.files.internal("atk/atk_1.png"));
	public static Texture pl_atk2 = new Texture(Gdx.files.internal("atk/atk_2.png"));
	public static Texture pl_atk3 = new Texture(Gdx.files.internal("atk/atk_3.png"));
	public static Texture pl_atk4 = new Texture(Gdx.files.internal("atk/atk_4.png"));
	public static Texture pl_atk5 = new Texture(Gdx.files.internal("atk/atk_5.png"));
	
	public static Texture pl_enemyatk1 = new Texture(Gdx.files.internal("enemyatk/enemyatk1.png"));
	public static Texture pl_enemyatk2 = new Texture(Gdx.files.internal("enemyatk/enemyatk2.png"));
	public static Texture pl_enemyatk3 = new Texture(Gdx.files.internal("enemyatk/enemyatk3.png"));
	public static Texture pl_enemyatk4 = new Texture(Gdx.files.internal("enemyatk/enemyatk4.png"));
	public static Texture pl_enemyatk5 = new Texture(Gdx.files.internal("enemyatk/enemyatk5.png"));
	public static Texture pl_enemyatk6 = new Texture(Gdx.files.internal("enemyatk/enemyatk6.png"));
	public static Texture pl_enemyatk7 = new Texture(Gdx.files.internal("enemyatk/enemyatk7.png"));
	public static Texture pl_enemyatk8 = new Texture(Gdx.files.internal("enemyatk/enemyatk8.png"));
	public static Texture pl_enemyatk9 = new Texture(Gdx.files.internal("enemyatk/enemyatk9.png"));
	public static Texture pl_enemyatk10 = new Texture(Gdx.files.internal("enemyatk/enemyatk10.png"));
	public static Texture pl_enemyatk11 = new Texture(Gdx.files.internal("enemyatk/enemyatk11.png"));



	
	public static Texture pl_block1 = new Texture(Gdx.files.internal("block/block_1.png"));
	public static Texture pl_block2 = new Texture(Gdx.files.internal("block/block_2.png"));
	public static Texture pl_block3 = new Texture(Gdx.files.internal("block/block_3.png"));
	public static Texture pl_block4 = new Texture(Gdx.files.internal("block/block_4.png"));
	
	public static Texture pl_idle1 = new Texture(Gdx.files.internal("idle/idle_1.png"));
	public static Texture pl_idle2 = new Texture(Gdx.files.internal("idle/idle_2.png"));
	public static Texture pl_idle3 = new Texture(Gdx.files.internal("idle/idle_3.png"));
	public static Texture pl_idle4 = new Texture(Gdx.files.internal("idle/idle_4.png"));

	
	public static Texture pl_jump1 = new Texture(Gdx.files.internal("jumping/up_1.png"));
	public static Texture pl_jump2 = new Texture(Gdx.files.internal("jumping/up_2.png"));
	public static Texture pl_jump3 = new Texture(Gdx.files.internal("jumping/down_1.png"));
	public static Texture pl_jump4 = new Texture(Gdx.files.internal("jumping/down_2.png"));
	
	public static Texture pl_spatk1 = new Texture(Gdx.files.internal("atk/atk_1.png"));
	public static Texture pl_spatk2 = new Texture(Gdx.files.internal("atk/atk_2.png"));
	public static Texture pl_spatk3 = new Texture(Gdx.files.internal("atk/atk_3.png"));
	public static Texture pl_spatk4 = new Texture(Gdx.files.internal("atk/atk_4.png"));
	public static Texture pl_spatk5 = new Texture(Gdx.files.internal("atk/atk_5.png"));

	
	public static Texture esine1 = new Texture(Gdx.files.internal("badlogic.jpg"), true);
	public static Texture esine2 = new Texture(Gdx.files.internal("fedora.jpg"), true);
	public static Texture esine3 = new Texture(Gdx.files.internal("spurdo.png"), true);
}