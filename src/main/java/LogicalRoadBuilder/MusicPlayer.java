package LogicalRoadBuilder;

import java.io.File;
import javax.sound.sampled.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The MusicPlayer class is responsible for playing background music and sound effects in the Logical Road Builder game.
 * It extends the Thread class to allow music playback in a separate thread.
 *
 * @author BJTU course team (public release anonymized)
 */
public class MusicPlayer extends Thread {

    private static List<Clip> clips = new ArrayList<>();

    /**
     * Overrides the run method of the Thread class to start the background music playback.
     * It continuously plays the music file "data/track.wav" in a loop.
     */
    public void run() {
        if (System.getenv("LOGICAL_ROAD_BUILDER_MUTE") != null) return;
        try {
            while(true) playMusic("data/music.wav");
        } catch (Exception e) {e.printStackTrace();}
    }

    /**
     * Plays the specified music file.
     *
     * @param path The path of the music file.
     * @throws Exception If an error occurs while playing the music.
     */
    public static void playMusic(String path) throws Exception {
        AudioInputStream in = AudioSystem.getAudioInputStream(new File(path));
        byte[] buffer = new byte[512];
        int cnt = 1;
        SourceDataLine line = AudioSystem.getSourceDataLine(in.getFormat());
        line.open();
        line.start();
        while(cnt > 0) {
            cnt = in.read(buffer, 0, buffer.length);
            if (cnt > 0) line.write(buffer, 0, cnt);
        }
        line.drain();
        line.close();
    }

    /**
     * Plays the specified sound file once.
     *
     * @param f The path of the sound file.
     */
    public static void play(final String f) {
        if (System.getenv("LOGICAL_ROAD_BUILDER_MUTE") != null) return;
        Clip c = null;
        try {
            String path = f.startsWith("file:") ? f.substring(5) : f;
            c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(new File(path)));
            c.loop(0);
            clips.add(c); // Add the clip to the list of active clips
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Plays the specified music file in a loop continuously.
     *
     * @param path The path of the music file.
     */
    public static void loopPlay(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clips.add(clip); // Add the clip to the list of active clips
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes all active audio clips and stops their playback.
     */
    public static void close() {
        for (Clip clip : clips) {
            if (clip != null) {
                clip.stop(); // Stop the clip
                clip.close(); // Close the resource
            }
        }
        clips.clear(); // Clear the list of active clips
    }
    /**
     * Stops the playback of the audio file specified by the given path.
     * This method attempts to stop the audio playback by closing the SourceDataLine associated with the audio file.
     *
     * @param path The path of the audio file to stop playback for.
     * @throws Exception If an error occurs while stopping the audio playback.
     */
    public static void stopMusic(String path) throws Exception{
        AudioInputStream in = AudioSystem.getAudioInputStream(new File(path));
        byte[] buffer = new byte[512];
        int cnt = 1;
        SourceDataLine line = AudioSystem.getSourceDataLine(in.getFormat());
        if (line != null && line.isOpen()) {
            line.stop();
            line.close();
        }
    }
}
