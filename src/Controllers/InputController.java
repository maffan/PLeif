package Controllers;

import Utils.InputParser;
import Views.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marcus on 2/4/2015.
 */
public class InputController implements ActionListener {
    private StatusPanel statusPanel;
    private InputParser parser;

    public InputController() {
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    public void setStatusPanel(StatusPanel statusPanel) {
        this.statusPanel = statusPanel;
    }

    public InputParser getParser() {
        return parser;
    }

    public void setParser(InputParser parser) {
        this.parser = parser;
    }

    public InputController(StatusPanel statusPanel, InputParser parser) {

        this.statusPanel = statusPanel;
        this.parser = parser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
