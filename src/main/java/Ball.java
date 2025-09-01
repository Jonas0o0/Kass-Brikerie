package src.main.java;

public class Ball {
    private int x;
    private int y;

    Ball(){
        this.x = 15;
        this.y = 20;
    }

    Ball (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void afficher(){
        System.out.println("⚪");
    }
}
