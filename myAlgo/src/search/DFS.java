package search;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

/**
* the DFS algorithms that make solution of maze
*
* @author  yonit shitrit
* @version 1.0
* @since   28-04-2016
*/

public class DFS extends CommonSearcher implements Searcher {

	State goal;
	ArrayList<State> visited = new ArrayList<>();

	@Override
	public Solution search(Searchable s) {

		if (dfs(s, s.getStartState()))
			return backtrace(goal);
		else
			return null;

	}

	public boolean dfs(Searchable s, State st) {
		if (st.equals(s.getGoalState())) {
			goal = st;
			return true;
		}
		for (State state : visited) {
			if (state.equals(st))
				return false;
		}
		visited.add(st);

		ArrayList<State> states = new ArrayList<State>();

		HashMap<Action, State> actions = s.getAllPossibleStates(st);
		for (State state : actions.values()) {
			if (st.getCameFrom() != null) {
				if (!st.equals(state) && !st.getCameFrom().equals(state))
					states.add(state);
			} else {
				if (!st.equals(state))
					states.add(state);
			}

		}

		for (State state : states) {

			if (dfs(s, state)) {
				return true;
			}

		}

		return false;
	}

}
