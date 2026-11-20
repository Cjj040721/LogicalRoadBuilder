package LogicalRoadBuilder;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

/**
 * The FireBall class represents a fireball that is automatically shot by a monster every 3 seconds.
 *
 * @author BJTU course team (public release anonymized)
 */
public class FireBall extends Monster implements Draw {
    private int x;
    private int y;
    private int width;
    private int height;
    private int state;
    private boolean getIntersection;
    Image imageFire = new ImageIcon("file:data/Damage.PNG").getImage();

    /**
     * Constructs a FireBall object with default values.
     */
    public FireBall() {
        this.x = super.getX();
        this.y = super.getY();
        width = 100;
        height = 100;
        this.state = super.getMonsterState();
    }

    /**
     * Checks whether the fireball intersects with the player.
     *
     * @param player the player to check intersection with
     * @return true if the fireball intersects with the player, false otherwise
     */
    public boolean insecChe(Player player) {
        Rectangle p1 = new Rectangle(player.getX(), player.getY(), 100, 100);
        Rectangle f1 = new Rectangle(this.x, this.y, 100, 100);
        if (!f1.intersects(p1)) {
            this.getIntersection = false;
            return false;
        } else {
            this.getIntersection = true;
            return true;
        }
    }

    /**
     * Moves the fireball towards the player until it reaches the bound or intersects with the player.
     *
     * @param player the player to move the fireball towards
     */
    public void moveFireBall(Player player) {
        while (this.insecChe(player) == false && x > 0) {
            x -= 40;
            setCor(x, y);
            System.out.println("Fireball x: " + x + " Fireball move");
        }
    }

    /**
     * Sets the x-coordinate of the fireball.
     *
     * @param x the x-coordinate to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the x-coordinate of the fireball.
     *
     * @return the x-coordinate of the fireball
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the y-coordinate of the fireball.
     *
     * @param y the y-coordinate to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the y-coordinate of the fireball.
     *
     * @return the y-coordinate of the fireball
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the coordinates of the fireball with a condition.
     *
     * @param x the x-coordinate to set
     * @param y the y-coordinate to set
     */
    public void setCor(int x, int y) {
        if (x <= 0 || getIntersection == false) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Returns the image of the fireball.
     *
     * @return the image of the fireball
     */
    public Image getImage() {
        return imageFire;
    }

    /**
     * Draws the fireball image if the state is greater than or equal to 0.
     *
     * @param g the Graphics object used for drawing
     */
    public void drawImage(Graphics g) {
        if (state >= 0) {
            g.drawImage(this.imageFire, this.x, this.y, width, height, null);
        }
    }
}
