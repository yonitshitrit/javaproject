package search;

import java.util.ArrayList;

/**
 * the class that concatenation the steps of solution maze
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public class Solution {
	private ArrayList<State> states;

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}
	
	@Override
	public String toString() {
		String s=  "";
		for (State state : states) {
			s+= state.toString() +" ";
		}
		return s;
	}
	
	
}
