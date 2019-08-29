import kareltherobot.*;
import java.awt.Color;

public class KarelPrinter {

	public static void main(String[] args) {
		KarelExtensions ryu = new KarelExtensions(10, 1, kareltherobot.Directions.East, 1000);
		
		ryu.drawPattern(new int[][]{{1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
									{1, 0, 0, 0, 0, 5, 2, 8, 0, 0},
									{1, 0, 0, 2, 0, 5, 2, 8, 0, 0},
									{1, 0, 0, 2, 0, 5, 2, 8, 0, 0},
									{1, 1, 1, 2, 4, 5, 2, 8, 1, 0},
									{0, 0, 0, 2, 4, 5, 2, 8, 0, 0},
									{0, 0, 0, 2, 4, 5, 2, 8, 0, 0},
									{0, 0, 0, 2, 4, 5, 2, 8, 0, 0},
									{0, 0, 0, 2, 4, 5, 2, 8, 0, 0},
									{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
	}

	static {
		World.reset(); 
		World.readWorld("emptyWorld10x10.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}
	
}
