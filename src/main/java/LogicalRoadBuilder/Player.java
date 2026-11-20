package LogicalRoadBuilder;

import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

/**
 * The Player class represents a player in the game.
 * It allows the player to be controlled and moved using keys.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Player implements Draw {
    BattleFrame battleFrame;
    private int x = 150;
    private int y = 200;
    private int width = 400;
    private int height = 400;
    public static int PlayerState = 100-PathfindingAlgorithm.s; // Initialize the player state from the road, set to 10 for testing
    // Final index to choose the character
    final int idx = 0;
    // Get the images of 4 different characters
    Image imageA = ImageController.Plays[StartFrame.selectedCarIndex];
    Image imageB = new ImageIcon().getImage();
    Image imageC = new ImageIcon().getImage();
    Image imageD = new ImageIcon().getImage();
    Image image2 = new ImageIcon("file:data/GameOver.PNG").getImage();

    /**
     * Constructs a Player object with the specified BattleFrame.
     *
     * @param battleFrame the BattleFrame associated with the player
     */
    public Player() {
    }

    /**
     * Sets the x-coordinate of the player.
     *
     * @param X the x-coordinate to set
     */
    public void setX(int X) {
        x = X;
    }

    /**
     * Returns the x-coordinate of the player.
     *
     * @return the x-coordinate of the player
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the y-coordinate of the player.
     *
     * @param Y the y-coordinate to set
     */
    public void setY(int Y) {
        y = Y;
    }

    /**
     * Returns the y-coordinate of the player.
     *
     * @return the y-coordinate of the player
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the width of the player.
     *
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the width of the player.
     *
     * @return the width of the player
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the height of the player.
     *
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the height of the player.
     *
     * @return the height of the player
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the state of the player.
     *
     * @return the state of the player
     */
    public int getPlayerState() {
        return PlayerState;
    }

    /**
     * Sets the state of the player.
     *
     * @param PlayerState the state to set
     */
    public void setPlayerState(int PlayerState) {
        this.PlayerState = PlayerState;
    }

    /**
     * Moves the player to the left by 20 units.
     */
    public void moveLeft() {
        this.x = x - 20;
        System.out.println("player: (" + x + "," + y + ").");
    }

    /**
     * Moves the player to the right by 20 units.
     */
    public void moveRight() {
        this.x += 20;
        System.out.println("player: (" + x + "," + y + ").");
    }

    /**
     * Moves the player upwards by 20 units.
     */
    public void moveUp() {
        this.y -= 20;
        System.out.println("player: (" + x + "," + y + ").");
    }

    /**
     * Moves the player downwards by 20 units.
     */
    public void moveDown() {
        this.y += 20;
        System.out.println("player: (" + x + "," + y + ").");
    }

    /**
     * Checks if the player is attacked by a fireball and updates the player's state accordingly.
     *
     * @param f2 the fireball to check intersection with
     */
    public void intersecFireBall(FireBall f2) {
        Rectangle p2 = new Rectangle(this.x, this.y, 50, 50);
        Rectangle f3 = new Rectangle(f2.getX(), f2.getY(), 50, 50);
        if (p2.intersects(f3)) {
            this.PlayerState = PlayerState - 10;
            System.out.println("Player state -10;");
        }
    }

    /**
     * Returns the image of the player character.
     *
     * @return the image of the player character
     */
    public Image getImageA() {
        return imageA;
    }

    /**
     * Draws the player image, displays the player state, and handles game over conditions.
     *
     * @param g the Graphics object used for drawing
     */
    public void drawImage(Graphics g) {
        if (idx == 0) {
            g.drawImage(imageA, this.x, this.y, width, height, null);
        } else if (idx == 1) {
            g.drawImage(imageB, this.x, this.y, width, height, null);
        } else if (idx == 2) {
            g.drawImage(imageC, this.x, this.y, width, height, null);
        } else if (idx == 3) {
            g.drawImage(imageD, this.x, this.y, width, height, null);
        } // Draw different images of players chosen by users

        // Write the message of player state:
        if(PlayerState >=0 ){
            Font font = new Font("Arial", Font.PLAIN, 24); // Set the font size
        g.setFont(font);
        g.drawString("Player:" + PlayerState, 250, 24);
        } // display the state when the state is larger then 0
        else{
         Font font = new Font("Arial", Font.PLAIN, 24); // Set the font size
         g.setFont(font);
         g.drawString("Player:" + 0, 250, 24);

        }//if the state smaller than 0, only display 0


        if (PlayerState <= 0) {
            g.drawImage(image2, 200, 200, 450, 250, null); // The final stage: game over
        }
    }
}
