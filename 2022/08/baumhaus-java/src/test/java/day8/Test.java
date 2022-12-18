package day8;

import tools.Scanner;

public class Test {
    public static void main(String[] args) {
        Test.testDemoInput();
        Test.testFullInput();
    }
    protected static void testDemoInput(){
        final Main main = new Main();
        final Scanner.Antwort antwort=main.loese("2022/08/", "demo-input.txt");
        if( antwort.teil1.equals("21 Bäume sichtbar.")){
            System.out.format("\n\nDie Antwort ist RICHTIG und lautet\n\n%s\n",antwort.teil1);
        }else{
            System.out.format("\n\nDie Antwort ist FALSCH und lautet\n\n%s\n",antwort.teil1);
        }
        if( antwort.teil2.equals("Der höchste Score ist 8.")){
            System.out.format("\n\nDie Antwort ist RICHTIG und lautet\n\n%s\n",antwort.teil2);
        }else{
            System.out.format("\n\nDie Antwort ist FALSCH und lautet\n\n%s\n",antwort.teil2);
        }
    }
    protected static void testFullInput(){
        final Main main = new Main();
        final Scanner.Antwort antwort=main.loese("2022/08/", "input.txt");
        if( antwort.teil1.equals("1789 Bäume sichtbar.")){
            System.out.format("\n\nDie Antwort ist RICHTIG und lautet\n\n%s\n",antwort.teil1);
        }else{
            System.out.format("\n\nDie Antwort ist FALSCH und lautet\n\n%s\n",antwort.teil1);
        }
        if( antwort.teil2.equals("Der höchste Score ist 314820.")){
            System.out.format("\n\nDie Antwort ist RICHTIG und lautet\n\n%s\n",antwort.teil2);
        }else{
            System.out.format("\n\nDie Antwort ist FALSCH und lautet\n\n%s\n",antwort.teil2);
        }
    }
}
