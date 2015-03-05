package Audio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;

public class VolumeControl 
{

	static FloatControl volumeControl;
	
    public static void changeVolume(float volume) {        
    Info source = Port.Info.SPEAKER;
    //        source = Port.Info.LINE_OUT;
    //        source = Port.Info.HEADPHONE;

        if (AudioSystem.isLineSupported(source)) 
        {
            try 
            {
                Port outline = (Port) AudioSystem.getLine(source);
                outline.open();                
                volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);                
                volumeControl.setValue(volume);
//                System.out.println("   new volume: " + volumeControl.getValue() );
            } 
            catch (LineUnavailableException ex) 
            {
                System.err.println("source not supported");
                ex.printStackTrace();
            }            
        }
    }

	public static float getVolume() {
		if(volumeControl != null){
			return volumeControl.getValue();
		}
		else{
			return 0;
		}
		
	} 

 }