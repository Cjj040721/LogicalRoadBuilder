package LogicalRoadBuilder;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TimeControl class manages the movement of monsters, fireballs interactions based on a timer.
 *
 * @author BJTU course team (public release anonymized)
 */
public class TimeControl {
    private Timer timer;
    private Monster monster;
    private FireBall fireBall;
    private Player player;

    /**
     * Constructs a TimeControl object with the specified monster, fireball, and player.
     *
     * @param m1 the monster to control
     * @param f1 the fireball to control
     * @param p1 the player to interact with
     */
    public TimeControl(Monster m1, FireBall f1, Player p1) {
        this.monster = m1;
        this.fireBall = f1;
        this.player = p1;

        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m1.moveRandom(); // Make monster move randomly
                f1.moveFireBall(player); // Fireball moves as well
                f1.setCor(m1.getX(), m1.getY()); // Set the coordinates of the fireball to match the monster's position
                System.out.println("Time action called");
            }
        }); // Time control of the movement of fireball and monster
    }

    /**
     * Starts the timer for controlling the movement of monsters and fireballs.
     */
    public void startTimer() {
        timer.start();
        System.out.println("Time control started");
    }

    /**
     * Stops the timer and halts the movement of monsters and fireballs.
     */
    public void stopTimer() {
        timer.stop();
        System.out.println("Time control stopped");
    }
}
