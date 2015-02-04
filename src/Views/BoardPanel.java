package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class BoardPanel extends JPanel {
    public BoardPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(new JLabel("Board",SwingConstants.CENTER),BorderLayout.CENTER);
        setPreferredSize(new Dimension(500,500));
    }
}
