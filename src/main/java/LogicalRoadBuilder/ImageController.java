package LogicalRoadBuilder;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The ImageController class is responsible for loading and managing the images used in the game.
 * It provides static variables to store the loaded images and a static method to load the images.
 *
 * @author BJTU course team (public release anonymized)
 */
public class ImageController {
    /**
     * Static array to store the loaded car images.
     */
    public static Image[] Cars = new Image[4];

    /**
     * Static array to store the loaded play images.
     */
    public static Image[] Plays = new Image[4];

    /**
     * Loads all the required images for the game.
     * It reads the image files from the "data" directory, scales them to the desired sizes,
     * and assigns them to the corresponding static variables.
     * If an IOException occurs during the loading process, it will be caught and printed.
     */
    public static void LoadImages() {
        try {
            int targetWidth1 = 300;  // Target width for car images
            int targetHeight1 = 150; // Target height for car images

            for (int i = 0; i < 4; i++) {
                Image originalImage1 = ImageIO.read(new FileInputStream("data/car" + (i + 1) + ".png"));
                Image scaledImage1 = originalImage1.getScaledInstance(targetWidth1, targetHeight1, Image.SCALE_SMOOTH);
                Cars[i] = scaledImage1;
            }

            int targetWidth2 = 300;  // Target width for play images
            int targetHeight2 = 150; // Target height for play images

            for (int i = 0; i < 4; i++) {
                Image originalImage2 = ImageIO.read(new FileInputStream("data/play" + (i + 1) + ".png"));
                Image scaledImage2 = originalImage2.getScaledInstance(targetWidth2, targetHeight2, Image.SCALE_SMOOTH);
                Plays[i] = scaledImage2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
