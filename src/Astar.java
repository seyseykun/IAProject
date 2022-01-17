import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Astar {
	
	private Vertex racine;
	private ArrayList<Vertex> cycleHamiltonien;
	private Frontier frontier;
	private Graph g;
	

	public Astar(Graph g) {
		this.racine = g.getSommet();
		this.frontier = new Frontier();
		this.cycleHamiltonien = new ArrayList<>();
		this.g = new Graph(g);
	}
	
	
	/**
	 * Method that returns the value of the smallet Hamiltonian cycle of the graph associated to the current instance of Astar
	 * @return
	 * @throws Exception
	 */
	public Integer solve() throws Exception {
		Integer tailleMaxF = 0;
		cycleHamiltonien = new ArrayList<>();
		Integer distanceparcourue = 0;

		
		cycleHamiltonien.add(racine);
		
		State s = new State(racine, cycleHamiltonien);
		
		ArrayList<Vertex> l = g.lPotentialVille(s);
		ArrayList<Vertex> lh = new ArrayList<>(l);
		lh.add(racine);
	
		for (Vertex v : l) {
			ArrayList<Vertex> explos = new ArrayList<>(cycleHamiltonien);
			explos.add(v);
			State sv = new State(v, explos);
			Heuristic hv = new Heuristic(lh, v);
			frontier.push(sv, v.getActions().get(this.racine) + hv.Prim()); //distance de racine à v + heuristic de v	
		}
		tailleMaxF = Math.max(tailleMaxF, frontier.getFrontier().size());
		
		while (!cycleHamiltonien.containsAll(g.getlVille())) {
			//On choisit la ville la plus proche dans la frontière
			
			Integer i = Integer.MAX_VALUE;
			Vertex minv = new Vertex(i);
			State mins = new State();
			Iterator<Map.Entry<State, Integer>> it = frontier.getFrontier().entrySet()
			        .iterator();
			while (it.hasNext()) {
				Map.Entry<State, Integer> pair = it.next();
				if (pair.getValue() < i) {
					i = pair.getValue();
					minv = pair.getKey().getActualVille(); //Peut-on enlever cette ligne ? l = g.lPotentialVille(s); devient l = g.lPotentialVille(mins);
					mins = pair.getKey();
				}
			}
			
			cycleHamiltonien = new ArrayList<>(mins.getVillesVisitees());
			frontier.getFrontier().remove(mins);
			distanceparcourue = mins.getDistancevisitees();
			
			s = new State(minv, cycleHamiltonien);
			l = g.lPotentialVille(s);
			ArrayList<Vertex> lh1 = new ArrayList<>(l);
			lh1.add(racine);
		
			for (Vertex v : l) {
				ArrayList<Vertex> explos = new ArrayList<>(cycleHamiltonien);
				explos.add(v);
				State sv = new State(v, explos);
				Heuristic hv = new Heuristic(lh1, v);
				frontier.push(sv, distanceparcourue + v.getActions().get(minv) + hv.Prim()); //distance de racine à v + heuristic de v	
			}
			tailleMaxF = Math.max(tailleMaxF, frontier.getFrontier().size());
			
		}
		System.out.println("Cycle hamiltonien :\n" + cycleHamiltonien + "\n");
		System.out.println("La taille maximum de frontier est : " + tailleMaxF + "\n");
		return distanceparcourue + this.racine.getActions().get(cycleHamiltonien.get(cycleHamiltonien.size()-1));
	}
	
	
	
	
	
	//GETTERS AND SETTERS
	public ArrayList<Vertex> getCycleHamiltonien() {
		return cycleHamiltonien;
	}

	public Vertex getRacine() {
		return racine;
	}
}
