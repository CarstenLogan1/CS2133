import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.Socket;

public class RobotFrame extends JFrame {
    public RobotFrame(Socket socket) throws MalformedURLException {
        setTitle("Browser");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RobotPanel panel = new RobotPanel(socket);
        add(panel);
        setVisible(true);

    }
}
