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
        this.y = 20;
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
    public boolean collision(Matrix m) {
        final int cx = getX();
        final int cy = getY();

        // Parcourt les 9 cases autour (y compris le centre)
        for (int dy = -1; dy <= 1; dy++) {
            final int y = cy + dy;
            for (int dx = -1; dx <= 1; dx++) {
                final int x = cx + dx;

                // lecture safe (renvoie ' ' si hors-bounds)
                char cell = m.getChar(x, y);
                System.out.println(cell);
                if (cell != ' ' && cell != 'o') {
                    System.out.println("Collision at (" + x + ", " + y + ") char='" + cell + "'");
                    this.velocity = -this.velocity; // on inverse la direction
                    return true; // on a touché quelque chose → crash
                }
            }
        }
        return false; // rien autour
    }


}
