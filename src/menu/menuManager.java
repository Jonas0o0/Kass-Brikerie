package src.menu;

import java.util.Scanner;

public class menuManager {
    public String menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        afficherMenuPrincipal();
        String choice = scanner.nextLine();
        scanner.close();
        return choice;
    }

    public void afficherMenuPrincipal() {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("               Jouer");
        System.out.println("               Règles");
        System.out.println("               Leaderboard");
        System.out.println("               Quitter\n\n\n\n\n");
        System.out.println("[>] Choisissez votre option: ");
    }
}
