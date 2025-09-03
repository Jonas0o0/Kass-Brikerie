package src.main.java.menu;

import java.util.Scanner;

import src.main.java.Main;
import src.main.java.Score;
import src.main.java.Timer;
import src.main.java.Tools;
import src.main.java.colors.colors;

public class menuGameOver {

    public static void gameOverScreen(Score sc, Timer t) {
        Scanner scanner = new Scanner(System.in);
        sc.enregistrerScore();
        Tools.clearScreen();
        Tools.gameOverScreen();
        System.out.println("\n\n\n");
        System.out.println(Tools.space(30) + Tools.space(14 - sc.getNomJoueur().length()) + colors.YELLOW + "[ "
                + colors.PURPLE + sc.getNomJoueur() + colors.YELLOW
                + " ]\n" + colors.WHITE);
        System.out
                .println(Tools.space(30) + colors.YELLOW + "Score:              " + colors.PURPLE + sc.getScore() + colors.WHITE);
        System.out.println(
                Tools.space(30) + colors.YELLOW + "Brique cassées:     " + colors.PURPLE + sc.getScore() + colors.WHITE);
        System.out.println(Tools.space(30) + colors.YELLOW + "Temps écoulé:       " + colors.PURPLE + t.getSeconds() + "s"
                + colors.WHITE);
        System.out.println("Appuyez sur entré pour continuer...");
        scanner.nextLine();
        try {
            Main.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}