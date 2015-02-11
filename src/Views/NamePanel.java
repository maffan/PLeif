package Views;

import javax.swing.*;

import Models.Entity;
import Models.Player;

import java.awt.*;

/**
 * Created by Marcus on 2/4/2015.
 */
public class NamePanel extends JPanel {
    public NamePanel(){
        add(new JLabel("Name and Level"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		//Player player = BoardPanel.getPlayer();

		g.setColor(Color.black);
		//g.drawString(player.getPlayerName() + "     LVL: G�teborgare", 20, 40);
		//g.drawString("At position X: " + player.getX() + " Y: " + player.getY(), 20, 55);
	}
}