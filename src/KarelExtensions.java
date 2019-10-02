import kareltherobot.*;
import java.lang.reflect.*;
import java.awt.Color;

public class KarelExtensions extends Robot {
	
	public KarelExtensions(int street, int avenue, char direction, int beepers) {
		super(street, avenue, (direction=='N')? North:(direction=='W')? West: (direction=='S')? South:East, beepers);
	}
	
	public KarelExtensions(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
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
		// 1 = turnLeft
		// 2 = move
		// 3 = turnRight
		// 4 = pickBeeper
		// 5 = putBeeper
		// 6 = turnOff
		// 7 = turnTo('E')
		// 8 = turnTo('N')
		// 9 = turnTo('W')
		// 10 = turnTo('S')
		// 11 = moveToWall
		// 12 = moveToBeeper
		// 13 = pickAllBeepers
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
				case 7:
					turnTo('E');
					break;
				case 8:
					turnTo('N');
					break;
				case 9:
					turnTo('W');
					break;
				case 10:
					turnTo('S');
					break;
				case 11:
					moveToWall();
					break;
				case 12:
					moveToBeeper();
					break;
				case 13:
					pickAllBeepers();
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
	
	public karelDir checkSurroundingBeepers() {
		karelDir dir = null;
		
		// Check Front
		move();
		if (nextToABeeper()) {
			dir = facingDir();
			
			pickBeeper();
			commandShortcut2(new int[] {1, 1, 2, 1, 1});
			return dir;
		}
		commandShortcut2(new int[] {1, 1, 2, 1, 1});

		// Check Left
		turnLeft();
		move();
		if (nextToABeeper()) {
			dir = facingDir();
			
			pickBeeper();
			commandShortcut2(new int[] {1, 1, 2, 1});
			return dir;
		}
		commandShortcut2(new int[] {1, 1, 2, 1});

		// Check Right
		turnRight();
		move();
		if (nextToABeeper()) {
			dir = facingDir();
			
			pickBeeper();
			commandShortcut2(new int[] {1, 1, 2, 3});
			return dir;
		}
		commandShortcut2(new int[] {1, 1, 2, 3});
		
		return null;
	}
	
	public karelDir facingDir() {
		karelDir dir = null;
		
		if (facingNorth()) {
			dir = karelDir.N;
		}
		
		if (facingWest()) {
			dir = karelDir.W;
		}
		
		if (facingSouth()) {
			dir = karelDir.S;
		}
		
		if (facingEast()) {
			dir = karelDir.E;
		}
		
		return dir;
	}
	
	public void turnTo(char dir) {
		switch (facingDir()) {
		// face east
		case N:
			turnLeft();
		case W:
			turnLeft();
		case S:
			turnLeft();
		case E:
			break;
		}
		
		switch (dir) {
		case 'E':
			turnLeft();
		case 'S':
			turnLeft();
		case 'W':
			turnLeft();
		case 'N':
			turnLeft();
			break;
		}
	}
	
	public void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
	
	public void moveToBeeper() {
		while (!nextToABeeper()) {
			move();
		}
	}
	
	public void pickAllBeepers() {
		while (nextToABeeper()) {
			pickBeeper();
		}
	}
	
	public boolean rightIsClear() {
		turnRight();
		try {
			return frontIsClear();
		} finally {
			turnLeft();
		}
	}
	
	public boolean leftIsClear() {
		turnLeft();
		try {
			return frontIsClear();
		} finally {
			turnRight();
		}
	}
	
	public char convertDirToChar(karelDir dir) {
		switch(dir) {
		case E:
			return 'E';
		case N:
			return 'N';
		case W:
			return 'W';
		case S:
			return 'S';
		default: 
			return 'N';
		}
	}
	
	static enum karelDir {
		E,
		N,
		W,
		S
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
