package Views;

import Audio.SoundPlayer;
import Models.Enemy;
import Models.Entity;
import Models.Player;
import Models.SpriteID;
import Models.WorldData;
import Utils.BoardPanelProvider;
import Utils.FilesRW;
import Utils.GamePaths;
import Utils.Images;
import Controllers.*;

import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * Panel containing the central game area
 */
public class BoardPanel extends JPanel implements Observer
{
	private final int gridSize = 50;

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
		world.player.iveChanged();
		update(null, null);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

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
		
		if(!world.isBossAlive)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.WHITE);
			g.drawString("Du vann!", 250, 250);
			SoundPlayer.playEnd();
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
	
	private void loadWorld(String path)
	{
		world = FilesRW.loadFrom(path);
		SetupWorldObservers();
	}
	
	public void reset(){
		loadWorld(GamePaths.StartState);
		InputController.setAttackController();
		SoundPlayer.playBg();
	}

	public void save()
	{
		FilesRW.saveTo(world, GamePaths.WorldSave);
	}

	public void load()
	{
		if((new File(GamePaths.WorldSave)).exists())
			loadWorld(GamePaths.WorldSave);
		else
			JOptionPane.showMessageDialog(null, "No saved game exists.", "Error", 0);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public static void iDied() {
		SoundPlayer.playEnd();
    	int option = JOptionPane.showConfirmDialog(null, "Skar ru' prova igen?", "YOU DIED!", JOptionPane.YES_NO_OPTION);
    	if(option == 0)
    		BoardPanelProvider.getBoardPanel().reset();
    	if(option == 1)
    		System.exit(0);
	}
}
