package Round2;
import java.util.*;
//import 

import Round3.Item;
import Round3.Player;
import Round3.Room;

public class Spahgetti extends Room{

	private String response = "Whatever you're trying to do, it's wrong. \n";
	
	public Spahgetti(){
		super.roomDescription = "Your eyes flutter open.\n";
		super.roomDescription += "You feel like you were hit by a bus.\n";
		super.roomDescription += "The ceiling is pasty white.\n";
		super.roomDescription += "The walls are a dull yellow.\n";
		super.roomDescription += "You can tell you're in your room. Mostly because it's an absolute mess.\n";
		super.roomDescription += "The custom ARTsy stuff on the walls is also a good indicator.";
		super.roomDescription += "Your CLOTHES strewn all over the floor only serves to further verify that this is, indeed, your room.\n";
		super.roomDescription += "But it's summer, who cares if your room is a mess?\n";
		super.roomDescription += "Oh yeah, your mom does.\n";
		super.roomDescription += "Suddenly a woman bursts in and commands you to get out of bed and clean up.\n";
		super.roomDescription += "In an equally sudden whoosh, she's gone.\n";
		super.roomDescription += "You roll out of bed and stand up a little too fast.\n";
		super.roomDescription += "Your palms are heavy, knees weak, arms spahgetti.\n";
		super.roomDescription += "Anyway, you finally collect yourself and notice there's a DOOR - something which all good rooms have.\n";
		super.roomDescription += "What do?\n";
	
		super.briefDescription = "There is ART on the walls.\n";
		super.briefDescription += "CLOTHES on the floor.\n";
		super.briefDescription += "Everyone walk the dinosaur.\n";
		super.briefDescription += "Lol.\n";
		super.briefDescription += "Also, don't forget the DOOR. Important stuff that is.\n";
		
		super.itemList.add(new Item("KEY"));
		super.itemList.add(new Item("CLOTHES"));
		super.itemList.add(new Item("ART"));
		super.itemList.add(new Item("BINDER"));
		super.itemList.add(new Item("MONEY"));
		super.itemList.add(new Item("DOOR"));
	}
	
	public String look(String n){
		
		if(n.equalsIgnoreCase("KEY")){
			response = "What key? :o) \n)";
		}else if(n.equalsIgnoreCase("CLOTHES")){
			response = "Skinny jeans and other hipstery accoutrements adorn the hardwood floor.\n";
		}else if(n.equalsIgnoreCase("ART")){
			response = "Various assortments and flavors of fan-girl-art-type-stuff. Seriously though, there's too much.\n";
		}else if(n.equalsIgnoreCase("BINDER")){
			response = "'Ho boy, your spidey senses are tingling! You think there might be something in here.\n";
		}else if(n.equalsIgnoreCase("ROOM")){
			response = super.briefDescription;
		}else{
			response = "Get yo head in the game.\n";
		}
		return response;
	}
	public String search(String n, Player p){
	
		response = "Yeah, ok.\n";
		if(p.hasItem("FIN")){
			response = "FIN";
		}else if(n.equalsIgnoreCase("KEY")){
			if(super.hasItem("KEY") && p.hasItem("KEY_QUEST")){
				response = "YOU SUPER SLEUTH YOU!!!! You found the KEY(necklace)!!\n";
				response += "You carefully don your KEY(necklace).\n";
				response += "You slide your feet apart and lift your hands to strike a pose.\n";
				response += "You somehow trip and fall - even though you didn't even pick your feet up off the ground. \n";
				response += "Whateva, you still coo tho'\n";
				response += "You's ready for tha boss fight.\n"; 
				p.addItem(super.removeItem("KEY"));
			}else if(!p.hasItem("KEY_QUEST")){
				response = "What key? :o)";
			}else if(p.hasItem("KEY")){
				response = "No key here. I think you already have it. Derp.";
			}
		}else if(n.equalsIgnoreCase("CLOTHES")){
			if(super.hasItem("MONEY")){
				response = "With an entrepreneurial spirit, you rummage through your clothes.\n";
				response += "OMG YOU FIND SOME DOSH!!! YOU POCKET THAT CRAP IMMEDIATELY.\n";
				response += "YOU SUCK AT MATH SO YOU DON'T BOTHER COUNTING. BUT HOLY CRAP MONEY!!!";
				p.addItem(super.removeItem("MONEY"));
			}else{
				response = "You search your clothes again. Hoping to find more dollah-$wag. No luck";
			}
		}else if(n.equalsIgnoreCase("ART")){
			if(p.hasItem("SORA_ART")){
				response = "Your stare mournfully at your wall, it feels so barren without that particular picture of Soran.\n";
			}else if(p.hasItem("ART_QUEST")){
				response = "You carefully glare at your art, hoping to find soemthing to sate your sister's anger.\n";
				response += "Your eye latches onto your most prized piece of art....\n";
				response += "It's your rendition of Soran - halfway through taking his shirt off.\n";
				response += "Mmmmmm, look at those abs....\n";
				response += "You snap out of it - shaking your head vigorously.\n";
				response += "You know what you must do... You carefully unpin the poster from the wall. \n";
				response += "You would sacrifice your own life just to protect the integrity of this fine fine piece of man me- I mean art.\n";
				response += "This is why you intend on giving it to your SISTER. Playing this game is more important to you.\n";
				p.addItem(new Item("SORA_ART"));
				
			}else{
				response = "You searh your ART. You find nothing of interest... Heheheh ;) \n";
			}
		}else if(n.equalsIgnoreCase("BINDER")){
			if(super.hasItem("BINDER")){
				response = "Holy crap, your BINDER is in this room?!?! I had no idea! You pocket 'dat swag immediately. \n";
				p.addItem(super.removeItem("BINDER"));
			}else{
				response = "It's already in your pocket. Not sure how you got it in there. But you did";
			}
		}
		return response;
	}
	public String use(String n, Player p){
		
		response = "Yeah, ok.\n";
		
		if(p.hasItem("FIN")){
			response = "FIN";
		}else if(n.equalsIgnoreCase("KEY")){
			response = "What key? Yo?.\n";
		}else if(n.equalsIgnoreCase("CLOTHES")){
			response = "Lol, aint no way you're picking up all 'dese clothes. That's someone else's job.\n";
		}else if(n.equalsIgnoreCase("ART")){
			response = "You stare intently at these beautiful masterpieces. Using them to tha maaax.\n";
		}else if(n.equalsIgnoreCase("BINDER")){
			if(p.hasItem("BINDER")){
				response = "You use your BINDER. It is ineffective. You need a better surface to draw on.\n";
			}else{
				response = "You should get a BINDER first.\n";
			}
		}else if(n.equalsIgnoreCase("DOOR")){
			response = "You use the DOOR to leave your room.\n";
			response += "You slide down the nearby banister and find yourself standing in the living room.\n";
			response += p.travelEast();
		}else if(n.equalsIgnoreCase("BED")){
			response = "You lay your head down to sleep.\n";
			response += "You try to imagine a better life for yourself. \n";
			response += "Man, if only Soran were real.\n";
			response += "FIN";
			p.addItem(new Item("FIN"));
		}
		
		return response;
	}
}
