import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_18 {

	public static void main(String[] args) {
		KarelExtensions prucha = new KarelExtensions(1, 2, kareltherobot.Directions.North, 0);
		int i = 0;
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}

		while (true) {
			prucha.moveToBeeper();
			prucha.turnTo('E');
			
			i = 0;
			
			while (prucha.nextToABeeper()) {
				i++;
				prucha.pickBeeper();
				prucha.turnLeft();
			}
			if (i == 5) {
				break;
			}
		}
		
		prucha.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_18.kwld"); 
		World.setBeeperColor(Color.yellow);
		World.setStreetColor(Color.red);
		World.setNeutroniumColor(Color.red);
		World.setDelay(1); 
		World.setVisible(true);
	}

}
