import javax.swing.*;
import java.awt.*;


public class BrowserFrame extends JFrame{

    public BrowserFrame(){
        setTitle("Browser");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BrowserPanel panel = new BrowserPanel();
        add(panel);
        setVisible(true);

    }
}
