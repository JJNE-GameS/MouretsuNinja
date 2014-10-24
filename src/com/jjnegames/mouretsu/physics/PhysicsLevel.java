package com.jjnegames.mouretsu.physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class PhysicsLevel {
	Vec2 gravity = new Vec2(0,1);
	World world = new World(null);
}
