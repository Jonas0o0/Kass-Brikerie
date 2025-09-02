package src.main.java;

public class Score{

    public int valeur;

    public Score(){
        this.valeur = 0;
    }

    public void addScore(int valeur){
        this.valeur = this.valeur + valeur;
    }

    public void addScoreBriqueBreak(){
        this.valeur = this.valeur + 10;
    }

    public int getScore(){
        return this.valeur;
    }

}