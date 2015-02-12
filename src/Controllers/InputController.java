package Controllers;

import Models.Aesthetics;
import Models.Entity;
import Models.Player;
import Utils.InputParser;
import Views.BoardPanel;
import Views.InputPanel;
import Views.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marcus on 2/4/2015.
 */
public class InputController implements ActionListener {
    private InputPanel inputPanel;
    private BoardPanel boardPanel;
    private Player player;

    private static final int gridSize = 50;
    private static final int width = 500; //GameDimensions.getWorldDimensions().width;
    private static final int height = 500; //GameDimensions.getWorldDimensions().height;
    
    public InputController() {
        
    }

    public InputController(InputPanel inputPanel, Player player, BoardPanel boardPanel) {
        this.inputPanel = inputPanel;
        this.player = player;
        this.boardPanel = boardPanel;
    }

    public InputController(StatusPanel statusPanel, BoardPanel boardPanel) {
        this.inputPanel = statusPanel.getInputPanel();
        this.boardPanel = boardPanel;
        this.player = boardPanel.getPlayer();
    }

    public void setInputPanel(InputPanel inputPanel) {
        this.inputPanel = inputPanel;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = inputPanel.getCommand();
        //This way of checking command does not look nice
        if (command.equals("north") || command.equals("n")) {
            goNorth();

        } else if (command.equals("east") || command.equals("e")) {
            goEast();

        } else if (command.equals("south") || command.equals("s")) {
            goSouth();

        } else if (command.equals("west") || command.equals("w")) {
            goWest();

        } else {
            System.out.println("Invalid command");
        }
    }

    private void goWest() {
        if(!hasCollision(player.getX()-1,player.getY())) {
            player.setX(Math.max(0, player.getX() - 1));
        }
    }

    private void goSouth() {
        if(!hasCollision(player.getX(),player.getY()+1)) {
            player.setY(Math.min(height / gridSize, player.getY() + 1));
        }
    }

    private void goEast() {
        if(!hasCollision(player.getX()+1,player.getY())) {
            player.setX(Math.min(width / gridSize, player.getX() + 1));
        }
    }

    private void goNorth() {
        if(!hasCollision(player.getX(),player.getY()-1)) {
            player.setY(Math.max(0, player.getY() - 1));
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
