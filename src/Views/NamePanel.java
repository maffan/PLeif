package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class NamePanel extends JPanel {
    public NamePanel(){
        add(new JLabel("Name and Level"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
