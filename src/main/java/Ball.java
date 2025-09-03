package src.main.java;

import src.main.java.colors.colors;

public class Ball implements Drawing, Move {
    private double x;
    private double y;
    public static final int HAUTEUR = 1;
    public static final int LARGEUR = 1;
    private double velocity = 1;

    Ball() {
        this.x = 50;
        this.y = 34;
    }

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return (int) this.x;
    }

    public int getY() {
        return (int) this.y;
    }

    @Override
    public String toString() {
        return "o";
    }

    public void move() {
        this.y -= velocity;
    }

    /** Collision "point" : on crashe si la case courante OU voisine contient un non-espace. */
    public boolean collision(Matrix m, Mur mur) {
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
                //System.out.println(cell);
                if (cell != ' ' && cell != 'o' && y == 40) {
                    if (!loose){
                        Main.pv.perdu();
                        Main.b = new Ball();
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
                    this.velocity = -this.velocity;
                    //System.out.println("Brique toucer");
                }else if (cell != ' ' && cell != 'o'){
                    this.velocity = -this.velocity;
                }

            }
        }
        return false; // rien autour
    }


}
