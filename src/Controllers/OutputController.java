package Controllers;

import Utils.OutputPanelProvider;
import Views.OutputPanel;

/**
 * Created by Marcus on 2/23/2015.
 */
public class OutputController {
    public OutputPanel outputPanel;
    
    /**
     * sets the outputpanel
     */
    public OutputController(){
        this.outputPanel = OutputPanelProvider.getOutputPanel();
    }

    /**
     * @param outputPanel change outputpanel to outputPanel
     */
    public OutputController(OutputPanel outputPanel) {
        this.outputPanel = outputPanel;
    }

    /**
     * @param text clear old text and print new line
     */
    public void print(String text) {
        outputPanel.setText(text);
    }

    /**
     * @param text add a new line with text
     */
    public void addLine(String text) {
        outputPanel.addLine(text);
    }
}
