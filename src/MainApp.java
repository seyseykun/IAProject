import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bonjour, bienvenue dans notre programme. \n Voulez vous 1: rentrer les diatances des villes a la main ou 2: generer des distance aleatoirement ? (1 ou 2) ");
		Integer rep = scanner.nextInt();
		if (rep == 2) {
			System.out.println(" \n Combien de Villes voulez vous dans le graph ? (Integer) ");
			rep = scanner.nextInt();
			Graph gg = new Graph();
			for (int i = 0; i < rep-1; i++) {
				gg.addVille();
			}
			
			Astar a11 = new Astar(gg);
			
			long startTime = System.nanoTime();
			Integer ii = a11.solve();
			long endTime = System.nanoTime();
			long durationAstar = (endTime - startTime); 
			
			System.out.println("Value of A*: " + ii);
			
			

			
			System.out.println("\n \n--- Hill Climbing --- \n");
			
			HillClimbing hh = new HillClimbing(gg);
			
			startTime = System.nanoTime();
			System.out.println("Value of final path: " + hh.solve());
			endTime = System.nanoTime();
			long durationHC = (endTime - startTime);
			
			System.out.println("\n \nLe temps d'exécution de A* est de: " + durationAstar + " nanosecondes. \nLe temps d'exécution de Hill Climbing Search est de:" + durationHC + " nanosecondes.");
			
			
		}
		if (rep == 1) {
			System.out.println(" \n Combien de Villes voulez vous dans le graph ? (Integer) ");
			rep = scanner.nextInt();
			int nVille = 1;
			Vertex sommet = new Vertex(nVille);
			ArrayList<Vertex> lv = new ArrayList<>();
			lv.add(sommet);
			for (int i = 0; i < rep-1; i++) {
				nVille ++;
				Vertex ville = new Vertex(nVille);
				for (int j=0; j < lv.size(); j++) {
					System.out.println(" \n Quelle est la distance entre la ville " + ville.getnVille() + " et la ville : " + lv.get(j).getnVille() + " ? (Integer) ");
					Integer dist = scanner.nextInt();
					lv.get(j).addNewVille(ville, dist);
					ville.addNewVille(lv.get(j), dist);
				}
				lv.add(ville);
			}
			Graph g = new Graph(lv);
			
			Astar a1 = new Astar(g);
			
			long startTime = System.nanoTime();
			Integer i = a1.solve();
			long endTime = System.nanoTime();
			long durationAstar = (endTime - startTime); 
			
			System.out.println("\nValue of A*: " + i);
			
			
			
			
			System.out.println("\n \n--- Hill Climbing --- \n");
			
			HillClimbing h = new HillClimbing(g);
			
			startTime = System.nanoTime();
			System.out.println("Value of final path: " + h.solve());
			endTime = System.nanoTime();
			long durationHC = (endTime - startTime);
			
			System.out.println("Le temps d'exécution de A* est :" + durationAstar + ". \n Le temps d'exécution de Hill Climbing Search est :" + durationHC);
		}
		
	
		
		/*
		
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
		
		Astar a1 = new Astar(g);
		
		Integer i = a1.solve();
		
		System.out.println("\n A* vaut : " + i);
		
		
		
		System.out.println("\n \n Hill Climbing \n");
		
		HillClimbing h = new HillClimbing(g);
		
		System.out.println(h.getPathInit());
		
		System.out.println(h.solve());
		
		*/
	}	
}