package src.main.java;
/*
Classe brique :
*/

public class Brique{

    public int posX; // Position sur l'axe X
    public int posY; // Position sur l'axe Y
    public String affichage = "###"; // Affichage de la brique
    public int score = 10; // Rajoute 10 au score en cas de destruction de la brique 

    // Affiche la brique
    void afficherBrique(){System.out.print(this.affichage);}
    
    // Positionnement de la brique aux coordonnées placées en paramètres
    void positionBrique(int positionX, int positionY){

        this.posX = positionX;
        this.posY = positionY;

        // Déplacer le curseur à la ligne Y, colonne X

        return;
    }


}