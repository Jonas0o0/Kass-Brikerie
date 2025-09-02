package src.main.java;
import src.main.java.colors.colors;

public class Ball implements Drawing{
    private double x;
    private double y;
    public static final int HAUTEUR = 1;
    public static final int LARGEUR = 1; 
    private double velocity = 1.2;


    Ball() {
        this.x = 15;
        this.y = 20;
    }

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return (int) this.x;
    }

    public int getY() {
        return (int) this.y;
    }

    @Override
    public String toString() {
        return colors.PURPLE+"O"+colors.WHITE;
    }
    

    public void move() {
        this.y -= velocity;
    }

}
 

