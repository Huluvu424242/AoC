package tools;

import puzzle.Algorithmus;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Scanner {

    protected final Algorithmus algorithmus = new Algorithmus();

    public Scanner() {

    }

    public void erfasseDaten(final Path inputPath) {
        try (java.util.Scanner scanner = new java.util.Scanner(inputPath.toFile())) {
            int lineNr = 1;
            while (scanner.hasNext()) {
                final String zeile = scanner.nextLine();
                algorithmus.bearbeiteZeile(lineNr, zeile);

                lineNr++;
            }
            algorithmus.bearbeiteZeileNach();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        algorithmus.berechneTeil1();
        algorithmus.berechneTeil2();
    }
}
