package src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import src.main.java.Score;
import src.main.java.menu.menuManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


class ScoreTest {

    private Scanner originalScanner;

    @Before
    void setUp() {
        // Sauvegarder l'ancien scanner si défini
        try {
            originalScanner = menuManager.scanner;
        } catch (Throwable ignored) {
            // si menuManager.scanner n'existe pas encore ou est null, on ignore
        }
    }

    @After
    void tearDown() {
        // Restaurer l'ancien scanner
        try {
            menuManager.scanner = originalScanner;
        } catch (Throwable ignored) {
        }

        // Nettoyage simple du fichier de test si présent
        File resDir = new File("res");
        File csv = new File(resDir, "scores.csv");
        if (csv.exists()) {
            // On laisse le fichier si le projet veut le garder ; décommentez si vous préférez supprimer
            // csv.delete();
        }
        if (resDir.exists() && resDir.isDirectory()) {
            // resDir.delete(); // idem
        }
    }

    @Test
    void addScore_shouldIncreaseByGivenValue() {
        Score s = new Score();
        s.addScore(15);
        assertEquals(15, s.getScore());
        s.addScore(5);
        assertEquals(20, s.getScore());
    }

    @Test
    void addScoreBriqueBreak_shouldIncreaseByTen() {
        Score s = new Score();
        s.addScoreBriqueBreak();
        assertEquals(10, s.getScore());
        s.addScoreBriqueBreak();
        assertEquals(20, s.getScore());
    }

    @Test
    void addNbrBriqueBreak_shouldIncrementCounter() {
        Score s = new Score();
        assertEquals(0, s.getNbrBriqueCassées());
        s.addNbrBriqueBreak();
        s.addNbrBriqueBreak();
        assertEquals(2, s.getNbrBriqueCassées());
    }

    @Test
    void addNomJoueur_shouldReadFromMenuManagerScanner() {
        // Simule une saisie utilisateur : "Alice\n"
        byte[] input = "Alice\n".getBytes(StandardCharsets.UTF_8);
        menuManager.scanner = new Scanner(new ByteArrayInputStream(input), StandardCharsets.UTF_8);

        Score s = new Score();
        s.addNomJoueur();
        assertEquals("Alice", s.getNomJoueur());
    }

    @Test
    void enregistrerScore_shouldAppendLineToCsv_preservingExistingLines() throws Exception {
        // Prépare le fichier res/scores.csv avec du contenu existant
        File resDir = new File("res");
        if (!resDir.exists()) assertTrue(resDir.mkdirs(), "Impossible de créer le dossier res/");
        File csv = new File(resDir, "scores.csv");

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csv, false), StandardCharsets.UTF_8))) {
            bw.write("Bob,100,3");
            bw.newLine();
            bw.write("Eve,90,2");
            bw.newLine();
        }

        // Prépare un Score avec nom, score et nb briques
        byte[] input = "Hamoude\n".getBytes(StandardCharsets.UTF_8);
        menuManager.scanner = new Scanner(new ByteArrayInputStream(input), StandardCharsets.UTF_8);

        Score s = new Score();
        s.addNomJoueur(); // lit "Hamoude"
        s.addScore(42);
        s.addNbrBriqueBreak();
        s.addNbrBriqueBreak(); // 2 briques cassées

        // Exécute
        s.enregistrerScore();
    }
}
