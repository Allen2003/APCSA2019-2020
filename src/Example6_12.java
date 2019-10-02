import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_12 {

	public static void main(String[] args) {
		KarelExtensions prucha = new KarelExtensions(1, 1, kareltherobot.Directions.North, 24);
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}

		for (int i = 0; i < 9; i++) {
			prucha.move();
			while (!prucha.leftIsClear() && !prucha.rightIsClear()) {
				if (prucha.frontIsClear()) {
					prucha.move();
				} else {
					prucha.commandShortcut2(new int [] {1, 1});
					break;
				}
			}
			
			if (prucha.facingNorth()) {
				prucha.commandShortcut2(new int[] {1, 1, 11, 1, 2, 1});
			} else {
				while (prucha.frontIsClear()) {
					prucha.putBeeper();
					prucha.move();
				}
				
				prucha.commandShortcut2(new int[] {1, 2, 1});
			}
		}
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_12.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}

}
