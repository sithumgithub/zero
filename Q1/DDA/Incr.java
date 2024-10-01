package IncreLine;
import java.util.Scanner;

public class Incr{
 
  public static void IncreLine(float x1, float y1, float x2, float y2) {
 
    float dx,dy,m,ry;
    int x,y;

    dx = x2 - x1;
    dy = y2 - y1;
 
    if (dx!=0){

        m = dy/dx;
        ry = y1;

        for(x = Math.round(x1); x <= Math.round(x2) ; x++ ){
            y = Math.round(ry);
            System.out.println(x + ", " + y);
            ry += m;
        }
    }else{
        if(dy==0){
            System.out.println(x1 + ", " + y1);
        }else{
            System.out.println("|m| > 1");       
        }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    float x1,y1,x2,y2;

    System.out.print("x1 : ");
    x1 = scanner.nextFloat();

    System.out.print("y1 : ");
    y1 = scanner.nextFloat();

    System.out.print("x2 : ");
    x2 = scanner.nextFloat();

    System.out.print("y2 : ");
    y2 = scanner.nextFloat();

    scanner.close();

    IncreLine(x1, y1, x2, y2);
 
  }
}