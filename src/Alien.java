import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class Alien extends Entity {
	public static String ALIEN = "ALIEN";
	
	float move_rate = 1000f;
	float last_move = 1;
	float mega_alien = 0;
	int movespeed = 25;
	
	boolean going_right = true;

	public Alien(float x, float y) {
		super(x, y);
		AlienAI.aliens.add(this);
		Image img = ResourceManager.getImage("alien");
		setGraphic(img);
		setHitBox(0, 0, img.getWidth(), img.getHeight());
		addType(ALIEN);
	}
	
	@Override
	public void collisionResponse(Entity other){
		ME.world.remove(this);
		TheGame.aliens.remove(this);
	}
	
	@Override
	public void update(GameContainer gx, int delta){
		/*
		//BROKEN CODE STARTS
		
		if (x >= 485){
			y += 25;
			x = 484;
			going_right = false;
		}
		if (x <= 4){
			y+= 25;
			x = 5;
			going_right = true;
		}
		
		//BROKEN CODE ENDS
		if(last_move != 0){
			mega_alien += delta;
			if(mega_alien >= move_rate){
				mega_alien = 0;
				last_move = 0;
			}
		}
		if(last_move == 0){
			if(going_right){
				x += movespeed;
			}
			if(!going_right){
				x -= movespeed;
			}
			last_move = delta;
		}
		*/
	}

}
