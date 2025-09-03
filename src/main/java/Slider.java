package src.main.java;

public class Slider implements Drawing, Move{
    private int x;
    private int y;
    private int longueur; 

    Slider(int x, int y, int longueur){
        this.x = x;
        this.y = y;
        this.longueur = longueur;
    }

    Slider(){
        this(10, 35,6);
    }

    public int getLongueur() {
        return longueur;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void affichage(){
        for(int i=0;i<this.longueur;i++){
            System.out.print("◼");
        }
    }

    public String toString(){
        String s = "";
        for(int i=0;i<this.longueur;i++){
            s = s + "◼";
        }
        return s;
    }

    public void move(){
        this.x += 1;
    }    
    
    public void move(int direction){
        this.x += direction;
    }

    public void setTaille(int taille){
        this.longueur = taille;
    }
}