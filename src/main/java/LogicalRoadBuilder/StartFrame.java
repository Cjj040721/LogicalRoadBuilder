package LogicalRoadBuilder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The StartFrame class is the main entry point of the Logical Road Builder game application.
 * It extends the Application class from JavaFX and sets up the initial user interface for the game.
 *
 * @author BJTU course team (public release anonymized)
 */
public class StartFrame extends Application {
    public static int selectedCarIndex = 0;
    private Stage primaryStage;
    private BorderPane rootPane;
    private Button startButton;
    private Button endButton;
    private Button aboutButton;
    public static Stage frame;
    public static StartFrame startFrame;

    /**
     * The main entry point of the JavaFX application.
     * It initializes the primary stage, sets up the scene, creates and lays out the buttons,
     * sets the background image, and shows the primary stage.
     *
     * @param primaryStage the primary stage of the application
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Logical Road Builder");

        rootPane = new BorderPane();
        Scene scene = new Scene(rootPane, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        createButtons();
        layoutButtons();
        addButtonActions();

        setBackgroundImage("file:data/background1.jpg");

        primaryStage.show();
    }

    /**
     * Creates the start, end, and about buttons using the createButton method.
     */
    private void createButtons() {
        startButton = createButton("file:data/startButton.png", 200, 100);
        endButton = createButton("file:data/endButton.png", 200, 100);
        aboutButton = createButton("file:data/adout.png", 200, 100);
    }

    /**
     * Creates a button with the specified image, width, and height.
     * It sets the button's style to have a transparent background and no padding.
     * It also adds a mouse-entered event handler to play a sound effect.
     *
     * @param imagePath the path to the button's image
     * @param width     the width of the button
     * @param height    the height of the button
     * @return the created button
     */
    private Button createButton(String imagePath, int width, int height) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        Button button = new Button();
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent; -fx-padding: 0;");

        button.setOnMouseEntered(e -> MusicPlayer.play("file:data/point button.wav"));

