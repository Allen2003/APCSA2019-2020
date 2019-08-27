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
		bob.move();
		bob.move();
		bob.move();
		bob.move();
		bob.turnRight();
		bob.move();
		bob.move();
		bob.move();
		bob.turnLeft();
		bob.turnLeft();
		
		// put a beeper
		bob.putBeeper();
		
		// go down the mountain
		bob.move();
		bob.turnRight();
		bob.move();
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.turnRight();
		bob.move();
		bob.move();
		bob.turnLeft();
		
		bob.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Page26Example6.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}
}
