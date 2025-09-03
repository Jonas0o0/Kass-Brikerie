package src.main.java;


import src.main.java.menu.menuManager;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

public class Score{

    private int valeur;
    private String nomJoueur;
    private int nbrBriqueCassées;

    public Score(){
        this.valeur = 0;
        this.nbrBriqueCassées = 0;
    }

    public void addScore(int valeur){
        this.valeur = this.valeur + valeur;
    }

    public void addScoreBriqueBreak(){
        this.valeur = this.valeur + 10;
    }

    public void addNbrBriqueBreak(){
        this.nbrBriqueCassées++;
    }


    public void addNomJoueur(){
        System.out.println("Entrez un nom de joueur : ");

        nomJoueur = menuManager.scanner.nextLine();
    }

    public int getScore(){
        return this.valeur;
    }

    public String getNomJoueur(){
        return this.nomJoueur;
    }

    public int getNbrBriqueCassées() {
        return nbrBriqueCassées;
    }

    public void enregistrerScore(){ // Met à jour le CSV avec le score de l'utilisateur
        try {
            File file = new File("/home/infoetu/ethan.seulin.etu/Public/dataKassBrikerie/scores.csv");
            if(!file.canExecute()||!file.canRead()) {
                file = new File("res/scores.csv");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            
            ArrayList<String> listeBase = new ArrayList<>();
            String ligne;
            while ((ligne=br.readLine())!=null) {
                listeBase.add(ligne);
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(String e: listeBase) {
                bw.append(e);
                bw.newLine();
            }
            bw.append(this.nomJoueur+","+this.valeur+","+this.nbrBriqueCassées);
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}