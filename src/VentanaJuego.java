import java.io.IOException;
import javax.swing.JFrame;

public class VentanaJuego {

    public static final int WIDTH = 445, HEIGHT = 640;

    private Tablero board;

    private JFrame window;

    private TetrisServer server;


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

    public void iniciarServidor(int port) {
        server = new TetrisServer();
        try {
            server.start(port);
            System.out.println("Servidor iniciado en el puerto " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new VentanaMenu();
        
        // Iniciar el servidor en un hilo separado
        Thread serverThread = new Thread(() -> {
            TetrisServer server = new TetrisServer();
            int port = 12345; // Puerto en el que el servidor estará escuchando
            try {
                server.start(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
    
        // Aquí puedes seguir con el resto de la lógica de tu juego
    }
    
}





// import javax.swing.JFrame;
// import java.io.IOException;

// public class VentanaJuego {

//     public static final int WIDTH = 445, HEIGHT = 640;

//     private Tablero board;

//     private JFrame window;

//     //private static Leaderboard lf;

    

//     private static VentanaMenu vm;

//     private TetrisServer server = new TetrisServer();

//     //private static VentanaJuego vj;

//     public VentanaJuego() {
//         window = new JFrame("Tetris");
//         window.setSize(WIDTH, HEIGHT);
//         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         window.setResizable(false);
//         window.setLocationRelativeTo(null);

//         board = new Tablero();
//         window.add(board);
//         window.addKeyListener(board);
//         window.setVisible(true);
//     }

//     // public static void showLeaderboard() {
//     //    lf.setVisible(true); 
//     // }

//     public static void showMenu(){
//         vm.setVisible(true);
//     }

//     public static void main(String[] args) {
        
//         new VentanaMenu();
//     }
// }