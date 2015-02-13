
public class NeverCastle extends Room {

	private boolean gameBeat = false;
	
	public NeverCastle(){
		super.roomDescription = "So I'm not going to get into gorey details here, \n";
		super.roomDescription += "But basically, Big Mick and gang take you across dimensions, blah blah blah,\n";
		super.roomDescription += "Eventually, when you wake up you find yourself standing in front of a floating castle with Big Mick and his gan - OH MY GOSH!!!\n";
		super.roomDescription += "IS THAT A GIANT FREAKING HEART-SHAPED MOON IN THE SKY?!?!\n";
		super.roomDescription += "*sigh*, some game designers have zero taste. Anyway.\n";
		super.roomDescription += "Since you're well enough to stand on your own feet, Big Mick leads you into the castle, through grey-winding hallways, through grey empty rooms.\n";
		super.roomDescription += "After a great deal of walking, you get really tired. I don't think you're ready for this fight.\n";
		super.roomDescription += "Finally, you're standing in front of really big double-doors. This is obviously the boss-room. \n";
		super.roomDescription += "Big Mick turns to you and says 'Aight sun, you know the deal. Go in there and shake a homie. Don't even think about coming out until the job is done.\n";
		super.roomDescription += "The dog and duck lift their heads up in unison once again. You assume it was in agreement or whatever. \n";
		super.roomDescription += "\nYou sigh before timidly opening the door and slipping inside.\n";
		super.roomDescription += "You are standing in a Hall the seems to be lacking Melodies.\n";
		super.roomDescription += "Before you is some big, metaly dude sitting on a giant grey throney thing.\n";
		super.roomDescription += "'GREETINGS' the throne-dude's voice booms out across the hall.\n";
		super.roomDescription += "'MY NAME IS XIG-' You don't wait for him to finish. His name starts with an X, you know you can't let him make the first move.\n";
		super.roomDescription += "*Ahem* try your KEYBLADE";
	}
	
	public String look(String n){
		if(gameBeat == false){
			return "Seriously, just USE your KEYBLADE.\n";
		}else{
			return "GAME OVER";
		}
	}
	public String search(String n, Player player){
		if(gameBeat == false){
			return "Ok, come on, are you seriously looking for something?\n";
		}else{
			return "GAME OVER";
		}
	}
	public String use(String n, Player player){
		String response = "Come on, please just USE the KEYBLADE";
		if( n.equalsIgnoreCase("KEYBLADE") && gameBeat == false){
			response = "You seem to have caught Mr. X-Name by surprise, his eyes widen as you charge at him brandishing your key-blade";
			response += "He starts to laugh as he effortlessly blasts you away with some magic-a** crap.\n";
			response += "You appear to be powerless. This guy must be a level 100-thousand or something. You didn't do enough grinding (Killing trash-monsters over and over until you're a high enough level) before this fight.\n";
			response += "'VERY WELL, I SEE WE'RE ALL FIGHT THEN. I SHALL JUST FINISH YOU OFF.' You close your eyes because you're too much of a pansy to face your demise.\n";
			response += "While your eyes are closed, you hear a brief struggle. Then nothing.\n";
			response += "(This next part is written by Michael Yeaple)\n";
			response += "A SEXY heroic dude (Michael) has saved the day.\n";
			response += "Then he's all like.\n";
			response += "Nat, you deserve to be with Curtis because I'm TOO sexy and heroic for any ONE woman.\n";
			response += "And - with a girl on each arm - he flies off into the night. (End of Michael's material)\n";
			response += "\n You sit there. Dumb-founded.\n";
			response += "You have no idea who this Curtis person is, but he sounds quite fetching. I bet he's a really swell guy too.\n"; 
			response +=	"He's probably very patient and understanding, even if you waited a whole week to play this freaking game.\n";
			response += "You hope to yourself that your name is 'Nat', otherwise this is a huge misunderstanding. \n";
			response += "ANYWAY, you go back through the big double-doors.\n";
			response += "You walk past Big Mick and his gang.\n";
			response += "You walk back through the big grey rooms.\n";
			response += "You back through the winding halls.\n";
			response += "You leave the floating castle and find your way back to the Town Square, back to the Bedroom, back to bed.\n";
			response += "Goodnight...... :) \n"; 
			gameBeat = true; 
		}else{
			return "GAME OVER";
		}
		return response;
	}
}
