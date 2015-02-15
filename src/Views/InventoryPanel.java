package Views;

import Models.Item;
import Models.Player;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class InventoryPanel extends JPanel implements Observer
{
    public InventoryPanel(){
        add(new JLabel("Inventory"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		Player player = BoardPanel.getPlayer();
		
		int offset = 40;
		g.drawString("You got:", 20, 40);
		for(Item e: player.getItems())
		{
			offset += 15;
			g.drawString(e.getName(), 20, offset);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}