package src.main.java.menu;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.colors.colors;

import java.io.BufferedReader;

public class menuClassement {
    public static void afficherClassement(String path) {
        printLogo();
        ArrayList<String> liste = new ArrayList<>();
        liste = formatterClassement(importerClassement("res/scores.csv")); 
        for(String s: liste) {
            System.out.println(s);
        }
        System.out.print("Appuyez sur entré pour quitter...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    private static ArrayList<String> importerClassement(String path) {
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                lines.add(colors.RED+dataLine[0]+" "+colors.BLUE+dataLine[1]+" "+colors.GREEN+dataLine[2]+colors.WHITE);
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
        System.out.print("░██         ░██████████    ░███    ░███████   ░██████████ ░█████████  ░████████     ░██████      ░███    ░█████████  ░███████   \n" + //
                        "░██         ░██           ░██░██   ░██   ░██  ░██         ░██     ░██ ░██    ░██   ░██   ░██    ░██░██   ░██     ░██ ░██   ░██  \n" + //
                        "░██         ░██          ░██  ░██  ░██    ░██ ░██         ░██     ░██ ░██    ░██  ░██     ░██  ░██  ░██  ░██     ░██ ░██    ░██ \n" + //
                        "░██         ░█████████  ░█████████ ░██    ░██ ░█████████  ░█████████  ░████████   ░██     ░██ ░█████████ ░█████████  ░██    ░██ \n" + //
                        "░██         ░██         ░██    ░██ ░██    ░██ ░██         ░██   ░██   ░██     ░██ ░██     ░██ ░██    ░██ ░██   ░██   ░██    ░██ \n" + //
                        "░██         ░██         ░██    ░██ ░██   ░██  ░██         ░██    ░██  ░██     ░██  ░██   ░██  ░██    ░██ ░██    ░██  ░██   ░██  \n" + //
                        "░██████████ ░██████████ ░██    ░██ ░███████   ░██████████ ░██     ░██ ░█████████    ░██████   ░██    ░██ ░██     ░██ ░███████   \n" + //
                        "                                                                                                                                \n" + //
                        "                                                                                                                                \n" + //
                        "                                                                                                                                ");;
    }

    private static ArrayList<String> formatterClassement(ArrayList<String> list) {
        int i=0;
        ArrayList<String> formatedList = new ArrayList<>();
        for(String e: list) {
            formatedList.add("░██░ "+space(20-e.length())+e+" ░██░");// 20 pixels de long
            i++;
        }
        return formatedList;
    }

    private static String space(int number) {
        if(number<=0) return "";
        String res="";
        for (int i = 0; i < number; i++) {
            res=res+"";
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a = importerClassement("res/scores.csv");
        for (String string : a) {
            System.out.println(string);
        }
    }
}
