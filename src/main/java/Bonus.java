package src.main.java;

import java.util.Random;

public class Bonus implements Drawing, Move{

    private int x;
    private int y;
    private BonusListe bonus;
    
    public Bonus(int posX, int posY){
        this.x = posX;
        this.y = posY;
        Random alea = new Random();
            this.bonus = BonusListe.values()[alea.nextInt(BonusListe.values().length)];
    }

    public int getX(){
        return this.x;
    }    

    public int getY(){
        return this.y;
    }

    public int getLargeur(){
        return 1;
    }

    public int getHauteur(){
        return 1;
    }

    public void move(){
        this.y += 1;
    }

    public void bonusSlider(){
        Main.s.setTaille(Main.s.getLargeur()+2);
    }

    public void HPPlus(){
        Main.pv.setPoints(Main.pv.getHP()+1);
    }

    public String toString(){
        return "" + this.bonus;
    }
}