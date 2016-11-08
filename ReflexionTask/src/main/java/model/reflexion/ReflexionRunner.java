package model.reflexion;

import model.NoteBook;

import java.lang.reflect.Method;

/**
 * Created by andri on 11/8/2016.
 */
public class ReflexionRunner {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("model.NoteBook");
            Object instance = (NoteBook) clazz.newInstance();

            ReflexionInfo info = new ReflexionInfo();
            for (Method method : clazz.getMethods()) {
                System.out.print(info.getModifiers(method));
                System.out.print(method.getName());
                System.out.println(info.getParameters(method));
                if (method.getName().startsWith("get")) {
                    System.out.println(method.invoke(instance));
                } else if (method.isAnnotationPresent(Override.class)) {
                    System.out.println(method.invoke(instance));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
