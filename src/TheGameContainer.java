import java.io.IOException;

import it.randomtower.engine.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Launch Hello World example
**/
public class TheGameContainer extends StateBasedGame {
	
	public static final int MENU = 1;
	public static final int GAME = 2;

	public TheGameContainer(String title) {
		super(title);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {	
		
	try {
		ResourceManager.loadResources("data/resources.xml");
	} catch (IOException e1) {
		System.out.println("It failed, lol");
		e1.printStackTrace();
	}
	
                // add HelloWorld to current game with id 1
		//addState(new TheMenu(MENU, container));
		addState(new TheGame(GAME, container));
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new TheGameContainer("DareInvaders"));
			container.setDisplayMode(500, 500, false);
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}