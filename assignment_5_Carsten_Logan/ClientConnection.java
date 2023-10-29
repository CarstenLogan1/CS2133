import java.io.*;
import java.net.Socket;

public class ClientConnection implements Runnable {
    private Socket socket;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = in.readLine();
            System.out.println(line);

            String[] input = line.split(" ");
            String fileName = input[1];
            System.out.println(fileName);
            System.out.println("Working Directory = " + System.getProperty("user.dir"));

            if (fileName == "/") {
                fileName = "index.html";
            }

            File file = new File("/Users/carstenlogan/cs2133/" + fileName);
            if (!file.exists()) {
            	OutputStream os = socket.getOutputStream();
                String response = "HTTP/1.1 404 Not Found\r\nContent-Type: text/html\r\n\r\n" +
                        "<html><head><title>File Not Found</title></head><body>" +
                        "<h1>404 Not Found</h1>" +
                        "<p>The requested resource could not be found.</p>" +
                        "</body></html>";
                os.write(response.getBytes());
                os.flush();
            } else {
                OutputStream os = socket.getOutputStream();
                String response = "HTTP/1.1 200 OK\r\nContent-type: text/html\r\n\r\n";
                os.write(response.getBytes());
                FileInputStream inStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inStream.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                inStream.close();
                os.flush();
            }

        } catch (IOException e) {
            // Send a 500 Internal Server Error response if anything goes wrong
            System.err.println("Exception caught: " + e);
            try {
                OutputStream output = socket.getOutputStream();
                String response = "HTTP/1.1 500 Internal Server Error\r\n\r\n";
                output.write(response.getBytes());
                output.flush();
                socket.close();
            } catch (IOException ex) {
                System.err.println("Exception caught while closing socket: " + ex);
            }
        }
    }

}
