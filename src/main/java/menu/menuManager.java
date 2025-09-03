package src.main.java.menu;

import java.util.Scanner;

import src.main.java.Tools;
import src.main.java.colors.colors;

public class menuManager {
    public static Scanner scanner;

    public static void menuPrincipal() {
        String choice;

        do {
            afficherMenuPrincipal();
            choice = scanner.nextLine();
        } while (!isNumer(choice));

        switch (choice) {
            case "1":
                return;
            case "2":
                menuRules.menuRegles();
                break;
            case "3":
                menuClassement.afficherClassement(choice);
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("⚠ Choix invalide, veuillez réessayer.");
        }
    }

    private static void afficherMenuPrincipal() {
        MenuLoading.DisplayDonuts(0.5);
        Tools.clearScreen();
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println(
                        colors.GREEN+" ▄    ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ "+colors.CYAN+"           ▄▄▄▄          "+colors.GREEN+" ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄    ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" + //
                        colors.GREEN+"▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌"+colors.CYAN+"       ▐▀▀▀    ▀▀▀▌     "+colors.GREEN+" ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + //
                        colors.GREEN+"▐░▌ ▐░▌ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ "+colors.CYAN+"       ▌          ▐     "+colors.GREEN+" ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░▌ ▐░▌ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ \n" + //
                        colors.GREEN+"▐░▌▐░▌  ▐░▌       ▐░▌▐░▌          ▐░▌          "+colors.CYAN+"     ▐▀            ▀▌   "+colors.GREEN+" ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌     ▐░▌▐░▌  ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌          \n" + //
                        colors.GREEN+"▐░▌░▌   ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ "+colors.CYAN+"    ▐▀              ▀▌  "+colors.GREEN+" ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌░▌   ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ \n" + //
                        colors.GREEN+"▐░░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌"+colors.CYAN+"    █                █  "+colors.GREEN+" ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌     ▐░░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌\n" + //
                        colors.GREEN+"▐░▌░▌   ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌"+colors.CYAN+"    ▐▄              ▄▌  "+colors.GREEN+" ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌░▌   ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ \n" + //
                        colors.GREEN+"▐░▌▐░▌  ▐░▌       ▐░▌          ▐░▌          ▐░▌"+colors.CYAN+"     ▐▄            ▄▌   "+colors.GREEN+" ▐░▌       ▐░▌▐░▌     ▐░▌       ▐░▌     ▐░▌▐░▌  ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌          \n" + //
                        colors.GREEN+"▐░▌ ▐░▌ ▐░▌       ▐░▌ ▄▄▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌"+colors.CYAN+"       ▌          ▐     "+colors.GREEN+" ▐░█▄▄▄▄▄▄▄█░▌▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌ ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ \n" + //
                        colors.GREEN+"▐░▌  ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌"+colors.CYAN+"       ▐▄▄▄    ▄▄▄▌     "+colors.GREEN+" ▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + //
                        colors.GREEN+" ▀    ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ "+colors.CYAN+"           ▀▀▀▀          "+colors.GREEN+" ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀    ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ \n" + //
                        "                                                                                                                                                       \n" + //
                        "");
        System.out.println("             [1] Jouer");
        System.out.println("             [2] Règles");
        System.out.println("             [3] Leaderboard");
        System.out.println("             [4] Quitter\n\n\n\n\n");
        System.out.println("[>] Choisissez votre option: ");
    }

    private static boolean isNumer(String stringNombre) {
        try {
            Integer.parseInt(stringNombre);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
