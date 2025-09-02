package src.main.java;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import src.main.java.colors.colors;
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
        mr.genererMur(25, 0, 3, 5);
        


        while (true) {

            char keyPressed = tickInputs.inputKey();
            if(keyPressed==27) {
                System.exit(keyPressed);
            }
            Tools.clearScreen();

            if(keyPressed=='D' || keyPressed=='d') {
                s.move(1);
            }
            if(keyPressed=='A' || keyPressed=='a') {
                s.move(-1);
            }

            m.clear();
            if(b.getX()<s.getX() + s.getLongueur() && b.getX()>s.getX() - 1 && b.getY() == s.getY() - 1){
                b.move();
            }

            for(int i=0;i<mur.size();i++){
                m.draw(mur.get(i).toString(), mur.get(i).getX(), mur.get(i).getY());
            }
            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX() - (s.getLongueur() / 2), s.getY());
            System.out.print(m.render());
            System.out.println("Score -> " + colors.YELLOW + sc.getScore() + colors.WHITE);

        }

    }
}
