
import javax.swing.*;
import java.awt.*;

public class SierpinskiFrame extends JFrame {
    public SierpinskiFrame() {
        setTitle("Sierpinski Triangles");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2,screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new SierpinskiPanel();
        add(panel);
        setVisible(true);
    }
}