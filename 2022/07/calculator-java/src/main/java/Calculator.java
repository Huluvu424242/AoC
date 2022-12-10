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
    protected Map<String,Integer> folders=new HashMap<>();



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
                bearbeiteZeile(lineNr,zeile);

                lineNr++;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
         auswertung();
    }

    private void auswertung() {
       final int sum= this.folders
            .keySet()
            .stream()
            .peek(key->System.out.format("\n(1) [%s]=%d",key,folders.getOrDefault(key,0)))
            .filter(key-> folders.getOrDefault(key,0)<=100000)
            .peek(key->System.out.format("\n(2) [%s]=%d",key,folders.getOrDefault(key,0)))
            .map(key -> folders.getOrDefault(key,0))
            .reduce(0,Integer::sum);

       System.out.format("\n\nDie Summe über alle Verzeichnisse <100000 beträgt: %d",sum);

//        .collect(Collectors.summingInt(Integer::intValue))

        //        File.separator
    }

    private void bearbeiteZeile(final int lineNr,final String zeile) {
        if(curPath!=null) {
            System.out.format("\n[%d]: %s", lineNr, zeile);
        }
        if(zeile.matches("\\$ cd /")){
            this.curPath=new File("/");
            System.out.format("\t\t\t\t\t\t|\t%s=[%d]",this.curPath.toString(), folders.getOrDefault(this.curPath.toString(),0));
            return;
        }
        if(zeile.matches("\\$ cd ..")){
            final int size = this.folders.getOrDefault(this.curPath.toString(),0);
            this.curPath=this.curPath.getParentFile();
            this.folders.put(this.curPath.toString(),this.folders.getOrDefault(this.curPath.toString(),0)+size);
            System.out.format("\t\t\t|\t%s=[%d]",this.curPath.toString(), folders.getOrDefault(this.curPath.toString(),0));
            return;
        }
        if(zeile.matches("\\$ cd .*")){
            final String pattern = "\\$ cd (.*)";
            final Pattern r = Pattern.compile(pattern);
            final Matcher m = r.matcher(zeile);
            if (m.find()) {
                final String folderName = m.group(1);
                this.curPath =new File(curPath, folderName);
            }
            System.out.format("\t\t\t|\t%s=[%d]",this.curPath.toString(), folders.getOrDefault(this.curPath.toString(),0));
            return;
        }
        if(zeile.matches("\\d+\\s*\\D+")){
            final String pattern = "(\\d+)\\s*\\D+";
            final Pattern r = Pattern.compile(pattern);
            final Matcher m = r.matcher(zeile);
            if (m.find()) {
                final String fileSize = m.group(1);
                final int size = Integer.parseInt(fileSize);
                this.folders.put(this.curPath.toString(),this.folders.getOrDefault(this.curPath.toString(),0)+size);
            }
            System.out.format("\t\t\t|\t%s=[%d]",this.curPath.toString(), folders.getOrDefault(this.curPath.toString(),0));
            return;
        }
    }
}
