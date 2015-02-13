package Round2;

import Round3.Item;
import Round3.Player;
import Round3.Room;

public class LivingRoom extends Room{

	private String response = "Whatever you're trying to do, it's wrong. \n";
	private int moveNumber = 0;
	public LivingRoom(){
		super.roomDescription = "You're now standing in the living room.\n";
		super.roomDescription += "One of your SISTERs is lounging on the chair.\n";
		super.roomDescription += "You're not entirely sure which SISTER it is, it's so hard to keep all their names straight.\n";
		super.roomDescription += "Ohhhh! Your PLAYSTATION is up in here too! Well, I should say 'your' PLAYSTATION.\n";
		super.roomDescription += "You actually can't really remeber who you're borrowing it from - but you know it's not actually your's.\n";
		super.roomDescription += "There's also da ENTRY to the kitchen. You can feel your stomach growling from not having enough spahgetti\n";
		super.roomDescription += "Oh, and we can't forgetabout the STAIRS you came down - which you will probably be going back up.\n";
		super.roomDescription += "Man, the living room could use some work. Hopefully someone who isn't you gets on this mess.\n";
		
		super.briefDescription = "You're in the living room.\n";
		super.briefDescription += "Ya see ya SISTER lougin' (or something else mebe) \n";
		super.briefDescription += "Ya see ya PLAYSTATION sittin'\n";
		super.briefDescription += "Ya see tha ENTRY to tha kitch'\n";
		super.briefDescription += "Ya see tha STAIRS to tha upSTAIRS.\n";
		super.briefDescription += "Ya get ready to drop some beets.\n";
		
		super.itemList.add(new Item("PLAYSTATION"));
		super.itemList.add(new Item("SISTER"));
	}
	
