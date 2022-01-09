package ch07_simplification.move_embellishment_to_decorator.repeatedtest;

import java.lang.reflect.Method;
import java.util.Set;

abstract class TestCase implements Test {

    @Override
    public int countTestcases() throws Exception {
        return getThisMethod().length;
    }

    @Override
    public void run() throws Exception {
        Method[] methods = getThisMethod();
        for (Method method : methods) {
            if (notTestMethod(method.getName())) continue;
            method.invoke(this, method.getParameterTypes());
        }
    }

    public void assertEquals(Object expected, Object actual) throws Exception {
        if (!expected.equals(actual)) {
            throw new Exception("not equals <expected>: " + expected + ", <actual>: " + actual);
        }
    }

    private Method[] getThisMethod() {
        return this.getClass().getDeclaredMethods();
    }

    private boolean notTestMethod(String methodName) {
        final Set<String> notTestMethodNames = Set.of("run", "countTestcases");
        return notTestMethodNames.contains(methodName);
    }
}