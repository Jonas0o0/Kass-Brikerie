package src.main.java;

public class Slider {
    public int  positionx;
    public final int positiony = 10;
    public int longueur; 

    Slider(int positionx,int longueur){
        this.positionx = positionx;
        this.longueur = longueur;
    }

    Slider(){
        this(10,6);
    }

    public int getLongueur() {
        return longueur;
    }

    public int getX() {
        return positionx;
    }

    public int getY() {
        return positiony;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
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

    public void avancer(int distance){
        this.positionx += distance;
    }
    
}