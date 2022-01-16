package fr.dauphine.IA.Astar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {

	////private List<Pair<Vertex, List<Edge>>> graph;
	private Map<Vertex, List<Edge>> graph;
	
	public Graph() {
		this.graph = new HashMap<Vertex, List<Edge>>();
	}
	
	
	public void addVertex(String city) {
		graph.putIfAbsent(new Vertex(city), new ArrayList<>());
	}
	//Pourquoi pas une List ou LinkedList ?
	
	public void removeVertex(String city) {
		Vertex v = new Vertex(city);
	    graph.values().stream().forEach(e -> for(Edge ed : e) {  });
	    graph.remove(v);
	}
	
	public void addEdge(String city1, String city2, Integer distance) {
		Vertex v1 = new Vertex(city1);
	    Vertex v2 = new Vertex(city2);
	    graph.get(v1).add(new Edge(v2, distance));
	    graph.get(v2).add(new Edge(v1, distance));
	}
	
	public void addEdge(Vertex v1, Vertex v2, Integer distance) {
	    graph.get(v1).add(new Edge(v2, distance));
	    graph.get(v2).add(new Edge(v1, distance));
	}
	
	public void removeEdge(String city1, String city2) {
		Vertex v1 = new Vertex(city1);
	    Vertex v2 = new Vertex(city2);
	    for (Edge e : graph.get(v1)) {
	    	if ((graph.get(v1) != null)&&(e.getArrive().equals(v2))) {
	    		graph.get(v1).remove(e);
	    	}
	    }
	    for (Edge e : graph.get(v2)) {
	    	if ((graph.get(v2) != null)&&(e.getArrive().equals(v1))) {
	    		graph.get(v2).remove(e);
	    	}
	    }
	}
	
	
	public Graph createRandomGraph(String... city) {
	    Graph g = new Graph();
	    for (String s : city) {
	    	g.addVertex(s);
	    }
	    for (Vertex v1 : this.graph.) {
	    	for (Vertex v2 : city) {
	    		if (v1.getCity() != v2.getCity()) {
	    			g.addEdge(v1, v2, ThreadLocalRandom.current().nextInt(1, 100));
	    			System.out.println(1);
	    			//Random number between 1 and 99.
	    		}
	    	}
	    }
	    return g;
	}
	

}
