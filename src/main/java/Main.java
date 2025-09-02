package src.main.java;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import src.main.java.inputs.tickInputs;

import src.main.java.menu.menuManager;

public class Main {
    public static void main(String[] args) throws Exception {
        Score sc = new Score();
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique(0, 0);
        Mur mr = new Mur();

        Matrix m = new Matrix();

        menuManager.menuPrincipal();

        ArrayList<Brique> mur = mr.afficherBriques();
        mr.genererMur(0, 0, 3, 5);
        


        while (true) {

            char keyPressed = tickInputs.inputKey();
            if(keyPressed==27) {
                System.exit(keyPressed);
            }
            Tools.clearScreen();



            m.clear();
            
            b.move();
            s.avancer(1);

            for(int i=0;i<mur.size();i++){
                m.draw(mur.get(i).toString(), mur.get(i).getX(), mur.get(i).getY());
            }
            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX() - (s.getLongueur() / 2), s.getY());
            System.out.print(m.render());
            System.out.println("Score -> " + sc.getScore());

        }

    }
}
