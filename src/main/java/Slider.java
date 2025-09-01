package src.main.java;

public class Slider {
    public int  positionx;
    public final int positiony = 26;
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

    public int getPositionx() {
        return positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public void affichage(){
        for(int i=0;i<longueur;i++){
            System.out.print("◼");
        }
    }
}