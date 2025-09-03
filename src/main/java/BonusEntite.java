package src.main.java;

public class BonusEntite implements Drawing{

    private int posX;
    private int posY;
    
    public BonusEntite(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getX(){
        return this.posX;
    }    

    public int getY(){
        return this.posY;
    }

    public int getLargeur(){
        return 1;
    }

    public int getHauteur(){
        return 1;
    }

    public void bonusSlider(){
        Main.s.setTaille(Main.s.getLongueur()+2);
    }

    public void HPPlus(){
        Main.pv.setPoints(Main.pv.getHP()+1);
    }
}