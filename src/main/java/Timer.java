package src.main.java;

public class Timer{

    private final long debut;

    public Timer(){
        this.debut = System.nanoTime();
    }

    public double getSeconds(){
        return (System.nanoTime()-debut)/1000000000;
    }
}


