import kareltherobot.*;
import java.awt.Color;

public class Page26Example6 implements Directions{
	
	public static void main(String[] args) {
		KarelExtensions bob = new KarelExtensions(1, 2, kareltherobot.Directions.East, 1);

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 1000) {}
		
		// go to the top of the mountain
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.move();
		bob.turnRight();
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.move();
		bob.turnRight();
		bob.move();
		
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
		bob.move();
		
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