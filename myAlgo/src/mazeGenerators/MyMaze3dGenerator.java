package mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * class that extends from commonMaze3dGenerator and realize the method maze3d generate and dfs algo
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public class MyMaze3dGenerator extends CommonMaze3dGenerator {

	Stack<Position> sPos = new Stack<Position>();
	Random r = new Random();
	int maze[][][];

/**
 * realize method from abstract class that we extends
 * the maze initialize to number 1 
 */

	@Override
	public Maze3d generate(int z, int x, int y) {
		maze = new int[z][x][y];
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < x; j++) {
				for (int q = 0; q < y; q++) {
					maze[i][j][q] = 1;
				}
			}
		}
		
		DFS(new Position(1, 1, 1));

		return new Maze3d(maze, new Position(1, 1, 1), new Position(z - 2, x - 2, y - 2));
	}
	
	/**
	 * The algorithms DFS that choose random direction from getpossoblediraction and get on
	 * @param pos
	 */

	private void DFS(Position pos) {
		ArrayList<Direction> dirs = getPossibleDirections(pos);
		if (dirs.size() == 0)
			return;

		for (int i = 0; i < dirs.size(); i++) {

			// Choose random direction
			int idx = r.nextInt(dirs.size());
			Direction dir = dirs.get(idx);
			dirs.remove(idx);
			int[][][] m = maze;

			switch (dir) {
			case LEFT:
				maze[pos.getZ()][pos.getX() - 1][pos.getY()] = 0;
				maze[pos.getZ()][pos.getX() - 2][pos.getY()] = 0;
				DFS(new Position(pos.getZ(), pos.getX() - 2, pos.getY()));
				break;
			case RIGHT:
				maze[pos.getZ()][pos.getX() + 1][pos.getY()] = 0;
				maze[pos.getZ()][pos.getX() + 2][pos.getY()] = 0;
				DFS(new Position(pos.getZ(), pos.getX() + 2, pos.getY()));
				break;
			case DOWN:
				maze[pos.getZ()][pos.getX()][pos.getY() + 1] = 0;
				maze[pos.getZ()][pos.getX()][pos.getY() + 2] = 0;
				DFS(new Position(pos.getZ(), pos.getX(), pos.getY() + 2));
				break;
			case UP:
				maze[pos.getZ()][pos.getX()][pos.getY() - 1] = 0;
				maze[pos.getZ()][pos.getX()][pos.getY() - 2] = 0;
				DFS(new Position(pos.getZ(), pos.getX(), pos.getY() - 2));
				break;

			case UP_LAYER:
				maze[pos.getZ() - 1][pos.getX()][pos.getY()] = 0;
				maze[pos.getZ() - 2][pos.getX()][pos.getY()] = 0;
				DFS(new Position(pos.getZ() - 2, pos.getX(), pos.getY()));
				break;
			case DOWN_LAYER:
				maze[pos.getZ() + 1][pos.getX()][pos.getY()] = 0;
				maze[pos.getZ() + 2][pos.getX()][pos.getY()] = 0;
				DFS(new Position(pos.getZ() + 2, pos.getX(), pos.getY()));
				break;

			}
			
		}
	}
	/**
	 * the method check the neighbors in left,right,up,down,up layer and down layer 
	 * @param pos
	 * @return dirs
	 * {@link Direction}
	 */

	private ArrayList<Direction> getPossibleDirections(Position pos) {
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = maze;

		// Check left neighbor
		if (pos.getX() - 2 >= 0 && maze[pos.getZ()][pos.getX() - 2][pos.getY()] == 0) {
			dirs.add(Direction.LEFT);
		}

		// Check right neighbor
		if (pos.getX() + 2 < maze[0].length && maze[pos.getZ()][pos.getX() + 2][pos.getY()] == 1) {
			dirs.add(Direction.RIGHT);
		}

		// Check up neighbor
		if (pos.getY() - 2 >= 0 && maze[pos.getZ()][pos.getX()][pos.getY() - 2] == 1) {
			dirs.add(Direction.UP);
		}

		// Check right neighbor
		if (pos.getY() + 2 < maze[0][0].length && maze[pos.getZ()][pos.getX()][pos.getY() + 2] == 1) {
			dirs.add(Direction.DOWN);
		}

		// Check DOWN_LAYER neighbor
		if (pos.getZ() + 2 < maze.length && maze[pos.getZ() + 2][pos.getX()][pos.getY()] == 1) {
			dirs.add(Direction.DOWN_LAYER);
		}

		// Check up layer neighbor
		if (pos.getZ() - 2 >=0 && maze[pos.getZ() - 2][pos.getX()][pos.getY()] == 1) {
			dirs.add(Direction.UP_LAYER);
		}

		

		return dirs;
	}

}
