package LogicalRoadBuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.List;
import javafx.application.Platform;
import javax.swing.JFrame;
import javafx.embed.swing.SwingNode;
import javax.swing.SwingUtilities;
/**
 * This class is the main function of the game interface, used to call various functions in other classes
 * Here is the entry point to call the board interface, including the creation of the window, mouse events, Creating the battle window
 * Write the click on the module rotation event to the ImagePaths class
 * Right click saves important functions, i.e. adding modules, finding paths! But note! The function to delete (or rather clear) modules is put into ImagePaths
 *
 * @author BJTU course team (public release anonymized)
 */

public class Driver extends Application {

    int po = -1;

    Board board = new Board();
    Module module = new Module();
    GameUtil gameUtil = new GameUtil();
    PathfindingAlgorithm pathfindingAlgorithm=new PathfindingAlgorithm();
    ImagePaths ImagePaths= new ImagePaths();
    DecorativePictures DecorativePictures=new DecorativePictures();

    Image boardImage = new Image("file:data/board.jpg");

    int[][] array = new int[7][7];

    public static StartFrame startFrame;
    /**
     * for loading the game window
     * Used to call functions related to adding modules, deleting modules, routing algorithms and trolley movement, etc.
     */

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        ImageView imageView = new ImageView(boardImage);
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        pane.getChildren().add(imageView);

        //Setting up the start and end points
        ImagePaths.addStartImage(pane,gameUtil.BeginPo,board,gameUtil.StartX,gameUtil.StartY);
        ImagePaths.addEndImage(pane,gameUtil.EndPo,board,gameUtil.EndX,gameUtil.EndY);

        ImagePaths.Roadblock(pane,gameUtil.Level,board);

        DecorativePictures.addImage(pane);
        imageView.setOnMouseClicked(event -> {
                 if (event.getButton() == MouseButton.SECONDARY) {
                System.out.println("Mouse clicked with right button");
                MusicPlayer.play("file:data/point button.wav");
                gameUtil.MOUSE_X = (int) event.getX();
                gameUtil.MOUSE_Y = (int) event.getY();
                po = gameUtil.getMousePosition(gameUtil.MOUSE_X, gameUtil.MOUSE_Y);

                ContextMenu contextMenu = new ContextMenu();
                MenuItem menuItem1 = new MenuItem("-> Adding modules to the Board");
                menuItem1.setOnAction(e -> {
                    if (gameUtil.getMousePosition(gameUtil.MOUSE_X,gameUtil.MOUSE_Y) != -1) {
                        ContextMenu subMenu = new ContextMenu();
                        MenuItem subMenuItem1 = new MenuItem("Cross");
                        subMenuItem1.setOnAction(subEvent -> {
                            ImagePaths.addImage(pane,ImagePaths.imagePath(1,0),po,board);
                            board.setBoard(module.getCorssArray(0), po);
                            board.MotherBoard(board);
                            MusicPlayer.play("file:data/point button.wav");
                            System.out.println("Cross added");
                        });
                        subMenu.getItems().add(subMenuItem1);

                        MenuItem subMenuItem2 = new MenuItem("Hyperbola");
                        subMenuItem2.setOnAction(subEvent -> {
                            ImagePaths.addImage(pane,ImagePaths.imagePath(3,0),po,board);
                            board.setBoard(module.getHyperbolaArray(0), po);
                            board.MotherBoard(board);
                            MusicPlayer.play("file:data/point button.wav");
                            System.out.println("Hyperbola added");
                        });
                        subMenu.getItems().add(subMenuItem2);

                        MenuItem subMenuItem3 = new MenuItem("Arc");
                        subMenuItem3.setOnAction(subEvent -> {
                            ImagePaths.addImage(pane,ImagePaths.imagePath(2,0 ),po,board);
                            board.setBoard(module.getArcArray(0), po);
                            board.MotherBoard(board);
                            MusicPlayer.play("file:data/point button.wav");
                            System.out.println("Arc added");
                        });
                        subMenu.getItems().add(subMenuItem3);

                        subMenu.show(imageView, event.getScreenX(), event.getScreenY());
                    } else {
                        System.out.println("Error! You need to click onto the board");
                        System.out.println("PO: " + gameUtil.getMousePosition((int) event.getX(), (int) event.getY()));
                    }
                });

                MenuItem menuItem4 = new MenuItem("Start the game");
                menuItem4.setOnAction(e -> {
                    List<PathfindingAlgorithm.Node> shortestPath = PathfindingAlgorithm.bfs(board.getBoard(), gameUtil.CarBeginX, gameUtil.CarBeginY, gameUtil.CarEndX, gameUtil.CarEndY);
                MusicPlayer.play("file:data/point button.wav");
                if (shortestPath != null) {
                    System.out.println("The shortest path is:"+PathfindingAlgorithm.s);
                    CarView carView = new CarView(shortestPath,pane);
                    carView.start(primaryStage);
                    ImageView imageView1 = new ImageView(new Image("Images/Congratulation.png"));
                    imageView1.setFitWidth(600);
                    imageView1.setFitHeight(200);
                    imageView1.setLayoutX(150);
                    imageView1.setLayoutY(150);
                    pane.getChildren().add(imageView1);
                    //Nesting Swing into JAVAFX
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(7), event2 -> {
                        SwingNode swingNode = new SwingNode();
                        SwingUtilities.invokeLater(() -> {
                        BattleFrame frame = new BattleFrame();
                        swingNode.setContent(frame.getMainPanel());
                        });
                        primaryStage.close();

                    }));
                    timeline.play();
                    }

                });
                contextMenu.getItems().addAll(menuItem1, menuItem4);
                contextMenu.show(imageView, event.getScreenX(), event.getScreenY());
            }
        });

        Scene scene = new Scene(pane, 800, 550);
        primaryStage.setTitle("Logical Road Builder Game - ET Group 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Shows the start frame of the game.
     */
    public static void showStartFrame() {
        Platform.runLater(() -> {
            Stage startStage = new Stage();
            StartFrame startFrame = new StartFrame();
            startFrame.start(startStage);
        });
    }

}
