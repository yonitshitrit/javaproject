package mazeGenerators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Building maze3d
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public class Maze3d {

	private int maze[][][];
	Random r = new Random();

	private Position startMaze;
	private Position endMaze;

	public Maze3d(int maze[][][], Position startMaze, Position endMaze) {
		this.maze = maze;
		this.startMaze = startMaze;
		this.endMaze = endMaze;
	}
	
	/**
	 * concatenation maze and setting of start maze and end maze in the maze by S and E
	 * @return mazeToString
	 */

	@Override
	public String toString() {
		String mazeToString="";
		for (int i = 0; i < getZ(); i++) {
			for (int j = 0; j < getX(); j++) {
				for (int q = 0; q < getY(); q++) {
					if(i==this.startMaze.getZ() && j==this.startMaze.getX() && q==this.startMaze.getY())
					{
						mazeToString=mazeToString+"S";
					}
					else if(i==this.endMaze.getZ() && j==this.endMaze.getX() && q==this.endMaze.getY())
					{
						mazeToString=mazeToString+"E";
					}
					else
					{
						mazeToString=mazeToString+maze[i][j][q];
					}
				}
				mazeToString=mazeToString+"\n";
			}
			mazeToString=mazeToString+"\n\n";
		}

		return mazeToString;
	}

	public int getZ() {
		return maze.length;
	}

	public int getX() {
		return maze[0].length;
	}

	public int getY() {
		return maze[0][0].length;
	}

	public int[][][] getMaze() {
		return maze;
	}

	public void setMaze(int[][][] maze) {
		this.maze = maze;
	}

	public Position getStartMaze() {
		return startMaze;
	}

	public void setStartMaze(Position startMaze) {
		this.startMaze = startMaze;
	}

	public Position getEndMaze() {
		return endMaze;
	}

	public void setEndMaze(Position endMaze) {
		this.endMaze = endMaze;
	}
	
	/**
	 * prints the whole maze
	 * @param maze
	 */
	
	public void printMazeCross(int maze[][]){							
		String s  = new String();
		for (int j = 0; j< maze.length; j++){
			for (int i =0; i <maze[0].length; i++){
				s+=" "+ maze[j][i];
			}
			s+="\n";
		}
		System.out.println(s);
	}


	public String[] getPossibleDirections(Position pos) {
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = maze;
		
		/**
		 * Check UP neighbor
		 */

		if (pos.getX() - 1 >= 0 && maze[pos.getZ()][pos.getX() - 1][pos.getY()] == 0) {
			dirs.add(Direction.UP);
		}
		/**
		 * Check DOWN neighbor
		 */
		
		if (pos.getX() + 1 < maze[0].length && maze[pos.getZ()][pos.getX() + 1][pos.getY()] == 0) {
			dirs.add(Direction.DOWN);
		}

		/**
		 * Check LEFT neighbor
		 */
		if (pos.getY() - 1 >= 0 && maze[pos.getZ()][pos.getX()][pos.getY() - 1] == 0) {
			dirs.add(Direction.LEFT);
		}
		
		/**
		 * Check RIGHT neighbor
		 */

		
		if (pos.getY() + 1 < maze[0][0].length && maze[pos.getZ()][pos.getX()][pos.getY() + 1] == 0) {
			dirs.add(Direction.RIGHT);
		}

		/**
		 * Check DOWN_LAYER neighbor
		 */
		
		if (pos.getZ() + 1 < maze.length && maze[pos.getZ() + 1][pos.getX()][pos.getY()] == 0) {
			dirs.add(Direction.DOWN_LAYER);
		}

		/**
		 * Check UP_LAYER neighbor
		 */
	
		if (pos.getZ() - 1 >=0 && maze[pos.getZ() - 1][pos.getX()][pos.getY()] == 0) {
			dirs.add(Direction.UP_LAYER);
		}
		
		/**
		 * the direction of maze in string str
		 * {@link Direction}
		 */
		
		Direction dir;
		String[] str= new String[dirs.size()];
		for(int i=0;i<dirs.size();i++)
		{
			dir = dirs.get(i);
			if(dir==Direction.DOWN)
			{
				str[i]="DOWN";
			}
			if(dir==Direction.UP)
			{
				str[i]="UP";
			}
			if(dir==Direction.LEFT)
			{
				str[i]="LEFT";
			}
			if(dir==Direction.RIGHT)
			{
				str[i]="RIGHT";
			}
			if(dir==Direction.DOWN_LAYER)
			{
				str[i]="DOWN_LAYER";
			}
			if(dir==Direction.UP_LAYER)
			{
				str[i]="UP_LAYER";
			}
		}

		return str;
		
		/**
		 * used to get a plain of the maze by setting the Z factor to i.
		 * @param i - int.
		 * @return int[][].
		 * 
		 */
	}
	public int[][] getCrossSectionByZ(int i) throws IndexOutOfBoundsException {				//return a plain (2d maze) by a certain x
		if(i >= 0 && i <= this.getZ())
		{
			int[][] plain = new int[this.getX()][this.getY()];
		
			for(int j = 0 ; j < this.getX() ;j++)
			{
				for(int k = 0 ; k < this.getY(); k++)
				{
					plain[j][k] = this.maze[i][j][k];
				}
			}
		
			return plain;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * used to get a plain of the maze by setting the X factor to i.
	 * @param i - int.
	 * @return int[][].
	 * 
	 */
	public int[][] getCrossSectionByX(int i) throws IndexOutOfBoundsException {				//return a plain (2d maze) by a certain y
		if( i >= 0 && i < this.getX())
		{
		
			int j = 0;
			int k = 0;
			int[][] plain = new int[this.getZ()][this.getY()];
			
			for( j = 0 ; j <this.getZ() ;j++)
			{
				
				for( k = 0 ; k < this.getZ(); k++)
				{
					plain[j][k] = this.maze[j][i][k];
					
				}
				
			
			}
		
			return plain;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * used to get a plain of the maze by setting the Y factor to i.
	 * @param i - int.
	 * @return int[][].
	 * @throws IndexOutOfBoundsException.
	 */
	public int[][] getCrossSectionByY(int i) throws IndexOutOfBoundsException{			//return a plain (2d maze) by a certain z
		if(i >= 0 && i < this.getY())
		{
			int j = 0;
			int k = 0;
			int[][] plain = new int[this.getZ()][this.getX()];
			
			for(j = 0 ; j <this.getZ() ;j++)
			{
				for(k = 0 ; k < this.getX(); k++)
				{
					plain[j][k] = this.maze[j][k][i];
					
				}
				
			}
			
			return plain;
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	public byte[] toByteArray()
	{
		byte[] array= new byte[maze[0].length*maze[0][0].length*maze.length];
		int count=0;
		
		for (int i = 0 ; i<maze.length;i++)
		{
			for(int j =0;j<maze[0].length;j++)
			{
				for(int k =0 ; k<maze[0][0].length;k++)
				{
					
					array[count]=(byte)maze[i][j][k];
					count++;		
					
				}
			}
		}
		return array;
	}
	
	

}
