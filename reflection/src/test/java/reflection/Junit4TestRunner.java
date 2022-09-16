package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;

        final Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            invokeWhenWithAnnotation(method);
        }
    }

    private void invokeWhenWithAnnotation(final Method method)
            throws IllegalAccessException, InvocationTargetException {
        if (method.isAnnotationPresent(MyTest.class)) {
            method.invoke(new Junit4Test());
        }
    }
}
