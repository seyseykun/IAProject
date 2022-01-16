import java.util.HashMap;
import java.util.TreeSet;

public class Frontier {

	
	private HashMap<Vertex, Integer> frontier;
	
	
	public HashMap<Vertex, Integer> getFrontier() {
		return frontier;
	}


	public Frontier() {
		this.frontier = new HashMap<Vertex, Integer>();
	}
	
	public void push(Vertex v, Integer i) {
		Integer put = frontier.put(v, i);
	}
}
