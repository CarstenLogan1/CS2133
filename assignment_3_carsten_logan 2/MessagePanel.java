import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {

    private final String MESSAGE = "YO! HELP!";
    private final int BOTTLEWIDTH = 200;
    private final int BOTTLEHEIGHT = 300;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = (getWidth() - BOTTLEWIDTH) / 2;
        int y = (getHeight() - BOTTLEHEIGHT) / 2;

        g.drawLine(300, 300, 400, 300);
        g.drawLine(300, 300, 300, 150);
        g.drawLine(400,300,400,150);
        g.drawLine(300,150,325,150);
        g.drawLine(400,150, 375, 150);
        g.drawLine(325, 150, 335, 130);
        g.drawLine(375, 150, 365, 130);
        g.drawOval(332, 128, 35, 10);
        g.drawString(MESSAGE, 318, 225);

    }
}
