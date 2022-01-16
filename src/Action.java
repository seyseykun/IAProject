
public class Action {
	private Integer cost;
	private boolean isIncluded = false;
	
	public Action(Integer c) {
		cost = c;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Action) {
            Action a = (Action)obj;
            return cost == a.getCost();
        }
        else {
            throw new ClassCastException();
        }
    }
	
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "cost: " + cost;
	}

	public boolean isIncluded() {
		return isIncluded;
	}

	public void setIncluded(boolean isIncluded) {
		this.isIncluded = isIncluded;
	}
	
	

}
