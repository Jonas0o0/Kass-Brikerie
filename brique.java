/*
Classe brique :
*/

public class brique{

    public int posX; // Position sur l'axe X
    public int posY; // Position sur l'axe Y
    public String affichage = "###"; // Affichage de la brique
    public int score = 10; // Rajoute 10 au score en cas de destruction de la brique 

    // Affiche la brique
    void afficherBrique(){System.out.print(this.affichage);}
    
    // Positionnement de la brique aux coordonnées placées en paramètres
    void positionBrique(int positionX, int positionY){

        this.posX = positionX;
        this.poxY = positionY;

        // Déplacer le curseur à la ligne Y, colonne X

        System.out.print(this.afficherBrique());
        return;
    }


}