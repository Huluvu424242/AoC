import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    protected File curPath;
    protected Map<String, Integer> folders = new HashMap<>();


    public static void main(String[] args) {
        final Path inputPath = Path.of("2022/07/input.txt");
        System.out.format("Path: %s", inputPath.toAbsolutePath());
        final Calculator calculator = new Calculator();
        calculator.erfasseDaten(inputPath);
    }

    protected void erfasseDaten(final Path inputPath) {
        try (Scanner scanner = new Scanner(inputPath.toFile())) {
            int lineNr = 1;
            while (scanner.hasNext()) {
                final String zeile = scanner.nextLine();
                bearbeiteZeile(lineNr, zeile);

                lineNr++;
            }
            // falls wir am Ende in einem Subpath sind berechnen wir noch die parents
            while (curPath.toString().length() > 1) {
                bearbeiteZeile(-1, "$ cd ..");
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        berechneTeil1();
        berechneTeil2();
    }

    private void berechneTeil1() {
        final int sum = this.folders
            .keySet()
            .stream()
            .filter(key -> folders.getOrDefault(key, 0) <= 100000)
            .map(key -> folders.getOrDefault(key, 0))
            .reduce(0, Integer::sum);

        System.out.format("\n\n(I) Die Summe über alle Verzeichnisse <100000 beträgt: %d\n\n", sum);
    }

    private void berechneTeil2() {
        final int MEMORY_SPACE_ALL = 70000000;
        final int root = folders.getOrDefault((new File("/")).toString(), 0);
        final int UNUSED_MEMORY = MEMORY_SPACE_ALL - root;
        final int MEMORY_SPACE_TOFREE = 30000000;
        final int MIN_FREED_MEMORY = MEMORY_SPACE_TOFREE - UNUSED_MEMORY;
        final Top top = new Top();

        System.out.format("\nGesamt: %d\nRoot: %d\nUnused: %d\nNeeded: %d\nMin: %d\n",MEMORY_SPACE_ALL,root,UNUSED_MEMORY,MEMORY_SPACE_TOFREE,MIN_FREED_MEMORY);

        this.folders
            .keySet()
            .stream()
            .peek(key -> System.out.format("\n(1) [%s]=%d", key, folders.getOrDefault(key, 0)))
            .filter(key -> folders.getOrDefault(key, 0) >= MIN_FREED_MEMORY)
            .peek(key -> System.out.format("\n(2) [%s]=%d", key, folders.getOrDefault(key, 0)))
            .forEach(key -> {
                final int freedMemory = folders.getOrDefault(key, 0);
                final int freedDelta = MEMORY_SPACE_TOFREE - UNUSED_MEMORY - freedMemory;
                if(top.freedMemoryBestFolder==0){
                    top.freedMemoryBestFolder=freedMemory+1;
                }
                if (freedMemory < top.freedMemoryBestFolder) {
                    top.freedMemoryBestFolder = freedMemory;
                    top.curDeltaOfMemory = freedDelta;
                    System.out.format("\n(3-YES) [%s] freedMemory=%d, freedDelta:=%d, bestFreedMemory=%d, bestDelta=%d", key, freedMemory, freedDelta, top.freedMemoryBestFolder, top.curDeltaOfMemory);
                }
                else{
                    System.out.format("\n(4-NO) [%s] freedMemory=%d, freedDelta:=%d, bestFreedMemory=%d, bestDelta=%d", key, freedMemory,freedDelta,top.freedMemoryBestFolder,top.curDeltaOfMemory);
                }
            });

        System.out.format("\n\n(II) Der vom best geeignetsten Verzeichnis freigegebene Platz beträgt: %d", top.freedMemoryBestFolder);
    }


    private void bearbeiteZeile(final int lineNr, final String zeile) {
        if (curPath != null) {
            System.out.format("\n[%d]: %s", lineNr, zeile);
        }
        if (zeile.matches("\\$ cd /")) {
            this.curPath = new File("/");
            System.out.format("\t\t\t\t\t\t|\t%s=[%d]", this.curPath.toString(), folders.getOrDefault(this.curPath.toString(), 0));
            return;
        }
        if (zeile.matches("\\$ cd ..")) {
            final int size = this.folders.getOrDefault(this.curPath.toString(), 0);
            this.curPath = this.curPath.getParentFile();
            this.folders.put(this.curPath.toString(), this.folders.getOrDefault(this.curPath.toString(), 0) + size);
            System.out.format("\t\t\t|\t%s=[%d]", this.curPath.toString(), folders.getOrDefault(this.curPath.toString(), 0));
            return;
        }
        if (zeile.matches("\\$ cd .*")) {
            final String pattern = "\\$ cd (.*)";
            final Pattern r = Pattern.compile(pattern);
            final Matcher m = r.matcher(zeile);
            if (m.find()) {
                final String folderName = m.group(1);
                this.curPath = new File(curPath, folderName);
            }
            System.out.format("\t\t\t|\t%s=[%d]", this.curPath.toString(), folders.getOrDefault(this.curPath.toString(), 0));
            return;
        }
        if (zeile.matches("\\d+\\s*\\D+")) {
            final String pattern = "(\\d+)\\s*\\D+";
            final Pattern r = Pattern.compile(pattern);
            final Matcher m = r.matcher(zeile);
            if (m.find()) {
                final String fileSize = m.group(1);
                final int size = Integer.parseInt(fileSize);
                this.folders.put(this.curPath.toString(), this.folders.getOrDefault(this.curPath.toString(), 0) + size);
            }
            System.out.format("\t\t\t|\t%s=[%d]", this.curPath.toString(), folders.getOrDefault(this.curPath.toString(), 0));
        }
    }
}

class Top {
    public int freedMemoryBestFolder = 0;
    public int curDeltaOfMemory = 0;
}
