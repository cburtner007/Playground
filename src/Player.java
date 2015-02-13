import java.util.*;


public class Player {

	private String name; 
	
	private ArrayList<Item> bag = new ArrayList <Item>();
	
	private String status; //Something nasty affecting the player, may impair movement.
	
	private Room currentRoom;
	
	public Player(){
		
	}
	
	/**
	 * 
	 * @return The name of the item added to the backpack
	 */
	public String addItem(Item i){
		bag.add(i);
		return i.getName();
	}
	
	public boolean canMove(){
		boolean flag = true ; 
		
		if(status.equalsIgnoreCase("MOVE_IMPAIRED")){
			flag = false;
		}
		
		return flag ;
	}
	
	public String command(String c){
		String response = null;
		c = c.toUpperCase(); //Converts command to upper case
		
		String[] s = c.split(" ");
		
		//Ensures user is using correct command format
		if(s.length != 2 && s.length != 1){
			throw new Error("String needs to be 'XXXX YYYY' format or just 'LOOK' ");
		}
	
		if(s[0].equalsIgnoreCase("LOOK")){
			if(s.length == 1){
				response = currentRoom.look("ROOM");
			}else{
				response = currentRoom.look(s[1]);
			}
		}else if(s[0].equalsIgnoreCase("SEARCH")){
			response = currentRoom.search(s[1], this);
		}else if(s[0].equalsIgnoreCase("USE")){
			response = currentRoom.use(s[1], this);
		}else{
			response = "Yeah, ok.";
		}
		return response;
	}
	
	/**
	 * 
	 * @return If designated item is in player's backapck -> Returns true
	 */
	public boolean hasItem(String n){
		boolean flag = false; 
		Iterator<Item> iter = bag.iterator();
		
		
		while(iter.hasNext() && !flag){
			flag = iter.next().getName().equalsIgnoreCase(n.toUpperCase()); //Flag becomes true when the iterator is pointing at an item with the same name
		}
		
		return flag; 
	}
	
	/**
	 * Removes an item of the designated name from the player's backpack
	 * 
	 * @return The name of the removed item is returned
	 */
	public String removeItem(){
		return "Lol";
	}
	
	public void setRoom(Room r){
		currentRoom = r;
	}
	
	
	public String travelWest(){
		this.currentRoom = currentRoom.goWest();
		
		return currentRoom.getRoomDescription();
	}
	
	public String travelEast(){
		this.currentRoom = currentRoom.goEast();
		
		return currentRoom.getRoomDescription();
	}
	
	public static void main(String args[]){
		Player testP = new Player();
		Bedroom testB = new Bedroom();
		TTown testT = new TTown();
		HBastion testH = new HBastion();
		NeverCastle testN = new NeverCastle();
		
		testB.setEast(testT);
		testT.setEast(testH);
		testT.setWest(testN);
		testH.setWest(testT);
		
		testP.setRoom(testB);
		
		Scanner sc = new Scanner(System.in);
		
		String input = "TEMP";
		String output = testB.getRoomDescription();
		
		System.out.println(output);
		while(!input.equalsIgnoreCase("STOP")){
			
			input = sc.nextLine();
			output = testP.command(input);
			
			System.out.println(output);
		}
	}
}
