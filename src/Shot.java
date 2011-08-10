import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class Shot extends Entity{
	float speed = 0.3f;
	public Shot(float x, float y) {
		super(x, y);
		Image img = ResourceManager.getImage("shot");
		setGraphic(img);
		setHitBox(0, 0, img.getWidth(), img.getHeight());
		addType("SHOT");
		define("fire!", Input.KEY_SPACE);
	}
	
	public void update(GameContainer container, int delta)
			throws SlickException {
		
		super.update(container, delta);
		y -= (speed *delta);
		
		if(y <= -100){
			ME.world.remove(this);
			Ship.bulletsonscreen--;
			System.out.println("SHIT, IT VANISHED!");
		}
		
		if (collide(Alien.ALIEN, x, y) != null){
			ME.world.remove(this);
			Ship.bulletsonscreen--;
		}
		
	}		
	
}

