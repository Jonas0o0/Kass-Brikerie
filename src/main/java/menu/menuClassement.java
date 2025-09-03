package src.main.java.menu;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import src.main.java.Tools;

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
        System.out.print("Appuyez sur entré pour quitter...");
        menuManager.scanner.nextLine();
        menuManager.menuPrincipal();
    }

    private static ArrayList<String> importerClassement() {
        File file = new File("/home/infoetu/ethan.seulin.etu/Public/dataKassBrikerie/scores.csv");
        if (!file.canRead() || !file.canWrite()) {
            file = new File("res/scores.csv");
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                lines.add(dataLine[0] + " " + dataLine[1] + " " + dataLine[2]);
            }
            br.close();
            return lines;
        } catch (Exception e) {
            System.out.println("Veuillez créer un fichier de sauvegarde /res/scores.csv");
            e.printStackTrace();
        }

        return null;
    }

    private static void printLogo() {
        System.out.print(
                "    ░██         ░██████████    ░███    ░███████   ░██████████ ░█████████  ░████████     ░██████      ░███    ░█████████  ░███████   \n"
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
                        "                                                                                                                                    \n"
                        + //
                        "           ░████████████░                                                                  ░████████████░                                                  \n"
                        + //
                        "              ░██████░                                                                        ░██████░\n"
                        + //
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

    private static ArrayList<String> formatterClassement(ArrayList<String> list) {
        ArrayList<String> formatedList = new ArrayList<>();
        for (String e : list) {
            formatedList.add(Tools.space(16) + "░██░" + Tools.space(44 - e.length()) + e + Tools.space(32) + "░██░");// 20
                                                                                                                     // pixels
                                                                                                                     // de
                                                                                                                     // long
        }
        return formatedList;
    }
}
