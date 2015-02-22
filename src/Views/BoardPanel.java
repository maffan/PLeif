package Views;

import Controllers.KeyPressedController;
import Models.Aesthetics;
import Models.Enemy;
import Models.Entity; // Should these imports be avoided somehow? MJ
import Models.Item;
import Models.Player;
import Models.SpriteID;
import Models.Stats;
import Models.WorldData;
import Utils.MapFileReader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class BoardPanel extends JPanel implements Observer
{
	private final int gridSize = 50;
	
	private int width = 500;
	private int height = 500;
	
	public static WorldData world;

	public BoardPanel()
	{
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(new JLabel("Board",SwingConstants.CENTER),BorderLayout.CENTER);
        setPreferredSize(new Dimension(500,500));
        
        SetupWorld();
        
        world.player.addObserver(this);
        world.player.addObserver(InfoPanel.getInventoryPanelInstance());
        world.player.addObserver(InfoPanel.getNamePanelInstance());

		setBackground(Color.white);
		
        addKeyListener(new KeyPressedController(world.player, this));
        
		//TESTING
		AddTestEntitys();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		width = getSize().width;
		height = getSize().height;
		
		// Draw gridlines.
		g.setColor(Color.black);
		for (int i = 0; i < gridSize*height; i++)
			g.drawLine(0, i * gridSize, width, i * gridSize);

		for (int i = 0; i < gridSize*width; i++)
			g.drawLine(i * gridSize, 0, i * gridSize, height);

		if(!world.entities.isEmpty())
		{
			int eW = 20;
			int eH = 30;
			int cX;
			int cY;
			
			for(Entity e : world.entities)
			{
				cX = e.getX()*gridSize+gridSize/2-eW/2;
				cY = e.getY()*gridSize+gridSize/2-eH/2;
				
				if(e instanceof Aesthetics)
				{
					if(e.getSpriteID() == SpriteID.Wall)
					{
						g.setColor(Color.darkGray);
						g.fillRect(cX, cY, eW+5, eH+5);
					}
					else if(e.getSpriteID() == SpriteID.Path)
					{
						g.setColor(Color.gray);
						g.fillRect(cX, cY, eW+5, eH+5);
					}
				}
			}

			//Player
			int pX = world.player.getX()*gridSize+gridSize/2-eW/2;;
			int pY = world.player.getY()*gridSize+gridSize/2-eW/2;;
			g.setColor(Color.red);
			g.fillRect(pX, pY, eW, eH);
			
			for(Entity e : world.entities)
			{
				cX = e.getX()*gridSize+gridSize/2-eW/2;
				cY = e.getY()*gridSize+gridSize/2-eH/2;

				if(e instanceof Enemy)
				{
					g.setColor(Color.blue);
					g.fillRect(cX, cY, eW, eH);
				}
			}
			
			for(Entity e : world.entities)
			{
				cX = e.getX()*gridSize+gridSize/2-eW/2;
				cY = e.getY()*gridSize+gridSize/2-eH/2;
				
				if(e instanceof Entity && e.getSpriteID() == SpriteID.Test)
				{
					g.setColor(Color.green);
					g.drawRect(cX, cY, eW, eH);
				}
			}
		}
	}

	private void SetupWorld()
	{
		boolean loadSavedMap = false;
		
		if(loadSavedMap)
		{
			
		}
		else
		{
			world = new WorldData();
			world.player = new Player("Glenn");
			world.mapFile = new MapFileReader(new File("PLeif/Data/testMap.xml"));
		}
	}
	
	public static Player getPlayer()
	{
		return world.player;
	}

    public List<Entity> getEntities() {
        return world.entities;
    }

    private void AddTestEntitys()
	{
		world.entities.add(new Entity(1, 1, SpriteID.Test, "Test"));
		world.entities.add(new Entity(3, 6, SpriteID.Test, "Test"));
		world.entities.add(new Entity(2, 3, SpriteID.Test, "Test"));
		world.entities.add(new Entity(8, 4, SpriteID.Test, "Test"));
		
		world.entities.add(new Enemy(3, 3, ""));

		world.entities.add(new Aesthetics(4, 4, SpriteID.Wall, true, ""));
		world.entities.add(new Aesthetics(4, 5, SpriteID.Path, false, ""));

		world.player.addItem(new Item(new Stats(), 0, 0, SpriteID.Sword, "Sword of Justice"));
		world.player.addItem(new Item(new Stats(), 0, 0, SpriteID.Shield, "Shield of Stuff"));
	}

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
