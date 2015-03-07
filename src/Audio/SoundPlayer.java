package Audio;

import Utils.GamePaths;


public class SoundPlayer {
	private static AudioThread audio;
	
	public static void playBg(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.BackgroundMusic,true);
		audio.start(); 
	}
	
	public static void playCombat(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.CombatMusic,true);
		audio.start(); 
	}
	
	public static void playEnd(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		audio = new AudioThread(GamePaths.EndMusic,false);
		audio.start(); 
	}
	
	
	public static void stopMusic(){
		if(audio != null && (! audio.player.isComplete()) ){
			audio.close();
		}
		else {
			System.out.println("No audioplayer running");
		}
	}
	
	
}