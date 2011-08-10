import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class Alien extends Entity {
	public static String ALIEN = "ALIEN";
	
	boolean going_right = true;

	public Alien(float x, float y) {
		super(x, y);
		Image img = ResourceManager.getImage("alien");
		setGraphic(img);
		setHitBox(0, 0, img.getWidth(), img.getHeight());
		addType(ALIEN);
	}
	
	@Override
	public void collisionResponse(Entity other){
		ME.world.remove(this);
		--TheGame.aliencount;
	}
	
	@Override
	public void update(GameContainer gx, int delta){
		
	}

}
