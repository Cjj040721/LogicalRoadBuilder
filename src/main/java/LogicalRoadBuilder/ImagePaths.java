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
 * This class is used to add images to the Board and modify the underlying 2D array.
 * The mouse click method is used here
 *
 * @author BJTU course team (public release anonymized)
 *
 */
public class ImagePaths
{
    GameUtil gameUtil=new GameUtil();
    Module module = new Module();
    private static List<ImageView> imageViewList = new ArrayList<>();
    public static final String  Cross1 = "file:images/cross1.png";
    public static final String  Cross2 = "file:images/Cross2.png";
    public static final String  Hyperbola1 = "file:images/Hyperbola1.png";
    public static final String  Hyperbola2 = "file:images/Hyperbola2.png";
    public static final String  Hyperbola3 = "file:images/Hyperbola3.png";
    public static final String  Hyperbola4 = "file:images/Hyperbola4.png";
    public static final String  Arc1 = "file:images/Arc1.png";
    public static final String  Arc2 = "file:images/Arc2.png";
    public static final String  Arc3 = "file:images/Arc3.png";
    public static final String  Arc4 = "file:images/Arc4.png";
    public static final String  Arc5 = "file:images/Arc5.png";
    public static final String  Arc6 = "file:images/Arc6.png";
    public static final String  Arc7 = "file:images/Arc7.png";
    public static final String  Arc8 = "file:images/Arc8.png";

    public static final String startImage = "file:images/start_image.png";
    public static final String endImage = "file:images/end.png";

