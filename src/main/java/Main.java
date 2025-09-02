package src.main.java;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import src.main.java.menu.menuManager;

public class Main {
    public static void main(String[] args) throws Exception {
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique(0, 0);
        Mur mr = new Mur();

        Matrix m = new Matrix();

        menuManager.menuPrincipal();

        ArrayList<Brique> mur = mr.afficherBriques();
        mr.genererMur(0, 0, 3, 5);
        


        while (true) {

            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.print("\033[H\033[2J");
            System.out.flush();



            m.clear();
            
            b.move();
            s.avancer(1);

            for(int i=0;i<mur.size();i++){
                m.draw(mur.get(i).toString(), mur.get(i).getX(), mur.get(i).getY());
            }
            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX() - (s.getLongueur() / 2), s.getY());
            System.out.print(m.render());

        }

    }
}
