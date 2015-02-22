package Controllers;

import Models.Aesthetics;
import Models.Entity;
import Models.Player;
import Models.WorldData;
import Utils.InputParser;
import Views.BoardPanel;
import Views.InputPanel;
import Views.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Marcus on 2/4/2015.
 */
public class InputController implements ActionListener {
	private InputPanel inputPanel;
	private BoardPanel boardPanel;
	private Player player;

	private static final int gridSize = 50;
	private static final int width = 500;
	private static final int height = 500;

	public InputController() {

	}

	public InputController(InputPanel inputPanel, Player player, BoardPanel boardPanel) {
		this.inputPanel = inputPanel;
		this.player = player;
		this.boardPanel = boardPanel;
	}

	public InputController(StatusPanel statusPanel, BoardPanel boardPanel) {
		this.inputPanel = statusPanel.getInputPanel();
		this.boardPanel = boardPanel;
		this.player = boardPanel.getPlayer();
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
		//This way of checking command does not look nice

		commandAction(command);
	}

	public void commandAction(String action)
	{
		String[] command = action.split(" ");
		
		if(command[0].equals("move"))
		{
			BoardPanel.world.player.move(command[1], height / gridSize);
		}
		else if(command[0].equals("look")){
			
			if (command[1].equals("north") || command[1].equals("n")) {
				lookNorth();

			} else if (command[1].equals("east") || command[1].equals("e")) {
				lookEast();

			} else if (command[1].equals("south") || command[1].equals("s")) {
				lookSouth();

			} else if (command[1].equals("west") || command[1].equals("w")) {
				lookWest();

			} else {
				System.out.println("Invalid command");
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