package Utils;

import Controllers.*;

public class Help {
	
	static OutputController OC = new OutputController();
	
	public static void help(){
		OC.print("Available commands: move, look, attack, pickup, equip, unequip, chat, reset, save, load, exit, volume, help\n"
				+ "type \"help [command]\" for more information about the selcted command");
	}
	
	public static void help(String command){
		switch(command){
		case "move":	OC.print("\"move [Direction]\" to move in the entered direction if nothing is blocking\n"
							+ "Alternativley \"m [Direction]\" or \"[Direction]\", the first letter of Direction can be used instead of the complete word");
						break;
		case "look":	OC.print("\"look [Direction]\" to get information about the selected tile\n"
							+ "Alternatively \"l [Direction]\", the first letter of Direction can be used instead of the complete word ");
						break;
		case "attack":	OC.print("\"attack [Direction]\" to attack in the selected direction\n"
							+ "Alternatively \"a [Direction]\", the first letter of Direction can be used instead of the complete word");
						break;
		case "chat":	OC.print("\"chat [name]\" to enter the chat with the selected name\n"
							+ "Alternatively \"chat\" to enter the chat with a default name");
						break;
		case "reset":	OC.print("Restarts the game\n"
							+ "Alternatively \"new\"");
						break;
		case "save":	OC.print("\"save\" to save the current game");
						break;
		case "load":	OC.print("\"load\" to load the latest save");
						break;
		case "pickup":	OC.print("\"pickup\" pickup item on current spot");
						break;
		case "equip":	OC.print("\"equip [#]\" equip # item from you inventory");
						break;
		case "unequip":	OC.print("\"unequip weapon or armour\" unequip your weapon or armour");
						break;
		case "exit":	OC.print("\"exit\" closes the game\n"
							+ "Alternatively \"exit\"");
						break;
		case "help":	help();
						break;
		default:		break;
		}
	}
}
