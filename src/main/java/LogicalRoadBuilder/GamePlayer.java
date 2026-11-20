package LogicalRoadBuilder;

import java.util.Arrays;

/**
 * The GamePlayer class represents player information in a game.
 * It stores the player's name and their scores for different levels.
 *
 * @author BJTU course team (public release anonymized)
 */
public class GamePlayer {

    public int[] scoreList; // An array to store the player's scores for different levels.
    public String name; // The name of the player.

    /**
     * Constructs a new GamePlayer object with the specified name.
     * Initializes the score list with a size of 4 (for 4 levels).
     *
     * @param name The name of the player.
     */
    public GamePlayer(String name) {
        this.scoreList = new int[4];
        this.name = name;
    }

    /**
     * Returns a string representation of the GamePlayer object.
     * The string includes the player's score list and name.
     *
     * @return A string representation of the GamePlayer object.
     */
    @Override
    public String toString() {
        return "GamePlayer{" +
                "scoreList=" + Arrays.toString(scoreList) +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Returns the score list of the player.
     *
     * @return The score list of the player.
     */
    public int[] getScoreList() {
        return scoreList;
    }

    /**
     * Sets the score list of the player.
     *
     * @param scoreList The new score list for the player.
     */
    public void setScoreList(int[] scoreList) {
        this.scoreList = scoreList;
    }

    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name The new name for the player.
     */
    public void setName(String name) {
        this.name = name;
    }
}
