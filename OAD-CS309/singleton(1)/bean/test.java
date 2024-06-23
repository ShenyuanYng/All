package singleton.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        Staff s1 = new Staff();
        System.out.println(s1.getClass().getName());
        String classname =  properties.getProperty("staff");
        Class a = Class.forName(classname);
        Staff s = (Staff) a.getConstructor().newInstance();
        System.out.println(s);
    }
}
