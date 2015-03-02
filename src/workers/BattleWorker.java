package Workers;

import Controllers.OutputController;
import Models.Enemy;
import Models.Player;
import Models.Stats;
import Models.WorldData;
import Utils.Attack;
import Utils.BoardPanelProvider;
import Views.BoardPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/27/2015.
 */
public class BattleWorker extends SwingWorker<Boolean,Void> {
    private Player player;
    private Enemy enemy;
    private OutputController outputController;
    private WorldData worldData;

    public BattleWorker() {
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        return doBattle();
    }



    public BattleWorker(Player player, Enemy enemy, OutputController outputController, WorldData worldData) {
        this.player = player;
        this.enemy = enemy;
        this.outputController = outputController;
        this.worldData = worldData;
    }
    
    public Boolean doBattle(){
        Stats playerStats = player.getStats();
        Stats enemyStats = enemy.getStats();
        
        outputController.print("Striden startar!");
        while(playerStats.getHealth() > 0){
            outputController.addLine("Leif attackerar sin motståndare och gör " + Attack.doAttack(player, enemy) + " enheter skada");
            if(enemyStats.getHealth() <= 0){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputController.addLine("Monstret dör en hemsk och smärtsam död");
                worldData.removeEnemy(enemy);
                BoardPanelProvider.getBoardPanel().revalidate();
                BoardPanelProvider.getBoardPanel().repaint();
                worldData.removeAes(new Point(enemy.getX(),enemy.getY()));
                return true;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            outputController.addLine("Fienden ger igen och gör " + Attack.doAttack(enemy, player) + " enheter skada");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
