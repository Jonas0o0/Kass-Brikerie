package src.main.java;

public class Main {
    public static void main(String[] args) {
        Ball b = new Ball();
        Slider s = new Slider();
        Brique bq = new Brique();

        b.afficher();
        s.affichage();
        for(int i = 0; i < 10; i++){
            System.out.println();
            bq.afficherBrique();
        }
    }
}
