package boot;

import mazeGenerators.Maze3dGenerator;
import mazeGenerators.MyMaze3dGenerator;
import mazeGenerators.Position;
import mazeGenerators.SimpleMazeGemerator;
import mazeGenerators.Maze3d;

public class Run {
private static void testMazeGenerator(Maze3dGenerator mg){
	// prints the time it takes the algorithm to run
	System.out.println(mg.measureAlgorithmTime(9, 9, 9));
	// generate another 3d maze
	Maze3d maze=mg.generate(9, 9, 9);
	// get the maze entrance
	Position p= maze.getStartMaze();
	// print the position
	System.out.println(p); // format "{x,y,z}"
	// get all the possible moves from a position
	String[] moves=maze.getPossibleDirections(maze.getStartMaze());
	// print the moves
	for(String move : moves)
	System.out.println(move);
	// prints the maze exit position 
	System.out.println(maze.getEndMaze());
	try{
	// get 2d cross sections of the 3d maze
	int[][] maze2dx=maze.getCrossSectionByX(2);
	maze.printMazeCross(maze2dx);
	int[][] maze2dy=maze.getCrossSectionByY(5);
	maze.printMazeCross(maze2dy);
	int[][] maze2dz=maze.getCrossSectionByZ(0);
	maze.printMazeCross(maze2dz);
	maze.getCrossSectionByX(-1);
	} catch (IndexOutOfBoundsException e){
	System.out.println("good!");
	}
	}
	public static void main(String[] args) {
	testMazeGenerator(new SimpleMazeGemerator());
	testMazeGenerator(new MyMaze3dGenerator());
	}
	
	
}



/*
public class Run {

	public static void main(String[] args) {

		Maze3d maze;
		MyMaze3dGenerator dfs = new MyMaze3dGenerator();
		maze = dfs.generate(7,7,7);
		System.out.println(maze);

	}

}
*/