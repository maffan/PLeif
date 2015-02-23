package Controllers;

import Views.BoardPanel;

/**
 * Created by Marcus on 2/23/2015.
 */
public class MoveController {
    private BoardPanel boardPanel;
    public MoveController(){
    }
    public MoveController(BoardPanel boardPanel){
        this.boardPanel = boardPanel;
    }
    public void movePlayer(String direction,int max){
        BoardPanel.world.player.move(direction,max);
    }
}
