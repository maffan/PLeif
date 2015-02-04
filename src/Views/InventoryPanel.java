package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class InventoryPanel extends JPanel {
    public InventoryPanel(){
        add(new JLabel("Inventory"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
