import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class Ship extends Entity {
	float speed = 0.3f;
	float fire_rate = 150f;
	float last_fire = 0;
	float megafire = 0;
	public static int bulletsonscreen = 0;
	
	
	Sound fx;

	public Ship(float x, float y) {
		super(x, y);
		setGraphic(ResourceManager.getImage("ship"));
		
		setHitBox(x, y, 50, 50);
		addType("ship");
		define("left", Input.KEY_LEFT);
		define("right", Input.KEY_RIGHT);
		define("fire!", Input.KEY_SPACE);
		try {
			fx = new Sound("data/shoot.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		super.update(container, delta);
		
		// check if a key is down 
		if(check("right") && x<440){
			// do anything you like, for example:
			x += (speed * delta);
		}
		if(check("left") && x>10){
			// do anything you like, for example:
			x -= (speed * delta);
		}
		if(check("fire!")){
			if(last_fire != 0){
			megafire += delta;
			if(megafire >= fire_rate){
				megafire = 0;
				last_fire = 0;
			}	
			}
			if(last_fire == 0 && bulletsonscreen < 2){
				Shot shot = new Shot(x+25, y);
				fx.play();
				ME.world.add(shot);
				System.out.println(last_fire);
				last_fire = delta;
				bulletsonscreen++;
			}
			if(TheGame.aliencount <=0){
				System.exit(0);
			} 
		}
	}
}