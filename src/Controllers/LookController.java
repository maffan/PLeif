package Controllers;

import Models.GameCell;
import Models.Player;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Marcus on 2/23/2015.
 */
public class LookController {
    private HashMap<Point, GameCell> cellMap;
    private OutputController outputController;
    
    public LookController(){
        
    }

    public LookController(HashMap<Point, GameCell> cellMap, OutputController outputController) {
        this.cellMap = cellMap;
        this.outputController = outputController;
    }
    
    public void look(Point point){
        outputController.print(cellMap.get(point).getDescription());
    }

    public void look(String command, Player player) {
        if(command.equals("north")){
            look(new Point(player.getX(),player.getY()-1));
        }
        else if(command.equals("east")){
            look(new Point(player.getX()+1,player.getY()));
        }
        else if(command.equals("south")){
            look(new Point(player.getX(),player.getY()+1));
        }
        else if(command.equals("west")){
            look(new Point(player.getX()-1,player.getY()));
        }
    }
}
