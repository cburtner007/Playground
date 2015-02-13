
public class TTown extends Room {

	//Buecket > Fountain > Wiseguy > Mick
	public TTown(){
		super.roomDescription =  "As the door fades away, you notice that you're now standing in some kind of town square.\n";
		super.roomDescription += "You look around. It's twilight, so you can still see perfectly fine. You begin to wonder if this town is stuck in permanent twilight.\n";
		super.roomDescription += "A dog and a duck approach you, they seem to be led by a small black mouse.";
		super.roomDescription += "You shriek in absolute terror. You pull out the closest thing you have to a weapon - your key - and brandish it, hoping to appear more intimidating. Mice are really really disgusting.\n";
		super.roomDescription += "The little black mouse stands up on its little black legs and clears its throat.\n";
		super.roomDescription += "You suddenly hear a language strikingly close to English coming from this black mouse 'yo nig. Cut 'dis crap out. I wan' axe yu somefin'.\n";
		super.roomDescription += "You narrow your eyes and skeptically lower your key 'blade'.\n";
		super.roomDescription += "The mouse speaks again 'Mah friends call me Big Mick, I 'spect you to do the same.'\n";
		super.roomDescription += "The duck and the dog tilt their heads up in what you assume to be agreement.\n";
		super.roomDescription += "'I want you to go shank a brotha. But yous gonna need a good wep first. Come back to me when you find somethin.'\n";
		super.roomDescription += "'If yous dont, you're gon haveta deal with mah homies.'\n";
		super.roomDescription += "The duck and the dog tilt their heads up again in what you assume to be a successful attempt at intimidation.";
		super.roomDescription += "\n You take a big gulp and vigorously nod your head as you slowly back away.\n";
		super.roomDescription += "To the east you see a WATERFALL that seems to be going in the wrong direction.\n";
		super.roomDescription += "To the north you see a water FOUNTAIN.\n";
		super.roomDescription += "To the south, an abandoned HOUSE.\n";
		super.roomDescription += "To the west is Big Mick and his gang, I wouldn't go back there if I were you. At least not until you have a wep to shank somebody. Mick is scary.\n";
		
		super.briefDescription = "There's a reverse WATERFALL to the east,\n";
		super.briefDescription += "An abandoned HOUSE to the south,\n";
		super.briefDescription += "a FOUNTAIN to the north, \n";
		super.briefDescription += "and Big Mick + gang to the west. But seriously, stay away from them for a bit.\n";
		
		super.itemList.add(new Item("WATERFALL"));
		super.itemList.add(new Item("FOUNTAIN"));
		super.itemList.add(new Item("HOUSE"));
		super.itemList.add(new Item("BUCKET"));
	}
	
	public String look(String n){
		
		String response = "What the heck are you trying to do?";
		
		if(n.equalsIgnoreCase("WATERFALL")){
			response = "The water in this WATERFALL isn't actually falling... It's going up instead. How trippy... You see that it's carrying some rocks upward though. You wonder if you can hop on one of them....\n";

		}else if(n.equalsIgnoreCase("FOUNTAIN")){		
			response = "A FOUNTAIN. It has water in it. Shocking.\n";

		}else if(n.equalsIgnoreCase("HOUSE")){
			response = "It's an old empty HOUSE. I highly doubt there's anything of value in there. You should just explore something else.\n";
			
		}else if(n.equalsIgnoreCase("BUCKET")){			
			response = "Nice-try guy. You need to search for this one.\n";
			
		}else if(n.equalsIgnoreCase("ROOM")){
			response = super.briefDescription; 
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
		
		return response;
	}
	
	public String search(String n, Player p){
		
		String response = "What the heck are you talking about?";
		Item temp;
		
		if(n.equalsIgnoreCase("WATERFALL")){
			response = "You SEARCH the WATERFALL and there are definitely some rocks floating upwards in this bad-boy. You can definitely hitch a ride by using this WATERFALL.\n";

		}else if(n.equalsIgnoreCase("FOUNTAIN")){		
			response = "You SEARCH the FOUNTAIN. It still has water in it. That's still shocking. You notice there are coins sitting on the bottom, presumably tossed in for a wish. You decide not to steal the coins, because you imagine yourself as being 'classy'. Don't ask me why.\n";

		}else if(n.equalsIgnoreCase("HOUSE")){
			if(this.itemUses(n) == 0){
				response = "Ok... You SEARCH the HOUSE once and find nothing. You probably shouldn't bother searching it again though, I highly doubt you'll find anything useful in there.\n";
			}else if(this.itemUses(n) == 1){
				response = "FINE FINE FINE. YOU SEARCH THE HOUSE AGAIN. YOU FIND A BUCKET. HOW ABOUT THAT? JUST GO FIND SOMETHING ELSE TO DO NOW.\n";
				temp = this.removeItem("BUCKET");
				p.addItem(temp);
			}else{
				response = "Seriously. Take a hint. Go away now.\n";
			}
			this.incItem(n);
		}else if(n.equalsIgnoreCase("BUCKET")){			
			if(p.hasItem("KEY")){
				response = "You're a pig.\n";
			}else{
				response = "What BUCKET?\n";
			}
		}else if(n.equalsIgnoreCase("ROOM")){
			response = super.briefDescription; 
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
				
		return response;
	}
	
	public String use(String n, Player p){
		
		String response = "What the heck are you talking about?";
		Item temp;
		if(n.equalsIgnoreCase("WATERFALL")){
			response = "You (kind of) gracefully hop onto one of the rocks floating upwards. You ascend.\n";
			response += "\n" + p.travelEast();
					
		}else if(n.equalsIgnoreCase("FOUNTAIN")){
			if(p.hasItem("BUCKET")){
				response = "You fill up your BUCKET with water. It is now a WATERBUCKET\n";
				//TO-DO p.removeItem("BUCKET");
				temp = new Item("WATERBUCKET");
				p.addItem(temp);
			}else{
				response = "You jump in the FOUNTAIN and die. You come back to life in front of the fountain. Someone must really want to keep you around.\n";
			}
		}else if(n.equalsIgnoreCase("HOUSE")){
			response = "You USE the HOUSE. I seriously think you're trying to make me mad. \n";

		}else if(n.equalsIgnoreCase("BUCKET")){
			if(p.hasItem("BUCKET")){
				response = "You would use a BUCKET, wouldn't you? You disgust me.";
			}else{
				response = "What BUCKET?\n";
			}		
		}else if(n.equalsIgnoreCase("KEYBLADE")){
			if(p.hasItem("KEYBLADE")){
				response = "Big Mick notices you swinging your KEYBLADE around, he strolls up to you.";
				response += "'Ey son, it's time to put 'dat wep to use. \n";
				response += "There's a big guy in some alternate dimension who thinks he's the boss.\n";
				response += "I want you to go show him I'M 'da boss.\n";
				response += "You stand there, expecting them to lead the way.\n";
				response += "Big Mick smiles (shockingly), you hear a loud *thunk* as your vision goes black.\n";
				response += "\n" + p.travelWest();
			}else{
				response = "What KEYBLADE?";
			}
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
		return response;
	}
}
