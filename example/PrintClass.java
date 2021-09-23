package example;

import java.sql.Array;
import java.util.ArrayList;

public class PrintClass {
    public static void main(String[] ags)  {
        System.out.println("Classloader of this class:" + PrintClass.class.getClassLoader());
        System.out.println("Classloader of Array:" + Array.class.getClassLoader());
        System.out.println("Classloader of ArrayList:" + ArrayList.class.getClassLoader());
    }
}