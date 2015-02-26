package Utils;

import Models.Aesthetics;
import Models.Enemy;
import Models.Item;
import Models.MobStats;
import Models.Player;
import Models.SpriteID;
import Models.Stats;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marcus on 2/16/2015.
 * Parses an XML file describing a map*
 */
public class MapFileReader
{
	private List<Enemy> enemies;
	private List<Item> items;
	private HashMap<Point, String> desc;
	private List<Aesthetics> aes;
	private Player player;
	
    /**Takes an XML-file and extracts cell information and puts them into a linked list and an hash map
     * 
     * @param mapFile A file object representing the xml-file
     */
    public MapFileReader(File mapFile)
    {
    	enemies = new ArrayList<Enemy>();
    	items = new ArrayList<Item>();
    	aes = new ArrayList<Aesthetics>();
    	desc = new HashMap<Point, String>();
    	
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(mapFile);
            document.getDocumentElement().normalize();

            NodeList cellList = document.getElementsByTagName("cell");
            
            for(int i = 0 ; i < cellList.getLength() ; i++) {
                Node cell = cellList.item(i);
                Element element = (Element) cell;
                int x = Integer.parseInt(element.getElementsByTagName("x").item(0).getTextContent());
                int y = Integer.parseInt(element.getElementsByTagName("y").item(0).getTextContent());
                String description = element.getElementsByTagName("description").item(0).getTextContent();
                desc.put(new Point(x, y), description);
                	
                if(element.getElementsByTagName("enemy").getLength() != 0)
                {
                	Stats stats = null;
                	switch (element.getElementsByTagName("enemy").item(0).getTextContent())
                	{
                		case "1":
                			stats = MobStats.EnemyLVL1; break;
                		case "2":
                			stats = MobStats.EnemyLVL2; break;
                		case "3":
                			stats = MobStats.EnemyLVL3; break;
                		case "4":
                			stats = MobStats.EnemyLVL4; break;
                		case "5":
                			stats = MobStats.Boss;
                	}
                	enemies.add(new Enemy(x, y, "", stats));
                }
                
                if(element.getElementsByTagName("item").getLength() != 0)
                {
                	Stats stats = null;
                	String[] itemProperties = element.getElementsByTagName("item").item(0).getTextContent().split(",");
                	switch (itemProperties[0])
                	{
                		case "sword":
                        	switch (itemProperties[2])
                        	{
                        		case "1":
                        			stats = MobStats.SwordLVL1(); break;
                        		case "2":
                        			stats = MobStats.SwordLVL2(); break;
                        		case "3":
                        			stats = MobStats.SwordLVL3(); break;
                        		case "4":
                        			stats = MobStats.SwordLVL4();
                        	}
                		case "armour":
                        	switch (itemProperties[2])
                        	{
                        		case "1":
                        			stats = MobStats.ArmourLVL1(); break;
                        		case "2":
                        			stats = MobStats.ArmourLVL2(); break;
                        		case "3":
                        			stats = MobStats.ArmourLVL3(); break;
                        		case "4":
                        			stats = MobStats.ArmourLVL4();
                        	}
                	}
                	String spriteid = itemProperties[0];
                	items.add(new Item(x, y, itemProperties[1], stats, SpriteID.stringToID(spriteid)));
                }
                
                if(element.getElementsByTagName("type").getLength() != 0)
                {
                	String[] aesProperties = element.getElementsByTagName("type").item(0).getTextContent().split(",");
                	boolean hasCollision = false;
                	
                	if(aesProperties[1].equals("1"))
                	{
                		hasCollision = true;
                	}
                	
                	aes.add(new Aesthetics(x, y, SpriteID.stringToID(aesProperties[0]), hasCollision, ""));
                }
                
                if(element.getElementsByTagName("player").getLength() != 0)
                {

                	Stats stats = null;
                	switch (element.getElementsByTagName("player").item(0).getTextContent())
                	{
                		case "1":
                			stats = MobStats.PlayerLVL1; break;	
                		case "2":
                			stats = MobStats.PlayerLVL2; break;
                		case "3":
                			stats = MobStats.PlayerLVL3; break;
                		case "4":
                			stats = MobStats.PlayerLVL4;
                	}
                	player = new Player(x, y, "Glenn", stats);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public Player getPlayer()
    {
    	return player;
    }
    
    public List<Enemy> getListOfEnemies()
    {
		return enemies;
    	
    }    
    public List<Item> getListOfItems()
    {
		return items;
    	
    }    
    public List<Aesthetics> getListOfAestethics()
    {
		return aes;
    }

	public HashMap<Point, String> getDescriptions()
	{
		return desc;
	}
}