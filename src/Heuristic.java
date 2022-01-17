
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class Heuristic {
	private ArrayList<Vertex> graph;
	private Vertex v;
	private ArrayList<Vertex> visitedCities = new ArrayList<>();
	private ArrayList<Integer> visitedEdges = new ArrayList<>();
	
	public Heuristic(ArrayList<Vertex> lV, Vertex v) {
		this.graph = lV;
		this.v = v;
	}
	
	
	
	public Integer Prim() {
		Integer h = 0;
	
		if (graph.size() > 0) {
	        visitedCities.add(v);
		}
	    while (! visitedCities.containsAll(graph) ) {
	    	Integer nextMinimum = Integer.MAX_VALUE;
	       	Vertex nextVille = v;
	       	for (Vertex vi : graph) {
	       		if(visitedCities.contains(vi)) {
	       			Par<Vertex, Integer> candidate = vi.nextMinimum(this);
	                if (candidate.getB() < nextMinimum) {
	                	nextMinimum = candidate.getB();
	                    nextVille = candidate.getA();
	               	}
	        	}
	        }
	       	visitedCities.add(nextVille);
	       	visitedEdges.add(nextMinimum);
	        h += nextMinimum;
	    }
	    return h;
	}
	

	
	
	
	//GETTERS AND SETTERS
	public ArrayList<Vertex> getVisitedCities() {
		return visitedCities;
	}


	public ArrayList<Integer> getVisitedEdges() {
		return visitedEdges;
	}	
	
	
}
