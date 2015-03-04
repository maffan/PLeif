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
		
		int offset = 20;
		for(int i = 0; i < player.getItems().size(); i++)
		{
			offset += 15;
			g.drawString((i+1) + ": " + player.getItems().get(i).getName(), 20, offset);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
}