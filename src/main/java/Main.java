package src.main.java;

import java.nio.Buffer;
import java.util.concurrent.TimeUnit;

import src.main.java.menu.menuManager;

public class Main {
    public static void main(String[] args) throws Exception {
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique(0, 0);
        Mur mr = new Mur(20);

        Matrix m = new Matrix();

        menuManager.menuPrincipal();

        String ball = "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n";
        for (int i = 0; i < 5; i++) {
            bq.toString();
            System.out.print(" ");
            bq.toString();
            System.out.print(" ");
            bq.toString();
            System.out.println();
        }
        b.afficher();
        s.affichage();

        RawUnix.exec("stty -icanon -echo min 1 time 0 < /dev/tty");
        int c;
            mr.genererMur(0, 0, 5, 3);


        while (true) {

            TimeUnit.MILLISECONDS.sleep(70);
            System.out.print("\033[H\033[2J");
            System.out.flush();



            m.clear();
            
            b.move();
            s.avancer(1);
            Brique[] mur = mr.afficherBriques();

            /*for(int i=0;i<mur.length;i++){
                System.out.println(mur);
                m.draw(mur[i].toString(), mur[i].getPositionX(), mur[i].getPositionY());
            }*/
            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX() - (s.getLongueur() / 2), s.getY());
            System.out.print(m.render());

        }

    }
}
