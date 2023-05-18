import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Multijugador {
    private JFrame frame;
    private JButton unirseSalaButton;

    public Multijugador() {
        frame = new JFrame("Multijugador");
        frame.setSize(300, 200); // Establecer un tamaño fijo para la ventana

        JPanel panel = new JPanel();

        unirseSalaButton = new JButton("Unirse a Sala");
        unirseSalaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog(frame, "Ingrese la IP del servidor:");

                // Crear instancia de cliente y establecer la conexión
                TetrisClient client = new TetrisClient();
                int port = 12345; // Puerto en el que el servidor está escuchando
                try {
                    client.startConnection(ip, port);
                    // Lógica adicional del cliente (enviar datos al servidor, recibir respuestas, etc.)
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(unirseSalaButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    
}
