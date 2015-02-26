package Controllers;

import Models.*;
import Views.BoardPanel;
import Views.InputPanel;
import Views.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Controller for handling input from the user
 */
public class InputController implements ActionListener {
	private InputPanel inputPanel;
	private BoardPanel boardPanel;
	private Player player;
    
    private MoveController moveController;
    private LookController lookController;

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
        this.moveController = new MoveController(boardPanel);
        this.lookController = new LookController(new OutputController(statusPanel.getOutputPanel()));
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
		
		//move
		if(command[0].equals("move") || command[0].equals("m"))
		{
			moveController.movePlayer(command[1], mapWidth);
		}
		//riktning direkt
		else if(command[0].equals("north") || command[0].equals("west") || command[0].equals("east") || command[0].equals("south")
                || command[0].equals("n") || command[0].equals("e") || command[0].equals("s") || command[0].equals("w")){
            moveController.movePlayer(command[0], mapWidth);
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
}