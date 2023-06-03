import javax.swing.*;
import java.io.IOException;
import javax.sound.sampled.*;

public class QuickMathTester {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        Music music = new Music();
        JFrame frame = new Menu("Quick Math", music);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        music.setFile(0);
        music.start();
        music.loop();
    }
}