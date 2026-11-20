package LogicalRoadBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * The BattlePanel class initializes the panel with drawImage methods, allowing different images to be displayed on the BattleFrame.
 *
 * @author BJTU course team (public release anonymized)
 */
public class BattlePanel extends JPanel {

    private Draw[] draws; // Elements need to draw
    private Image image; // Buffer
    private Image imageBC = new ImageIcon("file:data/BC2.png").getImage();

    /**
     * Constructs a BattlePanel object with the specified Draw objects.
     *
     * @param draws the Draw objects to be rendered on the panel
     */
    public BattlePanel(Draw... draws) {
        this.draws = draws;
    }

    /**
     * Draws the buffered image to avoid image stuttering.
     */
    private void drawBufferedImage() {
        image = createImage(this.getWidth(), this.getHeight());
        if (image != null) {
            Graphics g = image.getGraphics();
            g.drawImage(imageBC, 0, 0, this.getWidth(), this.getHeight(), this);
            for (Draw draw : this.draws) {
                draw.drawImage(g);
            }
            g.dispose(); // Release the context and system resources used by this graphics object
        }
    }

    /**
     * Paints the component by drawing the buffered image.
     *
     * @param g the Graphics object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBufferedImage();
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}
