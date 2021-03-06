package Workers;

import Audio.SoundPlayer;
import Controllers.OutputController;
import Models.Enemy;
import Models.Player;
import Models.Stats;
import Models.WorldData;
import Utils.BoardPanelProvider;
import Views.BoardPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marcus on 2/27/2015.
 * Battleworker class, a swing worker class
 */
public class BattleWorker extends SwingWorker<Boolean,Void> {
    private Player player;
    private Enemy enemy;
    private OutputController outputController;
    private WorldData worldData;
    private int playerXPos;
    private int playerYPos;

    /** 
     * @see javax.swing.SwingWorker#doInBackground()
     * lets battles be done in a background thread
     */
    @Override
    protected Boolean doInBackground() throws Exception {
        return doBattle();
    }
/**
 * Handles combat data
 * @param player
 * @param enemy
 * @param outputController
 * @param worldData
 */
    public BattleWorker(Player player, Enemy enemy, OutputController outputController, WorldData worldData) {
        this.player = player;
        this.enemy = enemy;
        this.outputController = outputController;
        this.worldData = worldData;
        this.playerXPos = player.getX();
        this.playerYPos = player.getY();
    }
    
    /**
     * Runs when entering combat, handles result
     * @return true if monster is defeated false otherwise
     */
    private Boolean doBattle(){
        Stats enemyStats = enemy.getStats();
        
        outputController.print("Striden startar!");
        SoundPlayer.playCombat();
        while(player.isAlive()){
            if(playerEscaped()){
                outputController.print("Du lyckades fly!");
                SoundPlayer.playBg();
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
            outputController.addLine("Leif attackerar sin motståndare och gör " + player.doAttack(enemy,true) + " enheter skada");
            if(playerEscaped()){
                outputController.print("Du lyckades fly!");
                SoundPlayer.playBg();
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
            if(enemyStats.getHealth() <= 0){
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputController.addLine("Monstret dör en hemsk och smärtsam död");
                SoundPlayer.playBg();
                worldData.removeEnemy(enemy);
                worldData.player.levelUp();
                BoardPanelProvider.getBoardPanel().revalidate();
                BoardPanelProvider.getBoardPanel().repaint();
                worldData.removeAes(new Point(enemy.getX(),enemy.getY()));
                return true;
            }
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            outputController.addLine("Fienden ger igen och gör " + player.doAttack(enemy, false) + " enheter skada");
            if(!player.isAlive())
            {
            	BoardPanel.iDied();
            		
            	return false;
            }
            	
            if(playerEscaped()){
                outputController.print("Du lyckades fly!");
                SoundPlayer.playBg();
                try {
                    Thread.sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * returns true or false if able to escape
     * @return true if escaped
     */
    private boolean playerEscaped() {
        return !(playerYPos == player.getY() && playerXPos == player.getX());
    }
}
