package Round3;
import java.util.*;

public class Room {

	protected Room eastRoom;
	protected Room westRoom;
	
	protected String previousC;
	
	protected String roomDescription;
	protected String briefDescription;
	
	protected ArrayList<Item> itemList = new ArrayList<Item>();
		
	protected Player p;
	
	private int numVisits = 0;
	
	public Room(){}
	
	public Item getItem(String n){
		//**Untested**
		
		Iterator<Item> iter = itemList.iterator();
		Item temp = iter.next();
		
		//Loops until temp is pointing at the item named "n"
		while( !temp.getName().equalsIgnoreCase(n.toUpperCase()) ){
			temp = iter.next();
		}
		
		return temp;
	}
	
	public boolean incItem(String n){
		boolean flag = false;
		
		Item temp = this.getItem(n);
		flag = temp.incrementUsage();
		
		return flag; //Should be true if all goes well
	}
	
	public int itemUses(String n){
		int num;
		
		Item temp = this.getItem(n);
		num = temp.getUses();
		
		return num;
		
	}
	public boolean hasItem(String n){
		boolean flag = false; 
		Iterator<Item> iter = itemList.iterator();
		
		
		while(iter.hasNext() && !flag){
			flag = iter.next().getName().equalsIgnoreCase(n.toUpperCase()); //Flag becomes true when the iterator is pointing at an item with the same name
		}
		
		return flag; 
	}
	
	public Item removeItem(String n){
		Item temp = this.getItem(n);
		this.itemList.remove(temp);
		return temp;
	}
	
	public String getRoomDescription(){
		String description = this.roomDescription;
		
		if(numVisits > 0){
			description = this.briefDescription;
		}
		
		numVisits++;
		return description;
	}
	
	public void setNumVisits(int i){
		numVisits = i;
	}
	
	/*public Room goNorth(){
		return northRoom;
	}*/
	
	public Room goEast(){
		return eastRoom;
	}
	
	/*public Room goSouth(){
		return southRoom;
	}*/
	
	public Room goWest(){
		return westRoom;
	}
	
	public void setEast(Room r){
		this.eastRoom = r;
	}
	
	public void setWest(Room r){
		this.westRoom = r;
	}
	
	/**
	 * The three commands
	 */
	public String look(String n){
		return null;
	}
	public String search(String n, Player player){
		return null;
	}
	public String use(String n, Player player){
		return null;
	}
	
}
