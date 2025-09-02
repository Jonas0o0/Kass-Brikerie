package src.main.java;
/*
Classe brique :
*/

public class Brique implements Drawing{

    public double x; // Position sur l'axe X
    public double y; // Position sur l'axe Y
    public int score = 10; // Rajoute 10 au score en cas de destruction de la brique 
    public static final int HAUTEUR = 2;
    public static final int LARGEUR = 8; 

    Brique(double positionX, double positionY){
        this.x = positionX;
        this.y = positionY;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    
    // Positionnement de la brique aux coordonnées placées en paramètres
    void positionBrique(double positionX, double positionY){

        this.x = positionX;
        this.y = positionY;

        // Déplacer le curseur 

        System.out.println(this.toString());

        return;
    }

    @Override
    public String toString() {
        return "........\n:......:";
    }


}