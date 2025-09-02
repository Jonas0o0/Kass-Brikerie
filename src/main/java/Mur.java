package src.main.java;

import java.util.ArrayList;

public class Mur{

    public ArrayList<Brique> mur;

    public Mur(){
        mur = new ArrayList<Brique>();
    }

    void genererLigne(int x , int y, int nbBriques){
        for(int i = 0; i<nbBriques; i++){
            mur.add(new Brique(x + i*(Brique.LARGEUR+1) , y));
        }
    }

    void genererMur(int x, int y, int hauteur, int longueur){
        for(int i = 0; i<hauteur; i++){
            genererLigne(x, y + i*(Brique.HAUTEUR+1), longueur);
        }
    }

    ArrayList<Brique> afficherBriques(){
        return mur;
    }

    public void destroy(Brique b){
        if (b != null){
            Main.sc.addScore(b.getScore());
        }
        this.mur.remove(b);
    }
}