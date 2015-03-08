package Controllers;

import Audio.*;
import Chat.*;
import Models.*;
import Utils.Help;
import Utils.OutputPanelProvider;
import Views.BoardPanel;
import Views.InputPanel;
import Views.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * Controller for handling input from the user
 */
public class InputController implements ActionListener {
	private InputPanel inputPanel;
	private BoardPanel boardPanel;
	private Player player;
    
    private LookController lookController;
    private AttackController attackController;
    
    private OutputController output;

	private static final int mapWidth = 10;

	public InputController() {

	}

    /**
     * Sets up an InputController so that input can be read from the user 
     * @param statusPanel The panel containing the InputPanel
     * @param boardPanel The panel containing the central gaming area
     */
	public InputController(StatusPanel statusPanel, BoardPanel boardPanel) {
		this.inputPanel = statusPanel.getInputPanel();
		this.boardPanel = boardPanel;
		this.player = BoardPanel.getPlayer();
        this.lookController = new LookController(new OutputController(statusPanel.getOutputPanel()));
        this.attackController = new AttackController(new OutputController(statusPanel.getOutputPanel()),BoardPanel.world);
        setAttackController(statusPanel);
        
        this.output = new OutputController(OutputPanelProvider.getOutputPanel());
	}
	
	public void setAttackController(StatusPanel statusPanel){
		this.attackController = new AttackController(new OutputController(statusPanel.getOutputPanel()),BoardPanel.world);
	}
	

    /**
     * Sets the InputPanel this controller is to read from
     * @param inputPanel
     */
    public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

    /**
     * Sets the player being controller by input from this controller
     * @param player
     */
	public void setPlayer(Player player) {
		this.player = player;
	}

    /**
     * Sets the BoardPanel associated with this controller
     * @param boardPanel
     */
	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = inputPanel.getCommand().toLowerCase().trim();
		commandAction(command);
	}

	public void commandAction(String action)
	{
		String[] command = action.split(" ");
		player = BoardPanel.world.player;
		//move
		if(command[0].equals("move") || command[0].equals("m"))
		{
			BoardPanel.world.player.move(command[1], mapWidth);
		}
		//riktning direkt
		else if(command[0].equals("north") || command[0].equals("west") || command[0].equals("east") || command[0].equals("south")
                || command[0].equals("n") || command[0].equals("e") || command[0].equals("s") || command[0].equals("w")){
			BoardPanel.world.player.move(command[0], mapWidth);
            player.minorHeal();
		}
		else if(command[0].equals("look") || command[0].equals("l")){
			if(command.length == 1)
			{
				lookController.look(command[0], player);
			}
			else{
				lookController.look(command[1],player);
			}
		}
        else if(command[0].equals("attack") || command[0].equals("a")){
        	if(command.length == 2)
        		attackController.attack(command[1]);
        }
		else if(command[0].equals("save"))
		{
			boardPanel.save();
		}
		else if(command[0].equals("load"))
		{
			boardPanel.load();
		}
        else if(command[0].equals("exit") || command[0].equals("quit")){
            System.exit(0);
        }
		
        else if (command[0].equals("chat")) {	//creates a chat window and connects
			try {
				if (command.length>1) { 
					new Chat(command[1], "234.235.236.237", 9999);	//with a desired name 
				} else {
					new Chat();	//with a default name if no name was specified
				}
			} catch (IOException e) {}
		}
		
        else if(command[0].equals("help")||command[0].equals("?")){
        	if(command.length>1){
        		Help.help(command[1]);
        	}
        	else{
        		Help.help();
        	}
        }
		
        else if(command[0].equals("playmusic") || command[0].equals("startmusic")) {
        	SoundPlayer.playBg();
        }
        else if(command[0].equals("stopmusic")) {
        	SoundPlayer.stopMusic();
        }
        else if(command[0].equals("pickup"))
		{
			if(player.pickUpItem())
			{
				output.addLine("I found somethin' fancy!");
			}
			else
			{
				output.addLine("Inge p� backen ju!");
			}
		}
        else if(command[0].equals("equip"))
		{
			if(command.length == 2)
				output.addLine(player.equip(command[1]));
		}else if(command[0].equals("unequip"))
		{
			if(command.length == 2)
				output.addLine(player.unequip(command[1]));
		}
		
		else if(command[0].equals("volume")){
			if(command.length == 1){}
			else{
			VolumeControl.changeVolume(Float.parseFloat(command[1]));
			}
			output.addLine("Volume: " +String.valueOf(VolumeControl.getVolume()));
		}
		else if(command[0].equals("supersecretcheatcode"))
		{
			player.setX(9);
			player.setY(8);
		}
		else if(command[0].equals("supersecretcheatcode"))
		{
			player.setX(9);
			player.setY(8);
		}
		else if(command[0].equals("reset"))
		{
			boardPanel.reset();
		}
		else{
			output.addLine("Felaktigt kommando");
		}	
	}
}