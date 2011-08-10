import java.util.ArrayList;

import org.newdawn.slick.state.StateBasedGame;


public class AlienAI {
	int delta;
	float move_rate = 1000f;
	float last_move = 1;
	float mega_alien = 0;
	int movespeed = 25;
	int downamount = 25;
	
	int maxright = 480;
	int maxleft = 5;
	
	boolean AnyBoundrariesCrossed = false;
	boolean going_right = true;
	
	private ArrayList<Alien> aliens;
	
	public AlienAI(){
		aliens = new ArrayList<Alien>();
		
	}
	
	public void updateDelta(int delta){
		this.delta = delta;
	}
	
	public void addAliens(Alien a){
		aliens.add(a);
	}
	
	public void move(){
		
		for(Alien a : aliens){
			if (a.x >= maxright || a.x <= maxleft){
				AnyBoundrariesCrossed = true;
			}
			else
				AnyBoundrariesCrossed = false;
			
			if (AnyBoundrariesCrossed){
				//I guess I need to loop again or it will only move the one in the current loop?
				for(Alien b : aliens){
				StepDown(b.y);
				}
			}
		}
		
		/*
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
	
	private float StepDown(float y) {
		going_right = !going_right;
		return y += downamount;
	}

	public void checkForWin() {
		// TODO Auto-generated method stub
		
	}
}
