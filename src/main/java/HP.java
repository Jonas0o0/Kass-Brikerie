package src.main.java;

public class HP{

    private int points = 3;
    public final static String COEUR = "♥";

    public HP(int points){
        this.points = points;
    }

    public int getHP(){
        return this.points;
    }

    public void perdu(){
        this.points = this.points-1;
    }

    public boolean gameOver(){
        if(this.points==0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i<this.points; i++){
            str = str + HP.COEUR + " ";
        }
        return str;
    }

    public void setPoints(int points){
        this.points = points;
    }
}