package src.main.java;

public class RawUnix {
    static void exec(String cmd) throws Exception {
        new ProcessBuilder("sh", "-c", cmd).inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        // passe le terminal en raw, sans echo
        exec("stty -icanon -echo min 1 time 0 < /dev/tty");
        try {
            System.out.println("Tape des touches (q pour quitter)...");
            int c;
            while ((c = System.in.read()) != -1) {
                if (c == 'q') break;
                System.out.println("code=" + c + " char='" + (char)c + "'");
            }
        } finally {
            // très important : restaurer
            exec("stty sane < /dev/tty");
        }
    }
}
