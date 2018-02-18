package horstman.reflection_test;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) {
        String name;

        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя класса (например java.util.Date): " );
            name = in.next();
        }

        try {
            // get object Class
            Class cls = Class.forName(name);
            Class superClass = cls.getSuperclass();
            String modifiers = Modifier.toString(cls.getModifiers());

            if (modifiers.length() > 0) { System.out.print(modifiers + " "); }

            System.out.println("class " + name);

            if (superClass != null && superClass != Object.class) {
                System.out.println(" extends " + superClass.getName());
            }

            System.out.print("{\n");
            printConstructors(cls);
            printMethods(cls);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printMethods(Class cls) {
        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            String name = method.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(method.getModifiers());
            if (methods.length > 0) { System.out.print(modifiers + " "); }

        }
    }

    public static void printConstructors(Class cls) {
        Constructor[] constructors = cls.getConstructors();

        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) { System.out.print(modifiers + " "); }
            System.out.print(name + "(");

            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) { System.out.print(", "); }

                System.out.print(paramTypes[i].getName());
            }

            System.out.println(");");
        }
    }
}
