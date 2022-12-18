package tools;

import day8.Algorithmus;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Scanner {

    public static class Antwort{
        public String teil1;
        public String teil2;
    }

    final protected Antwort antwort = new Antwort();

    protected final Algorithmus algorithmus;

    public Scanner(final Algorithmus algorithmus) {
        this.algorithmus = algorithmus;
    }

    public Antwort erfasseDaten(final Path inputPath) {
        try (java.util.Scanner scanner = new java.util.Scanner(inputPath.toFile())) {
            int lineNr = 1;
            while (scanner.hasNext()) {
                final String zeile = scanner.nextLine();
                algorithmus.verarbeiteZeile(lineNr, zeile);

                lineNr++;
            }
            algorithmus.zeilenNachbearbeitung();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        antwort.teil1 =algorithmus.berechneTeil1();
        antwort.teil2 =algorithmus.berechneTeil2();

        return antwort;
    }
}
