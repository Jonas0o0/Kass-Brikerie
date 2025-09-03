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

    public void enregistrerScore(){ // Met à jour le CSV avec le score de l'utilisateur
        try {
            File file = new File("res/scores.csv");
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
            bw.append(this.nomJoueur+","+this.valeur+",0");
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}