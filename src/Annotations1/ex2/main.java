package Annotations1.ex2;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class<?> cls = Container.class;
        SaveTo svt = cls.getAnnotation(SaveTo.class);

        Container container = new Container();
        Method[] methods = cls.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Saver.class)) {
                m.invoke(container, svt.path());
            }
        }
    }
}
