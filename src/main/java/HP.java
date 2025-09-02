package src.main.java;

public class HP{

    public static int points = 3;
    public String coeur = "♥";

    public HP(int points){
        HP.points = points;
    }

    public int getHP(){
        return HP.points;
    }

    public void perdu(){
        HP.points = HP.points-1;
    }

    public boolean gameOver(){
        if(HP.points==0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i<HP.points; i++){
            str = str + this.coeur + " ";
        }
        return str;
    }
}