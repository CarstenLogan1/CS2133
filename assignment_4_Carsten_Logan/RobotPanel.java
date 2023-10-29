import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class RobotPanel extends JPanel {

    private JButton [][] buttons;
    private Socket socket;
    private static final String TAKEOFF = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
    private static final String LAND = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
    private static final String FORWARD = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0.15, \"y\":0, \"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";
    private static final String UP ="{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0, \"y\":0, \"z\":0.25},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";;
    private static final String DOWN ="{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0, \"y\":0, \"z\":-0.25},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";;
    private static final String BACKWARD = "{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":-0.15, \"y\":0, \"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";;
    private static final String TURN ="{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0, \"y\":0, \"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0.15}}}";
    private static final String LEFT ="{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0, \"y\":-0.15, \"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";;
    private static final String RIGHT ="{\"op\":\"publish\",\"topic\":\"/cmd_vel\",\"msg\":{\"linear\":{\"x\":0, \"y\":0.15, \"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":0}}}";;

    public RobotPanel(Socket socket)  {
        this.socket = socket;
        setLayout(new GridLayout(3,3));
        buttons = new JButton[3][3];

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                JButton button = new JButton();
                button.addMouseListener(new MouseHandler(i,j));
                buttons[i][j] = button;
                add(button);
            }
        }
        setText();
    }

    private class MouseHandler implements MouseListener {
        private int row, col;

        public MouseHandler(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                if (row == 0 && col == 0) {
                    out.print(TAKEOFF);
                    out.flush();

                } else if (row == 0 && col == 1) {
                    out.print(LAND);
                    out.flush();

                } else if (row == 0 && col == 2) {
                    out.print(UP);
                    out.flush();

                } else if (row == 1 && col == 0) {
                    out.print(DOWN);
                    out.flush();

                } else if (row == 1 && col == 1) {
                    out.print(LEFT);
                    out.flush();

                } else if (row == 1 && col == 2) {
                    out.print(RIGHT);
                    out.flush();

                } else if (row == 2 && col == 0) {
                    out.print(FORWARD);
                    out.flush();

                } else if (row == 2 && col == 1) {
                    out.print(BACKWARD);
                    out.flush();

                } else if (row == 2 && col == 2) {
                    out.print(TURN);
                    out.flush();

                }
            } catch (UnknownHostException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public void setText() {
        String[][] buttonTexts = {
                {"takeoff", "land", "up"},
                {"down", "left", "right"},
                {"forward", "backward", "turn"}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(buttonTexts[i][j]);
            }
        }
    }

}
