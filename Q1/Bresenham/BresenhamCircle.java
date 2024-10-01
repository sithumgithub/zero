import java.awt.*;
import javax.swing.*;

public class BresenhamCircle extends JPanel {

    // Bresenham Circle Drawing Algorithm
    public void drawCircle(Graphics g, int x_center, int y_center, int radius) {
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;  // Initial decision parameter

        while (x <= y) {
            // Drawing all the octants of the circle
            plot(g, x_center + x, y_center + y);
            plot(g, x_center - x, y_center + y);
            plot(g, x_center + x, y_center - y);
            plot(g, x_center - x, y_center - y);
            plot(g, x_center + y, y_center + x);
            plot(g, x_center - y, y_center + x);
            plot(g, x_center + y, y_center - x);
            plot(g, x_center - y, y_center - x);

            // Decision parameter update
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    // Method to draw a single point
    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1); // Drawing a point (1x1 rectangle)
    }

    // Paint method to display the circle
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the center of the circle and radius
        int x_center = 250;
        int y_center = 250;
        int radius = 100;

        // Call the circle drawing algorithm
        drawCircle(g, x_center, y_center, radius);
    }

    public static void main(String[] args) {
        // Set up the frame for displaying the circle
        JFrame frame = new JFrame();
        BresenhamCircle panel = new BresenhamCircle();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
