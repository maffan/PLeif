package Views;

import javax.swing.*;

import Models.Player;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marcus on 2/4/2015.
 * class wit methods to show which items that are equipped
 */
public class EquippedPanel extends JPanel implements Observer {
    
	/**
	 * Sets up equippedpanel
	 */
	public EquippedPanel(){
        add(new JLabel("Equipped"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    /** 
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     * paints player with equipment if equipped
     */
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

	/** (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * calls the repaint method
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}