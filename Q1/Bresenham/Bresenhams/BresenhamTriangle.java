import javax.swing.*;
import java.awt.*;

public class BresenhamTriangle extends JFrame {
    private int x1, y1, x2, y2, x3, y3;

    public BresenhamTriangle() {
        setTitle("Upside Down Bresenham Triangle Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the coordinates of the upside-down triangle vertices
        x1 = 50;
        y1 = 300;  // Modified y-coordinate
        x2 = 200;
        y2 = 50;   // Modified y-coordinate
        x3 = 350;
        y3 = 300;  // Modified y-coordinate
    }

    private void BresenhamTriangle(Graphics g) {
        drawBresenhamLine(g, x1, y1, x2, y2);
        drawBresenhamLine(g, x2, y2, x3, y3);
        drawBresenhamLine(g, x3, y3, x1, y1);
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
        BresenhamTriangle(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BresenhamTriangle triangle = new BresenhamTriangle();
            triangle.setVisible(true);
        });
    }
}
