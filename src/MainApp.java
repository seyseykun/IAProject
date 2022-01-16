import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		
		ArrayList<Vertex> lv = new ArrayList<>();
		
		Vertex v1 = new Vertex(1);
        lv.add(v1);
        
        Vertex v2 = new Vertex(2);
        v1.addNewVille(v2, 21);
        v2.addNewVille(v1, 21);
        lv.add(v2);
        
        Vertex v3 = new Vertex(3);
        v1.addNewVille(v3, 9);
        v2.addNewVille(v3, 4);
        v3.addNewVille(v2, 4);
        v3.addNewVille(v1, 9);
        lv.add(v3);
        
        Vertex v4 = new Vertex(4);
        v1.addNewVille(v4, 21);
        v2.addNewVille(v4, 8);
        v3.addNewVille(v4, 6);
        v4.addNewVille(v1, 21);
        v4.addNewVille(v2, 8);
        v4.addNewVille(v3, 6);
        lv.add(v4);
        
        Vertex v5 = new Vertex(5);
        v1.addNewVille(v5, 1);
        v2.addNewVille(v5, 20);
        v3.addNewVille(v5, 7);
        v4.addNewVille(v5, 11);
        v5.addNewVille(v1, 1);
        v5.addNewVille(v2, 20);
        v5.addNewVille(v3, 7);
        v5.addNewVille(v4, 11);
        lv.add(v5);
        
        Graph g = new Graph(lv);
		
		//System.out.println(g.getSommet());
		
		//System.out.println("\n" + g.getlVille());
		

		//Heuristic h = new Heuristic(g.getlVille(), g.getSommet());
		
		//h.run();
		
        System.out.println(v1.toString());
		
		Astar a1 = new Astar(g);
		
		Integer i = a1.solve();
		
		System.out.println("\n" + i);
		
		
		//List<Ville> l1 = new ArrayList<>();
		//l1.add(v1);
		
		//State s1 = new State(v1, l1);
		
		//System.out.println("\n" + g.lPotentialVille(s1));
		
		
		System.out.println("\n \n Hill Climbing \n");
		
		HillClimbing h = new HillClimbing(g);
		
		System.out.println(h.getPathInit());
		
		System.out.println(h.solve());
		
	}	
}
