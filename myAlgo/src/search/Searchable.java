package search;

import java.util.HashMap;

public interface Searchable {
	/**
	 * This function will give all the possible {@link State states} from this state.
	 * 
	 * @param st
	 * @return
	 * @see {@link Searcher}
	 */
	public HashMap<Action, State> getAllPossibleStates(State st);
	

	public State getGoalState();
	
	public State getStartState();

}
