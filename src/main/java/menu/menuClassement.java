package src.main.java.menu;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.tools.Tool;

import src.main.java.Tools;

import java.io.BufferedReader;

public class menuClassement {
    public static void afficherClassement(String path) {
        Tools.clearScreen();
        printLogo();
        ArrayList<String> liste = new ArrayList<>();
        liste = formatterClassement(importerClassement("res/scores.csv")); 
        for(String s: liste) {
            System.out.println(s);
        }
        printFooter();
        System.out.print("Appuyez sur entré pour quitter...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        menuManager.menuPrincipal();
    }

    private static ArrayList<String> importerClassement(String path) {
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                lines.add(dataLine[0]+" "+dataLine[1]+" "+dataLine[2]);
            }
            br.close();
            return lines;
        } catch(Exception e) {
            System.out.println("Veuillez créer un fichier de sauvegarde /res/scores.csv");
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    private static void printLogo() {
        System.out.print("    ░██         ░██████████    ░███    ░███████   ░██████████ ░█████████  ░████████     ░██████      ░███    ░█████████  ░███████   \n" + //
                        "    ░██         ░██           ░██░██   ░██   ░██  ░██         ░██     ░██ ░██    ░██   ░██   ░██    ░██░██   ░██     ░██ ░██   ░██  \n" + //
                        "    ░██         ░██          ░██  ░██  ░██    ░██ ░██         ░██     ░██ ░██    ░██  ░██     ░██  ░██  ░██  ░██     ░██ ░██    ░██ \n" + //
                        "    ░██         ░█████████  ░█████████ ░██    ░██ ░█████████  ░█████████  ░████████   ░██     ░██ ░█████████ ░█████████  ░██    ░██ \n" + //
                        "    ░██         ░██         ░██    ░██ ░██    ░██ ░██         ░██   ░██   ░██     ░██ ░██     ░██ ░██    ░██ ░██   ░██   ░██    ░██ \n" + //
                        "    ░██         ░██         ░██    ░██ ░██   ░██  ░██         ░██    ░██  ░██     ░██  ░██   ░██  ░██    ░██ ░██    ░██  ░██   ░██  \n" + //
                        "    ░██████████ ░██████████ ░██    ░██ ░███████   ░██████████ ░██     ░██ ░█████████    ░██████   ░██    ░██ ░██     ░██ ░███████   \n" + //
                        "                                                                                                                                    \n" + //
                        "                                                                                                                                    \n" + //
                        "                                                                                                                                    \n" + //
                        "           ░████████████░                                                                  ░████████████░                                                  \n" + //
                        "              ░██████░                                                                        ░██████░\n" + //
                        "               ░████░                                                                          ░████░\n");
    }

    private static void printFooter() {
        System.out.print("               ░████░                                                                          ░████░\n" + //
                        "              ░██████░                                                                        ░██████░\n" + //
                        "           ░████████████░                                                                  ░████████████░\n");
    }

    private static ArrayList<String> formatterClassement(ArrayList<String> list) {
        ArrayList<String> formatedList = new ArrayList<>();
        for(String e: list) {
            formatedList.add(Tools.space(16)+"░██░"+Tools.space(44-e.length())+e+Tools.space(32)+"░██░");// 20 pixels de long
        }
        return formatedList;
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a = importerClassement("res/scores.csv");
        for (String string : a) {
            System.out.println(string);
        }
    }
}
