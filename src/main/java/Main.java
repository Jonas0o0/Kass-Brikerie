package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.colors.colors;
import src.main.java.inputs.tickInputs;

import src.main.java.menu.menuManager;

public class Main {
    public static Score sc = new Score();
    public static HP pv = new HP(3);
    public static Ball b = new Ball();
    public static Slider s = new Slider();

    public static void main(String[] args) throws Exception {
        Score sc = new Score();
        Ball b = new Ball();
        Slider s = new Slider();
        Mur mr = new Mur();

        Matrix m = new Matrix();

        Timer t = new Timer();

        HP pv = new HP(3);

        ArrayList<Brique> mur = mr.afficherBriques();
        mr.genererMur(1, 0, 4, 11);

        m.draw(s.toString(), s.getX() - (s.getLongueur() / 2), s.getY());

        System.out.print(m.render());
        System.out
                .println("Score " + Main.sc.getNomJoueur() + "-> " + colors.YELLOW + Main.sc.getScore() + colors.WHITE);
        System.out.println("Score " + sc.getNomJoueur() + "-> " + colors.YELLOW + sc.getScore() + colors.WHITE);
        System.out.println("Temps écoulés -> " + t.getSeconds() + "s");
        System.out.println("PV : " + Main.pv);

        System.out.println("PV : " + pv);

        if (pv.gameOver()) {
            Scanner scanner = new Scanner(System.in);
            sc.enregistrerScore();
            Tools.clearScreen();
            Tools.gameOverScreen();
            System.out.println("\n\n\n");
            System.out.println(Tools.space(20) + colors.YELLOW + "[ " + colors.PURPLE + sc.getNomJoueur()
                    + colors.YELLOW + " ]\n" + colors.WHITE);
            System.out.println(
                    Tools.space(20) + colors.YELLOW + "Score: \t" + colors.PURPLE + sc.getScore() + colors.WHITE);
            System.out.println(Tools.space(20) + colors.YELLOW + "Brique cassées: \t" + colors.PURPLE + sc.getScore()
                    + colors.WHITE);
            System.out.println(Tools.space(20) + colors.YELLOW + "Temps écoulé: \t" + colors.PURPLE + t.getSeconds()
                    + "s" + colors.WHITE);
            scanner.nextLine();
            System.out.println("Appuyez sur entré pour continuer...");
            menuManager.menuPrincipal();
        }

    }
}
