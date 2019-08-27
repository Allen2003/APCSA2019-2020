
import kareltherobot.*;
import java.awt.Color;

public class Example5Page25 {

	public static void main(String[] args) {
		KarelExtensions bob = new KarelExtensions(3, 4, kareltherobot.Directions.West, 0);
		
		bob.turnRight();
		bob.moveX(2);
		bob.turnLeft();
		bob.moveX(2);
		bob.turnLeft();
		bob.moveX(2);
		bob.turnLeft();
		bob.move();
		bob.pickBeeper();
		bob.turnLeft();
		bob.turnLeft();
		bob.move();
		bob.turnRight();
		bob.moveX(2);
		bob.turnRight();
		bob.moveX(2);
		bob.turnRight();
		bob.moveX(2);
		bob.turnRight();

		bob.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Example5Page25.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}
}
