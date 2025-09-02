package src.main.java;

import java.util.Scanner;

public class Score{

    private int valeur;
    private String nomJoueur;

    public Score(){
        this.valeur = 0;
    }

    public void addScore(int valeur){
        this.valeur = this.valeur + valeur;
    }

    public void addScoreBriqueBreak(){
        this.valeur = this.valeur + 10;
    }


    public void addNomJoueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un nom de joueur : ");

        nomJoueur = scanner.nextLine();
    }

    public int getScore(){
        return this.valeur;
    }

    public String getNomJoueur(){
        return this.nomJoueur;
    }

}