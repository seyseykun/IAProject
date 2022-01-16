package fr.dauphine.IA.Astar;

import java.util.Map;

public class Edge {

	private Vertex arrive;
	private Integer distance;
	
	
	public Edge(Vertex arrive, Integer distance) {
		this.arrive = arrive;
		this.distance = distance;
	}


	public Vertex getArrive() {
		return arrive;
	}

	public Integer getDistance() {
		return distance;
	}


	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge e = (Edge)obj;
            return (this.arrive.equals(e.getArrive()) & (this.distance == e.getDistance()));
        }
        else {
            throw new ClassCastException();
        }
    }
	
	

}
