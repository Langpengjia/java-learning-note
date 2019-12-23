package pers.lpj;

/**
 * @classname: MyTest
 * @description:
 * @author: Desire
 * @date: 2019-12-20 14:55
 */
public class MyTest4 {


    public static void main(String[] args) {

        /**
         * 类的初始化只有一次，除非该类被卸载；
         */
        MyParent4 myParent4 = new MyParent4();


        MyParent4 myParent42 = new MyParent4();
    }
}


class MyParent4 {
    static {
        System.out.println("myarent block4 !");
    }

}