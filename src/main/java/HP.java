package src.main.java;

public class HP{

    public int points = 3;
    public String coeur = "♥";

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
            str = str + this.coeur + " ";
        }
        return str;
    }
}