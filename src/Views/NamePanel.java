package Views;

import javax.swing.*;

import Models.Player;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marcus on 2/4/2015.
 */

public class NamePanel extends JPanel implements Observer
{
    /**
     * Initiates namepanel 
     */
    public NamePanel(){
        add(new JLabel("Name and Level"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    int test = 0;
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Player player = BoardPanel.getPlayer();

		g.setColor(Color.black);
		g.drawString(player.getName(), 20, 40);
		g.drawString("@ lvl " + player.getLevel(), 20, 55);
		g.drawString("with " + player.getHealth() + " health ", 20, 70);
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		repaint();
	}
}