package Views;

import javax.swing.*;

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
    /**
     * Initiates statsinfopanel
     */
    public StatsInfoPanel(){
        add(new JLabel("StatsInfo"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	

		Stats stats = BoardPanel.getPlayer().getStats();
		Player player = BoardPanel.getPlayer();
		
		int armourDefense = player.armour == null ? 0 : player.armour.getStats().getEndurance();
		String defense = armourDefense == 0 ? stats.getEndurance() +"" : stats.getEndurance() + "+" + armourDefense;
		int armourHealth = player.armour == null ? 0 : player.armour.getStats().getHealth();
		String health = armourHealth == 0 ? stats.getHealth() +"" : stats.getHealth() + "+" + armourHealth;

		int weaponDamage = player.weapon == null ? 0 : player.weapon.getStats().getDamage();
		String damage = weaponDamage == 0 ? stats.getDamage() +"" : stats.getDamage() + "+" + weaponDamage;
		double weaponLuck = player.weapon == null ? 0 : player.weapon.getStats().getLuck();
		String luck = weaponLuck == 0 ? (int)(stats.getLuck()*100) +"" : (int)(stats.getLuck()*100) + "+" + (int)(weaponLuck*100);

		int offset = 35;
		g.drawString("Max Health: " + health, 20, offset); offset += 14;
		g.drawString("Defense: " + defense, 20, offset); offset += 14;
		g.drawString("Damage: " + damage, 20, offset); offset += 14;
		g.drawString("Luck: " + luck + "%", 20, offset); offset += 14;
		g.drawString("Space: " + stats.getWeight(), 20, offset);
	}

	@Override
	public void update(Observable arg0, Object arg1){
		repaint();
	}
}
