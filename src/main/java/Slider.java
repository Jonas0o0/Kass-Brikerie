package src.main.java;

public class Slider implements Drawing, Move{
    private int x;
    private int y;
    private int largeur; 
    private final int HAUTEUR = 1;

    public Slider(int x, int y, int longueur){
        this.x = x;
        this.y = y;
        this.largeur = longueur;
    }

    public Slider(){
        this(50, 35,10);
    }

    public int getLargeur(){
        return this.largeur;
    }

    public int getHauteur(){
        return this.HAUTEUR;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setTaille(int taille){
        this.largeur = taille;
    }

    public void affichage(){
        for(int i=0;i<this.largeur;i++){
            System.out.print("◼");
        }
    }

    public String toString(){
        String s = "";
        for(int i=0;i<this.largeur;i++){
            s = s + "◼";
        }
        return s;
    }

    public void move(){
        this.x += 2;
    }    
    
    public void move(int direction){
        this.x += direction;
    }

}