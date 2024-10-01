import javax.swing.*;
import java.awt.*;

public class DDAPentagon extends JFrame {
    private int[] xPoints;
    private int[] yPoints;

    public DDAPentagon() {
        setTitle("DDA Pentagon Drawing");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the coordinates of the pentagon vertices
        xPoints = new int[]{200, 300, 250, 150, 100};
        yPoints = new int[]{100, 200, 300, 300, 200};
    }

    private void drawDDAPentagon(Graphics g) {
        for (int i = 0; i < xPoints.length - 1; i++) {
            drawDDALine(g, xPoints[i], yPoints[i], xPoints[i + 1], yPoints[i + 1]);
        }
        // Draw the last line connecting the last and first vertices
        drawDDALine(g, xPoints[xPoints.length - 1], yPoints[yPoints.length - 1], xPoints[0], yPoints[0]);
    }

    private void drawDDALine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1);
            x += xIncrement;
            y += yIncrement;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawDDAPentagon(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DDAPentagon pentagon = new DDAPentagon();
            pentagon.setVisible(true);
        });
    }
}
