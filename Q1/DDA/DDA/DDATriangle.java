import javax.swing.*;
import java.awt.*;

public class DDATriangle extends JFrame {
    private int x1, y1, x2, y2, x3, y3;

    public DDATriangle() {
        setTitle("Upside Down DDA Triangle Drawing");
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

    private void drawUpsideDownDDATriangle(Graphics g) {
        drawDDALine(g, x1, y1, x2, y2);
        drawDDALine(g, x2, y2, x3, y3);
        drawDDALine(g, x3, y3, x1, y1);
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
        drawUpsideDownDDATriangle(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DDATriangle upsideDownTriangle = new DDATriangle();
            upsideDownTriangle.setVisible(true);
        });
    }
}
