package LogicalRoadBuilder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 * The Car class represents a car object in the game.
 * It contains the car's position, image view, and methods for moving the car along a path.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Car {
    private int x;
    private int y;
    private int sx = 300;
    private int sy = 100;
    public ImageView imageView;
    private String carPath;

    /**
     * Returns the image view of the car.
     *
     * @return the image view of the car
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Constructs a Car object with the specified x and y coordinates.
     * The car image is determined based on the current game level.
     *
     * @param x the x-coordinate of the car
     * @param y the y-coordinate of the car
     */
    public Car(int x, int y) {
        this.x = x;
        this.y = y;
        if (GameUtil.Level == 1)
            carPath = "Images/car1.png";
        if (GameUtil.Level == 2)
            carPath = "Images/car2.png";
        if (GameUtil.Level == 3)
            carPath = "Images/car3.png";
        if (GameUtil.Level == 4)
            carPath = "Images/car4.png";
        Image image = new Image(this.getClass().getResourceAsStream(carPath));
        this.imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(60);
    }

    /**
     * Sets the position of the car.
     *
     * @param x the x-coordinate of the car
     * @param y the y-coordinate of the car
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the car along the shortest path to the next node.
     *
     * @param shortestPath the list of nodes representing the shortest path
     * @param index        the index of the current node in the shortest path
     */
    public void moveCarAlongPath(List<PathfindingAlgorithm.Node> shortestPath, int index) {
        if (index >= 0 && index < shortestPath.size()) { // Ensure the index is within valid range
            PathfindingAlgorithm.Node nextNode = shortestPath.get(index);
            // Move the car to the position of the next node
            int newX = nextNode.getY() * 20; // Multiply by 20 to adjust the position
            int newY = nextNode.getX() * 20; // Multiply by 20 to adjust the position
            this.setPosition(newX, newY); // Set the new position of the car
        } else {
            // Handle the case when the index is out of bounds
            System.out.println("Index out of bounds");
        }
    }

    /**
     * Adds the specified offsets to the car's position.
     *
     * @param sx the x-offset to add
     * @param sy the y-offset to add
     */
    public void addPosition(int sx, int sy) {
        for (int i = 1; i < 20; i++) {
            this.x += (sx / 20);
            this.y += (sy / 20);
            setPosition(this.x, this.y);
        }
    }

    /**
     * Returns the x-coordinate of the car.
     *
     * @return the x-coordinate of the car
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the car.
     *
     * @return the y-coordinate of the car
     */
    public int getY() {
        return y;
    }
}
