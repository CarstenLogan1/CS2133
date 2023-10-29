import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class Robot {
    private static Socket socket;
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://robcog.cs.okstate.edu/robot_sim.html";
        try {
            URL u = new URL(url);
            String host = u.getHost();
            socket = new Socket(host, 9095);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String filePath = u.getPath();
            if (filePath.isEmpty()) {
                filePath = "/";
            }
            out.print("GET " + filePath + " HTTP/1.1\r\n");
            out.print("Host: " + host + "\r\n\r\n");
            out.flush();
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(u.toURI());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new RobotFrame(socket);
    }
}