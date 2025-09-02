package src.main.java.menu;

import java.util.Scanner;

import src.main.java.colors.colors;

/**
 * Création et afficahge du menu du jeu principal.
 */

public class menuRules {

    // Afficher les règles
    public static void printRules() {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println(colors.CYAN + "===== RÈGLES DU JEU BREAKER =====" + colors.WHITE);
        System.out.println();

        System.out.println(colors.YELLOW + "Objectif :" + colors.WHITE);
        System.out.println("Contrôlez une raquette pour faire rebondir une balle et détruire toutes les briques.");
        System.out.println();

        System.out.println(colors.YELLOW + "Commandes :" + colors.WHITE);
        System.out.println("- Utilisez les flèches gauche et droite pour déplacer la raquette.");
        System.out.println("- Ne laissez pas la balle tomber !");
        System.out.println();

        System.out.println(colors.YELLOW + "Éléments du jeu :" + colors.WHITE);
        System.out.println(colors.BLUE + "● Raquette" + colors.WHITE + " : Permet de renvoyer la balle.");
        System.out.println(colors.RED + "● Balle" + colors.WHITE + " : Détruit les briques à l'impact.");
        System.out.println(colors.GREEN + "● Briques" + colors.WHITE + " : À casser pour gagner.");
        System.out.println(colors.PURPLE + "● Bonus" + colors.WHITE
                + " : Certains blocs libèrent des bonus (agrandissement, multi-balle...).");
        System.out.println(colors.BLACK + "● Objets neutres / obstacles" + colors.WHITE
                + " : Peuvent gêner ou ralentir.");
        System.out.println();

        System.out.println(colors.YELLOW + "Conditions de victoire :" + colors.WHITE);
        System.out.println("- Cassez toutes les briques pour passer au niveau suivant.");
        System.out.println();

        System.out.println(colors.RED + "Défaite :" + colors.WHITE);
        System.out.println("- Si la balle tombe en dehors de l'écran sans être renvoyée, vous perdez une vie.");
        System.out.println("- Le jeu se termine quand vous n'avez plus de vies.");
        System.out.println();

        System.out.println(colors.CYAN + "Bonne chance et amusez-vous bien !" + colors.WHITE);
    }

    public static void menuRegles() {
        Scanner scanner = new Scanner(System.in);
        printRules();
        System.err.println("Appuyez sur une touche pour continuer...");
        scanner.nextLine();
        scanner.close();
    }
}
