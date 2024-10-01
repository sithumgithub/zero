import javax.swing.*;
import java.awt.*;

public class MidpointCircle extends JFrame {
    private int centerX, centerY, radius;

    public MidpointCircle() {
        setTitle("Midpoint Circle Drawing Algorithm");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the center and radius of the circle
        centerX = 200;
        centerY = 200;
        radius = 100;
    }

    private void drawMidpointCircle(Graphics g) {
        int x = radius;
        int y = 0;
        int p = 1 - radius;

        drawCirclePoints(g, x, y);

        while (x > y) {
            y++;

            if (p <= 0)
                p = p + 2 * y + 1;
            else {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }

            drawCirclePoints(g, x, y);
        }
    }

    private void drawCirclePoints(Graphics g, int x, int y) {
        g.fillRect(centerX + x, centerY - y, 1, 1);
        g.fillRect(centerX - x, centerY - y, 1, 1);
        g.fillRect(centerX + x, centerY + y, 1, 1);
        g.fillRect(centerX - x, centerY + y, 1, 1);
        g.fillRect(centerX + y, centerY - x, 1, 1);
        g.fillRect(centerX - y, centerY - x, 1, 1);
        g.fillRect(centerX + y, centerY + x, 1, 1);
        g.fillRect(centerX - y, centerY + x, 1, 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawMidpointCircle(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MidpointCircle circle = new MidpointCircle();
            circle.setVisible(true);
        });
    }
}
