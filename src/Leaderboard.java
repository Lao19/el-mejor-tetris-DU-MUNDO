
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private static List<Jugador> jugadores;
    private JFrame leaderboardFrame;
    private JTable tablaJugadores;

    

    public Leaderboard() {
        jugadores = new ArrayList<>();
        leaderboardFrame = new JFrame("Tabla de Jugadores");
        tablaJugadores = new JTable();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void mostrarTabla() {
        // Ordenar la lista de jugadores por puntuación de mayor a menor
        Collections.sort(jugadores, Collections.reverseOrder());

        // Crear un modelo de tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Puntuación");

        // Agregar los datos de los jugadores al modelo de tabla
        for (Jugador jugador : jugadores) {
            modeloTabla.addRow(new Object[]{jugador.getNombre(), jugador.getScore()});
        }

        // Establecer el modelo de tabla en la JTable
        tablaJugadores.setModel(modeloTabla);

        // Agregar la JTable a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaJugadores);

        // Agregar el JScrollPane al panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.add(scrollPane);

        // Configurar la ventana y mostrarla
        leaderboardFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        leaderboardFrame.getContentPane().add(panelPrincipal);
        leaderboardFrame.pack();
        leaderboardFrame.setLocationRelativeTo(null);
        leaderboardFrame.setVisible(true);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}


