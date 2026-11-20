package LogicalRoadBuilder;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The Main class is the entry point of the Logical Road Builder application.
 * It extends the JavaFX Application class and initializes the necessary components
 * of the game, such as starting the background music, loading images, and showing
 * the start frame.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Main extends Application {
    public static StartFrame startFrame;
    public static BattleFrame battleFrame;
    public static final int BLOCKSIZE = 213;

    /**
     * The start method is called when the application is launched.
     * It initializes the application by calling the initializeApplication method.
     *
     * @param primaryStage the primary stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        initializeApplication(primaryStage);
    }

    /**
     * Initializes the application by starting the background music,
     * loading the required images, and showing the start frame.
     *
     * @param primaryStage the primary stage of the application
     */
    private void initializeApplication(Stage primaryStage) {
        // Start background music
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.setDaemon(true);
        musicPlayer.start();

        // Load images needed for the game
        ImageController.LoadImages();

        // Initialize and show the start frame
        startFrame = new StartFrame();
        startFrame.start(primaryStage);
    }

    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
