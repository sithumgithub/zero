import java.util.Scanner;

public class Bresenham{
 
  public static void BhLine(int x1, int y1, int x2, int y2) {
 
    int dx,dy,incr1,incr2,d,I,x,y,xend;

    dx = Math.abs(x2 - x1);
    dy = Math.abs(y2 - y1);

    d = 2*dy - dx;
    incr1 = 2*dy;
    incr2 = 2*(dy - dx);
 
    if (x1 > x2){
        x = x2;
        y = y2;
        xend = x1;
    }else{
        x = x1;
        y = y1;
        xend = x2;
    }

    System.out.println(x + ", " + y);

    for(I=x+1; I <= xend; I++){
        
        if(d<0){
            d += incr1;
        }else{
            y += 1;
            d += incr2;
        }
        System.out.println(x + ", " + y);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x1,y1,x2,y2;

    System.out.print("x1 : ");
    x1 = scanner.nextInt();

    System.out.print("y1 : ");
    y1 = scanner.nextInt();

    System.out.print("x2 : ");
    x2 = scanner.nextInt();

    System.out.print("y2 : ");
    y2 = scanner.nextInt();

    scanner.close();

    BhLine(x1, y1, x2, y2);
 
  }
}

