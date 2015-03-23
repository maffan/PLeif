package Views;

import javax.swing.*;

import Utils.GamePaths;

import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 * class for portrait panel for PC 
 */
public class PortraitPanel extends JPanel {
    /**
     * Initiates portraitpanel
     */
    public PortraitPanel(){
        add(new JLabel("Portrait"));
        add(new JLabel(new ImageIcon(GamePaths.Portrait)));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


}
