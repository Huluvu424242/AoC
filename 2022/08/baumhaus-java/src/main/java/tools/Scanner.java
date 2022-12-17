package tools;

import day8.Algorithmus;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Scanner {

    protected final Algorithmus algorithmus;

    public Scanner(final Algorithmus algorithmus) {
        this.algorithmus = algorithmus;
    }

    public void erfasseDaten(final Path inputPath) {
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
        algorithmus.berechneTeil1();
        algorithmus.berechneTeil2();
    }
}
