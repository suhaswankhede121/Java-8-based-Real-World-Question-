

class Point{
    double x,y;

    Point(double x,double y){
        this.x=x;
        this.y=y;
    }
}

public class ConditionalProblem {

    public static Point pointWithHighestOriginDistance(Point p1,Point p2,Point p3){
        double d1=Math.sqrt(p1.x*p1.x+p1.y*p1.y);
        double d2=Math.sqrt(p2.x*p2.x+p2.y*p2.y);
        double d3=Math.sqrt(p3.x*p3.x+p3.y*p3.y);
       // return d1>d2?(d1>d3?p1:p3):(d2>d3?p2:p3);
       if(d1>d2 && d1>d3){
        return p1;
       }
       else if(d2>d1 && d2>d3){
        return p2;
       }
       return p3;
    }
    public static void main(String[] args) {
        Point p1=new Point(2, 2);
        Point p2=new Point(3, 3);
        Point p3=new Point(-4, -4);
        Point result=pointWithHighestOriginDistance(p1, p2, p3);
        // System.out.format("%.1f\n",result.x);
        // System.out.format("%.1f",result.y);
        System.out.format("%.1f\n",result.x);
        System.out.format("%.1f",result.y);

    }
}
