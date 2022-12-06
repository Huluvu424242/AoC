import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stapel {

    public static int HEAD_LINE_NR = 1;
    public static int BOTTOM_LINE_NR = 10;
    public static int TOP_ACTION_LINE_NR = BOTTOM_LINE_NR + 1;


    protected void rechne() {
        final Path inputPath = Path.of("2022/05/demo-input.txt");
        erfasseStacks(inputPath);
        System.out.format("Path: %s", inputPath.toAbsolutePath().toString());
    }

    protected void erfasseStacks(final Path inputPath) {
        final Map<Integer, Haufen> stacks = new HashMap<>();
        try (Scanner scanner = new Scanner(inputPath.toFile())) {
            int lineNr = HEAD_LINE_NR;
            while (scanner.hasNext()) {
                final String zeile = scanner.nextLine();
                if (lineNr == HEAD_LINE_NR) {
                    System.out.format("[%d]: %s\n", lineNr, zeile);
                }else if (lineNr > HEAD_LINE_NR && lineNr < BOTTOM_LINE_NR) {
                    if(zeile.trim().length()>0) {
                        erfassung(stacks, zeile);
                    }
                } else if (lineNr == BOTTOM_LINE_NR) {
                    System.out.format("[%d]: %s\n", lineNr, zeile);
                    umdrehen(stacks);
                    printStacksVertical(stacks);
                } else {
                    executeAction(stacks,lineNr, zeile);
                }

                lineNr++;
            }
            printStacksVertical(stacks);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    protected void executeAction(final Map<Integer, Haufen> stacks, final int zeilenNr, final String zeile) {
        System.out.format("(%d): %s\n", zeilenNr, zeile);
        final String pattern = "move (\\d+) from (\\d+) to (\\d+)";
        final Pattern r = Pattern.compile(pattern);
        final Matcher m = r.matcher(zeile);
        if (m.find()) {
            final String group1 = m.group(1);
            final String group2 = m.group(2);
            final String group3 = m.group(3);

            final int anzahl = Integer.parseInt(group1);
            final int vonNr = Integer.parseInt(group2);
            final int zuNr = Integer.parseInt(group3);
            System.out.format("Verschiebe %d von %d zu %d.\n",anzahl,vonNr,zuNr);

            final Haufen fromHaufen = stacks.get(vonNr-1);
            final Haufen toHaufen = stacks.get(zuNr-1);
            for (int i = 0; i < anzahl; i++) {
                toHaufen.push(fromHaufen.pop());
            }
            stacks.put(vonNr-1,fromHaufen);
            stacks.put(zuNr-1,toHaufen);
            printStacksVertical(stacks);
        }

    }

    protected void erfassung(final Map<Integer, Haufen> stacks, final String line) {
        int stackNr = 0;
        for (char zeichen : line.toCharArray()) {
            final Haufen stack = stacks.getOrDefault(stackNr, new Haufen());
            if(!Character.isSpaceChar(zeichen)) {
                stack.push(zeichen);
                stacks.put(stackNr, stack);
            }
            stackNr++;
        }
    }

    protected void umdrehen(final Map<Integer, Haufen> stacks) {
        for (int haufenIndex = 0; haufenIndex < stacks.size(); haufenIndex++) {
            final Haufen curHaufen = stacks.get(haufenIndex);
            final Haufen inverseHaufen = new Haufen();
            for (int i = curHaufen.size() - 1; i > -1; i--) {
                inverseHaufen.push(curHaufen.pop());
            }
            if (curHaufen.size() > 0) {
                System.err.format("Der Haufen %d hat noch Elemente!!! %s", (haufenIndex + 1), curHaufen);
            }
            stacks.put(haufenIndex, inverseHaufen);
        }
    }

    protected void printStacksVertical(final Map<Integer, Haufen> stacks) {
        for (int haufenIndex = 0; haufenIndex < stacks.size(); haufenIndex++) {
            final Haufen stack = stacks.get(haufenIndex);
            System.out.format("|%d|:%s<\n", (haufenIndex + 1), stack.toString());
        }
    }


    public static void main(String[] args) {
        final Stapel stapel = new Stapel();
        stapel.rechne();
    }
}

class Haufen extends Stack<Character> {
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        for (Character character : this) {
            str.append(character);
        }
        return str.toString();
    }
}
