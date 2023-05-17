import javax.swing.JFrame;

public class VentanaJuego {

    public static final int WIDTH = 445, HEIGHT = 640;

    private Tablero board;

    private JFrame window;

    //private static Leaderboard lf;

    private static VentanaMenu vm;

    //private static VentanaJuego vj;

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

    // public static void showLeaderboard() {
    //    lf.setVisible(true); 
    // }

    public static void showMenu(){
        vm.setVisible(true);
    }

    public static void main(String[] args) {
        
        new VentanaMenu();
    }
}