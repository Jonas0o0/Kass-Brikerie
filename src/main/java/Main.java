package src.main.java;

import src.main.java.menu.menuManager;

public class Main {
    public static void main(String[] args) {
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique();


        Matrix m = new Matrix();

        menuManager.menuPrincipal();

        String ball =
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n" +
                "#### #### ####\n";
        for(int i = 0; i < 5; i++){
            bq.afficherBrique();
            System.out.print(" ");
            bq.afficherBrique();
            System.out.print(" ");
            bq.afficherBrique();
            System.out.println();
        }
        b.afficher();
        s.affichage();


        m.draw(ball, 50, 12);
        System.out.print(m.render());
    }
}
