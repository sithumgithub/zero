import javax.swing.*;
import java.awt.*;

public class CircleWithTriangle extends JApplet {
    int centerX, centerY, dGrid = 1, maxX, maxY;

    void initgr() {
        Dimension d;
        d = getSize();
        maxX = d.width - 1;
        maxY = d.height - 1;
        centerX = maxX / 2;
        centerY = maxY / 2;
    }

    void drawCircle(Graphics g, int xc, int yc, int radius) {
        int x = radius;
        int y = 0;
        int radiusError = 1 - x;

        while (x >= y) {
            plotCirclePoints(g, xc, yc, x, y);
            y++;

            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x) + 1;
            }
            plotCirclePoints(g, xc, yc, x, y);
        }
    }

    void plotCirclePoints(Graphics g, int xc, int yc, int x, int y) {
        g.fillOval(xc + x, yc - y, 5, 5);
        g.fillOval(xc - x, yc - y, 5, 5);
        g.fillOval(xc + x, yc + y, 5, 5);
        g.fillOval(xc - x, yc + y, 5, 5);
        g.fillOval(xc + y, yc - x, 5, 5);
        g.fillOval(xc - y, yc - x, 5, 5);
        g.fillOval(xc + y, yc + x, 5, 5);
        g.fillOval(xc - y, yc + x, 5, 5);
    }

    void drawTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);
    }

    void drawCircleInsideTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        int radius = 40;

        // Calculate centroid of the triangle
        int cx = (x1 + x2 + x3) / 3;
        int cy = (y1 + y2 + y3) / 3;

        drawCircle(g, cx, cy, radius);
    }

    public void paint(Graphics g) {
        initgr();
        int circleRadius = 100;

        // Draw the outer circle
        drawCircle(g, centerX, centerY, circleRadius);

        // Calculate coordinates for a triangle inside the circle
        int x1 = centerX;
        int y1 = centerY - circleRadius;
        int x2 = centerX - (int) (Math.sqrt(3) * circleRadius / 2);
        int y2 = centerY + circleRadius / 2;
        int x3 = centerX + (int) (Math.sqrt(3) * circleRadius / 2);
        int y3 = y2;

        // Draw the triangle
        drawTriangle(g, x1, y1, x2, y2, x3, y3);

        // Draw a circle inside the triangle
        drawCircleInsideTriangle(g, x1, y1, x2, y2, x3, y3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle with Triangle");
        CircleWithTriangle applet = new CircleWithTriangle();
        frame.getContentPane().add(applet);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
