import javax.swing.*;
import java.awt.*;

public class RotatedBresenhamPentagon extends JFrame {
    private int[] xPoints;
    private int[] yPoints;

    public RotatedBresenhamPentagon() {
        setTitle("Rotated Bresenham Pentagon Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the center and radius of the circumscribed circle
        int centerX = 200;
        int centerY = 200;
        int radius = 100;

        // Calculate the coordinates of the pentagon vertices
        xPoints = new int[5];
        yPoints = new int[5];

        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI * i / 5;
            // Apply rotation matrix for 90 degrees counterclockwise
            xPoints[i] = (int) (centerX + radius * Math.cos(angle - Math.PI / 2));
            yPoints[i] = (int) (centerY + radius * Math.sin(angle - Math.PI / 2));
        }
    }

    private void drawRotatedBresenhamPentagon(Graphics g) {
        for (int i = 0; i < xPoints.length - 1; i++) {
            drawBresenhamLine(g, xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]);
        }
        // Draw the last line connecting the last and first vertices
        drawBresenhamLine(g, xPoints[xPoints.length - 1], yPoints[yPoints.length - 1], xPoints[0], yPoints[0]);
    }

    private void drawBresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;

        while (true) {
            g.fillRect(x1, y1, 1, 1);

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;

            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }

            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawRotatedBresenhamPentagon(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RotatedBresenhamPentagon rotatedPentagon = new RotatedBresenhamPentagon();
            rotatedPentagon.setVisible(true);
        });
    }
}
