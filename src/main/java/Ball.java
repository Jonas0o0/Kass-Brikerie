package src.main.java;

import java.util.ArrayList;

import src.main.java.colors.colors;

public class Ball implements Drawing, Move {
    private double x;
    private double y;
    public final int HAUTEUR = 1;
    public final int LARGEUR = 1;
    
    private double vx = +0.1;
    private double vy = -0.2;

    Ball() {
        this.x = 50;
        this.y = 20;
    }

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Ball(int x, int y, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public int getX() {
        return (int) this.x;
    }

    public int getY() {
        return (int) this.y;
    }

    public double getVx(){
        return this.vx;
    }

    public double getVy(){
        return this.vy;
    }

    public int getLargeur(){
        return this.LARGEUR;
    }

    public int getHauteur(){
        return this.HAUTEUR;
    }

    @Override
    public String toString() {
        return "o";
    }

    public void move() {
        this.y += vy;
        this.x += vx;
    }

    /** Collision "point" : on crashe si la case courante OU voisine contient un non-espace. */
    public boolean collision(Matrix m, Mur mur, Slider s) {
        final int cx = getX();
        final int cy = getY();
        boolean loose = false;

        // Parcourt les 9 cases autour (y compris le centre)
        for (int dy = -1; dy <= 1; dy++) {
            int y = cy + dy;
            for (int dx = -1; dx <= 1; dx++) {
                int x = cx + dx;

                // lecture safe (renvoie ' ' si hors-bounds)
                char cell = m.getChar(x, y);
                
                if (cell != ' ' && cell != 'o' && y == Matrix.resy) {
                    Main.bs.remove(this);
                    if (!loose && Main.bs.size() == 0){
                        Main.pv.perdu();
                        Main.bs.add(new Ball());
                        loose = true;
                    }
                }else if ((cell == ':' || cell == '.') && cell != 'o'){
                    Brique des = null;
                    for (Brique b : mur.afficherBriques()){
                        if (b.collision(x,y)){
                            des = b;
                        }
                    }
                    mur.destroy(des);
                    this.bounce(des);
                }else if (cell == '◼' && cell != 'o'){
                    this.bounce(s);
                }else if (cell == '#' && cell != 'o' && y <= 1){
                    this.bounce(new Rect(0, 0, Matrix.resx, 1));
                }
                else if (cell == '#' && cell != 'o'){
                    if (x <= 1){
                        this.bounce(new Rect(0, 0, 1, Matrix.resy));
                    }else{
                        this.bounce(new Rect(Matrix.resx, 0, 1, Matrix.resy));
                    }
                }

            }
        }
        return false; // rien autour
    }

    private void bounce(Drawing r) {
        if (r == null) return;
        double overlapLeft   = (x + LARGEUR) - r.getX();
        double overlapRight  = (r.getX() + r.getLargeur()) - x;
        double overlapTop    = (y + HAUTEUR) - r.getY();
        double overlapBottom = (r.getY() + r.getHauteur()) - y;

        // Trouver la pénétration minimale (la plus petite)
        double minOverlapX = Math.min(overlapLeft, overlapRight);
        double minOverlapY = Math.min(overlapTop, overlapBottom);

        if (minOverlapX < minOverlapY) {
            // collision horizontale → inverser vx
            vx = -vx;
            if (overlapLeft < overlapRight) {
                x = r.getX() - LARGEUR; // recaler balle à gauche
            } else {
                x = r.getX() + r.getLargeur(); // recaler balle à droite
            }
        } else {
            // collision verticale → inverser vy
            vy = -vy;
            if (overlapTop < overlapBottom) {
                y = r.getY() - HAUTEUR; // recaler balle au-dessus
            } else {
                y = r.getY() + r.getHauteur(); // recaler balle en dessous
            }
        }
    }

    public void setVx(double vx){
        this.vx = vx;
    }

    public void setVy(double vy){
        this.vy = vy;
    }

}
