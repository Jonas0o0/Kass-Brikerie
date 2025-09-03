package src.main.java;

public enum Bonus{
    SLIDER_PLUS_GRAND, HP_PLUS, AJOUT_BALLE, BALLE_RALENTIT;

    public void bonusSlider(){
        Main.s.setTaille(Main.s.getLargeur()+2);
    }

    public void HPPlus(){
        Main.pv.setPoints(Main.pv.getHP()+1);
    }

    /*public void balleRalentit(){
        Main.b.
    }*/
}