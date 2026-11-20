package LogicalRoadBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

/**
 * The BattleFrame class is used to initialize the frame and key listener to control the movement of images.
 * It has been modified to integrate with JavaFX.
 *
 * @author BJTU course team (public release anonymized)
 */
public class BattleFrame extends JFrame {
    private BattlePanel panel;

    /**
     * Constructs a BattleFrame object and sets up the frame, key listener, and game objects.
     */
    public BattleFrame() {
        setTitle("Battle Game");
        setSize(1200, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Player p1 = new Player();
        Monster m1 = new Monster();
        Attack a1 = new Attack();
        FireBall f1 = new FireBall();
        BattlePanel panel = new BattlePanel(p1, m1, a1, f1);

        TimeControl tControl = new TimeControl(m1, f1, p1);
        tControl.startTimer();

          addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyD.add(e.getKeyCode());

                if (Player.PlayerState <= 0) {
                Driver.showStartFrame();
                SwingUtilities.getWindowAncestor(panel).dispose();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyD.remove(e.getKeyCode());
            }


            @Override
            public void keyTyped(KeyEvent e){
             KeyD.add(e.getKeyCode());
            if (p1.getPlayerState() ==0 || m1.getMonsterState() == 0 ) {
              e.consume(); // stop the key listener
              tControl.stopTimer();
             }
             else
            {
                if(KeyD.LEFT.use()){
              p1.moveLeft(); //control player to move left
              a1.setCor(p1.getX(), p1.getY()); //update the position of weapon to make it follow with player
              }
               else if(KeyD.RIGHT.use()){
              p1.moveRight();
              a1.setCor(p1.getX(), p1.getY());
              }
              else if(KeyD.UP.use()){
              p1.moveUp();
              a1.setCor(p1.getX(), p1.getY());
              }
              else if(KeyD.DOWN.use()){
              p1.moveDown();
              a1.setCor(p1.getX(), p1.getY());
              }
             else if(KeyD.Attack.use()){
                a1.setCor(p1.getX(), p1.getY());
                a1.moveFire(m1);
                m1.intersecAttack(a1);
              }
            p1.intersecFireBall(f1);
            panel.repaint();  //repaint to make images move
            }
           }

          });  //key listerner
        add(panel);
        setVisible(true);
    }

    /**
     * Returns the main panel of the BattleFrame.
     * This method is used to retrieve the JPanel object that represents the main panel of the BattleFrame.
     *
     * @return The JPanel object representing the main panel of the BattleFrame.
     */
    public JPanel getMainPanel() {
        return panel;
    }

    /**
     * The main method to start the battle frame.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BattleFrame frame = new BattleFrame();
            frame.setVisible(true);
        });
    }
}
