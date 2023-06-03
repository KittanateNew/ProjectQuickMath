import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author new
 */
public class Music {
    
    Clip clip;
    URL soundURL[] = new URL[30];
    
    public Music(){
        
        soundURL[0] = getClass().getResource("/Sound/MikoDayo.wav");
        soundURL[1] = getClass().getResource("/Sound/SuiseiBGM60.wav");
        soundURL[2] = getClass().getResource("/Sound/NormalMusic.wav");
        soundURL[3] = getClass().getResource("/Sound/HardMusic.wav");
        soundURL[4] = getClass().getResource("/Sound/MissionFail.wav");
         
    }
    
    public void setFile(int n){
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL[n]);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            setVolume(0.3);
        }catch(Exception e){
            
        }
    }
    
    public void setVolume(double percent){
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        double perCent = percent;
        float dB = (float) (Math.log(perCent)/Math.log(10.0)*20.0);
        volume.setValue(dB);
    }
    
    public void start(){
        clip.start();
    }
    
    public void stop(){
        clip.stop();
    }
    
    public void loop(){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    
    public void close(){
        clip.close();
    }
    
}
