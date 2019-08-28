import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class KarelExtensions extends UrRobot {
	
	public KarelExtensions(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);

		long timeStamp = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStamp < 1000) {}
	}
	
	public static void main(String[] args) {}
	
	public void drawPattern(int[][] pattern) {
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
	
	public void moveX(int distance) {
		for (int i = 0; i < distance; i++) {
			move();
		}
	}
	
	public void commandShortcut(String[] commands) {
		for (String item: commands) {
			switch(item) {
				case "left":
					turnLeft();
					break;
				case "move":
					move();
					break;
				case "right":
					turnRight();
					break;
				case "pick":
					pickBeeper();
					break;
				case "put":
					putBeeper();
					break;
				case "end":
					turnOff();
					break;
			}
		}
	}

	public void commandShortcut2(int[] commands) {
		// 0 = turnOff
		// 1 = turnLeft
		// 2 = move
		// 3 = turnRight
		// 4 = pickBeeper
		// 5 = putBeeper
		for (int item: commands) {
			switch(item) {
				case 1:
					turnLeft();
					break;
				case 2:
					move();
					break;
				case 3:
					turnRight();
					break;
				case 4:
					pickBeeper();
					break;
				case 5:
					putBeeper();
					break;
				case 6:
					turnOff();
					break;
			}
		}
	}
	
	public void move2() {
		move();
		move();
	}
	
//	public Method returnMove2() {
//		return getClass().getMethod("move2", null);
//	}
	
	public void repeat2Times(Method parameterMethod) throws Exception {

		parameterMethod.invoke(this);
		parameterMethod.invoke(this);
		
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
