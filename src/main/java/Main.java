package src.main.java;

import java.util.ArrayList;

import src.main.java.colors.colors;
import src.main.java.inputs.tickInputs;

import src.main.java.menu.menuManager;

public class Main {
    public static Score sc = new Score();
    public static HP pv = new HP(3);
    public static Ball b = new Ball();
    public static Slider s = new Slider();
    public static void main(String[] args) throws Exception {
        Mur mr = new Mur();

        Matrix m = new Matrix();

        menuManager.menuPrincipal();

        sc.addNomJoueur(); // Affichage du choix du Nom du Joueur

        Timer t = new Timer();

        ArrayList<Brique> mur = mr.afficherBriques();
        mr.genererMur(1, 0, 4, 11);
        


        while(true){

            char keyPressed = tickInputs.inputKey();
            if(keyPressed==27) {
                menuManager.menuPrincipal();
            }
            Tools.clearScreen();

            if(keyPressed=='D' || keyPressed=='d') {
                if(s.getX()<Matrix.resx-(s.getLargeur()/2)){
                    s.move(1);
                }
            }
            if(keyPressed=='A' || keyPressed=='a' || keyPressed=='Q' || keyPressed=='q') {
                if(s.getX()>(s.getLargeur()/2)){
                    s.move(-1);
                }
            }

            
            Main.b.collision(m, mr, s);
            Main.b.move();
            
            m.clear(); //toujours clear avant le draw
            for(int i=0;i<mur.size();i++){
                m.draw(mur.get(i).toString(), mur.get(i).getX(), mur.get(i).getY());
            }

            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX() - (s.getLargeur() / 2), s.getY());
            
            System.out.print(m.render());
            System.out.println("Score " + Main.sc.getNomJoueur() + "-> " + colors.YELLOW + Main.sc.getScore() + colors.WHITE);
            System.out.println("Temps écoulés -> " + t.getSeconds() + "s" );
            System.out.println("PV : " + Main.pv);

        }

    }
}

