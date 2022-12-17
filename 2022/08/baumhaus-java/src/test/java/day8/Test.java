package day8;

public class Test {
    public static void main(String[] args) {
        Test.testDemoInput();
        Test.testFullInput();
    }
    protected static void testDemoInput(){
        final Main main = new Main();
        main.loese("2022/08/", "demo-input.txt");
    }
    protected static void testFullInput(){
        final Main main = new Main();
        main.loese("2022/08/", "input.txt");
    }
}
