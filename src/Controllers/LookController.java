package Controllers;

import Models.Player;
import Views.BoardPanel;

import java.awt.*;

/**
 * Handles look command
 * Created by Marcus on 2/23/2015.
 */
public class LookController {
    private OutputController outputController;
    
    /**
     * Sets outputcontroller
     * @param outputController the outputcontroller to be set
     */
    public LookController(OutputController outputController) {
        this.outputController = outputController;
    }
    
    /**
     * Fetches information about the current location
     * @param point current point
     */
    public void look(Point point){
    	outputController.print(BoardPanel.world.getDescription(point));
    }

    /**
     * Fetch information about a tile in another direction
     * @param command input direction
     * @param player current player
     */
    public void look(String command, Player player) {
        if(command.equals("north") || command.equals("n")){
            look(new Point(player.getX(),player.getY()-1));
        }
        else if(command.equals("east") || command.equals("e")){
            look(new Point(player.getX()+1,player.getY()));
        }
        else if(command.equals("south") || command.equals("s")){
            look(new Point(player.getX(),player.getY()+1));
        }
        else if(command.equals("west") || command.equals("w")){
            look(new Point(player.getX()-1,player.getY()));
        }
        else if(command.equals("self")){
        	look(new Point(player.getX(),player.getY()));
       }
        else if(command.equals("look")){
        	look(new Point(player.getX(),player.getY()));
       }
    }
}
