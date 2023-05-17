import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TetrisServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Leaderboard leaderboard;

    public void start(int port) throws IOException {
        leaderboard = new Leaderboard(); // Inicializar el leaderboard

        serverSocket = new ServerSocket(port);
        System.out.println("Servidor iniciado en el puerto: " + port);

        while (true) {
            System.out.println("Esperando conexiones de clientes...");
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Leer los datos del cliente (nombre y puntuación)
            String nombre = in.readLine();
            int score = Integer.parseInt(in.readLine());

            // Actualizar el leaderboard con los datos recibidos del cliente
            Jugador jugador = new Jugador(nombre, score);
            leaderboard.agregarJugador(jugador);

            // Enviar confirmación al cliente
            out.println("Datos recibidos y actualizados en el leaderboard");

            // Cerrar la conexión con el cliente
            in.close();
            out.close();
            clientSocket.close();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) {
        TetrisServer server = new TetrisServer();
        try {
            int port = 12345; // Puerto en el que el servidor estará escuchando
            server.start(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
