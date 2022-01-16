import java.util.HashMap;
import java.util.TreeSet;

public class Frontier {

	
	private HashMap<State, Integer> frontier;


	public Frontier() {
		this.frontier = new HashMap<State, Integer>();
	}
	
	public void push(State s, Integer i) {
		Integer put = frontier.put(s, i);
	}
	
	
	public HashMap<State, Integer> getFrontier() {
		return frontier;
	}
	
	
	public void cleanFrontier() {
		this.frontier = new HashMap<State, Integer>();
	}
}
