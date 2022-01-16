package fr.dauphine.IA.Astar;

import java.util.ArrayList;

public class State {

	private Vertex actualCity;
	private ArrayList<Vertex> visitedCities = new ArrayList<Vertex>();
	
	public State (Vertex v) {
		this.actualCity = v;
		visitedCities.add(v);
	}
	
	public State (Vertex v, ArrayList<Vertex> visitedCities) throws Exception {
		if(visitedCities.contains(v)) {
			this.actualCity = v;
			this.visitedCities = visitedCities;
		}
		else
			throw new IllegalArgumentException();
	}
	
	public void changeState(Vertex v) {
		this.actualCity = v;
		this.visitedCities.add(v);
	}
	
	
	public Vertex getActualCity() {
		return actualCity;
	}
	public void setActualVille(Vertex actualCity) {
		this.actualCity = actualCity;
	}
	public ArrayList<Vertex> getVillesVisitees() {
		return visitedCities;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof State) {
			State c1 = (State)obj;
			return ((c1.getActualVille().equals(this.getActualVille())) & (c1.getVillesVisitees().equals(this.getVillesVisitees())));
		}
		else {
			throw new ClassCastException();
		}
	}
	
	public boolean isAction(State sfinal) {
		State temp = this;
		temp.changeState(sfinal.getActualVille());
		return sfinal.equals(temp);
	}

	
	@Override
	public String toString() {	
		return visitedCities + " - " + actualCity;
	}
	

}