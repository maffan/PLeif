package Views;

import Models.Player;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * @author Tobias 
 *  class for the inventory panel
 */
public class InventoryPanel extends JPanel implements Observer
{
    /**
     * Initiates inventorypanel
     */
    public InventoryPanel(){
        add(new JLabel("Inventory"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    /**
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     * paints item names in the inventory panel 
     */
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		Player player = BoardPanel.getPlayer();
		
		int offset = 20;
		for(int i = 0; i < player.getItems().size(); i++)
		{
			offset += 15;
			g.drawString((i+1) + ": " + player.getItems().get(i).getName(), 20, offset);
		}
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * calls the repaint method
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}