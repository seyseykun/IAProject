package fr.dauphine.IA.Astar;

import java.util.Iterator;
import java.util.Map;

public class Vertex {

	private String city;
	
	public Vertex(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	
	
	// equals and hashCode
	
	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Vertex) {
            Vertex v = (Vertex)obj;
            return (this.city == v.getCity());
        }
        else {
            throw new ClassCastException();
        }
    }
	
}
