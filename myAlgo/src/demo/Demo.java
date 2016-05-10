package demo;

import mazeGenerators.Maze3d;
import mazeGenerators.MyMaze3dGenerator;
import search.BFS;
import search.BreadthFirstSearch;
import search.DFS;
import search.MazeSearchableAdapter;
import search.Solution;

/**
* The Demo program implements an application that
* simply displays Display the labyrinth and the algorithms that solve it.
*
* @author  yonit shitrit
* @version 1.0
* @since   28-04-2016 
*/

public class Demo {

public static void main(String[] args) {
	
	System.out.println("---------------DFS SOLUTION-------------------");
	
	MyMaze3dGenerator ms= new MyMaze3dGenerator();
	Maze3d m=ms.generate(5, 5, 5);
	System.out.println(m);
	DFS sd = new DFS();
	Solution sl=sd.search(new MazeSearchableAdapter(m));
	if(sl != null)
		System.out.println(sl);
	else
		System.out.println("No solution found!");
	System.out.println("\n");
	
	System.out.println("---------------BFS SOLUTION-------------------");
	
	MyMaze3dGenerator ml= new MyMaze3dGenerator();
	Maze3d n=ml.generate(5, 5, 5);
	System.out.println(n);
	BFS bf = new BFS();
	Solution sl2=bf.search(new MazeSearchableAdapter(n));
	if(sl2 != null)
		System.out.println(sl2);
	else
		System.out.println("No solution found!");
	
	System.out.println("\n");
	
	System.out.println("---------------BreadthFirstSearch SOLUTION-------------------");
	
	MyMaze3dGenerator mf= new MyMaze3dGenerator();
	Maze3d br=mf.generate(5, 5, 5);
	System.out.println(br);
	BreadthFirstSearch bf2 = new BreadthFirstSearch();
	Solution sl3=bf2.search(new MazeSearchableAdapter(n));
	if(sl2 != null)
		System.out.println(sl3);
	else
		System.out.println("No solution found!");
	
	System.out.println("\n");
	
	
}

}
