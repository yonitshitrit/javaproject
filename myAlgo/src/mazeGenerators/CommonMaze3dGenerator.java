package mazeGenerators;

/**
 * The abstract class that set all the methods that need to be in maze
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public abstract class CommonMaze3dGenerator implements Maze3dGenerator {

	@Override
	public abstract Maze3d generate(int z, int x, int y);
	
	/**
	 * method that calculate measure algorithm time
	 *@return time
	 */
	
	@Override
	public String measureAlgorithmTime(int z, int x, int y) {

		long before;
		long after;
		String time;
		before = System.currentTimeMillis();
		this.generate(z, x, y);
		after = System.currentTimeMillis();
		time = String.valueOf(after - before);
		return time;
	}

}
