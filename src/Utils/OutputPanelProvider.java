package Utils;

import Views.OutputPanel;

/**
 * Created by Marcus on 3/3/2015.
 */
public class OutputPanelProvider {
    private static OutputPanel outputPanel;
    
    public static void setOutPutPanel(OutputPanel panel){
        outputPanel = panel;
    }
    
    public static OutputPanel getOutputPanel(){
        return outputPanel;
    }
}
