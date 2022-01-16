package fr.dauphine.IA.Astar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Heuristic {

	
	private ArrayList<Vertex> graph;
	private Vertex v;
	private ArrayList<Vertex> visitedCities = new ArrayList<Vertex>();
	
	public Heuristic(ArrayList<Vertex> lV, Vertex v) {
		this.graph = lV;
		this.v = v;
	}
	
	/*
	public Integer run() {
		Integer h = 0;
		int n = graph.indexOf(v);
		if (graph.size() > 0) {
	        visitedCities.add(graph.get(n));
		}
	    while (isDisconnected()) {
	       	Action nextMinimum = new Action(Integer.MAX_VALUE);
	       	Vertex nextVille = graph.get(n);
	       	for (Vertex v : graph) {
	       		if(visitedCities.contains(v)) {
	       			Pair<Vertex, Action> candidate = v.nextMinimum();
	                if (candidate.getB().getCost() < nextMinimum.getCost()) {
	                	nextMinimum = candidate.getB();
	                    nextVille = candidate.getA();
	               	}
	        	}
	        }
	        nextMinimum.setIncluded(true);
	        visitedCities.add(nextVille);
	        h += nextMinimum.getCost();
	    }
	    return h;
	}
	
	
	private boolean isDisconnected() {
	    for (Vertex v : graph) {
	        if (!visitedCities.contains(v)) {
	            return true;
	        }
	    }
	    return false;
	}
	//Return true if a ville in graph is not visited. 
	
	*/
	
	/*
	Procedure MSTPrim(Graph, source):
		for each u in V
		    key[u] := inf
		    parent[u] := NULL
		end for
		key[source] := 0
		Q = Priority_Queue()
		Q = V
		while Q is not empty
		    u -> Q.pop
		    for each v adjacent to i
		        if v belongs to Q and Edge(u,v) < key[v]    // here Edge(u, v) represents
		                                                    // cost of edge(u, v)
		            parent[v] := u
		            key[v] := Edge(u, v)
		        end if
		    end for
		end while
		
*/
	
	public Integer run() {
		
		for (Vertex v : graph) {
			
		}
			
		
		return null;
	}
}
