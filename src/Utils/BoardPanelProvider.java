package Utils;

import Views.BoardPanel;

/**
 * Created by Marcus on 2/27/2015.
 */
public class BoardPanelProvider {
    private static BoardPanel boardPanel;
    
    public static void setBoardPanel(BoardPanel panel){
        boardPanel = panel;
    }
    
    public static BoardPanel getBoardPanel(){
        return boardPanel;
    }
}
