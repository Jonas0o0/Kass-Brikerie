package src.main.java.menu;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import src.main.java.Tools;
import src.main.java.colors.colors;

import java.io.BufferedReader;

public class menuClassement {
    public static void afficherClassement(String path) {

        ArrayList<String> liste = new ArrayList<>();
        liste = formatterClassement(importerClassement());
        MenuLoading.DisplayDonuts(0.5);
        Tools.clearScreen();
        printLogo();
        for (String s : liste) {
            System.out.println(s);
        }
        printFooter();
		System.out.print("\n "+colors.PURPLE+"["+colors.GREEN+">"+colors.PURPLE+"]"+colors.YELLOW+" Appuyez sur Entrée pour continuer..."+colors.WHITE);
        menuManager.scanner.nextLine();
        menuManager.menuPrincipal();
    }

    private static ArrayList<String[]> importerClassement() {
        File file = new File("/home"+File.separator+"infoetu"+File.separator+"ethan.seulin.etu"+File.separator+"Public"+File.separator+"dataKassBrikerie"+File.separator+"scores.csv");
        if (!file.canRead() || !file.canWrite()) {
            file = new File("res"+File.separator+"scores.csv");
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String[]> lines = new ArrayList<String[]>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                lines.add(dataLine);
            }
            br.close();
            lines.sort((a, b) -> {
                int scoreA = Integer.parseInt(a[1]);
                int scoreB = Integer.parseInt(b[1]);
                return Integer.compare(scoreB, scoreA); // ordre décroissant (du plus grand au plus petit)
            });

            for (int i = lines.size()-1; i >=17; i=i-1) {
                lines.remove(i);
            }

            try {
                String premier = lines.get(0)[0];
                lines.get(0)[0] = "🏆 "+premier+" 🏆";
            } catch (Exception e) {
                e.printStackTrace();
            }

            return lines;
        } catch (Exception e) {
            System.out.println("Veuillez créer un fichier de sauvegarde /res/scores.csv");
            e.printStackTrace();
        }

        return null;
    }

    private static void printLogo() {
        System.out.print(
                colors.YELLOW+"\n\n\n\n    ░██         ░██████████    ░███    ░███████   ░██████████ ░█████████  ░████████     ░██████      ░███    ░█████████  ░███████   \n"
                        + //
                        "    ░██         ░██           ░██░██   ░██   ░██  ░██         ░██     ░██ ░██    ░██   ░██   ░██    ░██░██   ░██     ░██ ░██   ░██  \n"
                        + //
                        "    ░██         ░██          ░██  ░██  ░██    ░██ ░██         ░██     ░██ ░██    ░██  ░██     ░██  ░██  ░██  ░██     ░██ ░██    ░██ \n"
                        + //
                        "    ░██         ░█████████  ░█████████ ░██    ░██ ░█████████  ░█████████  ░████████   ░██     ░██ ░█████████ ░█████████  ░██    ░██ \n"
                        + //
                        "    ░██         ░██         ░██    ░██ ░██    ░██ ░██         ░██   ░██   ░██     ░██ ░██     ░██ ░██    ░██ ░██   ░██   ░██    ░██ \n"
                        + //
                        "    ░██         ░██         ░██    ░██ ░██   ░██  ░██         ░██    ░██  ░██     ░██  ░██   ░██  ░██    ░██ ░██    ░██  ░██   ░██  \n"
                        + //
                        "    ░██████████ ░██████████ ░██    ░██ ░███████   ░██████████ ░██     ░██ ░█████████    ░██████   ░██    ░██ ░██     ░██ ░███████   \n"
                        + //
                        "                                                                                                                                    \n"
                        + //
                        "                                                                                                                                    \n"
                        + //
           colors.GREEN+"           ░████████████░          "+colors.BLUE+"Name               Score             Briques           "+colors.GREEN+" ░████████████░                                                  \n"
                        +colors.GREEN+ //
                        "              ░██████░                                                                        ░██████░\n"
                        +colors.GREEN+ //
                        "               ░████░                                                                          ░████░\n");
    }

    private static void printFooter() {
        System.out.print(
                "               ░████░                                                                          ░████░\n"
                        + //
                        "              ░██████░                                                                        ░██████░\n"
                        + //
                        "           ░████████████░                                                                  ░████████████░\n");
    }

    private static ArrayList<String> formatterClassement(ArrayList<String[]> list) {
        ArrayList<String> formattedList = new ArrayList<>();

        int leftPadding = 16; // espaces à gauche
        int statsWidth = 104; // largeur fixe des stats
        int col0Width = 35; // pseudo
        int col1Width = 20; // score
        int col2Width = 20; // blocs détruits

        for (String[] e : list) {
            String col0 = centerOrTrim(e[0], col0Width); // centré
            String col1 = padOrTrim(e[1], col1Width); // à gauche
            String col2 = padOrTrim(e[2], col2Width); // à gauche

            // Construire les stats avec couleurs
            String stats = colors.PURPLE + col0
                    + colors.YELLOW + col1
                    + colors.RED + col2
                    + colors.WHITE;

            // Ajuster à exactement statsWidth
            stats = padOrTrim(stats, statsWidth);

            // Ligne finale
            String line = " ".repeat(leftPadding) +colors.GREEN+"░██░" + stats +colors.GREEN+"░██░";
            formattedList.add(line);
        }

        return formattedList;
    }

    private static String padOrTrim(String s, int width) {
        if (s.length() > width) {
            return s.substring(0, width); // tronquer
        } else {
            return String.format("%-" + width + "s", s); // pad à droite
        }
    }

    private static String centerOrTrim(String s, int width) {
        if (s.length() > width) {
            return s.substring(0, width);
        } else {
            int left = (width - s.length()) / 2;
            int right = width - s.length() - left;
            return " ".repeat(left) + s + " ".repeat(right);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a = formatterClassement(importerClassement());
        for (String string : a) {
            System.out.println(string);
        }
    }
}
