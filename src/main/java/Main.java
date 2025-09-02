package src.main.java;

import java.util.concurrent.TimeUnit;

import src.main.java.menu.menuManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique(0, 0);


        Matrix m = new Matrix();

        //menuManager.menuPrincipal();

        String ball =
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n";
        for(int i = 0; i < 5; i++){
            bq.toString();
            System.out.print(" ");
            bq.toString();
            System.out.print(" ");
            bq.toString();
            System.out.println();
        }
        b.afficher();
        s.affichage();





        while(true){
            TimeUnit.SECONDS.sleep(1);;
            b.move();
            s.avancer(1);
            m.draw(b.toString(), b.getX(), b.getY());
            m.draw(s.toString(), s.getX()-(s.getLongueur()/2), s.getY());
            System.out.print(m.render());

        }
        
    }
}
