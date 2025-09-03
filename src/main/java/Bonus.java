package src.main.java;

import java.util.Random;
import java.util.ArrayList;

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
        this.y += 0.3;
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

    public static void remove(ArrayList<Bonus> list, Bonus b){
        list.remove(b);
    }

    public static void check(ArrayList<Bonus> list, Bonus b){
        if(b.getX()>=Main.s.getX() && b.getX()<=(Main.s.getX()+Main.s.getLargeur()) && b.getY()==Main.s.getY()){
            if(b.bonus.logo==BonusListe.SLIDER_PLUS_GRAND.logo){
                b.bonusSlider();
                remove(list, b);
            }
            else if(b.bonus.logo==BonusListe.HP_PLUS.logo){
                b.HPPlus();
                remove(list, b);
            }else if(b.bonus.logo==BonusListe.AJOUT_BALLE.logo){
                ArrayList<Ball> newBall = new ArrayList<>();
                for (Ball ball : Main.bs){
                    newBall.add(new Ball(ball.getX(), ball.getY(), -ball.getVx(), ball.getVy()));
                    newBall.add(new Ball(ball.getX(), ball.getY(), ball.getVx(), -ball.getVy()));
                }
                Main.bs.addAll(newBall);
                remove(list, b);
            }else{
                for(Ball ball : Main.bs){
                    ball.setVx(ball.getVx()/2);
                    ball.setVy(ball.getVy()/2);
                }
                remove(list, b);
            }
        }
        else if(b.getY()>Matrix.resy){
            remove(list, b);
        }
    }
}