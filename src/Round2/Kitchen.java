package Round2;

import Round3.Item;
import Round3.Player;
import Round3.Room;

public class Kitchen extends Room{
	private String response = "Whatever you're trying to do, it's wrong. \n";
	
	public Kitchen(){
		super.roomDescription = "You walk into the kitchen.\n";
		super.roomDescription += "For once, you feel like you're truly at home.\n";
		super.roomDescription += "Like you've found your domain.\n";
		super.roomDescription += "Where you belong.\n";
		super.roomDescription += "The kitchen...\n";
		super.roomDescription += "The PHONE is ringing, bt-dubs.\n";
		super.roomDescription += "There's also a SANDWICH on teh counter.\n";
		super.roomDescription += "Finally, there's the ENTRY you came through";
		
		super.briefDescription = "There's a PHONE \n";
		super.briefDescription += "There's a SANDWICH \n";
		super.briefDescription += "There's the ENTRY you came through\n";
		super.briefDescription += "Please do something interesting for once.\n";
		
		
		super.itemList.add(new Item("PHONE"));
		super.itemList.add(new Item("SANDWICH"));
	}
	
	public String look(String n){
		if(n.equalsIgnoreCase("PHONE")){
			response = "Yeah, it's ringing alright. I wonder who it is? Perhaps an adoring fan?\n";
		}else if(n.equalsIgnoreCase("SANDWICH")){
			response = "ohhhhhh.... It's your favorite kind of sandwich... Sooo yummy...\n";
			response += "Who would leave such a precious artifact out in the open, unguarded?\n";
		}else if(n.equalsIgnoreCase("ROOM")){
			response = super.briefDescription;
		}else{
			response = "Get yo head in the game \n";
		}
		return response;
	}
	public String search(String n, Player p){
		response = "Yeah, ok.\n";
		if(n.equalsIgnoreCase("PHONE")){
			response = "You search. You find the phone number that hunkster gave you a month ago.\n";
			response += "You think maybe you should give him a call soon. But you have your priorities straight.\n";
			response += "If this hunkster can't wait for you to play your video games, then he's not good enough for you.\n";
		}else if(n.equalsIgnoreCase("SANDWICH")){
			response = "You find that the SANDWICH is made out of bread, meats, and various veggies.\n";
			response += "All of the ingredients happen to also be your favorite sandwich components,\n";
			response += " making this, quite possibly, the best sandwich ever.\n";
		}
		return response;
	}
	public String use(String n, Player p){
		response = "Yeah, ok.\n";
		if(n.equalsIgnoreCase("PHONE")){
			if(p.hasItem("QUEST_BINDER") && super.itemUses("PHONE") > 0){
				response = "You call your friend back.... Again. \n";
				response += "You say 'I finished some drawings for your comic or whatever'\n";
				response += "He responds 'It's a graphic novel, but whatever.' You hang up.'\n";
				response += "Whoa, deja-vu.\n";
			}
			else if(p.hasItem("QUEST_BINDER")){
				response = "You call your friend back\n";
				response += "You say 'I finished some drawings for your comic or whatever'\n";
				response += "He responds'It's a graphic novel, but whatever.' You hang up.'\n";
				super.incItem("PHONE");
			}else{
				response = "You pick up the phone and let out a confident 'Hello?'\n";
				response += "Oh dear Lord. It's your friend harassing you about that project you promsied you'd do.\n";
				response += "Why can't these plebs just let go of empty promises? You thought your apparent apathy would discourage him from following through - too bad it didn't. \n";
				response += "You decide maybe doing 1 or 2 drawings for this guy's graphic novel can't be SO bad.\n";
				response += "You're gonna need to find your BINDER though...\n";
			}
		}else if(n.equalsIgnoreCase("SANDWICH")){
			if(p.hasItem("HUNGRY")){
				response = "You cram the sandwich into your mouth and down your own throat.\n";
				response += "It's soooo gooooood. You feel refreshed and re-energized,\n";
				response += "ready to go kick some more 'soul-less' tail in Domain of Feelings.\n";
				p.removeItem("HUNGRY");
				p.addItem(new Item("NOT_HUNGRY"));
			}else if (p.hasItem("NOT_HUNGRY")){
				response = "There's a point where you have to say 'ok, I've eaten too much and am now sufficiently fat'.\n";
				response += "You are at that point now.\n";
			}else{
				response = "It's not food time yet. You will know when it's food time. Back off this sandwich.\n";
			}
		}else if(n.equalsIgnoreCase("BINDER")){
			if(p.hasItem("QUEST_BINDER")){
				response = "Ok, you've done WAY more than enough drawing. Those scribblings you did were mentally exhausting. \n";
				response += "It's definitely game time.\n";
			}else if(p.hasItem("BINDER")){
				response = "You use your BINDER. It's SUPER EFFECTIVE! Your quest loses all of its hit-points!\n";
				response += "Your quest faints, BINDER gains 420 exp. BINDER has leveled up!\n";
				response += "BINDER is trying to learn a new ability! But it can't, because it's just a BINDER :((( \n";
				response += "Anyway, you feel pretty accomplished right now. You should go do something relaxing.\n";
				p.addItem(new Item("QUEST_BINDER"));
			}else{
				response = "Ok, come on, I just gave you this quest. You have to GO GET THE FREAKING BINDER FIRST.\n";
			}
		}else if(n.equalsIgnoreCase("ENTRY")){
			response = "You go back through the ENTRY. Lookin' for trubble.\n";
			response += p.travelWest();
		}
		return response;
	}
	
}
