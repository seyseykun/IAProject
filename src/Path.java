
import java.util.ArrayList;
import java.util.List;

public class Path {
	private ArrayList<Vertex> villes =  new ArrayList<Vertex>();
	
	public Path() {
		this.villes =  new ArrayList<Vertex>();
	}
	
	public Path(Vertex v) {
		this.villes =  new ArrayList<Vertex>();
		villes.add(v);
	}
	
	public Path(Vertex... v) {
		this.villes =  new ArrayList<Vertex>();
		for(Vertex ver : v) {
			villes.add(ver);
		}
	}
	
	public Path(ArrayList<Vertex> villes) {
		this.villes =  new ArrayList<Vertex>(villes);
		
	}
	
	public void addVille (Vertex v) {
		villes.add(v);
	}
	
	public Integer costOfPath() {
		Integer cost = 0;
		Vertex a = villes.get(0);
		for (int i= 1; i < villes.size(); i++) {
			Vertex b = villes.get(i);
			cost += b.getActions().get(a).getCost();
			a = b;
		}
		return cost ;
	}
	
	public Path createCycle(Graph g) {
		Path p = new Path();
		if ( (this.villes.containsAll(g.getlVille())) && (this.villes.size() == g.getlVille().size()) ) {
			for (Vertex v : this.villes) {
				p.addVille(v);
			}
			p.addVille(this.villes.get(0));
			return p;
		}
		else {
			throw new IllegalArgumentException("The path does not contain all the vertices of the graph passed as a parameter");
		}	
	}

	public ArrayList<Vertex> getVilles() {
		return villes;
	}

	
	@Override
	public String toString() {
		return villes.toString();
	}


}