	public String look(String n){
		if(n.equalsIgnoreCase("PLAYSTATION")){
			response = "So black... So sleek... Oh the things you'd like to do with it\n";
		}else if(n.equalsIgnoreCase("SISTER")){
			response = "Yep. It's definitely your flesh and blood. She sneers at you and goes back to doing sister things.\n";
		}else if(n.equalsIgnoreCase("ROOM")){
			response = super.briefDescription;
		}else{
			response = "get yo head in the game\n";
		}
		return response;
	}
	public String search(String n, Player p){
		response = "Yeah, ok.\n";
		if(n.equalsIgnoreCase("PLAYSTATION")){
			response = "You give your PLAYSTATION a good 'ol search. You find your favorite game still in the disk-tray: Domain of Feelings.\n";
			response += "Man, you just can't get enough of Domain of Feelings.\n";
			response += "You're definitely going to be 'buying' the Playstation 420 as soon as it comes out, just so you can play the new one.\n";
		}else if(n.equalsIgnoreCase("SISTER")){
			response = "You give your SISTER a pat-down\n";
			response += "She glares at you the whole time.\n";
			response += "You finally make eye-contact with her and realize what you've done.\n";
			response += "You feel your face become flush. Why the heck would you give your SISTER a pat-down?\n";
		}
		return response; 
	}
	public String use(String n, Player p){
		response = "Yeah, ok.\n";
		//Combo is "UP", "UP", "DOWN", "DOWN", "LEFT", "DOWN", "LEFT", "UP", "RIGHT"
		if(n.equalsIgnoreCase("UP") && p.hasItem("GAME_TIME")){
			if(isNextMove(n)){
				response = "You successfully hop UP into the air.\n";
			}else{
				response = "You trip in the air as you jump. You fall on your face. Looks like you'll have to start the combo over again.\n";
			}
		}else if(n.equalsIgnoreCase("DOWN") && p.hasItem("GAME_TIME")){
			if(isNextMove(n)){
				response = "You successfully squat DOWN.\n";
			}else{
				response = "You wobble a little bit and fall backwards. Looks like you'll have to start the combo over again.\n";
			}
		}else if(n.equalsIgnoreCase("LEFT") && p.hasItem("GAME_TIME")){
			if(isNextMove(n)){
				response = "You successfully inch towards the LEFT.\n";
			}else{
				response = "You stumble to the left. That's definitely not it. Looks like you'll have to start the combo over again.\n";
			}
		}else if(n.equalsIgnoreCase("RIGHT") && p.hasItem("GAME_TIME")){
			if(isNextMove(n)){
				response = "You (your character) flies into the air and performs the ULTIMA SLICE-AND-DICE OF DEATH.\n";
				response += "WOW.\n";
				response += "SO MUCH DAMAGE. \n";
				response += "SUCH FORM.\n";
				response += "Bosse is very ded.... Wow\n";
				p.removeItem("GAME_TIME");
				response += "You jump up and dance like a G-D fool.\n";
				response += "You notice the rest of your family has filed into the living room at this point.\n";
				response += "Even your closest friend is here.\n";
				response += "such awkward. \n";
				response += "Wowee, would you look at the time?\n";
				response += "It's almost 7:30! \n";
				response += "Looks like you'll have to pack it in for tonight. \n";
				p.addItem(new Item("BED_TIME"));
				response += "Go find your BED. Amiga.\n";
			}else{
				response = "You stumble to the right. That's not it. Looks like you'll have to start the combo over again.\n";
			}
		}else if(p.hasItem("GAME_TIME")){
			response = "OH. OH NO. YOU'RE BEATING THIS BOSS. RIGHT HERE. RIGHT NOW.\n";
		}else if(n.equalsIgnoreCase("PLAYSTATION")){
			if(p.hasItem("KEY")){
				response = "Using the KEY to channel your inner energies, you focus your concentration into the controller or something. \n";
				response += "You (and by 'you' I mean the character you control) leap into the boss-fight chamber.\n";
				response += "You skip the opening cinematic and leap into action\n";
				response += "All you have to do is unleash the ultima-kill-combo.\n";
				response += "It's game time. Use the USE XXXX command to execute moves in the correct order. \n";
				response += "Your moves are UP, DOWN, LEFT, and RIGHT.  Goodluck.\n";
				p.addItem(new Item("GAME_TIME"));
			}else if(p.hasItem("SORA_ART_QUEST_COMPLETE")){
				response = "And finally, balance has been restored to the world as you sit down to finish up your gaming session.\n";
				response += "You guide your character into the final-boss-chamber, ready to rock and roll.\n ";
				response += "But you're not only ready to rock-and-roll, you're also ready to fight the final-boss.\n";
				response += "The boss-entrance-cinematic plays.\n";
				response += "When the cinematic finishes, you whip out your KEYblade and in just 2 short minutes..... You've managed to die and restart 4 times.\n";
				response += "You feel like you're at a loss - like you're about to give up. You think for a momment... \n";
				response += "Inspiration strikes you. Hard.\n";
				response += "You rub the back of your head. It hurts when a good idea hits you for the very first time.\n";
				response += "You know what you need to do... You need an item... A 'Lucky charm' so to speak...\n";
				response += "You set your controller down, vowing that you will come back after you have found what you need.\n";
				p.addItem(new Item("KEY_QUEST"));
			}else if(p.hasItem("SORA_ART")){
				response = "Shouldn't you be trying to give that poster to your SISTER now?\n";
			}else if (p.hasItem("HUNGRY")){
				response = "Hey, killing Zemmy isn't important right now, go find some good eats. Your belly is your god.\n";
			}else if(p.hasItem("ART_QUEST")){
				response = "You really really need to take care of your sister. Without killing her doe.\n";
			}else if (p.hasItem("NOT_HUNGRY")){
				response = "You plop down in front of the TV, ready to settle into the second half of your 8 hour session.\n";
				response += "Your SISTER is standing in front of you now, blocking the TV.\n";
				response += "Wut?\n";
				response += "'Get out of my way' you say, very very cooly.\n";
				response += "'You ate my sandwich.' she replies, also in a very cool tone.\n";
				response += "'Well, looks like you're gonna have ta make another, aren't you?' You respond, getting almost ice-cold now.\n";
				response += "She doesn't move. \n";
				response += "YOU BOTH ARE SO FREAKING COOL RIGHT NOW.\n";
				response += "There's no way you can play like this. You're gonna have to find something to make her happy.\n";
				response += "Or at least not mad.\n";
				response += "Or at least not standing in front of the TV.\n";
				p.addItem(new Item("ART_QUEST"));
			}else if(p.hasItem("QUEST_BINDER")){
				response = "You sit down for a well-earned session of 'Domain of Feelings 2.\n";
				response += "This is probably your favorite iteration of the game, but you're positive that \n";
				response += " Domain of Feelings 3 is going to be much much better.\n";
				//p.removeItem("QUEST_BINDER");
				response += "You feel a wave of hunger overcome you as you fight the last boss.\n";
				response += "You can't possibly think about playing while you're THIS hungry. It just won't do. \n";
				response += "You decide Zemas can wait while you find some gr00b.\n";
				p.addItem(new Item("HUNGRY"));
			}else{
				response = "You just don't feel like playing 'your' PLAYSTATION right now... You feel like there are more important things to do right now.\n";
			}
		}else if(n.equalsIgnoreCase("SISTER")){
			if(p.hasItem("SORA_ART_QUEST_COMPLETE")){
				response = "Oooook, that's enough messing with your sister for one day.\n";
			}else if(p.hasItem("SORA_ART")){
				//Tears up gift and leaves, good thing you have 10 more. 
				response = "You hand her your precious artifact - who could turn down such a generous gift?\n";
				response += "Your SISTER looks at it in disgust.\n";
				response += "She grabs two corners and carefully tears it down the middle.\n";
				response += "You're beside yourself, tears rush to your eyes as you watch your hunkster torn in twain \n";
				response += "You collapse into a heap on the floor.\n";
				response += "Your SISTER goes back to her corner - her wrath sated by your tears. \n";
				response += "You finally manage to collect yourself. At least you have 10 more identical copies of that poster.\n";
				p.addItem(new Item("SORA_ART_QUEST_COMPLETE"));
			}else if(p.hasItem("MONEY") && !p.hasItem("CLOTHES_CLEAN")){
				response = "You hold out a wad of cash. Your SISTER raises her eyebrows. \n";
				response += "She seems surprised at the amount. You have no idea how much money you're holding though.\n";
				response += "You tell your SISTER that you'll pay her if she cleans your room. \n";
				response += "Your SISTER grabs the cash, cleans your room, comes back downstairs, goes back to doing sister-things.\n";
				p.addItem(new Item("CLOTHES_CLEAN"));
			}else if(!p.hasItem("MONEY")){
				response = "Your SISTER snorts, 'Do you actually think I'm gonna clean YOUR room?'.\n";
				response += "You open your mouth to respond with a witty one-liner, but she has already gone back to doing sister-things.\n";
			}else{
				response = "Your SISTER stares blankly at you as you attempt to use her. \n";
				response += "What are you trying to do again?\n";
			}
		}else if(n.equalsIgnoreCase("ENTRY")){
			if(p.hasItem("CLOTHES_CLEAN")){
				response = "You gently saunter into the kitchen through the ENTRY\n";
				response += "If you were a guy, this would be mildly gay.\n";
				response += "Are you a guy?\n";
				response += p.travelEast();
			}else{
				response = "Your mom blocks your way.\n";
				response += "She curtly informs you that you will need to clean your room first.\n";
				response += "You find the nearest corner and pout for a good 15 minutes before doing something.\n";
			}
		}else if(n.equalsIgnoreCase("BINDER")){
			if(super.p.hasItem("QUEST_BINDER")){
				response = "Your BINDER is a high enough level already, stahp.\n";
			}else if(super.p.hasItem("BINDER")){
				response = "You use your BINDER. It's still ineffective. Just go to where you belong. *hint hint*.\n";
			}else{
				response = "Why are you trying to use something you don't have?\n";
			}
		}else if(n.equalsIgnoreCase("STAIRS")){
			response = "You go up the stairs. Woo.\n";
			response += p.travelWest();
		}
		return response;
	}
	
	private boolean isNextMove(String move){
		String[] moveList = {"UP", "UP", "DOWN", "DOWN", "LEFT", "DOWN", "LEFT", "UP", "RIGHT"};
		boolean flag = false; 
		if(move.equalsIgnoreCase(moveList[moveNumber])){
			flag = true; 
			moveNumber++;
		}else{
			flag = false;
			moveNumber = 0; 
		}
		return flag;
	}
}
