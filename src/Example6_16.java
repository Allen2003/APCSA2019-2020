import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_16 {

	public static void main(String[] args) {
		KarelExtensions prucha = new KarelExtensions(1, 1, kareltherobot.Directions.East, 0);
		int i = 0;
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}

		while (!prucha.nextToABeeper()) {
			if(prucha.rightIsClear()) {
				prucha.turnRight();
				prucha.move();
			} else if (prucha.frontIsClear()) {
				prucha.move();
			} else {
				prucha.turnLeft();
			}
		}
		
		prucha.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_16.kwld"); 
		World.setBeeperColor(Color.yellow);
		World.setStreetColor(Color.red);
		World.setNeutroniumColor(Color.red);
		World.setDelay(1); 
		World.setVisible(true);
	}

}
