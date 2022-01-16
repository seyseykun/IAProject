

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Vertex {
	private int nVille;
	private Map<Vertex, Integer> actions = new HashMap<>();
	//private boolean isVisited = false;
	
	public Vertex (int n) {
		nVille = n;
	}
	
	public void addNewVille(Vertex v, Integer cost) {
		
		Integer put = actions.put(v, cost);
	}
	

	@Override
	/*
	public boolean equals(Object obj) {
		if (obj instanceof Ville) {
			Ville c1 = (Ville)obj;
			Iterator<Map.Entry<Ville,Action>> it = actions.entrySet()
			        .iterator();
			    while (it.hasNext()) {
			        Map.Entry<Ville,Action> pair = it.next();
			        if () {
			        	
			        }
			    }
			return (nVille == c1.getnVille() & actions.equals(c1.getActions()));
		}
		else {
			throw new ClassCastException();
		}
	}
	*/
	
	public boolean equals(Object obj) {
        boolean res = true;
        if (obj instanceof Vertex) {
            Vertex c1 = (Vertex)obj;
            Iterator<Map.Entry<Vertex,Integer>> it1 = actions.entrySet()
                    .iterator();
            Iterator<Map.Entry<Vertex,Integer>> it2 = c1.getActions().entrySet()
                    .iterator();
                while (it1.hasNext()) {
                    Map.Entry<Vertex,Integer> pair1 = it1.next();
                    Map.Entry<Vertex,Integer> pair2 = it2.next();
                    res = (pair1.getKey() == pair2.getKey()) & (pair1.getValue() == pair2.getValue());
                    if (!res) {
                        return res;
                    }
                }
            return nVille == c1.getnVille();
        }
        else {
            throw new ClassCastException();
        }
    }
	
	/*
	public boolean isVisited() {
		return isVisited;
	}

	
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	*/
	
	
	/*
	public Par<Vertex, Action> nextMinimum() {
	    Action nextMinimum = new Action(Integer.MAX_VALUE);
	    Vertex nextVille = this;
	    Iterator<Map.Entry<Vertex,Action>> it = actions.entrySet()
	        .iterator();
	    while (it.hasNext()) {
	        Map.Entry<Vertex,Action> pair = it.next();
	        if (!pair.getKey().isVisited()) {
	            if (!pair.getValue().isIncluded()) {
	                if (pair.getValue().getCost() < nextMinimum.getCost()) {
	                    nextMinimum = pair.getValue();
	                    nextVille = pair.getKey();
	                }
	            }
	        }
	    }
	    Par<Vertex, Action> res = new Par<Vertex, Action>(nextVille, nextMinimum);
	    return res;
	}
	//Return
	*/
	
	
	public Par<Vertex, Integer> nextMinimum(Heuristic h) {
	    Integer nextMinimum = Integer.MAX_VALUE;
	    Vertex nextVille = this;
	    Iterator<Map.Entry<Vertex,Integer>> it = actions.entrySet()
	        .iterator();
	    while (it.hasNext()) {
	        Map.Entry<Vertex,Integer> pair = it.next();
	        if (!h.getVisitedCities().contains(pair.getKey())) {
	            if (!h.getVisitedEdges().contains(pair.getValue())) {    //On a un problème car si 2 edges ont la même valeur, les deux vont être dans VisitedEdges
	                if (pair.getValue() < nextMinimum) {
	                    nextMinimum = pair.getValue();
	                    nextVille = pair.getKey();
	                }
	            }
	        }
	    }
	    Par<Vertex, Integer> res = new Par<Vertex, Integer>(nextVille, nextMinimum);
	    return res;
	}
	//Return 
	

	
	
	@Override
	public String toString() {
		String s = "Ville n°: " + this.getnVille() + "\nPotential actions: [";
		Iterator<Map.Entry<Vertex,Integer>> it = actions.entrySet()
		        .iterator();
		    while (it.hasNext()) {
		        Map.Entry<Vertex,Integer> pair = it.next();
		        s += "\nmove to ville " + pair.getKey().getnVille() + " ; " + pair.getValue() + "km";
		    }
		s += " ]";
		return s;
	}
		
	
	public Map<Vertex, Integer> getActions() {
		return actions;
	}
	
	public int getnVille() {
		return nVille;
	}
}
