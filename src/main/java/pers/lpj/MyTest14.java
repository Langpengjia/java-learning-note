package pers.lpj;

/**
 * @classname: MyTest14
 * @description:
 * @author: Desire
 * @date: 2019-12-24 17:22
 */
public class MyTest14 extends ClassLoader {

    private String classLoaderName;

    private final String suffex = ".class";

    public MyTest14(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest14(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }
}
