package src.main.java;

public class Main {
    public static void main(String[] args) {
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique();

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
    }
}
