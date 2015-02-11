package Controllers;

import Models.Player;
import Views.BoardPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Marcus on 2/11/2015.
 */
public class KeyPressedController extends KeyAdapter {
    private Player player;

    private static final int gridSize = 50;
    private static final int width = 500; //GameDimensions.getWorldDimensions().width;
    private static final int height = 500; //GameDimensions.getWorldDimensions().height;
    
    public KeyPressedController(){
        
    }

    public KeyPressedController(Player player) {
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            player.setY(Math.max(0,player.getY()-1));
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.setX(Math.min(width/gridSize,player.getX()+1));
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.setY(Math.min(height/gridSize,player.getY()+1));
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.setX(Math.max(0,player.getX()-1));
        }
    }
}
