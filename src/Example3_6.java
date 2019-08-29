
import kareltherobot.*;
import java.awt.Color;

public class Example3_6 {

	public static void main(String[] args) {
		KarelExtensions ryu = new KarelExtensions(10, 1, kareltherobot.Directions.East, 10000);
		
		int[][] currentTime = new int[][] { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											
											{0, 0, 0,      0,     1, 1, 1,      1,     0, 1, 0,     0,      1, 1, 1, },
											{0, 0, 0,      0,     0, 0, 1,      1,     0, 1, 0,     0,      1, 0, 0, },
											{0, 0, 0,      0,     1, 1, 1,      0,     0, 1, 0,     0,      1, 1, 1, },
											{0, 0, 0,      0,     1, 0, 0,      1,     0, 1, 0,     0,      1, 0, 1, },
											{0, 0, 0,      0,     1, 1, 1,      1,     0, 1, 0,     0,      1, 1, 1, },
											
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
											
											/*
											 *     0, 1, 0,
											 *     0, 1, 0,
											 *     0, 1, 0,
											 *     0, 1, 0,
											 *     0, 1, 0,
											 * 
											 *      1, 1, 1,
											 *      0, 0, 1,
											 *      1, 1, 1,
											 *      1, 0, 0,
											 *      1, 1, 1,
											 *      
											 *        1, 1, 1,  
											 *        0, 0, 1,  
											 *        1, 1, 1,  
											 *        0, 0, 1,  
											 *        1, 1, 1,  
											 *      
											 *       1, 0, 1,  
											 *       1, 0, 1,  
											 *       1, 1, 1,  
											 *       0, 0, 1,  
											 *       0, 0, 1,  
											 *      
											 *      1, 1, 1,  
											 *      1, 0, 0,  
											 *      1, 1, 1,  
											 *      0, 0, 1,  
											 *      1, 1, 1,  
											 *      
											 *      1, 1, 1,  
											 *      1, 0, 0,  
											 *      1, 1, 1,  
											 *      1, 0, 1,  
											 *      1, 1, 1,  
											 *      
											 *       1, 1, 1,  
											 *       0, 0, 1,  
											 *       0, 0, 1,  
											 *       0, 0, 1,  
											 *       0, 0, 1,  
											 *      
											 *      
											 *       1, 1, 1,  
											 *       1, 0, 1,  
											 *       1, 1, 1,  
											 *       1, 0, 1,  
											 *       1, 1, 1,  
											 *      
											 *        1, 1, 1,  
											 *        1, 0, 1,  
											 *        1, 1, 1,  
											 *        0, 0, 1,  
											 *        1, 1, 1,  
											 *      
											 *         1, 1, 1,  
											 *         1, 0, 1,  
											 *         1, 0, 1,  
											 *         1, 0, 1,  
											 *         1, 1, 1,  
											 *      
											 * */
		ryu.drawPattern(currentTime);
	}                                                                                         

	static {
		World.reset(); 
		World.readWorld("emptyWorld10x15.kwld"); 
		World.setBeeperColor(Color.magenta);
		World.setStreetColor(Color.blue);
		World.setNeutroniumColor(Color.green.darker());
		World.setDelay(1); 
		World.setVisible(true);
	}
	
}

