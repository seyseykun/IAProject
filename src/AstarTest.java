import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class AstarTest {

	@Test
	public void runtest1() throws Exception {
		
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
        
        Graph g = new Graph(lv);
        Astar a1 = new Astar(g);
        
        assertEquals((Integer) 7, a1.solve());  
        
	}
	
}
