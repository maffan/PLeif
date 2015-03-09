package Audio;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;

/**
 * @author Tobias
 * @version 2014-03-08
 */
public class VolumeControl 
{

	static FloatControl volumeControl;
	
    /**
     * Change output volume
     * @param volume, new volume
     */
    public static void changeVolume(float volume) {        
    Info source = Port.Info.SPEAKER;
    Info source2 = Port.Info.HEADPHONE;
    Info source3 = Port.Info.LINE_OUT;

        if (AudioSystem.isLineSupported(source)) 
        {
            try 
            {
                Port outline = (Port) AudioSystem.getLine(source);
                outline.open();                
                volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);                
                volumeControl.setValue(volume);
            } 
            catch (LineUnavailableException ex) 
            {
                System.err.println("source not supported");
                ex.printStackTrace();
            }            
        }
        
        if (AudioSystem.isLineSupported(source2)) 
        {
            try 
            {
                Port outline2 = (Port) AudioSystem.getLine(source2);
                outline2.open();                
                volumeControl = (FloatControl) outline2.getControl(FloatControl.Type.VOLUME);                
                volumeControl.setValue(volume);
            } 
            catch (LineUnavailableException ex) 
            {
                System.err.println("source not supported");
                ex.printStackTrace();
            }            
        }
        
        if (AudioSystem.isLineSupported(source3)) 
        {
            try 
            {
                Port outline3 = (Port) AudioSystem.getLine(source3);
                outline3.open();                
                volumeControl = (FloatControl) outline3.getControl(FloatControl.Type.VOLUME);                
                volumeControl.setValue(volume);
            } 
            catch (LineUnavailableException ex) 
            {
                System.err.println("source not supported");
                ex.printStackTrace();
            }            
        }
    }

	/**
	 * @return current volume
	 */
	public static float getVolume() {
		if(volumeControl != null){
			return volumeControl.getValue();
		}
		else{
			return 0;
		}
		
	} 

 }