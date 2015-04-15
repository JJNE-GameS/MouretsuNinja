package com.jjnegames.mouretsu.game;

import java.util.ArrayList;
	













import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointEdge;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.jjnegames.mouretsu.game.objects.Ball;
import com.jjnegames.mouretsu.game.objects.BackGroundBlock;
import com.jjnegames.mouretsu.game.objects.GameObject;
import com.jjnegames.mouretsu.game.objects.MingVase;
import com.jjnegames.mouretsu.game.objects.Rect;
import com.jjnegames.mouretsu.game.objects.Sushi;
import com.jjnegames.mouretsu.game.objects.Triangle;
import com.jjnegames.mouretsu.game.objects.characters.AttackCone;
import com.jjnegames.mouretsu.game.objects.characters.Boss;
import com.jjnegames.mouretsu.game.objects.characters.Char;
import com.jjnegames.mouretsu.game.objects.characters.Juggernaut;
import com.jjnegames.mouretsu.game.objects.characters.SmallEnemy;
import com.jjnegames.mouretsu.game.objects.characters.GrapplingHook;
import com.jjnegames.mouretsu.game.objects.characters.Player;
import com.jjnegames.mouretsu.game.utils.MapFileReader;

public class WorldGenerator {

	public static void createWorld(ArrayList<GameObject> objects, World world,
			Stage stage, OrthographicCamera camera) {
		
		 int[][] map = MapFileReader.Loadmap();
		 System.out.println("herp");
		// int[][] backgroundmap = MapFileReader.LoadBackGroundmap();
		 
		// Nearest on terävämpi mutta ei toimi hyvin pyöriessä ja Linear on
		// epäselvempi mutta parempi vaihtoehto pyörivälle objektille
		TextureBank.alus.setFilter(TextureFilter.MipMapLinearNearest,
				TextureFilter.Linear);

		BodyDef bodyDef = new BodyDef();
		// DynamicBodylla luotu objekti voi liikkua
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		
		// Spawnpoint
		bodyDef.position.set(3f, 20f);
		// Rotation speed when spawned
		bodyDef.angularVelocity = 0;
		bodyDef.linearDamping=0.5f;

		// Luodaan rectangle jolle kerrotaan pelimaailma johon spawnataan,
		// sijainti&pyörimisnopeus jne, leveys, korkeus, kuva joka kertoo miltä
		// objekti näyttää
		Player character_1 = (Player) Player.create(world, bodyDef, 1f, 1f,TextureBank.alus);
		MGame.player=character_1;
		stage.addActor(character_1);
		

		
		
		BodyDef bodyDef6 = new BodyDef();
		bodyDef6.type = BodyDef.BodyType.StaticBody;
		bodyDef6.position.set(-1f, 50f);
		bodyDef6.angularVelocity = 0;
		PolygonShape s = new PolygonShape();
		s.setAsBox(1, 100);
		world.createBody(bodyDef6).createFixture(s,1f);

		
		
		for(int x=0;x<map.length;x++){
			for(int y=0;y<map[x].length;y++){
				
				if(map[x][y]== 1){
					int bit = 0;
					
					if(y>0 && map[x][y-1] == 1){
						bit += 4;
					}if(y<map[x].length-1 && map[x][y+1]== 1){
						bit += 1;
					}if(x>0 && map[x-1][y]== 1){
						bit += 8;
					}if(x<map.length-1 && map[x+1][y]== 1){
						bit += 2;
					}
				BodyDef bodyDef2 = new BodyDef();
				// KinematicBodylla luotu objekti ei voi liikkua
				bodyDef2.type = BodyType.KinematicBody;
				bodyDef2.position.set(x, y);
				bodyDef2.angularVelocity = 0;

				Rect rectangle_2 = Rect.create(world, bodyDef2, 1f, 1f,TextureBank.housetiles[bit]);
//				Ball rectangle_2 = Ball.create(world, bodyDef2, 0.5f, TextureBank.alus);

				stage.addActor(rectangle_2);
				
				}else if(map[x][y]== 5){
					int bit = 0;
					if(map[x][y]== 5){
						
						if(y>0 && map[x][y-1] == 5){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1] == 5 ){
							bit += 1;
						}if(x>0 && map[x-1][y]== 5){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 5){
							bit += 2;
						}
					}
					
					BodyDef bodyDef4 = new BodyDef();
					bodyDef4.type = BodyType.KinematicBody;
					bodyDef4.position.set(x, y);
					bodyDef4.angularVelocity = 0;

					Rect rectangle_3 = Rect.create(world, bodyDef4, 1f, 1f,TextureBank.groundtiles[bit]);

					stage.addActor(rectangle_3);
					
				}else if(map[x][y]== 3){
					int bit = 0;
					if(map[x][y]== 3){
						
						if(y>0 && map[x][y-1] == 3){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 3){
							bit += 1;
						}if(x>0 && map[x-1][y]== 3){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 3){
							bit += 2;
						}
				}
					BodyDef bodyDef5 = new BodyDef();
					bodyDef5.type = BodyType.KinematicBody;
					bodyDef5.position.set(x, y);
					bodyDef5.angularVelocity = 0;

					Rect rectangle_4 = Rect.create(world, bodyDef5, 1f, 1f,TextureBank.groundtiles[bit]);


					stage.addActor(rectangle_4);
					
//				}else if(backgroundmap[x][y]== 14){
//					int bit = 0;
//					if(backgroundmap[x][y]== 14){
//						
//						if(y>0 && backgroundmap[x][y-1] == 14){
//							bit += 4;
//						}if(y<backgroundmap[x].length-1 && backgroundmap[x][y+1]== 14){
//							bit += 1;
//						}if(x>0 && backgroundmap[x-1][y]== 14){
//							bit += 8;
//						}if(x<backgroundmap.length-1 && backgroundmap[x+1][y]== 14){
//							bit += 2;
//						}
//					}
//					
//					BackGroundBlock c = BackGroundBlock.create(x, y, 1, 1, TextureBank.esine2);
//					MGame.backgroundObjects.addActor(c);
//					
					
					
				}else if(map[x][y]== 18){
					int bit = 0;
					if(map[x][y]== 18){
						
						if(y>0 && map[x][y-1] == 18){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 18){
							bit += 1;
						}if(x>0 && map[x-1][y]== 18){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 18){
							bit += 2;
						}
					}
					
					BackGroundBlock b = BackGroundBlock.create(x, y, 1, 1, TextureBank.buddhatiles[bit]);
					MGame.backgroundObjects.addActor(b);
					
					
					
				}else if(map[x][y]== 25){
					int bit = 0;
					if(map[x][y]== 25){
						
						if(y>0 && map[x][y-1] == 25){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 25){
							bit += 1;
						}if(x>0 && map[x-1][y]== 25){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 25){
							bit += 2;
						}
					}
					
					BodyDef bodyDef5 = new BodyDef();
					bodyDef5.type = BodyType.DynamicBody;
					bodyDef5.position.set(x, y);
					bodyDef5.angularVelocity = 0;

					MingVase m = MingVase.create(world, bodyDef5, 1, 1, TextureBank.mingvase);
					MGame.stage.addActor(m);
					
					
					
				}else if(map[x][y]== 26){
					int bit = 0;
					if(map[x][y]== 26){
						
						if(y>0 && map[x][y-1] == 26){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 26){
							bit += 1;
						}if(x>0 && map[x-1][y]== 26){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 26){
							bit += 2;
						}
					}
					
					BackGroundBlock e = BackGroundBlock.create(x, y, 1, 1, TextureBank.water);
					MGame.backgroundObjects.addActor(e);
					
					
					
					
				}else if(map[x][y]== 27){
					int bit = 0;
					if(map[x][y]== 27){
						
						if(y>0 && map[x][y-1] == 27){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 27){
							bit += 1;
						}if(x>0 && map[x-1][y]== 27){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 27){
							bit += 2;
						}
					}
					
					BodyDef bodyDef3 = new BodyDef();
					bodyDef3.type = BodyDef.BodyType.DynamicBody;
					bodyDef3.position.set(10f, 20f);
					bodyDef3.angularVelocity = 0;
					Char character_2 = SmallEnemy.create(world, bodyDef3, 1f, 1f,TextureBank.vihollinen);
					stage.addActor(character_2);
					
					
					
					
				}else if(map[x][y]== 28){
					int bit = 0;
					if(map[x][y]== 28){
						
						if(y>0 && map[x][y-1] == 28){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 28){
							bit += 1;
						}if(x>0 && map[x-1][y]== 28){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 28){
							bit += 2;
						}
					}
					
					BodyDef bodyDef8 = new BodyDef();
					bodyDef8.type = BodyDef.BodyType.DynamicBody;
					bodyDef8.position.set(35f, 20f);
					bodyDef8.angularVelocity = 0;
					Char character_4 = Juggernaut.create(world, bodyDef8, 1f, 1f,TextureBank.vihollinen);
					stage.addActor(character_4);
					
					
					
					
				}else if(map[x][y]== 29){
					int bit = 0;
					if(map[x][y]== 29){
						
						if(y>0 && map[x][y-1] == 29){
							bit += 4;
						}if(y<map[x].length-1 && map[x][y+1]== 29){
							bit += 1;
						}if(x>0 && map[x-1][y]== 29){
							bit += 8;
						}if(x<map.length-1 && map[x+1][y]== 29){
							bit += 2;
						}
					}
					

					BodyDef bodyDef9 = new BodyDef();
					bodyDef9.type = BodyDef.BodyType.DynamicBody;
					bodyDef9.position.set(50f, 20f);
					bodyDef9.angularVelocity = 0;
					Char character_5 = Boss.create(world, bodyDef9, 1f, 1f,TextureBank.vihollinen);
					stage.addActor(character_5);
					
					
					
					
				}
			}
		}
		