    public static final String roadblock = "file:images/roadblock.png";
    public ImagePaths()
    {
    }
    /**
     * This function is used to set up a roadblock (indicating that there is no road here)
     * That is, barricades are present in all levels except level 1 where no barricades have been added
     */
    public void Roadblock(Pane pane, int x,Board board){
        ImageView imageView1 = new ImageView(new Image(roadblock));
        imageView1.setFitWidth(150);
        imageView1.setFitHeight(120);
        ImageView imageView2 = new ImageView(new Image(roadblock));
        imageView2.setFitWidth(150);
        imageView2.setFitHeight(120);
        ImageView imageView3 = new ImageView(new Image(roadblock));
        imageView3.setFitWidth(150);
        imageView3.setFitHeight(120);
        ImageView imageView4 = new ImageView(new Image(roadblock));
        imageView4.setFitWidth(150);
        imageView4.setFitHeight(120);
        ImageView imageView5 = new ImageView(new Image(roadblock));
        imageView5.setFitWidth(150);
        imageView5.setFitHeight(120);

        if(x==2){
            imageView1.setLayoutX(229);
            imageView1.setLayoutY(10);
            pane.getChildren().add(imageView1);
        }
        if(x==3){
            imageView1.setLayoutX(229);
            imageView1.setLayoutY(10);
            pane.getChildren().add(imageView1);

            imageView3.setLayoutX(0);
            imageView3.setLayoutY(251);
            pane.getChildren().add(imageView3);
        }
        if(x==4){

            imageView1.setLayoutX(229);
            imageView1.setLayoutY(10);
            pane.getChildren().add(imageView1);

            imageView2.setLayoutX(229);
            imageView2.setLayoutY(117);
            pane.getChildren().add(imageView2);

            imageView3.setLayoutX(0);
            imageView3.setLayoutY(251);
            pane.getChildren().add(imageView3);

            imageView4.setLayoutX(113);
            imageView4.setLayoutY(251);
            pane.getChildren().add(imageView4);

            imageView5.setLayoutX(239);
            imageView5.setLayoutY(370);
            pane.getChildren().add(imageView5);

        }

    }
    /**
     * Adding the Start Module
     */
    public void addStartImage(Pane pane, int po,Board board, int Ix,int Iy) //0:start 1:end
    {
        String imagePath=imagePath(4,0);
        ImageView imageView = new ImageView(new Image(imagePath));

           imageView.setLayoutX(Ix);
           imageView.setLayoutY(Iy);

            imageView.setFitWidth(130);
            imageView.setFitHeight(130);

            board.setBoard(module.getStartingPonit(), po);
            board.MotherBoard(board);
            board.getBoard();
        pane.getChildren().add(imageView);
    }
    /**
     * Adding the end Module
     */
    public void addEndImage(Pane pane, int po,Board board,int Ix,int Iy) //0:start 1:end
    {
        String imagePath=imagePath(4,1);
        ImageView imageView = new ImageView(new Image(imagePath));
         imageView.setLayoutX(Ix);
             imageView.setLayoutY(Iy);

            imageView.setFitWidth(130);
            imageView.setFitHeight(130);

            board.setBoard(module.getEndingPonit(), po);
                board.MotherBoard(board);
                board.getBoard();

        pane.getChildren().add(imageView);
    }
    /**
     * This function serves to add the road block after left mouse click on the plate
     * This function also assumes the rotation of the image (both visual rotation and underlying rotation of the array)
     * This module also takes on the function of deleting modules
     *In addition, if you want to delete a module, you have to point it at the board!
     */
    public void addImage(Pane pane,String imagePath, int po,Board board)
    {

        ImageView imageView = new ImageView(new Image(imagePath));

        if (imageView.getImage().getUrl().equals(Cross1)){
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        }
            //Hyperbola1
        if (imageView.getImage().getUrl().equals(Hyperbola1)){
        imageView.setFitWidth(130);
        imageView.setFitHeight(130);
        }
        //Arc1
        if (imageView.getImage().getUrl().equals(Arc1)){
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        }
        //Find the location where the module needs to be added!
        if(po==1){
             imageView.setLayoutX(0);
             imageView.setLayoutY(0);
        }else if(po==2){
            imageView.setLayoutX(126);
            imageView.setLayoutY(0);
        }else if(po == 3){
            imageView.setLayoutX(249);
            imageView.setLayoutY(0);
        }else if(po == 4){
            imageView.setLayoutX(375);
            imageView.setLayoutY(0);
        }else if(po == 5){
            imageView.setLayoutX(0);
            imageView.setLayoutY(127);
        }else if(po == 6){
            imageView.setLayoutX(126);
            imageView.setLayoutY(127);
        }else if(po == 7){
            imageView.setLayoutX(249);
            imageView.setLayoutY(127);
        }else if(po == 8){
            imageView.setLayoutX(375);
            imageView.setLayoutY(127);
        }else if(po == 9){
            imageView.setLayoutX(0);
            imageView.setLayoutY(255);
        }else if(po == 10){
            imageView.setLayoutX(126);
            imageView.setLayoutY(255);
        }else if(po == 11){
            imageView.setLayoutX(249);
            imageView.setLayoutY(255);
        }else if(po == 12){
            imageView.setLayoutX(375);
            imageView.setLayoutY(255);
        }else if(po == 13){
            imageView.setLayoutX(0);
            imageView.setLayoutY(380);
        }else if(po == 14){
            imageView.setLayoutX(126);
            imageView.setLayoutY(380);
        }else if(po == 15){
            imageView.setLayoutX(249);
            imageView.setLayoutY(380);
        }else if(po == 16){
            imageView.setLayoutX(375);
            imageView.setLayoutY(380);
        }
         // Add a mouse click event listener
        imageView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY){
            // Change image when clicking on it
            if (imageView.getImage().getUrl().equals(Cross1)) {

                imageView.setImage(new Image(Cross2));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getCorssArray(1), po);
                board.MotherBoard(board);
                board.getBoard();

            } else if (imageView.getImage().getUrl().equals(Cross2)) {

                imageView.setImage(new Image(Cross1));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getCorssArray(0), po);
                board.MotherBoard(board);
                board.getBoard();

            }
            if(imageView.getImage().getUrl().equals(Hyperbola1)){

                imageView.setImage(new Image(Hyperbola2));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getHyperbolaArray(1), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Hyperbola2)){

                imageView.setImage(new Image(Hyperbola3));
                imageView.setFitWidth(130);
                imageView.setFitHeight(130);
                board.setBoard(module.getHyperbolaArray(2), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Hyperbola3)){

                imageView.setImage(new Image(Hyperbola4));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getHyperbolaArray(3), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Hyperbola4)){

                imageView.setImage(new Image(Hyperbola1));
                imageView.setFitWidth(130);
                imageView.setFitHeight(130);
                board.setBoard(module.getHyperbolaArray(0), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc1)){

                imageView.setImage(new Image(Arc2));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(1), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc2)){

                imageView.setImage(new Image(Arc3));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(2), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc3)){

                imageView.setImage(new Image(Arc4));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(3), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc4)){

                imageView.setImage(new Image(Arc5));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(4), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc5)){

                imageView.setImage(new Image(Arc6));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(5), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc6)){

                imageView.setImage(new Image(Arc7));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(6), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc7)){

                imageView.setImage(new Image(Arc8));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(7), po);
                board.MotherBoard(board);
                board.getBoard();

            }else if(imageView.getImage().getUrl().equals(Arc8)){

                imageView.setImage(new Image(Arc1));
                imageView.setFitWidth(120);
                imageView.setFitHeight(120);
                board.setBoard(module.getArcArray(0), po);
                board.MotherBoard(board);
                board.getBoard();

            }
            MusicPlayer.play("file:data/point button.wav");
        }else if (event.getButton() == MouseButton.SECONDARY) {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem clearMenuItem = new MenuItem("Clear");
            clearMenuItem.setOnAction(e -> {
            pane.getChildren().removeAll(imageViewList);
            imageViewList.clear();
            board.RemoveAllModules();
            board.MotherBoard(board);

            board.setBoard(module.getStartingPonit(), gameUtil.BeginPo);
            board.setBoard(module.getEndingPonit(), gameUtil.EndPo);
            MusicPlayer.play("file:data/point button.wav");
            System.out.println("All ImageViews removed");
        });
        contextMenu.getItems().add(clearMenuItem);
        contextMenu.show(pane, event.getScreenX(), event.getScreenY());
        }
        });


        pane.getChildren().add(imageView);
        imageViewList.add(imageView);
    }

    /**
     * moduleType is used to determine whether cross(1)/arc(2)/Hyperbola(3)/start,end(4).
     * Specialtype is used to determine the type (direction) of each determined type.
     *
     */
    public String imagePath(int moduleType,int Specialtype)
    {
        if(moduleType==1)
        {
            if(Specialtype==0)
                return Cross1;
            if(Specialtype==1)
                return Cross2;
        }else if(moduleType==2)
        {
            if(Specialtype==0){
                return Arc1;
            }else if(Specialtype==1){
                return Arc2;
            }else if(Specialtype==2){
                return Arc3;
            }else if(Specialtype==3){
                return Arc4;
            }else if(Specialtype==4){
                return Arc5;
            }else if(Specialtype==5){
                return Arc6;
            }else if(Specialtype==6){
                return Arc7;
            }else if(Specialtype==7){
                return Arc8;
            }
        }else if(moduleType==3)
        {
            if(Specialtype==0){
                return Hyperbola1;
            }else if(Specialtype==1){
                return Hyperbola2;
            }else if(Specialtype==2){
                return Hyperbola3;
            }else if(Specialtype==3){
                return Hyperbola4;
            }
        }
        if(moduleType==4)
        {
            if(Specialtype==0)
                return startImage;
            else
                return endImage;
        }
        return "";
    }
}
