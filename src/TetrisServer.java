import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TetrisServer {
//    private ServerSocket serverSocket;
//    private Socket clientSocket;
//    private PrintWriter out;
//    private BufferedReader in;
//
//    public void start(int port) throws IOException {
//
//        System.out.println("Servidor iniciado en el puerto: " + port);
//        serverSocket = new ServerSocket(port);
//        clientSocket = serverSocket.accept();
//        out = new PrintWriter(clientSocket.getOutputStream(), true);
//        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {
//            if (".".equals(inputLine)) {
//                out.println("Recibido");
//                out.close();
//                break;
//            }
//            out.println(inputLine);
//        }
//
//        in.close();
//        clientSocket.close();
//
//    }
//
//    public void stop() throws IOException {
//        serverSocket.close();
//    }
private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) new EchoClientHandler(serverSocket.accept()).start();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    System.out.printf("Recibido: %s\n", inputLine);
                    out.println(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
