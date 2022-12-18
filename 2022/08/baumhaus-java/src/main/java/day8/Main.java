package day8;

import tools.Scanner;

import java.nio.file.Path;

public class Main {

    public Scanner.Antwort loese(final String folderName, final String inputFileName ) {
        final Path rootPath = Path.of(folderName);
        final Path inputPath = Path.of(rootPath.toString(), inputFileName);
        System.out.format("\n\nPath: %s", inputPath.toAbsolutePath());
        final Scanner scanner = new Scanner(new Algorithmus());
       return scanner.erfasseDaten(inputPath);
    }

}
