package search;

import mazeGenerators.Position;

/**
* The PositionToState program defines the way an object of type "Position" becomes 
* an object of type "State".
*
* @author yonit shitrit
* @version 1.0
* @since   28-04-2016 
*/


public class PositionToState extends State{
	
	private Position playerPosition;
	
	public Position getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(Position playerPosition) {
		this.playerPosition = playerPosition;
	}

	public PositionToState(Position playerPosition) {
		this.setPlayerPosition(playerPosition);
		this.setDescription(playerPosition.toString());		
	}
}
