package Annotations1.ex1;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        final Class<?> cls = Tester.class;
        Method[] methods = cls.getMethods();

        Tester tester = new Tester();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                Test ts = m.getAnnotation(Test.class);
                m.invoke(tester, ts.a(), ts.b());
            }
        }

    }
}
