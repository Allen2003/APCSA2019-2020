import kareltherobot.*;
import java.awt.Color;

public class Page29Example11 implements Directions{
	
	public static void main(String[] args) {
		KarelExtensions ryu = new KarelExtensions(1, 1, kareltherobot.Directions.North, 1);
		KarelExtensions ken = new KarelExtensions(1, 4, kareltherobot.Directions.East, 1);

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 1000) {}
		
		ryu.turnRight();
		ryu.moveX(3);
		ryu.putBeeper();
		ryu.turnLeft();
		ryu.turnLeft();
		ryu.moveX(3);
		ryu.turnRight();
		
		ken.turnLeft();
		ken.pickBeeper();
		ken.moveX(2);
		ken.putBeeper();
		ken.turnLeft();
		ken.turnLeft();
		ken.moveX(2);
		ken.turnLeft();

		ryu.turnOff();
		ken.turnOff();
	}
	
	static {
		World.reset(); 
		World.readWorld("Page29Example11.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}
}
