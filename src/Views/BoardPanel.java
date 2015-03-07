package Views;

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
		world.player.addObserver(InfoPanel.getEquippedPanelInstance());
		world.player.getStats().addObserver(InfoPanel.getStatsInfoPanelInstance());
		update(null, null);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		width = getSize().width;
		height = getSize().height;

		//Draw Backgorund
		g.drawImage(images.getImage(SpriteID.Bg), 0, 0, null);

		//Draw Player
		int pX = getPlayer().getX()*gridSize;
		int pY = getPlayer().getY()*gridSize;
		
		g.drawImage(images.getImage(getPlayer().getSpriteID()), pX, pY, null);

		//Rita aestetics
		if(!world.aes.isEmpty())
		{
			for(Entity e : world.aes)
			{
				pX = e.getX()*gridSize;
				pY = e.getY()*gridSize;
				
				g.drawImage(images.getImage(e.getSpriteID()), pX, pY, null);
			}
		}

		//Rita items
		if(!world.items.isEmpty())
		{
			for(Entity e : world.items)
			{
				pX = e.getX()*gridSize;
				pY = e.getY()*gridSize;
				
				g.drawImage(images.getImage(e.getSpriteID()), pX, pY, null);
			}
		}

		//Rita fiender, beh�ver s�kert g�ras n�got mer h�r
		if(!world.enemies.isEmpty())
		{
			for(Entity e : world.enemies)
			{
				pX = e.getX()*gridSize;
				pY = e.getY()*gridSize;
				
				g.drawImage(images.getImage(e.getSpriteID()), pX, pY, null);
			}
		}
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
	
	public void reset(){
		world = FilesRW.loadFrom(GamePaths.StartState);
		SetupWorldObservers();
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
