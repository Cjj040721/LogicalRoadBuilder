package LogicalRoadBuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The Frame class is the main entry point of the application.
 * It extends the JavaFX Application class and sets up the primary stage,
 * creates the main layout, and displays the level panel.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Frame extends Application {
    public static LevelPanel levelPanel;

    /**
     * The start method is called when the application is launched.
     * It sets up the primary stage, creates the main layout, and displays the level panel.
     *
     * @param primaryStage the primary stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game");
        primaryStage.setResizable(false);

        BorderPane root = new BorderPane();

        levelPanel = new LevelPanel();
        root.setCenter(levelPanel);

        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
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
