package Utils;


import Models.Enemy;
import Models.Player;
import Models.Stats;

import java.util.Random;

/**
 * Created by Marcus on 2/27/2015.
 */
public class Attack {
    public static int doAttack(Player player, Enemy enemy){
    	int attackerStatsDamage = player.getStats().getDamage() + (player.weapon == null ? 0 : player.weapon.getStats().getDamage());
        Stats defenderStats = enemy.getStats();
        
        defenderStats.setHealth(defenderStats.getHealth()-attackerStatsDamage);
        
        return attackerStatsDamage;
    }
    public static int doAttack(Enemy enemy,Player player){
        Stats attackerStats = enemy.getStats();
        Stats defenderStats = player.getStats();
        int defenderStatsEndurance = player.getStats().getEndurance() + (player.armour == null ? 0 : player.armour.getStats().getHealth());
        double defenderStatsLuck = player.getStats().getLuck() + (player.weapon == null ? 0 : player.weapon.getStats().getLuck());
        double random = new Random().nextDouble();
        int damage = attackerStats.getDamage();
        if(random < defenderStatsLuck){
            damage -= defenderStatsEndurance*random;
        }
        defenderStats.setHealth(defenderStats.getHealth()- damage);

        return damage;
    }
}
