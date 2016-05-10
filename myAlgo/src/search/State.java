package search;
/**
 * the class that set compare to state and state by cost
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public class State implements Comparable<State> {
	private String description;
	private double cost;
	private State cameFrom;
	public boolean visited;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public State getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}
	@Override
	public int compareTo(State s) {
		return (int)(this.cost - s.cost);
	}
	@Override
	public boolean equals(Object arg0) {
		State state = (State)arg0;
		return description.equals(state.description);
	}
	
	@Override
	public String toString() {
		return description;
	}
	
}
