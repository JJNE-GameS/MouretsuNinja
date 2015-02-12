package com.jjnegames.mouretsu.game.objects.characters;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

/*
 * Holds the owner of this AttackCone and 
 */
public class AttackCone{
	
	public Char chara;
	/**
	 * true = right
	 * false = left
	 */
	public boolean directionRight;
	
	public AttackCone(Char chara, boolean right){
		this.chara=chara;
		this.directionRight=right;
	}
}
