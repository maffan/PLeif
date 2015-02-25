package Controllers;

import Models.*;
import Utils.InputParser;
import Views.BoardPanel;
import Views.InputPanel;
import Views.StatusPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


/**
 * Created by Marcus on 2/4/2015.
 */
public class InputController implements ActionListener {
	private InputPanel inputPanel;
	private BoardPanel boardPanel;
	private Player player;
    
    private MoveController moveController;
    private LookController lookController;

	private static final int gridSize = 50;
	private static final int width = 500;
	private static final int height = 500;

	public InputController() {

	}

	public InputController(StatusPanel statusPanel, BoardPanel boardPanel) {
		this.inputPanel = statusPanel.getInputPanel();
		this.boardPanel = boardPanel;
		this.player = boardPanel.getPlayer();
        this.moveController = new MoveController(boardPanel);
        this.lookController = new LookController(new OutputController(statusPanel.getOutputPanel()));
	}

    public void setInputPanel(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

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
		
		//move
		if(command[0].equals("move") || command[0].equals("m"))
		{
			moveController.movePlayer(command[1], height / gridSize);
		}
		//riktning direkt
		else if(command[0].equals("north") || command[0].equals("west") || command[0].equals("east") || command[0].equals("south")
                || command[0].equals("n") || command[0].equals("e") || command[0].equals("s") || command[0].equals("w")){
            moveController.movePlayer(command[0], height / gridSize);
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
	}
	
	private void lookEast(){
		//beskrivning om vad som finns d�r
	}

	private void lookNorth(){
		//beskrivning om vad som finns d�r
	}

	private void lookSouth(){
		//beskrivning om vad som finns d�r
	}

	private void lookWest(){
		//beskrivning om vad som finns d�r
	}
}