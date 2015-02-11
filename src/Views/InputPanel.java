package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class InputPanel extends JPanel {
    private JTextField inputField;
    private JButton submitButton;
    public InputPanel(){
        inputField = new JTextField(30);
        submitButton = new JButton("Submit");
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new GridBagLayout());
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
}
