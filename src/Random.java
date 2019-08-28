import kareltherobot.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.awt.Color;

public class Random {

	public static void main(String[] args) {
		KarelExtensions bob = new KarelExtensions(1, 1, kareltherobot.Directions.East, 0);

		try {
			bob.repeat2Times(bob.getClass().getMethod("move2"));
		} catch (NoSuchMethodException e1) {
			System.out.print("NoSuchMethodException");
		} catch (Exception e2) {
			System.out.print("Exception");
		}
		
	}
	
	static {
		World.reset(); 
		World.readWorld("emptyWorld10x10.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(10); 
		World.setVisible(true);
	}

}
