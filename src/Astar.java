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
		this.frontier.push(this.racine, h.run());
		this.explored = new ArrayList<>();
		this.g = g;
	}
	
	public Integer solve() throws Exception {
		
		ArrayList<Integer> cycleHamiltonien = new ArrayList<>();
		Integer distanceparcourue = 0;
		Vertex villeprec = racine;
		
		explored.add(racine);
		cycleHamiltonien.add(racine.getnVille());
		frontier.getFrontier().remove(racine);
		
		State s = new State(racine, explored);
		
		ArrayList<Vertex> l = g.lPotentialVille(s);
		ArrayList<Vertex> lh = new ArrayList<>(l);
		lh.add(racine);
	
		for (Vertex v : l) {
			Heuristic hv = new Heuristic(lh, v);
			frontier.push(v, v.getActions().get(this.racine).getCost() + hv.run()); //f + distance de minv à v + heuristic de v	
		}
		
		while (!explored.containsAll(g.getlVille())) {
			Integer i = Integer.MAX_VALUE;
			Vertex minv = new Vertex(i);
			Iterator<Map.Entry<Vertex, Integer>> it = frontier.getFrontier().entrySet()
			        .iterator();
			while (it.hasNext()) {
				Map.Entry<Vertex, Integer> pair = it.next();
				if (pair.getValue() < i) {
					i = pair.getValue();
					minv = pair.getKey();
				}
			}
			explored.add(minv);
			cycleHamiltonien.add(minv.getnVille());
			frontier.getFrontier().remove(minv);
			distanceparcourue += villeprec.getActions().get(minv).getCost();
			villeprec = minv;
			
			s = new State(minv, explored);
			
			l = g.lPotentialVille(s);
			ArrayList<Vertex> lh1 = new ArrayList<>(l);
			lh1.add(racine);
			lh1.add(minv);
		
			for (Vertex v : l) {
				Heuristic hv = new Heuristic(lh1, v);
				frontier.push(v, distanceparcourue + v.getActions().get(minv).getCost() + hv.run()); //f + distance de minv à v + heuristic de v	
			}
		}
		System.out.println("Cycle hamiltonien :" + cycleHamiltonien);
		return distanceparcourue + this.racine.getActions().get(explored.get(explored.size()-1)).getCost();
	}
	//Factoriser la redondance du code
	
	
	
	public ArrayList<Vertex> getExplored() {
		return explored;
	}

	public Vertex getRacine() {
		return racine;
	}
}
