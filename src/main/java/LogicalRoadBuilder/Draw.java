package LogicalRoadBuilder;

import java.awt.*;

/**
 * The Draw interface defines a contract for classes that need to draw images.
 *
 * @author BJTU course team (public release anonymized)
 */
public interface Draw {
    /**
     * Draws an image using the provided Graphics object.
     *
     * @param g the Graphics object used for drawing
     */
    void drawImage(Graphics g);
}