		 BodyDef bodyDef4 = new BodyDef();
		 bodyDef4.type=BodyType.KinematicBody;
		 bodyDef4.position.set(11f, 3f);
		 bodyDef4.angularVelocity=0;
		
		 Triangle triangle = Triangle.create(world, bodyDef4, 0.5f, 0.5f, TextureBank.alus);
		 stage.addActor(triangle);
		

		world.setContactListener(createContactListener());
	}
	
	private  static ContactListener createContactListener()
	{
	    ContactListener contactListener = new ContactListener()
	    {
	        @Override
	        public void beginContact(Contact contact)
	        {

	        	final Fixture x1 = contact.getFixtureA();
	            final Fixture x2 = contact.getFixtureB();
	            
	            

	            if(x1.getBody().getUserData()!= null){
		            if(x1.getBody().getUserData() instanceof Player && x2.getBody().getType().equals(BodyType.KinematicBody))
		            {
		            	Player p = (Player) x1.getBody().getUserData();
		            	if(!p.ableToJump){
		            		p.ableToJump = true;
		            	}
		            }else if (x1.getBody().getUserData() instanceof GrapplingHook && !x2.isSensor()){
		            	
		            	MGame.functions.add(new Function(){
		            		public void exec(){
		            			try{
			            			GrapplingHook hook = (GrapplingHook) x1.getBody().getUserData();
					            	if(hook.limiter!=null)
					            		return;
					            	
					            	float xx1 = hook.chara.getBody().getWorldCenter().x;
			            			float yy1 = hook.chara.getBody().getWorldCenter().y;
			            			
					            	float xx2 = x1.getBody().getWorldCenter().x;
					            	float yy2 = x1.getBody().getWorldCenter().y;
					            	
					            	float distance =(float) Math.sqrt(Math.pow((xx1 - xx2),2)+ Math.pow((yy1-yy2),2));
					            	
					            	System.out.println(distance);
					            	System.out.println("x1="+ xx1);
					            	System.out.println("x2="+ xx2);
					            	System.out.println("y1="+ yy1);
					            	System.out.println("y2="+ yy2);				            		if(distance > 5){
				            			((Player) hook.chara).grapple();
				            			return;
				            		}
					    			System.out.println("excuting");
				            		hook.createRope(0.5f);
				            		WeldJointDef wj = new WeldJointDef();
				                	wj.initialize(x1.getBody(), x2.getBody(), x1.getBody().getWorldCenter());
				                	MGame.world.createJoint(wj);
			            		}catch(NullPointerException ex){
		            				System.err.println(ex.getStackTrace());
		            			}
		            			
		            		}
		            		
		            	});
		            }else if(x1.getBody().getUserData() instanceof AttackCone){
		            	if(x2.getBody().getUserData()!=null){
		            		if(x2.getBody().getUserData() instanceof Char){
		            			Char target = (Char)x2.getBody().getUserData();
		            			Char attacker = ((AttackCone)x1.getBody().getUserData()).chara;
		            			
		            			attacker.attackingFromRight = !((AttackCone)x1.getBody().getUserData()).directionRight;
		            			attacker.inAttackCone=target;
		            			System.out.println("targetInAttackCone"+ target);
		            		}
		            	}
		            }else if(x1.getBody().getUserData() instanceof Sushi){
		            	if(x2.getBody().getUserData()!=null){
		            		if(x2.getBody().getUserData() instanceof Player){
		            			Player target = (Player)x2.getBody().getUserData();
		            			Sushi su = (Sushi)x1.getBody().getUserData();
		            			if(su.del)
		            				return;
		            			su.del=true;
		            			target.health+=50;
		            			if(target.health>target.max_health)
		            				target.health=target.max_health;
		            		}
		            	}
		            }
	            }
	            
	            if(x2.getBody().getUserData()!= null){
		            if(x2.getBody().getUserData() instanceof Player && x1.getBody().getType().equals(BodyType.KinematicBody))
		            {
		            	Player p = (Player) x2.getBody().getUserData();
		            	if(!p.ableToJump){
		            		p.ableToJump = true;
		            	}
		            }else if (x2.getBody().getUserData() instanceof GrapplingHook && !x1.isSensor()){
		            
		            	MGame.functions.add(new Function(){
		            		public void exec(){
		            			
		            			GrapplingHook hook = (GrapplingHook) x2.getBody().getUserData();
		            			try{
					            	if(hook.limiter!=null)
					            		return;
					            	
					            	float xx1 = hook.chara.getBody().getWorldCenter().x;
			            			float yy1 = hook.chara.getBody().getWorldCenter().y;
			            			
					            	float xx2 = x2.getBody().getWorldCenter().x;
					            	float yy2 = x2.getBody().getWorldCenter().y;
					            	
					            	float distance =(float) Math.sqrt(Math.pow((xx1 - xx2),2)+ Math.pow((yy1-yy2),2));
					            	
					            	System.out.println(distance);
					            	System.out.println("x1="+ xx1);
					            	System.out.println("x2="+ xx2);
					            	System.out.println("y1="+ yy1);
					            	System.out.println("y2="+ yy2);
					            	if(distance > 5){
				            			System.out.println("pitkä matka");
				            			((Player) hook.chara).grapple();
				            			return;
				            		}
				            		System.out.println("excuting");
				            		hook.createRope(0.5f);
				            		WeldJointDef wj = new WeldJointDef();
				                	wj.initialize(x2.getBody(), x1.getBody(), x2.getBody().getWorldCenter());
				                	MGame.world.createJoint(wj);
		            			}catch(NullPointerException ex){
		            				System.err.println(ex.getStackTrace());
		            			}
		            			
		            		}
		            		
		            	});
		            }else if(x2.getBody().getUserData() instanceof AttackCone){
		            	if(x1.getBody().getUserData()!=null){
		            		if(x1.getBody().getUserData() instanceof Char){
		            			Char target = (Char)x1.getBody().getUserData();
		            			Char attacker = ((AttackCone)x2.getBody().getUserData()).chara;
		            			
		            			attacker.attackingFromRight = !((AttackCone)x2.getBody().getUserData()).directionRight;
		            			attacker.inAttackCone=target;
		            			System.out.println("targetInAttackCone2"+ target);
		            		}
		            	}
		            }else if(x2.getBody().getUserData() instanceof Sushi){
		            	if(x1.getBody().getUserData()!=null){
		            		if(x1.getBody().getUserData() instanceof Player){
		            			Player target = (Player)x1.getBody().getUserData();
		            			Sushi su = (Sushi)x2.getBody().getUserData();
		            			if(su.del)
		            				return;
		            			su.del=true;
		            			target.health+=50;
		            			if(target.health>target.max_health)
		            				target.health=target.max_health;
		            		}
		            	}
		            }
	            }
	            
            	

	        }

	        @Override
	        public void endContact(Contact contact)
	        {
	        	final Fixture x1 = contact.getFixtureA();
	            final Fixture x2 = contact.getFixtureB();
	            
	            

//	            if(x1.getBody().getUserData()!= null){
//		            if(x1.getBody().getUserData() instanceof AttackCone){
//		            	if(x2.getBody().getUserData()!=null){
//		            		if(x2.getBody().getUserData() instanceof Char){
//		            			Char attacker = ((AttackCone)x1.getBody().getUserData()).chara;
//		            			
//		            			attacker.inAttackCone=null;
//		            		}
//		            	}
//		            }
//	            }
//	            
//	            if(x2.getBody().getUserData()!= null){
//		            if(x2.getBody().getUserData() instanceof AttackCone){
//		            	if(x1.getBody().getUserData()!=null){
//		            		if(x1.getBody().getUserData() instanceof Char){
//		            			Char attacker = ((AttackCone)x2.getBody().getUserData()).chara;
//		            			
//		            			attacker.inAttackCone=null;
//		            		}
//		            	}
//		            }
//	            }
	            
            	
	        }

	        @Override
	        public void preSolve(Contact contact, Manifold oldManifold)
	        {
	               
	        }

	        @Override
	        public void postSolve(Contact contact, ContactImpulse impulse)
	        {
	               
	        }
	    };
	    return contactListener;
	}
}
