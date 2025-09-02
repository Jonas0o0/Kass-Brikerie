package src.main.java;

import java.util.Arrays;

public class Matrix {
    static final int resx = 100; // largeur intérieure (hors bordure)
    static final int resy = 40;  // hauteur intérieure (hors bordure)

    private final char[][] buf = new char[resy][resx];

    public Matrix() {
        clear();
    }

    /** Remplit le buffer d'espaces. */
    public void clear() {
        for (int i = 0; i < resy; i++) {
            Arrays.fill(this.buf[i], ' ');
        }
    }
    

    /** Dessine S (multi-ligne) à partir de (x,y) sans écraser avec du vide. */
    public void draw(String s, int x, int y) {
        if (s == null) return;
        String[] lines = s.split("\\R", -1); // garde lignes vides
        for (int dy = 0; dy < lines.length; dy++) {
            int yy = y + dy;
            if (yy < 0 || yy >= resy) continue; // hors écran vertical → on skip

            String line = lines[dy];
            for (int dx = 0; dx < line.length(); dx++) {
                int xx = x + dx;
                if (xx < 0 || xx >= resx) continue; // hors écran horizontal

                char c = line.charAt(dx);

                // On "supprime les caractères vides" : on n'écrit pas les blancs.
                // => pas d'écrasement par des espaces/tabs.
                if (!Character.isWhitespace(c)) {
                    this.buf[yy][xx] = c;
                }
            }
        }
    }

    /** Retourne la matrice avec bordure en #. */
    public String render() {
        StringBuilder out = new StringBuilder();

        // Ligne du haut
        System.out.println();
        for (int j = 0; j < resx + 2; j++) out.append('#');
        out.append('\n');

        // Corps + bordures latérales
        for (int i = 0; i < resy; i++) {
            out.append('#');
            out.append(this.buf[i]);
            out.append('#').append('\n');
        }

        // Ligne du bas
        for (int j = 0; j < resx + 2; j++) out.append('#');
        out.append('\n');

        return out.toString();
    }

    public char getChar(int posX, int posY){
        if (posX < 0 || posX >= resx || posY < 0 || posY >= resy) return '#'; // hors écran => vide
        return this.buf[posY][posX];
    }

}
