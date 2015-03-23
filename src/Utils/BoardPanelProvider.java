package Utils;

import Views.BoardPanel;

/**
 * Created by Marcus on 2/27/2015.
 * class that sets up boardpanel
 */
public class BoardPanelProvider {
    private static BoardPanel boardPanel;
    
    /**
     * @param panel set current boardpanel
     */
    public static void setBoardPanel(BoardPanel panel){
        boardPanel = panel;
    }
    
    /**
     * @return current boardpanel
     */
    public static BoardPanel getBoardPanel(){
        return boardPanel;
    }
}
