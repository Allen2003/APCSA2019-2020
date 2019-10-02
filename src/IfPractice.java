import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class IfPractice {

	public static void main(String[] args) {
		
		char dir = 'N';
		
		switch ((int)Math.random()*4) {
		case 0:
			dir = 'E';
			break;
		case 1:
			dir = 'N';
			break;
		case 2:
			dir = 'W';
			break;
		case 3:
			dir = 'S';
			break;
		}
		KarelExtensions bob = new KarelExtensions(1, (int)Math.round(Math.random()*10), dir, 0);

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 3000) {}
		bob.commandShortcut2(new int[] {9, 11, 3});
		bob.moveX(10);
		bob.turnOff();
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
