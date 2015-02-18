import Models.GameCell;
import Utils.MapFileReader;

import java.io.File;

/**
 * Created by Marcus on 2/16/2015.
 */
public class TestMapFileReader {
    public static void main(String[] args) {
        MapFileReader fileReader = new MapFileReader(new File("./Data/testMap.xml"));
        fileReader.getCells().forEach((cell) -> {
            System.out.println(cell);
        });
    }
}
