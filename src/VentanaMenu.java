import javax.swing.*;
import java.awt.*;


public class VentanaMenu extends JFrame {

    private static Leaderboard leaderboard = new Leaderboard();

    private TetrisServer server = new TetrisServer();;

    public VentanaMenu() {

        super("Menú de Tetris");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton botonInicio = new JButton("Jugar");
        botonInicio.addActionListener(e -> {
            setVisible(false);
            new VentanaJuego();
        });
        panel.add(botonInicio);

        
        JButton botonLeaderboard = new JButton("Leaderboard");
        botonLeaderboard.addActionListener(e -> {

            setVisible(true);
            
            leaderboard.mostrarTabla();

        });

        panel.add(botonLeaderboard);

        JButton botonComoJugar = new JButton("Cómo Jugar");

        botonComoJugar.addActionListener(e -> {
            String mensaje = "Cómo Jugar:\n\n";
            mensaje += "Utiliza las teclas de dirección para mover las piezas.\n";
            mensaje += "Presiona la tecla hacia abajo para acelerar la caída de las piezas.\n";
            mensaje += "Presiona la tecla hacia arriba para rotar las piezas.\n";
            mensaje += "Presiona la barra espaciadora para pausar el juego.\n";
            JOptionPane.showMessageDialog(this, mensaje, "Cómo Jugar", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(botonComoJugar);

        JButton botonSalir = new JButton("Salir");

        botonSalir.addActionListener(e -> {
            dispose();
            System.exit(0);
        });
        panel.add(botonSalir);

        add(panel);
        setVisible(true);
    }
}
