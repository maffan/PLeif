package Audio;

import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.BufferedInputStream;

/**
 * @author TE
 * @version 2015-03-08
 */
public class AudioThread extends Thread {

    private String file;
    private boolean loop;
    Player player;

/**
 * Starts new audiosthread
 * @param file input file
 * @param loop loop inputfile
 */
    public AudioThread(String file, boolean loop) {
        this.file = file;
        this.loop = loop;
    }

    public void run() {

        try {
            do {
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                player = new Player(bis);
                player.play();
            } while (loop);
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    /** 
     * Closes current audiothread
     * 
     */
    public void close(){
        loop = false;
        player.close();
        this.interrupt();
    }
}