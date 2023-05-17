import java.util.List;

public class Mensaje {
    private String ip;
    private int port;

    private List<Jugador> jugadores;

    public Mensaje(String ip, int port, List<Jugador> jugadores) {
        this.ip = ip;
        this.port = port;
        this.jugadores = jugadores;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
