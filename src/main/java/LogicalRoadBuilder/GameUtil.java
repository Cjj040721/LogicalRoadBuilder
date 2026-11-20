package LogicalRoadBuilder;


/**
 * GameUtil is a toolkit to hold static public variables such as mouse coordinates, the position of the board (1-16), the coordinates of the start and end modules, and the start coordinates of the underlying array
 * Getting the position of a mouse click and determining whether it hits the board, and determining the type of module currently stored on the board.
 *
 * @author BJTU course team (public release anonymized)
 *
 */
public class GameUtil
{

    static int MOUSE_X;
    static int MOUSE_Y;
    static int [][]DeleteModule=new int[7][7];

    /**
     * This is used to control the position of the start/end module
     */
    public static int StartX;
    public static int StartY;
    public static int EndX;
    public static int EndY;
    /**
     * This is used to set the position of the board (1-16)
     */
    public static int BeginPo;
    public static int EndPo;

    /**
     * Used to set the coordinates for the pathfinding algorithm
     */
    public static int CarBeginX;
    public static int CarBeginY;
    public static int CarEndX;
    public static int CarEndY;

    public static int Level;


    public static int [][] startPoint = {{0,0,0,1,0,0},{0,0,0,1,0,0},{0,0,0,1,0,0},
                              {0,0,0,1,0,0}, {0,0,0,1,0,0},{0,0,0,1,0,0}};
    public static int [][] endPoint = {{0,0,0,1,0,0,0},{0,1,1,1,1,1,0},{0,0,0,1,0,0,0},
                             {1,1,1,1,1,1,1},{0,0,0,1,0,0,0},{0,1,1,1,1,1,0},
                             {0,0,0,1,0,0,0}};
        /**
         * Input MX,MY (horizontal and vertical coordinates of the mouse)
         * This function is used to determine whether the mouse is pointing at the board or not
         * int po=-1; should be set to -1 at the beginning to represent that the mouse is not clicked in the correct position
         * Use the condition to judge where the mouse clicks
         * if mouse click position on the board, return normal po (1-16)
         * This function also fulfils the duty of determining whether the mouse is on the board or not
         * else return po=-1
         */
    public int getMousePosition(int Mx,int My){
        int po=-1;
        int parameter=110;
        if(My>=16&&My<=16+parameter){
        if(Mx>=16&&Mx<=16+parameter)
            po=1;
        if(Mx>=137&&Mx<=137+parameter)
            po=2;
        if(Mx>=252&&Mx<=252+parameter)
            po=3;
        if(Mx>=373&&Mx<=373+parameter)
            po=4;
        }

        if(My>=137&&My<=137+parameter){
        if(Mx>=16&&Mx<=16+parameter)
            po=5;
        if(Mx>=137&&Mx<=137+parameter)
            po=6;
        if(Mx>=252&&Mx<=252+parameter)
            po=7;
        if(Mx>=373&&Mx<=373+parameter)
            po=8;
        }

        if(My>=252&&My<=252+parameter){
        if(Mx>=16&&Mx<=16+parameter)
            po=9;
        if(Mx>=137&&Mx<=137+parameter)
            po=10;
        if(Mx>=252&&Mx<=252+parameter)
            po=11;
        if(Mx>=373&&Mx<=373+parameter)
            po=12;
        }

        if(My>=373&&My<=373+parameter){
        if(Mx>=16&&Mx<=16+parameter)
            po=13;
        if(Mx>=137&&Mx<=137+parameter)
            po=14;
        if(Mx>=252&&Mx<=252+parameter)
            po=15;
        if(Mx>=373&&Mx<=373+parameter)
            po=16;
        }
        return po;
    }

}
