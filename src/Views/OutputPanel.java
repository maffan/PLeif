package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class OutputPanel extends JPanel {
    public OutputPanel(){
        add(new JLabel("Output"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
