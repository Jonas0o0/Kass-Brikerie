package src.main.java.inputs;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class TickInputs {

    private static Terminal terminal;
    private static NonBlockingReader reader;

    private static volatile boolean running = false;
    private static Thread inputThread;

    // Queue d’événements clavier (remplie par le thread d’entrée)
    private static final BlockingQueue<Integer> KEY_QUEUE = new ArrayBlockingQueue<>(1024);

    // États continus (tenir la direction)
    public static final AtomicBoolean LEFT = new AtomicBoolean(false);
    public static final AtomicBoolean RIGHT = new AtomicBoolean(false);

    public static void init() throws IOException {
        if (terminal != null) return;

        terminal = TerminalBuilder.builder()
                .system(true)
                .jna(true)
                .jansi(true) // utile sur certains terminals/IDE
                .build();
        terminal.enterRawMode();
        reader = terminal.reader();

        running = true;
        inputThread = new Thread(() -> {
            try {
                while (running) {
                    // LECTURE BLOQUANTE ici (dans le thread dédié) => n'arrête jamais la boucle de jeu
                    int ch = reader.read();
                    if (ch >= 0) KEY_QUEUE.offer(ch);
                }
            } catch (IOException ignored) {
            }
        }, "TickInputs-Reader");
        inputThread.setDaemon(true);
        inputThread.start();
    }

    public static void shutdown() throws IOException {
        running = false;
        if (reader != null) reader.close();
        if (terminal != null) terminal.close();
        reader = null;
        terminal = null;
    }

    // Traite une touche et met à jour les états
    private static void handleKey(int ch) {
        char c = Character.toLowerCase((char) ch);

        // AZERTY: gauche = a ou q ; droite = d
        if (c == 'a' || c == 'q') {
            LEFT.set(true);
            RIGHT.set(false);
        } else if (c == 'd') {
            RIGHT.set(true);
            LEFT.set(false);
        } else if (c == ' ') {
            // stop
            LEFT.set(false);
            RIGHT.set(false);
        } else if (c == 'e') {
            // sortie immédiate si tu veux
            System.exit(0);
        }
        // 'm' sera traité côté Main si besoin de menu
    }

    /**
     * Dépile TOUTES les touches arrivées depuis la dernière frame (non-bloquant).
     * Retourne la dernière touche (ou -1 s’il n’y en a pas) pour que Main puisse détecter 'm'.
     */
    public static int poll() {
        int last = -1;
        Integer ch;
        while ((ch = KEY_QUEUE.poll()) != null) {
            last = ch;
            handleKey(ch);
        }
        return last;
    }

    public static boolean left()  { return LEFT.get(); }
    public static boolean right() { return RIGHT.get(); }
}

