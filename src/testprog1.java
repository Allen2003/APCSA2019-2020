import kareltherobot.*;
import java.awt.Color;

public class testprog1 implements Directions{
	
	public static void main(String[] args) {
		UrRobot Harold = new UrRobot (2, 3, East, 50);
		UrRobot Bob = new UrRobot (9, 3, East, 50);
		Harold.move();
		Bob.move();
		Harold.move();
		Harold.move();
		Harold.move();
		Harold.turnOff();
		Bob.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("crossWorld1.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}
}