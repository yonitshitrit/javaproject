package search;
/**
 * class that set action with description and cost
 * 
 * @author yonit shitrit
 * @version 1.0
 * @since 28-04-2016
 */

public class Action {
	private String description;
	private double cost;
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
	public Action(String description, double cost) {		
		this.description = description;
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return description.hashCode();
	}	
	
	
}
