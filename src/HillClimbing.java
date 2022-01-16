import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HillClimbing {

	private Path pathInit ;
	private Graph graph; 
	
	public HillClimbing(Graph graph) {
		this.graph = graph;
		ArrayList<Vertex> villes = new ArrayList<>(graph.getlVille());
		Collections.shuffle(villes);
		Path p = new Path(villes);
		this.pathInit = p.createCycle(graph);
	}
	
	public HillClimbing(Graph graph, Path pathInit) {
		this.graph = graph;
		this.pathInit = pathInit.createCycle(graph);
	}
	
	public HillClimbing(Graph graph, ArrayList<Vertex> path) {
		this.graph = graph;
		Path p = new Path(path);
		this.pathInit = p.createCycle(graph);
	}
	
	
	public Integer solve() throws Exception {
		Astar a = new Astar(this.graph);
		Integer sol = a.solve();
		System.out.println("La solution A* : " + sol);
		
		System.out.println(this.pathInit.costOfPath());
		
		if (this.pathInit.costOfPath() <= sol) {
			return this.pathInit.costOfPath();
		}
		else {
			while ( (this.pathInit.costOfPath() > sol) && (this.bestPath().costOfPath() < pathInit.costOfPath()) ){
				System.out.println(this.pathInit.costOfPath());
				this.pathInit = this.bestPath();
			}
			return pathInit.costOfPath();
		}
	}
	
	
	private Path bestPath() {
		ArrayList<Path> paths = this.permutations();
		Path bestpath = this.pathInit;
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
			Path path = pathInit;
			Collections.swap(path.getVilles(), i, 1);
			paths.add(path);
		}
		return paths;		
	}

	
	public Path getPathInit() {
		return pathInit;
	}
	
}
