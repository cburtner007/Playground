
public class Bedroom extends Room {
	
	public Bedroom() {
		super.westRoom = null;
		super.eastRoom = null;
		
		super.roomDescription = "You wake up from a stupor on a cold marbel floor.\n";
		super.roomDescription += "You feel groggy and you're not entirely sure where you are.\n";
		super.roomDescription += "You get the feeling you're in a bedroom as you climb onto your feet.\n";
		super.roomDescription += "There's a BED up against the western wall, so you feel like you're right about that one. Nice job.\n";
		super.roomDescription += "Why didn't you sleep on the bed? The probably would've been smarter.\n";
		super.roomDescription += "You look around the room some more, you notice an empty CHAIR against the north wall\n";
		super.roomDescription += "and a gay-a** heart-shaped MIRROR in the south-eastern corner. Seriously, how disgusting.\n";
		super.roomDescription += "Oh yeah, and there's no door.\n";
		
		super.briefDescription = "There's a BED against the west wall, \n";
		super.briefDescription += "CHAIR against the north wall,\n";
		super.briefDescription += "and a MIRROR in the south-eastern corner.\n ";
		
		super.itemList.add(new Item("BED"));
		super.itemList.add(new Item("CHAIR"));
		super.itemList.add(new Item("MIRROR"));
		super.itemList.add(new Item("KEY"));
		
		super.previousC = "NONE";
	}
	
	public String look(String n){
		
		String response = "What the heck are you trying to do?";
		
		if(n.equalsIgnoreCase("BED")){
			response = "It's a BED. Exhilerating.... Oh, but you notice a gleam - as if someone has hidden something of value under the pillow. What an idiot.\n";

		}else if(n.equalsIgnoreCase("CHAIR")){
			if(this.itemUses(n) == 0){
				response = "You look over the CHAIR... It's empty. How odd. \n";
			}else if(this.itemUses(n) > 0){
				response = "Yeah, still empty. That's still weird. \n";
			}
		}else if(n.equalsIgnoreCase("MIRROR")){
			
			if(this.itemUses(n) == 0){
				response = "You gaze into the MIRROR... After admiring yourself for a few moments (vain much?) you notice a cat on the CHAIR behind you in the MIRROR. It's gazing at you intently.\n";
			}else if(this.itemUses(n) == 1){
				response = "You look into the MIRROR again. The cat has moved closer so that it's standing in front of you in the MIRROR. You're no expert on cats, but it's definitely pink with purple stripes. Or is it purple with pink stripes? At any rate, it has a goofy grin on its face. Makes you wanna punch something.\n ";
				response += "You quickly look down in front of you. No cat. You look back into the MIRROR. You now see the cat standing on its head in the most preposterous of manners.\n";
				response += "You feel as if you're being invited to the other side of this mirror.\n";
				
			}else if(this.itemUses(n) > 1){
				response = "You look at yourself again. You think 'Dang, I should marry myself' before deciding to attempt to get to the other side of this MIRROR\n";
			}
			
		}else if(n.equalsIgnoreCase("KEY")){			
			response = "Nice try. But you're going to have to search for this bad-boy.";
			
		}else if(n.equalsIgnoreCase("ROOM")){
			response = super.briefDescription; 
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
		
		if(this.hasItem(n)){
			this.incItem(n);
		}
		
		return response;
	}

	public String search(String n, Player p){
		
		String response = "What the heck are you talking about?";
		Item temp;
		
		if(n.equalsIgnoreCase("BED")){
			if(this.hasItem("KEY")){
				response = "You search the BED, you find a shiney KEY! But the handle is unfortunately in the shape of a gay-a** heart. Oh well. You stuff it in your pocket - hoping that no one notices you have a 'thing' for keys.\n";
				temp = this.removeItem("KEY");
				p.addItem(temp);
			}else{
				response = "You search the BED and find nothing of value. Except for a comic book featuring anime characters you know all too well. You leave it where it is.\n";
			}
		}else if(n.equalsIgnoreCase("CHAIR")){
			response = this.look(n);
		}else if(n.equalsIgnoreCase("MIRROR")){
			response = this.look(n);
		}else if(n.equalsIgnoreCase("KEY")){
			if(p.hasItem("KEY")){
				response = "Uhhh... You search the... KEY? I guess you don't really find anything of value.\n";
			}else{
				response = "What KEY?\n";
			}
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
		return response;
	}
	
	public String use(String n, Player p){
		
		String response = "What the heck are you talking about?";
		
		if(n.equalsIgnoreCase("BED")){
			response = "You use the BED. You feel like you've wasted time. But at least you're well-rested.\n";
		}else if(n.equalsIgnoreCase("CHAIR")){
			response = "You sit down in the CHAIR and cross your legs like a pretentious little good girl.\n";
		}else if(n.equalsIgnoreCase("MIRROR")){
			if(p.hasItem("KEY")){
				response = "As you go to press your hands against the MIRROR, your hands unexpectedly pass through the surface. You stumble through.\n";
				response += " The cat bounds away as you hear the MIRROR shatter behind you. You see the cat going through a door in the eastern wall. You follow it.\n";
				response += " The door fades out of existence behind you as you step through it. There's no going back. The cat is nowhere to be found. \n";
				response += "\n" + p.travelEast();
			}else if(!p.hasItem("KEY")){
				response = "You press your hands against the cold surface of the MIRROR. Nothing happens, except for you leaving your hand-prints behind. You feel like you're missing a KEY item.\n";
			}
		}else if(n.equalsIgnoreCase("KEY")){
			if(p.hasItem("KEY")){
				response = "Erm... I guess you swing the KEY through the air as if it were an edged weapon. Like a blade. This accomplishes nothing, and you feel quite silly - as the key is very small and very unlike a weapon of any kind.\n";
			}else{
				response = "What KEY?\n";
			}		
		}else{
			response = "Whoops, it seems that thing doesn't exist.\n";
		}
		return response;
	}
}