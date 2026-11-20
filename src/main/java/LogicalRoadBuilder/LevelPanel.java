package LogicalRoadBuilder;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The LevelPanel class represents a panel that displays the different levels of the game.
 * It contains buttons for each level and handles the switching between levels.
 *
 * @author BJTU course team (public release anonymized)
 */
public class LevelPanel extends Pane {
    private Image backgroundImage;
    private boolean visible = false;

    /**
     * Constructs a new LevelPanel.
     * It sets the preferred size of the panel, loads the background image, and creates the level buttons.
     */
    public LevelPanel() {
        setPrefSize(1200, 900);

        loadBackground("file:data/level1.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.fitWidthProperty().bind(widthProperty());
        backgroundView.fitHeightProperty().bind(heightProperty());

        Button level1Button = createLevelButton(this, "Level1", 1050, 100, 150, 200, 1);
        Button level2Button = createLevelButton(this, "Level2", 850, 500, 150, 200, 2);
        Button level3Button = createLevelButton(this, "Level3", 250, 450, 150, 200, 3);
        Button level4Button = createLevelButton(this, "Level4", 500, 50, 150, 200, 4);

        getChildren().add(backgroundView);
        getChildren().addAll(level1Button, level2Button, level3Button, level4Button);
    }

    /**
     * Creates a button for a specific level.
     *
     * @param root   the root pane to which the button will be added
     * @param label  the label text for the button
     * @param x      the x-coordinate of the button's position
     * @param y      the y-coordinate of the button's position
     * @param width  the width of the button
     * @param height the height of the button
     * @param level  the level associated with the button
     * @return the created level button
     */
    private Button createLevelButton(Pane root, String label, int x, int y, int width, int height, int level) {
        Button button = new Button(label);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefWidth(width);
        button.setPrefHeight(height);

        button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");

        button.setOnMouseEntered(e -> {
            MusicPlayer.play("file:data/point button.wav");
        });

        button.setOnAction(e -> {
            MusicPlayer.play("file:data/point button.wav");
            switchLevel(level);
        });

        return button;
    }

    /**
     * Loads the background image from the specified path.
     *
     * @param path the path to the background image file
     */
    private void loadBackground(String path) {
        backgroundImage = new Image(path);
    }

    /**
     * Switches to the specified level.
     * It sets the level-specific data in the GameUtil object and starts the game.
     *
     * @param level the level to switch to
     */
    private void switchLevel(int level) {
        System.out.println("Switched to level: " + level);
        GameUtil gameUtil = new GameUtil();

        switch (level) {
            case 1:
                gameUtil.StartX = 0;
                gameUtil.StartY = 0;
                gameUtil.EndX = 132;
                gameUtil.EndY = 375;
                gameUtil.CarBeginX = 3;
                gameUtil.CarBeginY = 3;
                gameUtil.CarEndX = 21;
                gameUtil.CarEndY = 9;
                gameUtil.BeginPo = 1;
                gameUtil.EndPo = 14;
                gameUtil.Level = 1;
                break;
            case 2:
                gameUtil.StartX = 0;
                gameUtil.StartY = 0;
                gameUtil.EndX = 253;
                gameUtil.EndY = 253;
                gameUtil.BeginPo = 1;
                gameUtil.EndPo = 11;
                gameUtil.CarBeginX = 3;
                gameUtil.CarBeginY = 3;
                gameUtil.CarEndX = 15;
                gameUtil.CarEndY = 15;
                gameUtil.Level = 2;
                break;
            case 3:
                gameUtil.StartX = 0;
                gameUtil.StartY = 0;
                gameUtil.EndX = 379;
                gameUtil.EndY = 252;
                gameUtil.CarBeginX = 3;
                gameUtil.CarBeginY = 3;
                gameUtil.CarEndX = 15;
                gameUtil.CarEndY = 21;
                gameUtil.BeginPo = 1;
                gameUtil.EndPo = 12;
                gameUtil.Level = 3;
                break;
            case 4:
                gameUtil.StartX = 0;
                gameUtil.StartY = 0;
                gameUtil.EndX = 378;
                gameUtil.EndY = 372;
                gameUtil.CarBeginX = 3;
                gameUtil.CarBeginY = 3;
                gameUtil.CarEndX = 21;
                gameUtil.CarEndY = 21;
                gameUtil.BeginPo = 1;
                gameUtil.EndPo = 16;
                gameUtil.Level = 4;
                break;
        }
        Stage currentStage = (Stage) getScene().getWindow();
        currentStage.close();

        Driver driver = new Driver();
        Stage stage = new Stage();
        driver.start(stage);
    }
}
