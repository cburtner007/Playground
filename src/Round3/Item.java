package Round3;

public class Item {

	private int timesUsed;
	private String name;
	
	public Item(String n){
		timesUsed = 0;
		name = n.toUpperCase();
	}

	public String getName(){
		return name;
	}
	public int getUses(){
		return timesUsed;
	}
	
	public boolean incrementUsage(){
		timesUsed++;
		
		return true;
	}
}
