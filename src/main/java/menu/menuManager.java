package src.main.java.menu;

import java.util.Scanner;

import src.main.java.Main;

public class menuManager {
    public static void menuPrincipal() {
        String choice;
        Scanner scanner = new Scanner(System.in);
        do {
            afficherMenuPrincipal();
            choice = scanner.nextLine();
        } while(!isNumer(choice));


        if(choice.equals("1")) {
            return;
        }

        if (choice.equals("2")) {
            menuRules.menuRegles();
        }

        if(choice.equals("4")) {
            System.exit(0);
        }
        scanner.close();
    }

    public static void afficherMenuPrincipal() {
        System.out.println("\n\n\n\n\n\n\n");
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

    public static void main(String[] args) {
        menuPrincipal();
    }
}
