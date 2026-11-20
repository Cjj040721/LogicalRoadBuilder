package LogicalRoadBuilder;

/**
 * The Module class defines several arrays representing different module types and their configurations.
 * It initializes these arrays and provides methods to retrieve them.
 *
 * @author BJTU course team (public release anonymized)
 */
public class Module {
    private int[][] CorssArray1 = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 1, 0},
        {0, 1, 1, 0, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0},
        {0, 1, 1, 0, 1, 1, 0},
        {0, 1, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0}
    }; // Normal cross
    private int[][] CorssArray2 = new int[7][7]; // Rotated cross

    private int[][] ArcArray1 = new int[7][7]; // Normal arc
    private int[][] ArcArray2 = new int[7][7]; // Rotated arc
    private int[][] ArcArray3 = new int[7][7]; // Rotated arc
    private int[][] ArcArray4 = new int[7][7]; // Rotated arc
    private int[][] ArcArray5 = new int[7][7]; // Rotated arc
    private int[][] ArcArray6 = new int[7][7]; // Rotated arc
    private int[][] ArcArray7 = new int[7][7]; // Rotated arc
    private int[][] ArcArray8 = new int[7][7]; // Rotated arc

    private int[][] HyperbolaArray1 = new int[7][7]; // Normal hyperbola
    private int[][] HyperbolaArray2 = new int[7][7]; // Rotated hyperbola
    private int[][] HyperbolaArray3 = new int[7][7]; // Rotated hyperbola
    private int[][] HyperbolaArray4 = new int[7][7]; // Rotated hyperbola

    private int[][] startPoint = new int[7][7];

    int[][] endPoint = {
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] barrier = new int[7][7];

    /**
     * Constructor for the Module class.
     * Initializes the arrays representing different module types.
     */
    public Module() {
        int j;
        int i;
        // Define CrossArray2
        i = 3;
        for (j = 0; j <= 6; j++)
            CorssArray2[i][j] = 1;
        j = 3;
        for (i = 0; i <= 6; i++)
            CorssArray2[i][j] = 1;

        // Define ArcArray1 (counterclockwise)
        ArcArray1[3][6] = 1;
        ArcArray1[3][5] = 1;
        ArcArray1[3][4] = 1;
        ArcArray1[3][3] = 1;
        ArcArray1[4][3] = 1;
        ArcArray1[4][2] = 1;
        ArcArray1[5][2] = 1;
        ArcArray1[5][1] = 1;

        // Define ArcArray2
        ArcArray2[1][5] = 1;
        ArcArray2[2][5] = 1;
        ArcArray2[2][4] = 1;
        ArcArray2[3][4] = 1;
        ArcArray2[4][4] = 1;
        ArcArray2[4][3] = 1;
        ArcArray2[5][3] = 1;
        ArcArray2[6][3] = 1;

        // Define ArcArray3
        ArcArray3[0][3] = 1;
        ArcArray3[1][3] = 1;
        ArcArray3[2][3] = 1;
        ArcArray3[3][4] = 1;
        ArcArray3[4][4] = 1;
        ArcArray3[5][4] = 1;
        ArcArray3[3][3] = 1;
        ArcArray3[5][5] = 1;

        // Define ArcArray4
        ArcArray4[6][3] = 1;
        ArcArray4[5][3] = 1;
        ArcArray4[4][3] = 1;
        ArcArray4[3][3] = 1;
        ArcArray4[2][3] = 1;
        ArcArray4[2][2] = 1;
        ArcArray4[2][1] = 1;
        ArcArray4[1][1] = 1;

        // Define ArcArray5
        ArcArray5[0][3] = 1;
        ArcArray5[1][3] = 1;
        ArcArray5[2][3] = 1;
        ArcArray5[3][3] = 1;
        ArcArray5[3][2] = 1;
        ArcArray5[4][2] = 1;
        ArcArray5[5][2] = 1;
        ArcArray5[5][1] = 1;

        // Define ArcArray6
        ArcArray6[3][0] = 1;
        ArcArray6[3][1] = 1;
        ArcArray6[3][2] = 1;
        ArcArray6[3][3] = 1;
        ArcArray6[3][4] = 1;
        ArcArray6[2][4] = 1;
        ArcArray6[2][5] = 1;
        ArcArray6[1][5] = 1;

        // Define ArcArray7
        ArcArray7[1][1] = 1;
        ArcArray7[1][2] = 1;
        ArcArray7[2][2] = 1;
        ArcArray7[2][3] = 1;
        ArcArray7[3][3] = 1;
        ArcArray7[3][4] = 1;
        ArcArray7[3][5] = 1;
        ArcArray7[3][6] = 1;

        // Define ArcArray8
        ArcArray8[5][5] = 1;
        ArcArray8[5][4] = 1;
        ArcArray8[4][4] = 1;
        ArcArray8[4][3] = 1;
        ArcArray8[3][3] = 1;
        ArcArray8[3][2] = 1;
        ArcArray8[3][1] = 1;
        ArcArray8[3][0] = 1;

        // Define HyperbolaArray1 (counterclockwise)
        HyperbolaArray1[1][1] = 1;
        HyperbolaArray1[1][2] = 1;
        HyperbolaArray1[2][2] = 1;
        HyperbolaArray1[2][3] = 1;
        HyperbolaArray1[2][4] = 1;
        HyperbolaArray1[1][4] = 1;
        HyperbolaArray1[1][5] = 1;
        HyperbolaArray1[5][1] = 1;
        HyperbolaArray1[5][2] = 1;
        HyperbolaArray1[4][2] = 1;
        HyperbolaArray1[4][3] = 1;
        HyperbolaArray1[4][4] = 1;
        HyperbolaArray1[5][4] = 1;
        HyperbolaArray1[5][5] = 1;
        // Define HyperbolaArray2
        HyperbolaArray2[3][0] = 1;
        HyperbolaArray2[3][1] = 1;
        HyperbolaArray2[3][2] = 1;
        HyperbolaArray2[4][2] = 1;
        HyperbolaArray2[4][3] = 1;
        HyperbolaArray2[5][3] = 1;
        HyperbolaArray2[6][3] = 1;
        HyperbolaArray2[0][3] = 1;
        HyperbolaArray2[1][3] = 1;
        HyperbolaArray2[2][3] = 1;
        HyperbolaArray2[2][4] = 1;
        HyperbolaArray2[3][4] = 1;
        HyperbolaArray2[3][5] = 1;
        HyperbolaArray2[3][6] = 1;

        // Define HyperbolaArray3
        HyperbolaArray3[1][1] = 1;
        HyperbolaArray3[2][1] = 1;
        HyperbolaArray3[2][2] = 1;
        HyperbolaArray3[3][2] = 1;
        HyperbolaArray3[4][2] = 1;
        HyperbolaArray3[4][1] = 1;
        HyperbolaArray3[5][1] = 1;
        HyperbolaArray3[1][5] = 1;
        HyperbolaArray3[2][5] = 1;
        HyperbolaArray3[2][4] = 1;
        HyperbolaArray3[3][4] = 1;
        HyperbolaArray3[4][4] = 1;
        HyperbolaArray3[4][5] = 1;
        HyperbolaArray3[5][5] = 1;

        // Define HyperbolaArray4
        HyperbolaArray4[3][6] = 1;
        HyperbolaArray4[3][5] = 1;
        HyperbolaArray4[3][4] = 1;
        HyperbolaArray4[4][4] = 1;
        HyperbolaArray4[4][3] = 1;
        HyperbolaArray4[5][3] = 1;
        HyperbolaArray4[6][3] = 1;
        HyperbolaArray4[0][3] = 1;
        HyperbolaArray4[1][3] = 1;
        HyperbolaArray4[2][3] = 1;
        HyperbolaArray4[2][2] = 1;
        HyperbolaArray4[3][2] = 1;
        HyperbolaArray4[3][1] = 1;
        HyperbolaArray4[3][0] = 1;
    }

    /**
     * Returns the cross array based on the given cross type.
     *
     * @param corssType the type of cross (0 for normal, 1 for rotated)
     * @return the corresponding cross array
     */
    public int[][] getCorssArray(int corssType) {
        if (corssType == 0)
            return CorssArray1;
        else
            return CorssArray2;
    }

    /**
     * Returns the arc array based on the given arc type.
     *
     * @param arcType the type of arc (0 to 7)
     * @return the corresponding arc array
     */
    public int[][] getArcArray(int arcType) {
        switch (arcType) {
            case 0:
                return ArcArray1;
            case 1:
                return ArcArray2;
            case 2:
                return ArcArray3;
            case 3:
                return ArcArray4;
            case 4:
                return ArcArray5;
            case 5:
                return ArcArray6;
            case 6:
                return ArcArray7;
            default:
                return ArcArray8;
        }
    }

    /**
     * Returns the hyperbola array based on the given hyperbola type.
     *
     * @param hyperbolaType the type of hyperbola (0 to 3)
     * @return the corresponding hyperbola array
     */
    public int[][] getHyperbolaArray(int hyperbolaType) {
        switch (hyperbolaType) {
            case 0:
                return HyperbolaArray3;
            case 1:
                return HyperbolaArray2;
            case 2:
                return HyperbolaArray1;
            default:
                return HyperbolaArray4;
        }
    }

    /**
     * Returns the starting point array.
     *
     * @return the starting point array
     */
    public int[][] getStartingPonit() {
        return CorssArray2;
    }

    /**
     * Returns the ending point array.
     *
     * @return the ending point array
     */
    public int[][] getEndingPonit() {
        return endPoint;
    }
}
