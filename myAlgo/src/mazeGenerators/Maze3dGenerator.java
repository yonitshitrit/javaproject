package mazeGenerators;
/**
 * interface that sets maze
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */
public interface Maze3dGenerator {

	public Maze3d generate(int z, int x, int y);

	String measureAlgorithmTime(int z, int x, int y);

}
