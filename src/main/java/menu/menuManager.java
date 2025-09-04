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
        Tools.clearScreen();
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println(
                        colors.GREEN+"       ▄    ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ "+colors.RED+"             ▄▄▄▄            "+colors.GREEN+" ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄    ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" + //
                        colors.GREEN+"      ▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌"+colors.YELLOW+"         ▐▀▀▀    ▀▀▀▌       "+colors.GREEN+" ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + //
                        colors.GREEN+"      ▐░▌ ▐░▌ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ "+colors.GREEN+"         ▌          ▐       "+colors.GREEN+" ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░▌ ▐░▌ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ \n" + //
                        colors.GREEN+"      ▐░▌▐░▌  ▐░▌       ▐░▌▐░▌          ▐░▌          "+colors.CYAN+"       ▐▀            ▀▌     "+colors.GREEN+" ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌     ▐░▌▐░▌  ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌          \n" + //
                        colors.GREEN+"      ▐░▌░▌   ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ "+colors.BLUE+"      ▐▀              ▀▌    "+colors.GREEN+" ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌░▌   ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ \n" + //
                        colors.GREEN+"      ▐░░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌"+colors.PURPLE+"      █                █    "+colors.GREEN+" ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌     ▐░░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌\n" + //
                        colors.GREEN+"      ▐░▌░▌   ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌"+colors.RED+"      ▐▄              ▄▌    "+colors.GREEN+" ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░▌░▌   ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀      ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ \n" + //
                        colors.GREEN+"      ▐░▌▐░▌  ▐░▌       ▐░▌          ▐░▌          ▐░▌"+colors.YELLOW+"       ▐▄            ▄▌     "+colors.GREEN+" ▐░▌       ▐░▌▐░▌     ▐░▌       ▐░▌     ▐░▌▐░▌  ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌          \n" + //
                        colors.GREEN+"      ▐░▌ ▐░▌ ▐░▌       ▐░▌ ▄▄▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌"+colors.GREEN+"         ▌          ▐       "+colors.GREEN+" ▐░█▄▄▄▄▄▄▄█░▌▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌ ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ \n" + //
                        colors.GREEN+"      ▐░▌  ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌"+colors.BLUE+"         ▐▄▄▄    ▄▄▄▌       "+colors.GREEN+" ▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" + //
                        colors.GREEN+"       ▀    ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ "+colors.PURPLE+"             ▀▀▀▀            "+colors.GREEN+" ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀    ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ \n" + //
                        "                                                                                                                                                       \n\n" + //
                        colors.WHITE);
        System.out.println("                                                              "+colors.PURPLE+"["+colors.RED+"1"+colors.PURPLE+"]"+colors.RED+" Jouer");
        System.out.println("                                                              "+colors.PURPLE+"["+colors.YELLOW+"2"+colors.PURPLE+"]"+colors.YELLOW+" Règles");
        System.out.println("                                                              "+colors.PURPLE+"["+colors.GREEN+"3"+colors.PURPLE+"]"+colors.GREEN+" Leaderboard");
        System.out.println("                                                              "+colors.PURPLE+"["+colors.CYAN+"4"+colors.PURPLE+"]"+colors.CYAN+" Quitter\n\n\n\n");
        System.out.print("                                                      "+colors.PURPLE+"["+colors.GREEN+">"+colors.PURPLE+"]"+colors.YELLOW+" Choisissez votre option: "+colors.WHITE);
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
