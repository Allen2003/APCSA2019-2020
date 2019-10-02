import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_11 {

	public static void main(String[] args) {
		KarelExtensions adolf = new KarelExtensions(1, 1, kareltherobot.Directions.East, 0);
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}
		
		asdf:
		while (true) {
			while (adolf.frontIsClear()) {
				if (adolf.nextToABeeper()) {
					break asdf;
				}
				adolf.move();
			}
			adolf.turnLeft();
			
			while (!adolf.rightIsClear()) {
				adolf.move();
			}
			
			adolf.turnRight();
			adolf.move();
			
			while (!adolf.rightIsClear()) {
				adolf.move();
			}
			
			adolf.turnRight();
			adolf.moveToWall();
			adolf.turnLeft();
			
			if (adolf.nextToABeeper()) {
				break;
			}
		}

		adolf.pickBeeper();
		adolf.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_11.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}


}
