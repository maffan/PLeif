package Utils;

import Models.GameCell;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Marcus on 2/16/2015.
 * Parses an XML file describing a map*
 */
public class MapFileReader {
    private LinkedList<GameCell> cells;
    private HashMap<Point,GameCell> cellMap;

    /**Takes an XML-file and extracts cell information and puts them into a linked list and an hash map
     * 
     * @param mapFile A file object representing the xml-file
     */
    public MapFileReader(File mapFile){
        try {
            cells = new LinkedList<>();
            cellMap = new HashMap<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(mapFile);
            document.getDocumentElement().normalize();

            System.out.println("Root element: "+document.getDocumentElement().getNodeName());

            NodeList cellList = document.getElementsByTagName("cell");
            
            for(int i = 0 ; i < cellList.getLength() ; i++) {
                Node cell = cellList.item(i);
                Element element = (Element) cell;
                int x = Integer.parseInt(element.getElementsByTagName("x").item(0).getTextContent());
                int y = Integer.parseInt(element.getElementsByTagName("y").item(0).getTextContent());
                String description = element.getElementsByTagName("description").item(0).getTextContent();
                Point point = new Point(x,y);
                
                cells.add(new GameCell(point,description));
            }
            
            cells.forEach((cell) -> {
                cellMap.put(cell.getPoint(),cell);
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**Get method for retrieving a linked list of all the cells
     * 
     * @return A linked list of cells
     */
    public LinkedList<GameCell> getCells(){
        return cells;
    }

    /**Get method for retrieving an hash map mapping a cells position to the cell object
     * 
     * @return an Hash map mapping a position to its corresponding cell
     */
    public HashMap<Point,GameCell> getCellMap(){
        return cellMap;
    }
}
