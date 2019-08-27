
import kareltherobot.*;
import java.awt.Color;

public class Example4Page28 implements Directions{
	public static void main(String [] args) {
		UrRobot bob = new UrRobot (5, 4, East, 50);
		bob.move();
		bob.move();
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.move();
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.move();
		bob.move();
		bob.turnLeft();
		bob.move();
		bob.move();
		bob.move();
		bob.turnLeft();
		
		bob.turnOff();
	}

	static {
		World.reset(); 
		World.readWorld("Example4Page28.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}
}
