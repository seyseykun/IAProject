
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
	//Il faut que les villes soient construites correctement (faire attention aux voisins de chaque ville)
	
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
	
	public ArrayList<Vertex> lPotentialVille(State s){
		ArrayList<Vertex> l = new ArrayList<Vertex>();
		for (int i = 0; i<lVille.size(); i++) {
			ArrayList<Vertex> ll = s.getVillesVisitees();
			Vertex vv = lVille.get(i);
			if (!(ll.contains(vv))){
				l.add(vv);
			}
		}
		return l;
	}
	
	public ArrayList<State> lPotentialState(State s){
		ArrayList<State> l = new ArrayList<State>();
		for (int i = 0; i<lVille.size(); i++) {
			if (!(s.getVillesVisitees().contains(lVille.get(i)))) {
				State ss = s;
				ss.changeState(lVille.get(i));
				l.add(ss);
			}
		}
		return l;
	}
	
	public Integer cost (State sInitial, State sFinal) throws Exception{
		Integer cost = 0;
		if (sInitial.isAction(sFinal) == true) {
			Vertex vInit = sInitial.getActualVille();
			Vertex vFin = sFinal.getActualVille();
			cost = vInit.getActions().get(vFin).getCost();
			return cost;
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}
	
	public ArrayList<Vertex> villeNonVisetees(State s){
		ArrayList<Vertex> res = new ArrayList<Vertex>();
		for (int i = 0; i<lVille.size(); i++) {
			if (!(s.getVillesVisitees().contains(lVille.get(i)))) {
				res.add(lVille.get(i));
			}
		}
		return res;
	}

	public ArrayList<Vertex> getlVille() {
		return lVille;
	}

	public void setlVille(ArrayList<Vertex> lVille) {
		this.lVille = lVille;
	}

	public Vertex getSommet() {
		return sommet;
	}

	public void setSommet(Vertex sommet) {
		this.sommet = sommet;
	}

	
	

}