        return button;
    }

    /**
     * Lays out the start, end, and about buttons vertically in the center of the root pane.
     */
    private void layoutButtons() {
        VBox buttonBox = new VBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(startButton, endButton, aboutButton);

        rootPane.setCenter(buttonBox);
    }

    /**
     * Adds action event handlers to the start, end, and about buttons.
     * The start button shows the player selection window, the end button exits the application,
     * and the about button shows the game description.
     */
    private void addButtonActions() {
        startButton.setOnAction(e -> showPlayerSelectionWindow());
        endButton.setOnAction(e -> System.exit(0));
        aboutButton.setOnAction(e -> showAbout());
    }

    /**
     * Sets the background image of the root pane using the specified image path.
     *
     * @param imagePath the path to the background image
     */
    private void setBackgroundImage(String imagePath) {
        Image backgroundImage = new Image(imagePath);
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
        rootPane.setBackground(new Background(background));
    }

    /**
     * Displays a modal window for player selection.
     * It creates a grid of player buttons using the createPlayerButton method and shows the window.
     * When a player is selected, it closes the start frame.
     */
    private void showPlayerSelectionWindow() {
        Stage selectionWindow = new Stage();
        selectionWindow.initModality(Modality.APPLICATION_MODAL);
        selectionWindow.initOwner(primaryStage);
        selectionWindow.setTitle("Player Selection");

        String[] players = {"Pagani", "McLaren", "Porsche", "Lamborghini"};

        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(40);
        buttonGrid.setVgap(40);
        buttonGrid.setAlignment(Pos.CENTER);

        int row = 0;
        int col = 0;
        for (int i = 0; i < players.length; i++) {
            Button playerButton = createPlayerButton(players[i], i);
            buttonGrid.add(playerButton, col, row);

            col++;
            if (col == 2) {
                col = 0;
                row++;
            }
        }

        // 创建一个 BorderPane 作为根节点
        BorderPane root = new BorderPane();
        root.setCenter(buttonGrid);

        // 为 BorderPane 设置背景图像
        setBackgroundImage1(root, "file:data/choose.jpg");

        Scene selectionScene = new Scene(root, 1200, 900);
        selectionWindow.setScene(selectionScene);
        selectionWindow.setResizable(false);
        selectionWindow.showAndWait();

        // Close the start frame when a player is selected
        primaryStage.close();
    }

    private void setBackgroundImage1(Pane pane, String imagePath) {
        Image backgroundImage = new Image(imagePath);
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        pane.setBackground(new Background(background));
    }
        /**
         * Creates a button for a player with the specified name and index.
         * It sets the button's size, style, and image.
         * It also adds event handlers for mouse-entered and action events.
         * When the button is clicked, it plays a sound effect, sets the selected car index,
         * creates a GamePlayer object, hides the start frame, and shows the level panel.
         *
         * @param playerName the name of the player
         * @param index      the index of the player
         * @return the created player button
         */
        private Button createPlayerButton(String playerName, int index) {
            ImageView imageView = new ImageView(new Image("file:data/player" + (index + 1) + ".png"));
            imageView.setFitWidth(450);
            imageView.setFitHeight(200);

            Label nameLabel = new Label(playerName);
            nameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
            nameLabel.setAlignment(Pos.CENTER);

            VBox buttonContent = new VBox(20);
            buttonContent.setAlignment(Pos.CENTER);
            buttonContent.getChildren().addAll(imageView, nameLabel);

            Button playerButton = new Button();
            playerButton.setGraphic(buttonContent);
            playerButton.setPrefSize(500, 250);
            playerButton.setStyle("-fx-background-color: transparent;");

            playerButton.setOnMouseEntered(e -> MusicPlayer.play("file:data/point button.wav"));
            playerButton.setOnAction(e -> {
                MusicPlayer.play("file:data/point button.wav");
                selectedCarIndex = index;
                System.out.println(playerName);
                ((Stage) playerButton.getScene().getWindow()).close();
                GamePlayer player1 = new GamePlayer(playerName);
                player1.setScoreList(new int[]{1, 2, -1, -1});

                primaryStage.close();

                Stage levelStage = new Stage();
                levelStage.setTitle("Level");
                levelStage.setResizable(false);
                LevelPanel levelPanel = new LevelPanel();
                Scene levelScene = new Scene(levelPanel, 1200, 900);
                levelStage.setScene(levelScene);
                levelStage.show();
            });

            return playerButton;
        }

    /**
     * Displays a modal window with the game description.
     * It creates a label with the description text, wraps the text, sets the style, and shows the window.
     */
    private void showAbout() {
        Stage aboutStage = new Stage();
        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.initOwner(primaryStage);
        aboutStage.setTitle("Game Description");

        String description = "Logical Road Builder is a puzzle game based on road construction. The player's goal is to create a connected road between a given start and end point by placing different road modules on the board so that the carts can pass through smoothly.\n\n" +
                "How to play:\n" +
                "1. Character Selection: Before the game starts, the player can select one of the different vehicle characters, each of which has its own unique appearance.\n" +
                "2. Level Design: The game consists of multiple levels, each with a different board layout and difficulty level. Players need to skillfully place road modules on the board according to the level to connect the start and end points.\n" +
                "3. Road Modules: The game provides a variety of road modules, such as straight lines, curves, intersections and so on. Players need to choose the right module to build the road according to the needs of the level.\n" +
                "4. Obstacles: There may be obstacles in some levels, players need to bypass these obstacles to build roads.\n" +
                "5. Fighting Monsters: When the player reaches the end of the road by building the road, different vehicles transform into different Transformers, according to the length of the path constructed before to determine the player's blood, through the ASWD four keys to control the movement of Transformers space bar to attack!";

        Label descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-text-fill: black; -fx-font-size: 18px;-fx-font-family: 'Arial';");

        Label aboutLabel = new Label("About");
        aboutLabel.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: black;");

        StackPane aboutPane = new StackPane(descriptionLabel);
        aboutPane.setPadding(new Insets(20, 35, 10, 35));

        // 将 "about" 标签放置在距离顶部0像素和左侧400像素的位置
        StackPane.setAlignment(aboutLabel, Pos.TOP_LEFT);
        StackPane.setMargin(aboutLabel, new Insets(0, 0, 0, 400));
        aboutPane.getChildren().add(aboutLabel);

        // 添加背景图
        Image backgroundImage = new Image("file:data/about.jpeg");
        BackgroundImage background = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        aboutPane.setBackground(new Background(background));

        Scene aboutScene = new Scene(aboutPane, 950, 600);
        aboutStage.setScene(aboutScene);
        aboutStage.showAndWait();
    }

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
