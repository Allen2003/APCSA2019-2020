import kareltherobot.*;
import kareltherobot.Directions.Direction;

import java.awt.Color;

public class KarelPrinter {
	static int[][] pattern = new int[][] {	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}	}; // 10 x 10
	
	
	
	public static void main(String[] args) {

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 1000) {}
		
		KarelExtensions test = new KarelExtensions(pattern.length, 1, kareltherobot.Directions.East, 200);
		test.drawPattern(pattern);
	}
	
	static {
		World.reset();
		World.readWorld("emptyWorld11x11.kwld");
		World.setBeeperColor(Color.yellow);
		World.setStreetColor(Color.red);
		World.setNeutroniumColor(Color.red.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}
}
