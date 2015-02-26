package Views;

import Controllers.KeyPressedController;
import Models.Entity;
import Models.Player;
import Models.SpriteID;
import Models.WorldData;
import Utils.FilesRW;
import Utils.GamePaths;
import Utils.Images;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * Panel containing the central game area
 */
public class BoardPanel extends JPanel implements Observer
{
	private final int gridSize = 50;
	
	private int width = 500;
	private int height = 500;
	
	public static WorldData world;
	private Images images;

    /**
     * Creates and sets up a new world, attaches observers and listeners and adds entities
     */
	public BoardPanel()
	{
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.white);
        
        images = new Images();
        SetupWorld();
        SetupWorldObservers();
	}
	
	private void SetupWorldObservers()
	{
		world.player.addObserver(this);
        world.player.addObserver(InfoPanel.getInventoryPanelInstance());
        world.player.addObserver(InfoPanel.getNamePanelInstance());
        addKeyListener(new KeyPressedController(world.player, this));
        update(null, null);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		width = getSize().width;
		height = getSize().height;
		
		//Draw Backgorund
		g.drawImage(images.bg, 0, 0, null);
		
		//Draw Player
		int pX = world.player.getX()*gridSize;
		int pY = world.player.getY()*gridSize;
		g.drawImage(images.player, pX, pY, null);
		
		//Rita aestetics
		if(!world.aes.isEmpty())
		{
			for(Entity e : world.aes)
			{
				pX = e.getX()*gridSize;
				pY = e.getY()*gridSize;
				
				if(e.getSpriteID() == SpriteID.Tree)
				{
					g.drawImage(images.tree, pX, pY, null);
				}
				else if(e.getSpriteID() == SpriteID.Stone)
				{
					g.drawImage(images.stone, pX, pY, null);
				}
				else if(e.getSpriteID() == SpriteID.Water)
				{
					g.drawImage(images.water, pX, pY, null);
				}
			}
		}
		
		//Rita items
		if(!world.items.isEmpty())
		{
			for(Entity e : world.items)
			{
				pX = e.getX()*gridSize;
				pY = e.getY()*gridSize;
				
				if(e.getSpriteID() == SpriteID.Armour)
				{
					g.drawImage(images.armour, pX, pY, null);
				}
				else if(e.getSpriteID() == SpriteID.Sword)
				{
					g.drawImage(images.sword, pX, pY, null);
				}
			}
		}
		
		//Rita fiender, behöver säkert göras något mer här
		if(!world.enemies.isEmpty())
		{
			for(Entity e : world.enemies)
			{
				pX = e.getX()*gridSize;
				pY = e.getY()*gridSize;
				
				if(e.getSpriteID() == SpriteID.Enemy)
				{
					g.drawImage(images.enemy, pX, pY, null);
				}
			}
		}
		
//		// Draw gridlines.
//		g.setColor(Color.black);
//		for (int i = 0; i < gridSize*height; i++)
//			g.drawLine(0, i * gridSize, width, i * gridSize);
//
//		for (int i = 0; i < gridSize*width; i++)
//			g.drawLine(i * gridSize, 0, i * gridSize, height);
	}

	private void SetupWorld()
	{
		boolean loadSavedMap = false;
		String worldToLoad = GamePaths.Map1;
		
		if(loadSavedMap)
		{
			
		}
		else
		{
			world = new WorldData(worldToLoad);
		}
	}
	
	public static Player getPlayer()
	{
		return world.player;
	}
    
	public void save()
	{
		FilesRW.saveTo(world, GamePaths.WorldSave);
	}
	
	public void load()
	{
		world = FilesRW.loadFrom(GamePaths.WorldSave);
		SetupWorldObservers();
	}

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
