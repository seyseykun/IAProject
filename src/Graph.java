
import java.util.ArrayList;
import java.util.List;

public class Graph {
	private ArrayList<Vertex> lVille = new ArrayList<Vertex>();
	private Vertex sommet;
	private int nVille;
	
	public Graph() {
		nVille = 1;
		sommet = new Vertex(nVille);
		lVille.add(sommet);	
	}
	
	public Graph(ArrayList<Vertex> lVille) {
		this.lVille = lVille;
		this.sommet = lVille.get(0);
		nVille = lVille.size();
	}
	
	
	public Graph(Graph g) {
		this.lVille = new ArrayList<>(g.getlVille());
		this.sommet = lVille.get(0);
		nVille = lVille.size();
	}
	
	public void addVille () {
		nVille ++;
		Vertex ville = new Vertex(nVille);
		int min = 1;
	    int max = 100;
		for (int i=0; i < lVille.size(); i++) {
			int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
			lVille.get(i).addNewVille(ville, random_int);
			ville.addNewVille(lVille.get(i), random_int);
		}
		lVille.add(ville);
	}
	
	
	/**
	 * Method that returns the list of non-visited cities that you can visit from state s
	 * @param s
	 * @return
	 */
	
	public ArrayList<Vertex> lPotentialVille(State s){
		ArrayList<Vertex> lPotentialVille = new ArrayList<Vertex>();
		for (int i = 0; i<lVille.size(); i++) {
			ArrayList<Vertex> ll = new ArrayList<>(s.getVillesVisitees());
			Vertex vv = lVille.get(i);
			if (!(ll.contains(vv))){ 
				lPotentialVille.add(vv);
			}
		}
		return lPotentialVille;
	}
	
	
	
	
	
	public ArrayList<State> ACTIONS(State s){
		ArrayList<State> lPotentialState = new ArrayList<State>();
		for (int i = 0; i<lVille.size(); i++) {
			if (!(s.getVillesVisitees().contains(lVille.get(i)))) {
				State ss = s;
				ss.changeState(lVille.get(i));
				lPotentialState.add(ss);
			}
		}
		return lPotentialState;
	}
	
	public ArrayList<Vertex> StatesToVertices(ArrayList<State> ls){
		ArrayList<Vertex> lv = new ArrayList<Vertex>();
		for (int i = 0; i<ls.size(); i++) {
			lv.add(ls.get(i).getActualVille());
		}
		return lv;
	}
	
	/*
	public Integer RESULT(State sInitial, State sFinal) throws Exception{
		Integer cost = 0;
		if (sInitial.isAction(sFinal) == true) {
			Vertex vInit = sInitial.getActualVille();
			Vertex vFin = sFinal.getActualVille();
			cost = vInit.getActions().get(vFin);
			return cost;
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}*/

	
	
	
	
	
	//GETTERS AND SETTERS
	
	public ArrayList<Vertex> getlVille() {
		return lVille;
	}


	public Vertex getSommet() {
		return sommet;
	}


	
	

}
