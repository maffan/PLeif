package Views;

import Utils.OutputPanelProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Marcus on 2/4/2015.
 * status panel class creates input and output -panel objects
 */
public class StatusPanel extends JPanel{
    private InputPanel inputPanel;
    private OutputPanel outputPanel;

    /**
     * Initiates statuspanel
     */
    public StatusPanel(){
        setPreferredSize(new Dimension(500,100));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());
        makePanels();
    }

    /**
     * Creates statuspanel panels
     */
    private void makePanels() {
        outputPanel = new OutputPanel();
        OutputPanelProvider.setOutPutPanel(outputPanel);
        inputPanel = new InputPanel();
        add(outputPanel, BorderLayout.CENTER);
        add(inputPanel,BorderLayout.SOUTH);
    }


    /**
     * @return current inputpanel
     */
    public InputPanel getInputPanel() {
        return inputPanel;
    }
    
    /**
     * @return current outputpanel
     */
    public OutputPanel getOutputPanel() { 
        return outputPanel; 
    }

    /**
     * @param listener set actionlistener for statuspanel
     */
    public void addInputListener(ActionListener listener) {
        inputPanel.addSubmitController(listener);
    }
}
