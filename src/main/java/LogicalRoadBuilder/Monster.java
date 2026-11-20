package LogicalRoadBuilder;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The Monster class represents a monster in the game.
 * It controls the movement and behavior of the monster.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Monster implements Draw {
    private int x;
    private int y;
    private int width;
    private int height;
    public static int MonsterState = 20;
    Image imageMonster = new ImageIcon("file:data/Monster.PNG").getImage();
    Image imageWin = new ImageIcon("file:data/WIN.PNG").getImage();

    /**
     * Constructs a Monster object with default position and dimensions.
     */
    public Monster() {
        x = 750;
        y = 250;
        width = 300;
        height = 300;
    }

    /**
     * Moves the monster to a specific position.
     */
    public void move() {
        x = 677;
        y = 688;
    }

    /**
     * Keeps the monster within the specified bounds.
     */
    public void bounce() {
        // Control the bounds of the monster: x(400,800), y(0,800)
        if (x >= 670) {
            x = 650;
            System.out.println("move left");
        } else if (x <= 400) {
            x = 350;
            System.out.println("move right");
        } else if (y <= 0) {
            y = 100;
            System.out.println("move down");
        } else if (y >= 460) {
            y = 450;
            System.out.println("move up");
        }
    }

    /**
     * Moves the monster randomly within the specified bounds.
     */
    public void moveRandom() {
        Random r1 = new Random();
        int xx = r1.nextInt(801) - 400;
        Random r2 = new Random();
        int yy = r2.nextInt(1601) - 800;
        x += xx;
        y += yy;
        if(y<=0 || y>=460 || x<=400 || x>=670){
            this.bounce();
        }

        System.out.println("monster move randomly: (" + x + "," + y + ")");
    }

    /**
     * Sets the x-coordinate of the monster.
     *
     * @param X the x-coordinate to set
     */
    public void setX(int X) {
        x = X;
    }

    /**
     * Returns the x-coordinate of the monster.
     *
     * @return the x-coordinate of the monster
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the y-coordinate of the monster.
     *
     * @param Y the y-coordinate to set
     */
    public void setY(int Y) {
        y = Y;
    }

    /**
     * Returns the y-coordinate of the monster.
     *
     * @return the y-coordinate of the monster
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the state of the monster.
     *
     * @return the state of the monster
     */
    public int getMonsterState() {
        return MonsterState;
    }

    /**
     * Sets the state of the monster.
     *
     * @param MonsterState the state to set
     */
    public void setMonsterState(int MonsterState) {
        this.MonsterState = MonsterState;
    }

    /**
     * Checks if the monster intersects with an attack and reduces its state if so.
     *
     * @param a1 the attack to check intersection with
     */
    public void intersecAttack(Attack a1) {
        Rectangle m2 = new Rectangle(this.x, this.y, 50, 50);
        Rectangle a2 = new Rectangle(a1.getX(), a1.getY(), 50, 50);
        if (m2.intersects(a2)) {
            this.MonsterState -= 10;
            System.out.println();
        }
    }

    /**
     * Moves the monster to the left.
     */
    public void moveMLeft() {
        this.x = x - 20;
        System.out.println("monster: (" + x + "," + y + ").");
    }

    /**
     * Moves the monster to the right.
     */
    public void moveMRight() {
        this.x += 20;
        System.out.println("monster: (" + x + "," + y + ").");
    }

    /**
     * Moves the monster upwards.
     */
    public void moveMUp() {
        this.y -= 20;
        System.out.println("monster: (" + x + "," + y + ").");
    }

    /**
     * Moves the monster downwards.
     */
    public void moveMDown() {
        this.y += 20;
        System.out.println("monster: (" + x + "," + y + ").");
    }

    /**
     * Returns the image of the monster.
     *
     * @return the image of the monster
     */
    public Image getImage() {
        return imageMonster;
    }

    /**
     * Draws the monster image and displays its state on the graphics context.
     * If the monster state is less than or equal to 0, it draws the win image.
     *
     * @param g the graphics context to draw on
     */
    public void drawImage(Graphics g) {
        g.drawImage(imageMonster, this.x, this.y, width, height, null);
        Font font = new Font("Arial", Font.PLAIN, 24);
        g.setFont(font);
        g.drawString("Monster:" + MonsterState, 450, 24); // Display the monster blood message

        if (MonsterState <= 0) {
            g.drawImage(imageWin, 250, 250, 450, 250, null); // Display the win image
        }
    }
}
