package Controllers;

import Views.OutputPanel;

/**
 * Created by Marcus on 2/23/2015.
 */
public class OutputController {
    public OutputPanel outputPanel;
    
    public OutputController(){
        
    }

    public OutputController(OutputPanel outputPanel) {
        this.outputPanel = outputPanel;
    }

    public void print(String text) {
        outputPanel.setText(text);
    }

    public void addLine(String text) {
        outputPanel.addLine(text);
    }
}
