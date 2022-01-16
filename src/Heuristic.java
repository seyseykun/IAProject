
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
	
	/*
	public Integer run() {
		Integer h = 0;
		int n = graph.indexOf(v);
		if (graph.size() > 0) {
	        graph.get(n).setVisited(true);
		}
	    while (isDisconnected()) {
	       	Action nextMinimum = new Action(Integer.MAX_VALUE);
	       	Vertex nextVille = graph.get(n);
	       	for (Vertex v : graph) {
	       		if(v.isVisited()) {
	       			Par<Vertex, Action> candidate = v.nextMinimum();
	                if (candidate.getB().getCost() < nextMinimum.getCost()) {
	                	nextMinimum = candidate.getB();
	                    nextVille = candidate.getA();
	               	}
	        	}
	        }
	        nextMinimum.setIncluded(true);
	        nextVille.setVisited(true);
	        h += nextMinimum.getCost();
	    }
	    return h;
	}
	*/
	
	
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
	
	/*
	private boolean isDisconnected() {
	    for (Vertex ville : graph) {
	        if (!ville.isVisited()) {
	            return true;
	        }
	    }
	    return false;
	}
	//Return true if a ville in graph is not visited. 
	*/
	
	public ArrayList<Vertex> getVisitedCities() {
		return visitedCities;
	}


	public ArrayList<Integer> getVisitedEdges() {
		return visitedEdges;
	}	
	
	
}
