import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    protected File curPath;



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
                bearbeiteZeile(zeile);
                System.out.format("\n[%d]: %s ->\n%s [%d]", lineNr, zeile,this.curPath.toString(),0);

                lineNr++;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        // auswertung
//        File.separator
    }

    private void bearbeiteZeile(final String zeile) {
        if(zeile.matches("\\$ cd /")){
            this.curPath=new File("/");
            return;
        }
        if(zeile.matches("\\$ cd ..")){
            this.curPath=this.curPath.getParentFile();
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
            return;
        }
    }
}
