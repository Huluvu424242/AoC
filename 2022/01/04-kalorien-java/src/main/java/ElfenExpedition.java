
import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class ElfenExpedition {

    public static void main(String[] args) {
        final ElfenExpedition elfenExpedition = new ElfenExpedition();
        elfenExpedition.berechne();
    }

    public static class Elf {

        int nr = 0;
        int cal = 0;
        public Elf(int nr, int kalorien){
            this.nr =nr;
            this.cal =kalorien;
        };

        public String toString(){
            return "\nElf Nr: "+this.nr + " trägt "+this.cal+ " Kalorien. ";
        }

    }

    /**
     * key: elfNr
     * value: kalorien
     */
    protected Map<Integer,Integer> elfenMap = new HashMap<>();

    protected int curElfNr = 0;

    protected void berechne() {
        final Path path = Path.of("2022/01/04-kalorien-java/src/main/java/", "input.txt");
        System.out.format("Path: %s \n", path.toAbsolutePath());
        try (Scanner scanner = new Scanner(path.toFile())) {
            while (scanner.hasNext()) {
                erfassung(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        auswertung();
    }

    protected void auswertung() {
        final List<Elf> elfen = this.elfenMap.entrySet().stream()
            .map(entry -> new Elf(entry.getKey(), entry.getValue()))
            .map(entry->{System.out.println(entry);return entry;})
            .sorted(Comparator.comparingInt(o -> o.cal)).toList();

        final Elf firstElf = elfen.get(elfen.size()-1);
        final Elf secondElf = elfen.get(elfen.size()-2);
        final Elf thirdElf = elfen.get(elfen.size()-3);
        System.out.format("\n\nDer Elf mit den meisten Kalorien ist Elf Nr: %d mit %d Kalorien",firstElf.nr,firstElf.cal);
        System.out.format("\n\nDer Elf mit den meisten Kalorien ist Elf Nr: %d mit %d Kalorien",secondElf.nr,secondElf.cal);
        System.out.format("\n\nDer Elf mit den meisten Kalorien ist Elf Nr: %d mit %d Kalorien",thirdElf.nr,thirdElf.cal);

        System.out.format("\n\nDie Top 3 Elfen tragen zusammen %d Kalorien.", (firstElf.cal+secondElf.cal+thirdElf.cal));

    }
    protected void erfassung(String line) {
        final String trimmedLine = line.trim();
        if (trimmedLine.length() > 0) {
            final Integer aufzunehmendeKalorien = Integer.parseInt(trimmedLine);
            final Integer curKalorien= this.elfenMap.getOrDefault(this.curElfNr, 0);
            final Integer neuKalorien = curKalorien + aufzunehmendeKalorien;
            this.elfenMap.put(this.curElfNr,neuKalorien);
            System.out.format("\n    Elf %d lädt %d Kalorien",this.curElfNr,  aufzunehmendeKalorien);
        } else {
            System.out.format("\n### Elf %d trägt %d Kalorien",this.curElfNr,  this.elfenMap.getOrDefault(this.curElfNr,0));
            this.curElfNr++;
        }
    }


}
