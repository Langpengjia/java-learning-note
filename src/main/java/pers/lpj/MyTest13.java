package pers.lpj;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @classname: MyTest13
 * @description:
 * @author: Desire
 * @date: 2019-12-24 14:41
 */
public class MyTest13 {


    public static void main(String[] args) {
        //获取当前类的类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        Enumeration<URL> resources = null;
        try {
            resources = contextClassLoader.getResources("pers\\lpj\\C.class");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (resources.hasMoreElements()) {

            URL url = resources.nextElement();
            System.out.println(url);

        }

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);


        //AppClassLoader
        Class clazz1 = MyTest14.class;
        System.out.println(clazz1.getClassLoader());

        //BootstrapClassLoader
        Class clazz2 = String.class;//rt.jar
        System.out.println(clazz2.getClassLoader());


        //详细请查阅ClassLoader注释
        Class clazz3 =  MyTest14[].class;//和数组内元素的类加载器相同<MyTest14的类加载器为AppClassLoader>
        System.out.println(clazz3.getClassLoader());

        Class clazz4 =  String[].class;//和数组内元素的类加载器相同<MyTest14的类加载器为BootstrapClassLoader   return null>
        System.out.println(clazz4.getClassLoader());

        //基本类型数组变量的类不是由类加载器加载的
        Class clazz5 =  int[].class;
        System.out.println(clazz5.getClassLoader());


        Comparable[] comparables = new Comparable[5];
        Class<? extends Comparable[]> clazz6 = comparables.getClass();
        System.out.println(clazz6.getClassLoader());

    }
}
