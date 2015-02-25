package Views;

import Controllers.KeyPressedController;
import Models.Aesthetics;
import Models.Enemy;
import Models.Entity; // Should these imports be avoided somehow? MJ
import Models.Item;
import Models.MobStats;
import Models.Player;
import Models.SpriteID;
import Models.Stats;
import Models.WorldData;
import Utils.FilesRW;
import Utils.GamePaths;
import Utils.Images;

import java.awt.*;
import java.util.List;
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
        
		//TESTING
//		AddTestEntitys();
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
		
		/*
		 * Code below needs to be rewritten to look for stuff to draw in
		 * world.enemies, world.items and world.aes instead.
		 */
		
		//Rita aestetics
		if(!world.aes.isEmpty())
		{
			
			int cX;
			int cY;
			
			for(Entity e : world.aes){
				
				cX = e.getX()*gridSize;
				cY = e.getY()*gridSize;
				
				if(e instanceof Entity && e.getSpriteID() == SpriteID.Tree)
					{
						g.drawImage(images.tree, cX, cY, null);
					}
				else if(e instanceof Entity && e.getSpriteID() == SpriteID.Stone)
					{
						g.drawImage(images.stone, cX, cY, null);
					}
				else if(e instanceof Entity && e.getSpriteID() == SpriteID.Water)
					{
						g.drawImage(images.water, cX, cY, null);
					}
			}
		}
		
		//Rita items
		if(!world.items.isEmpty())
		{
			
			int cX;
			int cY;
			
			for(Entity e : world.items){
				
				cX = e.getX()*gridSize;
				cY = e.getY()*gridSize;
				
				if(e instanceof Entity && e.getSpriteID() == SpriteID.Armour)
					{
						g.drawImage(images.armour, cX, cY, null);
					}
				else if(e instanceof Entity && e.getSpriteID() == SpriteID.Sword)
					{
						g.drawImage(images.sword, cX, cY, null);
					}
			}
		}
		
		
		//Rita fiender, beh�ver s�kert g�ras n�got mer h�r
		if(!world.enemies.isEmpty())
		{
			
			int cX;
			int cY;
			
			for(Entity e : world.enemies){
				
				cX = e.getX()*gridSize;
				cY = e.getY()*gridSize;
				
				if(e instanceof Entity && e.getSpriteID() == SpriteID.Enemy)
					{
						g.drawImage(images.enemy, cX, cY, null);

					}
			}
		}
		

//		if(!world.entities.isEmpty())
//		{
//			int eW = 20;
//			int eH = 30;
//			int cX;
//			int cY;
//			
//			for(Entity e : world.entities)
//			{
//				cX = e.getX()*gridSize+gridSize/2-eW/2;
//				cY = e.getY()*gridSize+gridSize/2-eH/2;
//				
//				if(e instanceof Aesthetics)
//				{
//					if(e.getSpriteID() == SpriteID.Wall)
//					{
//						g.setColor(Color.darkGray);
//						g.fillRect(cX, cY, eW+5, eH+5);
//					}
//					else if(e.getSpriteID() == SpriteID.Path)
//					{
//						g.setColor(Color.gray);
//						g.fillRect(cX, cY, eW+5, eH+5);
//					}
//				}
//			}
//			
//			for(Entity e : world.entities)
//			{
//				cX = e.getX()*gridSize+gridSize/2-eW/2;
//				cY = e.getY()*gridSize+gridSize/2-eH/2;
//
//				if(e instanceof Enemy)
//				{
//					g.setColor(Color.blue);
//					g.fillRect(cX, cY, eW, eH);
//				}
//			}
//			
//			for(Entity e : world.entities)
//			{
//				cX = e.getX()*gridSize;
//				cY = e.getY()*gridSize;
//				
//				if(e instanceof Entity && e.getSpriteID() == SpriteID.Test)
//				{
//					g.setColor(Color.green);
//					g.drawRect(cX, cY, eW, eH);
//				}
//				if(e instanceof Entity && e.getSpriteID() == SpriteID.Tree)
//				{
//					g.drawImage(images.tree, cX, cY, null);
//				}
//			}
//		}
		
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
//			world.player = new Player("Glenn");
		}
	}
	
	public static Player getPlayer()
	{
		return world.player;
	}

//    private void AddTestEntitys()
//	{
//		world.entities.add(new Entity(1, 1, "Test", SpriteID.Tree));
//		world.entities.add(new Entity(3, 6, "Test", SpriteID.Tree));
//		world.entities.add(new Entity(2, 3, "Test", SpriteID.Tree));
//		world.entities.add(new Entity(8, 4, "Test", SpriteID.Test));
//		
//		world.entities.add(new Enemy(3, 3, "", MobStats.EnemyLVL1));
//
//		world.entities.add(new Aesthetics(4, 4, SpriteID.Wall, true, ""));
//		world.entities.add(new Aesthetics(4, 5, SpriteID.Path, false, ""));
//
//		world.player.addItem(new Item(0, 0, "Sword of Justice", new Stats(), SpriteID.Sword));
//		world.player.addItem(new Item(0, 0, "Shield of Stuff", new Stats(), SpriteID.Shield));
//	}
    
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
