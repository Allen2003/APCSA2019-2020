import kareltherobot.*;
import java.awt.Color;

public class Page27Example7 implements Directions{
	
	public static void main(String[] args) {
		KarelExtensions bob = new KarelExtensions(1, 2, kareltherobot.Directions.East, 1);

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 1000) {}
		
		// go outside to first beeper~
		bob.turnLeft();
		bob.turnLeft();
		bob.moveX(4);
		bob.turnRight();
		bob.moveX(3);
		bob.turnLeft();
		bob.turnLeft();
		
		// move to pick up beepers
		bob.pickBeeper();
		bob.move();
		bob.pickBeeper();
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.pickBeeper();
		bob.move();
		bob.turnRight();
		bob.move();
		bob.turnLeft();
		bob.pickBeeper();
		bob.moveX(2);
	}
	
	static {
		World.reset(); 
		World.readWorld("Page27Example7.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}
}
