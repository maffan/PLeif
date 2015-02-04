package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class EquippedPanel extends JPanel {
    public EquippedPanel(){
        add(new JLabel("Equipped"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
