import kareltherobot.*;
import java.awt.Color;

public class Experiment1 {

	static int[][] pattern;
	
	public Experiment1(int xDimention, int yDimention) {
		pattern = new int[xDimention][yDimention];
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[i].length; j++) {
				pattern[i][j] = 1;
			}
		}
	}
	
	public Experiment1(int[][] diagram) {
		pattern = diagram;
	}
	
	public static void main(String [] args) {
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
	
	public static void drawPattern() {
		UrRobot bob = new UrRobot(pattern.length, 1, kareltherobot.Directions.East, 100);
		
		long timeStamp = System.currentTimeMillis();
		int rowLength = 0;

		while (System.currentTimeMillis() - timeStamp < 1200) {}
		
		for (int[] row: pattern) {
			for (int space: row) {
				for (int i = 0; i < space; i ++) {
					bob.putBeeper();
				}
				bob.move();
				rowLength++;
			}
			
			// turn around at the end of a line
			UTurn(bob, "right");
			
			// go to the beginning of the next line
			for (int i = 0; i < rowLength; i++) {
				bob.move();
			}
			
			rowLength = 0;
			turnRight(bob);
			turnRight(bob);
		}
		
	}
	
	private static void putBeepersInRow(UrRobot robot, int rowLength) {
		// fill a row with beepers
		robot.putBeeper();
		
		for (int i = 0; i < rowLength - 1; i ++) {
			robot.move();
			robot.putBeeper();
		}
	}
	
	private static void UTurn(UrRobot robot, String direction) {
		// U turn at the end of a row
		switch (direction) {
		case "left":
			robot.turnLeft();
			robot.move();
			robot.turnLeft();
			break;
		case "right":
			turnRight(robot);
			robot.move();
			turnRight(robot);
			break;
		}
	}
	
	public static void turnRight(UrRobot robot) {
		// if 2 wrongs do not make a right, try 3
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
	}
	
	static {
		World.reset();
		World.readWorld("emptyWorld11x11.kwld");
		World.setBeeperColor(Color.YELLOW);
		World.setStreetColor(Color.RED);
		World.setNeutroniumColor(Color.RED);
		World.setDelay(1);
		World.setVisible(true);
	}
}
