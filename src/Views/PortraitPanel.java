package Views;

import javax.swing.*;

import Utils.GamePaths;

import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class PortraitPanel extends JPanel {
    public PortraitPanel(){
        add(new JLabel("Portrait"));
        add(new JLabel(new ImageIcon(GamePaths.Portrait)));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


}
