package src.main.java;

public class Tools {
    public static void clearScreen() {
        // Code ANSI pour effacer l'écran et remettre le curseur en haut
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
