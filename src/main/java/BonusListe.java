package src.main.java;

public enum BonusListe{
    SLIDER_PLUS_GRAND("♦"), 
    HP_PLUS("♥"), 
    AJOUT_BALLE("♠"), 
    BALLE_RALENTIE("♣");

    public String logo;

    BonusListe(String logo){
        this.logo = logo;
    }
}