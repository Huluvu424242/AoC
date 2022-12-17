package puzzle;

import tools.Scanner;

import java.nio.file.Path;

public class Main {


    public static void main(String[] args) {
        final Path rootPath = Path.of("2022/08/");
        final Path inputPath = Path.of(rootPath.toString(), "input.txt");
        System.out.format("Path: %s", inputPath.toAbsolutePath());
        final Scanner baumhaus = new Scanner();
        baumhaus.erfasseDaten(inputPath);
    }


}
