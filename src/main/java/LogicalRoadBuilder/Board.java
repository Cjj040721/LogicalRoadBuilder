package LogicalRoadBuilder;

import java.util.Arrays;
/**
 * Initialise the Board
 * @author BJTU course team (public release anonymized)
 *
 */
public class Board
{
    private int[][] BroadArray={
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0},
    {0,0,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,0,0},
    {0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0},
    {0,0,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,0,0},
    {0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0},
    {0,0,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0,0,0},
    {0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

    public Board()
    {
    }
    /**
     * Used to clear the board state, need to be paired with MotherBoard
     * so that the board from the new back to the initialisation of the
     */
    public void RemoveAllModules (){
        for (int i = 0; i < BroadArray.length; i++) {
        Arrays.fill(BroadArray[i], 0);
        }
    }
    /**
     * The MotherBoard function is actually designed for removing/adding modules, because removing a module directly reduces arr[7][7] all the way down to 0
     * Adding a module also changes the initial 1's to 0's.
     * Therefore, the board itself needs to return to a fixed 1 after the reversion to 0.
     *
     * Note: Every time you add/remove a module, you must call MotherBoard to restore the initial value, if you don't call this function, it will lead to an error in judgement of ModuleType() in GameUtil class
     * (Will there be optimisation? If you don't call this function to restore the initial value, it will lead to the problem that the ModuleType() in GameUtil class will be judged wrongly * (Is there any optimisation?)! Must use this function
     */
    public void MotherBoard(Board Board){
    BroadArray[3][6]=1; BroadArray[3][12]=1;BroadArray[3][18]=1;
    BroadArray[5][5]=1;BroadArray[5][6]=1;BroadArray[5][7]=1;BroadArray[5][11]=1;BroadArray[5][12]=1;BroadArray[5][13]=1;BroadArray[5][17]=1;BroadArray[5][18]=1;BroadArray[5][19]=1;
    BroadArray[6][3]=1;BroadArray[6][5]=1;BroadArray[6][6]=1;BroadArray[6][7]=1;BroadArray[6][9]=1;BroadArray[6][11]=1;BroadArray[6][12]=1;BroadArray[6][13]=1;BroadArray[6][15]=1;BroadArray[6][17]=1;BroadArray[6][18]=1;BroadArray[6][19]=1;BroadArray[6][21]=1;
    BroadArray[7][5]=1;BroadArray[7][6]=1;BroadArray[7][7]=1;BroadArray[7][11]=1;BroadArray[7][12]=1;BroadArray[7][13]=1;BroadArray[7][17]=1;BroadArray[7][18]=1;BroadArray[7][19]=1;
    BroadArray[9][6]=1;BroadArray[9][12]=1;BroadArray[9][18]=1;
    BroadArray[11][5]=1;BroadArray[11][6]=1;BroadArray[11][7]=1;BroadArray[11][11]=1;BroadArray[11][12]=1;BroadArray[11][13]=1;BroadArray[11][17]=1;BroadArray[11][18]=1;BroadArray[11][19]=1;
    BroadArray[12][3]=1;BroadArray[12][5]=1;BroadArray[12][6]=1;BroadArray[12][7]=1;BroadArray[12][9]=1;BroadArray[12][11]=1;BroadArray[12][12]=1;BroadArray[12][13]=1;BroadArray[12][15]=1;BroadArray[12][17]=1;BroadArray[12][18]=1;BroadArray[12][19]=1;BroadArray[12][21]=1;
    BroadArray[13][5]=1;BroadArray[13][6]=1;BroadArray[13][7]=1;BroadArray[13][11]=1;BroadArray[13][12]=1;BroadArray[13][13]=1;BroadArray[13][17]=1;BroadArray[13][18]=1;BroadArray[13][19]=1;
    BroadArray[15][6]=1;BroadArray[15][12]=1;BroadArray[15][18]=1;
    BroadArray[17][5]=1;BroadArray[17][6]=1;BroadArray[17][7]=1;BroadArray[17][11]=1;BroadArray[17][12]=1;BroadArray[17][13]=1;BroadArray[17][17]=1;BroadArray[17][18]=1;BroadArray[17][19]=1;
    BroadArray[18][3]=1;BroadArray[18][5]=1;BroadArray[18][6]=1;BroadArray[18][7]=1;BroadArray[18][9]=1;BroadArray[18][11]=1;BroadArray[18][12]=1;BroadArray[18][13]=1;BroadArray[18][15]=1;BroadArray[18][17]=1;BroadArray[18][18]=1;BroadArray[18][19]=1;BroadArray[18][21]=1;
    BroadArray[19][5]=1;BroadArray[19][6]=1;BroadArray[19][7]=1;BroadArray[19][11]=1;BroadArray[19][12]=1;BroadArray[19][13]=1;BroadArray[19][17]=1;BroadArray[19][18]=1;BroadArray[19][19]=1;
    BroadArray[21][6]=1;BroadArray[21][12]=1;BroadArray[21][18]=1;
    }
    /**
     * Depending on the position of the po
     * and passing in the array that needs to be set in the Board, change the Board's 1/0
     * 1: represents a pathway, 0: represents a closed circuit
     */
    public void setBoard(int[][] arr,int po)//po:where this module is dragged on the board
    {
        if(po==-1){
            System.out.println("po value is incorrect");
        return;
    }
        int y=po%4;//Which column is that?1，2，3，0
        int i=0;
        int ar=0,a=0;  //ar->j,a->i
        // Which line in module 16?
        if(po<=4)
        {
            if(y==1){
                for(i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++)
                this.BroadArray[i][j]=arr[i][j];
                }
            }
            if(y==2){
                for(i=0;i<arr.length;i++){
                    ar=0;
                for(int j=6;j<arr[0].length+6;j++){
                   this.BroadArray[i][j]=arr[i][ar];
                   ar++;
                }
                }
            }
            if(y==3){
                for(i=0;i<arr.length;i++){
                    ar=0;
                for(int j=12;j<arr[0].length+12;j++){
                   this.BroadArray[i][j]=arr[i][ar];
                   ar++;
                }
                }
            }
            if(y==0){
                for(i=0;i<arr.length;i++){
                    ar=0;
                for(int j=18;j<arr[0].length+18;j++){
                   this.BroadArray[i][j]=arr[i][ar];
                   ar++;
                }
                }
            }
        }
        if(po>4&&po<=8)
        {
            if(y==1){
                a=0;
                for(i=6;i<arr.length+6;i++){
                for(int j=0;j<arr[0].length;j++){
                this.BroadArray[i][j]=arr[a][j];
                }
                a++;
                }
            }
            if(y==2){
                a=0;
                for(i=6;i<arr.length+6;i++){
                ar=0;
                for(int j=6;j<arr[0].length+6;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
            if(y==3){
                a=0;
                for(i=6;i<arr.length+6;i++){
                    ar=0;
                for(int j=12;j<arr[0].length+12;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
            if(y==0){
                a=0;
                for(i=6;i<arr.length+6;i++){
                    ar=0;
                for(int j=18;j<arr[0].length+18;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
        }
        if(po>8&&po<=12)
        {
            if(y==1){
                a=0;
                for(i=12;i<arr.length+12;i++){
                for(int j=0;j<arr[0].length;j++){
                this.BroadArray[i][j]=arr[a][j];
                }
                a++;
                }
            }
            if(y==2){
                a=0;
                for(i=12;i<arr.length+12;i++){
                ar=0;
                for(int j=6;j<arr[0].length+6;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
            if(y==3){
                a=0;
                for(i=12;i<arr.length+12;i++){
                    ar=0;
                for(int j=12;j<arr[0].length+12;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
            if(y==0){
                a=0;
                for(i=12;i<arr.length+12;i++){
                    ar=0;
                for(int j=18;j<arr[0].length+18;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
        }
        if(po>12&&po<=16)
        {
            if(y==1){
                a=0;
                for(i=18;i<arr.length+18;i++){
                for(int j=0;j<arr[0].length;j++){
                this.BroadArray[i][j]=arr[a][j];
                }
                a++;
                }
            }
            if(y==2){
                a=0;
                for(i=18;i<arr.length+18;i++){
                ar=0;
                for(int j=6;j<arr[0].length+6;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
            if(y==3){
                a=0;
                for(i=18;i<arr.length+18;i++){
                    ar=0;
                for(int j=12;j<arr[0].length+12;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
            if(y==0){
                a=0;
                for(i=18;i<arr.length+18;i++){
                    ar=0;
                for(int j=18;j<arr[0].length+18;j++){
                   this.BroadArray[i][j]=arr[a][ar];
                   ar++;
                }
                a++;
                }
            }
        }
    }
    /**
     * Returns the BroadArray used in the route finding algorithm.
     */
    public int[][] getBoard()
    {
        return BroadArray;
    }

}
