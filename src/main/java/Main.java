package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.colors.colors;
import src.main.java.inputs.TickInputs;
import src.main.java.menu.menuGameOver;
import src.main.java.menu.menuManager;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class Main {
        public final static int X_MUR = 30;
        public final static int Y_MUR = 20;
        public final static int HAUTEUR_MUR = 1;
        public final static int LARGEUR_MUR = 1;

    public static Score sc;
    public static HP pv;
    public static ArrayList<Ball> bs;
    public static Slider s;
    public static ArrayList<Bonus> bonus;
    public static ArrayList<Ball> destroyBalls;
    public static void main(String[] args) throws Exception {
        Signal.handle(new Signal("INT"), new SignalHandler() {
        @Override
        public void handle(Signal sig) {
                System.out.println("Ctrl+C détecté mais ignoré !");
                // Ne rien faire -> le programme continue
        }
        });
        Signal.handle(new Signal("TERM"), new SignalHandler() {
        @Override
        public void handle(Signal sig) {
                System.out.println("Ctrl+\\ détecté mais ignoré !");
        }
        });
        while (true) {
                // ---- Réglage du tick ----
                final int TPS = 60; // ticks par seconde
                final long STEP_NS = 1_000_000_000L / TPS; // durée d'un tick en ns

                boolean loose = false;
                
                Main.sc = new Score();
                Main.pv = new HP(3);
                Main.s = new Slider();
                Main.bs = new ArrayList<Ball>();
                Main.bs.add(new Ball(s.getX(), s.getY()-2));
                Mur mr = new Mur();
                Main.bonus = new ArrayList<Bonus>();
                Main.destroyBalls = new ArrayList<Ball>();
                int nbStages = 1;

                Matrix m = new Matrix();
                menuManager.scanner = new Scanner(System.in);
                menuManager.menuPrincipal();

                sc.addNomJoueur(); // Affichage du choix du Nom du Joueur

                Timer t = new Timer();

                ArrayList<Brique> mur = mr.afficherBriques();
                mr.genererMur(X_MUR, Y_MUR, HAUTEUR_MUR, LARGEUR_MUR);
                

                // ---- IMPORTANT : ouvrir le terminal JLine UNE SEULE FOIS ----
                TickInputs.init();

                try {
                        while(!loose){
                                long now = System.nanoTime();
                                int key = TickInputs.poll(); // a/q = gauche, d = droite, e = quitter
                                if (key == 'm' || key == 'M') {
                                        menuManager.menuPrincipal();
                                }
                                if (TickInputs.left()){
                                        if(s.getX()>(s.getLargeur()/2)){
                                                s.move(-1);
                                        }
                                }if (TickInputs.right()){
                                        if(s.getX()<Matrix.resx-(s.getLargeur()/2)){
                                                s.move(1);
                                        }
                                }

                                if(mr.detruit()){
                                        nbStages++;
                                        mr.genererMur(X_MUR, Y_MUR, HAUTEUR_MUR, LARGEUR_MUR);      
                                        bs.clear();
                                        bs.add(new Ball(s.getX(), s.getY()-2));                                
                                }


                                //verifie tous les bonus, les appliques et les supprimes si en dehors de l'écran
                                for(int i = 0; i<bonus.size(); i++){
                                        Bonus.check(bonus, bonus.get(i));
                                }

                                Tools.clearScreen();

                                for(int i = 0; i<Main.bs.size(); i++){
                                        Main.bs.get(i).collision(m, mr, s);
                                        Main.bs.get(i).move();
                                }

                                Main.bs.removeAll(Main.destroyBalls);
                                Main.destroyBalls.clear();
                                if (Main.bs.size() == 0){
                                        Main.pv.perdu();
                                        Main.bs.add(new Ball(s.getX(), s.getY()-2));
                                }
                                
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

                                for(int i = 0; i<Main.bs.size(); i++){
                                        m.draw(Main.bs.get(i).toString(), Main.bs.get(i).getX(), Main.bs.get(i).getY());
                                }
                                
                                m.draw(s.toString(), s.getX() - (s.getLargeur() / 2), s.getY());
                                
                                System.out.print(m.render());
                                System.out.println("Score " + Main.sc.getNomJoueur() + "-> " + colors.YELLOW + Main.sc.getScore() + colors.WHITE);
                                System.out.println("Temps écoulés -> " + t.getSeconds() + "s" );
                                System.out.println("PV : " + Main.pv);
                                System.out.println("N° de stage en cours : " + nbStages);

                                if(pv.gameOver()) {
                                        menuGameOver.gameOverScreen(t);
                                        loose = true;
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
