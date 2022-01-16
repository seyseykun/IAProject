import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Astar {
	
	private Vertex racine;
	private ArrayList<Vertex> explored;
	private Frontier frontier;
	private Graph g;
	

	public Astar(Graph g) {
		this.racine = g.getSommet();
		this.frontier = new Frontier();
		Heuristic h = new Heuristic(g.getlVille(), racine);
		//this.frontier.push(this.racine, h.Prim());
		this.explored = new ArrayList<>();
		this.g = new Graph(g);
	}
	
	public Integer solve() throws Exception {
		
		ArrayList<Vertex> cycleHamiltonien = new ArrayList<>();
		Integer distanceparcourue = 0;
		Vertex villeprec = racine;
		
		explored.add(racine);
		cycleHamiltonien.add(racine);
		//frontier.getFrontier().remove(racine);
		
		State s = new State(racine, cycleHamiltonien);
		
		ArrayList<Vertex> l = g.lPotentialVille(s);
		ArrayList<Vertex> lh = new ArrayList<>(l);
		lh.add(racine);
	
		for (Vertex v : l) {
			ArrayList<Vertex> explos = new ArrayList<>(cycleHamiltonien);
			explos.add(v);
			State sv = new State(v, explos);
			Heuristic hv = new Heuristic(lh, v);
			frontier.push(sv, v.getActions().get(this.racine) + hv.Prim()); //f + distance de minv à v + heuristic de v	
		}
		
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
					minv = pair.getKey().getActualVille();
					mins = pair.getKey();
				}
			}
			
			//explored.add(minv);
			cycleHamiltonien = new ArrayList<>(mins.getVillesVisitees());
			//cycleHamiltonien.add(minv.getnVille());
			frontier.getFrontier().remove(mins);
			//frontier.cleanFrontier();
			//distanceparcourue += villeprec.getActions().get(minv);
			distanceparcourue = mins.getDistancevisitees();
			villeprec = minv;
			
			s = new State(minv, cycleHamiltonien);
			
			l = g.lPotentialVille(s);
			ArrayList<Vertex> lh1 = new ArrayList<>(l);
			lh1.add(racine);
			//lh1.add(minv);
		
			for (Vertex v : l) {
				ArrayList<Vertex> explos = new ArrayList<>(cycleHamiltonien);
				explos.add(v);
				State sv = new State(v, explos);
				Heuristic hv = new Heuristic(lh1, v);
				frontier.push(sv, distanceparcourue + v.getActions().get(minv) + hv.Prim()); //f + distance de minv à v + heuristic de v	
			}
		}
		System.out.println("Cycle hamiltonien :" + cycleHamiltonien);
		
		return distanceparcourue + this.racine.getActions().get(cycleHamiltonien.get(cycleHamiltonien.size()-1));
	}
	//Factoriser la redondance du code
	
	
	
	public ArrayList<Vertex> getExplored() {
		return explored;
	}

	public Vertex getRacine() {
		return racine;
	}
}
