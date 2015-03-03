package Utils;

import javazoom.jl.player.*;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

public class SoundPlayer {
	
	private static Player player;	
	
	//Spelar bakrundsmusik i ny thread
	public static void playMusic() {
		try{			
		    FileInputStream fis = new FileInputStream(GamePaths.BackgroundMusic);
		    BufferedInputStream bis = new BufferedInputStream(fis);
		    player = new Player(bis);

			
			}catch(Exception e){
		    	System.out.println("Problem playing file" +GamePaths.BackgroundMusic);
		    	System.out.println(e);
		    }
		
		//Ny thread f�r bakrund och starta l�ten
		new Thread() {
			public void run(){
				try { player.play(); }
				catch(Exception e){System.out.println(e);}
			}
		}.start();
		
	}
	
	public static void stopMusic(){
		player.close();
	}
	
	
}