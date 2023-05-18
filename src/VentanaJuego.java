import java.io.IOException;
import javax.swing.JFrame;

public class VentanaJuego {

    public static final int WIDTH = 445, HEIGHT = 640;

    private Tablero board;

    private JFrame window;

    private static TetrisServer server;


    public VentanaJuego() {
        window = new JFrame("Tetris");
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        board = new Tablero();
        window.add(board);
        window.addKeyListener(board);
        window.setVisible(true);
    }

    public static void  iniciarServidor(int port) {
        server = new TetrisServer();
        try {
            server.start(port);
            System.out.println("Servidor iniciado en el puerto " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VentanaMenu ventanaMenu = new VentanaMenu();

        Thread serverThread = new Thread(() -> {
            iniciarServidor(12345);
        });

        serverThread.start();

    }
    
}