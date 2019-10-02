import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_13 {

	public static void main(String[] args) {
		KarelExtensions prucha = new KarelExtensions(1, 1, kareltherobot.Directions.East, 0);
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}

		prucha.commandShortcut2(new int[] {8, 12, 13, 2, 3, 11, 3});
		
		while (prucha.anyBeepersInBeeperBag()) {
			prucha.putBeeper();
			if (prucha.leftIsClear()) {
				prucha.turnLeft();
			}
			prucha.move();
		}
		
		prucha.commandShortcut2(new int[] {3, 11, 1, 11, 6});
		
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_13.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}

}
