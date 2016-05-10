package search;

import java.util.PriorityQueue;

/**
* this abstarct class that set openlist and closelist and initialize them
*
* @author  yonit shitrit
* @version 1.0
* @since   28-04-2016
*/

public abstract class CommonSearcherWithPQueue extends CommonSearcher {
	protected PriorityQueue<State> openList;
	protected PriorityQueue<State> closeList;
	
	public CommonSearcherWithPQueue(){
		openList = new PriorityQueue<State>();
		closeList = new PriorityQueue<State>();
	}
	
}
