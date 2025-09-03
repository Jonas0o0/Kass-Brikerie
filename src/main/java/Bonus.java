package src.main.java;

import java.util.Random;

public class Bonus implements Drawing, Move{

    private double x;
    private double y;
    private BonusListe bonus;
    
    public Bonus(double posX, double posY){
        this.x = posX;
        this.y = posY;
        Random alea = new Random();
            this.bonus = BonusListe.values()[alea.nextInt(BonusListe.values().length)];
    }

    public int getX(){
        return (int) this.x;
    }    

    public int getY(){
        return (int) this.y;
    }

    public int getLargeur(){
        return 1;
    }

    public int getHauteur(){
        return 1;
    }

    public void move(){
        this.y += 0.2;
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