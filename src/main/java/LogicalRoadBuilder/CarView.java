package LogicalRoadBuilder;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

/**
 * The CarView class represents the graphical view of a car moving along a path.
 * It extends the JavaFX Application class.
 *
 * @author BJTU course team (public release anonymized)
 */
public class CarView extends Application {
    private Car car;

    public static final String Cariv = "file:images/car3.png";
    private ImageView carImageView = new ImageView(new Image(Cariv));
    private List<PathfindingAlgorithm.Node> shortestPath;

    /**
     * Constructs a CarView object with the specified shortest path and pane.
     *
     * @param shortestPath the list of nodes representing the shortest path
     * @param pane the pane to add the car image view to
     */
    public CarView(List<PathfindingAlgorithm.Node> shortestPath, Pane pane) {
        car = new Car(100, 100); // The initial position can be adjusted based on the start and end points
        this.shortestPath = shortestPath;

        carImageView = car.getImageView();
        pane.getChildren().add(carImageView);
    }

    /**
     * The start method is called when the application is launched.
     * It creates a timeline animation to move the car along the shortest path.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        int[] currentIndex = {0};

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), event -> {
            if (currentIndex[0] < shortestPath.size() - 1) {
                car.moveCarAlongPath(shortestPath, currentIndex[0]);
                carImageView.setLayoutX(car.getX());
                carImageView.setLayoutY(car.getY());
                currentIndex[0]++;
            }
        }));
        timeline.setCycleCount(shortestPath.size() - 1);
        timeline.play();
    }
}
