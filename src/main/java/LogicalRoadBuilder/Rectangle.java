package LogicalRoadBuilder;


/**
 *
 * manipulate the bound of a graph, can be used to check whether two graphics
 * are conincide or not
 *
 * @author BJTU course team (public release anonymized)
 *
 */
public class Rectangle
{
    private int width;
    private int height;
    private int x;
    private int y;

    /**
     * Constructor of an object of class Retangle
     */
    public Rectangle(int x, int y,int width,int height)
    {
       this.x=x;
       this.y=y;
       this.width=width;
       this.height=height;
    }

    /**
     *check whether other image is conincide with other rectangle
     */
    public boolean intersects(Rectangle r)
    {
       int tw= this.width;
       int th= this.height;
       int rw=r.width;
       int rh=r.height;

       if(rw<=0||th<=0||tw<=0||th<=0){
           return false;
       }
       int tx=this.x;
       int ty=this.y;
       int rx=r.x;
       int ry=r.y;

       rw+=rx;
       rh+=ry;
       tw+=tx;
       th+=ty;
       return ((rw<rx||rw>tx)&& (rh<ry||rh>ty)
       &&(tw<tx||tw>rx)&&(th<ty||th>ry));
    }
}
