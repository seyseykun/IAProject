import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HeuristicTest {

	@Test
	public void runtest1() {
		
		ArrayList<Vertex> lv = new ArrayList<>();
		
		Vertex v1 = new Vertex(1);
        lv.add(v1);
        
        Vertex v2 = new Vertex(2);
        v1.addNewVille(v2, 4);
        v2.addNewVille(v1, 4);
        lv.add(v2);
        
        Vertex v3 = new Vertex(3);
        v1.addNewVille(v3, 3);
        v2.addNewVille(v3, 1);
        v3.addNewVille(v2, 1);
        v3.addNewVille(v1, 3);
        lv.add(v3);
        
        Vertex v4 = new Vertex(4);
        v1.addNewVille(v4, 1);
        v2.addNewVille(v4, 2);
        v3.addNewVille(v4, 5);
        v4.addNewVille(v1, 1);
        v4.addNewVille(v2, 2);
        v4.addNewVille(v3, 5);
        lv.add(v4);
        
        Heuristic h1 = new Heuristic(lv, v1);
        
        assertEquals((Integer) 6, h1.Prim());       
	}
	
	@Test
	public void test2() {
		
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
        
        Heuristic h1 = new Heuristic(lv, v1);
        
        assertEquals((Integer) 18, h1.Prim()); 
	}
	
}
