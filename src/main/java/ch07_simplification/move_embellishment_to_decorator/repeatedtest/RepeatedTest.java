package ch07_simplification.move_embellishment_to_decorator.repeatedtest;

public class RepeatedTest extends TestDecorator {
    private final Test test;
    private final int repeat;

    public RepeatedTest(Test test, int repeat) {
        this.test = test;
        this.repeat = repeat;
    }

    @Override
    public int countTestcases() throws Exception {
        return test.countTestcases() * repeat;
    }

    @Override
    public void run() throws Exception {
        for (int i = 0; i < repeat; i++) {
            test.run();
        }
    }
}
