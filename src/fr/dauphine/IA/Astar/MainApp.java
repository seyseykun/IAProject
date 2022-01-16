package fr.dauphine.IA.Astar;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainApp {

	public static void main(String[] args) {
		
		ArrayList<String> city = new ArrayList<>();
		city.add("A");
		city.add("B");
		city.add("C");
		
		
		Graph graph = new Graph();
	    for (String s : city) {
	    	graph.addVertex(s);
	    }
	    for (String s1 : city) {
	    	for (String s2 : city) {
	    		if (s1 != s2) {
	    			graph.addEdge(s1, s2, ThreadLocalRandom.current().nextInt(1, 100));  //Random number between 1 and 99.
	    		}
	    	}
	    }
	}
}
