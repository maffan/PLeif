package Views;

import Models.Aesthetics;
import Models.Enemy;
import Models.Entity; // Should these imports be avoided somehow? MJ
import Models.Player;
import Models.SpriteID;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class BoardPanel extends JPanel
{
    
	private final int gridSize = 50;
	
	// Hardcoded values? MJ
	private int width = 500; //GameDimensions.getWorldDimensions().width;
	private int height = 500; //GameDimensions.getWorldDimensions().height;
	
	private List<Entity> entities;
	private static Player player;

	public BoardPanel()
	{
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(new JLabel("Board",SwingConstants.CENTER),BorderLayout.CENTER);
        setPreferredSize(new Dimension(500,500)); //GameDimensions.getWorldDimensions());
		
		player = new Player("Glenn");
		entities = new ArrayList<Entity>();
		entities.add(player);

		setBackground(Color.white);
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e) {
				keyPress(e);
			}
		});
		
		//TESTING
		AddTestEntitys();
	}

	private void keyPress(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
			if(!hasCollision(player.getX(),player.getY()-1))
			{
				player.setY(Math.max(0,player.getY()-1));
			}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			if(!hasCollision(player.getX(),player.getY()+1))
			{
				player.setY(Math.min(height/gridSize,player.getY()+1));
			}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			if(!hasCollision(player.getX()-1,player.getY()))
			{
				player.setX(Math.max(0,player.getX()-1));
			}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			if(!hasCollision(player.getX()+1,player.getY()))
			{
				player.setX(Math.min(width/gridSize,player.getX()+1));
			}

		GameFrame.infoPanelUpdate();
		GameFrame.statusPanelUpdate();
		
		repaint();
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

		if(!entities.isEmpty())
		{
			int eW = 20;
			int eH = 30;
			int cX;
			int cY;
			
			for(Entity e : entities)
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
			
			for(Entity e : entities)
			{
				cX = e.getX()*gridSize+gridSize/2-eW/2;
				cY = e.getY()*gridSize+gridSize/2-eH/2;
				
				if(e instanceof Player)
				{
					g.setColor(Color.red);
					g.fillRect(cX, cY, eW, eH);
				}
			}
			
			for(Entity e : entities)
			{
				cX = e.getX()*gridSize+gridSize/2-eW/2;
				cY = e.getY()*gridSize+gridSize/2-eH/2;

				if(e instanceof Enemy)
				{
					g.setColor(Color.blue);
					g.fillRect(cX, cY, eW, eH);
				}
			}
			
			for(Entity e : entities)
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
	//hasStuff() ?
	private boolean hasCollision(int x, int y)
	{
		for(Entity e : entities)
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
	
	public static Player getPlayer()
	{
		return player;
	}

	private void AddTestEntitys()
	{
		entities.add(new Entity(1, 1, SpriteID.Test));
		entities.add(new Entity(3, 6, SpriteID.Test));
		entities.add(new Entity(2, 3, SpriteID.Test));
		entities.add(new Entity(8, 4, SpriteID.Test));
		
		entities.add(new Enemy(3, 3));

		entities.add(new Aesthetics(4, 4, SpriteID.Wall, true));
		entities.add(new Aesthetics(4, 5, SpriteID.Path, false));

		player.addItem(new Entity(SpriteID.Sword));
		player.addItem(new Entity(SpriteID.Shield));
	}
}
