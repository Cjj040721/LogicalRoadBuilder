package LogicalRoadBuilder;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;

/**
 * The SwingInJavaFX class demonstrates how to embed a Swing component (BattleFrame) inside a JavaFX application.
 * It creates a JavaFX stage and embeds the Swing component using a SwingNode.
 *
 * @author BJTU course team (public release anonymized)
 */
public class SwingInJavaFX extends Application {

    /**
     * The start method is called when the JavaFX application is launched.
     * It creates a SwingNode, embeds the BattleFrame Swing component into it, and displays it in a JavaFX stage.
     *
     * @param stage The primary stage for this JavaFX application.
     * @throws Exception If an exception occurs during the application startup.
     */
    @Override
    public void start(Stage stage) throws Exception {
        final SwingNode swingNode = new SwingNode();

        SwingUtilities.invokeLater(() -> {
            // Create an instance of BattleFrame and set it as the content of the SwingNode
            BattleFrame battleFrame = new BattleFrame();
            swingNode.setContent(battleFrame.getMainPanel());
        });

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);

        Scene scene = new Scene(pane, 1200, 900);
        stage.setTitle("Battle Game");
        stage.setScene(scene);
        stage.show();
        //Platform.setImplicitExit(false);
    }

    /**
     * The main method is the entry point of the JavaFX application.
     * It launches the application by calling the launch method.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
