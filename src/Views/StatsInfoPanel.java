package Views;

import javax.swing.*;

import Models.Item;
import Models.Player;
import Models.Stats;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Marcus on 2/4/2015.
 */
public class StatsInfoPanel extends JPanel implements Observer
{
    public StatsInfoPanel(){
        add(new JLabel("StatsInfo"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		Stats stats = BoardPanel.getPlayer().getStats();

		int offset = 35;
		g.drawString("Health: " + stats.getHealth(), 20, offset); offset += 14;
		g.drawString("Defense: " + stats.getEndurance(), 20, offset); offset += 14;
		g.drawString("Damage: " + stats.getDamage(), 20, offset); offset += 14;
		g.drawString("Luck: " + (int)(stats.getLuck()*100) + "%", 20, offset); offset += 14;
		g.drawString("Space: " + stats.getWeight(), 20, offset);
	}

	@Override
	public void update(Observable arg0, Object arg1){
		repaint();
	}
}
