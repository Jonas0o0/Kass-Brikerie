package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.colors.colors;
import src.main.java.inputs.TickInputs;

import src.main.java.menu.menuManager;

public class Main {
    public static Score sc;
    public static HP pv;
    public static Ball b;
    public static Slider s;
    public static ArrayList<Bonus> bonus;
    public static void main(String[] args) throws Exception {
        while (true) {
                // ---- Réglage du tick ----
                final int TPS = 60; // ticks par seconde
                final long STEP_NS = 1_000_000_000L / TPS; // durée d'un tick en ns
                
                Main.sc = new Score();
                Main.pv = new HP(3);
                Main.b = new Ball();
                Main.s = new Slider();
                Mur mr = new Mur();
                Main.bonus = new ArrayList<Bonus>();

                Matrix m = new Matrix();

                menuManager.menuPrincipal();

                sc.addNomJoueur(); // Affichage du choix du Nom du Joueur

                Timer t = new Timer();

                ArrayList<Brique> mur = mr.afficherBriques();
                mr.genererMur(1, 0, 4, 11);
                

                // ---- IMPORTANT : ouvrir le terminal JLine UNE SEULE FOIS ----
                TickInputs.init();

                try {
                        while(true){
                                long now = System.nanoTime();
                                int key = TickInputs.poll(); // a/q = gauche, d = droite, e = quitter
                                if (key == 'm' || key == 'M') {
                                menuManager.menuPrincipal();
                                }
                                if (TickInputs.left())
                                s.move(-1);
                                if (TickInputs.right())
                                s.move(1);


                                Tools.clearScreen();

                                
                                Main.b.collision(m, mr, s);
                                Main.b.move();
                                for(Bonus b : Main.bonus){
                                        b.move();
                                }
                                
                                m.clear(); //toujours clear avant le draw
                                for(int i=0;i<mur.size();i++){
                                        m.draw(mur.get(i).toString(), mur.get(i).getX(), mur.get(i).getY());
                                }

                                for(int i=0;i<Main.bonus.size();i++){
                                        m.draw(Main.bonus.get(i).toString(), Main.bonus.get(i).getX(), Main.bonus.get(i).getY());
                                }

                                m.draw(b.toString(), b.getX(), b.getY());
                                m.draw(s.toString(), s.getX() - (s.getLargeur() / 2), s.getY());
                                
                                System.out.print(m.render());
                                System.out.println("Score " + Main.sc.getNomJoueur() + "-> " + colors.YELLOW + Main.sc.getScore() + colors.WHITE);
                                System.out.println("Temps écoulés -> " + t.getSeconds() + "s" );
                                System.out.println("PV : " + Main.pv);


                                if(pv.gameOver()) {
                                        menuGameOver.gameOverScreen(sc, t);
                                }

                                // 4) Régulation simple (petit sleep pour éviter 100% CPU)
                                long elapsed = System.nanoTime() - now;
                                long sleepNs = STEP_NS - elapsed; // 1 frame ≈ 1 update
                                if (sleepNs > 0) {
                                long ms = sleepNs / 1_000_000L;
                                int ns = (int) (sleepNs % 1_000_000L);
                                try {
                                        Thread.sleep(ms, ns);
                                } catch (InterruptedException ignored) {
                                }
                                }
                                TickInputs.LEFT.set(false);
                                TickInputs.RIGHT.set(false);
                        }
                } finally {
                        // Toujours fermer proprement
                        TickInputs.shutdown();
                }
        }
    }
}
