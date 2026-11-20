package LogicalRoadBuilder;

import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

/**
 * The Attack class represents the movement of a weapon with the player and attacks the monster.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Attack extends Player {
    private int x;
    private int y;
    private int width;
    private int height;
    private int state;

    Image image = new ImageIcon("file:data/Attack.PNG").getImage();

    /**
     * Constructs an Attack object with the specified player.
     *
     * @param player the player to inherit properties from
     */
    public Attack() {
        this.x = super.getX();
        this.y = super.getY();
        width = 100;
        height = 100;
        this.state = super.getPlayerState();
    }

    /**
     * Checks whether the attack intersects with the monster.
     *
     * @param monster the monster to check intersection with
     * @return true if the attack intersects with the monster, false otherwise
     */
    public boolean insecChe(Monster monster) {
        Rectangle m1 = new Rectangle(monster.getX(), monster.getY(), 50, 50);
        Rectangle a1 = new Rectangle(this.x, this.y, 50, 50);
        if (!m1.intersects(a1)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Starts the attack movement along the x-axis until it intersects with the monster or reaches a maximum x-coordinate.
     *
     * @param monster the monster to move the attack towards
     */
    public void moveFire(Monster monster){
       //y=super.getY();
      while(!this.insecChe(monster) && x<=650){
        x += 20;
        System.out.println("weapon position: ("+x+","+y+")");
      }

     }

    /**
     * Sets the x-coordinate of the attack.
     *
     * @param x the x-coordinate to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the x-coordinate of the attack.
     *
     * @return the x-coordinate of the attack
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the y-coordinate of the attack.
     *
     * @param y the y-coordinate to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the y-coordinate of the attack.
     *
     * @return the y-coordinate of the attack
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the coordinates of the attack.
     *
     * @param x the x-coordinate to set
     * @param y the y-coordinate to set
     */
    public void setCor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the image of the attack.
     *
     * @return the image of the attack
     */
    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Draws the attack image.
     *
     * @param g the Graphics object used for drawing
     */
    public void drawImage(Graphics g) {
        g.drawImage(this.image, this.x, this.y, width, height, null);
    }
}
