
import java.util.Scanner;

public class DDA{
 
  public static void DDALine(int x1, int y1, int x2, int y2) {
 
    int dx,dy,step,k;
    float x_inc,y_inc,x,y;

    dx = x2 - x1;
    dy = y2 - y1;
 
    if (Math.abs(dx) > Math.abs(dy)){
        step = Math.abs(dx);
    }else{
       step = Math.abs(dy);
    }

    x = x1;
    y = y1;

    System.out.print(x + ", " + y);

    x_inc = dx/step;
    y_inc = dy/step;

    for(k=1; k<=step; k++){
        x += x_inc;
        y += y_inc;

        System.out.print(x + ", " + y);
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

    DDALine(x1, y1, x2, y2);
 
  }
}
