package src.main.java;

import src.main.java.colors.colors;

public class Tools {
    public static void clearScreen() {
        // Code ANSI pour effacer l'écran et remettre le curseur en haut
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void gameOverScreen() {
        System.out.print(colors.RED+"\n\n          ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" + //
                        "         ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" + //
                        "        ▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" + //
                        "        ░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" + //
                        "        ░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" + //
                        "         ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" + //
                        "          ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" + //
                        "        ░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" + //
                        "              ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" + //
                        "                                                             ░                   \n"+colors.WHITE);
    }


    public static String space(int number) {
        if(number<=0) return "";
        String res="";
        for (int i = 0; i < number; i++) {
            res=res+" ";
        }
        return res;
    }
}
