import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.ME;
import it.randomtower.engine.World;


public class TheGame extends World {
	//List items get added in the constructor for Alien
	//public static ArrayList<Alien> aliens;
	int collumn = 5;
	int row = 10;
	AlienAI ai;
	
	public TheGame(int id, GameContainer container) {
		super(id, container);
		
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		ai = new AlienAI();
		
		super.init(container, game);
		
		//aliens = new ArrayList();
		
		for(int c = collumn; collumn < 400 ; collumn += 52){
			Alien a = new Alien(collumn, row);
			add(a);
			ai.aliens.add(a);
		}
		row = 65;
		collumn = 5;
		for(int c = collumn; collumn < 400 ; collumn += 52){
			Alien a = new Alien(collumn, row);
			add(a);
			ai.aliens.add(a);
		}
		
		Ship ship = new Ship(225,400);
		add(ship);
	}
	
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException{
		super.update(gc, game, delta);
		ai.checkForWin(); 
	}

}
