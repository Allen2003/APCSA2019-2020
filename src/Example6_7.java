import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class Example6_7 {

	public static void main(String[] args) {
		KarelExtensions adolf = new KarelExtensions(4, 3, kareltherobot.Directions.East, 0);
		
		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}
		
		adolf.moveToWall();
		adolf.turnLeft();
		
		for (int i = 0; i < 5; i ++) {
			try {
				while (adolf.frontIsClear()) {
					if (!adolf.rightIsClear()) {
						adolf.move();
					} else {
						throw new EscapeFoundException("Found");
					}
				}
			} catch (EscapeFoundException e) {
				adolf.commandShortcut2(new int[] {3, 2, 2});
				break;
			}
			adolf.turnLeft();
		}

		adolf.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Example6_7.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}


}
