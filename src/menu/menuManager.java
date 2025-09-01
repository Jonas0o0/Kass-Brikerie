package src.menu;

import java.util.Scanner;
import src.main.java.Main;
import src.menu.menuRules;

public class menuManager {
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        afficherMenuPrincipal();
        String choice = scanner.nextLine();
        scanner.close();

        if(choice=="1") {
            return Main();
        }

        if (choice="2") {
            menuRegles();
        }

        if(choice="4") {
            System.exit(0);
        }


    }

    public void afficherMenuPrincipal() {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("             [1] Jouer");
        System.out.println("             [2] Règles");
        System.out.println("             [3] Leaderboard");
        System.out.println("             [4] Quitter\n\n\n\n\n");
        System.out.println("[>] Choisissez votre option: ");
    }
}
