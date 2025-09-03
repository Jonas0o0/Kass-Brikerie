package src.main.java;

public class Rect implements Drawing{
    private int x, y;       // position du coin supérieur gauche
    private int largeur= 3; 
    private int hauteur = 3;

    Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.hauteur = height;
        this.largeur = width;
    }

    public int getX() {
        return (int) this.x;
    }

    public int getY() {
        return (int) this.y;
    }

    public int getLargeur(){
        return this.largeur;
    }

    public int getHauteur(){
        return this.hauteur;
    }

}
