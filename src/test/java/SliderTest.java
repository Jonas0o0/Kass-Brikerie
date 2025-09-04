package src.test.java;

import org.junit.jupiter.api.Test;

import src.main.java.Slider;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.nio.charset.StandardCharsets;


// import static org.junit.Assert.*; // Removed to avoid ambiguity

public class SliderTest {

    @Test
    public void defaultConstructor_shouldInitExpectedDefaults() {
        Slider s = new Slider();
        assertEquals(50, s.getX());
        assertEquals(35, s.getY());
        assertEquals(10, s.getLargeur());
        assertEquals(1, s.getHauteur());
    }

    @Test
    public void customConstructor_shouldSetFields() {
        Slider s = new Slider(3, 4, 7);
        assertEquals(3, s.getX());
        assertEquals(4, s.getY());
        assertEquals(7, s.getLargeur());
        assertEquals(1, s.getHauteur());
    }

    @Test
    public void setTaille_shouldUpdateLargeur() {
        Slider s = new Slider(0, 0, 5);
        assertEquals(5, s.getLargeur());
        s.setTaille(12);
        assertEquals(12, s.getLargeur());
    }

    @Test
    public void affichage_shouldPrintExactlyLargeurSquares() {
        Slider s = new Slider(0, 0, 6);

        // Capture System.out
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));
            s.affichage();
        } finally {
            System.setOut(originalOut);
        }

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(repeatSquares(6), output);
    }

    @Test
    public void toString_shouldReturnSquaresString() {
        Slider s = new Slider(0, 0, 4);
        assertEquals(repeatSquares(4), s.toString());
    }

    @Test
    public void move_noArg_shouldIncrementXBy2() {
        Slider s = new Slider(10, 0, 3);
        s.move();
        assertEquals(12, s.getX());
        s.move();
        assertEquals(14, s.getX());
    }

    @Test
    public void move_withArg_shouldAddDirection() {
        Slider s = new Slider(0, 0, 3);
        s.move(5);
        assertEquals(5, s.getX());
        s.move(-2);
        assertEquals(3, s.getX());
        s.move(0);
        assertEquals(3, s.getX());
    }

    // -------- utils --------
    private static String repeatSquares(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) sb.append("◼");
        return sb.toString();
    }
}
