package pers.lpj;

/**
 * @classname: MyTest6
 * @description:
 * @author: Desire
 * @date: 2019-12-23 14:05
 */
public class MyTest6 {

    public static void main(String[] args) {

        /**
         *
         * 当 Singletion 出于准备阶段时,要为成员变量分配空间和赋予默认值
         * 此时： c1=0 c2=0  singletion = null
         * 当调用getSingletion() 时，Singletion会进入初始化阶段
         * c1 = 0,c2 =0  singletion new 调用私有构造  c1 = 1 ,c2 = 1;
         * 初始化 c2 = 0
         * 所以 Singletion.c1 = 1
         * Singletion.c2 = 0
         *
         */
        Singletion singletion = Singletion.getSingletion();
        System.out.println(Singletion.c1);
        System.out.println(Singletion.c2);

    }

}

/**
 * 初始化阶段是按照 程序代码 <顺序> 去完成初始化
 */
class Singletion {

    public static int c1;

    private static Singletion singletion = new Singletion();

    private Singletion() {
        c1++;
        c2++;
        System.out.println("初始化阶段c1==" + c1);
        System.out.println("初始化阶段c2==" + c2);
    }

    /***
     * 此处注意准备阶段
     * 和初始化阶段的区别
     */
    public static int c2 = 0;


    public static Singletion getSingletion() {
        return singletion;
    }
}

