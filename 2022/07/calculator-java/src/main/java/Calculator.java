import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {
        final Path inputPath = Path.of("2022/07/demo-input.txt");
        System.out.format("Path: %s", inputPath.toAbsolutePath());
        final Calculator calculator = new Calculator();
        calculator.erfasseDaten(inputPath);
    }

    protected void erfasseDaten(final Path inputPath) {
        try (Scanner scanner = new Scanner(inputPath.toFile())) {
            int lineNr = 1;
            while (scanner.hasNext()) {
                final String zeile = scanner.nextLine();
//                final int posPacketMarker = getMarkerPosFrom(zeile,4);
//                final int posMessageMarker = getMarkerPosFrom(zeile,14);
                System.out.format("\n[%d]: %s -> ", lineNr, zeile);

                lineNr++;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
