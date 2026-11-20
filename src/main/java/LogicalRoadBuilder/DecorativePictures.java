package LogicalRoadBuilder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The DecorativePictures class is responsible for adding decorative images to the game pane.
 * It includes images for cross, hyperbola, arc, and choose elements.
 *
 * @author BJTU course team (public release anonymized)
 */
public class DecorativePictures {
    Image crossImage = new Image("file:images/Cross2.png");
    Image HyperbolaImage = new Image("file:images/Hyperbola1.png");
    Image arcImage = new Image("file:images/arc1.png");
    Image chooseImage = new Image("file:images/choose4.png");

    /**
     * Constructs an object of the DecorativePictures class.
     */
    public DecorativePictures() {
    }

    /**
     * Adds decorative images to the specified pane.
     *
     * @param pane the pane to add the images to
     */
    public void addImage(Pane pane) {
        ImageView imageView1 = new ImageView(chooseImage);
        ImageView imageView4 = new ImageView(crossImage);
        ImageView imageView2 = new ImageView(HyperbolaImage);
        ImageView imageView3 = new ImageView(arcImage);

        imageView1.setFitWidth(240);
        imageView1.setFitHeight(80);
        imageView4.setFitWidth(130);
        imageView4.setFitHeight(130);
        imageView2.setFitWidth(130);
        imageView2.setFitHeight(130);
        imageView3.setFitWidth(130);
        imageView3.setFitHeight(130);

        imageView1.setLayoutX(530);
        imageView1.setLayoutY(10);
        imageView4.setLayoutX(580);
        imageView4.setLayoutY(90);
        imageView2.setLayoutX(580);
        imageView2.setLayoutY(220);
        imageView3.setLayoutX(580);
        imageView3.setLayoutY(350);

        pane.getChildren().add(imageView4);
        pane.getChildren().add(imageView2);
        pane.getChildren().add(imageView3);
        pane.getChildren().add(imageView1);
    }
}
