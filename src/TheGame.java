import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.World;


public class TheGame extends World {

	int collumn = 5;
	int row = 10;
	public static int aliencount = 16;
	
	public TheGame(int id, GameContainer container) {
		super(id, container);
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		super.init(container, game);
		
		for(int c = collumn; collumn < 400 ; collumn += 52){
			Alien a = new Alien(collumn, row);
			add(a);
		}
		row = 65;
		collumn = 5;
		for(int c = collumn; collumn < 400 ; collumn += 52){
			Alien a = new Alien(collumn, row);
			add(a);
		}
		
		Ship ship = new Ship(225,400);
		add(ship);
	}

}
