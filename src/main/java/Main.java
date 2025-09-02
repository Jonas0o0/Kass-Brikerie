package src.main.java;

import java.util.ArrayList;

import src.main.java.colors.colors;
import src.main.java.inputs.tickInputs;

import src.main.java.menu.menuManager;

public class Main {
    public static void main(String[] args) throws Exception {
        Score sc = new Score();
        Ball b = new Ball();
        Slider s = new Slider();
        Mur mr = new Mur();

        Matrix m = new Matrix();

        menuManager.menuPrincipal();

        sc.addNomJoueur(); // Affichage du choix du Nom du Joueur

        Timer t = new Timer();

        HP pv = new HP(3);

        ArrayList<Brique> mur = mr.afficherBriques();
        mr.genererMur(1, 0, 4, 11);
        


        while(true){

            char keyPressed = tickInputs.inputKey();
            if(keyPressed==27) {
                menuManager.menuPrincipal();
            }
            Tools.clearScreen();

            if(keyPressed=='D' || keyPressed=='d') {
                if(s.getX()<Matrix.resx-(s.getLongueur()/2)){
                    s.move(1);
                }
            }
            if(keyPressed=='A' || keyPressed=='a' || keyPressed=='Q' || keyPressed=='q') {
                if(s.getX()>(s.getLongueur()/2)){
                    s.move(-1);
                }
            }

            
            b.collision(m);
            b.move();
            
            m.clear(); //toujours clear avant le draw
            for(int i=0;i<mur.size();i++){
                m.draw(mur.get(i).toString(), mur.get(i).getX(), mur.get(i).getY());
            }

            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX() - (s.getLongueur() / 2), s.getY());
            
            System.out.print(m.render());
            System.out.println("Score " + sc.nomJoueur + "-> " + colors.YELLOW + sc.getScore() + colors.WHITE);
            System.out.println("Temps écoulés -> " + t.getSeconds() + "s" );
            System.out.println("PV : " + pv);

        }

    }
}
