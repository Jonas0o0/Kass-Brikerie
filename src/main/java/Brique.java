package src.main.java;
/*
Classe brique :
*/

public class Brique{

    public int posX; // Position sur l'axe X
    public int posY; // Position sur l'axe Y
    public int score = 10; // Rajoute 10 au score en cas de destruction de la brique 

    Brique(int positionX, int positionY){
        this.posX = positionX;
        this.posY = positionY;
    }

    public int getPositionX() {
        return this.posX;
    }

    public int getPositionY() {
        return this.posY;
    }

    // Affiche la brique
    void afficherBrique(){
        System.out.print(" ...... \n|......|");
    }
    
    // Positionnement de la brique aux coordonnées placées en paramètres
    void positionBrique(int positionX, int positionY){

        this.posX = positionX;
        this.posY = positionY;

        // Déplacer le curseur 

        System.out.print(this.afficherBrique());

        return;
    }


}