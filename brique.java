/*
Classe brique :
*/

public class brique{

    public int posX; // Position sur l'axe X
    public int posY; // Position sur l'axe Y
    public String design = "###"; // Design de la brique
    public int score = 10; // Rajoute 10 au score en cas de destruction de la brique 
    
    // Positionnement de la brique aux coordonnées placées en paramètres
    void positionBrique(int positionX, int positionY){

        this.posX = positionX;
        this.poxY = positionY;
    
        SetCursorPosition(this.posY, this.posX);
        System.out.print(this.design);
        return;
    }

}