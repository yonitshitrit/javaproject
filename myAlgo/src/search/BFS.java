package search;
/**
 * the BFS algorithms that make solution of maze
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

import java.util.HashMap;

public class BFS extends CommonSearcherWithPQueue {
	@Override
	public Solution search(Searchable s) {
		openList.add(s.getStartState());
		
		while (!openList.isEmpty()) {
			State state = openList.poll();
			closeList.add(state);
			//countNodes();
			
			if (state.equals(s.getGoalState())) 
				return backtrace(state);
			//Entry is class that gives the connections in the hash map
			HashMap<Action, State> actions = s.getAllPossibleStates(state);
			for (java.util.Map.Entry<Action, State> entry: actions.entrySet()) {
				Action action = entry.getKey();
				State successor = entry.getValue();
				
				if(!openList.contains(successor) && !closeList.contains(successor)){
					successor.setCameFrom(state);
					successor.setCost(state.getCost() + funcCost(action));
					openList.add(successor);
				}
				else if(state.getCost() + funcCost(action) < successor.getCost()){
					successor.setCameFrom(state);
					successor.setCost(state.getCost() + funcCost(action));
					//update the priority queue
					openList.remove(successor);
					openList.add(successor);
				}
			}
		}
		return null; //we won't get here
	}
	
	protected double funcCost(Action action)
	{
		return action.getCost();
	}

	

}
