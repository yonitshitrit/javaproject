package mazeGenerators;

/**
 * the class extends abstract class and Diffuses randomly walls
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */
import java.util.Random;

public class SimpleMazeGemerator extends CommonMaze3dGenerator {
	Random r = new Random();
	
	/**
	 * the realize method from abstract class that diffuses num 1 in maze 
	 */

	@Override
	public Maze3d generate(int z, int x, int y) {

		int maze[][][] = new int[z][x][y];
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < x; j++) {
				for (int q = 0; q < y; q++) {
					maze[i][j][q] = 1;
				}
			}
		}
		
		/**
		 * Lottery number between 0 and 1 Excluding ends
		 */

		for (int i = 1; i < z - 1; i++) {
			for (int j = 1; j < x - 1; j++) {
				for (int q = 1; q < y - 1; q++) {
					maze[i][j][q] = r.nextInt((1 - 0) + 1) + 0;

				}
			}
		}
		int startZ;
		int startX;
		int startY;
	

		startZ = r.nextInt(z);


		if (startZ != 0 && startZ != z) {
			startY = r.nextInt(y-2)+1;
			if (startY == 0 || startY == y) {
				startX = r.nextInt(x - 2) + 1;
			} else {
				startX = r.nextInt(2) * (x - 1);
			}

		}

		else {
			startX = r.nextInt(5) + 1;
			startY = r.nextInt(5) + 1;
		}

		Position point = new Position(startZ, startX, startY);

		if (startZ == 0) {
			point.setZ(point.getZ() + 1);
			maze[point.getZ()][point.getX()][point.getY()] = 0;
		}

		if (startZ == z-1) {
			point.setZ(point.getZ() - 1);
			maze[point.getZ()][point.getX()][point.getY()] = 0;
		}
		if (startY == y-1) {
			point.setY(point.getY() - 1);
			maze[point.getZ()][point.getX()][point.getY()] = 0;
		}
		if (startY == 0) {
			point.setY(point.getY() + 1);
			maze[point.getZ()][point.getX()][point.getY()] = 0;
		}
		if (startX == x-1) {
			point.setX(point.getX() - 1);
			maze[point.getZ()][point.getX()][point.getY()] = 0;
		}
		if (startX == 0) {
			point.setX(point.getX() + 1);
			maze[point.getZ()][point.getX()][point.getY()] = 0;
		}
		
		

		while (point.getZ() != z-1 && point.getZ() != 0 && point.getX() != 0 && point.getX() != x-1 && point.getY() != y-1
				&& point.getY() != 0)
		{
			int rNum;
			rNum = r.nextInt(6);
			switch(rNum)
			{
			
			//up layer
			case 0:
				point.setZ(point.getZ()-1);
				maze[point.getZ()][point.getX()][point.getY()] = 0;
			//down layer
			case 1:
				point.setZ(point.getZ()+1);
				maze[point.getZ()][point.getX()][point.getY()] = 0;
			// X right
			case 2:
				point.setX(point.getX()+1);
				maze[point.getZ()][point.getX()][point.getY()] = 0;
			// x left
			case 3:
				point.setX(point.getX()-1);
				maze[point.getZ()][point.getX()][point.getY()] = 0;
			// y up
			case 4:
				point.setY(point.getY()-1 );
				maze[point.getZ()][point.getX()][point.getY()] = 0;
			// y down
			case 5:
				point.setY(point.getY()+1 );
				maze[point.getZ()][point.getX()][point.getY()] = 0;
				
				
			}
			

		}

			return new Maze3d(maze, new Position(startZ, startX, startY), point);
	}



}
