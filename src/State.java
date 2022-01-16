
import java.util.ArrayList;
import java.util.List;

public class State {
	private Vertex actualVille;
	private ArrayList<Vertex> villesVisitees = new ArrayList<Vertex>();
	
	public State (Vertex v) {
		this.actualVille = v;
		villesVisitees.add(v);
	}
	
	public State (Vertex v, ArrayList<Vertex> villesVisitees) throws Exception {
		if(villesVisitees.contains(v)) {
			this.actualVille = v;
			this.villesVisitees = villesVisitees;
		}
		else
			throw new IllegalArgumentException();
	}
	
	public void changeState(Vertex v) {
		this.actualVille = v;
		this.villesVisitees.add(v);
	}
	
	/*
	public Boolean isEtatInitial (Graph g) {
		return (actualVille == g.getlVille().get(0)) & (villesVisitees.size() == 1 ) & (villesVisitees.get(0) == g.getlVille().get(0));
	}
	
	public Boolean isEtatFinal (Graph g) {
		Boolean val;
		for (int i=0; i<g.getlVille().size(); i++ ) {
			Ville v = g.getlVille().get(i);
			val = villesVisitees.contains(v);
			if (val == false) {
				return false;
			}
		}
		return (actualVille == g.getlVille().get(0));
	}
	*/
	//Peut-on enlever ?
	
	public Vertex getActualVille() {
		return actualVille;
	}
	public void setActualVille(Vertex actualVille) {
		this.actualVille = actualVille;
	}
	public ArrayList<Vertex> getVillesVisitees() {
		return villesVisitees;
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
		return villesVisitees + " - " + actualVille;
	}
	
	
	

}
