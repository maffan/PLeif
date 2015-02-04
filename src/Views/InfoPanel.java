package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class InfoPanel extends JPanel{
    private NamePanel namePanel;
    private PortraitPanel portraitPanel;
    private StatsInfoPanel statsInfoPanel;
    private EquippedPanel equippedPanel;
    private InventoryPanel inventoryPanel;

    public InfoPanel(){
        add(new JLabel("Info"));
        setPreferredSize(new Dimension(200,500));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
