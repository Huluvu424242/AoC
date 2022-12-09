import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Detector {

    public static void main(String[] args) {
        final Path inputPath = Path.of("2022/06/demo-input.txt");
        System.out.format("Path: %s", inputPath.toAbsolutePath());
        final Detector detector=new Detector();
        detector.erfasseDaten(inputPath);
    }

    protected void erfasseDaten(final Path inputPath) {
        try (Scanner scanner = new Scanner(inputPath.toFile())) {
            int lineNr = 1;
            while (scanner.hasNext()) {
                final String zeile = scanner.nextLine();
                final int pos = getMarkerPosFrom(zeile);
                System.out.format("\n[%d]: %s -> %d",lineNr,zeile,pos);

                lineNr++;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    protected int getMarkerPosFrom(String zeile){
        // len 0-3
        Queue<Character> fifo = new LinkedList<>();
        for (int i = 0; i < zeile.length() ; i++) {
            final char zeichen = zeile.charAt(i);
            if ( fifo.size() == 4) {
                fifo.remove();
            }
            fifo.add(zeichen);
            final Set<Character> set = new HashSet<>(fifo);
            if(set.size()==4) return i+1;
        }
        return -1;
    }
}


