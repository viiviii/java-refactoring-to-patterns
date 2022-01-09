package ch07_simplification.move_embellishment_to_decorator.repeatedtest;

public class Client {

    public static void main(String[] args) throws Exception {
        int timesToRunTest = 2;
        Test repeatedShutdownTest = new RepeatedTest(new ServerShutDownTest(), timesToRunTest);
        repeatedShutdownTest.run();
    }
}
