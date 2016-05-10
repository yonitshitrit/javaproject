package mazeGenerators;

/**
 * the position of the maze and implements comparable for compareto between positions in the maze
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public class Position implements Comparable<Position>{

	private int z;
	private int x;
	private int y;

	public Position(int z, int x, int y) {

		this.x = x;
		this.y = y;
		this.z = z;

	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * compare to between positions by x,y,z in the space
	 */

	@Override
	public int compareTo(Position pos) {
		
		return (this.x-pos.x)+(this.y-pos.y)+(this.z-pos.z);
	}
	@Override
	
	public String toString() {
		String s = "";
		s += "{"+ z + "," + x  +"," + y + "}";
		return  s;
	}

}
