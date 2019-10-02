import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_10 {

	public static void main(String[] args) {
		KarelExtensions prucha = new KarelExtensions(1, 1, kareltherobot.Directions.North, 0);
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}
		
		for (int i = 0; i < 9; i++) {
			while (prucha.nextToABeeper()) {
				prucha.pickBeeper();
				prucha.move();
			}
			
			prucha.commandShortcut2(new int[] {1, 1});
			prucha.moveToWall();
			prucha.commandShortcut2(new int[] {1, 2, 1});
		}
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_10.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}

}
