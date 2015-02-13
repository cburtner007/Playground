
public class HBastion extends Room {

	public HBastion(){
		super.roomDescription = "You step off the rock. In front of you is a big, empty castle... Almost like it's hollow on the inside, like a... Like a hollow bastion. \n";
		super.roomDescription += "There also happens to be an unfortunately sized hole in the side of this castle.\n";
		super.roomDescription += "This hole seems to open up to a very large cathedral.\n";
		super.roomDescription += "This cathedral seems like it would be a truly epic thing to explore. But the hole is roped off.\n";
		super.roomDescription += "There seems to be a very worried looking MAN pacing in front of this hole in the wall.\n";
		super.roomDescription += "There's also the WATERFALL where you came from. You can probably go back by using it.\n";
		super.roomDescription += "Seriously. There's not much else to explore. Go talk to this dude (USE MAN)\n";
		
		super.briefDescription = "There really really isn't much to do here, except talk to the MAN (USE MAN)\n";
		super.briefDescription += "Oh yeah, and there's that WATERFALL you came from. You can probably jump from rock to rock to get down.\n";
		
		super.itemList.add(new Item("MAN"));
		
	}
	
	public String use(String n, Player p){
		
		String response = "What the heck are you talking about?";
		Item temp;
		if(n.equalsIgnoreCase("WATERFALL")){
			response = "You (kind of) gracefully hop from rock to rock. It's like going the wrong way on an escalator, but it gets the job done. You descend and go back to the town square.\n";
			response += "\n" + p.travelWest();
		}else if(n.equalsIgnoreCase("MAN")){
			if(p.hasItem("WATERBUCKET")){
				response = "You give the MAN a sip of water from your WATERBUCKET. He looks relieved enough to have a conversation. W00t.\n";
				response += "\n The MAN claps his hands together'Ah! Thank you lass, I've been practically dying of thirst trying to figure out this problem I'm having.'\n";
				response += "The MAN continues his monologue, 'My name is Ansel, and I am very wise. Unfortunately, during my last experiment, I blew a hole in this wall here.' \n";
				response += "You don't think that for someone so apparently wise, this was a very unwise thing to do, but you keep your mouth shut because you know what's good for you.\n";
				response += "Ansel speaks again, 'I have all the materials I need to fix it, now all I need is a really long chain.'\n";
				response += "He says, in a comforting manner, 'Fear not, you are not required to go find this chain. My problem is this: '\n";
				response += "\n'I have 7 small chains, and each chain has 5 links (The chains look kind of like this OOOOO).\n";
				response += "'I can take these chains to Big Mick who can open and close chain links to make one long chain - but I'm afraid he'll do it in the most expensive way possible.\n";
				response += "'If it will cost me $2 to open and close a link, what's the cheapest I can connect these chains for in order to make 1 long chain?'\n";
				response += "\n In order to answer this riddle. Simply type 'USE $X' where X is an integer number. The wise guy will tell you if you're right or wrong.\n";
			}else if(p.hasItem("BUCKET")){
				response = "The MAN gets excited as he sees you pull out your BUCKET. He looks inside and appears to be disappointed. He seemed like he was really REALLY hoping to find a liquid of some kind inside of it.\n";
			}else{
				response = "The MAN attempts to speak, but his voice sounds so dry that it cracks and you can't understand him at all. Oh well. Guess there's nothing else you can do now.\n";
			}
				
		}else if(n.startsWith("$")){
			if(n.equalsIgnoreCase("$12")){
				response = "Ansel sighs, 'Could you have picked a more obvious answer? Of course that's wrong.' you feel slightly embarrassed\n";
			}else if(n.equalsIgnoreCase("$10")){
				response = "Ansel's eyes gets wide, he seems excited, 'THAT'S IT! You're right! Thank you!'\n";
				response += "'Now for your reward... Do you have any items you'd like me to enchant?' He holds out his hand, waiting for you to place an item in it.\n";
				response += "You eagerly push your tiny little key into his hands. You give him a puppy-dog look.\n";
				response += "Ansel looks at you skeptically. 'I guess I can do something with this...'\n";
				response += "The MAN mutters an incantation and your tiny key poofs into a big-a** KEYBLADE. You can likely use it as a weapon to shank somebody.\n";
				response += "'Wait a second! I have an oath I want you to keep!' but before Ansel can say anything else, you leave him standing in front of that giant hole in the wall.\n";
				response += "You decide to name your KEYBLADE 'Promise Keeper'. You don't know why, you just think it sounds cool.\n";
				response += "\n You should go back down the WATERFALL. Big Mick will want to talk to you now. You got people to shank.\n";
				response += "HINT: USE KEYBLADE when you go back to town.\n";
				
				temp = new Item("KEYBLADE");
				p.addItem(temp);
			}else{
				response = "Ansel shakes his head 'No... No that's not it...'\n";
			}
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
		return response;
	}
}
