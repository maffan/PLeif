package Views;

import Models.Entity;
import Models.Player;

import java.awt.*;
import javax.swing.*;

public class InventoryPanel extends JPanel {
    public InventoryPanel(){
        add(new JLabel("Inventory"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		//Player player = BoardPanel.getPlayer();
		
		int offset = 40;
		g.drawString("You got: ", 20, 40);
//		for(Entity e: player.getEntities())
//		{
//			offset += 15;
//			g.drawString(e.getSpriteID().toString(), 20, offset);
//		}
	}
}