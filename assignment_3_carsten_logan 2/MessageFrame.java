import javax.swing.*;
import java.awt.*;

public class MessageFrame extends JFrame {

    public MessageFrame(){
        setTitle("Message in a Bottle");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new MessagePanel();
        add(panel);
        setVisible(true);
    }

}
