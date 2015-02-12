package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Marcus on 2/4/2015.
 */
public class InputPanel extends JPanel {
    private JTextField inputField;
    private JButton submitButton;
    public InputPanel(){
        init();
    }
    public InputPanel(ActionListener listener){
        init();
        addSubmitController(listener);
    }

    private void init() {
        initFields();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new GridBagLayout());
        makePanel();
    }

    private void makePanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(inputField,constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(submitButton,constraints);
    }

    private void initFields() {
        inputField = new JTextField(30);
        submitButton = new JButton("Submit");
    }

    public void addSubmitController(ActionListener listener){
        submitButton.addActionListener(listener);
        inputField.addActionListener(listener);
    }

    public String getCommand() {
        String input = inputField.getText();
        inputField.setText("");
        return input;
    }
}
