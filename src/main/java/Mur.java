package src.main.java;

import java.util.ArrayList;
import java.util.Random;

public class Mur{

    public ArrayList<Brique> mur;

    public Mur(){
        mur = new ArrayList<Brique>();
    }

    void genererLigne(int x , int y, int nbBriques){
        for(int i = 0; i<nbBriques; i++){
            mur.add(new Brique(x + i*(8 + 1) , y));
        }
    }

    void genererMur(int x, int y, int hauteur, int longueur){
        for(int i = 0; i<hauteur; i++){
            genererLigne(x, y + i*(2 + 1), longueur);
        }
    }

    ArrayList<Brique> afficherBriques(){
        return mur;
    }

    public void destroy(Brique b){
        if (b != null){
            Main.sc.addScore(b.getScore());
            Main.sc.addNbrBriqueBreak();
            Random alea = new Random();
            if(alea.nextInt(4)==0){
                Main.bonus.add(new Bonus(b.getX()+b.getLargeur()/2, b.getY()));
            }
        }
        this.mur.remove(b);
    }
}