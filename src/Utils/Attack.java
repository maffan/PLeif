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
        Stats attackerStats = player.getStats();
        Stats defenderStats = enemy.getStats();
        
        defenderStats.setHealth(defenderStats.getHealth()-attackerStats.getDamage());
        
        return attackerStats.getDamage();
    }
    public static int doAttack(Enemy enemy,Player player){
        Stats attackerStats = enemy.getStats();
        Stats defenderStats = player.getStats();
        double random = new Random().nextDouble();
        int damage = attackerStats.getDamage();
        if(random < defenderStats.getLuck()){
            damage -= defenderStats.getEndurance()*random;
        }
        defenderStats.setHealth(defenderStats.getHealth()- damage);

        return damage;
    }
}
