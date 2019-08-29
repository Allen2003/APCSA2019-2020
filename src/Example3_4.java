import kareltherobot.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.awt.Color;
public class Example3_4 {

	public static void main(String[] args) {
		KarelExtensions bob = new KarelExtensions(1, 6, kareltherobot.Directions.North, 0);

		bob.commandShortcut2(new int[] {2, 4, 1, 2, 3, 2, 4, 3, 2, 2, 4, 2, 1, 2, 4, 1, 2, 2, 4, 2, 2, 4, 2, 3, 2, 3, 4, 2, 2, 4, 2, 2, 4, 2, 2, 4, 1, 2, 1, 2, 4, 2, 2, 4, 2, 2, 4, 3, 2, 3, 2, 4, 2, 2, 4, 1, 2, 1, 2, 4});
	}
	
	static {
		World.reset(); 
		World.readWorld("Example3_4.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}

}
