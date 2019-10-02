import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_14 {

	public static void main(String[] args) {
		KarelExtensions prucha = new KarelExtensions(2, 2, kareltherobot.Directions.East, 0);
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}

		while (true) {
			try {
				prucha.turnTo(prucha.convertDirToChar(prucha.checkSurroundingBeepers()));
			} catch (NullPointerException e) {
				System.out.print("NPE caught");
				break;
			}
			prucha.move();
		}
		prucha.turnOff();
		
		
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_14.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}

}