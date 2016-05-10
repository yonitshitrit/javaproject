package search;

/**
 * the BreadthFirstSearch algorithms that make solution of maze
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class BreadthFirstSearch extends BFS {

	
	public BreadthFirstSearch() {
		openList = new PriorityQueue<State>(new Comparator<State>() {

			@Override
			public int compare(State o1, State o2) {
				return 1;
			}
		});
	}
}

