package Controllers;

import Models.Aesthetics;
import Models.Entity;
import Models.Player;
import Views.BoardPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Marcus on 2/11/2015.
 * Denna klass kommer, enligt vår nuvarande plan, inte att behövas i slutprodukten, då spelaren skall kontrolleras
 * via en konsol* *
 */
public class KeyPressedController extends KeyAdapter {
    private Player player;
    private BoardPanel boardPanel;

    private static final int mapWidth = 10;
    
    public KeyPressedController(){
        
    }

    public KeyPressedController(Player player,BoardPanel boardPanel) {
        this.player = player;
        this.boardPanel = boardPanel;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
    	if(e.getKeyCode() == KeyEvent.VK_UP){
    		BoardPanel.world.player.move("north", mapWidth);
    	}
    	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
    		BoardPanel.world.player.move("east", mapWidth);
    	}
    	if(e.getKeyCode() == KeyEvent.VK_DOWN){
    		BoardPanel.world.player.move("south", mapWidth);
    	}
    	if(e.getKeyCode() == KeyEvent.VK_LEFT){
    		BoardPanel.world.player.move("west", mapWidth);
    	}
    }
}