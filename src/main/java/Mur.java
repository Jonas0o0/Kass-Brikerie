package src.main.java;

public class Mur{

    public Brique[] mur;
    public int taille = 10;

    public Mur(){
        mur = new Brique[this.taille];
    }

    public Mur(int taille){
        mur = new Brique[taille];
    }

    void genereLigne(int x , int y, int nbBriques){
        for(int i = 0; i<nbBriques; i++){
            mur[i] = new Brique(x + i*(Brique.longeur+1) , y);
        }
    }

    Brique[] afficherBriques(){
        return mur;
    }
}