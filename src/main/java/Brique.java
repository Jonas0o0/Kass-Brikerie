package src.main.java;
/*
Classe brique :
*/

public class Brique implements Drawing{

    private int x; // Position sur l'axe X
    private int y; // Position sur l'axe Y
    private int score = 10; // Rajoute 10 au score en cas de destruction de la brique 
    public final static int HAUTEUR = 2;
    public final static int LARGEUR = 8; 

    Brique(int positionX, int positionY){
        this.x = positionX;
        this.y = positionY;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getScore() {
        return score;
    }
    
    // Positionnement de la brique aux coordonnées placées en paramètres
    void positionBrique(int positionX, int positionY){

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

    public boolean collision(int x, int y){
        return x >= this.x && x <= this.x + Brique.LARGEUR && y >= this.y && y <= this.y + Brique.HAUTEUR;
    }


}