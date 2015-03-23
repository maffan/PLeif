package Controllers;

import Models.Player;
import Models.WorldData;
import Views.BoardPanel;
import Workers.BattleWorker;

import java.awt.*;

/**
 * Created by Marcus on 2/27/2015.
 */
/**
 * @author Tobias
 * Class that handles the playable characters attacks
 */
public class AttackController {
    private Player player;
    private OutputController outputController;
    private WorldData worldData;

    /**
     * empty constructor
     */
    public AttackController() {
    }

    /**
     * Initiates a new AttackController
     * @param outputController The outputController to be used for printing output
     * @param worldData The worldData that contains the player and enemies
     */
    public AttackController(OutputController outputController, WorldData worldData) {
        this.outputController = outputController;
        this.worldData = worldData;
        player = worldData.player;
    }
    /**
     * Checks if an attack can be made and if so initiates a BattleController
     * @param command Direction for the attack
     */
    public void attack(String command){
        if(command.equals("north") || command.equals("n")){
            if(worldData.hasEnemy(new Point(player.getX(), player.getY()-1))){
                BattleWorker worker = new BattleWorker(player, worldData.getEnemy(new Point(player.getX(),player.getY()-1)),outputController,worldData);
                worker.execute();
            }
        }
        else if(command.equals("east") || command.equals("e")){
            if(worldData.hasEnemy(new Point(player.getX()+1, player.getY()))){
                BattleWorker worker = new BattleWorker(player, worldData.getEnemy(new Point(player.getX()+1,player.getY())),outputController,worldData);
                worker.execute();
            }
        }
        else if(command.equals("south") || command.equals("s")){
            if(worldData.hasEnemy(new Point(player.getX(), player.getY()+1))){
                BattleWorker worker = new BattleWorker(player, worldData.getEnemy(new Point(player.getX(),player.getY()+1)),outputController,worldData);
                worker.execute();
            }
        }
        else if(command.equals("west") || command.equals("w")){
            if(worldData.hasEnemy(new Point(player.getX()-1, player.getY()))){
                BattleWorker worker = new BattleWorker(player, worldData.getEnemy(new Point(player.getX()-1,player.getY())),outputController,worldData);
                worker.execute();
            }
        }
        
    }
}
