import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HillClimbing {

	private Path pathInit ;
	private Graph graph; 
	
	public HillClimbing(Graph graph) {
		this.graph = new Graph(graph);
		ArrayList<Vertex> villes = new ArrayList<>(graph.getlVille());
		Collections.shuffle(villes);
		Path p = new Path(villes);
		this.pathInit = p.createCycle(graph);
	}
	
	public HillClimbing(Graph graph, Path pathInit) {
		this.graph = new Graph(graph);
		this.pathInit = pathInit.createCycle(graph);
	}
	
	public HillClimbing(Graph graph, ArrayList<Vertex> path) {
		this.graph = new Graph(graph);
		Path p = new Path(path);
		this.pathInit = p.createCycle(graph);
	}
	

	public Integer solve() throws Exception {
		Astar a = new Astar(this.graph);
		Integer sol = a.solve();
		System.out.println("Value of A* : " + sol);
		
		System.out.println("Cost of initial Path: " + this.pathInit.costOfPath());
		double taux = this.pathInit.costOfPath();
		if (this.pathInit.costOfPath() <= sol) {
			return this.pathInit.costOfPath();
		}
		else {
			while ( (this.pathInit.costOfPath() > sol) && (this.bestPath().costOfPath() < pathInit.costOfPath()) ){
				
				this.pathInit = new Path(this.bestPath());
				System.out.println("New path: " + this.pathInit.costOfPath());
			}
			Integer écart = pathInit.costOfPath() - sol;
			System.out.println("Ecart à l'optimum: " + écart);
			if (pathInit.costOfPath() != taux) {taux = (-pathInit.costOfPath()/taux)*100 + 100;}
			else {taux = 0;}
			System.out.println("Taux d'amélioration par rapport à la solution initiale: " + taux + "%");
			return pathInit.costOfPath();
		}
	}
	
	
	private Path bestPath() {
		ArrayList<Path> paths = new ArrayList<>(this.permutations());
		Path bestpath = new Path(pathInit);
		Integer cost = pathInit.costOfPath();
		for (Path p : paths) {
			if(p.costOfPath() < cost) {
				bestpath = p;
				cost = p.costOfPath();
			}
		}
		return bestpath;
	}

	
	private ArrayList<Path> permutations(){
		ArrayList<Path> paths = new ArrayList<>();
		for (int i = 2 ; i < pathInit.getVilles().size() - 1 ; i++) {
			Path path = new Path(pathInit);
			Collections.swap(path.getVilles(), i, 1);
			paths.add(path);
		}
		return paths;		
	}

	
	public Path getPathInit() {
		return pathInit;
	}
	
}
