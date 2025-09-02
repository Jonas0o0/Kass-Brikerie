package src.main.java;

public class Slider implements Drawing {
    private double x;
    private double y;
    private int longueur; 

    Slider(double x, double y, int longueur){
        this.x = x;
        this.y = y;
        this.longueur = longueur;
    }

    Slider(){
        this(10, 20,6);
    }

    public int getLongueur() {
        return longueur;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
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

    public void avancer(int distance){
        this.x += distance;
    }

}