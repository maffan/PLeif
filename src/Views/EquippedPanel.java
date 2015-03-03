package Views;

import javax.swing.*;

import Models.Player;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marcus on 2/4/2015.
 */
public class EquippedPanel extends JPanel implements Observer {
    public EquippedPanel(){
        add(new JLabel("Equipped"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		Player player = BoardPanel.getPlayer();
		
		int offset = 35;
		if(player.armour != null)
		{
			g.drawString(player.armour.getName(), 20, offset);
		}
		
		offset += 15;
		if(player.weapon != null)
		{
			g.drawString(player.weapon.getName(), 20, offset);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}