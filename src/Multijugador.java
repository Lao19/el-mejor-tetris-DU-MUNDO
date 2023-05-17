import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multijugador {
    private JFrame frame;
    private JButton unirseSalaButton;

    

    public Multijugador() {
        frame = new JFrame("Multijugador");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // Establecer un tamaño fijo para la ventana

        JPanel panel = new JPanel();

        unirseSalaButton = new JButton("Unirse a Sala");
        unirseSalaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog(frame, "Ingrese la IP del servidor:");

                // Lógica para unirse a la sala con la IP especificada
                unirseSala(ip);
            }
        });
        panel.add(unirseSalaButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void unirseSala(String ip) {
        // Lógica para unirse a la sala con la IP especificada
        System.out.println("Uniéndose a la sala en IP: " + ip);
    }

   
}
