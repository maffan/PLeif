package Controllers;

import Models.Aesthetics;
import Models.Entity;
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
    private BoardPanel boardPanel;

    private static final int gridSize = 50;
    private static final int width = 500; //GameDimensions.getWorldDimensions().width;
    private static final int height = 500; //GameDimensions.getWorldDimensions().height;
    
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
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(!hasCollision(player.getX(),player.getY()-1)) {
                player.setY(Math.max(0, player.getY() - 1));
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(!hasCollision(player.getX()+1,player.getY())) {
                player.setX(Math.min(width / gridSize, player.getX() + 1));
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(!hasCollision(player.getX(),player.getY()+1)) {
                player.setY(Math.min(height / gridSize, player.getY() + 1));
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(!hasCollision(player.getX()-1,player.getY())) {
                player.setX(Math.max(0, player.getX() - 1));
            }
        }
    }

    private boolean hasCollision(int x, int y)
    {
        for(Entity e : boardPanel.getEntities())
        {
            if(e instanceof Aesthetics && ((Aesthetics) e).hasCollision())
            {
                if(e.getX() == x && e.getY() == y)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
