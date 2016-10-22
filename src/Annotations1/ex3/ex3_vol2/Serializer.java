package Annotations1.ex3.ex3_vol2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class Serializer {
    public static String serialize(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields) {
            if (!f.isAnnotationPresent(Annotations1.ex3.Save.class))
                continue;
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);
            sb.append(f.getName() + "=");

            if(f.getType() == int.class) {
                sb.append(f.getInt(o));
            } else if (f.getType() == String.class) {
                sb.append((String)f.get(o));
            } else if (f.getType() == long.class) {
                sb.append(f.getLong(o));
            } else if (f.getType() == char.class) {
                sb.append(f.getChar(o));
            } else if (f.getType() == double.class) {
                sb.append(f.get(o));
            }
            sb.append(";");
        }

        return sb.toString();
    }

    public static <T> T deserialize (String s, Class<T> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T res = (T)cls.newInstance();
        String[] pairs = s.split(";");
        for (String p : pairs) {
            String[] pr = p.split("=");
            if (pr.length != 2) {
                throw new InvalidParameterException(s);
            }

            String name = pr[0];
            String value = pr[1];

            Field f = cls.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);
            if (f.getType() == int.class) {
                f.setInt(res, Integer.parseInt(value));
            } else if (f.getType() == String.class) {
                f.set(res, value);
            } else if (f.getType() == char.class) {
                f.setChar(res, value.charAt(0));
            } else if (f.getType() == long.class) {
                f.setLong(res, Long.parseLong(value));
            } else if (f.getType() == double.class) {
                f.setDouble(res, Double.parseDouble(value));
            }
        }
        return res;
    }
}
