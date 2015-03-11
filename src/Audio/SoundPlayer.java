package Audio;

import Utils.GamePaths;


/**
 * @author TE
 * @version 2015-03-08
 */
public class SoundPlayer {
	private static AudioThread audio;
	
	/**
	 * Plays background music
	 */
	public static void playBg(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.BackgroundMusic,true);
		audio.start(); 
	}
	
	/**
	 * Plays combat music
	 */
	public static void playCombat(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.CombatMusic,true);
		audio.start(); 
	}
	
	/**
	 * Plays end or death music
	 */
	public static void playEnd(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.EndMusic,false);
		audio.start(); 
	}
	
	
	/**
	 * Stop current music running
	 */
	public static void stopMusic(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		else {
			System.out.println("No audioplayer running");
		}
	}

	public static void playVictory() {
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.VictoryMusic,false);
		audio.start(); 
		
	}
	
	
}