import kareltherobot.*;
import java.awt.Color;

public class KarelExtensions extends UrRobot {

//	int[][] pattern;
//	UrRobot bob;
	
	/* public KarelExtensions(int[][] diagram, int startY, int startX, kareltherobot.Directions.Direction direction, int initialBeepers) {
		pattern = diagram;
		
		bob = new UrRobot(startY, startX, direction, initialBeepers);
		
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[i].length; j++) {
				pattern[i][j] = 1;
			}
		}
		
	}
	
	public KarelExtensions(int[][] diagram) {
		pattern = diagram;
	} */
	
	public KarelExtensions(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 1000) {}
	}
	
	public static void main(String[] args) {

//		UrRobot bob = new UrRobot(1, 1, kareltherobot.Directions.East, 100);
//		
//		long timeStamp = System.currentTimeMillis();
//		int rowLength = 0;
//
//		while (System.currentTimeMillis() - timeStamp < 1200) {}
//
//		bob.turnLeft();
//		for (int i = 0; i < pattern.length; i ++) {
//			bob.move();
//		}
//		turnRight(bob);
//		
//		for (int[] row: pattern) {
//			for (int space: row) {
//				for (int i = 0; i < space; i ++) {
//					bob.putBeeper();
//				}
//				bob.move();
//				rowLength++;
//			}
//			
//			UTurn(bob, "right");
//			
//			for (int i = 0; i < rowLength; i++) {
//				bob.move();
//			}
//			
//			rowLength = 0;
//			turnRight(bob);
//			turnRight(bob);
//		}
	}
	
	public void drawPattern(int[][] pattern) {
//		if (bob == null) {
//			bob = new UrRobot(pattern.length, 1, kareltherobot.Directions.East, 100);
//		}
		int rowLength = 0;
		
		for (int[] row: pattern) {
			for (int space: row) {
				for (int i = 0; i < space; i ++) {
					putBeeper();
				}
				move();
				rowLength++;
			}
			
			// turn around at the end of a line
			UTurn("right");
			
			// go to the beginning of the next line
			for (int i = 0; i < rowLength; i++) {
				move();
			}
			
			rowLength = 0;
			turnLeft();
			turnLeft();
		}
		
	}
	
	private void putBeepersInRow(int rowLength) {
		// fill a row with beepers
		putBeeper();
		
		for (int i = 0; i < rowLength - 1; i ++) {
			move();
			putBeeper();
		}
	}
	
	private void UTurn(String direction) {
		// U turn at the end of a row
		switch (direction) {
		case "left":
			turnLeft();
			move();
			turnLeft();
			break;
		case "right":
			turnRight();
			move();
			turnRight();
			break;
		}
	}
	
	public void putBeepers(int numberOfBeepers) {
		// put numberOfBeepers beepers
		for (int i = 0; i < numberOfBeepers; i++) {
			putBeeper();
		}
	}
	
	public void turnRight() {
		// if 2 wrongs do not make a right, try 3
		turnLeft();
		turnLeft();
		turnLeft();
	}
	
	/* static {
		World.reset();
		World.readWorld("emptyWorld11x11.kwld");
		World.setBeeperColor(Color.YELLOW);
		World.setStreetColor(Color.RED);
		World.setNeutroniumColor(Color.RED);
		World.setDelay(1);
		World.setVisible(true);
	} */
}
