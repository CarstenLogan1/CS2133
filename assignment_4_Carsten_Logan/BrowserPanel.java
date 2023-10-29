import javax.net.ssl.SSLSocketFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;

public class BrowserPanel extends JPanel implements KeyListener {

    private JTextField textField;
    private JTextArea textArea;

    public BrowserPanel() {
        textField = new JTextField("enter a valid URL");
        textField.addKeyListener(this);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String url = textField.getText();
            String line;
            try {
                URL u = new URL(url);
                String host = u.getHost();
                Socket socket = SSLSocketFactory.getDefault().createSocket(host, 443);
                socket.setSoTimeout(500);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String filePath = u.getPath();
                if (filePath.isEmpty()) {
                    filePath = "/";
                }
                out.print("GET " + filePath + " HTTP/1.1\r\n");
                out.print("Host: " + host + "\r\n\r\n");
                out.flush();
                boolean inBody = false;
                StringBuilder bodyText = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    if (line.contains("<title>")) {
                        String title = line.substring(line.indexOf("<title>") + 7, line.indexOf("</title>"));
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                        frame.setTitle(title);
                    }
                    if (line.contains("<body")) {
                        inBody = true;
                    }
                    if (inBody) {
                        int start = 0;
                        int end;
                        while (start != -1) {
                            start = line.indexOf(">", start);
                            if (start != -1) {
                                end = line.indexOf("<", start);
                                if (end != -1) {
                                    String bodyTextSnippet = line.substring(start + 1, end);
                                    bodyText.append(bodyTextSnippet).append(" ").append("\n");
                                    start = end + 1;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (line.contains("</body")) {
                        inBody = false;
                        break;
                    }
                }
                textArea.setText(bodyText.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                textArea.setText("An error occurred while loading the webpage.");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

