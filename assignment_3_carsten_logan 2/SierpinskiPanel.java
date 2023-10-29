import javax.swing.*;
import java.awt.*;

public class SierpinskiPanel extends JPanel {


    public void paintComponent(Graphics g){
        super.paintComponent(g);

         int w = getWidth();
         int h = getHeight();
         int x = (w/2) - (h/2);
         int y = 0;
         int size1 = h;

        draw(g, x, y, size1);

    }

    private void draw(Graphics g, int x, int y, int size1) {
        int size2, leftX, leftY, rightX, rightY, topX, topY;

        if (size1 == 1) {
            g.drawRect(x, y, 1, 1);
        } else {
            size2 = size1 / 2;
            leftX = x - (size2 / 2);
            leftY = y + size2;
            rightX = x + (size2 / 2);
            rightY = y + size2;
            topX = x;
            topY = y;

            draw(g, leftX, leftY, size2 );
            draw(g, rightX, rightY, size2);
            draw(g, topX, topY, size2);
        }
    }

}