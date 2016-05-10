package search;

import java.util.ArrayList;
import java.util.HashMap;

import mazeGenerators.Direction;
import mazeGenerators.Maze3d;
import mazeGenerators.Position;

/**
* The MazeSearchableAdapter program connects the maze generators part to the algorithms part
* by using the Adapter pattern.
*
* @author  yonit shitrit
* @version 1.0
* @since   28-04-2016
*/


public class MazeSearchableAdapter implements Searchable {
	

	private Maze3d myMaze;
	private static final int MOVE_COST = 1;
	
	public MazeSearchableAdapter(Maze3d myMaze) {
		this.myMaze = myMaze;
	}

	@Override
	public State getStartState() {
		PositionToState startState = new PositionToState(myMaze.getStartMaze());
		return startState;
	}

	@Override
	public State getGoalState() {
		PositionToState goalState = new PositionToState(myMaze.getEndMaze());
		return goalState;
	}
	
	private Position getNextPosition(Position currPos, Direction dir){
		switch(dir){
		// ON Z
		case UP_LAYER:
			return new Position(currPos.getZ()+1, currPos.getX(), currPos.getY());
		case DOWN_LAYER:
			return new Position(currPos.getZ()-1, currPos.getX(), currPos.getY());
			
		// ON X
			
		case RIGHT:
			return new Position(currPos.getZ(), currPos.getX()+1, currPos.getY());
		case LEFT:
			return new Position(currPos.getZ(), currPos.getX()-1, currPos.getY());
			
		// ON Y
		case UP:
			return new Position(currPos.getZ(), currPos.getX(), currPos.getY()+1);
		case DOWN:
			return new Position(currPos.getZ(), currPos.getX(), currPos.getY()-1);
		}
		
		return null;
	}
	
	@Override
	
	public HashMap<Action, State> getAllPossibleStates(State st) {
		int flag = 0;
		PositionToState mazeState = (PositionToState)st;
		Position pos = mazeState.getPlayerPosition();
		String[] directions = myMaze.getPossibleDirections(pos);
		
		HashMap<Action, State> actions = new HashMap<Action, State>();
		for (String direction : directions) {
			Action action = new Action(direction, MOVE_COST);
			PositionToState newState = new PositionToState(getNextPosition(pos, direction));
			newState.setCameFrom(st);
			
			actions.put(action, newState);
			
			if(mazeState.getCameFrom()!=null&&!newState.equals(mazeState.getCameFrom())&&flag!=0)
			{
				actions.put(action, newState);
			}
			else
			{
				actions.put(action, newState);
			
				flag++;
			}
		}
		return actions;
	}
	
	public Position getNextPosition(Position pos, String dir)
	{
		if(dir.compareTo("UP")==0)
		{
			return new Position(pos.getZ(), pos.getX()-1, pos.getY());
		}
		else if(dir.compareTo("DOWN")==0)
		{
			return new Position(pos.getZ(), pos.getX()+1, pos.getY());
		}
		else if(dir.compareTo("LEFT")==0)
		{
			return new Position(pos.getZ(), pos.getX(), pos.getY()-1);
		}
		else if(dir.compareTo("RIGHT")==0)
		{
			return new Position(pos.getZ(), pos.getX(), pos.getY()+1);
		}
		else if(dir.compareTo("UP_LAYER")==0)
		{
			return new Position(pos.getZ()-1, pos.getX(), pos.getY());
		}
		else if(dir.compareTo("DOWN_LAYER")==0)
		{
			return new Position(pos.getZ()+1, pos.getX(), pos.getY());
		}
		else
			return pos;
		
	
	}





}
