import java.util.ArrayList;

public class StateHC {

	private ArrayList<Vertex> cycle = new ArrayList<Vertex>();
	//Toutes les villes doivent être uniques dans la liste
	
	public StateHC(ArrayList<Vertex> cycle) {
		this.cycle = cycle;
	}
	
	
	//Return the
	public Integer Cost() {
		Integer cost = 0;
		for (int i= 1; i < cycle.size(); i++) {
			cycle.get(i).getActions().get(cycle.get(i+1)).getCost(); 
			cost += cost;
		}
		return cost;
	}
	
}
