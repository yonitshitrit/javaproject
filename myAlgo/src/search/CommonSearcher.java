package search;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * the abstract class that do backtrace of steps solution
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public abstract class CommonSearcher implements Searcher {
	
	
	public CommonSearcher() {
		
	}
	
	protected Solution backtrace(State state) {
		State s = state;
		ArrayList<State> states = new ArrayList<State>();
		while (s != null) {
			states.add(0, s);	
			s = s.getCameFrom();
		}
		Solution solution = new Solution();
		solution.setStates(states);
		return solution;
	}
}
