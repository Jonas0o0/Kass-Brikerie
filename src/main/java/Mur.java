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

    void genererLigne(int x , int y, int nbBriques){
        for(int i = 0; i<nbBriques; i++){
            mur[i] = new Brique(x + i*(Brique.longeur+1) , y);
        }
    }

    void genererMur(int x, int y, int hauteur, int longueur){
        for(int i = 0; i<hauteur; i++){
            genererLigne(x, y + i*(Brique.hauteur+1), longueur);
        }
    }

    Brique[] afficherBriques(){
        return mur;
    }
}