
import java.util.ArrayList;
import java.util.List;

public class State {
	private Vertex actualVille;
	private ArrayList<Vertex> villesVisitees = new ArrayList<Vertex>();
	private Integer distancevisitees = 0;
	
	public State (Vertex v) {
		this.actualVille = v;
		villesVisitees.add(v);
		for(int i = 0 ; i<villesVisitees.size() - 1; i++) {
			distancevisitees += villesVisitees.get(i).getActions().get(villesVisitees.get(i+1));
		}
	}
	
	public State (Vertex v, ArrayList<Vertex> villesVisitees) throws Exception {
		if(villesVisitees.contains(v)) {
			this.actualVille = v;
			this.villesVisitees = villesVisitees;
			for(int i = 0 ; i<villesVisitees.size() - 1; i++) {
				distancevisitees += villesVisitees.get(i).getActions().get(villesVisitees.get(i+1));
			}
		}
		else
			throw new IllegalArgumentException();
	}
	
	public State(State s) {
		this.actualVille = s.getActualVille();
		this.villesVisitees = new ArrayList<Vertex>(s.getVillesVisitees());
		this.distancevisitees = s.getDistancevisitees();
	}
	
	public State() {
	}

	
	public void changeState(Vertex v) {
		this.actualVille = v;
		this.villesVisitees.add(v);
		distancevisitees += villesVisitees.get(villesVisitees.size() - 2).getActions().get(v);
	}
	
	
	
	//Créer une fonction pathCost c(state1, action, state2) ????
	
	
	

	
	//Overriding methods equals and toString
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

	@Override
	public String toString() {	
		return villesVisitees + " - " + actualVille;
	}
	
	
	
	
	
	
	
	
	//GETTERS AND SETTERS
		public Vertex getActualVille() {
			return actualVille;
		}
		
		public ArrayList<Vertex> getVillesVisitees() {
			return villesVisitees;
		}

		public Integer getDistancevisitees() {
			return distancevisitees;
		}
	
	

}
